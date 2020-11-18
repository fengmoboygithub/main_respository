package com.company.config;

import java.util.Properties;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Configuration
@PropertySource("classpath:/kaptcha-config.properties")
public class WebConfiguration {
	
	@Autowired
    private Environment env;

    /**
     * 登陆时验证码的配置
     * @return
     */
    @Bean(name = "captchaProducer")
    public DefaultKaptcha captchaProducer() {
    	DefaultKaptcha captchaProducer = new DefaultKaptcha();
    	Properties properties = new Properties();
    	// 验证码宽度
    	properties.setProperty("kaptcha.image.width", env.getProperty("kaptcha.image.width"));
    	// 验证码高度
    	properties.setProperty("kaptcha.image.height", env.getProperty("kaptcha.image.height"));
    	// 生成验证码内容范围
    	properties.setProperty("kaptcha.textproducer.char.string", env.getProperty("kaptcha.textproducer.char.string"));
    	// 验证码个数
    	properties.setProperty("kaptcha.textproducer.char.length", env.getProperty("kaptcha.textproducer.char.length"));
    	// 是否有边框
    	properties.setProperty("kaptcha.border", env.getProperty("kaptcha.border"));
    	// 验证码字体颜色
    	properties.setProperty("kaptcha.textproducer.font.color", env.getProperty("kaptcha.textproducer.font.color"));
    	// 验证码字体大小
    	properties.setProperty("kaptcha.textproducer.font.size", env.getProperty("kaptcha.textproducer.font.size"));
    	// 验证码所属字体样式
    	properties.setProperty("kaptcha.textproducer.font.names", env.getProperty("kaptcha.textproducer.font.names"));
    	properties.setProperty("kaptcha.background.clear.from", env.getProperty("kaptcha.background.clear.from"));
    	properties.setProperty("kaptcha.background.clear.to", env.getProperty("kaptcha.background.clear.to"));
    	properties.setProperty("kaptcha.obscurificator.impl", env.getProperty("kaptcha.obscurificator.impl"));
    	properties.setProperty("kaptcha.noise.impl", env.getProperty("kaptcha.noise.impl"));
    	// 干扰线颜色
    	properties.setProperty("kaptcha.noise.color", env.getProperty("kaptcha.noise.color"));
    	// 验证码文本字符间距
    	properties.setProperty("kaptcha.textproducer.char.space", env.getProperty("kaptcha.textproducer.char.space"));
    	captchaProducer.setConfig(new Config(properties));
    	return captchaProducer;
    }
    
    /**
     * 声明会话过滤器
     * @return
     */
//    @Bean(name = "sessionFilter")
//    public Filter sessionFilter() {
//        return new SessionFilter();
//    }
//
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//    public FilterRegistrationBean testFilterRegistration() {
//
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(sessionFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("sessionFilter");
//        registration.setOrder(1);
//        return registration;
//    }
    
    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("1024MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("1024MB");
        return factory.createMultipartConfig();
    }
}