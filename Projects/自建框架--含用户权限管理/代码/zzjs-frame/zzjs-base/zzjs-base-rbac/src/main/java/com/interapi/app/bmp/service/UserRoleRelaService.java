package com.interapi.app.bmp.service;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.UserRoleRela;

import java.util.List;

public interface UserRoleRelaService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    List<UserRoleRela> getListByUserId(Long userId);

    void updateUserRoleRela(Long userId, String roleList);
}