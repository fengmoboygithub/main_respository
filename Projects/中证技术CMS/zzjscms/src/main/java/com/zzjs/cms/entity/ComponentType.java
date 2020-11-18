package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 组件类型实体
 * @author yinlong
 *
 */
public class ComponentType extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 组件类型ID
	 */
	private long compTypeId;
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
	private int sort;
	
	public long getCompTypeId() {
		return compTypeId;
	}
	public void setCompTypeId(long compTypeId) {
		this.compTypeId = compTypeId;
	}
	public String getCompTypeTip() {
		return compTypeTip;
	}
	public void setCompTypeTip(String compTypeTip) {
		this.compTypeTip = compTypeTip;
	}
	public String getCompTypeName() {
		return compTypeName;
	}
	public void setCompTypeName(String compTypeName) {
		this.compTypeName = compTypeName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}
