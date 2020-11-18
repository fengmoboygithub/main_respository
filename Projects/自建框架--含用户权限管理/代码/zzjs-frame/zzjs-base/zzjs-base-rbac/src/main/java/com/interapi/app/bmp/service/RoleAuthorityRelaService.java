package com.interapi.app.bmp.service;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;
import com.interapi.app.base.service.IBaseService;
import com.interapi.app.bmp.model.RoleAuthorityRela;

import java.util.List;

public interface RoleAuthorityRelaService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    List<RoleAuthorityRela> getListByRoleId(Long roleId);

    void updateRoleAuthorityRela(Long roleId, String authorityList);
}