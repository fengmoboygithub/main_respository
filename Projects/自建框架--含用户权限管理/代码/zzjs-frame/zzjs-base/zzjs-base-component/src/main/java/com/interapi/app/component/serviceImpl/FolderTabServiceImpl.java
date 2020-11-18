package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.FolderTabService;
import com.interapi.app.component.dao.FolderTabMapper;
import com.interapi.app.component.model.FolderTab;
import com.interapi.app.component.model.FolderTabExample;

@Service
public class FolderTabServiceImpl extends BaseServiceImpl<FolderTab, FolderTabExample> implements FolderTabService<FolderTab, FolderTabExample>{

    @Autowired
    private FolderTabMapper mapper;
	
	public IBaseDao<FolderTab, FolderTabExample> getMapper(){
		return mapper;
	}
}