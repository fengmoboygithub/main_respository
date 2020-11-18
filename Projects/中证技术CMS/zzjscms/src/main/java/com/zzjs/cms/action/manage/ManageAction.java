/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzjs.cms.base.action.ManageBaseAction;
import com.zzjs.cms.exception.FolderNotFoundException;

/**
 * 进入网站后台首页
 * @author yangyanchao
 * 
 */

@Controller
@RequestMapping("/manage")
public class ManageAction extends ManageBaseAction {

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap)
			throws FolderNotFoundException {
		modelMap.put("articleCount", 0);
		modelMap.put("downloadCount", 0);
		modelMap.put("userCount", 0);
		modelMap.put("folderAll", folderService.getAllFolderList(this.getAdmin(request).getSiteId()));
//		List<ArticleVo> articleList = articleService
//				.getArticleListByAdminIdAndFolderId(this
//						.getAdmin(request).getSiteId(),admin.getAdminId(), 0,
//						null, 0, 10);
//		modelMap.put("articleList", articleList);
		return "manage/index";
	}

}
