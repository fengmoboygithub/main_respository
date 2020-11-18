/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件读写操作类
 * @author yangyanchao
 *
 */
public class FileUtils {
	public static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	private FileUtils() {
	}
	/**
	 * 写入文件
	 * @param date
	 * @return
	 */
	public static void writeFile (File writeFile, String contont) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream(writeFile,true);
			bos = new BufferedOutputStream(fos);
			StringBuffer sb = new StringBuffer(contont);
			bos.write(sb.toString().getBytes("utf-8"));
			bos.flush();
		} catch(IOException e){
			logger.info("写入文件出错",e.fillInStackTrace());
		} finally {
			try {
				if(bos != null){
					bos.close();
				}
				if(fos != null){
					fos.close();
				}
			} catch (IOException e) {
				logger.info("写入文件时流关闭出错",e.fillInStackTrace());
			}
		}
	}

	public static void main(String[] args) {

    }
}
