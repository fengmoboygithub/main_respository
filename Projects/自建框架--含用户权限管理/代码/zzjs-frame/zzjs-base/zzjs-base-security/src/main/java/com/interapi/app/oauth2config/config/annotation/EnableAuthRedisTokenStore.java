package com.interapi.app.oauth2config.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.interapi.app.oauth2config.config.store.MyRedisTokenStore;

/**
 * @author yangyanchao
 * @description: 在启动类上添加该注解来----开启令牌存储在 redis缓存（授权服务器）
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyRedisTokenStore.class)
public @interface EnableAuthRedisTokenStore {
}
