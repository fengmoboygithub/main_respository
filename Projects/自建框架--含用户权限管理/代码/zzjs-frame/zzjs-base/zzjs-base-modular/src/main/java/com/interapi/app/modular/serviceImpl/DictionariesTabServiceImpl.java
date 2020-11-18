package com.interapi.app.modular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.service.DictionariesTabService;
import com.interapi.app.modular.dao.DictionariesTabMapper;
import com.interapi.app.modular.model.DictionariesTab;
import com.interapi.app.modular.model.DictionariesTabExample;

@Service
public class DictionariesTabServiceImpl extends BaseServiceImpl<DictionariesTab, DictionariesTabExample> implements DictionariesTabService<DictionariesTab, DictionariesTabExample>{

    @Autowired
    private DictionariesTabMapper mapper;
	
	public IBaseDao<DictionariesTab, DictionariesTabExample> getMapper(){
		return mapper;
	}
}