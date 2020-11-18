package com.interapi.app.bean;

import org.springframework.http.HttpStatus;

/**
 * 返回基本json对象 
 * 
 * @author yangyanchao
 * 
 * @param <T>
 */
public class ResponseModel {
    private boolean success = true;
    /** 提示语 */
    private String message;
    /** 状态码 */
    private int code = HttpStatus.OK.value();
    
    public ResponseModel() {
		super();
	}
    
    public ResponseModel(int code, String message) {
    	this.code = code;
        this.message = message;
	}

	public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
