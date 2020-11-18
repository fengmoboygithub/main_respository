package com.interapi.app.oauth2config.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.interapi.app.oauth2config.config.filter.MyCorsFilter;

/**
 * @author yangyanchao
 * @description: 在启动类上添加该注解来----解决前后端分离跨域问题
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyCorsFilter.class)
public @interface EnableCorsFilter {
}
