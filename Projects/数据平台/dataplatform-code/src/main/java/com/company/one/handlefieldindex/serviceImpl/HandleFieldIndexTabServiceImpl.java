package com.company.one.handlefieldindex.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.handlefieldindex.service.HandleFieldIndexTabService;
import com.company.one.handlefieldindex.dao.HandleFieldIndexTabMapper;
import com.company.one.handlefieldindex.model.HandleFieldIndexTab;
import com.company.one.handlefieldindex.model.HandleFieldIndexTabExample;

@Service
public class HandleFieldIndexTabServiceImpl extends BaseServiceImpl<HandleFieldIndexTab, HandleFieldIndexTabExample> implements HandleFieldIndexTabService<HandleFieldIndexTab, HandleFieldIndexTabExample>{

    @Autowired
    private HandleFieldIndexTabMapper mapper;
	
	public IBaseDao<HandleFieldIndexTab, HandleFieldIndexTabExample> getMapper(){
		return mapper;
	}
}