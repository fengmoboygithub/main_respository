/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */
package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.entity.Site;
import com.zzjs.cms.entity.vo.SiteVo;

/**
 * 站点
 * 
 * @author yangyanchao
 */

@Repository
public interface SiteDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 添加站点
	 * 
	 * @param Site
	 * @return Integer
	 * 
	 */
	public int addSite(Site site);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除站点
	 * 
	 * @param siteId
	 * @return Integer
	 * 
	 */
	public int deleteSite(@Param("siteId") long siteId);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改站点信息
	 */
	public void updateSiteBySiteId(Site site);
	
	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 获取所有站点列表(分页)
	 * 
	 * @param offset
	 * @param rows
	 * @return List<SiteVo>
	 * 
	 */
	public List<SiteVo> getAllList(@Param("offset") long offset,
			@Param("rows") long rows);

	/**
	 * 获取所有站点的数量
	 * 
	 * @return Integer
	 * 
	 */
	public int getAllListCount();

	/**
	 * 通过Id获得指定站点信息
	 * 
	 * @param siteId
	 * @return Site
	 */
	public SiteVo getSiteById(@Param("siteId") long siteId);

	/**
	 * 获取所有站点列表
	 * @return
	 */
	public List<SiteVo> getAllSiteList();
	
	
	/**
	 * 通过adminId 获取该adminId下所有站点列表(分页)
	 * 
	 * @param offset
	 * @param rows
	 * @param adminId
	 * @return List<SiteVo>
	 * 
	 */
	public List<SiteVo> getSiteListByAdminId(@Param("offset") long offset,
			@Param("rows") long rows,@Param("adminId") long adminId);

	/**
	 * 通过adminId 获取该adminId下所有站点的数量
	 * 
	 * @return Integer
	 * 
	 */
	public int getSiteListCountByAdminId(@Param("adminId") long adminId);

}
