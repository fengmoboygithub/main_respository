package com.company.projectinfo.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.basedirectory.dao.BaseDirectoryMapper;
import com.company.basedirectory.model.BaseDirectory;
import com.company.basedirectory.model.BaseDirectoryExample;
import com.company.directoryversion.service.DirectoryVersionService;
import com.company.enums.DataPermission;
import com.company.enums.ManuscriptInfoApply;
import com.company.enums.RequestParameterType;
import com.company.processnodeinfo.dao.ProcessNodeInfoMapper;
import com.company.processnodeinfo.model.ProcessNodeInfo;
import com.company.projectdirectory.dao.ProjectDirectoryMapper;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectinfo.dao.ProjectInfoMapper;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.model.ProjectInfoExample;
import com.company.projectinfo.service.ProjectInfoService;
import com.company.projectinfo.view.DealtInfo;
import com.company.projectstageinfo.dao.ProjectStageInfoMapper;
import com.company.projectstageinfo.model.ProjectStageInfo;
import com.company.projectstageinfo.model.ProjectStageInfoExample;
import com.company.utils.HttpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Service
public class ProjectInfoServiceImpl extends BaseServiceImpl<ProjectInfo, ProjectInfoExample> implements ProjectInfoService<ProjectInfo, ProjectInfoExample>{

	public static Logger logger = LoggerFactory.getLogger(ProjectInfoServiceImpl.class);

    @Autowired
    private ProjectInfoMapper mapper;
	@Autowired
    private ProjectStageInfoMapper projectStageInfoMapper;
	@Autowired
	private BaseDirectoryMapper baseDirectoryMapper;
	@Autowired
	private ProjectDirectoryMapper projectDirectoryMapper;
	@Autowired
	private ProcessNodeInfoMapper processNodeInfoMapper;

	@Autowired
	private DirectoryVersionService directoryVersionService;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 统一账户管理外部调用url
	 */
	@Value("${web.user-system-url}")
	private String userSystemUrl;

	public IBaseDao<ProjectInfo, ProjectInfoExample> getMapper(){
		return mapper;
	}

	/**
	 * 保存项目信息及项目目录信息
	 * @param info
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveForMe(ProjectInfo info) throws BaseException {
		int success = this.getMapper().insertSelective(info);

		if (success <= 0) {
			this.logger.error("保存项目信息错误{}", info.toString());
			throw new BaseException("保存项目信息错误");
		}

		/*根据项目类型并按项目阶段值正序查询项目阶段信息*/
		ProjectStageInfoExample example = new ProjectStageInfoExample();
		example.setOrderByClause("CAST(PROJECTSTAGE as SIGNED) ASC");
		com.company.projectstageinfo.model.ProjectStageInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(info.getProjecttype());
		List<ProjectStageInfo> psList = projectStageInfoMapper.selectByExample(example);
		int count = 0;
		for(ProjectStageInfo projectStageInfo : psList){
			if(count == 0){
				//新增项目项目操作-对最小“项目阶段”的项目，按“基础目录表”的“是否适用”填写
				this.insertProjectDirectoryMin(projectStageInfo, info);
			} else {
				//新增项目项目操作-对其他“项目阶段”项目，“是否适用”写为不适用
				this.insertProjectDirectoryOther(projectStageInfo, info);
			}
			count++;
		}
		//新建项目时添加目录版本表
		directoryVersionService.initDirectoryVersion(info);

		try {
			//新增数据项
			this.saveDataItem(info);
		} catch (BaseException e) {
			logger.error("新增数据项错误信息：", e.getLocalizedMessage());
		}
		if (!StringUtils.isEmpty(info.getUserId()) && !StringUtils.isEmpty(info.getRoleList())) {
			try {
				//新增数据权限  用户、角色和数据项 并将redis中更新
				this.saveDataRole(info);
			} catch (BaseException e) {
				logger.error("新增数据权限错误信息：", e.getLocalizedMessage());
			}
		}
	}

	/**
	 * 新增数据项信息
	 * @param info
	 * @throws BaseException
	 */
	public void saveDataItem(ProjectInfo info) throws BaseException {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("uuDid", info.getId());
			map.put("dataName", info.getProjectname());
			map.put("dataDescribe", info.getProjectname()+"描述");
			map.put("levelSort", "1");
			map.put("sameLevelSort", "1");
			Map<String, Object> loginfo = null;
			loginfo = HttpUtil.HttpRequestutil(map, userSystemUrl+"/api/system/dataitem/insert", RequestMethod.POST, RequestParameterType.QUERY);
			if ("0".equals(loginfo.get("code").toString())) {
				logger.info(loginfo.toString());
			}
		} catch (Exception e) {
			logger.error("新增数据项信息错误信息：", e);
			throw new BaseException("新增数据项信息错误信息");
		}
	}

	/**
	 * 新增数据权限信息
	 * @param info  给项目ID 赋值 info.id
	 *              给角色列表字符串‘逗号分隔’ 赋值 info.roleList
	 *              用户列表字符串‘逗号分隔’ 赋值 info.userId
	 * @throws BaseException
	 */
	public void saveDataRole(ProjectInfo info) throws BaseException {
		try {
			String userId = info.getUserId();
			String dataIds = "";
			//获取当前用户的数据项集合
			Map<String, String> hmap = new HashMap<String, String>();
			hmap.put("userId", userId);
			Map<String, Object> authInfo;
			authInfo = HttpUtil.HttpRequestutil(hmap, userSystemUrl+"/api/system/menu/selectDatamByUserId", RequestMethod.GET, RequestParameterType.QUERY);
			ArrayList<Map<String,String>> list = (ArrayList<Map<String,String>>) authInfo.get("data");
			if(list != null && list.size() > 0){
				for(int i=0;i<list.size();i++){
					Map<String,String> objItem = list.get(i);
					String name = objItem.get("name").toString();
					String valueStr = objItem.get("value").toString();
					if(!StringUtils.isEmpty(valueStr)){
						if(DataPermission.PROJECT.getCode().equals(name)){
							dataIds += (valueStr+",");
						}
					}
				}
			}
			list = new ArrayList<Map<String, String>>();
			dataIds += info.getId();
			Map<String, String> itemMap = new HashMap<String, String>();
			itemMap.put("name",DataPermission.PROJECT.getCode());
			itemMap.put("value",dataIds);
			list.add(itemMap);
			String jsonString = JSON.toJSONString(list);
			//将缓存更新
			redisTemplate.opsForValue().set(userId, jsonString);
			//新增数据权限信息
			Map<String, String> map = new HashMap<String, String>();
			map.put("dataIds", dataIds);
			map.put("roleIds", info.getRoleList());
			map.put("userIds", userId);
			Map<String, Object> loginfo = null;
			loginfo = HttpUtil.HttpRequestutil(map, userSystemUrl+"/api/system/datam/save", RequestMethod.POST, RequestParameterType.BODY);
			if ("0".equals(loginfo.get("code").toString())) {
				logger.info(loginfo.toString());
			}
		} catch (Exception e) {
			logger.error("新增数据权限信息错误信息：", e);
			throw new BaseException("新增数据权限信息错误信息");
		}
	}
	/**
	 * 编辑项目信息及同步数据项信息
	 * @param info
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void editForMe(ProjectInfo info) throws BaseException {

		int success = getMapper().updateByPrimaryKeySelective(info);
		if (success <= 0) {
			logger.error("更新项目信息错误{}",  info.toString());
			throw new BaseException("更新项目信息错误");
		}

		try {
			//编辑数据项
			this.editDataItem(info);
		} catch (BaseException e) {
			logger.error("编辑数据项错误信息：", e.getLocalizedMessage());
		}
	}

	/**
	 * 编辑数据项信息
	 * @param info
	 * @throws BaseException
	 */
	public void editDataItem(ProjectInfo info) throws BaseException {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("uuDid", info.getId());
			map.put("dataName", info.getProjectname());
			map.put("dataDescribe", info.getProjectname()+"描述");
			map.put("levelSort", "1");
			map.put("sameLevelSort", "1");
			Map<String, Object> loginfo = null;
			loginfo = HttpUtil.HttpRequestutil(map, userSystemUrl+"/api/system/dataitem/edit", RequestMethod.POST, RequestParameterType.QUERY);
			if ("0".equals(loginfo.get("code").toString())) {
				logger.info(loginfo.toString());
			}
		} catch (Exception e) {
			logger.error("编辑数据项信息错误信息：", e);
			throw new BaseException("编辑数据项信息错误信息");
		}
	}

	/**
	 * 新增项目目录操作-对最小“项目阶段”的项目，“是否适用”写为适用
	 * @param projectStageInfo
	 */
	private void insertProjectDirectoryMin(ProjectStageInfo projectStageInfo, ProjectInfo info){
		BaseDirectoryExample example = new BaseDirectoryExample();
		BaseDirectoryExample.Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(projectStageInfo.getProjecttype());
		criteria.andProjectstageEqualTo(projectStageInfo.getProjectstage());
		List<BaseDirectory> list = baseDirectoryMapper.selectByExample(example);
		for(BaseDirectory baseDirectory : list){
			ProjectDirectory projectDirectory = new ProjectDirectory();
			projectDirectory.setDirectoryid(baseDirectory.getId());
			projectDirectory.setProjectid(info.getId());
			projectDirectory.setStage(projectStageInfo.getProjectstage());
			projectDirectory.setFullname(baseDirectory.getFullname());
			projectDirectory.setSname(baseDirectory.getSname());
			String parentId = baseDirectory.getParentid();
			if(parentId == null || parentId.trim().length()==0){
				//若父id为null则赋值项目ID
				projectDirectory.setParentid(info.getId());
			} else {
				//若父id不为null则赋值基础目录的父id
				projectDirectory.setParentid(parentId);
			}
			projectDirectory.setIsapp(ManuscriptInfoApply.YES.getCode());
			projectDirectory.setProcessnode("11");
			projectDirectory.setDirectoryno(baseDirectory.getDirentoryno());
			projectDirectory.setLevel(baseDirectory.getLevel());
			projectDirectoryMapper.insertSelectiveForMe(projectDirectory);
		}
	}

	/**
	 * 新增项目目录操作-对其他“项目阶段”项目，“是否适用”写为适用
	 * @param projectStageInfo
	 */
	private void insertProjectDirectoryOther(ProjectStageInfo projectStageInfo, ProjectInfo info){
		BaseDirectoryExample example = new BaseDirectoryExample();
		BaseDirectoryExample.Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(projectStageInfo.getProjecttype());
		criteria.andProjectstageEqualTo(projectStageInfo.getProjectstage());
		List<BaseDirectory> list = baseDirectoryMapper.selectByExample(example);
		for(BaseDirectory baseDirectory : list){
			ProjectDirectory projectDirectory = new ProjectDirectory();
			projectDirectory.setDirectoryid(baseDirectory.getId());
			projectDirectory.setProjectid(info.getId());
			projectDirectory.setStage(projectStageInfo.getProjectstage());
			projectDirectory.setFullname(baseDirectory.getFullname());
			projectDirectory.setSname(baseDirectory.getSname());
			String parentId = baseDirectory.getParentid();
			if(parentId == null || parentId.trim().length()==0){
				//若父id为null则赋值项目ID
				projectDirectory.setParentid(info.getId());
			} else {
				//若父id不为null则赋值基础目录的父id
				projectDirectory.setParentid(parentId);
			}
			projectDirectory.setIsapp(ManuscriptInfoApply.YES.getCode());
			projectDirectory.setProcessnode("11");
			projectDirectory.setDirectoryno(baseDirectory.getDirentoryno());
			projectDirectory.setLevel(baseDirectory.getLevel());
			projectDirectoryMapper.insertSelectiveForMe(projectDirectory);
		}
	}
	/**
	 * 项目阶段改变--推进
	 * @param info
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public String advance(ProjectInfo info) throws BaseException{
		//首先判断是否可以进行修改
		ProjectInfo p = mapper.selectByPrimaryKey(info.getId());
		//查询当前阶段流程的最大节点
		ProcessNodeInfo processNodeInfo = processNodeInfoMapper.selectMaxProcessnodeByStage(p);
		String maxProcessnode = processNodeInfo.getProcessnode();
		//统计当全部目录小于等于该阶段 并且 全部目录的流程节点不等于当前阶段最大流程
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("projectid",info.getId());
		map.put("stage",info.getStage());
		map.put("processnode",maxProcessnode);
		int count = projectDirectoryMapper.countIneligible(map);
		if(count!=0){
			throw new BaseException("当前不能进行变更阶段操作！");
		}

		//变更阶段时，变更当前全部目录到新开始节点，operid为4
		//首先根据操作类型和当前流程节点判断下一流程节点，如何获取流程节点
		//1.根据项目id查询当前项目阶段，通过当前项目阶段
		List<ProjectDirectory> projectDirectoryList = projectDirectoryMapper.selectAllDirectory(map);
		//2.将当前阶段最大的流程节点判断为当前流程节点，根据operid为4的流程信息查询下一流程节点
		List list = new ArrayList();
		Map<String,Object> parmaMap = new HashMap<String,Object>();
		parmaMap.put("startprocessnode",maxProcessnode);
		parmaMap.put("operid","4");
		parmaMap.put("projectstage",info.getStage());
		parmaMap.put("projecttype",p.getProjecttype());
		ProcessNodeInfo targetProcessNodeInfo = processNodeInfoMapper.getNextProcessNode(parmaMap);
		Map<String, Object> tempMap = new HashMap<String, Object>();
		if(null == targetProcessNodeInfo){
			throw new BaseException("目标节点不能为空！");
		}else{
			//更新全部项目目录的流程节点

			tempMap.put("processnode",targetProcessNodeInfo.getProcessnode());
			tempMap.put("projectStage",info.getStage());
			tempMap.put("projectid",info.getId());
			for(ProjectDirectory projectDirectory:projectDirectoryList){
				list.add(projectDirectory.getDirectoryid());
			}
			tempMap.put("list",list);
		}
		int success1 = projectDirectoryMapper.batchUpdateByPrimaryKey(tempMap);
		if (success1 <= 0) {
			logger.error("变更阶段更新所有目录流程节点实体错误{}");
			throw new BaseException("变更阶段更新所有目录流程节点实体错误");
		}

		//项目阶段改变-推进-更新项目信息
		mapper.updateProjectInfoForAdvance(info);
		//根据项目类型与阶段值获取下个阶段值
		Integer nextStageVal = mapper.selectNextStageVal(info);
		info.setStage(nextStageVal+"");
		//项目阶段改变-推进-更新项目目录信息 将下阶段的从基础目录copy过来的不适用目录改为适用目录
		//mapper.updateProjectDirectoryForAdvance(info);
		return "";
	}
	/**
	 * 项目阶段改变--回退
	 * @param info
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void back(ProjectInfo info) throws BaseException{
		//项目阶段改变-回退-更新项目信息
		mapper.updateProjectInfoForBack(info);
		//项目阶段改变-回退-更新项目目录信息
		mapper.updateProjectDirectoryForBack(info);
	}
	/**
	 * 	分页查询--待办信息
	 * @param currentPage  起始页目
	 * @param itemsPerPage 每页最多显示条目
	 * @param itemsPerPage
	 * @param example
	 * @return
	 * @throws BaseException
	 */
	public PageInfo<DealtInfo> getListByPageForDealt(int currentPage, int itemsPerPage, ProjectInfoExample example) throws BaseException {

		List<ProjectInfo> list = null;
		List<DealtInfo> dealtInfoList = null;
		PageInfo<DealtInfo> page = null;
		PageInfo<ProjectInfo> pageInfo = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage);
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = getMapper().selectByExample(example);
			pageInfo = new PageInfo<ProjectInfo>(list);
			//将项目信息转化为待办信息
			dealtInfoList = this.transform(list);
			page = new PageInfo<DealtInfo>(dealtInfoList);
			page.setTotal(pageInfo.getTotal());
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("分页查询失败");
		}
		return page;

	}

	/**
	 * 将项目信息转化为待办信息
	 * @param list
	 * @return
	 * @throws BaseException
	 */
	private List<DealtInfo> transform(List<ProjectInfo> list) throws BaseException{
		List<DealtInfo> dealtInfoList = new ArrayList<DealtInfo>();
		if( list != null && list.size() > 0 ){
			list.forEach(projectInfo -> {
				DealtInfo dealtInfo = mapper.selectByDealt(projectInfo);
				if(dealtInfo != null){
					dealtInfoList.add(dealtInfo);
				}
			});
		}
		return dealtInfoList;
	}
}