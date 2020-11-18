/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */
package com.zzjs.cms.base.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.zzjs.cms.service.FileInfoService;
import com.zzjs.cms.service.FolderService;
import com.zzjs.cms.service.TemplateService;

/**
 * 
 * @author yangyanchao
 * 
 */
public class BaseAction {

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected FileInfoService fileService;

	@Autowired
	protected TemplateService themeService;

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	protected static String AJAX = "common/ajax";
	protected static String AJAX_MSG = "msg";
}
