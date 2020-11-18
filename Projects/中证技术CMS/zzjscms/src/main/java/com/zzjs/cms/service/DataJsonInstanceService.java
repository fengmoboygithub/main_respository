package com.zzjs.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.base.service.BaseServiceImpl;
import com.zzjs.cms.dao.DataJsonInstanceDao;
import com.zzjs.cms.entity.DataJsonInstance;

/**
 * 数据源实例service
 * 
 * @author yangyanchao
 */
@Service
public class DataJsonInstanceService extends BaseServiceImpl<DataJsonInstance>{
	@Autowired
	private DataJsonInstanceDao dataJsonInstanceDao;
	
	public DataJsonInstanceDao getDao(){
		return dataJsonInstanceDao;
	}
}
