package com.company.base.model;

/**
 * 基本的选项对象封装
 * @author yangyanchao
 *
 */
@SuppressWarnings("serial")
public class BaseOption extends BaseModel{
	/**
	 * key值
	 */
	private String key;
	/**
	 * 文本值
	 */
	private String label;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
