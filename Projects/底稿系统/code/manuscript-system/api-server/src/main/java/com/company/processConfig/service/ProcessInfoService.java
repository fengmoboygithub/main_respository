package com.company.processConfig.service;

import java.util.List;
import java.util.Map;

import com.company.base.example.BaseExample;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;

public interface ProcessInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	/**
	 * 保存流程信息
	 * @param addlist
	 * @param dellist
	 */
	void saveProcessList(List<Map<String, String>> addlist,List<Map<String, String>> dellist);
}