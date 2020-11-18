package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.AuthorityPageRela;
import com.interapi.app.bmp.model.AuthorityPageRelaExample;
import com.interapi.app.bmp.service.AuthorityPageRelaService;
import com.interapi.app.bmp.dao.AuthorityPageRelaMapper;

@Service
public class AuthorityPageRelaServiceImpl implements AuthorityPageRelaService{

    private static final Logger logger = LoggerFactory.getLogger(AuthorityPageRelaServiceImpl.class);

    @Autowired
    private AuthorityPageRelaMapper mapper;

    @Override
    public AuthorityPageRela getAuthorityPageRela(Long id) {

        AuthorityPageRela model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getAuthorityPageRela]delete AuthorityPageRela id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(AuthorityPageRela model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addAuthorityPageRela]add AuthorityPageRela={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(AuthorityPageRela model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateAuthorityPageRela]update AuthorityPageRela={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteAuthorityPageRela]delete AuthorityPageRela id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(AuthorityPageRelaExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteAuthorityPageRela]deleteByExample AuthorityPageRela example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(AuthorityPageRelaExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<AuthorityPageRela> getListByPage(int currentPage, int itemsPerPage, AuthorityPageRelaExample example) {
       
        List<AuthorityPageRela> list = null;
        PageInfo<AuthorityPageRela> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<AuthorityPageRela>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<AuthorityPageRela> getList(AuthorityPageRelaExample example) {
    
        return mapper.selectByExample(example);
        
    }
}