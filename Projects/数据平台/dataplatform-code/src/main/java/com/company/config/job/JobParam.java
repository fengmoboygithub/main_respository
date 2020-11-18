package com.company.config.job;

import java.io.File;

/**
 * 参数信息类
 * @author yangyanchao
 *
 */
public class JobParam {
	/**
	 * 扫描目录
	 */
	private File scanDir;
	
	/**
	 * 备份目录
	 */
	private File backupDir;
	
	/**
	 * 临时目录
	 */
	private File tempDir;
	
	/**
	 * 附件目录
	 */
	private File annexDir;

	/**
	 * 应答目录
	 */
	private File respondDir;

	/**
	 * 设置插入一批次中最多行数
	 */
	private int insertBatchMaxNum;

	/**
	 * 设置查询一批次中最多行数
	 */
	private int queryBatchMaxNum;

	/**
	 * 字段分隔符
	 */
	private String separator;

	/**
	 * 换行符
	 */
	private String linefeed;

	/**
	 * 结束字符
	 */
	private String end;
	
	/**
	 * 附件目录名称
	 */
	private String attachmentName;
	
	/**
	 * txt文件名正则表达式
	 */
	private String regularTxtname;

	/**
	 * zip文件名正则表达式
	 */
	private String regularZipname;

	/**
	 * 普通信息正则表达式
	 */
	private String regularPlain;

	/**
	 * 元组信息正则正则表达式
	 */
	private String regularTuple;

	public JobParam() {
		super();
	}

	public JobParam(File scanDir, File backupDir, File tempDir, File annexDir, File respondDir, int insertBatchMaxNum,
			int queryBatchMaxNum, String separator, String linefeed, String end, String attachmentName,
			String regularTxtname, String regularZipname, String regularPlain, String regularTuple) {
		super();
		this.scanDir = scanDir;
		this.backupDir = backupDir;
		this.tempDir = tempDir;
		this.annexDir = annexDir;
		this.respondDir = respondDir;
		this.insertBatchMaxNum = insertBatchMaxNum;
		this.queryBatchMaxNum = queryBatchMaxNum;
		this.separator = separator;
		this.linefeed = linefeed;
		this.end = end;
		this.attachmentName = attachmentName;
		this.regularTxtname = regularTxtname;
		this.regularZipname = regularZipname;
		this.regularPlain = regularPlain;
		this.regularTuple = regularTuple;
	}


	public File getScanDir() {
		return scanDir;
	}

	public void setScanDir(File scanDir) {
		this.scanDir = scanDir;
	}

	public File getBackupDir() {
		return backupDir;
	}

	public void setBackupDir(File backupDir) {
		this.backupDir = backupDir;
	}

	public File getTempDir() {
		return tempDir;
	}

	public void setTempDir(File tempDir) {
		this.tempDir = tempDir;
	}

	public File getAnnexDir() {
		return annexDir;
	}

	public void setAnnexDir(File annexDir) {
		this.annexDir = annexDir;
	}

	public File getRespondDir() {
		return respondDir;
	}

	public void setRespondDir(File respondDir) {
		this.respondDir = respondDir;
	}

	public int getInsertBatchMaxNum() {
		return insertBatchMaxNum;
	}

	public void setInsertBatchMaxNum(int insertBatchMaxNum) {
		this.insertBatchMaxNum = insertBatchMaxNum;
	}

	public int getQueryBatchMaxNum() {
		return queryBatchMaxNum;
	}

	public void setQueryBatchMaxNum(int queryBatchMaxNum) {
		this.queryBatchMaxNum = queryBatchMaxNum;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getLinefeed() {
		return linefeed;
	}

	public void setLinefeed(String linefeed) {
		this.linefeed = linefeed;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getRegularTxtname() {
		return regularTxtname;
	}

	public void setRegularTxtname(String regularTxtname) {
		this.regularTxtname = regularTxtname;
	}

	public String getRegularZipname() {
		return regularZipname;
	}

	public void setRegularZipname(String regularZipname) {
		this.regularZipname = regularZipname;
	}

	public String getRegularPlain() {
		return regularPlain;
	}

	public void setRegularPlain(String regularPlain) {
		this.regularPlain = regularPlain;
	}

	public String getRegularTuple() {
		return regularTuple;
	}

	public void setRegularTuple(String regularTuple) {
		this.regularTuple = regularTuple;
	}

	@Override
	public String toString() {
		return "JobParam [scanDir=" + scanDir + ", backupDir=" + backupDir + ", tempDir=" + tempDir + ", annexDir="
				+ annexDir + ", respondDir=" + respondDir + ", insertBatchMaxNum=" + insertBatchMaxNum
				+ ", queryBatchMaxNum=" + queryBatchMaxNum + ", separator=" + separator + ", linefeed=" + linefeed
				+ ", end=" + end + ", attachmentName=" + attachmentName + ", regularTxtname=" + regularTxtname
				+ ", regularZipname=" + regularZipname + ", regularPlain=" + regularPlain + ", regularTuple="
				+ regularTuple + "]";
	}
}
