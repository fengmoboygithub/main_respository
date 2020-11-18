package com.interapi.app.bmp.dao;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.AuthorityPageRela;
import com.interapi.app.bmp.model.AuthorityPageRelaExample;

import java.util.List;

public interface AuthorityPageRelaMapper extends IBaseDao<AuthorityPageRela, AuthorityPageRelaExample>{

    List<AuthorityPageRela> getListByAuthorityId(Long authorityId);

    void deleteByAuthorityId(Long authorityId);

    void insertBatch(List<AuthorityPageRela> list);
}