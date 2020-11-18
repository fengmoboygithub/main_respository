package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void testFile(String targetDirPath, String patternStr){
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
                    Pattern pattern = Pattern.compile(patternStr);
                    Matcher matcher = pattern.matcher(fileName);
                    if(matcher.find()){
                        String newFileName = matcher.group(1);
                        if(newFileName != null && newFileName.length() > 0){
                            String fName = "EP"+newFileName+suff;
                            if(newFileName.length() == 1){
                                fName = "EP0"+newFileName+suff;
                            }
                            System.out.println("new:"+fName);
                            pathname.renameTo(new File(pathname.getParent(), fName));
                        } else {
                            System.out.println("No find");
                        }
                    }
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                }
                return false;
            }
        });
    }
    public static void main(String[] args) {
        Test2.testFile("E:\\一代女皇",
                "^『一代女皇』第(\\d+)|(.+)$");
    }
}
