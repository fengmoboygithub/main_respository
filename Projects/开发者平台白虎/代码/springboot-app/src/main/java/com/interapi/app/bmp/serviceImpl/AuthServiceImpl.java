package com.interapi.app.bmp.serviceImpl;
import java.util.Date;
import java.util.List;

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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
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
			throw new UsernameNotFoundException("用户已存在");
		} 
		final String rawPassword = userToAdd.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
//        userToAdd.setRoles(asList("ROLE_USER")); //添加默认角色
        userTabMapper.insert(userToAdd);
        return userToAdd;
    }
 
    @Override
    public String login(String username, String password) {
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
        redisUtil.setByString(JwtRedisEnum.getTokenKey(username, createdDate), token, expiration);
        logger.info("将jwt的票据信息放入Redis缓存中 key:【{}】 value:【{}】过期时间：{}秒",
        		JwtRedisEnum.getTokenKey(username, createdDate),
        		token,
        		expiration);
        //将安全框架的认证信息放入Redis缓存中 
        String authenticationStr = JSON.toJSONString(userDetails);
        redisUtil.setByString(JwtRedisEnum.getAuthenticationKey(username, createdDate), authenticationStr , expiration);
        logger.info("将安全框架的认证信息放入Redis缓存中  key:【{}】 value:【{}】过期时间：{}秒",
        		JwtRedisEnum.getAuthenticationKey(username, createdDate),
        		authenticationStr,
        		expiration);
        return token;
    }
 
    @Override
    public String refresh(String oldToken) {
//        final String token = oldToken.substring(tokenHead.length());
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        LoginUser user = (LoginUser) userDetailsService.loadUserByUsername(username);
//        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
//            return jwtTokenUtil.refreshToken(token);
//        }
        return null;
    }
}
