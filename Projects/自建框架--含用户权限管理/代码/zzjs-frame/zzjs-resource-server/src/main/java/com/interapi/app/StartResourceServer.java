package com.interapi.app;

import java.util.Collection;
import java.util.Iterator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interapi.app.bean.ResponseAuthenticationModel;
import com.interapi.app.oauth2config.config.annotation.EnableCorsFilter;
import com.interapi.app.oauth2config.config.annotation.EnableResJWTTokenStore;


@SpringBootApplication
@RestController
@MapperScan("com.interapi.app.**.dao")
@EnableCaching
@EnableCorsFilter          //解决前后端分离跨域问题
@EnableResJWTTokenStore    //开启 JWT 令牌存储（资源服务器-非对称加密）
public class StartResourceServer 
{
    public static void main( String[] args )
    {
    	// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(StartResourceServer.class, args);
		System.out.println("资源服务程序正在运行...");
    }
    @PostMapping(value = "/api/getAuthenticationInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseAuthenticationModel getAuthenticationInfo() {
    	ResponseAuthenticationModel responseModel = new ResponseAuthenticationModel();
        try {
        	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        	@SuppressWarnings("unchecked")
			Collection<SimpleGrantedAuthority> list = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
            String authorities = "";
            Iterator<SimpleGrantedAuthority> it = list.iterator();
            while(it.hasNext()){
            	authorities += (it.next()).getAuthority()+",";
            }
            if(authorities.length()>0){
            	authorities = authorities.substring(0, authorities.length()-1);
            }
        	responseModel.setAuthorities(authorities);
        } catch (Exception e) {
        	responseModel.setSuccess(false);
        	responseModel.setMessage("Fail:" + e.getMessage());
        	responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("获取认证信息");
        return responseModel;
    }
}
