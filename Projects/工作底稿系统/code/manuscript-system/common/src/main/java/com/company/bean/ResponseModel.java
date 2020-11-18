package com.company.bean;

import java.util.HashMap;

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
    
    /** 返回内容 **/
    private String body;
    
    /** 状态码 */
    private int code = HttpStatus.OK.value();
    
    /** 具体每个输入错误的消息*/
	protected HashMap<String, String> errors = new HashMap<String, String>();
    
    public ResponseModel() {
		super();
	}
    
    public ResponseModel(int code, String message) {
    	this.code = code;
        this.message = message;
	}
    

	public ResponseModel(String message, String body, int code) {
		this.message = message;
		this.body = body;
		this.code = code;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public HashMap<String, String> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}
}
