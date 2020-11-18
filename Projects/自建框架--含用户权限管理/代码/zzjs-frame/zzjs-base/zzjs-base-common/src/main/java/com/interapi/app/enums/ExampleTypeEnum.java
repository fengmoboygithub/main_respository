package com.interapi.app.enums;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.druid.util.StringUtils;

/**
 * mybatisExample类型枚举类
 * NoParam ::  无参数
 * Integer ::  数字类型
 * Long    ::  长数字类型
 * Date    ::  日期类型
 * String  ::  字符串类型
 * BigDecimal::  大数据类型
 */
public enum ExampleTypeEnum {

    /**
     * 无参数
     */
    TYPE_NOPARAM("0",null),

    /***
     * 数字类型
     */
    TYPE_INTEGER("1",Integer.class),
    
    /**
     * 长数字类型
     */
    TYPE_LONG("2",Long.class),
    
    /**
     * 日期类型
     */
    TYPE_DATE("3",Date.class),
    
    /**
     * 字符串类型
     */
    TYPE_STRING("4",String.class),
    
    /**
     * 大数据类型
     */
    TYPE_BIGDECIMAL("5",BigDecimal.class)
    ;
	
	private String code;
	
    private Class<?> value;

    ExampleTypeEnum(String code, Class<?> value) {
    	this.code = code;
        this.value = value;
    }
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Class<?> getValue() {
		return value;
	}
	public void setValue(Class<?> value) {
		this.value = value;
	}
	
	/**
	 * 根据code值返回枚举类 若没有该code值则返回无参枚举
	 * @param code
	 * @return
	 */
	public static ExampleTypeEnum getEnumsByCode(String code){
		if(StringUtils.isEmpty(code)){
			return TYPE_NOPARAM;
		}
		for(ExampleTypeEnum enums : ExampleTypeEnum.values()){
			if(enums.getCode().equals(code)){
				return enums;
			}
		}
		return TYPE_NOPARAM;
	}
	
	public static void main(String[] args) {
		System.out.println(ExampleTypeEnum.getEnumsByCode("0").getValue());
	}
}
