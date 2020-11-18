package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import com.interapi.app.bmp.service.UserTabService;
import com.interapi.app.bmp.dao.UserTabMapper;

@Service
public class UserTabServiceImpl implements UserTabService{

    private static final Logger logger = LoggerFactory.getLogger(UserTabServiceImpl.class);

    @Autowired
    private UserTabMapper mapper;

    @Override
    public UserTab getUserTab(Long id) {

        UserTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getUserTab]delete UserTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(UserTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addUserTab]add UserTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(UserTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateUserTab]update UserTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteUserTab]delete UserTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(UserTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteUserTab]deleteByExample UserTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(UserTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<UserTab> getListByPage(int currentPage, int itemsPerPage, UserTabExample example) {
       
        List<UserTab> list = null;
        PageInfo<UserTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<UserTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<UserTab> getList(UserTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}