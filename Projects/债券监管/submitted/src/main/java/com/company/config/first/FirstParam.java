package com.company.config.first;

/**
 * 首次报送参数类
 * @author yangyanchao
 *
 */
public class FirstParam {
	/**
	 * 首次报送标识
	 */
	private boolean flag;
	/**
	 * 首次报送接口编码
	 */
	private String interfaceCode;

	public FirstParam() {
		super();
	}

	public FirstParam(boolean flag, String interfaceCode) {
		super();
		this.flag = flag;
		this.interfaceCode = interfaceCode;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
}
