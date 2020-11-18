package com.company.base.handle;

import com.company.base.exception.BaseException;

/**
 * 操作处理接口
 * @author yangyanchao
 *
 */
public interface Handle<T> {
	/**
	 * 操作处理
	 */
	public void handle(T t) throws BaseException;
}
