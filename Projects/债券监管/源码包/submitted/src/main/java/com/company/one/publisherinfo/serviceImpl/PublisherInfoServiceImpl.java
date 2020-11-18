package com.company.one.publisherinfo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.publisherinfo.dao.PublisherInfoMapper;
import com.company.one.publisherinfo.model.PublisherInfo;
import com.company.one.publisherinfo.model.PublisherInfoExample;
import com.company.one.publisherinfo.service.PublisherInfoService;

@Service
public class PublisherInfoServiceImpl extends BaseServiceImpl<PublisherInfo, PublisherInfoExample> implements PublisherInfoService<PublisherInfo, PublisherInfoExample>{

    @Autowired
    private PublisherInfoMapper mapper;
	
	public IBaseDao<PublisherInfo, PublisherInfoExample> getMapper(){
		return mapper;
	}
}