package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 字典实体
 * @author yinlong
 *
 */
public class Dictionary extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private long id;
	/**
	 * 字典关键字
	 */
	private String dicKey;
	/**
	 * 数据值
	 */
	private String dicDataValue;
	/**
	 * 数据描述
	 */
	private String dicDataDesc;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDicKey() {
		return dicKey;
	}
	public void setDicKey(String dicKey) {
		this.dicKey = dicKey;
	}
	public String getDicDataValue() {
		return dicDataValue;
	}
	public void setDicDataValue(String dicDataValue) {
		this.dicDataValue = dicDataValue;
	}
	public String getDicDataDesc() {
		return dicDataDesc;
	}
	public void setDicDataDesc(String dicDataDesc) {
		this.dicDataDesc = dicDataDesc;
	}
	
}
