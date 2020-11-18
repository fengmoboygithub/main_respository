package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.SiteTabService;
import com.interapi.app.component.dao.SiteTabMapper;
import com.interapi.app.component.model.SiteTab;
import com.interapi.app.component.model.SiteTabExample;

@Service
public class SiteTabServiceImpl extends BaseServiceImpl<SiteTab, SiteTabExample> implements SiteTabService<SiteTab, SiteTabExample>{

    @Autowired
    private SiteTabMapper mapper;
	
	public IBaseDao<SiteTab, SiteTabExample> getMapper(){
		return mapper;
	}
}