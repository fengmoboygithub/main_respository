package com.interapi.app.generator.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 返回单条json对象 
 * 
 * @author yangyanchao
 * 
 * @param <T>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseDataModel<T> extends ResponseModel{
    private T entity;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
