package com.company.projectstageinfo.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;

import java.io.Serializable;

public interface ProjectStageInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
    /**
     * 	删除该阶段及基础目录数据
	 * @param id
	 * @throws BaseException
	 */
    void deleteForMe(String id) throws BaseException;
}