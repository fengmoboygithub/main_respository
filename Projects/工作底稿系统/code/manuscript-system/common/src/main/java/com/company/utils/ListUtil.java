package com.company.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * list工具类
 */
public class ListUtil {
	
	/**
	 * String转List<Map<String,Object>>
	 */
	public static List<Map<String, Object>> toListMap(String json){
        List<Object> list =JSON.parseArray(json);
         
        List< Map<String,Object>> listw = new ArrayList<Map<String,Object>>();
        for (Object object : list){
        Map<String,Object> ageMap = new HashMap<String,Object>();
        Map <String,Object> ret = (Map<String, Object>) object;//取出list里面的值转为map
        listw.add(ret);
        }
        return listw;
         
    }
}
