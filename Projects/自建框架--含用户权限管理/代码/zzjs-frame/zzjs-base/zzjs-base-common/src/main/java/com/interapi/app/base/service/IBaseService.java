package com.interapi.app.base.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.base.model.BaseModel;


/**
 * @author yangyanchao
 * 基类Service
 * @param <T>
 * @param <E>
 */
@Service
public interface IBaseService<T extends BaseModel,E extends BaseExample> {
    /*****************CRUD操作*******************************************/
    /**
     * 根据主键查询单个记录
     * @param id
     * @return
     * @throws BaseException
     */
    T get(Long id) throws BaseException;
    /**
     * 新增数据
     * @param model
     * @throws BaseException
     */
    void save(T model) throws BaseException;
    /**
     * 更新数据
     * @param model
     * @throws BaseException
     */
    void update(T model) throws BaseException;
    
	/**
	 * 根据主键删除数据
	 * @param id
	 * @throws BaseException
	 */
	void deleteByPrimaryKey(Long id) throws BaseException;
	
    /**
     * 删除数据根据条件
     * @param example
     * @throws BaseException
     */
    void deleteByExample(E example) throws BaseException;
	
	/**
	 * 根据条件统计数目
	 * @param example
	 * @return
	 * @throws BaseException
	 */
	long countByExample(E example) throws BaseException;
	
    /**
     * 根据对象分页查询多条记录
     * @param currentPage  起始页目
     * @param itemsPerPage 每页最多显示条目
     * @param itemsPerPage
     * @param example
     * @return
     * @throws BaseException
     */
    PageInfo<T> getListByPage(int currentPage, int itemsPerPage, E example) throws BaseException;
	
    /**
     * 根据对象查询多条记录
     * @param example
     * @return
     * @throws BaseException
     */
    List<T> getList(E example) throws BaseException;
}
