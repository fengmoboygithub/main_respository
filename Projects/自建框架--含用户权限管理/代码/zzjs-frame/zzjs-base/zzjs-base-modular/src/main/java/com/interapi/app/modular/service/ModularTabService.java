package com.interapi.app.modular.service;

import java.util.List;
import java.util.Map;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.model.BaseOption;
import com.interapi.app.base.service.IBaseService;

public interface ModularTabService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

	/**
	 * 通过模块ID查询模块信息，再通过模块信息中的表名和实例名查询该表下的所有列信息，
	 * 通过模块ID查询模块字段信息
	 * @param id
	 * @return 
	 * 	map.data 所有列信息 [{"key":"id","label":"主键"},{...}]
	 * 	map.value 模块字段信息["name","account"]
	 */
	Map<String, List> getFieldsById(Long id);

	/**
	 * 保存模块字段信息
	 * @param id
	 * @param list
	 */
	void saveFieldInfo(Long id, List<BaseOption> list);

	/**
	 * 	通过模块ID查询 模块字段信息
	 *  通过模块ID查询 查询条件信息
	 * @param id
	 * @return
	 *  map.data  模块字段信息 [{"key":1(模块字段主键ID),"label":"name_姓名"},{...}]
	 * 	map.value 查询条件信息[1(模块字段主键ID),2(模块字段主键ID)]
	 */
	Map<String, List> getQueryCriteriasById(Long id);

	/**
	 * 保存查询条件信息
	 * @param id
	 * @param list
	 */
	void saveQueryCriteriaInfo(Long id, List<BaseOption> list);

	/**
	 * 	通过模块ID查询 模块字段信息
	 *  通过模块ID查询 表格项信息
	 * @param id
	 * @return
	 *  map.data  模块字段信息 [{"key":1(模块字段主键ID),"label":"name_姓名"},{...}]
	 * 	map.value 表格项信息[1(模块字段主键ID),2(模块字段主键ID)]
	 */
	Map<String, List> getTableItemsById(Long id);

	/**
	 * 保存表格项信息
	 * @param id
	 * @param list
	 */
	void saveTableItemInfo(Long id, List<BaseOption> list);
	
	/**
	 * 	通过模块ID查询 模块字段信息
	 *  通过模块ID查询 表单项信息
	 * @param id
	 * @return
	 *  map.data  模块字段信息 [{"key":1(模块字段主键ID),"label":"name_姓名"},{...}]
	 * 	map.value 表单项信息[1(模块字段主键ID),2(模块字段主键ID)]
	 */
	Map<String, List> getFormItemsById(Long id);
	
	/**
	 * 保存表单项信息
	 * @param id
	 * @param list
	 */
	void saveFormItemInfo(Long id, List<BaseOption> list);

	/**
	 * 通过模块名称查询 模块信息(查询条件信息  表格项信息 表单项信息)
	 * @param modularName
	 * @return
	 */
	String getModularInfo(String modularName);

}