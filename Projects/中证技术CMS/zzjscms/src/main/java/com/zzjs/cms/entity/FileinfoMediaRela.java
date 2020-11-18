package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;

/**
 * 文件与资源文件关系表实体
 * @author yangyanchao
 *
 */
public class FileinfoMediaRela extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long relaId;
	private long mediaId;
	private long fileId;
	public long getRelaId() {
		return relaId;
	}
	public void setRelaId(long relaId) {
		this.relaId = relaId;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	public long getMediaId() {
		return mediaId;
	}
	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}
}
