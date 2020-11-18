package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.DataSourceTab;
import com.interapi.app.bmp.model.DataSourceTabExample;
import com.interapi.app.bmp.service.DataSourceTabService;
import com.interapi.app.bmp.dao.DataSourceTabMapper;

@Service
public class DataSourceTabServiceImpl implements DataSourceTabService{

    private static final Logger logger = LoggerFactory.getLogger(DataSourceTabServiceImpl.class);

    @Autowired
    private DataSourceTabMapper mapper;

    @Override
    public DataSourceTab getDataSourceTab(Long id) {

        DataSourceTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getDataSourceTab]delete DataSourceTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(DataSourceTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addDataSourceTab]add DataSourceTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(DataSourceTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateDataSourceTab]update DataSourceTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteDataSourceTab]delete DataSourceTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(DataSourceTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteDataSourceTab]deleteByExample DataSourceTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(DataSourceTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<DataSourceTab> getListByPage(int currentPage, int itemsPerPage, DataSourceTabExample example) {
       
        List<DataSourceTab> list = null;
        PageInfo<DataSourceTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<DataSourceTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<DataSourceTab> getList(DataSourceTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}