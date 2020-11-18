package com.interapi.app.auth.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.interapi.app.auth.model.LoginUser;
import com.interapi.app.authorize.MySimpleGrantedAuthority;
import com.interapi.app.bmp.dao.AuthorityTabMapper;
import com.interapi.app.bmp.dao.ResourceTabMapper;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.AuthorityTab;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;

@Service
public class LoginUserServiceImpl implements UserDetailsService{

    @Autowired
    private UserTabMapper mapper;
    
    @Autowired
    private AuthorityTabMapper authorityTabMapper;
    
    @Autowired
    private ResourceTabMapper resourceTabMapper;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UserTabExample example = new UserTabExample();
		example.createCriteria().andAccountEqualTo(s);
		List<UserTab> list = mapper.selectByExample(example);
		if(list == null || list.size() == 0){
			throw new UsernameNotFoundException("用户不存在");
		}
		UserTab userTab = new UserTab();
		userTab = list.get(0);
		//通过用户ID获取权限列表
		List<AuthorityTab> authorityList = authorityTabMapper.getAuthorityTabListByUserId(userTab.getId());
		List<MySimpleGrantedAuthority> authorities = new ArrayList<MySimpleGrantedAuthority>();
        for (AuthorityTab authority : authorityList) {
        	authorities.add(new MySimpleGrantedAuthority(authority.getFlag()));
        }
        LoginUser loginUser = new LoginUser();  
        loginUser.setId(userTab.getId());  
        loginUser.setName(userTab.getName());
        loginUser.setAccount(userTab.getAccount());
        loginUser.setUsername(userTab.getAccount());
        loginUser.setPassword(userTab.getPassword());
        loginUser.setMobile(userTab.getMobile());
        loginUser.setEmail(userTab.getEmail());
        loginUser.setAuthorityList(authorityList);
        loginUser.setAuthorities(authorities);
        return loginUser;
	}
	public List<ResourceTab> getResourceTabListByUserName(String name) throws UsernameNotFoundException  {
		UserTabExample example = new UserTabExample();
		example.createCriteria().andAccountEqualTo(name);
		List<UserTab> list = mapper.selectByExample(example);
		if(list == null || list.size() == 0){
			throw new UsernameNotFoundException("用户不存在");
		}
		UserTab userTab = new UserTab();
		userTab = list.get(0);
		//通过用户ID获取接口资源列表
		return resourceTabMapper.getResourceTabListByUserId(userTab.getId());
	}
}