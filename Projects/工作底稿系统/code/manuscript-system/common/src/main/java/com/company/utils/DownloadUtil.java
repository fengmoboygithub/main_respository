package com.company.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 *	下载工具类
 * @author fra.zj
 *
 */
public class DownloadUtil {

	/**
	 *	通过流下载文件
	 * @param response
	 * @param uri
	 * @throws Exception
	 */
	public static void downloadByStream(HttpServletResponse response,String uri) throws Exception {
		FileInputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			File file = new File(uri);
			StringBuffer sb = new StringBuffer();
			sb.append("attachment; filename=").append(uri.substring(uri.lastIndexOf("/") + 1, uri.length()));
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("application/x-msdownload;charset=UTF-8");
			response.setHeader("Content-Disposition", new String(sb.toString().getBytes(), "UTF-8"));
			// 将此文件流写入到response输出流中
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, i);
			}
			outputStream.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			outputStream.close();
			inputStream.close();
		}
	}
}
