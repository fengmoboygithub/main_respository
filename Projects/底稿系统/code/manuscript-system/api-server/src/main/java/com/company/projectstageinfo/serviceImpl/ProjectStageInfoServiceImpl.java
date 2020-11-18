package com.company.projectstageinfo.serviceImpl;

import com.company.base.exception.BaseException;
import com.company.basedirectory.dao.BaseDirectoryMapper;
import com.company.basedirectory.model.BaseDirectoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.projectstageinfo.service.ProjectStageInfoService;
import com.company.projectstageinfo.dao.ProjectStageInfoMapper;
import com.company.projectstageinfo.model.ProjectStageInfo;
import com.company.projectstageinfo.model.ProjectStageInfoExample;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ucar.units.Base;

@Service
public class ProjectStageInfoServiceImpl extends BaseServiceImpl<ProjectStageInfo, ProjectStageInfoExample> implements ProjectStageInfoService<ProjectStageInfo, ProjectStageInfoExample>{

    @Autowired
    private ProjectStageInfoMapper mapper;

	@Autowired
	private BaseDirectoryMapper baseDirectoryMapper;
	
	public IBaseDao<ProjectStageInfo, ProjectStageInfoExample> getMapper(){
		return mapper;
	}

	/**
	 * 	删除该阶段及基础目录数据
	 * @param id
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void deleteForMe(String id) throws BaseException {
		ProjectStageInfo stageInfo = mapper.selectByPrimaryKey(id);
		if(stageInfo == null){
			logger.error("根据主键未查询到阶段信息{}", id);
			throw new BaseException("根据主键未查询到阶段信息");
		}
		int success = getMapper().deleteByPrimaryKey(id);
		if (success <= 0) {
			logger.error("根据主键删除阶段信息错误{}", id);
			throw new RuntimeException("删除阶段信息错误");
		}
		BaseDirectoryExample example = new BaseDirectoryExample();
		BaseDirectoryExample.Criteria criteria =  example.createCriteria();
		criteria.andProjecttypeEqualTo(stageInfo.getProjecttype());
		criteria.andProjectstageEqualTo(stageInfo.getProjectstage());
		baseDirectoryMapper.deleteByExample(example);
	}
}