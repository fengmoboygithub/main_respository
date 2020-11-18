package com.interapi.app.bmp.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.dao.PageTabMapper;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.PageTab;
import com.interapi.app.bmp.model.PageTabExample;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import com.interapi.app.bmp.service.PageTabService;

@Service
public class PageTabServiceImpl extends BaseServiceImpl<PageTab, PageTabExample> implements PageTabService<PageTab, PageTabExample>{

    @Autowired
    private PageTabMapper mapper;
	
	public IBaseDao<PageTab, PageTabExample> getMapper(){
		return mapper;
	}
	
	@Autowired
    private UserTabMapper userTabMapper;
	
	@Override
	public List<PageTab> getPageTabListByUserId(String username) {
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