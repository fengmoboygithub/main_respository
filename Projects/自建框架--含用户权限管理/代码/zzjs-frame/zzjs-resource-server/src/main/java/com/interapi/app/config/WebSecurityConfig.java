package com.interapi.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.interapi.app.oauth2config.config.ResServerConfig;
/**
 * spring Security 配置类
 * @author yangyanchao
 * @description: 资源服务器访问权限配置
 */
@Configuration
public class WebSecurityConfig  extends ResServerConfig  {

	@Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                //访问受保护资源 /api 的要求：客户端 Scope 为 all
                .antMatchers("/api/**")
                .access("#oauth2.hasScope('all')");
    }
}
