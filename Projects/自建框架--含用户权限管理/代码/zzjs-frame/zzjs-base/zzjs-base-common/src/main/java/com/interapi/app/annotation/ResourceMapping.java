package com.interapi.app.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义资源映射注解
 * @author yangyanchao
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceMapping {
    /**
     * 模块命名空间或者接口资源URI
     * @return
     */
    String code();
    /**
     * 模块名称
     * @return
     */
    String name() default "";
    /**
     * 模块映射表名
     * @return
     */
    String tableName() default "";
    /**
     * 权限名称
     * @return
     */
    String roleName();
    /**
     * 权限标识
     * @return
     */
    String roleFlag();
    /**
     * 页面地址  /pages/模块命名空间/list.html
     * @return
     */
    String homePage() default "";
    
    /**
     * 菜单名称
     * @return
     */
    String menuName() default "";
    
    /**
     * 菜单排序
     * @return
     */
    String menuSort() default "0";
    
    /**
     * 页面排序
     * @return
     */
    String pageSort() default "0";
}
