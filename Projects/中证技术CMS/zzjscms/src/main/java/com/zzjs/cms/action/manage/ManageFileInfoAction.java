/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action.manage;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.constant.FileInfoConstant;
import com.zzjs.cms.entity.FileInfo;
import com.zzjs.cms.entity.vo.FileInfoVo;
import com.zzjs.cms.entity.vo.FileinfoMediaRelaVo;
import com.zzjs.cms.entity.vo.FolderVo;
import com.zzjs.cms.entity.vo.MediaVo;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.entity.vo.SiteVo;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.exception.FolderNotFoundException;
import com.zzjs.cms.exception.UploadException;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.util.SSUtils;

/**
 * 文件action
 * @author yangyanchao
 */
@Controller
@RequestMapping("/manage/fileInfo")
public class ManageFileInfoAction extends ManageBaseAction {

//	@Autowired
//	private FileInfoAction fileInfoAction;

	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap,
			@RequestParam(value = "siteId") long siteId,
			@RequestParam(value = "folderId", defaultValue = "0") long folderId)
			throws FolderNotFoundException {
		modelMap.put("folderAll",
				folderService.getAllFolderList(siteId));
		modelMap.put("folderId", folderId);
		modelMap.put("siteId", siteId);
		return "manage/fileInfo/add";
	}

	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public EntityJson<FileInfo> add(
			@RequestParam("siteId") long siteId,
			@RequestParam("folderId") long folderId,
			@RequestParam("ename") String ename,
			@RequestParam("name") String name,
			@RequestParam(value = "createTime", required = false) String createTime,
			@RequestParam("status") FileInfoConstant.Status status,
			HttpServletRequest request, ModelMap modelMap)
			throws UploadException, ParseException {
		EntityJson<FileInfo> json = new EntityJson<FileInfo>();
		try {
			FileInfo fileInfo = fileInfoService.addFileInfo(siteId, folderId, 
					ename, name, status, createTime);
			json.setT(fileInfo);
			json.setResult(true);
			return json;
		} catch (FolderNotFoundException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} catch (IOException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}

	/**
	 * 进入某种文件的列表分页的首页
	 * @throws FolderNotFoundException
	 * 
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "siteId", defaultValue = "0") long siteId,
			@RequestParam(value = "folderId", defaultValue = "0") long folderId,
			HttpServletRequest request, ModelMap modelMap)
			throws FolderNotFoundException {
		SiteVo site = siteService.getSiteById(siteId);
		List<FolderVo> pathList = folderService
				.getFolderPathListByFolderId(folderId);
		PageVo<FileInfoVo> pageVo = fileInfoService.getFileInfoPageByFolderId(siteId,
				folderId, pageNum);
		modelMap.put("pathList", pathList);
		modelMap.put("folderId", folderId);
		modelMap.put("site", site);
		modelMap.put("pageVo", pageVo);
		modelMap.put("p", pageNum);
		return "manage/fileInfo/list";
	}

	/**
	 * 进入修改文件页面
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "fileId", defaultValue = "1") long fileId,
			@RequestParam(value = "siteId", defaultValue = "1") long siteId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		FileInfoVo fileInfo = fileInfoService.getFileInfoById(fileId);
		//通过站点Id得到所有资源列表 打上是否属于该文件的标识
		List<MediaVo> mediaAll = attachmentService.getMediaListAllBySiteId(siteId, fileId);
		//通过文件ID得到资源列表
		List<FileinfoMediaRelaVo> mediaFileList = fileinfoMediaService.getFileinfoMediaListByFileId(fileId, mediaAll);
		modelMap.put("fileInfo", fileInfo);
		modelMap.put("folderAll",
				folderService.getAllFolderList(siteId));
		modelMap.put("mediaAll", mediaAll);
		modelMap.put("mediaFileList", mediaFileList);
		modelMap.put("JSESSIONID", request.getSession().getId());
		return "manage/fileInfo/update";
	}

	/**
	 * 修改文件资料
	 * @param fileId
	 * @param folderId
	 * @param name
	 * @param titile
	 * @param content
	 * @param description
	 * @param status
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public EntityJson<FileInfo> update(
			@RequestParam("fileId") long fileId,
			@RequestParam("folderId") long folderId,
			@RequestParam("ename") String ename,
			@RequestParam("name") String name,
			@RequestParam("sourceCode") String sourceCode,
			@RequestParam(value = "htmlCodeByEdit") String htmlCodeByEdit,
			@RequestParam(value = "createTime", required = false) String createTime,
			@RequestParam("status") FileInfoConstant.Status status,
			HttpServletRequest request, ModelMap modelMap)
			throws ParseException {
		EntityJson<FileInfo> json = new EntityJson<FileInfo>();
		try {
			FileInfo fileInfo = fileInfoService.updateFileInfo(fileId,
					folderId, ename, name, 
					sourceCode, htmlCodeByEdit, 
				    status, createTime);
			json.setT(fileInfo);
			json.setResult(true);
			return json;
		} catch (UploadException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} catch (IOException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} catch (FolderNotFoundException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}

	/**
	 * 彻底删除文件
	 * @throws FileInfoNotFoundException
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> deleteFile(
			@RequestParam(value = "fileId") long fileId)
			throws FileInfoNotFoundException {
		EntityJson<String> json = new EntityJson<String>();
		try {
			// 删除站点文件及其关系数据
			fileInfoService.deleteFileInfoById(fileId);
			json.setResult(true);
		} catch (BaseException e) {
			json.setResult(false);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/preview.htm", method = RequestMethod.GET)
	public String preview(@RequestParam(value = "fileId", defaultValue = "-1") long fileId,
			ModelMap modelMap, HttpServletRequest request) throws FileInfoNotFoundException {
		if(fileId != -1){
			FileInfo fileInfo = fileInfoService.getFileInfoById(fileId);
			String sourceCode = SSUtils.delPToHTML(fileInfo.getSourceCode());
			modelMap.put("sourceCode", sourceCode);
		}
		return "template/preview/preview";
	}
	
	@RequestMapping(value = "/sourceCode.htm", method = RequestMethod.GET)
	public String sC(@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "siteId", defaultValue = "0") long siteId,
			@RequestParam(value = "folderId", defaultValue = "0") long folderId,
			ModelMap modelMap, HttpServletRequest request) throws FileInfoNotFoundException, FolderNotFoundException {
		PageVo<FileInfoVo> pageVo = fileInfoService.getFileInfoPageByFolderId(siteId,
				folderId, pageNum);
		modelMap.put("pageVo", pageVo);
		return "manage/fileInfo/sourceCode";
	}
}
