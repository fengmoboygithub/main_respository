package com.interapi.app.bmp.service;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.AuthorityPageRela;

import java.util.List;

public interface AuthorityPageRelaService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    List<AuthorityPageRela> getListByAuthorityId(Long authorityId);

    void updateAuthorityPageRela(Long authorityId, String pageList);
}