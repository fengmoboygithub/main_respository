package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.MediaTabService;
import com.interapi.app.component.dao.MediaTabMapper;
import com.interapi.app.component.model.MediaTab;
import com.interapi.app.component.model.MediaTabExample;

@Service
public class MediaTabServiceImpl extends BaseServiceImpl<MediaTab, MediaTabExample> implements MediaTabService<MediaTab, MediaTabExample>{

    @Autowired
    private MediaTabMapper mapper;
	
	public IBaseDao<MediaTab, MediaTabExample> getMapper(){
		return mapper;
	}
}