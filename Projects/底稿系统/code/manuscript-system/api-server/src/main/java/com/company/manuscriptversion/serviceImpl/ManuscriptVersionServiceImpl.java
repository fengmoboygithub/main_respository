package com.company.manuscriptversion.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.manuscriptversion.service.ManuscriptVersionService;
import com.company.manuscriptversion.dao.ManuscriptVersionMapper;
import com.company.manuscriptversion.model.ManuscriptVersion;
import com.company.manuscriptversion.model.ManuscriptVersionExample;

@Service
public class ManuscriptVersionServiceImpl extends BaseServiceImpl<ManuscriptVersion, ManuscriptVersionExample> implements ManuscriptVersionService<ManuscriptVersion, ManuscriptVersionExample>{

    @Autowired
    private ManuscriptVersionMapper mapper;
	
	public IBaseDao<ManuscriptVersion, ManuscriptVersionExample> getMapper(){
		return mapper;
	}
}