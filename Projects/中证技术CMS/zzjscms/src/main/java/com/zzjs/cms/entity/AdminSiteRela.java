package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 用户站点关系表实体
 * @author yangyanchao
 *
 */
public class AdminSiteRela extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long relaId;
	private long siteId;
	private long adminId;
	public long getRelaId() {
		return relaId;
	}
	public void setRelaId(long relaId) {
		this.relaId = relaId;
	}
	public long getSiteId() {
		return siteId;
	}
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
}
