/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.base.json;

import java.util.HashMap;

/**
 * 返回单条json对象 
 * @author yangyanchao
 *	
 */
public class BaseJson {
	/**
	 * 结果 true为成功 false为失败
	 */
	protected boolean result;
	/**
	 * 成功的消息
	 */
	protected String msg;

	/**
	 * 具体每个输入错误的消息
	 */
	protected HashMap<String, String> errors = new HashMap<String, String>();

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HashMap<String, String> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}
}
