/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.entity.vo;

import com.zzjs.cms.entity.ComponentInstanceTab;

/**
 * 组件实例实体
 * 
 * @author yangyanchao
 * 
 */

public class ComponentInstanceTabVo  extends ComponentInstanceTab{

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
}
