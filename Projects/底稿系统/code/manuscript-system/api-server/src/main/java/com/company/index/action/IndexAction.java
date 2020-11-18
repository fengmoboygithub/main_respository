package com.company.index.action;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 仪表盘Action类
 * @author yangyanchao
 *
 */
@Controller
@RequestMapping("/platform")
public class IndexAction {

	public static Logger logger = LoggerFactory.getLogger(IndexAction.class);
	
	/**
	 * 转到仪表盘页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String indexPage(HttpServletRequest request) {
		return "platform/index";
	}
	
}
