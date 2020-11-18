package com.company.base.service;
import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


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
     * 	根据主键查询单个记录
     * @param id
     * @return
     * @throws BaseException
     */
    T get(Serializable id) throws BaseException;
    /**
     * 	新增数据
     * @param model
     * @throws BaseException
     */
    void save(T model) throws BaseException;
    /**
     * 	更新数据
     * @param model
     * @throws BaseException
     */
    void update(T model) throws BaseException;

    /**
     * 	根据查询条件及Example类修改实体只更新不为空的字段
     */
    void updateByExampleSelective(T record, E example) throws BaseException;
    
	/**
	 * 	根据主键删除数据
	 * @param id
	 * @throws BaseException
	 */
	void deleteByPrimaryKey(Serializable id) throws BaseException;
	
    /**
     * 	删除数据根据条件
     * @param example
     * @throws BaseException
     */
    void deleteByExample(E example) throws BaseException;
	
	/**
	 * 	根据条件统计数目
	 * @param example
	 * @return
	 * @throws BaseException
	 */
	long countByExample(E example) throws BaseException;
	
    /**
     * 	根据对象分页查询多条记录
     * @param currentPage  起始页目
     * @param itemsPerPage 每页最多显示条目
     * @param itemsPerPage
     * @param example
     * @return
     * @throws BaseException
     */
    PageInfo<T> getListByPage(int currentPage, int itemsPerPage, E example) throws BaseException;

    /**
     * 	根据对象分页查询多条记录
     * @param currentPage  起始页目
     * @param itemsPerPage 每页最多显示条目
     * @param itemsPerPage
     * @param example
     * @return
     * @throws BaseException
     */
    PageInfo<T> getListByPageWithBlobs(int currentPage, int itemsPerPage, E example) throws BaseException;
	
    /**
     * 	根据对象分页查询多条记录
     * @param currentPage  起始页目
     * @param itemsPerPage 每页最多显示条目
     * @param sql 不包含排序的完整SQL语句否则会报错<br>
     * @param itemsPerPage
     * @param example
     * @return
     * @throws BaseException
     */
    PageInfo<T> getListByPage(int currentPage, int itemsPerPage, String sql, E example) throws BaseException;

    /**
     * 	根据对象查询多条记录
     * @param example
     * @return
     * @throws BaseException
     */
    List<T> getList(E example) throws BaseException;
    
    /**
     * 	自定义查询<br>
     * 
     * @param sql 不包含排序的完整SQL语句否则会报错<br>
     * @param example
     * @return 
     * 2017年4月9日
     */
    public List<T> select(String sql,E example) throws BaseException;

    /**
     *	批量删除信息
     * @param keyList
     * @throws BaseException
     */
    void batchDeleteByPrimaryKey(List<Map<String, Object>> keyList) throws BaseException;
    
    /**
     *	批量添加信息
     * @param itemList
     * @throws BaseException
     */
    int batchInsert(List<T> itemList, String mapperClass) throws BaseException;
    
}
