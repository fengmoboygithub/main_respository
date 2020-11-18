package com.interapi.app.modular.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.modular.service.TableItemTabService;
import com.interapi.app.modular.dao.TableItemTabMapper;
import com.interapi.app.modular.model.TableItemTab;
import com.interapi.app.modular.model.TableItemTabExample;

@Service
public class TableItemTabServiceImpl extends BaseServiceImpl<TableItemTab, TableItemTabExample> implements TableItemTabService<TableItemTab, TableItemTabExample>{

    @Autowired
    private TableItemTabMapper mapper;
	
	public IBaseDao<TableItemTab, TableItemTabExample> getMapper(){
		return mapper;
	}
}