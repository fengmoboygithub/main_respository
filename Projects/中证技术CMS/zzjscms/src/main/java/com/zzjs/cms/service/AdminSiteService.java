package com.zzjs.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.zzjs.cms.dao.AdminSiteDao;
import com.zzjs.cms.entity.AdminSiteRela;
import com.zzjs.cms.entity.vo.AdminSiteRelaVo;

@Service
public class AdminSiteService {

	@Autowired
	private AdminSiteDao adminSiteDao;

	@CacheEvict(value = "site", allEntries = true)
	public AdminSiteRela addAdminSite(long adminId, long siteId) {
		AdminSiteRela adminSiteRela = new AdminSiteRela();
		adminSiteRela.setAdminId(adminId);
		adminSiteRela.setSiteId(siteId);
		adminSiteRela.setCreateTime(new Date());
		adminSiteDao.addAdminSite(adminSiteRela);
		return adminSiteRela;
	}

	@CacheEvict(value = "site", allEntries = true)
	public int deleteAdminSite(long adminId, long siteId) {
		return adminSiteDao.deleteAdminSite(adminId, siteId);
	}
	
	public int deleteAdminSiteByAdminId(long adminId) {
		return adminSiteDao.deleteAdminSiteByAdminId(adminId);
	}
	
	public int deleteAdminSiteBySiteId(long siteId) {
		return adminSiteDao.deleteAdminSiteBySiteId(siteId);
	}

	public List<AdminSiteRelaVo> getAdminSiteListById(long adminId) {
		List<AdminSiteRelaVo> list = adminSiteDao
				.getAdminSiteListById(adminId);
		return list;
	}
	
	public List<AdminSiteRelaVo> getAdminSiteListBySiteId(long siteId) {
		List<AdminSiteRelaVo> list = adminSiteDao
				.getAdminSiteListBySiteId(siteId);
		return list;
	}

	public AdminSiteRelaVo getAdminSiteById(long adminId, long siteId) {
		return adminSiteDao.getAdminSiteById(adminId, siteId);
	}
}
