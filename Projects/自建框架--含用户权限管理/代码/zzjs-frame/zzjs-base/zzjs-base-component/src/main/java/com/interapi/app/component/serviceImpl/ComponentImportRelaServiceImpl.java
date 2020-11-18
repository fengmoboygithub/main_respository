package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.ComponentImportRelaService;
import com.interapi.app.component.dao.ComponentImportRelaMapper;
import com.interapi.app.component.model.ComponentImportRela;
import com.interapi.app.component.model.ComponentImportRelaExample;

@Service
public class ComponentImportRelaServiceImpl extends BaseServiceImpl<ComponentImportRela, ComponentImportRelaExample> implements ComponentImportRelaService<ComponentImportRela, ComponentImportRelaExample>{

    @Autowired
    private ComponentImportRelaMapper mapper;
	
	public IBaseDao<ComponentImportRela, ComponentImportRelaExample> getMapper(){
		return mapper;
	}
}