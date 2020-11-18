package com.company.config.interfaceinfo;
/**
 * 接口信息参数类
 * @author yangyanchao
 *
 */
public class InterfaceParam {
	/**
	 * 接口编码
	 */
	private String code;
	/**
	 * 报告库调用接口类型
	 */
	private String type;
	/**
	 * 关联编码
	 */
	private String rela;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRela() {
		return rela;
	}
	public void setRela(String rela) {
		this.rela = rela;
	}
	public InterfaceParam(String code, String type, String rela) {
		super();
		this.code = code;
		this.type = type;
		this.rela = rela;
	}
	public InterfaceParam() {
		super();
	}
	
}
