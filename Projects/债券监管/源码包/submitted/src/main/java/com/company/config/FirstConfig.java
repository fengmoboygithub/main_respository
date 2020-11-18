package com.company.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.config.first.FirstParam;

/**
 * 首次报送配置类
 * 
 * @author yangyanchao
 *
 */
@Configuration
public class FirstConfig {

	/**
	 * 首次报送标识
	 */
	@Value("${work.first.flag}")
	private boolean flag;
	/**
	 * 首次报送接口编码
	 */
	@Value("${work.first.interfaceCode}")
	private String interfaceCode;
	
	@Bean
	public FirstParam firstParam() {
		FirstParam firstParam = new FirstParam(flag, interfaceCode);
		return firstParam;
	}
}
