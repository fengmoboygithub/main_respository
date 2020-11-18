package com.company.directoryopinion.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.constant.BaseConstant;
import com.company.directoryopinion.dao.DirectoryOpinionMapper;
import com.company.directoryopinion.model.DirectoryOpinion;
import com.company.directoryopinion.model.DirectoryOpinionExample;
import com.company.directoryopinion.service.DirectoryOpinionService;
import com.company.operateinfo.dao.OperateInfoMapper;
import com.company.operateinfo.model.OperateInfo;
import com.company.processnodeinfo.dao.ProcessNodeInfoMapper;
import com.company.projectinfo.dao.ProjectInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DirectoryOpinionServiceImpl extends BaseServiceImpl<DirectoryOpinion, DirectoryOpinionExample> implements DirectoryOpinionService<DirectoryOpinion, DirectoryOpinionExample>{

    @Autowired
    private DirectoryOpinionMapper mapper;
	
	public IBaseDao<DirectoryOpinion, DirectoryOpinionExample> getMapper(){
		return mapper;
	}

	@Autowired
	private ProcessNodeInfoMapper processNodeInfoMapper;

	@Autowired
	private OperateInfoMapper operateInfoMapper;

	@Autowired
	private ProjectInfoMapper projectInfoMapper;


	/**
	 * 保存意见信息
	 * @param opinion
	 * @param projectId
	 * @param directoryId
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveOpinion(String opinion, String projectId, String directoryId, String userName, String userId, String hashname, String opinionType) throws BaseException {
		try {
			DirectoryOpinion directoryOpinion = new DirectoryOpinion();
			directoryOpinion.setId(UUID.randomUUID().toString().replace("-",""));
			directoryOpinion.setProjectid(projectId);
			directoryOpinion.setDirectoryid(directoryId);
			directoryOpinion.setContents(opinion);
			directoryOpinion.setVersionhash(hashname);
			directoryOpinion.setCreateTime(new Date());
			directoryOpinion.setCreateUser(userName);
			directoryOpinion.setIsDelete(BaseConstant.DEL_FLAG_NO);
			directoryOpinion.setUpdateTime(new Date());
			directoryOpinion.setOpinionType(opinionType);
			int success = mapper.insertSelective(directoryOpinion);
			if (success <= 0) {
				logger.error("保存意见信息实体错误{}",  directoryOpinion.toString());
				throw new BaseException("保存意见信息实体错误");
			}
			//保存操作信息表
			OperateInfo operateInfo = new OperateInfo();
			operateInfo.setId(UUID.randomUUID().toString().replace("-",""));
			operateInfo.setOpinionid(directoryOpinion.getId());
			operateInfo.setOpertype("1");
			operateInfo.setCreateTime(new Date());
			operateInfo.setCreateUser(userId);
			operateInfo.setIsDelete(BaseConstant.DEL_FLAG_NO);
			operateInfoMapper.insertSelective(operateInfo);
		}catch (Exception e){
			logger.info("保存意见信息信息错误");
			throw new BaseException("保存意见信息信息错误");
		}
	}

	/**
	 * 保存全部意见信息
	 * @param projectid
	 * @param treedag
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveAllOpinion(String projectid, String processnode, String operId, String userName, String userId,  String treedag, String opinionType) throws BaseException {
		try {
			JSONArray rootArray = JSONArray.parseArray(treedag);
			JSONObject jsonObject = null;
			for (int i = 0; i < rootArray.size(); i++) {
				jsonObject = rootArray.getJSONObject(i);
				String id = jsonObject.get("id").toString();
				String opinion = jsonObject.get("opinion").toString();
				String type = jsonObject.get("type").toString();
				String hashname = "";
				if (jsonObject.get("hashname") != null) {
					hashname = jsonObject.get("hashname").toString();
				}

				String targetProcessNode = "";
				//获取目标流程节点 = 工作流下一节点（输入 用户名、当前流程节点、操作）
				//			ProcessNodeInfo processNodeInfo = new ProcessNodeInfo();
				//			processNodeInfo.setOpertype(operId);
				//			processNodeInfo.setProcessnode(processnode);
				//			ProcessNodeInfo targetProcessNodeInfo = processNodeInfoMapper.getNextProcessNode(processNodeInfo);

				//			ProjectInfo projectinfo = projectInfoMapper.selectByPrimaryKey(projectid);
				//			Map<String,Object> parmaMap = new HashMap<String,Object>();
				//			parmaMap.put("startprocessnode",processnode);
				//			parmaMap.put("operid",operId);
				//			parmaMap.put("projectstage",projectinfo.getStage());
				//			parmaMap.put("projecttype",projectinfo.getProjecttype());
				//			ProcessNodeInfo targetProcessNodeInfo = processNodeInfoMapper.getNextProcessNode(parmaMap);
				//			if(null == targetProcessNodeInfo){
				//				throw new BaseException("目标节点不能为空！");
				//			}else{
				//				targetProcessNode = targetProcessNodeInfo.getProcessnode();
				//			}
				if ("dir".equals(type)) {
					//需要判断是否存在同版本的目录意见，通过项目id，目录id，版本hash，起点流程节点和终点流程节点判断，如果存在，则更新，如果不存在，则插入
					DirectoryOpinionExample directoryOpinionExample = new DirectoryOpinionExample();
					DirectoryOpinionExample.Criteria criteria = directoryOpinionExample.createCriteria();
					criteria.andProjectidEqualTo(projectid);
					criteria.andDirectoryidEqualTo(id);
					if (!StringUtils.isEmpty(hashname)) {
						criteria.andVersionhashEqualTo(hashname);
					}
					//				criteria.andStartprocessnodeEqualTo(processnode);
					//				criteria.andEndprocessnodeEqualTo(targetProcessNode);
					List<DirectoryOpinion> list = new ArrayList<>();
					list = mapper.selectByExample(directoryOpinionExample);
					if (list != null && list.size() > 0) {
						DirectoryOpinion directoryOpinion = new DirectoryOpinion();
						directoryOpinion.setId(list.get(0).getId());
						directoryOpinion.setUpdateTime(new Date());
						directoryOpinion.setContents(opinion);
						directoryOpinion.setCreateUser(userName);
						directoryOpinion.setOpinionType(opinionType);
						mapper.updateByPrimaryKeySelective(directoryOpinion);
						//保存操作信息表
						OperateInfo operateInfo = new OperateInfo();
						operateInfo.setId(UUID.randomUUID().toString().replace("-", ""));
						operateInfo.setOpinionid(directoryOpinion.getId());
						operateInfo.setOpertype("1");
						operateInfo.setCreateTime(new Date());
						operateInfo.setCreateUser(userId);
						operateInfo.setIsDelete(BaseConstant.DEL_FLAG_NO);
						operateInfoMapper.insertSelective(operateInfo);
					} else {
						DirectoryOpinion directoryOpinion = new DirectoryOpinion();
						directoryOpinion.setId(UUID.randomUUID().toString().replace("-", ""));
						directoryOpinion.setProjectid(projectid);
						directoryOpinion.setDirectoryid(id);
						directoryOpinion.setContents(opinion);
						directoryOpinion.setCreateTime(new Date());
						directoryOpinion.setCreateUser(userName);
						directoryOpinion.setIsDelete(BaseConstant.DEL_FLAG_NO);
						directoryOpinion.setUpdateTime(new Date());
						directoryOpinion.setOpinionType(opinionType);
						mapper.insertSelective(directoryOpinion);
						//保存操作信息表
						OperateInfo operateInfo = new OperateInfo();
						operateInfo.setId(UUID.randomUUID().toString().replace("-", ""));
						operateInfo.setOpinionid(directoryOpinion.getId());
						operateInfo.setOpertype("1");
						operateInfo.setCreateTime(new Date());
						operateInfo.setCreateUser(userId);
						operateInfo.setIsDelete(BaseConstant.DEL_FLAG_NO);
						operateInfoMapper.insertSelective(operateInfo);
					}
				} else if ("file".equals(type)) {

				}
			}
		}catch (Exception e){
			logger.info("保存全部意见信息错误");
			throw new BaseException("保存全部意见信息错误");
		}
	}

	@Override
	public DirectoryOpinion getDirectoryOpinion(DirectoryOpinion directoryOpinion) {
		return mapper.getDirectoryOpinion(directoryOpinion);
	}
}