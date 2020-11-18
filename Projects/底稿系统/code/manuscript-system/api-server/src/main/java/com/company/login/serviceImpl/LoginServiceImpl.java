package com.company.login.serviceImpl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.company.enums.RequestParameterType;
import com.company.utils.HttpUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.exception.AuthException;
import com.company.login.service.LoginService;
import com.company.userinfo.controller.UserTabController;
import com.company.userinfo.dao.UserTabMapper;
import com.company.userinfo.model.UserTab;
import com.company.userinfo.model.UserTabExample;
import com.company.utils.HttpClientUtils;
import com.company.utils.RedisUtil;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import net.bytebuddy.asm.Advice.This;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登陆登出相关操作实现类
 * @author yangyanchao
 *
 */
@Service
public class LoginServiceImpl extends BaseServiceImpl<UserTab, UserTabExample> implements LoginService<UserTab, UserTabExample>{

    public static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private UserTabMapper mapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
	
	public IBaseDao<UserTab, UserTabExample> getMapper(){
		return mapper;
	}

    /**
     * 统一账户管理外部调用url
     */
    @Value("${web.user-system-url}")
    private String userSystemUrl;
	
	/* (non-Javadoc)
	 * @see com.company.login.service.LoginService#login(java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	public Map<String, Object> login(String name, String password,
			HttpServletRequest request) throws AuthException {
	        Map<String, String> map = new HashMap<String, String>();
	        //RedisUtil redisUtil = new RedisUtil();
	        // 用户名密码
	        map.put("username", name);
	        map.put("password", password);
	        Map<String, Object> loginfo ;
	        loginfo = HttpUtil.HttpRequestutil(map, userSystemUrl+"/api/system/user/login", RequestMethod.GET, RequestParameterType.QUERY);
	        if ("0".equals(loginfo.get("code").toString())) {
                // 成功的话继续请求权限
	            Map<String, Object> authmap = (Map<String, Object>) loginfo.get("data");
	            String userId = authmap.get("userId")+"";
                map.put("userId", userId);
                Map<String, Object> authInfo;
                authInfo = HttpUtil.HttpRequestutil(map, userSystemUrl+"/api/system/menu/selectDatamByUserId", RequestMethod.GET, RequestParameterType.QUERY);
	            ArrayList<Object> list = (ArrayList<Object>) authInfo.get("data");
                String jsonString = JSON.toJSONString(list);
                redisTemplate.opsForValue().set(userId, jsonString);  
                return authmap;
	            //boolean result = redisUtil.set("userId", "jsonString");
            }else {
                throw new AuthException("用户不存在");
            }
        }
}