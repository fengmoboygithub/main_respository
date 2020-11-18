package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.DataJsonTemplateTabService;
import com.interapi.app.component.dao.DataJsonTemplateTabMapper;
import com.interapi.app.component.model.DataJsonTemplateTab;
import com.interapi.app.component.model.DataJsonTemplateTabExample;

@Service
public class DataJsonTemplateTabServiceImpl extends BaseServiceImpl<DataJsonTemplateTab, DataJsonTemplateTabExample> implements DataJsonTemplateTabService<DataJsonTemplateTab, DataJsonTemplateTabExample>{

    @Autowired
    private DataJsonTemplateTabMapper mapper;
	
	public IBaseDao<DataJsonTemplateTab, DataJsonTemplateTabExample> getMapper(){
		return mapper;
	}
}