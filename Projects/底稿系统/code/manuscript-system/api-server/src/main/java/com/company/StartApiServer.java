package com.company;

import com.company.annotation.EnableSwagger2Store;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@RestController
@MapperScan("com.company.**.dao")
@EnableCaching
@EnableSwagger2Store
@EnableTransactionManagement
public class StartApiServer 
{
    public static void main( String[] args ){	
    	System.setProperty("es.set.netty.runtime.available.processors", "false");
    	// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
		SpringApplication.run(StartApiServer.class, args);
		System.out.println("投行工作底稿正在运行...");
    }
}
