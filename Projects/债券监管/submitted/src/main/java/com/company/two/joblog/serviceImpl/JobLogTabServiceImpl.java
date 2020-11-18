package com.company.two.joblog.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.two.joblog.service.JobLogTabService;
import com.company.two.joblog.dao.JobLogTabMapper;
import com.company.two.joblog.model.JobLogTab;
import com.company.two.joblog.model.JobLogTabExample;

@Service
public class JobLogTabServiceImpl extends BaseServiceImpl<JobLogTab, JobLogTabExample> implements JobLogTabService<JobLogTab, JobLogTabExample>{

    @Autowired
    private JobLogTabMapper mapper;
	
	public IBaseDao<JobLogTab, JobLogTabExample> getMapper(){
		return mapper;
	}
}