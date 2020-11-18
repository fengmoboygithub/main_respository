package com.company.userinfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.userinfo.service.UserTabService;
import com.company.userinfo.dao.UserTabMapper;
import com.company.userinfo.model.UserTab;
import com.company.userinfo.model.UserTabExample;

@Service
public class UserTabServiceImpl extends BaseServiceImpl<UserTab, UserTabExample> implements UserTabService<UserTab, UserTabExample>{

    @Autowired
    private UserTabMapper mapper;
	
	public IBaseDao<UserTab, UserTabExample> getMapper(){
		return mapper;
	}
}