package com.zzjs.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.base.service.BaseServiceImpl;
import com.zzjs.cms.dao.ComponentTemplateDao;
import com.zzjs.cms.entity.ComponentTemplate;

/**
 * 组件模板service
 * 
 * @author yangyanchao
 */
@Service
public class ComponentTemplateService extends BaseServiceImpl<ComponentTemplate>{
	@Autowired
	private ComponentTemplateDao componentTemplateDao;
	
	public ComponentTemplateDao getDao(){
		return componentTemplateDao;
	}
	
	/**
	 * 逻辑删除模板
	 * @param id
	 * @return
	 */
	public int deleteTemplateLogical(long id){
		return componentTemplateDao.deleteTemplateLogical(id);
	}
	
	/**
	 * 添加模板，返回生效数，入参的template的id会重新赋值为插入数据的主键id
	 * @param template
	 * @return
	 */
	public Integer addTemplate(ComponentTemplate template){
		return componentTemplateDao.addTemplate(template);
	}
	
	/**
	 * 通过主键选择性更新模板
	 * @param template
	 * @return
	 */
	public int updateByIdSelective(ComponentTemplate template){
		
		return componentTemplateDao.updateByIdSelective(template);
	}
}
