package com.company.manuscriptinfo.serviceImpl;

import com.company.base.exception.BaseException;
import com.company.docuserremarksmap.dao.DocUserRemarksMapMapper;
import com.company.docuserremarksmap.model.DocUserRemarksMap;
import com.company.docuserremarksmap.model.DocUserRemarksMapExample;
import com.company.enums.ManuscriptInfoEsMode;
import com.company.enums.ManuscriptInfoEsVersion;
import com.company.enums.ManuscriptInfoStatus;
import com.company.es.model.ManuscriptInfoForEs;
import com.company.es.repository.ManuscriptInfoForEsRepository;
import com.company.projectdirectory.dao.ProjectDirectoryMapper;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.model.ProjectDirectoryExample;
import com.company.projectdirectory.model.ProjectDirectoryKey;
import com.company.projectdirectory.service.ProjectDirectoryService;
import com.company.projectinfo.dao.ProjectInfoMapper;
import com.company.projectinfo.model.ProjectInfo;
import com.company.utils.DateUtils;
import com.company.utils.TikaUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.manuscriptinfo.service.ManuscriptInfoService;
import com.company.manuscriptinfo.dao.ManuscriptInfoMapper;
import com.company.manuscriptinfo.model.ManuscriptInfo;
import com.company.manuscriptinfo.model.ManuscriptInfoExample;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.company.manuscriptinfo.model.ManuscriptInfoExample.Criteria;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ManuscriptInfoServiceImpl extends BaseServiceImpl<ManuscriptInfo, ManuscriptInfoExample> implements ManuscriptInfoService<ManuscriptInfo, ManuscriptInfoExample>{

    @Autowired
    private ManuscriptInfoMapper mapper;

	/**
	 * 项目目录信息mapper
	 */
	@Autowired
	private ProjectDirectoryMapper projectDirectoryMapper;

	@Autowired
	private ProjectDirectoryService<ProjectDirectory, ProjectDirectoryExample> projectDirectoryService;

	/**
	 * 项目信息mapper
	 */
	@Autowired
	private ProjectInfoMapper projectInfoMapper;

	/**
	 * 备注信息关系mapper
	 */
	@Autowired
	private DocUserRemarksMapMapper docUserRemarksMapMapper;

	/**
	 * 存储在es里的持久化操作类
	 */
	@Autowired
    private ManuscriptInfoForEsRepository manuscriptInfoForEsRepository;
	public IBaseDao<ManuscriptInfo, ManuscriptInfoExample> getMapper(){
		return mapper;
	}

	/**
	 * 上传资源目录
	 */
	@Value("${web.upload-file-path}")
	private String fileUploadPath;

	/**
	 * 	根据主键查询单个记录
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	public ManuscriptInfo getByMe(String id, String userId) throws BaseException {
		ManuscriptInfo model = getMapper().selectByPrimaryKey(id);
		if (model == null) {
			logger.error("获取实体数据错误，查询参数：{}", id);
			throw new BaseException("获取实体数据错误");
		}
		DocUserRemarksMapExample example = new DocUserRemarksMapExample();
		DocUserRemarksMapExample.Criteria criteria = example.createCriteria();
		criteria.andDocidEqualTo(id);
		criteria.andUseridEqualTo(userId);
		List<DocUserRemarksMap> list = docUserRemarksMapMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			DocUserRemarksMap drm = list.get(0);
			model.setStatus(drm.getStatus());
			model.setRemarks(drm.getRemarks());
			model.setUserid(userId);
		} else {
			model.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
			model.setRemarks("");
			model.setUserid("");
		}
		return model;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateByMe(ManuscriptInfo model) throws BaseException {
		int success = getMapper().updateByPrimaryKeySelective(model);
		if (success <= 0) {
			logger.error("更新实体错误{}",  model.toString());
			throw new BaseException("更新实体错误");
		}
		String id = model.getId();
		String userId = model.getUserid();
		String status = model.getStatus();
		String remarks = model.getRemarks();
		DocUserRemarksMap drm = new DocUserRemarksMap();
		drm.setDocid(id);
		drm.setUserid(userId);
		if (!StringUtils.isEmpty(status)) {
			drm.setStatus(status);
		}
		if (!StringUtils.isEmpty(remarks)) {
			drm.setRemarks(remarks);
		}
		DocUserRemarksMapExample example = new DocUserRemarksMapExample();
		DocUserRemarksMapExample.Criteria criteria = example.createCriteria();
		criteria.andDocidEqualTo(id);
		criteria.andUseridEqualTo(userId);
		List<DocUserRemarksMap> list = docUserRemarksMapMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			//有则更新备注信息关系记录
			DocUserRemarksMap drm1 = list.get(0);
			drm.setId(drm1.getId());
			docUserRemarksMapMapper.updateByPrimaryKeySelective(drm);
		} else {
			//无则新增备注信息关系记录
			drm.setId(null);
			docUserRemarksMapMapper.insertSelective(drm);
		}
		return;
	}

	/**
	 * 保存底稿信息
	 * @param info
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveForMe(ManuscriptInfo info) throws BaseException{
		ManuscriptInfoExample example = new ManuscriptInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andDirectoryidEqualTo(info.getDirectoryid());
		criteria.andProjectidEqualTo(info.getProjectid());
		criteria.andDocnameEqualTo(info.getDocname());
		int updateSuccess = this.getMapper().updateByExampleSelective(info, example);
		if(updateSuccess <= 0){
			int success = this.getMapper().insertSelective(info);
			if (success <= 0) {
				this.logger.error("保存底稿信息错误{}", info.toString());
				throw new BaseException("保存底稿信息错误");
			}
			//保存底稿信息检索
			this.saveForManuscriptInfoForEsRepository(info, ManuscriptInfoEsMode.ADD, ManuscriptInfoEsVersion.CURRENT);
		} else {
			List<ManuscriptInfo> list = this.getMapper().selectByExample(example);
			if(list != null && list.size() > 0){
				info = list.get(0);
			}
			//更新底稿信息检索
			this.saveForManuscriptInfoForEsRepository(info, ManuscriptInfoEsMode.UPDATE, ManuscriptInfoEsVersion.CURRENT);
		}
		String projectId = info.getProjectid();
		String directoryId = info.getDirectoryid();
		logger.info("saveForMe--projectId:{},directoryId:{}", projectId, directoryId);
		//向上遍历目录 计算目录hash值进行更改
		projectDirectoryService.updateProjectDirectoryHashForDeep(projectId, directoryId);
	}

	/**
	 * 保存底稿信息检索
	 * @param info
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveForManuscriptInfoForEsRepository(ManuscriptInfo info, ManuscriptInfoEsMode mode, ManuscriptInfoEsVersion version) throws BaseException{
		ManuscriptInfoForEs record = new ManuscriptInfoForEs();
		String hashName = info.getHashname();
		record.setId(info.getId());
		record.setDocname(info.getDocname());
		record.setHashname(hashName);
		String haxPath = fileUploadPath + hashName;
		//调用pdf抽取工具 实现将文件中的文本内容抽取
		record.setKeyword(TikaUtils.parseTxtByFile(haxPath));
		record.setUploadtime(DateUtils.dataTimeToString(info.getUploaddate()));
		record.setUserid(info.getUserid());
		record.setOrderno(info.getOrderno());
		record.setIsapp(info.getIsapp());
		record.setProcessnode(info.getProcessnode());
		record.setNewversionflag(version.getCode());
//		record.setFiletype(info.getFiletype());

		String projectId = info.getProjectid();
		if (!StringUtils.isEmpty(projectId)) {
			ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectId);
			record.setProjectid(projectId);
			record.setProjectname(projectInfo.getProjectname());
			record.setProjectstage(projectInfo.getStage());
			record.setProjecttype(projectInfo.getProjecttype());
			record.setProjectstarttime(DateUtils.dataToString(projectInfo.getBegindate()));
			record.setProjectendtime(DateUtils.dataToString(projectInfo.getEnddate()));
		}
		String directoryId = info.getDirectoryid();
		if (!StringUtils.isEmpty(projectId) && !StringUtils.isEmpty(directoryId)) {
			ProjectDirectoryKey key = new ProjectDirectoryKey();
			key.setProjectid(projectId);
			key.setDirectoryid(directoryId);
			ProjectDirectory projectDirectory = projectDirectoryMapper.selectByPrimaryKey(key);
			record.setDirectoryid(directoryId);
			record.setDirectorysname(projectDirectory.getSname());
			record.setDirectoryfullname(projectDirectory.getFullname());
		}
		try{
			if(mode.equals(ManuscriptInfoEsMode.ADD)){
				manuscriptInfoForEsRepository.save(record);
			} else if(mode.equals(ManuscriptInfoEsMode.UPDATE)){
				boolean falg = manuscriptInfoForEsRepository.existsById(info.getId());
				if(falg){
					manuscriptInfoForEsRepository.deleteById(info.getId());
				}
				manuscriptInfoForEsRepository.save(record);
			} else {
				throw new BaseException("传入的mode参数没有匹配");
			}
		} catch (Exception e){
			throw new BaseException("保存底稿信息检索失败。。。");
		}
	}

	/**
	 * 删除底稿信息
	 * @param id
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	@Override
	public void delForMe(String id) throws BaseException {
		//删除底稿信息
		int success = getMapper().deleteByPrimaryKey(id);
		if (success <= 0) {
			logger.error("根据主键删除底稿信息错误{}", id);
			throw new RuntimeException("删除底稿信息错误");
		}
		//删除底稿信息 在ES里的
		manuscriptInfoForEsRepository.deleteById(id);
		return;
	}
}