package com.company.query.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.company.query.model.SmartQueryModel;
import com.company.query.model.SmartQueryModelExample;


public interface SmartQueryMapper {
    
    /**
     * 	自定义查询<br>
     * 
     * @param sql 不包含排序的完整SQL语句否则会报错<br>
     * @param example
     * @return 
     * 2017年4月9日
     */
    public List<SmartQueryModel> select(@Param("sql") String sql, @Param("example") SmartQueryModelExample example);
    
    /**
     * 	查询存储过程的方法
     * @param map
     */
    public void callProcedure(Map<String,Object> map);
    
    /**
     * 	查询导入数据存储过程的方法
     * @param map
     */
    public Object callProcedureImportData(Map<String,Object> map);
    
    /**
     * 	查询函数的方法
     * @param map
     */
    public void callFunction(Map<String,Object> map);
}
