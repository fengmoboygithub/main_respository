package com.company.domain.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.base.exception.BaseException;

/**
 * 解析文件相关的domain
 * @author yangyanchao
 *
 */
public class AnalysisFileDomain {
	
	/**
	 * 输出日志
	 */
	private Logger logger = LoggerFactory.getLogger(AnalysisFileDomain.class);
	
	/**
	 * 要解析的文件
	 */
	private File target;
	
	/**
	 * 结束字符
	 */
	private String end;
	
	/**
	 * 普通信息正则表达式
	 */
	private Pattern plainPattern;
	
	/**
	 * 元组信息正则表达式
	 */
	private Pattern tuplePattern;
	
	/**
	 * 首行信息处理操作接口
	 */
	private FirstLineHandle<AnalysisFileDomain> firstLineHandle;
	
	/**
	 * 普通信息循环处理操作接口
	 */
	private PlainLoopHandle<AnalysisFileDomain> plainLoopHandle;
	
	/**
	 * 元组信息循环处理操作接口
	 */
	private TupleLoopHandle<AnalysisFileDomain> tupleLoopHandle;
	
	/**
	 * 普通信息循环结束处理操作接口
	 */
	private PlainLoopEndHandle<AnalysisFileDomain> plainLoopEndHandle;
	
	/**
	 * 元组信息循环结束处理操作接口
	 */
	private TupleLoopEndHandle<AnalysisFileDomain> tupleLoopEndHandle;

	/**
	 * catch处理操作接口
	 */
	private CatchHandle<AnalysisFileDomain> catchHandle;
	
	/**
	 * finlly处理操作接口
	 */
	private FinallyHandle<AnalysisFileDomain> finallyHandle;
	
	/**
	 * 元组信息正则匹配类--内部属性只可读
	 */
	private Matcher tupleMatcher;
	
	/**
	 * 元组子项信息正则匹配类--内部属性只可读
	 */
	private Matcher tupleItemMatcher;
	
	/**
	 * 普通信息正则匹配类--内部属性只可读
	 */
	private Matcher plainItemMatcher;
	
	/**
	 * 元组名称--内部属性只可读
	 */
	private String tupleName = "";
	
	/**
	 * 普通数据总条数--内部属性只可读
	 */
	private int plainItemCount = 0;
	
	/**
	 * 正在读取的行数据--内部属性只可读
	 */
	private String tempLine = null;
	
	/**
	 * 元组子项数据总条数--内部属性只可读
	 */
	private int tupleItemCount = 0;
	
	public AnalysisFileDomain() {
		super();
	}
	
	public AnalysisFileDomain(File target, String end, Pattern plainPattern, Pattern tuplePattern) {
		super();
		this.target = target;
		this.end = end;
		this.plainPattern = plainPattern;
		this.tuplePattern = tuplePattern;
	}
	
	public String getTempLine() {
		return tempLine;
	}

	public String getTupleName() {
		return tupleName;
	}

	public int getPlainItemCount() {
		return plainItemCount;
	}

	public int getTupleItemCount() {
		return tupleItemCount;
	}

	public Matcher getTupleMatcher() {
		return tupleMatcher;
	}

	public Matcher getTupleItemMatcher() {
		return tupleItemMatcher;
	}

	public Matcher getPlainItemMatcher() {
		return plainItemMatcher;
	}

	public File getTarget() {
		return target;
	}

	public void setTarget(File target) {
		this.target = target;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Pattern getPlainPattern() {
		return plainPattern;
	}

	public void setPlainPattern(Pattern plainPattern) {
		this.plainPattern = plainPattern;
	}

	public Pattern getTuplePattern() {
		return tuplePattern;
	}

	public void setTuplePattern(Pattern tuplePattern) {
		this.tuplePattern = tuplePattern;
	}

	public FirstLineHandle<AnalysisFileDomain> getFirstLineHandle() {
		return firstLineHandle;
	}

	public void setFirstLineHandle(FirstLineHandle<AnalysisFileDomain> firstLineHandle) {
		this.firstLineHandle = firstLineHandle;
	}

	public PlainLoopHandle<AnalysisFileDomain> getPlainLoopHandle() {
		return plainLoopHandle;
	}

	public void setPlainLoopHandle(PlainLoopHandle<AnalysisFileDomain> plainLoopHandle) {
		this.plainLoopHandle = plainLoopHandle;
	}

	public TupleLoopHandle<AnalysisFileDomain> getTupleLoopHandle() {
		return tupleLoopHandle;
	}

	public void setTupleLoopHandle(TupleLoopHandle<AnalysisFileDomain> tupleLoopHandle) {
		this.tupleLoopHandle = tupleLoopHandle;
	}

	public PlainLoopEndHandle<AnalysisFileDomain> getPlainLoopEndHandle() {
		return plainLoopEndHandle;
	}

	public void setPlainLoopEndHandle(PlainLoopEndHandle<AnalysisFileDomain> plainLoopEndHandle) {
		this.plainLoopEndHandle = plainLoopEndHandle;
	}

	public TupleLoopEndHandle<AnalysisFileDomain> getTupleLoopEndHandle() {
		return tupleLoopEndHandle;
	}

	public void setTupleLoopEndHandle(TupleLoopEndHandle<AnalysisFileDomain> tupleLoopEndHandle) {
		this.tupleLoopEndHandle = tupleLoopEndHandle;
	}

	public CatchHandle<AnalysisFileDomain> getCatchHandle() {
		return catchHandle;
	}

	public void setCatchHandle(CatchHandle<AnalysisFileDomain> catchHandle) {
		this.catchHandle = catchHandle;
	}

	public FinallyHandle<AnalysisFileDomain> getFinallyHandle() {
		return finallyHandle;
	}

	public void setFinallyHandle(FinallyHandle<AnalysisFileDomain> finallyHandle) {
		this.finallyHandle = finallyHandle;
	}

	/**
	 * 解析操作
	 * @throws BaseException
	 */
	public void analysis() throws BaseException {
		Reader fr = null;
        BufferedReader br = null;
        //元组标识位
    	boolean tupleItemFlag = false;
        //普通数据标识位
    	boolean plainItemFlag = true;
        try {
    		fr = new FileReader(target);
    		br = new BufferedReader(fr);
    		while((tempLine = br.readLine()) != null){
    			if(!end.equals(tempLine)) {
    				tupleMatcher = tuplePattern.matcher(tempLine);
    				if (tupleMatcher.find()) {
    					 if(plainItemFlag){
    						 logger.info("普通数据总条数为："+plainItemCount);
    						 if(plainLoopEndHandle != null){
    							 plainLoopEndHandle.handle(this);
    						 }
    						 plainItemFlag = false;
    					 }
    			         if(tupleItemFlag){
    			        	 logger.info(tupleName+"元组子项数据总条数"+tupleItemCount);
    			        	 if(tupleLoopEndHandle != null){
    			        		 tupleLoopEndHandle.handle(this);
    			        	 }
    			        	 tupleItemCount = 0;
    			        	 tupleName = "";
    			         }
    			         tupleItemFlag = true;
    			         //元组信息
    			         tupleName = tupleMatcher.group(1);
    			      } else {
    			    	  if(tupleItemFlag) {
    			    		  tupleItemMatcher = plainPattern.matcher(tempLine);
    			    		  if (tupleItemMatcher.find()) {
    			    			  if(tupleLoopHandle != null){
    			    				  tupleLoopHandle.handle(this);
    			    			  }
    			    			  tupleItemCount++;
    			    		  }
    			    	  } else {
    			    		  plainItemMatcher = plainPattern.matcher(tempLine);
    			    		  if (plainItemMatcher.find()) {
    			    			  //普通信息
    			    			  if(plainLoopHandle != null){
    			    				  plainLoopHandle.handle(this);
    			    			  }
    			    			  plainItemCount++;
    			    		  } else {
    			    			  //第一行
    			    			  if(firstLineHandle != null){
    			    				  firstLineHandle.handle(this);
    			    			  }
    			    		  }
    			    	  }
    			      }
    			}
    		}
    		if(plainItemFlag){
				 logger.info("普通数据总条数为："+plainItemCount);
				 if(plainLoopEndHandle != null){
					 plainLoopEndHandle.handle(this);
				 }
			}
	        if(tupleItemFlag){
	        	 logger.info(tupleName+"元组子项数据总条数"+tupleItemCount);
	        	 if(tupleLoopEndHandle != null){
	        		 tupleLoopEndHandle.handle(this);
	        	 }
	        }
		} catch (Exception e) {
			if(catchHandle != null){
				catchHandle.handle(this);
			}
			logger.info("文件解析入库临时表异常", e.fillInStackTrace());
			throw new BaseException("文件解析入库临时表异常", e);
		} finally {
			if(finallyHandle != null){
				finallyHandle.handle(this);
			}
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}
			catch (Exception e) {
				logger.info("文件流关闭异常", e.fillInStackTrace());
			}
		}
	}
}
