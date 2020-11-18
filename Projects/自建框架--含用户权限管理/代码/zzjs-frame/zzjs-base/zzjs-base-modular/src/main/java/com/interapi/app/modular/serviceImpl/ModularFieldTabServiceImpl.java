package com.interapi.app.modular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.service.ModularFieldTabService;
import com.interapi.app.modular.dao.ModularFieldTabMapper;
import com.interapi.app.modular.model.ModularFieldTab;
import com.interapi.app.modular.model.ModularFieldTabExample;

@Service
public class ModularFieldTabServiceImpl extends BaseServiceImpl<ModularFieldTab, ModularFieldTabExample> implements ModularFieldTabService<ModularFieldTab, ModularFieldTabExample>{

    @Autowired
    private ModularFieldTabMapper mapper;
	
	public IBaseDao<ModularFieldTab, ModularFieldTabExample> getMapper(){
		return mapper;
	}
}