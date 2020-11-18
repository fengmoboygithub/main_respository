package com.interapi.app.bmp.dao;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.PostRoleRela;
import com.interapi.app.bmp.model.PostRoleRelaExample;

import java.util.List;

public interface PostRoleRelaMapper extends IBaseDao<PostRoleRela, PostRoleRelaExample>{

    List<PostRoleRela> getListByPostId(Long postId);

    void deleteByPostId(Long postId);

    void insertBatch(List<PostRoleRela> list);
}