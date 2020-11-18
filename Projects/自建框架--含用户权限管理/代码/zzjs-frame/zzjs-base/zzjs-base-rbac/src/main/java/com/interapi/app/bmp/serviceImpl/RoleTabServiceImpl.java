package com.interapi.app.bmp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.dao.RoleTabMapper;
import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.RoleTabExample;
import com.interapi.app.bmp.service.RoleTabService;

@Service
public class RoleTabServiceImpl extends BaseServiceImpl<RoleTab, RoleTabExample> implements RoleTabService<RoleTab, RoleTabExample>{

    @Autowired
    private RoleTabMapper mapper;
	
	public IBaseDao<RoleTab, RoleTabExample> getMapper(){
		return mapper;
	}
	
	@Override
	public List<RoleTab> getRoleTabListByUserId(Long userId) {
		return mapper.getRoleTabListByUserId(userId);
	}
}