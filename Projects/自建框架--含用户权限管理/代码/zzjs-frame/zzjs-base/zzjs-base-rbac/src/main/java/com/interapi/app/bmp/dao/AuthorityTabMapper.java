package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.AuthorityTab;
import com.interapi.app.bmp.model.AuthorityTabExample;
public interface AuthorityTabMapper extends IBaseDao<AuthorityTab, AuthorityTabExample>{
	/**
     * 通过用户ID获取权限列表
     * @param id
     * @return
     */
    List<AuthorityTab> getAuthorityTabListByUserId(@Param("id") Long id);
}