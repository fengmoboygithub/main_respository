package com.interapi.app.bmp.dao;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.AuthorityResourceRela;
import com.interapi.app.bmp.model.AuthorityResourceRelaExample;

import java.util.List;

public interface AuthorityResourceRelaMapper extends IBaseDao<AuthorityResourceRela, AuthorityResourceRelaExample>{

    List<AuthorityResourceRela> getListByAuthorityId(Long authorityId);

    void deleteByAuthorityId(Long authorityId);

    void insertBatch(List<AuthorityResourceRela> list);
}