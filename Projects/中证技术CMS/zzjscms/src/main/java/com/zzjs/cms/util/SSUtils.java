package com.zzjs.cms.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.util.HtmlUtils;

import freemarker.template.utility.HtmlEscape;

/**
 * @author yangyanchao
 * 
 */
public class SSUtils {

	/**
	 * 把骆驼命名法的变量，变为大写字母变小写且之前加下划线
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnderline(String str) {
		str = StringUtils.uncapitalize(str);
		char[] letters = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char letter : letters) {
			if (Character.isUpperCase(letter)) {
				sb.append("_" + letter + "");
			} else {
				sb.append(letter + "");
			}
		}
		return StringUtils.lowerCase(sb.toString());
	}

	public static String toText(String str) {
		return HtmlUtils.htmlEscape(str);
	}
	
	public static String encodeByMe(String str) {
		if(str==null || str.trim().length() == 0){
			return "";
		}
		String ss = str.replaceAll(">", "&gt;");
		ss = ss.replaceAll("<", "&lt;");
		ss = ss.replaceAll("'", "&#39;");
		ss = ss.replaceAll("\"", "&quot;");
		return ss;
	}
	
	public static String decodeByMe(String str) {
		if(str==null || str.trim().length() == 0){
			return "";
		}
		String ss = str.replaceAll("&gt;", ">");
		ss = ss.replaceAll("&lt;", "<");
		ss = ss.replaceAll("&#39;", "'");
		ss = ss.replaceAll("&quot;", "\"");
		return ss;
	}
	
	public static String toHTML(String str) {
		return HtmlUtils.htmlUnescape(str);
	}
	
	public static String delPToHTML(String str) {
		if(str==null || str.trim().length() == 0) {
			return "";
		}
		str = str.replaceAll("<p>", "");
		str = str.replaceAll("</p>", "");
		return HtmlUtils.htmlUnescape(str);
	}
	
	/**
	 * 去除根目录
	 * @param str
	 * @return
	 */
	public static String delRootFoler(String folerDir) {
		if(folerDir.indexOf("/")>0 && folerDir.length()>=folerDir.indexOf("/")+1){
			folerDir = folerDir.substring(folerDir.indexOf("/")+1);
		}
		return folerDir;
	}

	/**
	 * 得到格式化json数据 退格用\t 换行用\r
	 */
	public static String format(String jsonStr) {
		if(jsonStr == null || jsonStr.length() == 0){
			return "";
		}
		int level = 0;
		StringBuffer jsonForMatStr = new StringBuffer();
		for (int i = 0; i < jsonStr.length(); i++) {
			char c = jsonStr.charAt(i);
			if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
				jsonForMatStr.append(getLevelStr(level));
			}
			switch (c) {
			case '{':
			case '[':
				jsonForMatStr.append(c + "\n");
				level++;
				break;
			case ',':
				jsonForMatStr.append(c + "\n");
				break;
			case '}':
			case ']':
				jsonForMatStr.append("\n");
				level--;
				jsonForMatStr.append(getLevelStr(level));
				jsonForMatStr.append(c);
				break;
			default:
				jsonForMatStr.append(c);
				break;
			}
		}

		return jsonForMatStr.toString();

	}
	
	private static String getLevelStr(int level) {
		StringBuffer levelStr = new StringBuffer();
		for (int levelI = 0; levelI < level; levelI++) {
			levelStr.append("\t");
		}
		return levelStr.toString();
	}
	
	public static void main(String[] args) {
//		String text = "美丽<script>;alert(123);</script>";
//		String text1 = SSUtils.toText(text);
//		System.out.println(text1);
//		System.out.println(HtmlUtils.htmlUnescape(text1));
		
//		String text2 = "<p>美丽&lt;script&gt;;alert(123);&lt;/script&gt;</p>";
//		System.out.println(text2);
//		text2 = text2.replaceAll("<p>", "");
//		System.out.println(text2);
//		text2 = text2.replaceAll("</p>", "");
//		System.out.println(text2);
		
//		String folerDir = "test-root/css/dsd/csd";
//		if(folerDir.indexOf("/")>0 && folerDir.length()>=folerDir.indexOf("/")+1){
//			folerDir = folerDir.substring(folerDir.indexOf("/")+1);
//		}
//		System.out.println(folerDir);
		String ss = "<'\"\"/>";
		System.out.println(encodeByMe(ss));
	}
}
