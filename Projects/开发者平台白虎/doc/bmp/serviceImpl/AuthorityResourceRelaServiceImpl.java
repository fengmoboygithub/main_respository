package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.AuthorityResourceRela;
import com.interapi.app.bmp.model.AuthorityResourceRelaExample;
import com.interapi.app.bmp.service.AuthorityResourceRelaService;
import com.interapi.app.bmp.dao.AuthorityResourceRelaMapper;

@Service
public class AuthorityResourceRelaServiceImpl implements AuthorityResourceRelaService{

    private static final Logger logger = LoggerFactory.getLogger(AuthorityResourceRelaServiceImpl.class);

    @Autowired
    private AuthorityResourceRelaMapper mapper;

    @Override
    public AuthorityResourceRela getAuthorityResourceRela(Long id) {

        AuthorityResourceRela model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getAuthorityResourceRela]delete AuthorityResourceRela id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(AuthorityResourceRela model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addAuthorityResourceRela]add AuthorityResourceRela={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(AuthorityResourceRela model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateAuthorityResourceRela]update AuthorityResourceRela={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteAuthorityResourceRela]delete AuthorityResourceRela id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(AuthorityResourceRelaExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteAuthorityResourceRela]deleteByExample AuthorityResourceRela example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(AuthorityResourceRelaExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<AuthorityResourceRela> getListByPage(int currentPage, int itemsPerPage, AuthorityResourceRelaExample example) {
       
        List<AuthorityResourceRela> list = null;
        PageInfo<AuthorityResourceRela> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<AuthorityResourceRela>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<AuthorityResourceRela> getList(AuthorityResourceRelaExample example) {
    
        return mapper.selectByExample(example);
        
    }
}