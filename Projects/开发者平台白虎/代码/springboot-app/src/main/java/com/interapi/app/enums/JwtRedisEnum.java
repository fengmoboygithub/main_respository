package com.interapi.app.enums;

/**
 * Redis存储jwt的key前缀
 *
 * @author TongWei.Chen 2018-06-09 21:40:23
 */
public enum JwtRedisEnum {

    /**
     * token 的key前缀
     */
    TOKEN_KEY_PREFIX("jwt:"),

    /***
     * authentication的key
     */
    AUTHENTICATION_KEY_PREFIX("authentication:")
    ;

    private String value;


    JwtRedisEnum(String value) {
        this.value = value;
    }

    /**
     * 获取key
     *
     * @param username：xxx@163.com
     * @param createdDate
     * @return
     */
    public static String getTokenKey(String username, String createdDate) {
        return TOKEN_KEY_PREFIX.value + username + ":" + createdDate;
    }

    /**
     * 获取身份认证key
     *
     * @param username：用户名
     * @return
     */
    public static String getAuthenticationKey(String username, String createdDate) {
        return AUTHENTICATION_KEY_PREFIX.value + username + ":" + createdDate;
    }
}
