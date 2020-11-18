/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

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
	
	/**
	 * 复制目录
	 * @param srcDir
	 * @param destDir
	 * @param isDelete 是否删除原来目录
	 * @throws Exception 
	 */
	public static void copyDirectory(File srcDir, File destDir, boolean isDelete) throws Exception{
		org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir);
		if(srcDir.exists() && isDelete){
			if(srcDir.isDirectory()){
				org.apache.commons.io.FileUtils.deleteDirectory(srcDir);
			} else {
				srcDir.deleteOnExit();
			}
		}
	}
	
	/**
	 * 复制文件到指定目录
	 * @param srcDir
	 * @param destDir 指定目录
	 * @param isDelete 是否删除原来文件
	 * @throws Exception 
	 */
	public static void copyFileToDirectory(File srcFile, File destDir, boolean isDelete) throws Exception{
		org.apache.commons.io.FileUtils.copyFileToDirectory(srcFile, destDir);
		if(srcFile.exists() && isDelete){
			if(srcFile.isDirectory()){
				org.apache.commons.io.FileUtils.deleteDirectory(srcFile);
			} else {
				org.apache.commons.io.FileUtils.deleteQuietly(srcFile);
			}
		}
	}
	
	/**
	 * 删除指定目录
	 * @param srcDir
	 * @throws Exception
	 */
	public static void deleteDirectory(File srcDir)throws Exception{
		org.apache.commons.io.FileUtils.deleteDirectory(srcDir);
	}
	
	
	/**
	 * 获取文件名称 去掉后缀
	 * @param file
	 * @return
	 */
	public static String getFileName(File file){
		String fileName = file.getName();
		if(fileName != null && fileName.length() > 0){
			int endIndex = fileName.lastIndexOf(".");
			return fileName.substring(0, endIndex);
		}
		return "";
	}
	
	/**
	 * 获取文件hash值
	 * @param file
	 * @return
	 */
	public static String getFileHash(File file){
		InputStream fis = null;
		BufferedInputStream bis = null;
		String result = "";
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			result = DigestUtils.md5DigestAsHex(bis);
		} catch (Exception e) {
			logger.info("文件hash值获取是吧",e.fillInStackTrace());
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		String f = getFileName(new File("E:/dataplatform/scanfile/OTC_TEST_DIR.zip"));
//		System.out.println(f);
		org.apache.commons.io.FileUtils.listFilesAndDirs(new File("E:/dataplatform/scanfile"), new IOFileFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				System.out.println("arg0:"+arg0.getPath());
				System.out.println("arg1:"+arg1);
				return false;
			}
			
			@Override
			public boolean accept(File arg0) {
				System.out.println("FILE==>>arg0:"+arg0.getPath());
				return false;
			}
		}, new IOFileFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				System.out.println("arg0:"+arg0.getPath());
				System.out.println("arg1:"+arg1);
				return false;
			}
			
			@Override
			public boolean accept(File arg0) {
				System.out.println("DIR==>>arg0:"+arg0.getPath());
				return false;
			}
		});
		
    }
}
