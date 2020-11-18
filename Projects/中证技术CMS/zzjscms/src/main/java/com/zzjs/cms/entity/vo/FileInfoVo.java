package com.zzjs.cms.entity.vo;

import java.util.List;

import com.zzjs.cms.entity.FileInfo;
import com.zzjs.cms.entity.Folder;

public class FileInfoVo extends FileInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Folder folder;

	private List<FolderVo> folderPathList;

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public List<FolderVo> getFolderPathList() {
		return folderPathList;
	}

	public void setFolderPathList(List<FolderVo> folderPathList) {
		this.folderPathList = folderPathList;
	}
}
