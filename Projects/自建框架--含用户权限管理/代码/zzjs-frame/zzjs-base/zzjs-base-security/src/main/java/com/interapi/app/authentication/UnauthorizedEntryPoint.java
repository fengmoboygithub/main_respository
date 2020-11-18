package com.interapi.app.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interapi.app.bean.ResponseModel;
/**
 * 重写 捕获认证异常处理类  默认是跳转登录页面 现在改为输出json登录失败报文（json格式）
 * @author yangyanchao
 *
 */
@Component("unauthorizedEntryPoint")
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
	@Autowired
	private ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(UnauthorizedEntryPoint.class);
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(isAjaxRequest(request)){ 
		  logger.info("认证失败");
          //以Json格式返回
          ResponseModel re = new ResponseModel();
          re.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
          re.setMessage("用户名或密码不正确。");
          re.setSuccess(false);
          response.setStatus(HttpStatus.OK.value());
          response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");   
          response.getWriter().write(objectMapper.writeValueAsString(re));
		} else { 
			response.sendRedirect("/login");
		}
	}
	
	public static boolean isAjaxRequest(HttpServletRequest request) { 
//		String ajaxFlag = request.getHeader("X-Requested-With"); 
//		return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag); 
		return true;
	}
}
