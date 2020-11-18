package com.company.messagecenter.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.messagecenter.model.MessageCenter;

public interface MessageCenterService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
    /**
     * 编辑消息
     * @param model
     * @throws BaseException
     */
    void updateForMe(MessageCenter model) throws BaseException;
}