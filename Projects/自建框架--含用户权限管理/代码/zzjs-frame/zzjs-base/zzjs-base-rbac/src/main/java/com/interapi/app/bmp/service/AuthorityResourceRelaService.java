package com.interapi.app.bmp.service;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.AuthorityResourceRela;

import java.util.List;

public interface AuthorityResourceRelaService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    List<AuthorityResourceRela> getListByAuthorityId(Long authorityId);

    void updateAuthorityResourceRela(Long authorityId, String resourceList);
}