package com.company.config.interfaceinfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口信息参数类
 * @author yangyanchao
 *
 */
public class InterfaceParamInfo {
	/**
	 * 接口信息参数信息
	 */
	private Map<String, InterfaceParam> info = new HashMap<String, InterfaceParam>();

	public InterfaceParamInfo() {
		super();
	}

	public Map<String, InterfaceParam> getInfo() {
		return info;
	}

	public void setInfo(Map<String, InterfaceParam> info) {
		this.info = info;
	}
	
	public void putItem(String key, InterfaceParam value){
		info.put(key, value);
	}
}
