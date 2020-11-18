/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化类
 * @author yangyanchao
 *
 */
public class DateUtils {
	private DateUtils() {
	}
	/** 日期格式 **/
    public interface DATE_PATTERN {
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYYMMDDHH_MM_SS = "yyyyMMdd HH:mm:ss";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    }
	
	/**
	 * 将日期类型的 转化为字符
	 * @param date
	 * @return
	 */
	public static String dataTimeToString (Date date, String formatStr) {
		String toString = "";
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		toString = sdf.format(date);
		return toString;
	}
	
	/**
	 * 将日期类型的 转化为字符
	 * @param date
	 * @return
	 */
	public static String dataToString (Date date, String formatStr) {
		String toString = "";
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
			toString = sdf.format(date);
		}
		return toString;
	}
	
	/**
	 * 将字符转化为日期类型yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Date stringToDateTime (String string, String formatStr) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将字符转化为日期类型yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static Date stringToDate (String string, String formatStr) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将字符转化为日期类型
	 * @param date
	 * @return
	 */
	public static Date stringToDateByFormat (String string, String format) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String currentDate() {
		Date date = new Date();
		return dataTimeToString(date, DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
	}
	
	/**
	 *	 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(Object date, String pattern) {
		if (date == null) {
			return null;
		}
		if (pattern == null) {
			return format(date);
		}
		return new SimpleDateFormat(pattern).format(date);
	}
	
	/**
	 * 	格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(Object date) {
		return format(date, DATE_PATTERN.YYYY_MM_DD);
	}
	
	public static void main(String[] args) {
//		Date date = DateUtils.stringToDateByFormat("2019-03-04", "yyyyMMdd");
//		String dateTempStr = DateUtils.format(date, "yyyy/M/d");
		
//		Date date =  DateUtils.stringToDate("2019-03-04");
//		String dateTempStr = DateUtils.format(date, "yyyy/M/d");
//		System.out.println(dateTempStr);

    }
}
