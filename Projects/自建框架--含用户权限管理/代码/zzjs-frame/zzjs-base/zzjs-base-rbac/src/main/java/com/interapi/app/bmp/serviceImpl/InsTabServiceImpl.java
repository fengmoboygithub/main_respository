package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.InsTabService;
import com.interapi.app.bmp.dao.InsTabMapper;
import com.interapi.app.bmp.model.InsTab;
import com.interapi.app.bmp.model.InsTabExample;

@Service
public class InsTabServiceImpl extends BaseServiceImpl<InsTab, InsTabExample> implements InsTabService<InsTab, InsTabExample>{

    @Autowired
    private InsTabMapper mapper;
	
	public IBaseDao<InsTab, InsTabExample> getMapper(){
		return mapper;
	}
}