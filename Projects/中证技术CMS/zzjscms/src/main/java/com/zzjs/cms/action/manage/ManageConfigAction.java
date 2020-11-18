/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action.manage;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.constant.SystemConstant;
import com.zzjs.cms.entity.Admin;
import com.zzjs.cms.entity.Config;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.util.SSUtils;

/**
 * 网站配置action
 * 
 * @author yangyanchao
 * 
 */
@Controller
@RequestMapping("/manage/config")
public class ManageConfigAction extends ManageBaseAction {

	/**
	 *	配置列表界面
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			HttpServletRequest request, ModelMap modelMap) {
		PageVo<Config> pageVo = configService.getConfigListPage(pageNum);
		modelMap.put("pageVo", pageVo);
		modelMap.put("p", pageNum);
		return "manage/config/list";
	}
	
	/**
	 * 删除组件
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public EntityJson<String> deleteKey(
			@RequestParam(value = "key") String key){
		EntityJson<String> json = new EntityJson<String>();
		configService.deleteConfig(key);
		json.setResult(true);
		return json;
	}
	
	
	/**
	 * 网站配置
	 */
	@RequestMapping(value = "/baisc.htm", method = RequestMethod.GET)
	public String basic(ModelMap modelMap) {
		List<String> templateList = this.getTemplate();
		modelMap.addAttribute("templateList", templateList);
		return "manage/config/basic";
	}
	
	/**
	 * 修改网站配置
	 */
	@ResponseBody
	@RequestMapping(value = "/basic.json", method = RequestMethod.POST)
	public EntityJson<String> basicSubmit(
			@RequestParam(value = "sitename") String sitename,
			@RequestParam(value = "sitedesc") String sitedesc, ModelMap modelMap) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			if (StringUtils.isBlank(sitename)) {
				json.getErrors().put("sitename", "网站名称不能为空");
			}
			if (StringUtils.isBlank(sitedesc)) {
				json.getErrors().put("sitedesc", "网站描述不能为空");
			}

			// 检测校验结果
			validate(json);
			configService.updagteConfigByKey("sys_sitename",
					SSUtils.toText(sitename));
			configService.updagteConfigByKey("sys_sitedesc",
					SSUtils.toText(sitedesc));
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;

	}

	@RequestMapping(value = "/picture.htm", method = RequestMethod.GET)
	public String picture() {
		return "system/config/picture";
	}

	@ResponseBody
	@RequestMapping(value = "/update/picture.json", method = RequestMethod.GET)
	public EntityJson<String> updatePicture(
			@RequestParam(value = "bigWidth") String bigWidth,
			@RequestParam(value = "bigheight") String bigheight,
			@RequestParam(value = "smallWidth") String smallWidth,
			@RequestParam(value = "smallHeight") String smallHeight) {
		EntityJson<String> json = new EntityJson<String>();
		try {
			if (StringUtils.isBlank(bigWidth)) {
				json.getErrors().put("bigWidth", "大图的宽度不能为空");
			}
			if (StringUtils.isBlank(bigheight)) {
				json.getErrors().put("bigheight", "大图的高度不能为空");
			}
			if (StringUtils.isBlank(smallWidth)) {
				json.getErrors().put("smallWidth", "小图的宽度不能为空");
			}
			if (StringUtils.isBlank(smallHeight)) {
				json.getErrors().put("smallHeight", "小图的高度不能为空");
			}

			// 检测校验结果
			validate(json);
			String strb = bigWidth + "x" + bigheight + ";" + smallWidth + "x"
					+ smallHeight + ";";
			configService.updagteConfigByKey("article_picture_size", strb);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	private List<String> getTemplate() {
		List<String> templateList = new ArrayList<String>();
		String templatePath = SystemConstant.ZZJS_CMS_ROOT + "/WEB-INF/";
		File dir = new File(templatePath);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory() && !file.getName().equals("admin")) {
				templateList.add(file.getName());
			}
			logger.debug(file.getName());
		}
		return templateList;
	}

	
	/**
	 * 进入新建配置页面
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
		return "manage/config/add";
	}
	
	
	/**
	 * 新建配置
	 * @param key
	 * @param value
	 * @param description
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public EntityJson<Config> add(
			@RequestParam("key") String key,
			@RequestParam("value") String value,
			@RequestParam("description") String description,
			HttpServletRequest request, ModelMap modelMap){
		EntityJson<Config> json = new EntityJson<Config>();
		try {
			Config config = configService.addConfig(key, value, description);
			json.setT(config);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		}
	}
	
	/**
	 * 进入修改配置页面
	 * @throws Exception
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "key") String key,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Config config = configService.getConfigByKey(key);
		modelMap.put("config", config);
		modelMap.put("JSESSIONID", request.getSession().getId());
		return "manage/config/update";
	}
	
	/**
	 * 修改配置信息
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public EntityJson<Config> update(
			@RequestParam("key") String key,
			@RequestParam("value") String value,
			@RequestParam("description") String description,
			HttpServletRequest request, ModelMap modelMap)
			throws ParseException {
		EntityJson<Config> json = new EntityJson<Config>();
		try {
			Config config = configService.updateConfig(SSUtils.toText(key.trim()), SSUtils.toText(value.trim()), SSUtils.toText(description.trim()));
			json.setT(config);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			json.setResult(false);
			return json;
		} 
	}
	
}
