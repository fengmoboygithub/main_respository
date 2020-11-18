package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.AuthorityPageRelaService;
import com.interapi.app.bmp.dao.AuthorityPageRelaMapper;
import com.interapi.app.bmp.model.AuthorityPageRela;
import com.interapi.app.bmp.model.AuthorityPageRelaExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthorityPageRelaServiceImpl extends BaseServiceImpl<AuthorityPageRela, AuthorityPageRelaExample> implements AuthorityPageRelaService<AuthorityPageRela, AuthorityPageRelaExample>{

    @Autowired
    private AuthorityPageRelaMapper mapper;
	
	public IBaseDao<AuthorityPageRela, AuthorityPageRelaExample> getMapper(){
		return mapper;
	}

	/**
	 * 根据权限id查询菜单
	 * @param authorityId
	 * @return
     */
	@Override
	public List<AuthorityPageRela> getListByAuthorityId(Long authorityId) {
		return mapper.getListByAuthorityId(authorityId);
	}

	/**
	 * 保存权限菜单配置
	 * @param authorityId
	 * @param pageList
     */
	@Override
	public void updateAuthorityPageRela(Long authorityId, String pageList) {
		mapper.deleteByAuthorityId(authorityId);
		List<AuthorityPageRela> list = new ArrayList<>();
		System.out.println(pageList);
		if(null!=pageList && !"".equals(pageList)){
			String[] pageStr =  pageList.split(",");
			for(int i = 0; i < pageStr.length; i++){
				String obj=pageStr[i];
				Long pageId = Long.parseLong(obj);
				AuthorityPageRela recode = new AuthorityPageRela();
				recode.setAuthorityId(authorityId);
				recode.setPageId(pageId);
				recode.setCreateTime(new Date());
				recode.setCreateUser(0L);
				recode.setIsDelete("1");
				list.add(recode);
			}
			mapper.insertBatch(list);
		}
	}
}