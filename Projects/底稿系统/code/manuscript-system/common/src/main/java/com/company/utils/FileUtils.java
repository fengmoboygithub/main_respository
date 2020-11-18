/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.security.MessageDigest;

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
	 * 写入文件流到前端
	 * @param filepath
	 * @param filename
	 * @param request
	 * @param response
	 * @return
	 */
	public static void writeTxtFileForWeb (String filepath,
										String filename,
										HttpServletRequest request,
										HttpServletResponse response) throws UnsupportedEncodingException {
		// 如果文件名不为空，则进行下载
		if (filepath != null) {
			File file = new File(filepath);
			// 如果文件存在，则进行下载
			if (file.exists()) {
				// 配置文件下载
				response.setHeader("content-type", "text/plain");
				response.setContentType("text/plain");
				filename = URLEncoder.encode(filename, "UTF-8");
				//filename = new String(filename.getBytes("GB2312"), "ISO_8859_1");
				//告诉客户端下载文件
				if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > -1)
				{
					//response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
					response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

				} else {
					// 下载文件能正常显示中文
					response.setHeader("Content-Disposition", "attachment;filename=" + filename);
				}
				// 实现文件下载
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					logger.info("下载成功");

				} catch (Exception e) {
					logger.info("下载失败");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * 写入文件流到前端
	 * @param filepath
	 * @param filename
	 * @param request
	 * @param response
	 * @return
	 */
	public static void writeZipFileForWeb (String filepath,
										  String filename,
										  HttpServletRequest request,
										HttpServletResponse response) throws UnsupportedEncodingException {
		// 如果文件名不为空，则进行下载
		if (filepath != null) {
			File file = new File(filepath);
			// 如果文件存在，则进行下载
			if (file.exists()) {
				// 配置文件下载
				response.setHeader("content-type", "application/zip");
				response.setContentType("application/zip");
				filename = URLEncoder.encode(filename, "UTF-8");
				//filename = new String(filename.getBytes("GB2312"), "ISO_8859_1");
				//告诉客户端下载文件
				if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > -1)
				{
					//response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
					response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

				} else {
					// 下载文件能正常显示中文
					response.setHeader("Content-Disposition", "attachment;filename=" + filename);
				}
				// 实现文件下载
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					logger.info("下载成功");

				} catch (Exception e) {
					logger.info("下载失败");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * 写入文件
	 * @param writeFile
	 * @param contont
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
	 * @param srcFile
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
	 * 复制文件
	 * @param srcFile
	 * @param destFile
	 * @throws Exception
	 */
	public static void copyFileToFile(File srcFile, File destFile) throws Exception{
		org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
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
	 * 获取文件hash值  MD5
	 * @param file
	 * @return
	 */
	public static String getFileHashForMd5(File file) {
		return Encrypt.hashToMd5(file);
	}

	/**
	 * 获取文件hash值  SHA256
	 * @param file
	 * @return
	 */
	public static String getFileHashForSha256(File file) {
		return Encrypt.hashToSha256(file);
	}

	public static File multipartFileToFile(MultipartFile file) throws Exception {

		File toFile = null;
		if (file.equals("") || file.getSize() <= 0) {
			file = null;
		} else {
			InputStream ins = null;
			ins = file.getInputStream();
			toFile = new File(file.getOriginalFilename());
			inputStreamToFile(ins, toFile);
			ins.close();
		}
		return toFile;
	}

	//获取流文件
	private static void inputStreamToFile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
//		String f = getFileName(new File("E:/dataplatform/scanfile/OTC_TEST_DIR.zip"));
//		System.out.println(f);
		
//		org.apache.commons.io.FileUtils.listFilesAndDirs(new File("E:/dataplatform/scanfile"), new IOFileFilter() {
//
//			@Override
//			public boolean accept(File arg0, String arg1) {
//				System.out.println("arg0:"+arg0.getPath());
//				System.out.println("arg1:"+arg1);
//				return false;
//			}
//
//			@Override
//			public boolean accept(File arg0) {
//				System.out.println("FILE==>>arg0:"+arg0.getPath());
//				return false;
//			}
//		}, new IOFileFilter() {
//
//			@Override
//			public boolean accept(File arg0, String arg1) {
//				System.out.println("arg0:"+arg0.getPath());
//				System.out.println("arg1:"+arg1);
//				return false;
//			}
//
//			@Override
//			public boolean accept(File arg0) {
//				System.out.println("DIR==>>arg0:"+arg0.getPath());
//				return false;
//			}
//		});
		//baf58ef4183fd4e79f66ca003ccafebf
//		File dest1 = new File("M:\\download\\test\\北京青钱信息技术有限公司报价函及公司介绍.pdf");
//		String name1 = FileUtils.getFileHashForMd5(dest1);
//		//87d13fe8044b5342f7d5d45068c15140
//		File dest2 = new File("M:\\download\\test\\北京时易互动科技有限公司.pdf");
//		String name2 = FileUtils.getFileHashForMd5(dest2);
//		//a076b8cdcda775f72f0e65b543842718
//		File dest3 = new File("M:\\download\\test\\中证技术有限责任公司询价函—华路时代.pdf");
//		String name3 = FileUtils.getFileHashForMd5(dest3);
//		System.out.println(name1);
//		System.out.println(name2);
//		System.out.println(name3);

		File dest4 = new File("M:\\11.txt");
		String name4sha256 = Encrypt.hashToSha256(dest4);
		String name4sha512 = Encrypt.hashToSha512(dest4);
		String name4md5 = Encrypt.hashToMd5(dest4);
		System.out.println("sha256:"+name4sha256);
		System.out.println(name4sha256.length());
		System.out.println("sha512:"+name4sha512);
		System.out.println(name4sha512.length());
		System.out.println("md5:"+name4md5);
		System.out.println(name4md5.length());

		String dest5 = "1231231231231233";
		String name5sha256 = Encrypt.hashToSha256(dest5);
		String name5sha512 = Encrypt.hashToSha512(dest5);
		String name5md5 = Encrypt.hashToMd5(dest5);
		System.out.println("sha256:"+name5sha256);
		System.out.println(name5sha256.length());
		System.out.println("sha512:"+name5sha512);
		System.out.println(name5sha512.length());
		System.out.println("md5:"+name5md5);
		System.out.println(name5md5.length());
    }
}
