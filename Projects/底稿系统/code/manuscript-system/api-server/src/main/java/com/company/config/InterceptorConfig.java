package com.company.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.company.dictionarys.model.DictionaryTab;
import com.company.dictionarys.model.DictionaryTabExample;
import com.company.dictionarys.service.DictionaryTabService;

/**
 * 拦截器配置类
 * @author yangyanchao
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
    private DictionaryTabService<DictionaryTab, DictionaryTabExample> service;
	/**
	 * addInterceptor用于添加你自定义的拦截器实例
	 * addPathPatterns用于添加要拦截的url,可以写多个。
	 * excludePathPatterns用于添加不需要拦截的url,可以写多个。
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new GlobalInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/captcha.htm","/login.json")
//                .excludePathPatterns("/public/**","/api/**",
//                		"/resources/**","/static/**"
//                		//,"/image/**","/video/**","/file/**","/dialogs/**"
//                		);
		GlobalInterceptor globalInterceptor = new GlobalInterceptor();
		globalInterceptor.setService(service);
		registry.addInterceptor(globalInterceptor).addPathPatterns("/**");
		//registry.addInterceptor(globalInterceptor).addPathPatterns("/platform/**","/manage/**","/logout.htm","/login.htm");

    }
}
