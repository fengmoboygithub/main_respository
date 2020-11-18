package com.company.two.templatetab.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.two.templatetab.service.TabTemplateService;
import com.company.two.templatetab.dao.TabTemplateMapper;
import com.company.two.templatetab.model.TabTemplate;
import com.company.two.templatetab.model.TabTemplateExample;

@Service
public class TabTemplateServiceImpl extends BaseServiceImpl<TabTemplate, TabTemplateExample> implements TabTemplateService<TabTemplate, TabTemplateExample>{

    @Autowired
    private TabTemplateMapper mapper;
	
	public IBaseDao<TabTemplate, TabTemplateExample> getMapper(){
		return mapper;
	}
}