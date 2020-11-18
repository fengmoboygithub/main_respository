package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 组件模板实体
 * @author yangyanchao
 */
public class ComponentTemplate extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组件id
	 */
	private long componentId;
	/**
	 * 组件模板名称
	 */
	private String templateName;
	
	/**
	 * 是否默认模板
	 */
	private String isDefault;

	public long getComponentId() {
		return componentId;
	}

	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

}
