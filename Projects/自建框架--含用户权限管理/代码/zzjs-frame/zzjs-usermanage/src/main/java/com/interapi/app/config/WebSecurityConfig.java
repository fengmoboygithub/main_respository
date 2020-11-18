package com.interapi.app.config;

import org.springframework.context.annotation.Configuration;

import com.interapi.app.oauth2config.config.AbstractClientServerSecurityConfig;
/**
 * spring Security 客户端配置类 
 * @author yangyanchao
 *
 */
@Configuration
public class WebSecurityConfig extends AbstractClientServerSecurityConfig {
}
