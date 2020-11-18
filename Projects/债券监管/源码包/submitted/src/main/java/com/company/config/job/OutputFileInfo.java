package com.company.config.job;

import java.util.Date;

import com.company.utils.DateUtils;
import com.company.utils.DateUtils.DATE_PATTERN;

/**
 * 输出命名格式类
 * @author yangyanchao
 *
 */
public class OutputFileInfo {
	
	/**
	 * 接口编号
	 */
	private String interfaceCode;
	
	/**
	 * 版本号
	 */
	private String versionNum = "V01";
	
	/**
	 * 数据日期
	 */
	private String dataDate = DateUtils.dataToString(new Date(),DATE_PATTERN.YYYYMMDD);
	
	/**
	 * 当日序号
	 */
	private String curSerNum = "01";
	
	/**
	 * 增全量标志
	 */
	private String expFlag = "Q";
	
	
	/**
	 * 文件扩展名
	 */
	private String fileExt = "TXT";

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	public String getExpFlag() {
		return expFlag;
	}

	public void setExpFlag(String expFlag) {
		this.expFlag = expFlag;
	}

	public String getCurSerNum() {
		return curSerNum;
	}

	public void setCurSerNum(String curSerNum) {
		this.curSerNum = curSerNum;
	}

	public String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public OutputFileInfo(String interfaceCode, String expFlag) {
		super();
		this.interfaceCode = interfaceCode;
		this.expFlag = expFlag;
	}

	@Override
	public String toString() {
		return "SAC-BOND_" + interfaceCode + "_" + versionNum + "_" + dataDate
				+ "_" + curSerNum + "_" + expFlag + "." + fileExt;
	}
	public static void main(String[] args) {
		OutputFileInfo ofi = new OutputFileInfo("J001", "Q");
		System.out.println(ofi.toString());
	}
	
}
