package com.company.one.baseinfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.baseinfo.dao.BondBaseInfoMapper;
import com.company.one.baseinfo.model.BondBaseInfo;
import com.company.one.baseinfo.model.BondBaseInfoExample;
import com.company.one.baseinfo.service.BondBaseInfoService;

@Service
public class BondBaseInfoServiceImpl extends BaseServiceImpl<BondBaseInfo, BondBaseInfoExample> implements BondBaseInfoService<BondBaseInfo, BondBaseInfoExample>{

    @Autowired
    private BondBaseInfoMapper mapper;
	
	public IBaseDao<BondBaseInfo, BondBaseInfoExample> getMapper(){
		return mapper;
	}
}