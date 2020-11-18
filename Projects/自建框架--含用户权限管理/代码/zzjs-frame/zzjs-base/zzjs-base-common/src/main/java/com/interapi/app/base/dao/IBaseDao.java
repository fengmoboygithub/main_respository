package com.interapi.app.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.base.example.BaseExample;
import com.interapi.app.base.model.BaseModel;

/**
 * @author yangyanchao
 * 基类DAO 处理CRUD操作数据库
 * @param <T>
 */
public interface IBaseDao<T extends BaseModel,E extends BaseExample> {
   /*****************CRUD操作*******************************************/
   /**
    * 根据查询条件统计数量
    */
   long countByExample(E example);

   /**
    * 根据查询条件删除实体
    */
   int deleteByExample(E example);

   /**
    * 根据主键删除实体
    */
   int deleteByPrimaryKey(Long id);

   /**
    * 新增所有字段
    */
   int insert(T record);

   /**
    * 新增不为空的字段
    */
   int insertSelective(T record);

   /**
    * 根据Example类查询实体
    */
   List<T> selectByExample(E example);

   /**
    * 根据主键查询实体
    */
   T selectByPrimaryKey(Long id);

   /**
    * 根据查询条件及Example类修改实体只更新不为空的字段
    */
   int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

   /**
    * 根据查询条件及Example类修改实体每个字段都要更新
    */
   int updateByExample(@Param("record") T record, @Param("example")E example);

   /**
    * 根据查询条件修改实体
    */
   int updateByPrimaryKeySelective(T record);

   /**
    * 根据主键修改实体
    */
   int updateByPrimaryKey(T record);
}