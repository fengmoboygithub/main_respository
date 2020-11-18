package com.company.one.syslogging.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.syslogging.service.SysLoggingTabService;
import com.company.one.syslogging.dao.SysLoggingTabMapper;
import com.company.one.syslogging.model.SysLoggingTab;
import com.company.one.syslogging.model.SysLoggingTabExample;

@Service
public class SysLoggingTabServiceImpl extends BaseServiceImpl<SysLoggingTab, SysLoggingTabExample> implements SysLoggingTabService<SysLoggingTab, SysLoggingTabExample>{

    @Autowired
    private SysLoggingTabMapper mapper;
	
	public IBaseDao<SysLoggingTab, SysLoggingTabExample> getMapper(){
		return mapper;
	}
}