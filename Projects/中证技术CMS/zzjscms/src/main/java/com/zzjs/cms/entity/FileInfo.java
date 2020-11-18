/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;
import com.zzjs.cms.constant.FileInfoConstant;

/**
 * 文件实体
 * 
 * @author yangyanchao
 * 
 */

public class FileInfo extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 文件Id
	 */
	private long fileId;
	
	/**
	 * 站点Id
	 */
	private long siteId;

	/**
	 * 所属目录的第一级Id
	 */
	private long folderId;
	
	/**
	 * 文件类别
	 */
	private FileInfoConstant.Types fileType;
	
	/**
	 * 文件版本
	 */
	private long fileVersion;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 英文名称
	 */
	private String ename;
	
	/**
	 * 中文名称
	 */
	private String name;

	/**
	 * 源码内容
	 */
	private String sourceCode;
	
	/**
	 * html片段
	 */
	private String htmlCodeByEdit;

	/**
	 * 文件状态
	 */
	private FileInfoConstant.Status status;

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public FileInfoConstant.Types getFileType() {
		return fileType;
	}

	public void setFileType(FileInfoConstant.Types fileType) {
		this.fileType = fileType;
	}

	public long getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(long fileVersion) {
		this.fileVersion = fileVersion;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public FileInfoConstant.Status getStatus() {
		return status;
	}

	public void setStatus(FileInfoConstant.Status status) {
		this.status = status;
	}
	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
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

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getHtmlCodeByEdit() {
		return htmlCodeByEdit;
	}

	public void setHtmlCodeByEdit(String htmlCodeByEdit) {
		this.htmlCodeByEdit = htmlCodeByEdit;
	}
}
