package com.interapi.app.bmp.service;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.UserPostRela;

import java.util.List;

public interface UserPostRelaService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    List<UserPostRela> getListByUserId(Long userId);

    void updateUserPostRela(Long userId, String  postList);
}