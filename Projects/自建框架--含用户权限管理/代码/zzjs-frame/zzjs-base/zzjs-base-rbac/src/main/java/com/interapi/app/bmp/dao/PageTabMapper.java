package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.bmp.model.PageTab;
import com.interapi.app.bmp.model.PageTabExample;
public interface PageTabMapper extends IBaseDao<PageTab, PageTabExample>{
	/**
     * 通过用户ID获取页面列表
     * @param id
     * @return
     */
    List<PageTab> getPageTabListByUserId(@Param("id") Long id);
}