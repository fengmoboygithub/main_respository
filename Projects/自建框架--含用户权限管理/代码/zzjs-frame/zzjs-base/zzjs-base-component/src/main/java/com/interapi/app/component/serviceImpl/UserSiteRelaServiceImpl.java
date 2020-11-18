package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.UserSiteRelaService;
import com.interapi.app.component.dao.UserSiteRelaMapper;
import com.interapi.app.component.model.UserSiteRela;
import com.interapi.app.component.model.UserSiteRelaExample;

@Service
public class UserSiteRelaServiceImpl extends BaseServiceImpl<UserSiteRela, UserSiteRelaExample> implements UserSiteRelaService<UserSiteRela, UserSiteRelaExample>{

    @Autowired
    private UserSiteRelaMapper mapper;
	
	public IBaseDao<UserSiteRela, UserSiteRelaExample> getMapper(){
		return mapper;
	}
}