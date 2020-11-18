package com.interapi.app.bmp.serviceImpl;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import com.interapi.app.bmp.service.UserTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserTabServiceImpl extends BaseServiceImpl<UserTab, UserTabExample> implements UserTabService<UserTab, UserTabExample>{

    @Autowired
    private UserTabMapper mapper;
	
	public IBaseDao<UserTab, UserTabExample> getMapper(){
		return mapper;
	}

	@Value("${init.password:123456}")
	private String initPassword;

	/** 修改密码 */
	@Override
	@Transactional
	public void updatePassword(UserTab record) {
		final String rawPassword = "{bcrypt}"+ record.getPassword();
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserTab userTab = mapper.selectByPrimaryKey(record.getId());
		if(!passwordEncoder.matches(record.getOldPassword(),userTab.getPassword())){
			throw new RuntimeException("原始密码错误!");
		}
		record.setPassword(passwordEncoder.encode(rawPassword));
		record.setLastPasswordResetDate(new Date());
		mapper.updatePassword(record);
	}

	/** 保存用户 */
	@Override
	public void saveUser(UserTab record) {
		final String rawPassword = "{bcrypt}"+ record.getPassword();
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		// 加密
		record.setPassword(passwordEncoder.encode(rawPassword));
		record.setLastPasswordResetDate(new Date());
		record.setCreateTime(new Date());
		record.setCreateUser(0L);
		record.setIsDelete("1");
		mapper.insertSelective(record);
	}

	/** 初始化密码 */
	@Override
	public void initPassword(UserTab record) {
		final String rawPassword = "{bcrypt}"+initPassword;
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		// 加密
		record.setPassword(passwordEncoder.encode(rawPassword));
		record.setLastPasswordResetDate(new Date());
		mapper.updatePassword(record);
	}

	/**
	 * 根据id查询用户全部关联信息
	 * @param id
	 * @return
     */
	@Override
	public UserTab selectUserDetailById(Long id) {
		return mapper.selectUserDetailById(id);
	}


}