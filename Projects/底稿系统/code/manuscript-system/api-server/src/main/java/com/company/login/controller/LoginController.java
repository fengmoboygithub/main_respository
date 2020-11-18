package com.company.login.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.company.bean.ResponseDataModel;
import com.company.login.service.LoginService;
import com.company.userinfo.model.UserTab;
import com.company.userinfo.model.UserTabExample;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 登录、登出等相关操作Action类
 * @author yangyanchao
 *
 */
@Api(value="登录",tags={"登录"})
@RestController("LoginController")
@RequestMapping("/api/UserControl")
public class LoginController {
    
    
	public static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private LoginService<UserTab, UserTabExample> service;
	

	/**
	 * 登录操作
	 * @param name
	 * @param password
	 * @param captcha
	 * @param request
	 * @return
	 */
	@ApiOperation("登录")
    @PostMapping(value = "/getUserInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
	public ResponseDataModel<String> login(
	        @RequestParam(required = true) @ApiParam(name="username",value="账号",required=true) String username,
	        @RequestParam(required = true) @ApiParam(name="password",value="密码",required=true) String password,
			HttpServletRequest request) {
		ResponseDataModel<String> json = new ResponseDataModel<String>();
		try {
//			String kaptcha = (String) request.getSession().getAttribute(
//					com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if (StringUtils.isEmpty(password)) {
				json.getErrors().put("password", "密码不能为空");
			} else if (password.length() < 8 && password.length() > 20) {
				json.getErrors().put("password", "密码最少8个字符，最多20个字符");
			}
			// 校验验证码
//			if (!StringUtils.isEmpty(kaptcha)
//					&& kaptcha.equalsIgnoreCase(captcha)) {
//
//			} else {
//				json.getErrors().put("captcha", "验证码错误");
//			}
			json.check();
			Map<String, Object> user = service.login(username, password, request);
			String jsonString = JSON.toJSONString(user);
			json.setEntity(jsonString);

		} catch (Exception e) {
			// 异常，重置验证码
//			request.getSession().removeAttribute(
//					com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			json.setSuccess(false);
			json.getErrors().put("msg", e.getLocalizedMessage());
//			json.setMessage("change_captcha");
		}
		return json;
	}
}
