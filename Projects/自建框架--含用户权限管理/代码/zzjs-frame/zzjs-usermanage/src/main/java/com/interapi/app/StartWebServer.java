package com.interapi.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.interapi.app.oauth2config.config.annotation.EnableCorsFilter;
import com.interapi.app.oauth2config.config.annotation.EnableResJWTTokenStore;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableCaching
@MapperScan("com.interapi.app.**.dao")
@EnableResJWTTokenStore    //开启 JWT 令牌存储（资源服务器-非对称加密）
@EnableCorsFilter          //解决前后端分离跨域问题
@EnableSwagger2
public class StartWebServer 
{
    public static void main( String[] args )
    {
    	// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(StartWebServer.class, args);
		System.out.println("用户管理客户端程序正在运行...");
    }
}
