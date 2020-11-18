package com.interapi.app.bmp.service;

import java.util.List;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.ResourceTab;

public interface ResourceTabService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	/**
	 * 通过用户ID获取接口资源列表
	 * @param userId
	 * @return
	 */
	public List<ResourceTab> getResourceTabListByUserId(Long userId);
}