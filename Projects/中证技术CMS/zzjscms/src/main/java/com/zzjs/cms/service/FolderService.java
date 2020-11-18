/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzjs.cms.constant.FolderConstant;
import com.zzjs.cms.dao.FolderDao;
import com.zzjs.cms.entity.Folder;
import com.zzjs.cms.entity.vo.FolderVo;
import com.zzjs.cms.exception.FolderNotFoundException;

/**
 * 目录服务
 * 
 * @author yangyanchao
 * 
 */
@Service
public class FolderService {

	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private FolderDao folderDao;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加目录
	 * 
	 * @param fatherId
	 * @param name
	 * @param ename
	 * @param status
	 * @param type
	 * @return Folder
	 * @throws FolderNotFoundException
	 */
	@CacheEvict(value = "folder", allEntries = true)
	@Transactional
	public Folder addFolder(long siteId, long fatherId, String name, String ename,
			FolderConstant.status status)
			throws FolderNotFoundException {
		Folder folder = new Folder();
		folder.setSiteId(siteId);
		folder.setFatherId(fatherId);
		if (fatherId == 0) {
			folder.setLevel(1);
		} else {
			Folder fatherFolder = this.getFolderById(fatherId);
			folder.setLevel(fatherFolder.getLevel() + 1);
		}
		folder.setName(name);
		folder.setEname(ename);
		folder.setPath("");
		folder.setSort(1);
		folder.setStatus(status);
		folder.setCreateTime(new Date());
		folderDao.addFolder(folder);
		if (fatherId == 0) {
			this.updatePath(folder.getFolderId(), folder.getFolderId() + "");
		} else {
			Folder fatherFolder = this.getFolderById(fatherId);
			this.updatePath(folder.getFolderId(), fatherFolder.getPath() + "#"
					+ folder.getFolderId());
		}
		return folder;
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除目录
	 * 
	 * @param folderId
	 * @return boolean
	 */
	@CacheEvict(value = "folder", allEntries = true)
	public boolean deleteFolderById(long folderId) {
		return folderDao.deleteFolder(folderId);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 更新目录
	 * 
	 * @param folderId
	 * @param fatherId
	 * @param ename
	 * @param name
	 * @param status
	 * @param type
	 * @param sort
	 * @return folder
	 */
	@CacheEvict(value = "folder", allEntries = true)
	public void updateFolderById(long folderId, String name, String ename,
			FolderConstant.status status) {
		folderDao.updateFolderById(folderId, name, ename, status);
	}

	/**
	 * 通过指定Id修改其目录的序列
	 * 
	 * @param folderId
	 * @param sort
	 * @return Integer
	 */
	@CacheEvict(value = "folder", allEntries = true)
	public int updateSort(long folderId, int sort) {
		return folderDao.updateSort(folderId, sort);
	}

	/**
	 * 通过指定Id修改其目录的路径
	 * 
	 * @param folderId
	 * @param path
	 * @return Integer
	 */
	public int updatePath(long folderId, String path) {
		return folderDao.updatePath(folderId, path);
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到指定目录
	 * 
	 * @param folderId
	 * @return Folder
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "folder")
	public FolderVo getFolderById(long folderId) throws FolderNotFoundException {
		FolderVo folder = folderDao.getFolderById(folderId);
		if (folder == null) {
			throw new FolderNotFoundException("");
		} else {
			logger.debug("目录("+folderId+")");
			return folder;
		}
	}
	
	/**
	 * 得到站点根目录
	 * 
	 * @param siteId
	 * @return Folder
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "folder")
	public FolderVo getRootFolderBySiteId(long siteId) throws FolderNotFoundException {
		FolderVo folder = folderDao.getRootFolderBySiteId(siteId);
		if (folder == null) {
			throw new FolderNotFoundException("");
		} else {
			return folder;
		}
	}

	/**
	 * 得到所有的四层目录
	 * 
	 * @return
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "folder")
	public List<FolderVo> getAllFolderList(long siteId) {
		List<FolderVo> folderList = folderDao.getAllFolderList(siteId);
		HashMap<String, FolderVo> folderMap = new HashMap<String, FolderVo>();
		for (FolderVo folder : folderList) {
			folderMap.put(folder.getFolderId() + "", folder);
		}
		for (FolderVo folder : folderList) {
			Map<String,String> map = getPathName(folderMap, folder.getPath());
			folder.setPathName(map.get("names_zh"));
			folder.setPathEname(map.get("names_en"));
		}
		return folderList;
	}

	@Cacheable(value = "folder")
	private Map<String,String> getPathName(HashMap<String, FolderVo> folderMap, String path) {
		List<String> names_zh = new ArrayList<String>();
		List<String> names_en = new ArrayList<String>();
		try {
			String[] folderIds = path.split("#");
			for (String folderId : folderIds) {
				names_zh.add(folderMap.get(folderId).getName());
				names_en.add(folderMap.get(folderId).getEname());
			}
		} catch (NullPointerException e) {
			logger.fatal(path + " - " + StringUtils.join(path.split("#"), ","));
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("names_zh", StringUtils.join(names_zh, " - "));
		map.put("names_en", StringUtils.join(names_en, "/"));
		return map;
	}

	/**
	 * 得到该站点下所有子目录
	 * 
	 * @param fatherId
	 * @return List<Folder>
	 */
	@Cacheable(value = "folder")
	public List<FolderVo> getFolderListByFatherId(long siteId, long fatherId,
			FolderConstant.status status) {
		return folderDao.getFolderListByFatherId(siteId, fatherId, status);
	}


	@Cacheable(value = "folder")
	public boolean isFolderByEname(String ename, long fatherId) {
		Folder folder = folderDao.getFolderByEname(ename, fatherId);
		if (folder == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 得到目录的Path
	 * 
	 * @param folderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "folder")
	public List<FolderVo> getFolderPathListByFolderId(long folderId)
			throws FolderNotFoundException {
		List<FolderVo> list = new ArrayList<FolderVo>();
		if (folderId == 0) {
			return list;
		} else {
			Folder folder = this.getFolderById(folderId);
			String[] str = folder.getPath().split("#");
			for (int i = 0; i < folder.getLevel(); i++) {
				FolderVo fold = this.getFolderById(Long.parseLong(str[i]));
				list.add(fold);
			}
			return list;
		}
	}

	@CacheEvict(value = "folder", allEntries = true)
	public void updateStatus(long folderId, FolderConstant.status status) {
		folderDao.updateStatus(folderId, status);
	}


	public long firstFolderId(long folderId) {
		FolderVo folder = folderDao.getFolderById(folderId);
		String[] folderIdList = folder.getPath().split("#");
		return Long.parseLong(folderIdList[0]);
	}

}
