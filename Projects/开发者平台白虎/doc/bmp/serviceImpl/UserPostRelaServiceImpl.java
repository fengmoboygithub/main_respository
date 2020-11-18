package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.UserPostRela;
import com.interapi.app.bmp.model.UserPostRelaExample;
import com.interapi.app.bmp.service.UserPostRelaService;
import com.interapi.app.bmp.dao.UserPostRelaMapper;

@Service
public class UserPostRelaServiceImpl implements UserPostRelaService{

    private static final Logger logger = LoggerFactory.getLogger(UserPostRelaServiceImpl.class);

    @Autowired
    private UserPostRelaMapper mapper;

    @Override
    public UserPostRela getUserPostRela(Long id) {

        UserPostRela model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getUserPostRela]delete UserPostRela id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(UserPostRela model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addUserPostRela]add UserPostRela={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(UserPostRela model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateUserPostRela]update UserPostRela={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteUserPostRela]delete UserPostRela id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(UserPostRelaExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteUserPostRela]deleteByExample UserPostRela example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(UserPostRelaExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<UserPostRela> getListByPage(int currentPage, int itemsPerPage, UserPostRelaExample example) {
       
        List<UserPostRela> list = null;
        PageInfo<UserPostRela> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<UserPostRela>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<UserPostRela> getList(UserPostRelaExample example) {
    
        return mapper.selectByExample(example);
        
    }
}