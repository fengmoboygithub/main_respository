package com.company.processConfig.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.processConfig.model.ProcessInfo;
import com.company.processConfig.model.ProcessStageInfo;

public interface GraphInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
    /**
     * 保存流程与阶段信息
     * @throws BaseException
     */
    void saveProcessInfo(ProcessInfo processInfo , ProcessStageInfo processStageInfo) throws BaseException;
    /**
     * 删除流程与阶段信息
     * @throws BaseException
     */
    void delProcessInfo(ProcessStageInfo processStageInfo) throws BaseException;
    /**
     * 保存图像信息
     * @throws BaseException
     */
    void saveGraphInfo(T record) throws BaseException;
}