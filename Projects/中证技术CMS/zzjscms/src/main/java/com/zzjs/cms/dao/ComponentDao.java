package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.entity.Component;
import com.zzjs.cms.entity.ComponentType;
import com.zzjs.cms.entity.vo.ComponentTypeVo;
import com.zzjs.cms.entity.vo.ComponentVo;

/**
 * 组件dao
 * @author yinlong
 *
 */
@Repository
public interface ComponentDao {

	/**
	 * 通过adminId 获取该adminId下 所有组件数据
	 * @param offset
	 * @param rows
	 * @param check 
	 * @param adminId
	 * @return
	 */
	public List<ComponentVo> getComponentList(@Param("offset") long offset,
			@Param("rows") long rows, @Param("componentName") String  componentName , 
			@Param("compTypeId") String compTypeId);

	/**
	 * 通过adminId 获取该adminId下所有组件的数量
	 * @param check 
	 * @param adminId
	 * @return
	 */
	public int getComponentListCount(@Param("componentName")  String componentName, 
			@Param("compTypeId") String compTypeId);
	/**
	 * 删除组件
	 * @param componentId
	 * @return
	 */
	public int deleteComponent(@Param("componentId") long componentId);
	
	/**
	 * 增加组件
	 * @param component
	 */
	public void addComponent(Component component);
	
	/**
	 * 通过id查询组件
	 * @param componentId
	 * @return
	 */
	public ComponentVo getComponentById(long componentId);

	/**
	 * 获取所有组件类型
	 * @return
	 */
	public List<ComponentType> getAllComponentType();
	
	/**
	 * 获取所有组件
	 * @return
	 */
	public List<ComponentVo> getAllComponent(ComponentVo component);
	
	/**
	 * 更新组件
	 * @param component
	 */
	public void updateComponentById(Component component);

	/**
	 * 获取所有组件类型以及组件类型下组件
	 * @return
	 */
	public List<ComponentTypeVo> getAllComponentTypeVos();
	
	/**
	 * 获取组件类型以及组件类型下已有组件模板的组件
	 * @return
	 */
	public List<ComponentTypeVo> getHaveTempComponentTypeVos();
}
