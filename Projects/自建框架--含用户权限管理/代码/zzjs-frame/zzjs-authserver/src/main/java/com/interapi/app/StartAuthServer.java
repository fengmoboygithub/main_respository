package com.interapi.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.interapi.app.oauth2config.config.annotation.EnableAuthJWTTokenStore;
import com.interapi.app.oauth2config.config.annotation.EnableCorsFilter;
import com.interapi.app.oauth2config.config.annotation.EnableDBClientDetailsService;
import com.interapi.app.oauth2config.config.annotation.EnableRestTemplate;


@SpringBootApplication
@MapperScan("com.interapi.app.**.dao")
@EnableCaching
@EnableRestTemplate      //启用RestTemplate
//@EnableAuthRedisTokenStore    // 使用 redis 存储令牌
@EnableAuthJWTTokenStore        // 使用  JWT 令牌存储（授权服务器-非对称加密）
@EnableDBClientDetailsService // 从数据库加载客户端详情
@EnableCorsFilter          //解决前后端分离跨域问题
public class StartAuthServer 
{
    public static void main( String[] args )
    {
    	// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(StartAuthServer.class, args);
		System.out.println("认证服务程序正在运行...");
    }
}
