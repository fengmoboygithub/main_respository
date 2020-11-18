package com.zzjs.cms.entity.vo;

import com.zzjs.cms.entity.Component;
import com.zzjs.cms.entity.ComponentType;

public class ComponentVo extends Component {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComponentType componentType;
	
	private String owner = "no";

	public ComponentType getComponentType() {
		return componentType;
	}

	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
