package com.company.one.handletuple.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.handletuple.service.HandleTupleTmpService;
import com.company.one.handletuple.dao.HandleTupleTmpMapper;
import com.company.one.handletuple.model.HandleTupleTmp;
import com.company.one.handletuple.model.HandleTupleTmpExample;

@Service
public class HandleTupleTmpServiceImpl extends BaseServiceImpl<HandleTupleTmp, HandleTupleTmpExample> implements HandleTupleTmpService<HandleTupleTmp, HandleTupleTmpExample>{

    @Autowired
    private HandleTupleTmpMapper mapper;
	
	public IBaseDao<HandleTupleTmp, HandleTupleTmpExample> getMapper(){
		return mapper;
	}
}