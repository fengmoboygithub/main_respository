/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.utils;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 字符处理操作类
 * @author yangyanchao
 *
 */
public class StringUtils {
	public static Logger logger = LoggerFactory.getLogger(StringUtils.class);
	private StringUtils() {
	}
	private static String hexString = "0123456789ABCDEF";
	
	/**
	 *	将字符串编码成16进制数字,适用于所有字符（包括中文）
	 */
	public static String encode(String str) {
		// 根据默认编码获取字节数组
		byte[] bytes = str.getBytes();
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		// 将字节数组中每个字节拆解成2位16进制整数
		for (int i = 0; i < bytes.length; i++) {
			sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
			sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
		}
		return sb.toString();
	}

	/**
	 *	将16进制数字解码成字符串,适用于所有字符（包括中文）
	 */
	public static String decode(String bytes) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
		// 将每2位16进制整数组装成一个字节
		for (int i = 0; i < bytes.length(); i += 2)
			baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
		return new String(baos.toByteArray());
	}
	/**
	 * 将字符串进行转义处理
	 * @param date
	 * @return
	 */
	public static String transfDeal(String contont) {
		String result = contont;
		if(contont == null || contont.length() == 0){
			return "";
		}
		//转义处理
		/**
		 *  （1）若存在半角双引号（即"），应替换成一对半角双引号（即""）进行转义，同时应用另一对半角双引号（即""）将该字段值包含起来；
		 *  （2）若存在半角逗号（即,）应用一对半角双引号（即""）将该字段值包含起来；
		 *  （3）若存在上述约定的换行符0x0A时，以0x1E对其进行替换。
		 */
		if(result.indexOf(decode("0A")) >= 0){
			result = result.replaceAll(decode("0A"), decode("1E"));
		}
		if(result.indexOf("\"") >= 0){
			result = result.replaceAll("\"", "\"\"");
			result = "\""+result+"\"";
		} else if(result.indexOf(",") >= 0){
			result = "\""+result+"\"";
		}
		return result;
		
	}
	
	public static void main(String[] args) {
//		String str = "1"+decode("0A")+"1";
//		str = str.replaceAll(decode("0A"), decode("1E"));
//		System.out.println(str);
		String versionNum = String.format("V%02d", 1);
		String versionNum1 = String.format("V%02d", 11);
		System.out.println(versionNum);
		System.out.println(versionNum1);
    }
}
