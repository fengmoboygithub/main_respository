package com.company.enums;

/**
 * 认证错误信息
 */
public enum AuthErrorEnum {

    /**
     * 用户名或密码不正确
     */
	BAD_CREDENTIALS_PREFIX("Bad credentials","用户名或密码不正确");

    private String message;
	
    private String value;

    AuthErrorEnum(String message, String value) {
    	this.message = message;
        this.value = value;
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
