package com.zzjs.cms.dao;

import org.springframework.stereotype.Repository;

import com.zzjs.cms.base.dao.IBaseDao;
import com.zzjs.cms.entity.DataJsonTemplate;

@Repository
public interface DataJsonTemplateDao extends IBaseDao<DataJsonTemplate>{
	
	/**
	 * 添加模板数据源，入参的对象的id 会重新赋值为插入表中数据的主键
	 * @param dataJsonTemplate
	 * @return 影响的条数
	 */
	public Integer addDataJsonTemplate(DataJsonTemplate dataJsonTemplate);
	
	/**
	 * 通过主键选择性更新模板数据源
	 * @param dataJsonTemplate
	 * @return
	 */
	public int updateByIdSelective(DataJsonTemplate dataJsonTemplate);
}
