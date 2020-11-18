package com.company.login.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.bean.ResponseDataModel;
import com.company.constant.BaseConstant;
import com.company.login.service.LoginService;
import com.company.userinfo.model.UserTab;
import com.company.userinfo.model.UserTabExample;
import com.google.code.kaptcha.impl.DefaultKaptcha;

/**
 * 登录、登出等相关操作Action类
 * @author yangyanchao
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {

	public static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 验证码
	 */
	@Autowired
	private DefaultKaptcha captchaProducer;
	
	@Autowired
    private LoginService<UserTab, UserTabExample> service;
	
	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "captcha.htm", method = RequestMethod.GET)
	public void captcha(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

	/**
	 * 转到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request) {
		return "/login";
	}

	/**
	 * 登出操作转到登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(BaseConstant.LOGIN_KEY);
		return "redirect:/login.htm";
	}

	/**
	 * 登录操作
	 * @param name
	 * @param password
	 * @param captcha
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login.json", method = RequestMethod.POST)
	public ResponseDataModel<String> login(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "captcha") String captcha,
			HttpServletRequest request) {
		ResponseDataModel<String> json = new ResponseDataModel<String>();

		try {
			String kaptcha = (String) request.getSession().getAttribute(
					com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if (StringUtils.isEmpty(password)) {
				json.getErrors().put("password", "密码不能为空");
			} else if (password.length() < 6 && password.length() > 30) {
				json.getErrors().put("password", "密码最少6个字符，最多30个字符");
			}
			// 校验验证码
			if (!StringUtils.isEmpty(kaptcha)
					&& kaptcha.equalsIgnoreCase(captcha)) {

			} else {
				json.getErrors().put("captcha", "验证码错误");
			}
			json.check();

			service.login(name, password, request);

		} catch (Exception e) {
			// 异常，重置验证码
			request.getSession().removeAttribute(
					com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			json.setSuccess(false);
			json.getErrors().put("password", "邮箱或密码错误");
			json.setMessage("change_captcha");
		}
		return json;
	}
}
