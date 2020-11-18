package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.AuthorityResourceRelaService;
import com.interapi.app.bmp.dao.AuthorityResourceRelaMapper;
import com.interapi.app.bmp.model.AuthorityResourceRela;
import com.interapi.app.bmp.model.AuthorityResourceRelaExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthorityResourceRelaServiceImpl extends BaseServiceImpl<AuthorityResourceRela, AuthorityResourceRelaExample> implements AuthorityResourceRelaService<AuthorityResourceRela, AuthorityResourceRelaExample>{

    @Autowired
    private AuthorityResourceRelaMapper mapper;
	
	public IBaseDao<AuthorityResourceRela, AuthorityResourceRelaExample> getMapper(){
		return mapper;
	}

	/**
	 * 根据权限id查询资源
	 * @param authorityId
	 * @return
     */
	@Override
	public List<AuthorityResourceRela> getListByAuthorityId(Long authorityId) {
		return mapper.getListByAuthorityId(authorityId);
	}

	/**
	 * 保存权限资源配置
	 * @param authorityId
	 * @param resourceList
     */
	@Override
	public void updateAuthorityResourceRela(Long authorityId, String resourceList) {
		mapper.deleteByAuthorityId(authorityId);
		List<AuthorityResourceRela> list = new ArrayList<>();
		System.out.println(resourceList);
		if(null!=resourceList && !"".equals(resourceList)){
			String[] pageStr =  resourceList.split(",");
			for(int i = 0; i < pageStr.length; i++){
				String obj=pageStr[i];
				Long resourceId = Long.parseLong(obj);
				AuthorityResourceRela recode = new AuthorityResourceRela();
				recode.setAuthorityId(authorityId);
				recode.setResourceId(resourceId);
				recode.setCreateTime(new Date());
				recode.setCreateUser(0L);
				recode.setIsDelete("1");
				list.add(recode);
			}
			mapper.insertBatch(list);
		}
	}
}