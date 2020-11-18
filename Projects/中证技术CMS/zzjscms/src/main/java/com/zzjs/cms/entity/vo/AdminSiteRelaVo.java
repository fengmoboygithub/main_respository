package com.zzjs.cms.entity.vo;

import com.zzjs.cms.entity.AdminSiteRela;
/**
 * 用户站点关系表VO
 * @author yangyanchao
 *
 */
public class AdminSiteRelaVo extends AdminSiteRela {

	private SiteVo site;
	
	private AdminVo admin;

	public SiteVo getSite() {
		return site;
	}

	public void setSite(SiteVo site) {
		this.site = site;
	}

	public AdminVo getAdmin() {
		return admin;
	}

	public void setAdmin(AdminVo admin) {
		this.admin = admin;
	}
}
