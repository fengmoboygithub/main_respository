package com.company.one.absinfo.service;

import com.company.base.example.BaseExample;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;

public interface AbsBaseInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

}