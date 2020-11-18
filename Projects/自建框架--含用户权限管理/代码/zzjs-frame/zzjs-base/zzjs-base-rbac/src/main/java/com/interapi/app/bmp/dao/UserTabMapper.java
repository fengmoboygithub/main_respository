package com.interapi.app.bmp.dao;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
public interface UserTabMapper extends IBaseDao<UserTab, UserTabExample>{

    /**
     * 修改用户密码
     * @param recode
     */
    void updatePassword(UserTab recode);

    UserTab selectUserDetailById(Long id);

}