package com.company.operateinfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.operateinfo.service.OperateInfoService;
import com.company.operateinfo.dao.OperateInfoMapper;
import com.company.operateinfo.model.OperateInfo;
import com.company.operateinfo.model.OperateInfoExample;

@Service
public class OperateInfoServiceImpl extends BaseServiceImpl<OperateInfo, OperateInfoExample> implements OperateInfoService<OperateInfo, OperateInfoExample>{

    @Autowired
    private OperateInfoMapper mapper;
	
	public IBaseDao<OperateInfo, OperateInfoExample> getMapper(){
		return mapper;
	}
}