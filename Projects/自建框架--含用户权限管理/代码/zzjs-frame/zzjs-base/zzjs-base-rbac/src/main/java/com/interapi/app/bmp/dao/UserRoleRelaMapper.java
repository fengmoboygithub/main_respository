package com.interapi.app.bmp.dao;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.UserRoleRela;
import com.interapi.app.bmp.model.UserRoleRelaExample;

import java.util.List;

public interface UserRoleRelaMapper extends IBaseDao<UserRoleRela, UserRoleRelaExample>{

    List<UserRoleRela> getListByUserId(Long userId);

    void deleteByUserId(Long userId);

    void insertBatch(List<UserRoleRela> list);
}