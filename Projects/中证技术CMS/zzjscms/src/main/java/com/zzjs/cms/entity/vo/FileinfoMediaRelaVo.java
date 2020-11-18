package com.zzjs.cms.entity.vo;

import com.zzjs.cms.entity.FileinfoMediaRela;
/**
 * 文件与资源文件关系表表VO
 * @author yangyanchao
 *
 */
public class FileinfoMediaRelaVo extends FileinfoMediaRela {
	private MediaVo media;
	
	private String pathEname;

	public MediaVo getMedia() {
		return media;
	}

	public void setMedia(MediaVo media) {
		this.media = media;
	}

	public String getPathEname() {
		return pathEname;
	}

	public void setPathEname(String pathEname) {
		this.pathEname = pathEname;
	}
}
