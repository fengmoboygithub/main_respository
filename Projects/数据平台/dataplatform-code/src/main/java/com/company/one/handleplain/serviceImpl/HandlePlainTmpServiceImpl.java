package com.company.one.handleplain.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.handleplain.service.HandlePlainTmpService;
import com.company.one.handleplain.dao.HandlePlainTmpMapper;
import com.company.one.handleplain.model.HandlePlainTmp;
import com.company.one.handleplain.model.HandlePlainTmpExample;

@Service
public class HandlePlainTmpServiceImpl extends BaseServiceImpl<HandlePlainTmp, HandlePlainTmpExample> implements HandlePlainTmpService<HandlePlainTmp, HandlePlainTmpExample>{

    @Autowired
    private HandlePlainTmpMapper mapper;
	
	public IBaseDao<HandlePlainTmp, HandlePlainTmpExample> getMapper(){
		return mapper;
	}
}