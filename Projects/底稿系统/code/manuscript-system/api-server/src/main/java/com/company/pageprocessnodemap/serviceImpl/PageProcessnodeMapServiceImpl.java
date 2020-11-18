package com.company.pageprocessnodemap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.pageprocessnodemap.service.PageProcessnodeMapService;
import com.company.pageprocessnodemap.dao.PageProcessnodeMapMapper;
import com.company.pageprocessnodemap.model.PageProcessnodeMap;
import com.company.pageprocessnodemap.model.PageProcessnodeMapExample;

@Service
public class PageProcessnodeMapServiceImpl extends BaseServiceImpl<PageProcessnodeMap, PageProcessnodeMapExample> implements PageProcessnodeMapService<PageProcessnodeMap, PageProcessnodeMapExample>{

    @Autowired
    private PageProcessnodeMapMapper mapper;
	
	public IBaseDao<PageProcessnodeMap, PageProcessnodeMapExample> getMapper(){
		return mapper;
	}
}