package com.zzjs.cms.action.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzjs.cms.base.action.ManageBaseAction;

@Controller
@RequestMapping("/manage/codeEditer")
public class ManageCodeEditerAction extends ManageBaseAction {

	/**
	 * 进入在线编辑代码页面
	 */
	@RequestMapping(value = "/view.htm", method = RequestMethod.GET)
	public String manage(
			@RequestParam(value = "type", required=true) String type,
			@RequestParam(value = "id", required=true) String id,
			HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("id", id);
		modelMap.put("type", type);
		return "manage/codeEditer/editer";
	}
	
}
