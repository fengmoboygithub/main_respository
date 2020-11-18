package com.company.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * ReflectUtil类  java反射工具类
 */
public class ReflectUtil {
	public final static int RESULT_BIGDECIMAL = 1;
	public final static int RESULT_STRING = 2;
	public final static int RESULT_INTEGER = 3;
	public final static int RESULT_DATE = 4;
	
	
	public static BigDecimal dealBigDecimal(BigDecimal target) {
		if(target==null){
			return null;
		} else {
			return target.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
	}
	
	public static String getStringValByFieldName(Object target, String fieldName, int resultType, String units) throws Exception{
		String resultStr = "";
		Class<?> class1 = target.getClass();
		//获得id 属性
        Field field = class1.getDeclaredField(fieldName);
        //打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问  
        //由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的  
        field.setAccessible(true);
        if(ReflectUtil.RESULT_BIGDECIMAL == resultType){
        	BigDecimal val = (BigDecimal)field.get(target);
        	val = ReflectUtil.dealBigDecimal(val);
			if(val==null){
				resultStr = "--";
			} else {
				resultStr = val.toPlainString();
			}
		} else if(ReflectUtil.RESULT_STRING == resultType){
			resultStr = (String)field.get(target);
			if(resultStr==null){
				resultStr = "--";
			}
		} else if(ReflectUtil.RESULT_INTEGER == resultType){
			BigDecimal val = (BigDecimal)field.get(target);
			if(val==null){
				resultStr = "--";
			} else {
				resultStr = val.toPlainString();
			}
		} else if(ReflectUtil.RESULT_DATE == resultType){
			resultStr = (String)field.get(target);
			if(resultStr==null) {
				resultStr = "--";
			}
		} else {
			resultStr = "非法类型";
		}
        
        return resultStr+units;
	}
	
	public static void main(String[] args) {
		String test = "1%";
		String test1 = test.substring(1);
		System.out.println(test1);
		test = test.substring(0, 1);
		System.out.println(test);
	}
	
}
