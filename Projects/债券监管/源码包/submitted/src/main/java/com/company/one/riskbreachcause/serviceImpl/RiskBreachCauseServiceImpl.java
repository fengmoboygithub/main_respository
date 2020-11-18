package com.company.one.riskbreachcause.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.one.riskbreachcause.dao.RiskBreachCauseMapper;
import com.company.one.riskbreachcause.model.RiskBreachCause;
import com.company.one.riskbreachcause.model.RiskBreachCauseExample;
import com.company.one.riskbreachcause.service.RiskBreachCauseService;

@Service
public class RiskBreachCauseServiceImpl extends BaseServiceImpl<RiskBreachCause, RiskBreachCauseExample> implements RiskBreachCauseService<RiskBreachCause, RiskBreachCauseExample>{

    @Autowired
    private RiskBreachCauseMapper mapper;
	
	public IBaseDao<RiskBreachCause, RiskBreachCauseExample> getMapper(){
		return mapper;
	}
}