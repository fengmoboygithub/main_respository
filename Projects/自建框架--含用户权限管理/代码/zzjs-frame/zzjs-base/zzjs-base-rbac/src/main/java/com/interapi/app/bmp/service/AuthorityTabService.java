package com.interapi.app.bmp.service;

import java.util.List;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.AuthorityTab;

public interface AuthorityTabService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	/**
	 * 通过用户ID获取权限列表
	 * @param userId
	 * @return
	 */
	public List<AuthorityTab> getAuthorityTabListByUserId(Long userId);
}