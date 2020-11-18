package com.company.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;

public class StringUtil {
	public static final char UNDERLINE = '_';
    /**
     * 匹配空格、回车、换行符、制表符
     */
    private static String REGULAR_EMPTY = "\\s*|\t|\r|\n";

    /**
     *	将匹配的字符置为空
     */
    public static String trimByRegular(String patternStr, String replaceStr) {
        String result = "";
        if(patternStr != null && patternStr.length() > 0) {
            Pattern p = Pattern.compile(REGULAR_EMPTY);
            Matcher m = p.matcher(patternStr);
            if(replaceStr == null) {
                replaceStr = "";
            }
            result = m.replaceAll(replaceStr);
        }
        return result;
    }
	/**
     * 驼峰格式字符串转换为下划线格式字符串
     * 
     * @param param
     * @return
     */
    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线格式字符串转换为驼峰格式字符串
     * 
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    /**
     * 首字母大写
     * 
     * @param param
     * @return
     */
    public static String firstCharToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (i == 0) {
                sb.append(Character.toUpperCase(param.charAt(i)));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    /**
     * 字符转double
     * @param param
     * @return
     */
    public static Double stringToDouble(String param) {
        return (param == null || param.length() == 0) ? null : new BigDecimal(param).doubleValue();
    }
    
    /**
     * 得到不为null的字符串
     * @param param
     * @return
     */
    public static String getNotEmptyString(String param) {
        return StringUtils.isEmpty(param) ? "" : param.trim();
    }
    
    public static void main(String[] args) {
    	System.out.println(StringUtil.firstCharToCamel("dept_id"));
	}
}
