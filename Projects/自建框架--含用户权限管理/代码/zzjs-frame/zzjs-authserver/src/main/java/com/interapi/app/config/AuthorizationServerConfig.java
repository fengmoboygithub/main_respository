package com.interapi.app.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;

import com.interapi.app.oauth2config.config.AuthServerConfig;

/**
 * 认证服务器相关配置
 * @author yangyanchao
 *
 */
@Configuration
public class AuthorizationServerConfig extends AuthServerConfig {
	
	/**
     * 调用父类构造函数，设置令牌失效日期等信息
     */
    public AuthorizationServerConfig() {
        super((int)TimeUnit.DAYS.toSeconds(1), 0, false, false);
    }
}