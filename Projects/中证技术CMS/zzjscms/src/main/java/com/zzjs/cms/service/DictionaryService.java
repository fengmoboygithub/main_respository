package com.zzjs.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.dao.DictionaryDao;
import com.zzjs.cms.entity.Dictionary;

/**
 * 字典Service
 * @author yinlong
 *
 */
@Service
public class DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;
	
	/**
	 * 通过字典key查询数据
	 * @param key
	 * @return
	 */
	public List<Dictionary> getDictionariesByKey(String dicKey) {
		return dictionaryDao.getDictionariesByKey(dicKey);
	}
	
	
}
