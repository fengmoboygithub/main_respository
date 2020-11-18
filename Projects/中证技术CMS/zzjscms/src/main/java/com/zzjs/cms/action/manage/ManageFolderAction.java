/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */
package com.zzjs.cms.action.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.constant.FolderConstant;
import com.zzjs.cms.entity.Folder;
import com.zzjs.cms.entity.vo.FolderVo;
import com.zzjs.cms.entity.vo.SiteVo;
import com.zzjs.cms.exception.FolderNotFoundException;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.util.RegexUtils;
import com.zzjs.cms.util.SSUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 目录action
 * @author yangyanchao
 */
@RequestMapping("/manage/folder")
@Controller
public class ManageFolderAction extends ManageBaseAction {

	/**
	 * 添加新的目录
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public EntityJson<String> add(
			@RequestParam(value = "siteId") long siteId,
			@RequestParam(value = "fatherId", defaultValue = "0") long fatherId,
			@RequestParam(value = "folderName") String folderName,
			@RequestParam(value = "folderEname") String folderEname,
			@RequestParam(value = "status") FolderConstant.status status,
			HttpServletRequest request, 
			ModelMap modelMap) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			if (StringUtils.isBlank(folderName)) {
				json.getErrors().put("folderName", "目录名称不能为空");
			}
			if (StringUtils.isBlank(folderEname)) {
				json.getErrors().put("folderEname", "英文名称不能为空");
			} else if (!RegexUtils.isAlphaUnderline(folderEname)) {
				json.getErrors().put("folderEname", "只能是英文字母，数字和下划线");
			} else if (folderService.isFolderByEname(folderEname,fatherId)) {
				json.getErrors().put("folderEname", "英文名称不能重复");
			}
			// 检测校验结果
			validate(json);
			folderService.addFolder(siteId,fatherId,
					SSUtils.toText(folderName.trim()),
					SSUtils.toText(folderEname.toLowerCase().trim()), status);
			json.setResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * 进入目录列表
	 * @throws FolderNotFoundException
	 * 
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam("siteId") long siteId,
			@RequestParam(value = "folderId", defaultValue = "0") long folderId,
			ModelMap modelMap, HttpServletRequest request)
			throws FolderNotFoundException {
		List<FolderVo> pathList = folderService
				.getFolderPathListByFolderId(folderId);
		SiteVo site = siteService.getSiteById(siteId);
		Folder folder = new Folder();
		if (folderId == 0) {
			folder.setFolderId(0);
			folder.setSiteId(siteId);
			folder.setName(site.getSiteName());
		} else {
			folder = folderService.getFolderById(folderId);
		}
		List<FolderVo> folderList = folderService.getFolderListByFatherId(siteId,
				folderId, null);
		modelMap.put("folder", folder);
		modelMap.put("site", site);
		modelMap.put("folderList", folderList);
		modelMap.put("pathList", pathList);
		modelMap.put("folderAll", folderService.getAllFolderList(siteId));
		modelMap.put("folderTypeAll", dictionaryService.getDictionariesByKey("folderType"));//目录类型
		return "manage/folder/list";
	}

	/**
	 * 进入修改目录资料页面
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(@RequestParam("folderId") long folderId,
			@RequestParam(value = "p", defaultValue = "1") int p,
			ModelMap modelMap, HttpServletRequest request) throws Exception {
		Folder folder = folderService.getFolderById(folderId);
		modelMap.put("folder", folder);
		modelMap.put("JSESSIONID", request.getSession().getId());
		return "manage/folder/update";
	}

	/**
	 * 修改目录资料
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public EntityJson<String> update(
			@RequestParam(value = "siteId") long siteId,
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "ename") String ename,
			@RequestParam(value = "status") FolderConstant.status status,
			HttpServletRequest request) {
		EntityJson<String> json = new EntityJson<String>();
		// FIXME 检查目录的ename不能用循环遍历检查
		List<FolderVo> list = folderService.getAllFolderList(siteId);
		try {
			if (name.equals("")) {
				json.getErrors().put("name", "目录名称不能为空");
			}
			if (ename.equals("")) {
				json.getErrors().put("ename", "英文名称不能为空");
			} else {
				for (Folder folder : list) {
					if (folderId != folder.getFolderId()) {
						if (ename.equals(folder.getEname())) {
							json.getErrors().put("folderEname", "英文名称不能重复");
						}
					}
				}
			}
			// 检测校验结果
			validate(json);
			folderService.updateFolderById(folderId,
					SSUtils.toText(name.trim()),
					SSUtils.toText(ename.trim().toLowerCase()), status);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * 目录排序
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/sort.json", method = RequestMethod.POST)
	public EntityJson<String> sort(
			@RequestParam(value = "sortJson") String sortJson) {
		EntityJson<String> json = new EntityJson<String>();
		JSONArray array = JSONArray.fromObject(sortJson);
		for (int i = 0; i < array.size(); i++) {
			JSONObject folder = array.getJSONObject(i);
			String folderId = folder.get("folderId").toString();
			String sort = folder.get("sort").toString();
			folderService.updateSort(Long.parseLong(folderId),
					Integer.parseInt(sort));
		}
		json.setResult(true);
		return json;
	}

	/**
	 * 删除目录
	 * @throws FolderNotFoundException
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> delete(
			@RequestParam(value = "folderId") long folderId,
			@RequestParam(value = "siteId") long siteId)
			throws FolderNotFoundException {
		EntityJson<String> json = new EntityJson<String>();
		List<FolderVo> folderList = folderService.getFolderListByFatherId(siteId, 
				folderId, null);
		if (folderList.size() == 0) {
			int count = fileInfoService.getFileInfoCountByFolderId(folderId);
			if (count != 0) {
				json.setResult(false);
				json.setMsg("此目录下还有文件,不能被删除。");
			} else {
				json.setResult(true);
				folderService.deleteFolderById(folderId);
			}
		} else {
			json.setResult(false);
			json.setMsg("此目录下有子目录，不能删除。");
		}
		return json;
	}
}
