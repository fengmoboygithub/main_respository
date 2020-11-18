package otc.tech.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import otc.tech.base.controller.BaseController;
import otc.tech.model.User;
import otc.tech.util.AjaxResult;
import otc.tech.util.LoginCheck;

@Controller
public class LogController extends BaseController {
	@Autowired
	private LoginCheck logincheck;

	@GetMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		// 如果是Ajax请求，返回Json字符串。
		return "login";
		// return new ModelAndView("login");
	}

	@PostMapping("/loginUser")
	@ResponseBody
	public AjaxResult login(HttpServletRequest request,HttpSession session) { // 从前台页面取得的值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
        	System.out.println("获取到信息，开始验证！！");
            subject.login(token);//登陆成功的话，放到session中
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return success();
        } catch (Exception e) {
        	String msg = "用户或密码错误";
			return error(msg);
        }


//		String user_name = logincheck.check(username, password);
//		if (user_name != null && user_name != "账户或者密码错误") {
//			return success();
//		} else {
//			String msg = "用户或密码错误";
//			return error(msg);
//		}
	}
	
//	@GetMapping("/logout")
//	public String logout() {
//		return "login";
//	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}


}
