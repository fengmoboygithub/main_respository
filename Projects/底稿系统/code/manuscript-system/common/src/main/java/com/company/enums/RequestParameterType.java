package com.company.enums;

/**
 * Request参数类型枚举类
 * @author yangyanchao
 *
 */
public enum RequestParameterType {
	/**
     * 	query
     */
	QUERY,
	/**
	 * 	path
	 */
	PATH,
	/**
	 * 	body
	 */
	BODY;

	private RequestParameterType() {
	}
}
