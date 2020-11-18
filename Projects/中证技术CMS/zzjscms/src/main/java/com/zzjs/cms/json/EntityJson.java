/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.zzjs.cms.base.json.BaseJson;
import com.zzjs.cms.exception.ValidateException;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class EntityJson<T> extends BaseJson{
	/**
	 * 返回的数据
	 */
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public void check() throws ValidateException {
		if (this.getErrors().size() > 0) {
			this.setResult(false);
			throw new ValidateException("有错误发生");
		} else {
			this.setResult(true);
		}
	}
}
