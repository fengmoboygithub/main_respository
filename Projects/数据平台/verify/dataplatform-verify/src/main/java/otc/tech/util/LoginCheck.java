package otc.tech.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import otc.tech.model.User;
import otc.tech.service.IUserService;
@Component
public class LoginCheck {
	@Autowired
	private IUserService userService;
	
	 public String check(String username,String password){
		 User user=new User();
		 user.setName(username);
		 user.setPassword(password);
		 User userlogin = null;
	        try {
	        	  userlogin = userService.selectOne(user);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        if(userlogin!=null) {
	        	return userlogin.getName();
	        }else {
	        	return "账户或者密码错误";
	        }
	        
	    }
}
