package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.RoleTabExample;
public interface RoleTabMapper extends IBaseDao<RoleTab, RoleTabExample>{
	/**
	 * 通过用户ID获取角色列表
	 * @param id
	 * @return
	 */
	List<RoleTab> getRoleTabListByUserId(@Param("id") Long id);
}