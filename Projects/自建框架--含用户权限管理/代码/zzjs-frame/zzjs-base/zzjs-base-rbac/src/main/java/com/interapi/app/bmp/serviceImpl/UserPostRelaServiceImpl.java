package com.interapi.app.bmp.serviceImpl;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.dao.UserPostRelaMapper;
import com.interapi.app.bmp.model.UserPostRela;
import com.interapi.app.bmp.model.UserPostRelaExample;
import com.interapi.app.bmp.service.UserPostRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserPostRelaServiceImpl extends BaseServiceImpl<UserPostRela, UserPostRelaExample> implements UserPostRelaService<UserPostRela, UserPostRelaExample>{

    @Autowired
    private UserPostRelaMapper mapper;
	
	public IBaseDao<UserPostRela, UserPostRelaExample> getMapper(){
		return mapper;
	}

	/**
	 * 根据用户id查询用户所有岗位
	 * @param userId
	 * @return
     */
	@Override
	public List<UserPostRela> getListByUserId(Long userId) {
		return mapper.getListByUserId(userId);
	}

	/**
	 * 保存用户岗位分配
	 * @param postList
     */
	@Override
	@Transactional
	public void updateUserPostRela(Long userId, String postList) {
		//首先根据用户id删除全部岗位，然后重新保存全部岗位
		//3种情况，新增，修改，删除
		//判断入参是否为空，如果不为空，则为新增或修改，新增与修改全部为首先删除表中该userid的全部岗位，然后执行插入
		//如果入参为空，则只删除该userid对应的岗位
		//删除操作
		mapper.deleteByUserId(userId);
		List<UserPostRela> list = new ArrayList<>();
		System.out.println(postList);
		if(null!=postList && !"".equals(postList)){
			String[] postStr =  postList.split(",");
			for(int i = 0; i < postStr.length; i++){
				String obj=postStr[i];
				Long postId = Long.parseLong(obj);
				UserPostRela recode = new UserPostRela();
				recode.setUserId(userId);
				recode.setPostId(postId);
				recode.setCreateTime(new Date());
				recode.setCreateUser(0L);
				recode.setIsDelete("1");
				list.add(recode);
			}
			mapper.insertBatch(list);
		}
	}
}