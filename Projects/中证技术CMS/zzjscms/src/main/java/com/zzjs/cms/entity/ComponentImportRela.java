/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 组件引入关系实体
 * 
 * @author yangyanchao
 * 
 */

public class ComponentImportRela  extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 组件名称
	 */
	private String componentName;

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	/**
	 * 组件React代码
	 */
	private String htmlCode;
	public String getHtmlCode() {
		return htmlCode;
	}

	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}
	/**
	 * 组件ID
	 */
	private long componentId;
	/**
	 * 导入组件ID
	 */
	private long importId;
	public long getComponentId() {
		return componentId;
	}
	public void setComponentId(long componentId) {
		this.componentId = componentId;
	}
	public long getImportId() {
		return importId;
	}
	public void setImportId(long importId) {
		this.importId = importId;
	}
}
