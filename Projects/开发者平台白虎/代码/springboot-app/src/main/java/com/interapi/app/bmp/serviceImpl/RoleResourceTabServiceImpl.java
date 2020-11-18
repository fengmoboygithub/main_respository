package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.RoleResourceTab;
import com.interapi.app.bmp.model.RoleResourceTabExample;
import com.interapi.app.bmp.service.RoleResourceTabService;
import com.interapi.app.bmp.dao.RoleResourceTabMapper;

@Service
public class RoleResourceTabServiceImpl implements RoleResourceTabService{

    private static final Logger logger = LoggerFactory.getLogger(RoleResourceTabServiceImpl.class);

    @Autowired
    private RoleResourceTabMapper mapper;

    @Override
    public RoleResourceTab getRoleResourceTab(Long id) {

        RoleResourceTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getRoleResourceTab]delete RoleResourceTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(RoleResourceTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addRoleResourceTab]add RoleResourceTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(RoleResourceTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateRoleResourceTab]update RoleResourceTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteRoleResourceTab]delete RoleResourceTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(RoleResourceTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteRoleResourceTab]deleteByExample RoleResourceTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(RoleResourceTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<RoleResourceTab> getListByPage(int currentPage, int itemsPerPage, RoleResourceTabExample example) {
       
        List<RoleResourceTab> list = null;
        PageInfo<RoleResourceTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<RoleResourceTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<RoleResourceTab> getList(RoleResourceTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}