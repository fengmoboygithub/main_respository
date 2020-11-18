package com.interapi.app.bmp.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.DataSourceTab;
import com.interapi.app.bmp.model.DataSourceTabExample;


public interface DataSourceTabService {
	/**
	 * 根据id查询单个记录
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 * @throws
	 */
    DataSourceTab getDataSourceTab(Long id);
	/**
	 * 插入数据
	 *
	 * @param model
	 * @return
	 * @throws
	 */
    void save(DataSourceTab model);
	/**
	 * 更新数据
	 *
	 * @param model
	 * @return
	 * @throws
	 */
    void update(DataSourceTab model);
    
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
    void deleteByExample(DataSourceTabExample example);
	
	/**
	 * 根据条件统计数目
	 *
	 * @param example
	 * @throws Exception
	 * @throws
	 */
	long countByExample(DataSourceTabExample example);
	
	/**
	 * 根据对象分页查询多条记录
	 * @param start        起始页目
	 * @param itemsPerPage 每页最多显示条目
	 * @param example
	 * @return
	 */
    PageInfo<DataSourceTab> getListByPage(int currentPage, int itemsPerPage, DataSourceTabExample example);
	
	/**
	 * 根据对象查询多条记录
	 * @param example
	 * @return
	 */
    List<DataSourceTab> getList(DataSourceTabExample example);
    

}