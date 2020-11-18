package com.interapi.app.oauth2config.config.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangyanchao
 * @description: 注入RestTemplate
 *
 */
public class MyRestTemplate {
	@Autowired 
	private RestTemplateBuilder builder; 
    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例 
    @Bean 
    public RestTemplate restTemplate() { 
    	return builder.build(); 
    }
}
