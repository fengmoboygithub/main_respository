package com.interapi.app.component.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.component.service.MediaFolderRelaService;
import com.interapi.app.component.dao.MediaFolderRelaMapper;
import com.interapi.app.component.model.MediaFolderRela;
import com.interapi.app.component.model.MediaFolderRelaExample;

@Service
public class MediaFolderRelaServiceImpl extends BaseServiceImpl<MediaFolderRela, MediaFolderRelaExample> implements MediaFolderRelaService<MediaFolderRela, MediaFolderRelaExample>{

    @Autowired
    private MediaFolderRelaMapper mapper;
	
	public IBaseDao<MediaFolderRela, MediaFolderRelaExample> getMapper(){
		return mapper;
	}
}