package com.interapi.app.bmp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.interapi.app.authorize.MySimpleGrantedAuthority;
import com.interapi.app.bmp.dao.RoleTabMapper;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.LoginUser;
import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;

@Service
public class LoginUserServiceImpl implements UserDetailsService{

    @Autowired
    private UserTabMapper mapper;
    
    @Autowired
    private RoleTabMapper roleTabMapper;

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
		//通过用户ID获取角色列表
		List<RoleTab> roleList = roleTabMapper.getRoleTabListByUserId(userTab.getId());
		List<MySimpleGrantedAuthority> authorities = new ArrayList<MySimpleGrantedAuthority>();
        for (RoleTab role : roleList) {
        	authorities.add(new MySimpleGrantedAuthority(role.getFlag()));
        }
        LoginUser loginUser = new LoginUser();  
        loginUser.setId(userTab.getId());  
        loginUser.setName(userTab.getName());
        loginUser.setAccount(userTab.getAccount());
        loginUser.setUsername(userTab.getAccount());
        loginUser.setPassword(userTab.getPassword());
        loginUser.setMobile(userTab.getMobile());
        loginUser.setEmail(userTab.getEmail());
        loginUser.setRoleList(roleList);
        loginUser.setAuthorities(authorities);
//        loginUser.setLastPasswordResetDate(userTab.getLastPasswordResetDate());
        return loginUser;
	}
	public static void main(String[] args) {
		BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
		String pp = "root";
		String ppencode = bp.encode(pp);
		System.out.println(ppencode);
		System.out.println(ppencode.length());
	}
}