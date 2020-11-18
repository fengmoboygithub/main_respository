package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.PostRoleRelaService;
import com.interapi.app.bmp.dao.PostRoleRelaMapper;
import com.interapi.app.bmp.model.PostRoleRela;
import com.interapi.app.bmp.model.PostRoleRelaExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostRoleRelaServiceImpl extends BaseServiceImpl<PostRoleRela, PostRoleRelaExample> implements PostRoleRelaService<PostRoleRela, PostRoleRelaExample>{

    @Autowired
    private PostRoleRelaMapper mapper;
	
	public IBaseDao<PostRoleRela, PostRoleRelaExample> getMapper(){
		return mapper;
	}

	/**
	 * 根据岗位id查询角色
	 * @param postId
	 * @return
     */
	@Override
	public List<PostRoleRela> getListByPostId(Long postId) {
		return mapper.getListByPostId(postId);
	}

	/**
	 * 保存岗位角色分配
	 * @param postId
	 * @param roleList
     */
	@Override
	public void updatePostRoleRela(Long postId, String roleList) {
		mapper.deleteByPostId(postId);
		List<PostRoleRela> list = new ArrayList<>();
		System.out.println(roleList);
		if(null!=roleList && !"".equals(roleList)){
			String[] roleStr =  roleList.split(",");
			for(int i = 0; i < roleStr.length; i++){
				String obj=roleStr[i];
				Long roleId = Long.parseLong(obj);
				PostRoleRela recode = new PostRoleRela();
				recode.setPostId(postId);
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