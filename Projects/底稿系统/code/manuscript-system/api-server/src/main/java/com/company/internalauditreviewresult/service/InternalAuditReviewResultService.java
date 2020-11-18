package com.company.internalauditreviewresult.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;

public interface InternalAuditReviewResultService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    void saveInternalAuditReviewResult(T record, String taskId) throws BaseException;
}