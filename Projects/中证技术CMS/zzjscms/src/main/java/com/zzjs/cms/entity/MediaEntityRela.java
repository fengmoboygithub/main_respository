package com.zzjs.cms.entity;

import com.zzjs.cms.base.entity.BaseModel;
import com.zzjs.cms.constant.MediaEntityConstant;

/**
 * 资源文件与实体关系表实体类
 * @author yangyanchao
 *
 */
public class MediaEntityRela extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long relaId;
	private long mediaId;
	private long entityId;
	private MediaEntityConstant.Entity entity;
	public long getRelaId() {
		return relaId;
	}
	public void setRelaId(long relaId) {
		this.relaId = relaId;
	}
	public long getEntityId() {
		return entityId;
	}
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	public MediaEntityConstant.Entity getEntity() {
		return entity;
	}
	public void setEntity(MediaEntityConstant.Entity entity) {
		this.entity = entity;
	}
	public long getMediaId() {
		return mediaId;
	}
	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}
}
