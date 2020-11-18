package com.interapi.app.enums;

/**
 * Redis存储jwt的key前缀
 */
public enum JwtRedisEnum {

    /**
     * token 的key前缀
     */
    TOKEN_KEY_PREFIX("jwt:"),

    /***
     * authentication的key
     */
    AUTHENTICATION_KEY_PREFIX("authentication:"),
    
    /***
     * resourceuris的key
     */
    RESOURCEURIS_KEY_PREFIX("resourceuris:"),
    
    /***
     * authorities的key
     */
    AUTHORITIES_KEY_PREFIX("authorities:")
    ;

    private String value;


    JwtRedisEnum(String value) {
        this.value = value;
    }

    /**
     * 获取key
     *
     * @param username：xxx@163.com
     * @return
     */
    public static String getTokenKey(String username) {
        return TOKEN_KEY_PREFIX.value + username;
    }
    
    /**
     * 获取接口资源key
     *
     * @param token：身份令牌
     * @return
     */
    public static String getResourceUrisKey(String token, String clientId) {
        return RESOURCEURIS_KEY_PREFIX.value + token + ":" + clientId;
    }
    
    /**
     * 获取权限集key
     *
     * @param token：身份令牌
     * @return
     */
    public static String getAuthoritiesKey(String token, String clientId) {
        return AUTHORITIES_KEY_PREFIX.value + token + ":" + clientId;
    }
}
