package com.company.resolve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.base.exception.BaseException;

/**
 * 将文件内容解析为java实体信息类
 * @author yangyanchao
 *
 */
public class FileToInfo {
	private Logger logger = LoggerFactory.getLogger(FileToInfo.class);
	//普通信息列表
    private List<Map<String,String>> plainList = new ArrayList<Map<String,String>>();
    //普通信息条数
    private String plainSize = null;
    //元组Map
    Map<String, List<Map<String,String>>> tupleMap = new LinkedHashMap<String, List<Map<String,String>>>();
    //普通信息正则匹配
    private Pattern plainPattern = Pattern.compile("^([^\\|]+)\\|(.+)$");
    //元组信息正则匹配
    private Pattern tuplePattern = Pattern.compile("^([^\\|]+)\\|(\\d+)$");
    
    public FileToInfo() {
		super();
	}

	/** 
	 * 序列化为字符串
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("普通信息条数:");
		sb.append(plainSize);
		sb.append("\n");
		if(plainList.size() != 0){
			for(Map<String,String> plainItem : plainList){
				sb.append("普通信息:");
				for(Entry<String, String> plainItemEntry : plainItem.entrySet()){
					sb.append("{key==>>");
					sb.append(plainItemEntry.getKey());
					sb.append(", value==>>");
					sb.append(plainItemEntry.getValue());
					sb.append("}");
				}
				sb.append("\n");
			}
		}
		if(tupleMap.size() != 0){
			for(Entry<String, List<Map<String,String>>> entry : tupleMap.entrySet()){
				String key = entry.getKey();
				sb.append("元组信息:");
				sb.append(key);
				sb.append("\n");
				List<Map<String,String>> value = entry.getValue();
				if(value != null && value.size() != 0) {
					for(Map<String,String> sub : value){
						sb.append(key+"的元组子项信息:");
						for(Entry<String, String> subEntry : sub.entrySet()){
							sb.append("{key==>>");
							sb.append(subEntry.getKey());
							sb.append(", value==>>");
							sb.append(subEntry.getValue());
							sb.append("}");
						}
						sb.append("\n");
					}
				}
			}
		}
		return sb.toString();
	}
	
	/** 
	 * 序列化为字符串列表
	 */
	public List<String> toList() {
		List<String> list = new ArrayList<String>();
		if(plainList.size() != 0){
			for(Map<String,String> plainItem : plainList){
				for(Entry<String, String> plainItemEntry : plainItem.entrySet()){
					String plainItemKey = plainItemEntry.getKey().trim();
					String plainItemValue = plainItemEntry.getValue().trim();
					if(tupleMap.size() != 0){
						//遍历元组信息
						for(Entry<String, List<Map<String,String>>> entry : tupleMap.entrySet()){
							String tupleKey = entry.getKey().trim();
							List<Map<String,String>> value = entry.getValue();
							StringBuilder tupleString = new StringBuilder();
							if(value != null && value.size() != 0) {
								for(Map<String,String> sub : value){
									for(Entry<String, String> subEntry : sub.entrySet()){
										String subKey = subEntry.getKey().trim();
										String subValue = subEntry.getValue().trim();
										if(subKey.equals(plainItemKey)){
											tupleString.append(subValue);
											tupleString.append(",");
										}
									}
								}
							}
							if(plainItemValue.indexOf(tupleKey) > -1 && tupleString.length() > 0){
								plainItemValue = plainItemValue.replaceAll(tupleKey, "["+tupleString.toString()+"]");
							}
						}
					}
					list.add(plainItemValue);
				}
			}
		}
		return list;
	}

	/**
	 * 读取文件内容 并将该内容解析的数据赋值到对象本身
	 * @param filePath
	 * @return
	 * @throws BaseException
	 */
	public FileToInfo resolveFile(File file) throws BaseException{
		Reader fr = null;
        BufferedReader br = null;
        //普通数据总条数
        int plainItemCount = 0;
        //元组名称
        String tupleName = "";
        //元组子项数据总条数
        int tupleItemCount = 0;
        boolean tupleItemFlag = false;
        boolean plainItemFlag = true;
        try {
    		fr = new FileReader(file);
    		br = new BufferedReader(fr);
    		String temp = null;
    		while((temp = br.readLine()) != null){
    			if(!"END".equals(temp)) {
    				Matcher tupleMatcher = tuplePattern.matcher(temp);
    				if (tupleMatcher.find()) {
    					 if(plainItemFlag){
    						 System.out.println("普通数据总条数为："+plainItemCount);
    						 plainItemFlag = false;
    					 }
    			         if(tupleItemFlag){
    			        	 System.out.println(tupleName+"元组子项数据总条数"+tupleItemCount);
    			        	 tupleItemCount = 0;
    			        	 tupleName = "";
    			         }
    			         tupleItemFlag = true;
    			         //元组信息
    			         tupleName = tupleMatcher.group(1);
    			      } else {
    			    	  if(tupleItemFlag) {
    			    		  Matcher plainMatcher = plainPattern.matcher(temp);
    			    		  if (plainMatcher.find()) {
    			    			  //元组子项信息
        			    		  tupleItemCount++;
    			    		  }
    			    	  } else {
    			    		  Matcher plainMatcher = plainPattern.matcher(temp);
    			    		  if (plainMatcher.find()) {
    			    			  //普通信息
    			    			  plainItemCount++;
    			    		  } else {
    			    			  //普通信息条数
    			    			  plainSize = temp;
    			    		  }
    			    	  }
    			      }
    			}
    		}
    		System.out.println(tupleName+"元组子项数据总条数"+tupleItemCount);
		} catch (Exception e) {
			logger.info("文件解析异常", e.fillInStackTrace());
		} finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				logger.info("文件流关闭异常", e.fillInStackTrace());
			}
		}
    	return this;
    }
}
