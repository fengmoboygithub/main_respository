package com.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.company.store.Swagger2Store;

/**
 * @author yangyanchao
 * @description: 在启动类上添加该注解来----开启Swagger2 api文档
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(Swagger2Store.class)
public @interface EnableSwagger2Store {
}
