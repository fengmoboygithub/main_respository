package com.company.processConfig.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.processConfig.model.StageInfo;
import com.company.processConfig.model.StageInfoExample;

import java.util.List;

public interface StageInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    public List<StageInfo> getListByType(StageInfoExample example) throws BaseException;
}
