package com.interapi.app.modular.dao;

import java.util.List;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.modular.model.ModularFieldTab;
import com.interapi.app.modular.model.ModularTab;
import com.interapi.app.modular.model.ModularTabExample;
public interface ModularTabMapper extends IBaseDao<ModularTab, ModularTabExample>{

	/**
	 * 通过模块表名和实例名 查询所有列信息
	 * @param modularTab
	 * @return
	 */
	List<ModularFieldTab> selectAllFields(ModularTab modularTab);

}