package com.zzjs.cms.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.base.dao.IBaseDao;
import com.zzjs.cms.entity.ComponentTemplate;

@Repository
public interface ComponentTemplateDao extends IBaseDao<ComponentTemplate>{
	
	/**
	 * 通过id逻辑删除模板
	 * @param id
	 * @return
	 */
	public int deleteTemplateLogical(@Param("id") long id);
	
	/**
	 * 添加模版（根据入参选择添加）
	 * @param template
	 * @return 添加模板，返回生效数，入参的template的id会重新赋值为插入数据的主键id
	 */
	public Integer addTemplate(ComponentTemplate template);
	
	/**
	 * 通过主键选择性更新模板
	 * @param template
	 * @return
	 */
	public int updateByIdSelective(ComponentTemplate template);
}
