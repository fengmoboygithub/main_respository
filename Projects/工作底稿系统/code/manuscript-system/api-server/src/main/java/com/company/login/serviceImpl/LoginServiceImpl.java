package com.company.login.serviceImpl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.constant.BaseConstant;
import com.company.exception.AuthException;
import com.company.login.service.LoginService;
import com.company.userinfo.dao.UserTabMapper;
import com.company.userinfo.model.UserTab;
import com.company.userinfo.model.UserTabExample;
import com.company.userinfo.model.UserTabExample.Criteria;
import com.company.utils.AuthUtils;

/**
 * 登陆登出相关操作实现类
 * @author yangyanchao
 *
 */
@Service
public class LoginServiceImpl extends BaseServiceImpl<UserTab, UserTabExample> implements LoginService<UserTab, UserTabExample>{

    @Autowired
    private UserTabMapper mapper;
	
	public IBaseDao<UserTab, UserTabExample> getMapper(){
		return mapper;
	}
	
	public void login(String name, String password,
			HttpServletRequest request) throws AuthException {
		UserTabExample example = new UserTabExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
        criteria.andUserAccEqualTo(name);
		List<UserTab> list = mapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			throw new AuthException("用户名或密码错误");
		}
		UserTab admin = list.get(0);
		String loginPassword = AuthUtils.getPassword(password);
		if (loginPassword.equals(admin.getUserPwd())) {
			request.getSession().setAttribute(BaseConstant.LOGIN_KEY, admin.getId());
	        request.getSession().setAttribute(BaseConstant.LOGIN_USER, admin);
		} else {
			throw new AuthException("用户名或密码错误");
		}
	}
}