/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zzjs.cms.constant.SystemConstant;
import com.zzjs.cms.entity.Admin;
import com.zzjs.cms.util.HttpUtils;

/**
 * 
 * 跨域过滤器
 * 
 * @author yangyanchao
 * 
 */
public class BasicFilter implements Filter {

	protected final Logger logger = Logger.getLogger(this.getClass());

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.addHeader("Access-Control-Allow-Origin", "*");
		// Access-Control-Allow-Methods: 授权请求的方法（GET, POST, PUT, DELETE，OPTIONS等)
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,sessionId");
		response.addHeader("Access-Control-Max-Age", "1800");// 30 min
		//调用方ip
		String ip = HttpUtils.getIp(request);
		long startTime = System.currentTimeMillis();
		logger.info("==================================" + "调用接口开始" + "==================================");
		logger.info("调用方ip：" + ip);
		logger.info("请求URI：" + request.getRequestURI());
		logger.info("请求参数信息：" + request.getQueryString());
		chain.doFilter(request, response);
		long endTime = System.currentTimeMillis();
		logger.info("调用接口所用毫秒数：" + (endTime-startTime));
		logger.info("==================================" + "调用接口调用结束" + "=============================");
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
