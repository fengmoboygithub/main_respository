package com.zzjs.cms.action.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.entity.vo.AdminSiteRelaVo;
import com.zzjs.cms.entity.vo.AdminVo;
import com.zzjs.cms.entity.vo.SiteVo;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.json.EntityJson;

@Controller
@RequestMapping("/manage/adminSite")
public class ManageAdminSiteAction extends ManageBaseAction {

	/**
	 * 进入管理员管理站点页面
	 */
	@RequestMapping(value = "/manage.htm", method = RequestMethod.GET)
	public String manage(
			@RequestParam(value = "adminId", defaultValue = "1") long adminId,
			HttpServletRequest request, ModelMap modelMap) {
		//查询所有站点 根据用户ID和站点ID查询关系表 在与所有站点对比得到属于自己的站点列表和不属于自己的站点列表
		List<SiteVo> siteAll = siteService.getAllSiteList(adminId);
		modelMap.put("admin", adminService.getAdminById(adminId));
		modelMap.put("siteAll", siteAll);
		return "manage/adminSite/manage";
	}
	
	/**
	 * 进入分享站点页面
	 */
	@RequestMapping(value = "/share.htm", method = RequestMethod.GET)
	public String share(
			@RequestParam(value = "siteId", defaultValue = "1") long siteId,
			HttpServletRequest request, ModelMap modelMap) {
		//查询所有用户 根据用户ID和站点ID查询关系表 在与所有用户对比得到属于自己的用户列表和不属于自己的用户列表
		List<AdminVo> adminAll = adminService.getAllAdminList(siteId);
		modelMap.put("site", siteService.getSiteById(siteId));
		modelMap.put("adminAll", adminAll);
		return "manage/adminSite/shareAdmin";
	}

	@ResponseBody
	@RequestMapping(value = "/addSite.json", method = RequestMethod.POST)
	public EntityJson<String> addSite(
			@RequestParam(value = "adminId") long adminId,
			@RequestParam(value = "siteId") long siteId)
			throws FileInfoNotFoundException {
		EntityJson<String> json = new EntityJson<String>();
		AdminSiteRelaVo adminSite = adminSiteService.getAdminSiteById(
				adminId, siteId);
		if (adminSite == null) {
			adminSiteService.addAdminSite(adminId, siteId);
			json.setResult(true);
		} else {
			json.setMsg("管理员已拥有该站点，请重新添加！");
			json.setResult(false);
		}
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> delete(@RequestParam(value = "adminId") long adminId,
			@RequestParam(value = "siteId") long siteId)
			throws FileInfoNotFoundException {
		EntityJson<String> json = new EntityJson<String>();
		adminSiteService.deleteAdminSite(adminId, siteId);
		json.setResult(true);
		return json;
	}
}
