/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;
import com.zzjs.cms.constant.MediaConstant;

//TODO media
public class Media extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long mediaId;
	private String name;
	private String path;
	private long size;
	private String suffix;
	private MediaConstant.Type type;

	public long getMediaId() {
		return mediaId;
	}

	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
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

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public MediaConstant.Type getType() {
		return type;
	}

	public void setType(MediaConstant.Type type) {
		this.type = type;
	}
}
