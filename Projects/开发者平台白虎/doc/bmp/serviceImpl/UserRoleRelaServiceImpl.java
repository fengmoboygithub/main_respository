package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.UserRoleRela;
import com.interapi.app.bmp.model.UserRoleRelaExample;
import com.interapi.app.bmp.service.UserRoleRelaService;
import com.interapi.app.bmp.dao.UserRoleRelaMapper;

@Service
public class UserRoleRelaServiceImpl implements UserRoleRelaService{

    private static final Logger logger = LoggerFactory.getLogger(UserRoleRelaServiceImpl.class);

    @Autowired
    private UserRoleRelaMapper mapper;

    @Override
    public UserRoleRela getUserRoleRela(Long id) {

        UserRoleRela model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getUserRoleRela]delete UserRoleRela id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(UserRoleRela model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addUserRoleRela]add UserRoleRela={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(UserRoleRela model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateUserRoleRela]update UserRoleRela={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteUserRoleRela]delete UserRoleRela id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(UserRoleRelaExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteUserRoleRela]deleteByExample UserRoleRela example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(UserRoleRelaExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<UserRoleRela> getListByPage(int currentPage, int itemsPerPage, UserRoleRelaExample example) {
       
        List<UserRoleRela> list = null;
        PageInfo<UserRoleRela> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<UserRoleRela>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<UserRoleRela> getList(UserRoleRelaExample example) {
    
        return mapper.selectByExample(example);
        
    }
}