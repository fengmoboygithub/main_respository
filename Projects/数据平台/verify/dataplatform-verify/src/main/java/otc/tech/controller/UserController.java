package otc.tech.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import otc.tech.base.controller.BaseController;
import otc.tech.model.User;
import otc.tech.service.IUserService;
import otc.tech.util.AjaxResult;
import otc.tech.util.BeanUtils;
import otc.tech.util.StringUtils;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private String prefix = "user";
	
	@Autowired
	private IUserService userService;

	 @GetMapping("/resetPwd/{userId}")
	    public String resetPwd(@PathVariable("userId") String userId, ModelMap mmap)
	    {
	        mmap.put("user", userService.selectByPrimaryKey(userId));
	        return prefix + "/resetPwd";
	    }
	 
	    @GetMapping("/checkPassword")
	    @ResponseBody
	    public boolean checkPassword(String password)
	    {
	    	User user =new User();
			Object obj =  SecurityUtils.getSubject().getPrincipal();
			if (StringUtils.isNotNull(obj)) {
				BeanUtils.copyBeanProp(user, obj);
			}
			
	        //String encrypt = ShiroUtils.crypto(password, user.getSalt());
	        if (user.getPassword().equals(password))
	        {
	            return true;
	        }
	        return false;
	    }

	    @PostMapping("/resetPwd")
	    @ResponseBody
	    public AjaxResult resetPwd(User user)
	    {
	        //user.setSalt(ShiroUtils.randomSalt());
	        //user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
	        int rows = userService.updateByPrimaryKeySelective(user);
	        if (rows > 0)
	        {
	        	user=userService.selectByPrimaryKey(user);
	        	Subject subject =SecurityUtils.getSubject();
	    		PrincipalCollection principalCollection = subject.getPrincipals();
	    		String realmName = principalCollection.getRealmNames().iterator().next();
	    		PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
	    		// 重新加载Principal
	    		subject.runAs(newPrincipalCollection);
	        	//shiroUtilService.setSysUser(userService.selectUserById(user.getUserId()));
	            return success();
	        }
	        return error();
	    }

}
