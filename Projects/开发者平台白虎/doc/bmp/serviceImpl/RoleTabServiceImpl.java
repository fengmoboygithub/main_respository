package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.RoleTabExample;
import com.interapi.app.bmp.service.RoleTabService;
import com.interapi.app.bmp.dao.RoleTabMapper;

@Service
public class RoleTabServiceImpl implements RoleTabService{

    private static final Logger logger = LoggerFactory.getLogger(RoleTabServiceImpl.class);

    @Autowired
    private RoleTabMapper mapper;

    @Override
    public RoleTab getRoleTab(Long id) {

        RoleTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getRoleTab]delete RoleTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(RoleTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addRoleTab]add RoleTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(RoleTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateRoleTab]update RoleTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteRoleTab]delete RoleTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(RoleTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteRoleTab]deleteByExample RoleTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(RoleTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<RoleTab> getListByPage(int currentPage, int itemsPerPage, RoleTabExample example) {
       
        List<RoleTab> list = null;
        PageInfo<RoleTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<RoleTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<RoleTab> getList(RoleTabExample example) {
    
        return mapper.selectByExample(example);
        
    }

	@Override
	public List<RoleTab> getRoleTabListByUserId(Long userId) {
		return mapper.getRoleTabListByUserId(userId);
	}
}