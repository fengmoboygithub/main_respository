/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action.manage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.entity.FileInfo;
import com.zzjs.cms.entity.vo.ComponentTypeVo;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.exception.FolderNotFoundException;
import com.zzjs.cms.exception.UploadException;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.util.SSUtils;

/**
 * 布局编辑器action
 * @author yangyanchao
 */
@Controller
@RequestMapping("/manage/pageditor")
public class ManagePageEditorAction extends ManageBaseAction {
	
	@RequestMapping(value = "/test.htm", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		return "manage/pageditor/test";
	}
	
	@RequestMapping(value = "/productList.htm", method = RequestMethod.GET)
	public String productList(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		return "manage/pageditor/product_list";
	}
	
	@RequestMapping(value = "/productList1.htm", method = RequestMethod.GET)
	public String productList1(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) {
		return "manage/pageditor/product_list1";
	}

	/**
	 * 进入布局编辑器工作台页面
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param fileId
	 * @param optType
	 * @return
	 * @throws FileInfoNotFoundException
	 * @throws BaseException
	 */
	@RequestMapping(value = "/editer.htm", method = RequestMethod.GET)
	public String editer(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap,
			@RequestParam(value = "fileId", required=true) long fileId,
			@RequestParam(value = "type", required=true) String optType
			)
			throws Exception, BaseException {
			FileInfo fileInfo = fileInfoService.getFileInfoById(fileId);
			Map<String,Map<String,String>> map = componentInstanceTabService.selectAllCodeToMapByPageId(fileId);
			ObjectMapper mapper = new ObjectMapper();
	        String mapCodeJson = mapper.writeValueAsString(map);
			List<ComponentTypeVo> allTypeList = componentService.getAllDelPToHTMLComponentTypeVos();
			//页面编辑区html代码
			modelMap.put("htmlCodeByEdit", SSUtils.toHTML(fileInfo.getHtmlCodeByEdit()));
			//页面ID
			modelMap.put("fileId", fileId);
			//打开类型 page页面打开  model模态窗口打开
			modelMap.put("optType", optType);
			//封装各个组件实例代码以及html代码和媒体资源文件
			modelMap.put("mapCodeJson", mapCodeJson);
			//查询所有组件类型及其该类型下已审核的组件信息
			modelMap.put("allTypeList", allTypeList);
		return "manage/pageditor/editer";
	}
	
	/**
	 * 查询该页面所包含的组件实例及其下面的组件所有React代码
	 */
	@ResponseBody
	@RequestMapping(value = "/allCode.json", method = RequestMethod.POST)
	public EntityJson<Map<String,String>> allCode(
			@RequestParam(value = "id") long id) {
		EntityJson<Map<String,String>> json = new EntityJson<Map<String,String>>();
		try {
			//查询该页面所包含的组件实例及其下面的组件所有React代码
			Map<String,String> map = componentInstanceTabService.selectAllCodeByPageId(id);
			json.setT(map);
			json.setResult(true);
			return json;
		} catch (BaseException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} catch (FileInfoNotFoundException e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveHtmlCodeByEdit.json", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public  EntityJson<FileInfo> saveHtmlCodeByEdit (HttpServletRequest request, HttpServletResponse response) {
		EntityJson<FileInfo> jsonVo = new EntityJson<FileInfo>();
		try {
			long fileId = Long.valueOf(request.getParameter("fileId") != null ? request.getParameter("fileId") : "0");
			FileInfo fileInfo = fileInfoService.getFileInfoById(fileId);
			String sourceCode = request.getParameter("sourceCode");
			String htmlCodeByEdit = request.getParameter("htmlCodeByEdit");
			fileInfoService.updateFileInfo(fileId, fileInfo.getFolderId(), fileInfo.getEname(), fileInfo.getName(), 
					sourceCode, htmlCodeByEdit, fileInfo.getStatus(), "");
			jsonVo.setT(fileInfo);
			jsonVo.setResult(true);
			jsonVo.setMsg("保存成功");
		} catch (FileInfoNotFoundException e) {
			e.printStackTrace();
			jsonVo.setMsg(e.getMessage());
			jsonVo.setResult(false);
		} catch (UploadException e) {
			e.printStackTrace();
			jsonVo.setMsg(e.getMessage());
			jsonVo.setResult(false);
		} catch (IOException e) {
			e.printStackTrace();
			jsonVo.setMsg(e.getMessage());
			jsonVo.setResult(false);
		} catch (FolderNotFoundException e) {
			e.printStackTrace();
			jsonVo.setMsg(e.getMessage());
			jsonVo.setResult(false);
		}
		return jsonVo;
	}
	
}
