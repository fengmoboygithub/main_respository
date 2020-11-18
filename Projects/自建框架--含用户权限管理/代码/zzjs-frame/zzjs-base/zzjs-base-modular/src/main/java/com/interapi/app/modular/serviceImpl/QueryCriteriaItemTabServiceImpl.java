package com.interapi.app.modular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.service.QueryCriteriaItemTabService;
import com.interapi.app.modular.dao.QueryCriteriaItemTabMapper;
import com.interapi.app.modular.model.QueryCriteriaItemTab;
import com.interapi.app.modular.model.QueryCriteriaItemTabExample;

@Service
public class QueryCriteriaItemTabServiceImpl extends BaseServiceImpl<QueryCriteriaItemTab, QueryCriteriaItemTabExample> implements QueryCriteriaItemTabService<QueryCriteriaItemTab, QueryCriteriaItemTabExample>{

    @Autowired
    private QueryCriteriaItemTabMapper mapper;
	
	public IBaseDao<QueryCriteriaItemTab, QueryCriteriaItemTabExample> getMapper(){
		return mapper;
	}
}