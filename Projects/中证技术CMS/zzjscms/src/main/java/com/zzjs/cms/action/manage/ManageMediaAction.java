/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.constant.MediaEntityConstant.Entity;
import com.zzjs.cms.entity.Folder;
import com.zzjs.cms.entity.Media;
import com.zzjs.cms.entity.vo.MediaEntityRelaVo;
import com.zzjs.cms.entity.vo.MediaVo;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.exception.FolderNotFoundException;
import com.zzjs.cms.exception.UploadException;
import com.zzjs.cms.json.EntityJson;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/manage/attachment")
public class ManageMediaAction extends ManageBaseAction {

	/**
	 * 进入某种文件的列表分页的首页
	 * @throws FolderNotFoundException
	 */
	@RequestMapping(value = "/page.htm", method = RequestMethod.GET)
	public String filePage(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "folderId", defaultValue = "1") long folderId,
			HttpServletRequest request, ModelMap modelMap)
			throws FolderNotFoundException {
		Folder folder = folderService.getFolderById(folderId);
//		PageVo<Media> attachmentPage = attachmentService.getMediaPageByKindId(
//				folderId, MediaConstant.Kind.folder, 12, pageNum);
//		modelMap.put("folderAll", folderService.getAllFolderList(this.getAdmin(request).getSiteId(), 0));
		modelMap.put("JSESSIONID", request.getSession().getId());
		modelMap.put("folder", folder);
//		modelMap.put("attachmentPage", attachmentPage);
		return "manage/attachment/page";
	}
	
	/**
	 * 所有资源文件列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listAll.json", method = RequestMethod.GET)
	public String attachmentAll(@RequestParam("entityId") long entityId) {
		List<MediaVo> attachmentList = attachmentService.getMediaListAll(entityId, 500);
		JSONObject json = new JSONObject();
		json.put("attachmentList", attachmentList);
		return json.toString();
	}
	

	/**
	 * 该实体下的资源文件列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list.json", method = RequestMethod.GET)
	public String attachment(@RequestParam("entityId") long entityId, 
			@Param("entity") Entity entity) {
		List<MediaEntityRelaVo> attachmentList = mediaEntityRelaService.getMediaListByEntityId(
				entityId, entity, 500);
		JSONObject json = new JSONObject();
		json.put("attachmentList", attachmentList);
		return json.toString();
	}

	/**
	 * 附件上传
	 */
	@ResponseBody
	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "entityId") long entityId,
			@RequestParam(value = "entity") Entity entity,
			@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request) {
		try {
			attachmentService.addUploadFile(file, file.getOriginalFilename(),
					entityId, entity);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		return json.toString();
	}

	/**
	 * 彻底删除文件
	 * @throws FileInfoNotFoundException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> deleteFile(
			@RequestParam(value = "mediaId") long mediaId) {
		EntityJson<String> json = new EntityJson<String>();
		Media media = attachmentService.getMediaById(mediaId);
		attachmentService.deleteMedia(mediaId, media.getPath());
		json.setResult(true);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/update_link.json", method = RequestMethod.POST)
	public EntityJson<String> updateLink(
			@RequestParam(value = "attachmentId") long attachmentId,
			@RequestParam(value = "link") String link) {
		EntityJson<String> json = new EntityJson<String>();
		attachmentService.updateLinkByMediaId(attachmentId, link);
		json.setResult(true);
		return json;
	}

//	@ResponseBody
//	@RequestMapping(value = "/update_name.json", method = RequestMethod.POST)
//	public JsonVo<String> updateName(
//			@RequestParam(value = "attachmentId") long attachmentId,
//			@RequestParam(value = "name") String name) {
//		JsonVo<String> json = new JsonVo<String>();
//		attachmentService.updateNameByMediaId(attachmentId, name);
//		json.setResult(true);
//		return json;
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/ueditor/manager.htm", method = RequestMethod.POST)
//	public String photoManager(@RequestParam(value = "kindId") long kindId,
//			@RequestParam(value = "kind") MediaConstant.Kind kind,
//			HttpServletRequest request) {
//		List<Media> attachmentList = attachmentService.getMediaListByKindId(
//				kindId, kind, 100);
//		List<String> picturePathList = new ArrayList<String>();
//		for (Media attachment : attachmentList) {
//			if (attachment.getType().equals(MediaConstant.Type.photo)) {
//				picturePathList.add(attachment.getPath().replace(
//						java.io.File.separator, "/"));
//			}
//		}
//		return StringUtils.join(picturePathList.toArray(), "ue_separate_ue");
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/ueditor/upload.htm", method = RequestMethod.POST)
//	public String photoUpload(@RequestParam("kindId") long kindId,
//			@RequestParam(value = "kind") MediaConstant.Kind kind,
//			@RequestParam("Filename") String Filename,
//			@RequestParam("fileName") String fileName,
//			@RequestParam("fileNameFormat") String fileNameFormat,
//			@RequestParam("pictitle") String pictitle,
//			@RequestParam("Upload") String Upload,
//			@RequestParam("upfile") MultipartFile upfile,
//			HttpServletRequest request) {
//		JSONObject json = new JSONObject();
//		if (!MediaUtils.isFileType(fileName, MediaUtils.PHOTO_TYPE)) {
//			json.put("state", "不允许的文件格式");
//			return json.toString();
//		}
//		try {
//			Media attachment = attachmentService.addUploadFile(upfile,
//					fileName, kindId, kind);
//			json.put("original", fileName);
//			json.put("url", attachment.getPath());
//			json.put("title", pictitle);
//			json.put("state", "SUCCESS");
//			return json.toString();
//		} catch (IllegalStateException e) {
//			json.put("state", e.getMessage());
//		} catch (IOException e) {
//			json.put("state", e.getMessage());
//		} catch (UploadException e) {
//			json.put("state", e.getMessage());
//		}
//		return json.toString();
//	}
}
