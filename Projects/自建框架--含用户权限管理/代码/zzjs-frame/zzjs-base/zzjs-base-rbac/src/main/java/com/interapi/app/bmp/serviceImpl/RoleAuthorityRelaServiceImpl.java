package com.interapi.app.bmp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interapi.app.base.dao.IBaseDao;
import com.interapi.app.base.service.BaseServiceImpl;
import com.interapi.app.bmp.service.RoleAuthorityRelaService;
import com.interapi.app.bmp.dao.RoleAuthorityRelaMapper;
import com.interapi.app.bmp.model.RoleAuthorityRela;
import com.interapi.app.bmp.model.RoleAuthorityRelaExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleAuthorityRelaServiceImpl extends BaseServiceImpl<RoleAuthorityRela, RoleAuthorityRelaExample> implements RoleAuthorityRelaService<RoleAuthorityRela, RoleAuthorityRelaExample>{

    @Autowired
    private RoleAuthorityRelaMapper mapper;
	
	public IBaseDao<RoleAuthorityRela, RoleAuthorityRelaExample> getMapper(){
		return mapper;
	}

	/**
	 * 根据角色id查询权限
	 * @param roleId
	 * @return
     */
	@Override
	public List<RoleAuthorityRela> getListByRoleId(Long roleId) {
		return mapper.getListByRoleId(roleId);
	}

	/**
	 * 保存角色权限配置
	 * @param roleId
	 * @param authorityList
     */
	@Override
	public void updateRoleAuthorityRela(Long roleId, String authorityList) {
		mapper.deleteByRoleId(roleId);
		List<RoleAuthorityRela> list = new ArrayList<>();
		System.out.println(authorityList);
		if(null!=authorityList && !"".equals(authorityList)){
			String[] authorityStr =  authorityList.split(",");
			for(int i = 0; i < authorityStr.length; i++){
				String obj=authorityStr[i];
				Long authorityId = Long.parseLong(obj);
				RoleAuthorityRela recode = new RoleAuthorityRela();
				recode.setRoleId(roleId);
				recode.setAuthorityId(authorityId);
				recode.setCreateTime(new Date());
				recode.setCreateUser(0L);
				recode.setIsDelete("1");
				list.add(recode);
			}
			mapper.insertBatch(list);
		}
	}
}