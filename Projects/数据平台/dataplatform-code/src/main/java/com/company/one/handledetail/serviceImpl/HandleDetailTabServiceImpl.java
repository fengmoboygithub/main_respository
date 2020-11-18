package com.company.one.handledetail.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.handledetail.service.HandleDetailTabService;
import com.company.one.handledetail.dao.HandleDetailTabMapper;
import com.company.one.handledetail.model.HandleDetailTab;
import com.company.one.handledetail.model.HandleDetailTabExample;

@Service
public class HandleDetailTabServiceImpl extends BaseServiceImpl<HandleDetailTab, HandleDetailTabExample> implements HandleDetailTabService<HandleDetailTab, HandleDetailTabExample>{

    @Autowired
    private HandleDetailTabMapper mapper;
	
	public IBaseDao<HandleDetailTab, HandleDetailTabExample> getMapper(){
		return mapper;
	}
}