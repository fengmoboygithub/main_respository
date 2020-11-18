package com.company.bean;


import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 返回多条数据json对象
 * 
 * @author yangyanchao
 * 
 * @param <T>
 */ 
@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseDataListModel<T> extends ResponseModel{
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
