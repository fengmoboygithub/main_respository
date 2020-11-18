package com.company.docuserremarksmap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.docuserremarksmap.service.DocUserRemarksMapService;
import com.company.docuserremarksmap.dao.DocUserRemarksMapMapper;
import com.company.docuserremarksmap.model.DocUserRemarksMap;
import com.company.docuserremarksmap.model.DocUserRemarksMapExample;

@Service
public class DocUserRemarksMapServiceImpl extends BaseServiceImpl<DocUserRemarksMap, DocUserRemarksMapExample> implements DocUserRemarksMapService<DocUserRemarksMap, DocUserRemarksMapExample>{

    @Autowired
    private DocUserRemarksMapMapper mapper;
	
	public IBaseDao<DocUserRemarksMap, DocUserRemarksMapExample> getMapper(){
		return mapper;
	}
}