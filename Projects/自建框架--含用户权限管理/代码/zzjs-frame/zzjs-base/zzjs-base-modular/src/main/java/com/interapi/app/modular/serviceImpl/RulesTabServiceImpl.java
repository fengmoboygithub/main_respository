package com.interapi.app.modular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.service.RulesTabService;
import com.interapi.app.modular.dao.RulesTabMapper;
import com.interapi.app.modular.model.RulesTab;
import com.interapi.app.modular.model.RulesTabExample;

@Service
public class RulesTabServiceImpl extends BaseServiceImpl<RulesTab, RulesTabExample> implements RulesTabService<RulesTab, RulesTabExample>{

    @Autowired
    private RulesTabMapper mapper;
	
	public IBaseDao<RulesTab, RulesTabExample> getMapper(){
		return mapper;
	}
}