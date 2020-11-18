package com.interapi.app.generator.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.generator.model.ComponentInstanceTab;
import com.interapi.app.generator.model.ComponentInstanceTabExample;
import com.interapi.app.generator.service.ComponentInstanceTabService;
import com.interapi.app.generator.dao.ComponentInstanceTabMapper;

@Service
public class ComponentInstanceTabServiceImpl implements ComponentInstanceTabService{

    private static final Logger logger = LoggerFactory.getLogger(ComponentInstanceTabServiceImpl.class);

    @Autowired
    private ComponentInstanceTabMapper mapper;

    @Override
    public ComponentInstanceTab getComponentInstanceTab(Long id) {

        ComponentInstanceTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getComponentInstanceTab]delete ComponentInstanceTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(ComponentInstanceTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addComponentInstanceTab]add ComponentInstanceTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(ComponentInstanceTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateComponentInstanceTab]update ComponentInstanceTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteComponentInstanceTab]delete ComponentInstanceTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(ComponentInstanceTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteComponentInstanceTab]deleteByExample ComponentInstanceTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(ComponentInstanceTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<ComponentInstanceTab> getListByPage(int currentPage, int itemsPerPage, ComponentInstanceTabExample example) {
       
        List<ComponentInstanceTab> list = null;
        PageInfo<ComponentInstanceTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<ComponentInstanceTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<ComponentInstanceTab> getList(ComponentInstanceTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}