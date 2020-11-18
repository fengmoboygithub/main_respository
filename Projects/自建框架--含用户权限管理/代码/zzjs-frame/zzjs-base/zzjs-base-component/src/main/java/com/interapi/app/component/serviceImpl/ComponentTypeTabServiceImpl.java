package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.ComponentTypeTabService;
import com.interapi.app.component.dao.ComponentTypeTabMapper;
import com.interapi.app.component.model.ComponentTypeTab;
import com.interapi.app.component.model.ComponentTypeTabExample;

@Service
public class ComponentTypeTabServiceImpl extends BaseServiceImpl<ComponentTypeTab, ComponentTypeTabExample> implements ComponentTypeTabService<ComponentTypeTab, ComponentTypeTabExample>{

    @Autowired
    private ComponentTypeTabMapper mapper;
	
	public IBaseDao<ComponentTypeTab, ComponentTypeTabExample> getMapper(){
		return mapper;
	}
}