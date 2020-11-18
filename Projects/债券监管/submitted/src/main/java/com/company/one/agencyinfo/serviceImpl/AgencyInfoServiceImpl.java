package com.company.one.agencyinfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.agencyinfo.dao.AgencyInfoMapper;
import com.company.one.agencyinfo.model.AgencyInfo;
import com.company.one.agencyinfo.model.AgencyInfoExample;
import com.company.one.agencyinfo.service.AgencyInfoService;

@Service
public class AgencyInfoServiceImpl extends BaseServiceImpl<AgencyInfo, AgencyInfoExample> implements AgencyInfoService<AgencyInfo, AgencyInfoExample>{

    @Autowired
    private AgencyInfoMapper mapper;
	
	public IBaseDao<AgencyInfo, AgencyInfoExample> getMapper(){
		return mapper;
	}
}