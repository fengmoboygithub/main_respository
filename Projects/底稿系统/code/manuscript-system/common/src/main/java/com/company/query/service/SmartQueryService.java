package com.company.query.service;

import com.company.query.model.SmartQueryModel;
import com.company.query.model.SmartQueryModelExample;

import java.util.List;


/**
 *
 * 
 * SmartQueryService.java
 * @Title: 自定义查询公共Service 接口<br>
 * @author zgl
 * 2020年5月10日 下午3:50:20
 * @Description:
 */
public interface SmartQueryService {


    /**
     * 查询，不分页<br>
     * @param sql 自定义SQL<br>
     * @param ex
     * @return 
     * zgl
     * 2020年5月10日
     */
    public List<SmartQueryModel> findList(String sql,SmartQueryModelExample ex);

}
