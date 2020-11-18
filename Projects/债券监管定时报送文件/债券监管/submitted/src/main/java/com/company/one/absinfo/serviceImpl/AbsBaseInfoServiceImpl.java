package com.company.one.absinfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.absinfo.dao.AbsBaseInfoMapper;
import com.company.one.absinfo.model.AbsBaseInfo;
import com.company.one.absinfo.model.AbsBaseInfoExample;
import com.company.one.absinfo.service.AbsBaseInfoService;

@Service
public class AbsBaseInfoServiceImpl extends BaseServiceImpl<AbsBaseInfo, AbsBaseInfoExample> implements AbsBaseInfoService<AbsBaseInfo, AbsBaseInfoExample>{

    @Autowired
    private AbsBaseInfoMapper mapper;
	
	public IBaseDao<AbsBaseInfo, AbsBaseInfoExample> getMapper(){
		return mapper;
	}
}