package com.zzjs.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.base.service.BaseServiceImpl;
import com.zzjs.cms.constant.ConfigConstant;
import com.zzjs.cms.dao.ComponentDao;
import com.zzjs.cms.entity.Component;
import com.zzjs.cms.entity.ComponentType;
import com.zzjs.cms.entity.vo.ComponentTypeVo;
import com.zzjs.cms.entity.vo.ComponentVo;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.util.SSUtils;

/**
 * 组件service
 * 
 * @author yinlong
 */
@Service
public class ComponentService extends BaseServiceImpl<ComponentVo>{
	@Autowired
	private ComponentDao componentDao;
	@Autowired
	private ConfigService configService;
	
	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////
	/**
	 * 添加组件
	 * 
	 * @param htmlCode
	 * @param compTypeId
	 * @param adminId
	 * @param siteName
	 * @param siteAddress
	 * @return Site
	 */
	public Component addComponent(String componentName, long compTypeId, String htmlCode,String className, int sort) {
		Date now = new Date();
		Component component = new Component();
		component.setComponentName(componentName);
		component.setCompTypeId(compTypeId);
		component.setClassName(className);
		component.setCreateTime(now);
		component.setUpdateTime(now);
		component.setSort(sort);
		component.setHtmlCode(htmlCode);
		componentDao.addComponent(component);
		return component;
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////
	/**
	 * 删除组件
	 * 
	 * @param componentId
	 */
	public int deleteComponent(long componentId) {
		return componentDao.deleteComponent(componentId);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////
	/**
	 * 修改组件
	 * @param componentId
	 * @param compTypeId
	 * @param text
	 * @param sort
	 * @param htmlCode
	 * @return
	 */
	public Component updateComponentById(long componentId, long compTypeId, String componentName,
			int sort, String className, String htmlCode) {
		Date now = new Date();
		Component component = new Component();
		component.setComponentId(componentId);
		component.setCompTypeId(compTypeId);
		component.setComponentName(componentName);
		component.setClassName(className);
		component.setUpdateTime(now);
		component.setHtmlCode(htmlCode);
		component.setSort(sort);
		componentDao.updateComponentById(component);
		return component;
	}
	

	/**
	 * 获取组件分页
	 * 
	 * @param pageNum
	 * @param compTypeId 
	 * @param compnentName 
	 * @param check
	 * @return
	 */
	public PageVo<ComponentVo> getComponentListPage(int pageNum, String componentName, 
			String compTypeId) {
		PageVo<ComponentVo> pageVo = new PageVo<ComponentVo>(pageNum);
		pageVo.setRows(configService.getIntKey(ConfigConstant.ZZJS_CMS_ROWS));
		List<ComponentVo> list = this.getComponentList(pageVo.getOffset(), pageVo.getRows(), componentName,
				compTypeId);
		pageVo.setList(list);
		pageVo.setCount(this.getComponentListCount(componentName, compTypeId));
		pageVo.getPageNumHtml();
		return pageVo;
	}

	/**
	 * 获取所有组件的数量
	 * 
	 * @param init
	 * @param adminId
	 * @return
	 */
	public int getComponentListCount(String componentName, String compTypeId) {
		return componentDao.getComponentListCount(componentName, compTypeId);
	}

	/**
	 * 条件分页查询获取所有组件数据
	 * 
	 * @param offset
	 * @param rows
	 * @param compTypeId 
	 * @param compnentName 
	 * @param check
	 * @param adminId
	 * @return
	 */
	public List<ComponentVo> getComponentList(int offset, int rows, String componentName, 
			String compTypeId) {
		return componentDao.getComponentList(offset, rows, componentName, compTypeId);
	}

	/**
	 * 获取所有组件类型
	 * @return
	 */
	public List<ComponentType> getAllComponentType() {
		List<ComponentType> componentTypes = componentDao.getAllComponentType();
		return componentTypes;
	}
	
	/**
	 * 获取所有组件列表
	 * @return
	 */
	public List<ComponentVo> getAllComponent(ComponentVo component) {
		List<ComponentVo> componentList = componentDao.getAllComponent(component);
		return componentList;
	}

	/**
	 * 查询id查询组件
	 * @param componentId
	 * @return
	 */
	public ComponentVo getComponentById(long componentId) {
		return componentDao.getComponentById(componentId);
	}

	/**
	 * 获取处理后的组件列表
	 * @param check
	 * @return
	 */
	public List<ComponentTypeVo> getAllDelPToHTMLComponentTypeVos() {
		List<ComponentTypeVo> compVos = componentDao.getHaveTempComponentTypeVos();
		for (ComponentTypeVo componentTypeVo : compVos) {
			List<Component> comps  = componentTypeVo.getComponents();
			for (Component component : comps) {
				String htmCode = SSUtils.toHTML(component.getHtmlCode());
				component.setHtmlCode(htmCode);
			}
		}
		return compVos;
	}

}
