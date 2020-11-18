package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.ComponentTemplateTabService;
import com.interapi.app.component.dao.ComponentTemplateTabMapper;
import com.interapi.app.component.model.ComponentTemplateTab;
import com.interapi.app.component.model.ComponentTemplateTabExample;

@Service
public class ComponentTemplateTabServiceImpl extends BaseServiceImpl<ComponentTemplateTab, ComponentTemplateTabExample> implements ComponentTemplateTabService<ComponentTemplateTab, ComponentTemplateTabExample>{

    @Autowired
    private ComponentTemplateTabMapper mapper;
	
	public IBaseDao<ComponentTemplateTab, ComponentTemplateTabExample> getMapper(){
		return mapper;
	}
}