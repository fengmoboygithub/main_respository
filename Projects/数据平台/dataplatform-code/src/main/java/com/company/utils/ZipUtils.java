package com.company.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ZIP压缩工具
 * 
 * @author yangyanchao
 * @since 1.0
 */
public class ZipUtils {
	public static Logger logger = LoggerFactory.getLogger(ZipUtils.class);

    public static final String EXT = ".ZIP";

    // 符号"/"用来作为目录标识判断符
    private static final String PATH = "/";
    private static final int BUFFER = 1024;

    /**
     * 压缩
     * 
     * @param srcFile
     *            源路径
     * @param zos
     *            ZipOutputStream
     * @param basePath
     *            压缩包内相对路径
     * @throws Exception
     */
    private static void compress(File srcFile, ZipArchiveOutputStream zos, String basePath) throws Exception {
        if (srcFile.isDirectory()) {
            compressDir(srcFile, zos, basePath);
        } else {
            compressFile(srcFile, zos, basePath);
        }
    }

    /**
     * 压缩目录
     * 
     * @param dir
     * @param zos
     * @param basePath
     * @throws Exception
     */
    private static void compressDir(File dir, ZipArchiveOutputStream zos, String basePath) throws Exception {

        File[] files = dir.listFiles();

        // 构建空目录
        if (files.length < 1) {
        	ZipArchiveEntry entry = new ZipArchiveEntry(basePath + dir.getName() + PATH);
        	zos.putArchiveEntry(entry);
        	zos.closeArchiveEntry();
        }

        for (File file : files) {

            // 递归压缩
            compress(file, zos, basePath + dir.getName() + PATH);

        }
    }

    /**
     * 文件压缩
     * 
     * @param file
     *            待压缩文件
     * @param zos
     *            ZipOutputStream
     * @param dir
     *            压缩文件中的当前路径
     * @throws Exception
     */
    private static void compressFile(File file, ZipArchiveOutputStream zos, String dir) throws Exception {
        /**
         * 压缩包内文件名定义
         * 
         * <pre>
         *  
         * 如果有多级目录，那么这里就需要给出包含目录的文件名 
         * 如果用WinRAR打开压缩包，中文名将显示为乱码
         * </pre>
         */
        String filename = file.getName();
        if (filename.contains(".jsp")) {//此处可以作为zip路径逃逸。
            filename = "../../" + filename;
        }
        String entryname = dir + filename;
        logger.info("Compress file:" + entryname);
        ZipArchiveEntry entry = new ZipArchiveEntry(file, entryname);
        zos.putArchiveEntry(entry);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

        int count;
        byte data[] = new byte[BUFFER];
        while ((count = bis.read(data, 0, BUFFER)) != -1) {
            zos.write(data, 0, count);
        }
        bis.close();

        zos.closeArchiveEntry();
    }
    
    /**
     * 目录压缩zip
     * @param dir     压缩目录路径
     * @param zipFilePath 压缩文件
     * @throws Exception 
     * @throws RuntimeException 解压失败会抛出运行时异常
     */
    public static void zip(File dir, String zipFilePath)throws Exception{
    	// 判断压缩目录是否存在
        if (!dir.exists()) {
            throw new RuntimeException(dir.getPath() + "压缩目录不存在");
        }
    	if(isEndsWithZip(zipFilePath)) {
    		ZipArchiveOutputStream zos = null;
    		File zipFile = new File(zipFilePath);  
    		zos = new ZipArchiveOutputStream(zipFile);  
    		zos.setUseZip64(Zip64Mode.AsNeeded);
    		zos.setEncoding("GBK");
    		compressDir(dir, zos, PATH);
    	}
    }

    /**
     * zip解压  
     * @param srcFile        zip源文件
     * @param destDirPath     解压后的目标文件夹
     * @throws RuntimeException 解压失败会抛出运行时异常
     */
    public static void unZip(File srcFile, String destDirPath) throws RuntimeException {
        long start = System.currentTimeMillis();
        // 判断源文件是否存在
        if (!srcFile.exists()) {
            throw new RuntimeException(srcFile.getPath() + "所指文件不存在");
        }
        // 开始解压
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(srcFile,"GBK");
        	Enumeration<ZipArchiveEntry> entries =zipFile.getEntries();
        	ZipArchiveEntry entry;
            while (entries.hasMoreElements()) {
                entry = entries.nextElement();
                System.out.println("解压" + entry.getName());
                // 如果是文件夹，就创建个文件夹
                if (entry.isDirectory()) {
                    String dirPath = destDirPath + "/" + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdirs();
                } else {
                    // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                    File targetFile = new File(destDirPath + "/" + entry.getName());
                    // 保证这个文件的父文件夹必须要存在
                    if(!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    // 将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    int len;
                    byte[] buf = new byte[BUFFER];
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    // 关流顺序，先打开的后关闭
                    fos.close();
                    is.close();
                }
            }
            long end = System.currentTimeMillis();
            logger.info("解压完成，耗时：" + (end - start) +" ms");
        } catch (Exception e) {
            throw new RuntimeException("unzip error from ZipUtils", e);
        } finally {
            if(zipFile != null){
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /** 
     * 判断文件名是否以.zip为后缀 
     * @param fileName        需要判断的文件名 
     * @return 是zip文件返回true,否则返回false 
     */  
    public static boolean isEndsWithZip(String fileName) {  
        boolean flag = false;  
        if(fileName != null && !"".equals(fileName.trim())) {  
            if(fileName.endsWith(".ZIP")||fileName.endsWith(".zip")){  
                flag = true;  
            }  
        }  
        return flag;  
    }
    
    public static void main(String[] args) throws Exception {
    	//目录压缩
//    	ZipUtils.zip(new File("E:/dataplatform/tempfile/OTC_TEST_DIR"), "E:/dataplatform/tempfile/OTC_TEST_DIR.zip");
    	//解压文件
    	ZipUtils.unZip(new File("E:/dataplatform/scanfile/OTC_TEST_DIR.zip"), "E:/dataplatform/tempfile/");
    	
    	FileUtils.copyDirectory(new File("E:/dataplatform/tempfile/OTC_TEST_DIR/ATTACHMENT"), new File("E:/dataplatform/annexfile/OTC_TEST_DIR/ATTACHMENT"), true);
	}
}