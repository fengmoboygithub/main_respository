package com.company.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.company.constant.BaseConstant;
import com.company.constant.DictionarysConstant;
import com.company.dictionarys.model.DictionaryTab;
import com.company.dictionarys.model.DictionaryTabExample;
import com.company.dictionarys.service.DictionaryTabService;
import com.company.userinfo.model.UserTab;
import com.company.utils.HttpUtil;

/**
 * 全局拦截器定义类
 * @author yangyanchao
 * 
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {

	private DictionaryTabService<DictionaryTab, DictionaryTabExample> service;
	

	public DictionaryTabService<DictionaryTab, DictionaryTabExample> getService() {
		return service;
	}

	public void setService(DictionaryTabService<DictionaryTab, DictionaryTabExample> service) {
		this.service = service;
	}

	/**
	 * preHandle是请求执行前执行的
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	/**
	 * postHandler是请求结束执行的，但只有preHandle方法返回true的时候才会执行
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//设置跨域请求  
        //此处ip地址为需要访问服务器的ip及端口号
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type,Token,Accept, Connection, User-Agent, Cookie");
//        response.setHeader("Access-Control-Max-Age", "3628800");
		if (null == modelAndView) {
			return;
		}
		// 系统配置参数
//		String basePath = HttpUtil.getBasePath(request);
//		modelAndView.addObject("BASE_PATH", basePath);
//		modelAndView.addObject("UPLOAD_BASE_PATH", basePath + "/upload");
//		modelAndView
//				.addObject(
//						"TEMPLATE_BASE_PATH",
//						basePath
//								+ "/static/template/"
//								+ service
//										.getDictionaryByKey(DictionarysConstant.ZZJS_TEMPLATE));
//		modelAndView.addObject("zzjs_seo_title",
//				service.getDictionaryByKey(DictionarysConstant.ZZJS_SEO_TITLE));
//		modelAndView.addObject("zzjs_seo_description",
//				service.getDictionaryByKey(DictionarysConstant.ZZJS_SEO_DESCRIPTION));
		MDC.put("ip", HttpUtil.getIp(request));
//		UserTab userTab = (UserTab)request.getSession().getAttribute(BaseConstant.LOGIN_USER);
//		if(userTab != null){
//			modelAndView.addObject(BaseConstant.LOGIN_USER, userTab);
//		}
	}

	/**
	 * afterCompletion是视图渲染完成后才执行，同样需要preHandle返回true，该方法通常用于清理资源等工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
