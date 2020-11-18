package com.interapi.app.bmp.serviceImpl;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.interapi.app.authorize.MySimpleGrantedAuthority;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import com.interapi.app.bmp.service.AuthService;
import com.interapi.app.enums.JwtRedisEnum;
import com.interapi.app.utils.JwtTokenUtil;
import com.interapi.app.utils.RedisUtil;

@Service
public class AuthServiceImpl implements AuthService{

	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserTabMapper userTabMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.expiration}")
    private Long expiration;
 
    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserTabMapper userTabMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userTabMapper = userTabMapper;
    }
    
    @Override
    public UserTab register(UserTab userToAdd) throws AuthenticationException{
        final String username = userToAdd.getAccount();
        UserTabExample example = new UserTabExample();
		example.createCriteria().andAccountEqualTo(username);
		List<UserTab> list = userTabMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return null;
		} 
		final String rawPassword = userToAdd.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        userToAdd.setCreateTime(new Date());
        userToAdd.setCreateUser(0L);
        userToAdd.setIsDelete("1");
        userTabMapper.insert(userToAdd);
        return userToAdd;
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public Map<String,String> login(String username, String password) {
    	Map<String,String> map = new HashMap<>();
    	//手动调用安全框架实现认证逻辑
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // authenticationManager 在WebSecurityConfig声明注入 
        // 用户提交的用户名和密码 生成token类 在从数据库中获取用户信息与权限信息并返回token类 最后比较两方
        // 若相等则通过验证将认证类authentication放入SecurityContextHolder缓存中
    	final Authentication authentication = authenticationManager.authenticate(upToken);
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	
        // 通过安全框架认证后 使用jwt生成token票据并返回
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        Long createdDateLong = jwtTokenUtil.getCreatedDateLongFromToken(token);
        String createdDate = String.valueOf(createdDateLong);
        //将jwt的票据信息放入Redis缓存中 
        redisUtil.set(JwtRedisEnum.getTokenKey(username, createdDate), token, expiration);
        logger.info("将jwt的票据信息放入Redis缓存中 key:【{}】 value:【{}】过期时间：{}秒",
        		JwtRedisEnum.getTokenKey(username, createdDate),
        		token,
        		expiration);
        //将安全框架的认证信息放入Redis缓存中 
        String authenticationStr = JSON.toJSONString(userDetails);
        redisUtil.set(JwtRedisEnum.getAuthenticationKey(username, createdDate), userDetails , expiration);
        logger.info("将安全框架的认证信息放入Redis缓存中  key:【{}】 value:【{}】过期时间：{}秒",
        		JwtRedisEnum.getAuthenticationKey(username, createdDate),
        		authenticationStr,
        		expiration);
		Collection<MySimpleGrantedAuthority> list = (Collection<MySimpleGrantedAuthority>) userDetails.getAuthorities();
        String authorities = "";
        Iterator<MySimpleGrantedAuthority> it = list.iterator();
        while(it.hasNext()){
        	authorities += (it.next()).getAuthority()+",";
        }
        if(authorities.length()>0){
        	authorities = authorities.substring(0, authorities.length()-1);
        }
        map.put("token", token);
        map.put("authorities", authorities);
        return map;
    }

	@Override
	public void logout(HttpServletRequest request) {
		// 获取Authorization 认证头信息 存储着token信息
        String authHeader = request.getHeader(this.tokenHeader);
        // 截取token
        final String token = authHeader.substring((tokenHead+" ").length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Long createdDateLong = jwtTokenUtil.getCreatedDateLongFromToken(token);
        String createdDate = String.valueOf(createdDateLong);
        
        //将jwt的票据信息从Redis缓存中删除 
        redisUtil.del(JwtRedisEnum.getTokenKey(username, createdDate));
        logger.info("将jwt的票据信息从Redis缓存中删除  key:【{}】",
        		JwtRedisEnum.getTokenKey(username, createdDate)
        		);
        //将安全框架的认证信息从Redis缓存中删除 
        redisUtil.del(JwtRedisEnum.getAuthenticationKey(username, createdDate));
        logger.info("将安全框架的认证信息从Redis缓存中删除   key:【{}】",
        		JwtRedisEnum.getAuthenticationKey(username, createdDate)
        		);
	}
}
