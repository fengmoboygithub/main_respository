package com.interapi.app.bmp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.AuthenticationException;

import com.interapi.app.bmp.model.UserTab;

/**
 * 认证接口服务类
 * @author yangyanchao
 *
 */
public interface AuthService {
	/**
	 * 登陆操作相关
	 * @param username
	 * @param password
	 * @return
	 */
	Map<String,String> login(String username, String password);
    /**
     * 注册操作相关
     * @param userToAdd
     * @return
     * @throws AuthenticationException
     */
    UserTab register(UserTab userToAdd) throws AuthenticationException;
    
    /**
     * 登出操作相关
     * @param request
     * @return
     */
    void logout(HttpServletRequest request);
}
