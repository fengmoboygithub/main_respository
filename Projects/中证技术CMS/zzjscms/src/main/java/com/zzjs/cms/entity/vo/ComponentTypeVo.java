package com.zzjs.cms.entity.vo;

import java.util.Date;
import java.util.List;

import com.zzjs.cms.constant.ComponentTypeConstant;
import com.zzjs.cms.entity.Component;

/**
 * 组件类型vo类
 * 
 * @author yinlong
 *
 */
public class ComponentTypeVo {
	/**
	 * 组件类型ID
	 */
	private long tpCompTypeId;
	/**
	 * 组件类型名称
	 */
	private String compTypeName;
	/**
	 * 组件提示
	 */
	private String compTypeTip;
	/**
	 * 排序
	 */
	private int tpSort;
	/**
	 * 创建时间
	 */
	private Date tpCreateTime;
	/**
	 * 更新时间
	 */
	private Date tpUpdateTime;
	
	/**
	 * 组件类型描述
	 */
	private ComponentTypeConstant.compTypeDesc compTypeDesc;
	
	/**
	 * html页面对应标签id
	 */
	private String htmlId;
	
	/**
	 * 组件类型下的所有组件
	 */
	private List<Component> components;

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}
	
	public long getTpCompTypeId() {
		return tpCompTypeId;
	}

	public void setTpCompTypeId(long tpCompTypeId) {
		this.tpCompTypeId = tpCompTypeId;
	}

	public String getCompTypeName() {
		return compTypeName;
	}

	public void setCompTypeName(String compTypeName) {
		this.compTypeName = compTypeName;
	}

	public String getCompTypeTip() {
		return compTypeTip;
	}

	public void setCompTypeTip(String compTypeTip) {
		this.compTypeTip = compTypeTip;
	}

	public int getTpSort() {
		return tpSort;
	}

	public void setTpSort(int tpSort) {
		this.tpSort = tpSort;
	}

	public Date getTpCreateTime() {
		return tpCreateTime;
	}

	public void setTpCreateTime(Date tpCreateTime) {
		this.tpCreateTime = tpCreateTime;
	}

	public Date getTpUpdateTime() {
		return tpUpdateTime;
	}

	public void setTpUpdateTime(Date tpUpdateTime) {
		this.tpUpdateTime = tpUpdateTime;
	}

	public ComponentTypeConstant.compTypeDesc getCompTypeDesc() {
		return compTypeDesc;
	}

	public void setCompTypeDesc(ComponentTypeConstant.compTypeDesc compTypeDesc) {
		this.compTypeDesc = compTypeDesc;
	}

	public String getHtmlId() {
		return htmlId;
	}

	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
	}

	
}
