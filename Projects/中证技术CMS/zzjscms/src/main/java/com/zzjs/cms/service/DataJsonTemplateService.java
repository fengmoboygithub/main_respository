package com.zzjs.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.base.service.BaseServiceImpl;
import com.zzjs.cms.dao.DataJsonTemplateDao;
import com.zzjs.cms.entity.DataJsonTemplate;

/**
 * 数据源模板service
 * 
 * @author yangyanchao
 */
@Service
public class DataJsonTemplateService extends BaseServiceImpl<DataJsonTemplate>{
	@Autowired
	private DataJsonTemplateDao dataJsonTemplateDao;
	
	public DataJsonTemplateDao getDao(){
		return dataJsonTemplateDao;
	}
	
	/**
	 * 添加模板数据源，入参的对象的id 会重新赋值为插入表中数据的主键
	 * @param dataJsonTemplate
	 * @return 影响的条数
	 */
	public Integer addDataJsonTemplate(DataJsonTemplate dataJsonTemplate){
		return getDao().addDataJsonTemplate(dataJsonTemplate);
	}
	
	/**
	 * 通过主键选择性更新模板数据源
	 * @param dataJsonTemplate
	 * @return
	 */
	public int updateByIdSelective(DataJsonTemplate dataJsonTemplate){
		
		return getDao().updateByIdSelective(dataJsonTemplate);
	}
}
