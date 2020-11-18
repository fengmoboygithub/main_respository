package com.interapi.app.oauth2config.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author yangyanchao
 * @description: Web 权限配置类
 *
 */
@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public abstract class AbstractClientServerSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// password 方案三：支持多种编码，通过密码的前缀区分编码方式,推荐
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Autowired(required = false)
    public OncePerRequestFilter authenticationTokenFilterBean;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http// 我们这里不需要csrf
		.csrf().disable()
        .headers()
        .frameOptions()
        .disable()
        .and()
        // 基于token，所以不需要session
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        // 允许对于网站静态资源的无授权访问
//		.antMatchers(
//				HttpMethod.GET,
//				"/",
//				"/*.html",
//				"/favicon.ico",
//				"/**/*.html",
//				"/**/*.css",
//				"/**/*.js",
//				"/**/*.png",
//				"/**/*.jpg",
//				"/**/*.jpeg",
//				"/**/*.ico",
//				"/**/*.gif",
//				"/**/*.eot",
//				"/**/*.svg",
//				"/**/*.ttf",
//				"/**/*.woff",
//				"/**/*.woff2",
//				"/**/*.otf",
//				"/**/*.map",
//				"/**/*.json"
//		).permitAll()
		//对于认证相关post操作api要允许匿名访问
//		.antMatchers("/auth/login","/auth/logout").permitAll()
        .anyRequest()
        .authenticated();
     // 添加JWT filter
        http
		.addFilterBefore(authenticationTokenFilterBean, UsernamePasswordAuthenticationFilter.class);
        // 禁用缓存
      	http.headers().cacheControl();
    }

}