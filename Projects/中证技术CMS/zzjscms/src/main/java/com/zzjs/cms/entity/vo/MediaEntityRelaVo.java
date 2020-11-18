package com.zzjs.cms.entity.vo;

import com.zzjs.cms.entity.MediaEntityRela;
/**
 * 资源文件与实体关系表VO
 * @author yangyanchao
 *
 */
public class MediaEntityRelaVo extends MediaEntityRela {
	
	private MediaVo media;
	
	private FolderVo folder;
	
	public MediaVo getMedia() {
		return media;
	}

	public void setMedia(MediaVo media) {
		this.media = media;
	}

	public FolderVo getFolder() {
		return folder;
	}

	public void setFolder(FolderVo folder) {
		this.folder = folder;
	}
	
}
