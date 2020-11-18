package com.company.usermessagerela.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.usermessagerela.model.UserMessageRela;

public interface UserMessageRelaService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
    /**
     * 发布消息
     * @param info
     *              消息信息列表 赋值 info.mgList
     *              用户信息列表 赋值 info.userList
     * @throws BaseException
     */
    void saveForMe(UserMessageRela info) throws BaseException;

    /**
     * 全部撤回消息
     * @param info
     *              消息信息列表 赋值 info.mgList
     * @throws BaseException
     */
    void delForAll(UserMessageRela info) throws BaseException;

    /**
     * 部分撤回消息
     * @param info
     *              消息信息列表 赋值 info.mgList
     *              用户信息列表 赋值 info.userList
     * @throws BaseException
     */
    void delForPart(UserMessageRela info) throws BaseException;
}