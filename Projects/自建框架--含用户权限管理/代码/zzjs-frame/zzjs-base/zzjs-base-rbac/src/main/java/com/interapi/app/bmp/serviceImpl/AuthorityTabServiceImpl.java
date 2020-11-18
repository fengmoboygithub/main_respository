package com.interapi.app.bmp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.dao.AuthorityTabMapper;
import com.interapi.app.bmp.model.AuthorityTab;
import com.interapi.app.bmp.model.AuthorityTabExample;
import com.interapi.app.bmp.service.AuthorityTabService;

@Service
public class AuthorityTabServiceImpl extends BaseServiceImpl<AuthorityTab, AuthorityTabExample> implements AuthorityTabService<AuthorityTab, AuthorityTabExample>{

    @Autowired
    private AuthorityTabMapper mapper;
	
	public IBaseDao<AuthorityTab, AuthorityTabExample> getMapper(){
		return mapper;
	}
	
	@Override
	public List<AuthorityTab> getAuthorityTabListByUserId(Long userId) {
		return mapper.getAuthorityTabListByUserId(userId);
	}
}