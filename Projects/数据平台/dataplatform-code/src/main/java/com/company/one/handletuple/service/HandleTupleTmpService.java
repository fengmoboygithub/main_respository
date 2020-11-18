package com.company.one.handletuple.service;

import com.company.base.example.BaseExample;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;

public interface HandleTupleTmpService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

}