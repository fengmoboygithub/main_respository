package com.interapi.app.bmp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.dao.ResourceTabMapper;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.ResourceTabExample;
import com.interapi.app.bmp.service.ResourceTabService;

@Service
public class ResourceTabServiceImpl extends BaseServiceImpl<ResourceTab, ResourceTabExample> implements ResourceTabService<ResourceTab, ResourceTabExample>{

    @Autowired
    private ResourceTabMapper mapper;
	
	public IBaseDao<ResourceTab, ResourceTabExample> getMapper(){
		return mapper;
	}
	
	@Override
	public List<ResourceTab> getResourceTabListByUserId(Long userId) {
		return mapper.getResourceTabListByUserId(userId);
	}
}