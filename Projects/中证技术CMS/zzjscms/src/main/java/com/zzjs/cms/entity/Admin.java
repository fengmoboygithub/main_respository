/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 管理员实体
 * 
 * @author yangyanchao
 * 
 */

public class Admin  extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 管理员Id
	 */
	private long adminId;

	/**
	 * 管理员名称
	 */
	private String name;

	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 密码
	 */
	private String password;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
