package com.interapi.app.bmp.service;

import java.util.List;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.RoleTab;

public interface RoleTabService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	/**
	 * 通过用户ID获取角色列表
	 * @param userId
	 * @return
	 */
	public List<RoleTab> getRoleTabListByUserId(Long userId);
}