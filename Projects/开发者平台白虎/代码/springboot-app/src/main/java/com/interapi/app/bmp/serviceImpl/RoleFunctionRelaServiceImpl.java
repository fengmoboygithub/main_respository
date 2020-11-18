package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.RoleFunctionRela;
import com.interapi.app.bmp.model.RoleFunctionRelaExample;
import com.interapi.app.bmp.service.RoleFunctionRelaService;
import com.interapi.app.bmp.dao.RoleFunctionRelaMapper;

@Service
public class RoleFunctionRelaServiceImpl implements RoleFunctionRelaService{

    private static final Logger logger = LoggerFactory.getLogger(RoleFunctionRelaServiceImpl.class);

    @Autowired
    private RoleFunctionRelaMapper mapper;

    @Override
    public RoleFunctionRela getRoleFunctionRela(Long id) {

        RoleFunctionRela model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getRoleFunctionRela]delete RoleFunctionRela id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(RoleFunctionRela model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addRoleFunctionRela]add RoleFunctionRela={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(RoleFunctionRela model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateRoleFunctionRela]update RoleFunctionRela={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteRoleFunctionRela]delete RoleFunctionRela id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(RoleFunctionRelaExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteRoleFunctionRela]deleteByExample RoleFunctionRela example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(RoleFunctionRelaExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<RoleFunctionRela> getListByPage(int currentPage, int itemsPerPage, RoleFunctionRelaExample example) {
       
        List<RoleFunctionRela> list = null;
        PageInfo<RoleFunctionRela> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<RoleFunctionRela>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<RoleFunctionRela> getList(RoleFunctionRelaExample example) {
    
        return mapper.selectByExample(example);
        
    }
}