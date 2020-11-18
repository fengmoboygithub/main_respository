package otc.tech.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import otc.tech.base.controller.BaseController;
import otc.tech.model.Menu;
import otc.tech.model.User;
import otc.tech.service.IMenuService;
import otc.tech.service.IReportTypesService;
import otc.tech.util.BeanUtils;
import otc.tech.util.StringUtils;

import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class IndexController extends BaseController {

	@Autowired
	private IMenuService menuService;
	
	// 系统首页
	@GetMapping("/index")
	public String index(ModelMap mmap) {

		User user =new User();
		Object obj =  SecurityUtils.getSubject().getPrincipal();
		if (StringUtils.isNotNull(obj)) {
			BeanUtils.copyBeanProp(user, obj);
		}
		
		user.setName("管理员");
		// 根据用户id取出菜单
		Menu menu = new Menu();
		menu.setParentId(0);
		Menu restmenus = menuService.selectOne(menu);
		Menu menu1 = new Menu();
		menu1.setParentId(1);
		List<Menu> restmenus1 = menuService.select(menu1);
		restmenus.getChildren().addAll(restmenus1);
		mmap.put("menus", restmenus);
		mmap.put("user", user);
		return "index";
	}

	// 系统介绍
	@GetMapping("/system/main")
	public String main(ModelMap mmap) {
		mmap.put("version", "1.0");
		return "main";
	}
}
