package com.interapi.app.modular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.service.ElementTabService;
import com.interapi.app.modular.dao.ElementTabMapper;
import com.interapi.app.modular.model.ElementTab;
import com.interapi.app.modular.model.ElementTabExample;

@Service
public class ElementTabServiceImpl extends BaseServiceImpl<ElementTab, ElementTabExample> implements ElementTabService<ElementTab, ElementTabExample>{

    @Autowired
    private ElementTabMapper mapper;
	
	public IBaseDao<ElementTab, ElementTabExample> getMapper(){
		return mapper;
	}
}