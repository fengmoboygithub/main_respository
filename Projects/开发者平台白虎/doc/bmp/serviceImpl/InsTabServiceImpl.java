package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.InsTab;
import com.interapi.app.bmp.model.InsTabExample;
import com.interapi.app.bmp.service.InsTabService;
import com.interapi.app.bmp.dao.InsTabMapper;

@Service
public class InsTabServiceImpl implements InsTabService{

    private static final Logger logger = LoggerFactory.getLogger(InsTabServiceImpl.class);

    @Autowired
    private InsTabMapper mapper;

    @Override
    public InsTab getInsTab(Long id) {

        InsTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getInsTab]delete InsTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(InsTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addInsTab]add InsTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(InsTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateInsTab]update InsTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteInsTab]delete InsTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(InsTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteInsTab]deleteByExample InsTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(InsTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<InsTab> getListByPage(int currentPage, int itemsPerPage, InsTabExample example) {
       
        List<InsTab> list = null;
        PageInfo<InsTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<InsTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<InsTab> getList(InsTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}