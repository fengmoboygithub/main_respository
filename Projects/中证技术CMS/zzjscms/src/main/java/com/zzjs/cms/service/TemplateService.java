/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zzjs.cms.constant.ConfigConstant;
import com.zzjs.cms.constant.SystemConstant;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.exception.TemplateNotFoundException;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 模板工具类
 * 
 * @author yangyanchao
 * 
 */
@Service
public class TemplateService {

	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ConfigService configService;

	/**
	 * @return
	 */
	public String get404() {
		return this.getTemplatePath("404");
	}

	/**
	 * @return
	 */
	public String get500() {
		return this.getTemplatePath("500");
	}

	/**
	 * 得到首页（默认页）模板
	 * 
	 * @return
	 * @throws TemplateNotFoundException
	 */
	public String getDefaultTemplate() throws TemplateNotFoundException {
		List<String> themeOrderList = new ArrayList<String>();
		themeOrderList.add("output");
		for (String theme : themeOrderList) {
			if (this.isExist(theme)) {
				return this.getTemplatePath(theme);
			}
		}
		throw new TemplateNotFoundException("模板文件：output 不存在！！");
	}

	/**
	 * 得到当前请求需要渲染的模板相对路径
	 * 
	 * @param theme
	 * @return
	 */
	private String getTemplatePath(String template) {
		return "/template/"
				+ configService.getStringByKey(ConfigConstant.ZZJS_TEMPLATE)
				+ "/" + template;
	}

	/**
	 * 模板物理地址是否存在
	 * 
	 * @param theme
	 * @return
	 */
	@Cacheable("default")
	public Boolean isExist(String theme) {
		String themePath = "/WEB-INF/static/template/"
				+ configService.getStringByKey(ConfigConstant.ZZJS_TEMPLATE)
				+ "/" + theme + ".ftl";
		File file = new File(SystemConstant.ZZJS_CMS_ROOT + themePath);
		if (file.exists()) {
			logger.info("尝试使用模板：" + themePath+"【存在】");
			return true;
		} else {
			logger.info("尝试使用模板：" + themePath+"【不存在】");
			return false;
		}
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////
	
	public void staticTemplate(File resultFile, Map<String,Object> data) throws BaseException{
		String themePath = "/WEB-INF/static/template/" 
					+ configService.getStringByKey(ConfigConstant.ZZJS_TEMPLATE) + "/";
		File templateFolder = new File(SystemConstant.ZZJS_CMS_ROOT + "/" + themePath);
		Configuration freemarkerCfg = new Configuration();
		try {
			// 加载模版文件的路径
			freemarkerCfg.setDirectoryForTemplateLoading(templateFolder);
			freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
			// 指定模版路径
			Template template = freemarkerCfg.getTemplate(configService.getStringByKey(ConfigConstant.ZZJS_TEMPLATE_FILE), "UTF-8");
			template.setEncoding("UTF-8");
			// 静态页面路径
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile), "UTF-8"));
			// 处理模版并开始输出静态页面
			template.process(data, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error("生成静态网页出错",e.fillInStackTrace());
			e.printStackTrace();
			throw new BaseException("生成静态网页出错");
		}
	}
}
