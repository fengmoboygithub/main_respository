package com.interapi.app.bmp.dao;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.UserPostRela;
import com.interapi.app.bmp.model.UserPostRelaExample;

import java.util.List;

public interface UserPostRelaMapper extends IBaseDao<UserPostRela, UserPostRelaExample>{

    List<UserPostRela> getListByUserId(Long userId);

    void deleteByUserId(Long userId);

    void insertBatch(List listJson);
}