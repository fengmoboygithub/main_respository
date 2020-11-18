package com.interapi.app.bmp.service;

import java.util.List;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.PageTab;

public interface PageTabService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	
	/**
	 * 通过用户名称获取菜单页面列表
	 * @param username
	 * @return
	 */
	public List<PageTab> getPageTabListByUserId(String userName);
	
	/**
	 * 通过用户ID获取页面列表
	 * @param userId
	 * @return
	 */
	public List<PageTab> getPageTabListByUserId(Long userId);
}