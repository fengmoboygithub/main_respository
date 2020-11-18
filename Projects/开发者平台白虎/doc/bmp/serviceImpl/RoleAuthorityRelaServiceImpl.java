package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.RoleAuthorityRela;
import com.interapi.app.bmp.model.RoleAuthorityRelaExample;
import com.interapi.app.bmp.service.RoleAuthorityRelaService;
import com.interapi.app.bmp.dao.RoleAuthorityRelaMapper;

@Service
public class RoleAuthorityRelaServiceImpl implements RoleAuthorityRelaService{

    private static final Logger logger = LoggerFactory.getLogger(RoleAuthorityRelaServiceImpl.class);

    @Autowired
    private RoleAuthorityRelaMapper mapper;

    @Override
    public RoleAuthorityRela getRoleAuthorityRela(Long id) {

        RoleAuthorityRela model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getRoleAuthorityRela]delete RoleAuthorityRela id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(RoleAuthorityRela model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addRoleAuthorityRela]add RoleAuthorityRela={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(RoleAuthorityRela model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateRoleAuthorityRela]update RoleAuthorityRela={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteRoleAuthorityRela]delete RoleAuthorityRela id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(RoleAuthorityRelaExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteRoleAuthorityRela]deleteByExample RoleAuthorityRela example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(RoleAuthorityRelaExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<RoleAuthorityRela> getListByPage(int currentPage, int itemsPerPage, RoleAuthorityRelaExample example) {
       
        List<RoleAuthorityRela> list = null;
        PageInfo<RoleAuthorityRela> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<RoleAuthorityRela>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<RoleAuthorityRela> getList(RoleAuthorityRelaExample example) {
    
        return mapper.selectByExample(example);
        
    }
}