/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 站点实体
 * 
 * @author yangyanchao
 * 
 */

public class Site extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 站点Id
	 */
	private long siteId;

	/**
	 * 站点中文名称
	 */
	private String siteName;
	
	/**
	 * 站点英文名称
	 */
	private String siteEname;

	/**
	 * 站点地址
	 */
	private String siteAddress;

	/**
	 * 创建该站点的用户id
	 */
	private long createrAdminId;

	
	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteEname() {
		return siteEname;
	}

	public void setSiteEname(String siteEname) {
		this.siteEname = siteEname;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public long getCreaterAdminId() {
		return createrAdminId;
	}

	public void setCreaterAdminId(long createrAdminId) {
		this.createrAdminId = createrAdminId;
	}
	
}
