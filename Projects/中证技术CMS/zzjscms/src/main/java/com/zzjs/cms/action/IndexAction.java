/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzjs.cms.base.action.BaseAction;

/**
 * 首页
 * 
 * @author yangyanchao
 */
@Controller
public class IndexAction extends BaseAction {

	/**
	 * 首页
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defalut(HttpServletRequest request,
			ModelMap modelMap) {
		modelMap.put("password", "");
		return "/manage/login";
	}

	/**
	 * 首页
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
//	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
//	public String home(@RequestParam(value = "p", defaultValue = "1") long p,
//			ModelMap modelMap) {
//		try {
//			modelMap.addAttribute("p", p);
//			modelMap.addAttribute("g_folderId", 0);
//			return themeService.getDefaultTemplate();
//		} catch (TemplateNotFoundException e) {
//			modelMap.addAttribute("g_folderId", 0);
//			logger.fatal(e.getMessage());
//			return themeService.get404();
//		}
//	}

	/**
	 * 404
	 * 
	 * @return
	 */
	@RequestMapping(value = "/404.htm", method = RequestMethod.GET)
	public String pageNotFound(ModelMap modelMap) {
		modelMap.addAttribute("g_folderId", 0);
		return themeService.get404();
	}

	/**
	 * 500
	 * 
	 * @return
	 */
	@RequestMapping(value = "/500.htm", method = RequestMethod.GET)
	public String error(ModelMap modelMap) {
		modelMap.addAttribute("g_folderId", 0);
		return themeService.get500();
	}
	
	/**
	 * 网站顶部数据  By  Test
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/topData.htm")
	public String topData(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		String result = "{\"message\":{\"showlist\":[{\"href\":\"http://www.baidu.com\",\"name\":\"手机版\"},{\"href\":\"http://www.baidu.com\",\"name\":\"登录\"},{\"href\":\"http://www.baidu.com\",\"name\":\"注册\"}],\"welcome\":\"欢迎光临报价系统网站！\"},\"result\":\"0\"}";
		request.setAttribute(AJAX_MSG, result);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		//{"message":{"showlist":[{"href":"http://www.baidu.com","name":"手机版"},{"href":"http://www.baidu.com","name":"登录"},{"href":"http://www.baidu.com","name":"注册"}],"welcome":"欢迎光临报价系统网站！"},"result":"0"}
		return AJAX;
	}
	
	/**
	 * 网站底部数据  By Test
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bottomData.htm")
	public String bottomData(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		String result = "{\"message\":{\"showlist\":[{\"href\":\"http://www.baidu.com\",\"name\":\"关于我们\"},{\"href\":\"http://www.baidu.com\",\"name\":\"服务条款\"},{\"href\":\"http://www.baidu.com\",\"name\":\"免责声明\"},{\"href\":\"http://www.baidu.com\",\"name\":\"网站地图\"},{\"href\":\"http://www.baidu.com\",\"name\":\"联系我们\"}],\"copyRight\":\"Copyright ©2010-2016中证技术 版权所有\"},\"result\":\"0\"}";
		request.setAttribute(AJAX_MSG, result);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		//{"message":{"showlist":[{"href":"http://www.baidu.com","name":"关于我们"},{"href":"http://www.baidu.com","name":"服务条款"},{"href":"http://www.baidu.com","name":"免责声明"},{"href":"http://www.baidu.com","name":"网站地图"},{"href":"http://www.baidu.com","name":"联系我们"}],"copyRight":"Copyright ©2010-2016中证技术 版权所有"},"result":"0"}
		return AJAX;
	}
	
	/**
	 * 显示tab标签 By Test
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/tabListTest.htm")
	public String tabListTest(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		String result = "{\"message\":{\"showlist\":[{\"flid\":\"4\",\"flmc\":\"备案公示\",\"flpx\":\"1\"},{\"flid\":\"5\",\"flmc\":\"参与人公告\",\"flpx\":\"2\"},{\"flid\":\"2\",\"flmc\":\"通知公告\",\"flpx\":\"2\"},{\"flid\":\"3\",\"flmc\":\"市场动态\",\"flpx\":\"3\"},{\"flid\":\"6\",\"flmc\":\"发行公告\",\"flpx\":\"3\"},{\"flid\":\"7\",\"flmc\":\"成立公告\",\"flpx\":\"4\"},{\"flid\":\"9\",\"flmc\":\"回售公告\",\"flpx\":\"6\"}],\"xxplType\":\"2\"},\"result\":\"0\"}";
		request.setAttribute(AJAX_MSG, result);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		//{"message":{"showlist":[{"flid":"4","flmc":"备案公示","flpx":"1"},{"flid":"5","flmc":"参与人公告","flpx":"2"},{"flid":"2","flmc":"通知公告","flpx":"2"},{"flid":"3","flmc":"市场动态","flpx":"3"},{"flid":"6","flmc":"发行公告","flpx":"3"},{"flid":"7","flmc":"成立公告","flpx":"4"},{"flid":"9","flmc":"回售公告","flpx":"6"}],"xxplType":"2"},"result":"0"}
		return AJAX;
	}
	
	/**
	 * 用ajax显示分页信息 By Test
	 * @param modelMap
	 * @param request
	 * @param xxplVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/pageListTest.htm")
	public String pageListTest(ModelMap modelMap, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		String result = "{\"code\": 1, \"success\": true, \"message\": \"成功\", \"matchedTotal\": 201, \"pageIndex\": 1, \"pageSize\": 10, \"pageTotal\": 0, \"resultSet\": [{\"bdid\":\"3819\",\"bt\":\"通知公告\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-07-13\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3796\",\"bt\":\"关于发布《机构间私募产品报价与服务系统代理交易业务指引（试行）》的通知\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-04-18\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3789\",\"bt\":\"关于就《机构间私募产品报价与服务系统代理交易业务指引（试行）》征求意见的通知\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-02-02\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3765\",\"bt\":\"关于《机构间私募产品报价与服务系统私募股权信息披露规则（征求意见稿）》及配套规则征求意见的通知\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-01-28\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3764\",\"bt\":\"关于《机构间私募产品报价与服务系统私募股权转让业务指引（修订稿）》征求意见通知\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-01-28\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3750\",\"bt\":\"关于就《资产转让业务指引》及《资产拍卖业务指引》征求意见的通知\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-01-26\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3743\",\"bt\":\"关于报价系统非公开发行公司债券申报文件有效期相关事项的通知\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-01-26\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3581\",\"bt\":\"关于报价系统2016年全年公共假日休市安排的通知\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2015-12-28\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3749\",\"bt\":\"报价系统参与人名单公告（第一百零五批）\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-01-26\",\"stick\":\"\",\"sytp\":\"\"},{\"bdid\":\"3748\",\"bt\":\"报价系统参与人名单公告（第一百零四批）\",\"category\":\"2\",\"flid\":\"\",\"flmc\":\"\",\"isnew\":\"\",\"pubTime\":\"2016-01-26\",\"stick\":\"\",\"sytp\":\"\"}]}";
		request.setAttribute(AJAX_MSG, result);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");  
        response.setHeader("Access-Control-Allow-Methods", "GET");  
        response.setHeader("Allow", "GET");  
        response.setHeader("Access-Control-Allow-Methods", "POST");  
        response.setHeader("Allow", "POST");
		//{"code": 1, "success": true, "message": "成功", "matchedTotal": 201, "pageIndex": 1, "pageSize": 10, "pageTotal": 0, "resultSet": [{"bdid":"3819","bt":"通知公告","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-07-13","stick":"","sytp":""},{"bdid":"3796","bt":"关于发布《机构间私募产品报价与服务系统代理交易业务指引（试行）》的通知","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-04-18","stick":"","sytp":""},{"bdid":"3789","bt":"关于就《机构间私募产品报价与服务系统代理交易业务指引（试行）》征求意见的通知","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-02-02","stick":"","sytp":""},{"bdid":"3765","bt":"关于《机构间私募产品报价与服务系统私募股权信息披露规则（征求意见稿）》及配套规则征求意见的通知","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-01-28","stick":"","sytp":""},{"bdid":"3764","bt":"关于《机构间私募产品报价与服务系统私募股权转让业务指引（修订稿）》征求意见通知","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-01-28","stick":"","sytp":""},{"bdid":"3750","bt":"关于就《资产转让业务指引》及《资产拍卖业务指引》征求意见的通知","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-01-26","stick":"","sytp":""},{"bdid":"3743","bt":"关于报价系统非公开发行公司债券申报文件有效期相关事项的通知","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-01-26","stick":"","sytp":""},{"bdid":"3581","bt":"关于报价系统2016年全年公共假日休市安排的通知","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2015-12-28","stick":"","sytp":""},{"bdid":"3749","bt":"报价系统参与人名单公告（第一百零五批）","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-01-26","stick":"","sytp":""},{"bdid":"3748","bt":"报价系统参与人名单公告（第一百零四批）","category":"2","flid":"","flmc":"","isnew":"","pubTime":"2016-01-26","stick":"","sytp":""}]}
		return AJAX;
	}
}
