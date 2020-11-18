package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.ResourceTabExample;
import com.interapi.app.bmp.service.ResourceTabService;
import com.interapi.app.bmp.dao.ResourceTabMapper;

@Service
public class ResourceTabServiceImpl implements ResourceTabService{

    private static final Logger logger = LoggerFactory.getLogger(ResourceTabServiceImpl.class);

    @Autowired
    private ResourceTabMapper mapper;

    @Override
    public ResourceTab getResourceTab(Long id) {

        ResourceTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getResourceTab]delete ResourceTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(ResourceTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addResourceTab]add ResourceTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(ResourceTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateResourceTab]update ResourceTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteResourceTab]delete ResourceTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(ResourceTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteResourceTab]deleteByExample ResourceTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(ResourceTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<ResourceTab> getListByPage(int currentPage, int itemsPerPage, ResourceTabExample example) {
       
        List<ResourceTab> list = null;
        PageInfo<ResourceTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<ResourceTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<ResourceTab> getList(ResourceTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}