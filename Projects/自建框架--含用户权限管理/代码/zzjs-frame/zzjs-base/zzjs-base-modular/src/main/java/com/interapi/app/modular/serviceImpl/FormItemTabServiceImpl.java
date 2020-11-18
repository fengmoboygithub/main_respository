package com.interapi.app.modular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.service.FormItemTabService;
import com.interapi.app.modular.dao.FormItemTabMapper;
import com.interapi.app.modular.model.FormItemTab;
import com.interapi.app.modular.model.FormItemTabExample;

@Service
public class FormItemTabServiceImpl extends BaseServiceImpl<FormItemTab, FormItemTabExample> implements FormItemTabService<FormItemTab, FormItemTabExample>{

    @Autowired
    private FormItemTabMapper mapper;
	
	public IBaseDao<FormItemTab, FormItemTabExample> getMapper(){
		return mapper;
	}
}