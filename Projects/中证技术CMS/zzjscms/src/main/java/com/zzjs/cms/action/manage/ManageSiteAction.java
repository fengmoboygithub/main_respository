/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action.manage;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.entity.Admin;
import com.zzjs.cms.entity.Site;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.entity.vo.SiteVo;
import com.zzjs.cms.exception.FolderNotFoundException;
import com.zzjs.cms.exception.UploadException;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.util.SSUtils;

/**
 * 站点action
 * @author yangyanchao
 */
@Controller
@RequestMapping("/manage/site")
public class ManageSiteAction extends ManageBaseAction {
	
	/**
	 * 进入新建站点页面
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		Admin admin = this.getAdmin(request);
		modelMap.put("adminId", admin.getAdminId());
		return "manage/site/add";
	}

	/**
	 * 新建站点
	 * @param adminId
	 * @param siteName
	 * @param siteAddress
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws UploadException
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public EntityJson<Site> add(
			@RequestParam("adminId") long adminId,
			@RequestParam("siteName") String siteName,
			@RequestParam("siteEname") String siteEname,
			@RequestParam("siteAddress") String siteAddress,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<Site> json = new EntityJson<Site>();
		try {
			Site site = siteService.addSite(adminId, SSUtils.toText(siteName.trim()), SSUtils.toText(siteEname.trim().toLowerCase()), siteAddress);
			json.setT(site);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}

	/**
	 * 进入站点列表分页的页面
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			HttpServletRequest request, ModelMap modelMap) {
		Admin admin = this.getAdmin(request);
		long adminId = admin.getAdminId();
		PageVo<SiteVo> pageVo = siteService.getSiteListPageByAdminId(pageNum, adminId);
		modelMap.put("adminId", adminId);
		modelMap.put("pageVo", pageVo);
		modelMap.put("p", pageNum);
		return "manage/site/list";
	}

	/**
	 * 进入修改站点页面
	 * @throws Exception
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "siteId", defaultValue = "1") long siteId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SiteVo site = siteService.getSiteById(siteId);
		modelMap.put("site", site);
		modelMap.put("JSESSIONID", request.getSession().getId());
		return "manage/site/update";
	}

	/**
	 * 修改站点信息
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public EntityJson<Site> update(
			@RequestParam("siteId") long siteId,
			@RequestParam("siteName") String siteName,
			@RequestParam("siteEname") String siteEname,
			@RequestParam("siteAddress") String siteAddress,
			HttpServletRequest request, ModelMap modelMap)
			throws ParseException {
		EntityJson<Site> json = new EntityJson<Site>();
		try {
			
			Site site = siteService.updateSiteBySiteId(siteId, SSUtils.toText(siteName.trim()), SSUtils.toText(siteEname.trim().toLowerCase()), siteAddress);
			json.setT(site);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}

	/**
	 * 删除站点
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> deleteFile(
			@RequestParam(value = "siteId") long siteId){
		EntityJson<String> json = new EntityJson<String>();
		siteService.deleteSite(siteId);
		json.setResult(true);
		return json;
	}
	/**
	 * 站点导出
	 * @throws FolderNotFoundException 
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/export.json", method = RequestMethod.POST)
	public EntityJson<String> export(
			@RequestParam(value = "siteId") long siteId,
			HttpServletRequest request) throws FolderNotFoundException {
		EntityJson<String> json = new EntityJson<String>();
		boolean flag = false;
		try {
			flag = siteService.export(siteId);
		} catch (Exception e){
			logger.error(e.getMessage(), e.fillInStackTrace());
			flag = false;
		}
		if (flag) {
			json.setMsg("导出站点成功，请查看输出目录。");
			json.setResult(true);
		} else {
			json.setMsg("导出站点失败，请查看日志。");
			json.setResult(false);
		}
		return json;
	}
}
