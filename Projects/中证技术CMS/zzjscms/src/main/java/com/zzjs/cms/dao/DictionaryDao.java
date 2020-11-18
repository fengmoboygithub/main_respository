package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.entity.Dictionary;

/**
 * 字典dao
 * @author yinlong
 *
 */
@Repository
public interface DictionaryDao {

	/**
	 *  通过字典key查询数据
	 * @param key
	 * @return
	 */
	List<Dictionary> getDictionariesByKey(@Param("dicKey") String dicKey);

	
	
}
