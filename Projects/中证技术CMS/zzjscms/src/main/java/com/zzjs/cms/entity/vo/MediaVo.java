package com.zzjs.cms.entity.vo;

import com.zzjs.cms.entity.Media;
/**
 * 资源文件表VO
 * @author yangyanchao
 *
 */
public class MediaVo extends Media {
	private long folderId;
	private String pathName;
	private String pathEname;
	private String owner;
	
	public long getFolderId() {
		return folderId;
	}
	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public String getPathEname() {
		return pathEname;
	}
	public void setPathEname(String pathEname) {
		this.pathEname = pathEname;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
