package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 数据源模板实体
 * @author yangyanchao
 */
public class DataJsonTemplate extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组件模板id
	 */
	private long templateId;
	/**
	 * json配置en名称
	 */
	private String dataJsonEnName;
	
	/**
	 * json配置名称
	 */
	private String dataJsonName;
	
	/**
	 * json配置代码
	 */
	private String dataJsonCode;

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public String getDataJsonEnName() {
		return dataJsonEnName;
	}

	public void setDataJsonEnName(String dataJsonEnName) {
		this.dataJsonEnName = dataJsonEnName;
	}

	public String getDataJsonName() {
		return dataJsonName;
	}

	public void setDataJsonName(String dataJsonName) {
		this.dataJsonName = dataJsonName;
	}

	public String getDataJsonCode() {
		return dataJsonCode;
	}

	public void setDataJsonCode(String dataJsonCode) {
		this.dataJsonCode = dataJsonCode;
	}
}
