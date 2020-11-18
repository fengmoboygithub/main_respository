/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.base.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzjs.cms.base.json.BaseJson;
import com.zzjs.cms.constant.SystemConstant;
import com.zzjs.cms.entity.vo.AdminVo;
import com.zzjs.cms.exception.ValidateException;
import com.zzjs.cms.json.EntityJson;
import com.zzjs.cms.service.AdminService;
import com.zzjs.cms.service.AdminSiteService;
import com.zzjs.cms.service.ComponentImportRelaService;
import com.zzjs.cms.service.ComponentInstanceTabService;
import com.zzjs.cms.service.ComponentService;
import com.zzjs.cms.service.ComponentTemplateService;
import com.zzjs.cms.service.ConfigService;
import com.zzjs.cms.service.DataJsonInstanceService;
import com.zzjs.cms.service.DataJsonTemplateService;
import com.zzjs.cms.service.DictionaryService;
import com.zzjs.cms.service.FileInfoService;
import com.zzjs.cms.service.FileinfoMediaService;
import com.zzjs.cms.service.FolderService;
import com.zzjs.cms.service.MediaEntityRelaService;
import com.zzjs.cms.service.MediaService;
import com.zzjs.cms.service.SiteService;
import com.zzjs.cms.util.SSUtils;

/**
 * 所有action的父类
 * 
 */
@Controller
public class ManageBaseAction {

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	protected static String AJAX = "common/ajax";
	protected static String AJAX_MSG = "msg";

	@Autowired
	protected ConfigService configService;

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected FileInfoService fileInfoService;

	@Autowired
	protected MediaService attachmentService;

	@Autowired
	protected AdminService adminService;

	@Autowired
	protected AdminSiteService adminSiteService;
	
	@Autowired
	protected SiteService siteService;
	
	@Autowired
	protected MediaEntityRelaService mediaEntityRelaService;
	
	@Autowired
	protected FileinfoMediaService fileinfoMediaService;
	
	@Autowired
	protected ComponentService componentService;
	
	@Autowired
	protected ComponentImportRelaService componentImportRelaService;
	
	@Autowired
	protected ComponentInstanceTabService componentInstanceTabService;
	
	@Autowired
	protected ComponentTemplateService componentTemplateService;
	
	@Autowired
	protected DataJsonTemplateService dataJsonTemplateService;
	
	@Autowired
	protected DataJsonInstanceService dataJsonInstanceService;
	
	@Autowired
	protected DictionaryService dictionaryService;
	
	/**
	 * 参数校验
	 * 
	 * @param json
	 *            json数据Bean
	 * @throws ValidateException
	 */
	protected <T> void validate(EntityJson<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			json.setResult(false);
			throw new ValidateException("有错误发生");
		} else {
			json.setResult(true);
		}
	}

	/**
	 * 从session中获得管理员的信息
	 * 
	 * @param request
	 * @return
	 */
	protected AdminVo getAdmin(HttpServletRequest request) {
		AdminVo admin = (AdminVo) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		return admin;
	}
	
	/**
	 * 将对象转为json
	 * 并打印日志
	 * 以后可以压缩json字符串 
	 * @param resultJson
	 */
	protected String objToJson(BaseJson resultJson){
		ObjectMapper mapper = new ObjectMapper();
		//设置日期格式
		mapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); 
        String json = "";
        String formatJson = "";
		try {
			//对象转化为json
			json = mapper.writeValueAsString(resultJson);
			//json格式化
			formatJson = SSUtils.format(json);
		} catch (Exception e) {
			logger.error("json--格式化失败");
		}
//        logger.info("响应json内容："+formatJson);
        return json;
	}
	
}
