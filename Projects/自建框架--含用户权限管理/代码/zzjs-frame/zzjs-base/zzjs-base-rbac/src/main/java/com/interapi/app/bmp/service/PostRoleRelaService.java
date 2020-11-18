package com.interapi.app.bmp.service;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.PostRoleRela;

import java.util.List;

public interface PostRoleRelaService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    List<PostRoleRela> getListByPostId(Long postId);

    void updatePostRoleRela(Long postId, String roleList);
}