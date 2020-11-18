package com.interapi.app.bmp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.DeptTab;
import com.interapi.app.bmp.model.DeptTabExample;
import com.interapi.app.bmp.service.DeptTabService;
import com.interapi.app.bmp.dao.DeptTabMapper;

@Service
public class DeptTabServiceImpl implements DeptTabService{

    private static final Logger logger = LoggerFactory.getLogger(DeptTabServiceImpl.class);

    @Autowired
    private DeptTabMapper mapper;

    @Override
    public DeptTab getDeptTab(Long id) {

        DeptTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getDeptTab]delete DeptTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(DeptTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addDeptTab]add DeptTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(DeptTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updateDeptTab]update DeptTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deleteDeptTab]delete DeptTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(DeptTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deleteDeptTab]deleteByExample DeptTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(DeptTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<DeptTab> getListByPage(int currentPage, int itemsPerPage, DeptTabExample example) {
       
        List<DeptTab> list = null;
        PageInfo<DeptTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<DeptTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<DeptTab> getList(DeptTabExample example) {
    
        return mapper.selectByExample(example);
        
    }
}