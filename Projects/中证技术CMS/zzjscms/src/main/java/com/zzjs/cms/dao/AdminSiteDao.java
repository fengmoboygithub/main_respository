package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.entity.AdminSiteRela;
import com.zzjs.cms.entity.vo.AdminSiteRelaVo;

@Repository
public interface AdminSiteDao {

	public int addAdminSite(AdminSiteRela adminSiteRela);

	public int deleteAdminSite(@Param("adminId") long adminId,
			@Param("siteId") long siteId);
	
	public int deleteAdminSiteByAdminId(@Param("adminId") long adminId);
	
	public int deleteAdminSiteBySiteId(@Param("siteId") long siteId);

	public List<AdminSiteRelaVo> getAdminSiteListById(
			@Param("adminId") long adminId);
	
	public List<AdminSiteRelaVo> getAdminSiteListBySiteId(
			@Param("siteId") long siteId);

	public AdminSiteRelaVo getAdminSiteById(@Param("adminId") long adminId,
			@Param("siteId") long siteId);
}
