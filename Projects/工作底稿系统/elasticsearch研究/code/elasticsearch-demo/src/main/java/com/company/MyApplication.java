package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
public class MyApplication {
	public static Logger logger = LoggerFactory.getLogger(MyApplicationTests.class);
	public static void main(String[] args) {
		SpringApplication.run(MyApplicationTests.class, args);
		logger.info("程序已启动。。。");
	}
}
