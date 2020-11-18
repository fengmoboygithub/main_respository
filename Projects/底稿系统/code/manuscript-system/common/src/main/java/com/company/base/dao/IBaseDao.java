package com.company.base.dao;

import com.company.base.example.BaseExample;
import com.company.base.model.BaseModel;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author yangyanchao
 * 基类DAO 处理CRUD操作数据库
 * @param <T>
 */
public interface IBaseDao<T extends BaseModel,E extends BaseExample> {
   /*****************CRUD操作*******************************************/
   /**
    *	 根据查询条件统计数量
    */
   long countByExample(E example);

   /**
    * 	根据查询条件删除实体
    */
   int deleteByExample(E example);

   /**
    * 	根据主键删除实体
    */
   int deleteByPrimaryKey(Serializable id);

   /**
    * 	新增所有字段
    */
   int insert(T record);

   /**
    * 	新增不为空的字段
    */
   int insertSelective(T record);

   /**
    * 	根据Example类查询实体
    */
   List<T> selectByExample(E example);

   /**
    * 	根据Example类查询实体
    */
   List<T> selectByExampleWithBLOBs(E example);

   /**
    * 	根据主键查询实体
    */
   T selectByPrimaryKey(Serializable id);

   /**
    * 	根据查询条件及Example类修改实体只更新不为空的字段
    */
   int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

   /**
    * 	根据查询条件及Example类修改实体每个字段都要更新
    */
   int updateByExample(@Param("record") T record, @Param("example")E example);

   /**
    * 	根据查询条件修改实体
    */
   int updateByPrimaryKeySelective(T record);

   /**
    * 	根据主键修改实体
    */
   int updateByPrimaryKey(T record);
   
   /**
    *	批量删除信息
    * @param keyList
    */
   int batchDeleteByPrimaryKey(@Param("keyList")List<Map<String, Object>> keyList);
   
   /**
    * 	自定义查询<br>
    * 
    * @param sql 不包含排序的完整SQL语句否则会报错<br>
    * @param example
    * @return 
    */
   List<T> select(@Param("sql") String sql, @Param("example") E example);

}