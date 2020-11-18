/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    }
	
	/**
	 * 将日期类型的 转化为字符
	 * @param date
	 * @return
	 */
	public static String dataTimeToString (Date date) {
		String toString = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		toString = sdf.format(date);
		return toString;
	}
	
	/**
	 * 将日期类型的 转化为字符
	 * @param date
	 * @return
	 */
	public static String dataToString (Date date) {
		String toString = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		toString = sdf.format(date);
		return toString;
	}
	
	/**
	 * 将字符转化为日期类型yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Date stringToDateTime (String string) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将字符转化为日期类型yyyy-MM-dd
	 * @param string
	 * @return
	 */
	public static Date stringToDate (String string) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 *	 将字符转化为日期类型yyyyMMdd
	 * @param date
	 * @return
	 */
//	public static Date stringToDate1 (String string) {
//		Date date = null;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		try {
//			date = sdf.parse(string);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}
	
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
		return dataTimeToString(date);
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
