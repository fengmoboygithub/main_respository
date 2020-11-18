package com.interapi.app.bmp.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.PageTab;
import com.interapi.app.bmp.model.PageTabExample;


public interface PageTabService {
	/**
	 * 根据id查询单个记录
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 * @throws
	 */
    PageTab getPageTab(Long id);
	/**
	 * 插入数据
	 *
	 * @param model
	 * @return
	 * @throws
	 */
    void save(PageTab model);
	/**
	 * 更新数据
	 *
	 * @param model
	 * @return
	 * @throws
	 */
    void update(PageTab model);
    
    /**
	 * 根据ID删除数据
	 *
	 * @param id
	 * @throws Exception
	 * @throws
	 */
	void deleteByPrimaryKey(Long id);
	
	/**
	 * 删除数据根据条件
	 *
	 * @param example
	 * @throws Exception
	 * @throws
	 */
    void deleteByExample(PageTabExample example);
	
	/**
	 * 根据条件统计数目
	 *
	 * @param example
	 * @throws Exception
	 * @throws
	 */
	long countByExample(PageTabExample example);
	
	/**
	 * 根据对象分页查询多条记录
	 * @param start        起始页目
	 * @param itemsPerPage 每页最多显示条目
	 * @param example
	 * @return
	 */
    PageInfo<PageTab> getListByPage(int currentPage, int itemsPerPage, PageTabExample example);
	
	/**
	 * 根据对象查询多条记录
	 * @param example
	 * @return
	 */
    List<PageTab> getList(PageTabExample example);
    
    /**
	 * 通过用户Token值获取菜单页面列表
	 * @param token
	 * @return
	 */
	List<PageTab> getPageTabListByUserId(String token);
	
	/**
	 * 通过用户ID获取菜单页面列表
	 * @param userId
	 * @return
	 */
	List<PageTab> getPageTabListByUserId(Long userId);
	
	
    

}