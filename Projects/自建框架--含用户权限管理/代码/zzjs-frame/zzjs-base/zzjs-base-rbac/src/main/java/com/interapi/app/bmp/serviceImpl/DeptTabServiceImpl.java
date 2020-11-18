package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.DeptTabService;
import com.interapi.app.bmp.dao.DeptTabMapper;
import com.interapi.app.bmp.model.DeptTab;
import com.interapi.app.bmp.model.DeptTabExample;

@Service
public class DeptTabServiceImpl extends BaseServiceImpl<DeptTab, DeptTabExample> implements DeptTabService<DeptTab, DeptTabExample>{

    @Autowired
    private DeptTabMapper mapper;
	
	public IBaseDao<DeptTab, DeptTabExample> getMapper(){
		return mapper;
	}
}