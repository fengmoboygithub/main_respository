/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.base.exception.BaseException;

/**
 * 日期格式化类
 * @author yangyanchao
 *
 */
public class TikaUtils {
	public static Logger logger = LoggerFactory.getLogger(TikaUtils.class);
	
	/**
	 * 将日期类型的 转化为字符
	 * @param date
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Map<String, String> parseByFile (File file) throws BaseException{
		Map<String, String> map = new HashMap<String, String>();
		//构建InputStream来读取数据
		//可以写文件路径，pdf，word，html等
		InputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.info("文件未找到。。。", e.fillInStackTrace());
			throw new BaseException("文件未找到", e);
		}
		BodyContentHandler textHandler = new BodyContentHandler();
		//Metadata对象保存了作者，标题等元数据
		Metadata matadata = new Metadata();
		//当调用parser，AutoDetectParser会自动估计文档MIME类型
		Parser parser = new AutoDetectParser();
		ParseContext context = new ParseContext();
		//执行解析过程
		try {
			parser.parse(input, textHandler, matadata, context);
			map.put("author", matadata.get(Metadata.AUTHOR));
			map.put("createTime", matadata.get(Metadata.DATE));
			String text = textHandler.toString();
			//将文本中的换行符、制表符去掉
			//text = StringUtils.trimByRegular(text, null);
			map.put("body", text);
		} catch (Exception e) {
			logger.info("解析异常。。。", e.fillInStackTrace());
			throw new BaseException("解析异常", e);
		} finally {
			try {
				if(input != null) {
					input.close();
				}
			} catch (IOException e) {
			}
		}
		return map;
	}
	
	/**
	 * 打印结果
	 * @param map
	 * @param fileType
	 */
	private static void printMe(Map<String, String> map, String fileType){
		System.out.println(fileType+"内容抽取:");
		System.out.println("\tAuthor: "+map.get("author"));
		System.out.println("\tCreatetime: "+map.get("createTime"));
		String body = map.get("body");
		System.out.println("\tBody: "+body);
	}
	
	public static void main(String[] args) throws Exception {
		//test.pdf
		File pdfFile = new File("E:/工作底稿系统/elasticsearch/testfile/test.pdf");
		Map<String, String> map = TikaUtils.parseByFile(pdfFile);
		TikaUtils.printMe(map, "pdf");
		Long pdfFileLen = pdfFile.length();
		System.out.println("\tpdfFileLen：" + pdfFileLen);
		String body = map.get("body");
		int bodySize = body.getBytes().length;
		System.out.println("\tBodyLen: "+bodySize);
		System.out.println("\t比例: "+(int)(pdfFileLen/bodySize));
		
//		//test.doc
//		File docFile = new File("E:/工作底稿系统/elasticsearch/testfile/test.doc");
//		TikaUtils.printMe(TikaUtils.parseByFile(docFile), "doc");
//		//test.docx
//		File docxFile = new File("E:/工作底稿系统/elasticsearch/testfile/test.docx");
//		TikaUtils.printMe(TikaUtils.parseByFile(docxFile), "docx");
//		//test.xls
//		File xlsFile = new File("E:/工作底稿系统/elasticsearch/testfile/test.xls");
//		TikaUtils.printMe(TikaUtils.parseByFile(xlsFile), "xls");
//		//test.xlsx
//		File xlsxFile = new File("E:/工作底稿系统/elasticsearch/testfile/test.xlsx");
//		TikaUtils.printMe(TikaUtils.parseByFile(xlsxFile), "xlsx");
		//54
    }
}
