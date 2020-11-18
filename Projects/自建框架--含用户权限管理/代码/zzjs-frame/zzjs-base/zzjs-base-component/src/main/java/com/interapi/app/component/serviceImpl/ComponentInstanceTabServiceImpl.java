package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.ComponentInstanceTabService;
import com.interapi.app.component.dao.ComponentInstanceTabMapper;
import com.interapi.app.component.model.ComponentInstanceTab;
import com.interapi.app.component.model.ComponentInstanceTabExample;

@Service
public class ComponentInstanceTabServiceImpl extends BaseServiceImpl<ComponentInstanceTab, ComponentInstanceTabExample> implements ComponentInstanceTabService<ComponentInstanceTab, ComponentInstanceTabExample>{

    @Autowired
    private ComponentInstanceTabMapper mapper;
	
	public IBaseDao<ComponentInstanceTab, ComponentInstanceTabExample> getMapper(){
		return mapper;
	}
}