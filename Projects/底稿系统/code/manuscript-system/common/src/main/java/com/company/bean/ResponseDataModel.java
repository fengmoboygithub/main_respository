package com.company.bean;

import org.springframework.http.HttpStatus;

import com.company.exception.ValidateException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 返回单条json对象 
 * 
 * @author yangyanchao
 * 
 * @param <T>
 */
@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseDataModel<T> extends ResponseModel{
    private T entity;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
    
    public void check() throws ValidateException {
		if (this.getErrors().size() > 0) {
			this.setSuccess(false);
			this.setMessage("有错误发生");
			this.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			throw new ValidateException("有错误发生");
		} else {
			this.setSuccess(true);
		}
	}
}
