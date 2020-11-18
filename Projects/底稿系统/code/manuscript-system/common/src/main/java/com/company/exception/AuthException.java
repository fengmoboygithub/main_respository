/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.company.exception;

import com.company.base.exception.BaseException;

/**
 * 
 * 系统配置Key获得的Value为空
 * 
 * @author yangyanchao
 * 
 */
public class AuthException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthException(String msg) {
		super(msg);
	}
}
