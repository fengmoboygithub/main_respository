package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.FileTabService;
import com.interapi.app.component.dao.FileTabMapper;
import com.interapi.app.component.model.FileTab;
import com.interapi.app.component.model.FileTabExample;

@Service
public class FileTabServiceImpl extends BaseServiceImpl<FileTab, FileTabExample> implements FileTabService<FileTab, FileTabExample>{

    @Autowired
    private FileTabMapper mapper;
	
	public IBaseDao<FileTab, FileTabExample> getMapper(){
		return mapper;
	}
}