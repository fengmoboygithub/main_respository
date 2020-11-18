package com.company.login.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.company.base.example.BaseExample;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.exception.AuthException;

/**
 * 登陆登出相关操作接口类
 * @author yangyanchao
 *
 * @param <T>
 * @param <E>
 */
public interface LoginService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
	/**
	 * 登陆操作
	 * @param name
	 * @param password
	 * @param request
	 * @throws AuthException
	 */
	public Map<String, Object> login(String name, String password,
			HttpServletRequest request) throws AuthException;
}