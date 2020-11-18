package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.PostTabService;
import com.interapi.app.bmp.dao.PostTabMapper;
import com.interapi.app.bmp.model.PostTab;
import com.interapi.app.bmp.model.PostTabExample;

@Service
public class PostTabServiceImpl extends BaseServiceImpl<PostTab, PostTabExample> implements PostTabService<PostTab, PostTabExample>{

    @Autowired
    private PostTabMapper mapper;
	
	public IBaseDao<PostTab, PostTabExample> getMapper(){
		return mapper;
	}
}