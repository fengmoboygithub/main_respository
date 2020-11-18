package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.AuthorityTab;
import com.interapi.app.bmp.model.AuthorityTabExample;
import com.interapi.app.bmp.service.AuthorityTabService;
import com.interapi.app.bmp.dao.AuthorityTabMapper;

@Service
public class AuthorityTabServiceImpl implements AuthorityTabService{

    private static final Logger logger = LoggerFactory.getLogger(AuthorityTabServiceImpl.class);

    @Autowired
    private AuthorityTabMapper mapper;

    @Override
    public AuthorityTab getAuthorityTab(Long id) {

        AuthorityTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getAuthorityTab]delete AuthorityTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(AuthorityTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addAuthorityTab]add AuthorityTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(AuthorityTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateAuthorityTab]update AuthorityTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteAuthorityTab]delete AuthorityTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(AuthorityTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteAuthorityTab]deleteByExample AuthorityTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(AuthorityTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<AuthorityTab> getListByPage(int currentPage, int itemsPerPage, AuthorityTabExample example) {
       
        List<AuthorityTab> list = null;
        PageInfo<AuthorityTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<AuthorityTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<AuthorityTab> getList(AuthorityTabExample example) {
    
        return mapper.selectByExample(example);
        
    }

	@Override
	public List<AuthorityTab> getAuthorityTabListByUserId(Long userId) {
		return mapper.getAuthorityTabListByUserId(userId);
	}
}