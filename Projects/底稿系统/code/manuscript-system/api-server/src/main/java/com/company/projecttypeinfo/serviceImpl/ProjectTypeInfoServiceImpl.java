package com.company.projecttypeinfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.projecttypeinfo.service.ProjectTypeInfoService;
import com.company.projecttypeinfo.dao.ProjectTypeInfoMapper;
import com.company.projecttypeinfo.model.ProjectTypeInfo;
import com.company.projecttypeinfo.model.ProjectTypeInfoExample;

@Service
public class ProjectTypeInfoServiceImpl extends BaseServiceImpl<ProjectTypeInfo, ProjectTypeInfoExample> implements ProjectTypeInfoService<ProjectTypeInfo, ProjectTypeInfoExample>{

    @Autowired
    private ProjectTypeInfoMapper mapper;
	
	public IBaseDao<ProjectTypeInfo, ProjectTypeInfoExample> getMapper(){
		return mapper;
	}
}