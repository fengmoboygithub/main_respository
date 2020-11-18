package com.company.loginfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.loginfo.service.LogInfoService;
import com.company.loginfo.dao.LogInfoMapper;
import com.company.loginfo.model.LogInfo;
import com.company.loginfo.model.LogInfoExample;

@Service
public class LogInfoServiceImpl extends BaseServiceImpl<LogInfo, LogInfoExample> implements LogInfoService<LogInfo, LogInfoExample>{

    @Autowired
    private LogInfoMapper mapper;
	
	public IBaseDao<LogInfo, LogInfoExample> getMapper(){
		return mapper;
	}
}