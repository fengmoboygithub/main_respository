package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.FunctionTab;
import com.interapi.app.bmp.model.FunctionTabExample;
import com.interapi.app.bmp.service.FunctionTabService;
import com.interapi.app.bmp.dao.FunctionTabMapper;

@Service
public class FunctionTabServiceImpl implements FunctionTabService{

    private static final Logger logger = LoggerFactory.getLogger(FunctionTabServiceImpl.class);

    @Autowired
    private FunctionTabMapper mapper;

    @Override
    public FunctionTab getFunctionTab(Long id) {

        FunctionTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getFunctionTab]delete FunctionTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(FunctionTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addFunctionTab]add FunctionTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(FunctionTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateFunctionTab]update FunctionTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteFunctionTab]delete FunctionTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(FunctionTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteFunctionTab]deleteByExample FunctionTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(FunctionTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<FunctionTab> getListByPage(int currentPage, int itemsPerPage, FunctionTabExample example) {
       
        List<FunctionTab> list = null;
        PageInfo<FunctionTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<FunctionTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<FunctionTab> getList(FunctionTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}