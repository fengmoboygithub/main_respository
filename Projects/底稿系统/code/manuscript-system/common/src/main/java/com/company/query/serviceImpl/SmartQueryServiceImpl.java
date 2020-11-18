package com.company.query.serviceImpl;

import com.company.base.exception.BaseException;
import com.company.query.dao.SmartQueryMapper;
import com.company.query.model.SmartQueryModel;
import com.company.query.model.SmartQueryModelExample;
import com.company.query.service.SmartQueryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * SmartQueryServiceImpl.java
 * @Title: 自定义查询公共Service 接口实现类<br>
 * @author zengsy
 * 2017年4月9日 下午3:54:14
 * @modifier zengsy
 * 2017年4月9日 下午3:54:14
 * @Description:
 */
@Service("smartQueryService")
public class SmartQueryServiceImpl implements SmartQueryService {

    @Resource
    SmartQueryMapper mapper;



    @Override
    public List<SmartQueryModel> findList(String sql,SmartQueryModelExample example) {
        if (StringUtils.isEmpty(example)) example = new SmartQueryModelExample();
        //查询结果列表
        List<SmartQueryModel> list = this.mapper.select(sql, example);
        //返回对象
        return list;
    }
}
