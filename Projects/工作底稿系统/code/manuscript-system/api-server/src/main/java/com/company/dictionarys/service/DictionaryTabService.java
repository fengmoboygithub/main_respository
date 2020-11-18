package com.company.dictionarys.service;

import java.util.List;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.dictionarys.model.DictionaryTab;

public interface DictionaryTabService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	/**
	 * 
	 * @param id
	 * @throws BaseException
	 */
	public void deleteByPrimaryKey(Long id) throws BaseException;

	/**
	 * 	根据字典key查询下面字典列表
	 * @param dicKey
	 * @return
	 */
	public List<DictionaryTab> getDictionarysByKey(String dicKey) throws BaseException;
	
	/**
	 * 	根据字典key查询字典值
	 * @param dicKey
	 * @return
	 */
	public String getDictionaryByKey(String dicKey) throws BaseException;
}