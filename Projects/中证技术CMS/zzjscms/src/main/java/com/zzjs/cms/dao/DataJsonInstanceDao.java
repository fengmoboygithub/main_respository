package com.zzjs.cms.dao;

import org.springframework.stereotype.Repository;

import com.zzjs.cms.base.dao.IBaseDao;
import com.zzjs.cms.entity.DataJsonInstance;
import com.zzjs.cms.exception.BaseException;

@Repository
public interface DataJsonInstanceDao extends IBaseDao<DataJsonInstance>{
	/**
	 * 根据文件ID删除数据源实例表数据
	 * @param fileId
	 * @return
	 * @throws BaseException
	 */
	public Integer deleteByEntityByFileId(Long fileId) throws BaseException;
	
}
