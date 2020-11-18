package com.company.config;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;

import com.company.constant.BaseConstant;
import com.company.utils.HttpUtil;
/**
 * 判断会话超时或者未登陆恶意访问资源时跳转登陆页面
 * @author yangyanchao
 *
 */
public class SessionFilter implements Filter {
    protected Logger logger = LoggerFactory.getLogger(SessionFilter.class);
    // 不登陆也可以访问的资源
    private static Set<String> GreenUrlSet = new HashSet<String>();
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public void doFilter(ServletRequest srequest, ServletResponse sresponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        HttpServletResponse response = (HttpServletResponse)sresponse;
        String uri = request.getRequestURI();
        sresponse.setCharacterEncoding("UTF-8");//设置响应编码格式
        sresponse.setContentType("text/html;charset=UTF-8");//设置响应编码格式
        logger.info("+++++++++++++++++安全过滤器, 请求URI："+uri+"+++++++++++++++++++++++++++++");
        if (	uri.endsWith(".js")
                || uri.endsWith(".css")
                || uri.endsWith(".jpg")
                || uri.endsWith(".gif")
                || uri.endsWith(".png")
                || uri.endsWith(".ico")
                || antPathMatcher.match("/dialogs/**", uri)
                || antPathMatcher.match("/ueditor/**", uri)
                || antPathMatcher.match("/config/**", uri)
                || antPathMatcher.match("/static-file-plate/**", uri)
                || antPathMatcher.match("/public/**", uri)
				|| antPathMatcher.match("/resources/**", uri)
				|| antPathMatcher.match("/static/**", uri)
				|| antPathMatcher.match("/image/**", uri)
				|| antPathMatcher.match("/video/**", uri)
				|| antPathMatcher.match("/file/**", uri)
			) {
        	logger.info("安全过滤器, 资源uri通过, " + request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
            return;
        }

        
        //不处理指定的action, jsp
        if (GreenUrlSet.contains(uri)) {
        	logger.info("安全过滤器, 指定不作处理的uri通过, " + request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
            return;
        }
        Long id = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        if(id == null){
        	String html = "<script type=\"text/javascript\">window.location.href=\"/login.htm\"</script>";
            sresponse.getWriter().write(html);
        }else {
        	if (uri.contains("/api/")) {
        		response.addHeader("Access-Control-Allow-Origin", "*");
        		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        		response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,sessionId");
        		response.addHeader("Access-Control-Max-Age", "1800");// 30 min
        		String ip = HttpUtil.getIp(request);
        		long startTime = System.currentTimeMillis();
        		logger.info("==================================" + "调用接口开始" + "==================================");
        		logger.info("调用方ip：" + ip);
        		logger.info("请求URI：" + request.getRequestURI());
        		logger.info("请求参数信息：" + request.getQueryString());
        		filterChain.doFilter(srequest, sresponse);
        		long endTime = System.currentTimeMillis();
        		logger.info("调用接口所用毫秒数：" + (endTime-startTime));
        		logger.info("==================================" + "调用接口调用结束" + "=============================");
        		return;
        	} else {
        		filterChain.doFilter(srequest, sresponse);
        	}
            
        }
    }

    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {
        //生成验证码
        GreenUrlSet.add("/captcha.htm");
        //登录页面
        GreenUrlSet.add("/login.htm");
        //登出操作并跳转到登录页面
        GreenUrlSet.add("/logout.htm");
        //登录认证操作
        GreenUrlSet.add("/login.json");
    }
    
    public static void main(String[] args) {
    	AntPathMatcher antPathMatcher = new AntPathMatcher();
    	System.out.println(antPathMatcher.match("/static/**", "/static/manage/css/bootstrap.min.css"));
	}
}
