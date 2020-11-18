package com.interapi.app.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;

/**
 * Redis缓存 配置类
* Title: RedisConfig
* Description: 
* Redis配置文件 
* Version:1.0.0  
* @author yangyc
* @date 2018年3月19日
 */
@Configuration
public class RedisConfig extends AbstractRedisConfig{
	/**
     * 调用父类构造函数，设置缓存默认失效时间、缓存组信息
     */
	public RedisConfig() {
		super(TimeUnit.MINUTES.toSeconds(10), null);
	}  
}  
