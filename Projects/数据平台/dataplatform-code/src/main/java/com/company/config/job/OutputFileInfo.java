package com.company.config.job;

import java.util.Date;

import com.company.utils.DateUtils;
import com.company.utils.DateUtils.DATE_PATTERN;

/**
 * 通用应答文件命名格式类
 * @author yangyanchao
 *
 */
public class OutputFileInfo {
	
	/**
	 * 文件接收人代码
	 */
	private String fileReceiverCode;
	
	/**
	 * 文件创建人代码
	 */
	private String fileCreaterCode;
	
	/**
	 * 接口编号
	 */
	private String interfaceId;
	
	/**
	 * 数据日期
	 */
	private String submissionDate = DateUtils.dataToString(new Date(),DATE_PATTERN.YYYYMMDD);
	
	/**
	 * 当日序号
	 */
	private String fileNum = "0001";
	
	/**
	 * 操作标识
	 */
	private String operationId = "R";
	
	
	/**
	 * 文件扩展名
	 */
	private String fileExt = "TXT";


	public String getFileReceiverCode() {
		return fileReceiverCode;
	}

	public void setFileReceiverCode(String fileReceiverCode) {
		this.fileReceiverCode = fileReceiverCode;
	}

	public String getFileCreaterCode() {
		return fileCreaterCode;
	}

	public void setFileCreaterCode(String fileCreaterCode) {
		this.fileCreaterCode = fileCreaterCode;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public OutputFileInfo(String fileReceiverCode, String fileCreaterCode, String interfaceId, String fileNum) {
		super();
		this.fileReceiverCode = fileReceiverCode;
		this.fileCreaterCode = fileCreaterCode;
		this.interfaceId = interfaceId;
		this.fileNum = fileNum;
	}

	@Override
	public String toString() {
		return "OTC_" + fileReceiverCode + "_" + fileCreaterCode 
				+ "_" + interfaceId+ "_" + submissionDate
				+ "_" + fileNum + "_" + operationId + "." + fileExt;
	}
	public static void main(String[] args) {
		OutputFileInfo ofi = new OutputFileInfo("000899", "131101", "A1001", "0001");
		System.out.println(ofi.toString());
	}
	
}
