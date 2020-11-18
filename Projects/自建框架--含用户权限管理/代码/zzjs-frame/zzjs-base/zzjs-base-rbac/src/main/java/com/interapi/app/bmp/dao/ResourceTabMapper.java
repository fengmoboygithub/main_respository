package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.ResourceTabExample;
public interface ResourceTabMapper extends IBaseDao<ResourceTab, ResourceTabExample>{
	/**
     * 通过用户ID获取接口资源列表
     * @param id
     * @return
     */
    List<ResourceTab> getResourceTabListByUserId(@Param("id") Long id);
}