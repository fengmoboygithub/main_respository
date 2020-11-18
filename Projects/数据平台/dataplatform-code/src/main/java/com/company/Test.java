package com.company;

import com.company.base.exception.BaseException;

public class Test {
	public static void main(String[] args) throws BaseException {
//		String sdf = "|Z19042300100111000002|2019-04-11|0|0|||方圆天成-汉唐壹号沪港深核心价值私募证券投资基金|3214|方圆天成资产管理（深圳）有限公司|914403003265274945|1|11||400.00||主协议.pdf|CounterpartyInformationTuple|asdaTuple1";
//		System.out.println(DigestUtils.md5DigestAsHex(sdf.getBytes()));
//		System.out.println(DigestUtils.md5DigestAsHex(sdf.getBytes()).length());
//        String filename = "E:\\债券监管\\文档.zip";
//        InputStream fis = null;
//        BufferedInputStream bis = null;
//    	try {
//			fis = new FileInputStream(filename);
//			bis = new BufferedInputStream(fis);
//			System.out.println(DigestUtils.md5DigestAsHex(bis));
//			System.out.println(DigestUtils.md5DigestAsHex(bis).length());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(bis != null) {
//					bis.close();
//				}
//				if(fis != null) {
//					fis.close();
//				}
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
//		String filePath = "E:\\数据平台\\OTC_131101_000899_A1001_20171211_0001_A.TXT";
//		FileToInfo fileToInfo = new FileToInfo();
//		File file = new File(filePath);
//		Pattern fileNamePattern = Pattern.compile("^OTC_([^_]+)_([^_]+)_([^_]+)_([^_]+)_([^_]+)_([^_]+)\\.TXT$");
//		Matcher fileNameMatcher = fileNamePattern.matcher(file.getName());
//		if(fileNameMatcher.find()){
//			System.out.println(fileNameMatcher.group(1)+"$"+fileNameMatcher.group(2)+"$"+fileNameMatcher.group(3)+"$"
//					+fileNameMatcher.group(4)+"$"+fileNameMatcher.group(5)+"$"+fileNameMatcher.group(6));
//			try {
//				System.out.println(fileToInfo.resolveFile(file).toList());
//			} catch (BaseException e) {
//				e.printStackTrace();
//			}
//		} else {
//			
//		}
//		String filePath = "E:\\数据平台\\OTC_131101_000899_A1001_20171211_0001_A.TXT";
//		FileToInfo fileToInfo = new FileToInfo();
//		File file = new File(filePath);
//		fileToInfo.resolveFile(file);
//		Pattern fileNamePattern = Pattern.compile("^(.+)(\\.TXT|\\.txt)$");
//		Matcher fileNameMatcher = fileNamePattern.matcher("test.TXT");
//		if(fileNameMatcher.find()){
//			System.out.println("匹配");
//		} else {
//			System.out.println("未匹配");
//		}
		System.out.println(String.format("%08d", 123));
	}
}
