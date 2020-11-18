package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.ModularTab;
import com.interapi.app.bmp.model.ModularTabExample;
import com.interapi.app.bmp.service.ModularTabService;
import com.interapi.app.bmp.dao.ModularTabMapper;

@Service
public class ModularTabServiceImpl implements ModularTabService{

    private static final Logger logger = LoggerFactory.getLogger(ModularTabServiceImpl.class);

    @Autowired
    private ModularTabMapper mapper;

    @Override
    public ModularTab getModularTab(Long id) {

        ModularTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getModularTab]delete ModularTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(ModularTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addModularTab]add ModularTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(ModularTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateModularTab]update ModularTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteModularTab]delete ModularTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(ModularTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteModularTab]deleteByExample ModularTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(ModularTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<ModularTab> getListByPage(int currentPage, int itemsPerPage, ModularTabExample example) {
       
        List<ModularTab> list = null;
        PageInfo<ModularTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<ModularTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<ModularTab> getList(ModularTabExample example) {
    
        return mapper.selectByExample(example);
        
    }

	@Override
	public List<ModularTab> getModularTabListByUserId(Long userId) {
		return mapper.getModularTabListByUserId(userId);
	}
}