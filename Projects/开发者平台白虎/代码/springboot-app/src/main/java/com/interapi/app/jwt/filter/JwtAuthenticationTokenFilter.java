package com.interapi.app.jwt.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.interapi.app.bmp.model.LoginUser;
import com.interapi.app.bmp.service.RbacService;
import com.interapi.app.enums.JwtRedisEnum;
import com.interapi.app.enums.JwtUrlEnum;
import com.interapi.app.generator.bean.ResponseModel;
import com.interapi.app.utils.JwtTokenUtil;
import com.interapi.app.utils.RedisUtil;
 
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
	public static Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Value("${jwt.header}")
    private String tokenHeader;
 
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    
    /**
     * token失效时间
     */
    @Value("${jwt.expiration}")
    private Long expiration;
    
    /**
     * token 当token剩余时间小于自动刷新时间时 刷新token
     */
    @Value("${jwt.autoRefreshTokenExpiration}")
    private Long autoRefreshTokenExpiration;
    
    @Value("${jwt.route.authentication.loginPage}")
    private String loginPage;
    
    @Value("${jwt.route.authentication.path}")
    private String loginUrl;
    
    @Value("${jwt.route.authentication.register}")
    private String registerUrl;
 
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private RedisUtil redisUtil;
    
    @Autowired
    private RbacService rbacService;
    
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
    	logger.info("请求路径：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
    	String[] urlArr = {loginPage,loginUrl,registerUrl,JwtUrlEnum.LOGOUT.url()};
    	for (int i = 0, length = urlArr.length; i < length; i ++) {
        	if (antPathMatcher.match(urlArr[i], request.getRequestURI())) {
        		logger.info("放开登录与注册URI：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
        		chain.doFilter(request, response);
        		return;
        	}
        }
    	
    	// 获取Authorization 认证头信息 存储着token信息
        String authHeader = request.getHeader(this.tokenHeader);
        if (StringUtils.isEmpty(authHeader) || ! authHeader.startsWith(tokenHead+" ")) {
            logger.error("请求头中{}的开头不是{}，Authorization===>【{}】", this.tokenHeader, tokenHead , authHeader);
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "暂无权限！");
            return;
        }
        // 截取token
        final String authToken = authHeader.substring((tokenHead+" ").length());
        
        // 判断token是否真实
        if (!jwtTokenUtil.validateToken(authToken)) {
            logger.info("token值非法！");
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "token值非法！");
            return;
        }
        
        // 判断token是否失效
        if (jwtTokenUtil.isTokenExpired(authToken)) {
            logger.info("token已过期！");
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "token已过期！");
            return;
        }
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        Long createdDateLong = jwtTokenUtil.getCreatedDateLongFromToken(authToken);
        String createdDate = String.valueOf(createdDateLong);
        // 验证token是否合法
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(createdDate)) {
            logger.info("username【{}】或createdDate【{}】可能为null！", username, createdDate);
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "暂无权限！");
            return;
        }
        
        // 验证token是否存在（过期了也会消失） 在Redis缓存中验证
        String token = redisUtil.getByString(JwtRedisEnum.getTokenKey(username, createdDate));
        if (StringUtils.isEmpty(token)) {
            logger.info("Redis里没查到key【{}】对应的value！", JwtRedisEnum.getTokenKey( username, createdDate));
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "token已过期！");
            return;
        }
        
        // 判断传来的token和存到redis的token是否一致
        if (! Objects.equals(token.toString(), authToken)) {
            logger.error("前端传来的token【{}】和redis里的token【{}】不一致！", authToken, token.toString());
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "暂无权限！");
            return;
        }
        
        //从redis缓存中得到认证信息
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
        	String authenticationStr = redisUtil.getByString(JwtRedisEnum.getAuthenticationKey(username, createdDate));
        	
        	ObjectMapper objectMapper=new ObjectMapper();
        	LoginUser userDetails=objectMapper.readValue(authenticationStr, LoginUser.class);
        	UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                    request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        
        boolean hasPermission = false;
        // 根据认证用户 获取可以访问的url路径
        String[] permitUrls = rbacService.hasPermissionUrl(SecurityContextHolder.getContext().getAuthentication());
        if(permitUrls == null || permitUrls.length == 0){
        	logger.info("你可以访问的路径为空！");
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "你可以访问的路径为空！");
            return;
        } else {
        	//授权通过的url
        	for (int i = 0, length = permitUrls.length; i < length; i ++) {
        		if (antPathMatcher.match(permitUrls[i], request.getRequestURI())) {
        			hasPermission = true;
        			break;
        		}
        	}
        	
        }
        //url不能通过授权
        if(!hasPermission){
        	logger.info("暂无权限访问该路径：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
            responseEntity(response, HttpStatus.UNAUTHORIZED.value(), "暂无权限访问该路径："+request.getRequestURI()+"！");
            return;
        }
        
        logger.info("认证用户 获取可以访问的url路径：【{}】，请求方式为：【{}】", request.getRequestURI(), request.getMethod());
		// token过期时间
        long tokenExpireTime = jwtTokenUtil.getExpirationDateFromToken(authToken).getTime();
        // token还剩余多少时间过期
        long surplusExpireTime = (tokenExpireTime - System.currentTimeMillis()) / 1000;
        logger.info("token还剩余多少时间过期:" + surplusExpireTime);
        
        /*
         * 退出登录不刷新token，因为假设退出登录操作，刷新token了，这样清除的是旧的token，相当于根本没退出成功
         */
        if (! Objects.equals(request.getRequestURL(), JwtUrlEnum.LOGOUT.url())) {
            // token过期时间小于等于多少秒，自动刷新token
            if (surplusExpireTime <= autoRefreshTokenExpiration) {
                // 1.删除之前的token
            	redisUtil.delByString(JwtRedisEnum.getTokenKey(username, createdDate));

                //2.重新生成token
                // 重新生成token，放到header以及redis
                String newAuthToken = jwtTokenUtil.refreshToken(authToken);
                // 重新生成createdDate，放到header以及redis
                String newCreatedDate = String.valueOf(jwtTokenUtil.getCreatedDateLongFromToken(authToken));
                response.setHeader(tokenHeader, tokenHead+" " + newAuthToken);
                redisUtil.setByString(JwtRedisEnum.getTokenKey(username, newCreatedDate),
                        newAuthToken,
                        expiration);
                logger.info("重新生成token【{}】和randomKey【{}】", newAuthToken, newCreatedDate);

                // 取出老的authenticate放到redis里
                String authentication = redisUtil.getByString(JwtRedisEnum.getAuthenticationKey(username, createdDate));

                redisUtil.setByString(JwtRedisEnum.getAuthenticationKey(username, newCreatedDate),
                        authentication,
                        expiration);

                // 删除旧的认证信息,这里设置50s后自动到期，是因为在实际应用中有可能从authentication里获取用户唯一标识
                redisUtil.setByString(
                        JwtRedisEnum.getAuthenticationKey(username, createdDate),
                        authentication,
                        50);
            }
        }
		chain.doFilter(request, response);
    }
    
    private void responseEntity(HttpServletResponse response, Integer status, String msg) {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status);
        try {
            response.getWriter().write(
            		JSON.toJSONString(new ResponseModel(status, msg))
            		);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	AntPathMatcher antPathMatcher1 = new AntPathMatcher();
    	System.out.println(antPathMatcher1.match("auth/login", "/auth/login"));
	}
}
