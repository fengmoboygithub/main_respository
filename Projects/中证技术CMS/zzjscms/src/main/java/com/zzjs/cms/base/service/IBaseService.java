package com.zzjs.cms.base.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.zzjs.cms.base.entity.BaseModel;
import com.zzjs.cms.exception.BaseException;


/**
 * 基本服务接口
 * @author yangyanchao 
 *
 * @param <T>
 */
@Service
public interface IBaseService<T extends BaseModel> {
    /*****************CRUD操作*******************************************/
    public T selectByPrimaryKey(Object key) throws BaseException;
    public T selectByMaxKey(Object key) throws BaseException;
    public Integer updateByPrimaryKey(T t) throws BaseException;
    public Integer deleteByPrimaryKey(Object key) throws BaseException;
    public Integer insert(T t) throws BaseException;
    public Integer deleteByEntity(T entity) throws BaseException;
    public Integer deleteByPrimaryKeys(Object... keys) throws BaseException ;
    public Integer selectMaxId()throws BaseException ;
    /**************************自定义SQL查询*********************************/
    public List<T> selectBySql(@Param(value = "sql")String sql) throws BaseException;
    public Integer updateBySql(@Param(value = "sql")String sql) throws BaseException;
    public Integer deleteBySql(@Param(value = "sql")String sql) throws BaseException;
    public Integer insertBySql(@Param(value = "sql")String sql) throws BaseException;
    /***********************分页查询操作对象方式*********************************/
    public Integer selectByModelPagingCount(T  model) throws BaseException;
    public List<T> selectByModelPaging(T model) throws BaseException;
    /***********************分页查询操作Map方式*********************************/
    public Integer selectByMapPagingCount(Map<?,?> map) throws BaseException;
    public List<T> selectByMapPaging(Map<?,?> map) throws BaseException;
    /***********************查询不分页****************************************/
    public List<T> selectByEntiry(T entity) throws BaseException;
    public Integer selectByMapCount(Map<?, ?>  map) throws BaseException;
    public List<T> selectByMap(Map<?, ?>  map) throws BaseException;
	
}
