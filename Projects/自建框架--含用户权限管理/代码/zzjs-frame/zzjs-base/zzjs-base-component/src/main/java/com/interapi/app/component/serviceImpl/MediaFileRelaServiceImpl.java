package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.MediaFileRelaService;
import com.interapi.app.component.dao.MediaFileRelaMapper;
import com.interapi.app.component.model.MediaFileRela;
import com.interapi.app.component.model.MediaFileRelaExample;

@Service
public class MediaFileRelaServiceImpl extends BaseServiceImpl<MediaFileRela, MediaFileRelaExample> implements MediaFileRelaService<MediaFileRela, MediaFileRelaExample>{

    @Autowired
    private MediaFileRelaMapper mapper;
	
	public IBaseDao<MediaFileRela, MediaFileRelaExample> getMapper(){
		return mapper;
	}
}