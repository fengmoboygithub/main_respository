package com.company;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
    public static void testFile(String targetDirPath){
        File targetDir = new File(targetDirPath);
        File[] fileList = targetDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isFile()){
                    String fileName = pathname.getName();
                    String suff = "";
                    if(fileName != null && fileName.length() > 0){
                        suff = fileName.substring(fileName.lastIndexOf("."));
                        fileName = fileName.substring(0,fileName.lastIndexOf("."));
                    }
                    System.out.println("-----------------------------------------");
                    System.out.println("old:"+pathname.getName());
                    File dir = new File(pathname.getParent(), fileName);
                    File file = new File(dir, "EP01"+suff);
                    dir.mkdirs();
                    pathname.renameTo(file);
                    System.out.println("new:"+file.getName());
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                }
                return false;
            }
        });
    }
    public static void main(String[] args) {
        Test3.testFile("D:\\我的资源\\电影\\类型\\灾难");
    }
}
