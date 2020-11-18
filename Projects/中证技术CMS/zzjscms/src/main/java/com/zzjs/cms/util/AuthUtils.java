/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.util;

import org.apache.commons.codec.digest.DigestUtils;

import com.zzjs.cms.constant.SystemConstant;
import com.zzjs.cms.exception.AuthException;

/**
 * 授权相关的工具类
 * 
 * @author yangyanchao
 * 
 */
public class AuthUtils {

	/**
	 * 生产密文密码
	 * 
	 * @param password
	 *            明文密码
	 * @param email
	 *            邮箱
	 * @return
	 * @throws AuthException
	 */
	public static String getPassword(String password) {
		return DigestUtils.md5Hex(password).toLowerCase();
	}

	/**
	 * @param str
	 * @return
	 */
	public static String MD5(String str) {
		return DigestUtils.md5Hex(str).toLowerCase();
	}

	/**
	 * @param email
	 * @return
	 */
	public static String getFaceUrl(String email) {
		return SystemConstant.FACE_URL + "/" + AuthUtils.MD5(email) + ".jpg";
	}
}
