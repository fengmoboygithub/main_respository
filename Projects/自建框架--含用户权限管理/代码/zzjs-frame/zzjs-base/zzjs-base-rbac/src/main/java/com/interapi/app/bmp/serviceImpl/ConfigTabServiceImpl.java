package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.ConfigTabService;
import com.interapi.app.bmp.dao.ConfigTabMapper;
import com.interapi.app.bmp.model.ConfigTab;
import com.interapi.app.bmp.model.ConfigTabExample;

@Service
public class ConfigTabServiceImpl extends BaseServiceImpl<ConfigTab, ConfigTabExample> implements ConfigTabService<ConfigTab, ConfigTabExample>{

    @Autowired
    private ConfigTabMapper mapper;
	
	public IBaseDao<ConfigTab, ConfigTabExample> getMapper(){
		return mapper;
	}
}