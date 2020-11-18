package com.interapi.app.bmp.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.interapi.app.bmp.dao.ResourceTabMapper;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import com.interapi.app.bmp.service.RbacService;

/**
 * 返回权限验证的实现类  基于RBAC(role-Based-access control)权限控制
 * @author yangyanchao
 *
 */
@Service
public class RbacServiceImpl implements RbacService {
	@Autowired
    private UserTabMapper userTabMapper;
	@Autowired
    private ResourceTabMapper resourceTabMapper;
	
	@Override
	public String[] hasPermissionUrl(Authentication authentication) {
		List<String> urls = new LinkedList<>();
		Object principal = authentication.getPrincipal();
        if (principal != null && principal instanceof UserDetails) { //首先判断先当前用户是否是我们UserDetails对象。
              String userName = ((UserDetails) principal).getUsername();
              UserTabExample example = new UserTabExample();
              example.createCriteria().andAccountEqualTo(userName);
              List<UserTab> list = userTabMapper.selectByExample(example);
              UserTab userTab = list.get(0);
              Long userId = userTab.getId();
              //通过用户ID获取资源列表
      		  List<ResourceTab> resourceList = resourceTabMapper.getResourceTabListByUserId(userId);
      		  // 数据库读取 
      		  //读取用户所拥有权限的所有URL
              // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
              for (ResourceTab resourceTab : resourceList) {
            	  String url = resourceTab.getUri();
            	  urls.add(url);
              }
        }
        return urls.toArray(new String[urls.size()]);
	}

}
