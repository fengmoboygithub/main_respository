package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 组件实体
 * @author yangyanchao
 */
public class Component extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 组件id
	 */
	private long componentId;
	/**
	 * 组件类型ID
	 */
	private long compTypeId;
	/**
	 * 组件名称
	 */
	private String componentName;
	
	/**
	 * 组件Class名称
	 */
	private String className;
	
	/**
	 * 组件React代码
	 */
	private String htmlCode;
	
	/**
	 * 排序
	 */
	private int sort;
	

	public long getComponentId() {
		return componentId;
	}

	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}

	public long getCompTypeId() {
		return compTypeId;
	}

	public void setCompTypeId(long compTypeId) {
		this.compTypeId = compTypeId;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getHtmlCode() {
		return htmlCode;
	}

	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
