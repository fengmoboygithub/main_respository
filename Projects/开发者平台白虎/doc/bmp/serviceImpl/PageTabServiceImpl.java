package com.interapi.app.bmp.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.dao.PageTabMapper;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.PageTab;
import com.interapi.app.bmp.model.PageTabExample;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import com.interapi.app.bmp.service.PageTabService;
import com.interapi.app.utils.JwtTokenUtil;

@Service
public class PageTabServiceImpl implements PageTabService{

    private static final Logger logger = LoggerFactory.getLogger(PageTabServiceImpl.class);

    @Autowired
    private PageTabMapper mapper;
    
    @Autowired
    private UserTabMapper userTabMapper;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public PageTab getPageTab(Long id) {

        PageTab model = mapper.selectByPrimaryKey(id);
        if (model == null) {
            logger.error("[getPageTab]delete PageTab id={} fail", id);
            throw new RuntimeException("GET data fail");
        }
        return model;

    }

    @Override
    public void save(PageTab model) {
    
        int success = mapper.insertSelective(model);
        if (success <= 0) {
            logger.error("[addPageTab]add PageTab={} fail",  model.toString());
            throw new RuntimeException("Add data fail");
        }
        return;

    }

    @Override
    public void update(PageTab model) {
    
        int success = mapper.updateByPrimaryKeySelective(model);
        if (success <= 0) {
            logger.error("[updatePageTab]update PageTab={} fail",  model.toString());
            throw new RuntimeException("Modify data fail");
        }
        return;

    }

    @Override
    public void deleteByPrimaryKey(Long id) {

        int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("[deletePageTab]delete PageTab id={} fail", id);
            throw new RuntimeException("Del data fail");
        }
        return;

    }
    
    @Override
    public void deleteByExample(PageTabExample example) {
    
        int success = mapper.deleteByExample(example);
        if (success <= 0) {
            logger.error("[deletePageTab]deleteByExample PageTab example={} fail", example);
            throw new RuntimeException("DeleteByExample data fail");
        }
        return;
    }
    
    @Override
    public long countByExample(PageTabExample example) {
    
        return mapper.countByExample(example);
        
    }

    @Override
    public PageInfo<PageTab> getListByPage(int currentPage, int itemsPerPage, PageTabExample example) {
       
        List<PageTab> list = null;
        PageInfo<PageTab> page = null;
		try {
			PageHelper.startPage(currentPage,itemsPerPage); 
			logger.info("设置第"+currentPage+"页"+itemsPerPage+"条数据!");
			list = mapper.selectByExample(example);
			page = new PageInfo<PageTab>(list);
			logger.info("总共有:"+page.getTotal()+"条数据,实际返回:"+list.size()+"条数据!");
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
		}
		return page;
		
    }

    @Override
    public List<PageTab> getList(PageTabExample example) {
    
        return mapper.selectByExample(example);
        
    }

	@Override
	public List<PageTab> getPageTabListByUserId(String token) {
		String username = jwtTokenUtil.getUsernameFromToken(token);
		List<PageTab> resultList = new ArrayList<PageTab>();
		UserTabExample example = new UserTabExample();
		example.createCriteria().andAccountEqualTo(username);
		List<UserTab> list = userTabMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			UserTab userTab = new UserTab();
			userTab = list.get(0);
			Long id = userTab.getId();
			//通过用户ID获取菜单页面列表
			resultList = mapper.getPageTabListByUserId(id);
			if(resultList != null && resultList.size() > 0){
				List<PageTab> menuList = new ArrayList<PageTab>();
				for(PageTab menuInfo : resultList){
					if(menuInfo.getParentId() == null && "0".equals(menuInfo.getClassify())){
						//查找一级菜单
						menuList.add(menuInfo);
					}
				}
				for(PageTab oneMenuInfo : menuList){
					for(PageTab menuInfo : resultList){
						
						if(menuInfo.getParentId() != null && oneMenuInfo.getId().compareTo(menuInfo.getParentId()) == 0){
							List<PageTab> childList = oneMenuInfo.getChildList();
							if(childList == null) {
								childList = new ArrayList<PageTab>();
								childList.add(menuInfo);
							} else {
								childList.add(menuInfo);
							}
							oneMenuInfo.setChildList(childList);
						}
					}
				}
				Collections.sort(menuList, new Comparator<PageTab>(){
		            public int compare(PageTab o1, PageTab o2) {
		                //按照排序字段升序排列
		                return o1.getSort().compareTo(o2.getSort());
		            }
		        });
				for(PageTab oneMenuInfo : menuList){
					List<PageTab> childList = oneMenuInfo.getChildList();
					if(childList != null) {
						Collections.sort(childList, new Comparator<PageTab>(){
				            public int compare(PageTab o1, PageTab o2) {
				                //按照排序字段升序排列
				                return o1.getSort().compareTo(o2.getSort());
				            }
				        });
						oneMenuInfo.setChildList(childList);
					}
				}
				resultList = menuList;
			}
		}
		return resultList;
	}

	@Override
	public List<PageTab> getPageTabListByUserId(Long userId) {
		return mapper.getPageTabListByUserId(userId);
	}
}