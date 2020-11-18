package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.PostRoleRela;
import com.interapi.app.bmp.model.PostRoleRelaExample;
import com.interapi.app.bmp.service.PostRoleRelaService;
import com.interapi.app.bmp.dao.PostRoleRelaMapper;

@Service
public class PostRoleRelaServiceImpl implements PostRoleRelaService{

    private static final Logger logger = LoggerFactory.getLogger(PostRoleRelaServiceImpl.class);

    @Autowired
    private PostRoleRelaMapper mapper;

    @Override
    public PostRoleRela getPostRoleRela(Long id) {

        PostRoleRela model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getPostRoleRela]delete PostRoleRela id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(PostRoleRela model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addPostRoleRela]add PostRoleRela={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(PostRoleRela model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updatePostRoleRela]update PostRoleRela={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deletePostRoleRela]delete PostRoleRela id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(PostRoleRelaExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deletePostRoleRela]deleteByExample PostRoleRela example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(PostRoleRelaExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<PostRoleRela> getListByPage(int currentPage, int itemsPerPage, PostRoleRelaExample example) {
       
        List<PostRoleRela> list = null;
        PageInfo<PostRoleRela> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<PostRoleRela>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<PostRoleRela> getList(PostRoleRelaExample example) {
    
        return mapper.selectByExample(example);
        
    }
}