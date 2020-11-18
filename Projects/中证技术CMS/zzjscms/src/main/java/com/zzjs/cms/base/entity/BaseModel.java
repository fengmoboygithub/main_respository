package com.zzjs.cms.base.entity;
import java.io.Serializable;
import java.util.Date;



public class BaseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private long id;
	/**
	 * 页码
	 */
	private int offset;
	/**
	 * 每页最多显示条数
	 */
	private int rows;
	/**
	 * 排序
	 */
	private int sort;
	/**
	 * 创建人ID
	 */
	private long createUser;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最近修改人ID
	 */
	private long updateUser;
	/**
	 * 最近修改时间
	 */
	private Date updateTime;
	/**
	 * 是否注销标识
	 */
	private String isDelete;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public long getCreateUser() {
		return createUser;
	}
	public void setCreateUser(long createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(long updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}