package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.ComponentTabService;
import com.interapi.app.component.dao.ComponentTabMapper;
import com.interapi.app.component.model.ComponentTab;
import com.interapi.app.component.model.ComponentTabExample;

@Service
public class ComponentTabServiceImpl extends BaseServiceImpl<ComponentTab, ComponentTabExample> implements ComponentTabService<ComponentTab, ComponentTabExample>{

    @Autowired
    private ComponentTabMapper mapper;
	
	public IBaseDao<ComponentTab, ComponentTabExample> getMapper(){
		return mapper;
	}
}