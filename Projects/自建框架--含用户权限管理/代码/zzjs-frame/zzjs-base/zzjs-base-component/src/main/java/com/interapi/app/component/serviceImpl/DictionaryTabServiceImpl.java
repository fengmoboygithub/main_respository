package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.DictionaryTabService;
import com.interapi.app.component.dao.DictionaryTabMapper;
import com.interapi.app.component.model.DictionaryTab;
import com.interapi.app.component.model.DictionaryTabExample;

@Service
public class DictionaryTabServiceImpl extends BaseServiceImpl<DictionaryTab, DictionaryTabExample> implements DictionaryTabService<DictionaryTab, DictionaryTabExample>{

    @Autowired
    private DictionaryTabMapper mapper;
	
	public IBaseDao<DictionaryTab, DictionaryTabExample> getMapper(){
		return mapper;
	}
}