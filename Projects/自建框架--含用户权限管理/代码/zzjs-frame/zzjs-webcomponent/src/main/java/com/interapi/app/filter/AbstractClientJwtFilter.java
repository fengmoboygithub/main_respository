package com.interapi.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.interapi.app.bean.ResponseModel;
import com.interapi.app.enums.JwtRedisEnum;
import com.interapi.app.utils.RedisUtil;

/**
 * @author yangyanchao
 * @description: 客户端  配置jwt过滤器 进行权限判断
 *
 */
@Component
public class AbstractClientJwtFilter extends OncePerRequestFilter {
	public static Logger logger = LoggerFactory.getLogger(AbstractClientJwtFilter.class);
    @Value("${jwt.header:Authorization}")
    public String tokenHeader;
 
    @Value("${jwt.tokenHead:Bearer}")
    public String tokenHead;
    
    @Value("${server.servlet.context-path:/usermanage}")
    public String contextPath;
    
    @Autowired
    public OAuth2ClientProperties oAuth2ClientProperties;
    
    @Autowired(required = false)
    public RedisUtil redisUtil;
    
    @Autowired(required = false)
    private TokenStore tokenStore;
    
    public AntPathMatcher antPathMatcher = new AntPathMatcher();
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
    	logger.info("请求路径：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
    	if (Objects.equals(RequestMethod.GET.toString(), request.getMethod())) {
        	logger.info("jwt不拦截此路径因为开启了不拦截GET请求：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
    		chain.doFilter(request, response);
    		return;
        }
//    	if (Objects.equals(RequestMethod.OPTIONS.toString(), request.getMethod())) {
//        	logger.info("jwt不拦截此路径因为开启了不拦截OPTIONS请求：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
//    		chain.doFilter(request, response);
//    		return;
//        }
    	
    	// 获取Authorization 认证头信息 存储着token信息
        String authHeader = request.getHeader(this.tokenHeader);
        if (StringUtils.isEmpty(authHeader) || ! authHeader.startsWith(tokenHead+" ")) {
            logger.error("请求头中{}的开头不是{}，Authorization===>【{}】", this.tokenHeader, tokenHead , authHeader);
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "暂无权限！");
            return;
        }
        String clientId = oAuth2ClientProperties.getClientId();
        if (StringUtils.isEmpty(clientId)) {
            logger.error("请在配置为配置客户端唯一标识。");
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "没有配置客户端唯一标识！");
            return;
        }
        // 截取token
        final String authToken = authHeader.substring((tokenHead+" ").length());
        OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(authToken);
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            SecurityContextHolder.getContext().setAuthentication(oAuth2Authentication);
        }
        
        boolean hasPermission = false;
        //登陆后默认放开的路径集合
        String[] permissionArr = new String[]{};
        //从redis缓存中获取可以访问的url路径
        String resourceUris = (String)redisUtil.get(JwtRedisEnum.getResourceUrisKey(authToken, clientId));
        String[] permitUrls = new String[]{};
        if(!StringUtils.isEmpty(resourceUris)){
        	if(resourceUris.indexOf(",") > -1){
        		permitUrls = resourceUris.split(",");
        	} else {
        		permitUrls = new String[]{resourceUris};
        	}
        }
        if(permitUrls == null || permitUrls.length == 0){
        	permitUrls = permissionArr;
        } else {
        	List<String> strs = Arrays.asList(permitUrls);
        	List<String> strs1 = Arrays.asList(permissionArr);
        	List<String> strs2 = new ArrayList<String>(); 
        	for(String pu : strs){
        		strs2.add(pu);
        	}
        	for(String pu1 : strs1){
        		strs2.add(pu1);
        	}
        	permitUrls = strs2.toArray(new String[strs2.size()]);
        }
        //授权通过的url
        for (int i = 0, length = permitUrls.length; i < length; i ++) {
        	if (antPathMatcher.match(contextPath+permitUrls[i], request.getRequestURI())) {
        		hasPermission = true;
        		break;
        	}
        }
        //url不能通过授权
        if(!hasPermission){
        	logger.info("暂无权限访问该路径：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "暂无权限访问该路径："+request.getRequestURI()+"！");
            return;
        }
        logger.info("认证用户 获取可以访问的url路径：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
		chain.doFilter(request, response);
    }
    
    public void responseEntity(HttpServletResponse response, Integer status, String msg) {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status);
        try {
        	ResponseModel responseModel = new ResponseModel(status, msg);
        	responseModel.setSuccess(false);
            response.getWriter().write(
            		JSON.toJSONString(responseModel)
            		);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
