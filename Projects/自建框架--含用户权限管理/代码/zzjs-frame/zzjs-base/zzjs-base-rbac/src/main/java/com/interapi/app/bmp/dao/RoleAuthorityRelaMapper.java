package com.interapi.app.bmp.dao;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.RoleAuthorityRela;
import com.interapi.app.bmp.model.RoleAuthorityRelaExample;

import java.util.List;

public interface RoleAuthorityRelaMapper extends IBaseDao<RoleAuthorityRela, RoleAuthorityRelaExample>{

    List<RoleAuthorityRela> getListByRoleId(Long roleId);

    void deleteByRoleId(Long roleId);

    void insertBatch(List<RoleAuthorityRela> list);
}