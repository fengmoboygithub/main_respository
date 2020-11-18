package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.UserRoleRelaService;
import com.interapi.app.bmp.dao.UserRoleRelaMapper;
import com.interapi.app.bmp.model.UserRoleRela;
import com.interapi.app.bmp.model.UserRoleRelaExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserRoleRelaServiceImpl extends BaseServiceImpl<UserRoleRela, UserRoleRelaExample> implements UserRoleRelaService<UserRoleRela, UserRoleRelaExample>{

    @Autowired
    private UserRoleRelaMapper mapper;
	
	public IBaseDao<UserRoleRela, UserRoleRelaExample> getMapper(){
		return mapper;
	}

	@Override
	public List<UserRoleRela> getListByUserId(Long userId) {
		return mapper.getListByUserId(userId);
	}

	@Override
	public void updateUserRoleRela(Long userId, String roleList) {
		mapper.deleteByUserId(userId);
		List<UserRoleRela> list = new ArrayList<>();
		System.out.println(roleList);
		if(null!=roleList && !"".equals(roleList)){
			String[] roleStr =  roleList.split(",");
			for(int i = 0; i < roleStr.length; i++){
				String obj=roleStr[i];
				Long roleId = Long.parseLong(obj);
				UserRoleRela recode = new UserRoleRela();
				recode.setUserId(userId);
				recode.setRoleId(roleId);
				recode.setCreateTime(new Date());
				recode.setCreateUser(0L);
				recode.setIsDelete("1");
				list.add(recode);
			}
			mapper.insertBatch(list);
		}
	}
}