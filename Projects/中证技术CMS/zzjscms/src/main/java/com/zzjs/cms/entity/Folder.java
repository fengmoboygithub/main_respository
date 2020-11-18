/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;
import com.zzjs.cms.constant.FolderConstant;

/**
 * 目录实体
 * 
 * @author yangyanchao
 * 
 */
public class Folder extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 目录Id
	 */
	private long folderId;

	/**
	 * 父亲Id
	 */
	private long fatherId;
	
	/**
	 * 站点Id
	 */
	private long siteId;

	/**
	 * 英文名称
	 */
	private String ename;

	/**
	 * 目录名称
	 */
	private String name;

	/**
	 * 路径
	 */
	private String path;
	/**
	 * 层级
	 */
	private int level;
	/**
	 * 状态
	 */
	private FolderConstant.status status;

	/**
	 * 目录类型
	 */
	private String folderType;
	
	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public FolderConstant.status getStatus() {
		return status;
	}

	public void setStatus(FolderConstant.status status) {
		this.status = status;
	}

	public String getFolderType() {
		return folderType;
	}

	public void setFolderType(String folderType) {
		this.folderType = folderType;
	}


}
