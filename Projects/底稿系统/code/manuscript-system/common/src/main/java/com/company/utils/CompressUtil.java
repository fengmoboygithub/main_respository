package com.company.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 生成压缩文件 （zip，rar 格式）
 */
public class CompressUtil {
	
	private static Logger logger = LoggerFactory.getLogger(CompressUtil.class);

    /**
     * @param path   要压缩的文件路径
     * @param format 生成的格式（zip、rar）d
     */
    public static void generateFile(String path, String zipFilePath) throws Exception {
        File file = new File(path);
        // 压缩文件的路径不存在
        if (!file.exists()) {
            throw new Exception("路径 " + path + " 不存在文件，无法进行压缩...");
        }
        // 目的压缩文件
        File zipFile = new File(zipFilePath);
        // 用于存放压缩文件的文件夹
        File parentFile = zipFile.getParentFile();
        // 如果文件夹不存在，进行创建
        if( !parentFile.exists() ){
        	parentFile.mkdirs();
        }

        // 输入流 表示从一个源读取数据
        // 输出流 表示向一个目标写入数据

        // 输出流
        FileOutputStream outputStream = new FileOutputStream(zipFile);

        // 压缩输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outputStream));

        generateFile(zipOutputStream, file, "");

        logger.info("源文件位置：" + file.getAbsolutePath() + "，目的压缩文件生成位置：" + zipFile.getAbsolutePath());
        // 关闭 输出流
        zipOutputStream.close();
    }

    /**
     * @param out  输出流
     * @param file 目标文件
     * @param dir  文件夹
     * @throws Exception
     */
    private static void generateFile(ZipOutputStream out, File file, String dir) throws Exception {

        // 当前的是文件夹，则进行一步处理
        if (file.isDirectory()) {
            //得到文件列表信息
            File[] files = file.listFiles();

            //将文件夹添加到下一级打包目录
            out.putNextEntry(new ZipEntry(dir + "/"));

            dir = dir.length() == 0 ? "" : dir + "/";

            //循环将文件夹中的文件打包
            for (int i = 0; i < files.length; i++) {
                generateFile(out, files[i], dir + files[i].getName());
            }

        } else { // 当前是文件

            // 输入流
            FileInputStream inputStream = new FileInputStream(file);
            // 标记要打包的条目
            out.putNextEntry(new ZipEntry(dir));
            // 进行写操作
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
            // 关闭输入流
            inputStream.close();
        }

    }

    // 测试
    public static void main(String[] args) {
        String path = "E:/dataplatform/backupfile";
        String zipFilePath = "E:/dataplatform/me/backupfile.zip";

        try {
            generateFile(path, zipFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }

    }

}