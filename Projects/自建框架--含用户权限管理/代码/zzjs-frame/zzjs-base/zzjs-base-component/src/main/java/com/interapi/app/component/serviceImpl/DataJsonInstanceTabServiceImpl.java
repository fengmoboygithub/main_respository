package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.DataJsonInstanceTabService;
import com.interapi.app.component.dao.DataJsonInstanceTabMapper;
import com.interapi.app.component.model.DataJsonInstanceTab;
import com.interapi.app.component.model.DataJsonInstanceTabExample;

@Service
public class DataJsonInstanceTabServiceImpl extends BaseServiceImpl<DataJsonInstanceTab, DataJsonInstanceTabExample> implements DataJsonInstanceTabService<DataJsonInstanceTab, DataJsonInstanceTabExample>{

    @Autowired
    private DataJsonInstanceTabMapper mapper;
	
	public IBaseDao<DataJsonInstanceTab, DataJsonInstanceTabExample> getMapper(){
		return mapper;
	}
}