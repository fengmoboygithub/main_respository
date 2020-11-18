/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zzjs.cms.constant.MediaConstant;
import com.zzjs.cms.constant.MediaEntityConstant;
import com.zzjs.cms.constant.MediaEntityConstant.Entity;
import com.zzjs.cms.dao.MediaDao;
import com.zzjs.cms.entity.FileinfoMediaRela;
import com.zzjs.cms.entity.Media;
import com.zzjs.cms.entity.vo.FolderVo;
import com.zzjs.cms.entity.vo.MediaEntityRelaVo;
import com.zzjs.cms.entity.vo.MediaVo;
import com.zzjs.cms.exception.UploadException;
import com.zzjs.cms.util.MediaUtils;

@Service
public class MediaService {

	@Autowired
	private MediaDao mediaDao;
	
	@Autowired
	private FileinfoMediaService fileinfoMediaService;
	
	@Autowired
	private FolderService folderService;
	
	@Autowired
	private MediaEntityRelaService mediaEntityRelaService;
	
	/*
	 * 上传附件
	 */
	@CacheEvict(value = "media", allEntries = true)
	public Media addUploadFile(MultipartFile multipartFile, String fileName,
			long entityId, Entity entity) throws IllegalStateException,
			IOException, UploadException {
		MediaConstant.Type type = MediaConstant.Type.photo;
		if (MediaUtils.isFileType(fileName, MediaUtils.PHOTO_TYPE)) {
			type = MediaConstant.Type.photo;
		} else if (MediaUtils.isFileType(fileName, MediaUtils.FILE_TYPE)) {
			type = MediaConstant.Type.file;
		} else {
			throw new UploadException("文件类型有误");
		}
		Date now = new Date();
		String path = MediaUtils.save(multipartFile);
		Media attachment = new Media();
		attachment.setName(fileName);
		attachment.setPath(path);
		attachment.setType(type);
		attachment.setSize(multipartFile.getSize());
		StringBuffer sb = new StringBuffer(MediaUtils.getFileExt(fileName));
		if(sb.length()>0){
			attachment.setSuffix(sb.deleteCharAt(0).toString());
		}
		attachment.setCreateTime(now);
		mediaDao.addMedia(attachment);
		//添加资源文件与实体关系
		mediaEntityRelaService.addMediaEntityRela(attachment.getMediaId(), entityId, entity);
		return attachment;
	}

	/**
	 * 删除附件通过附件ID  删除资源文件与文件关系
	 */
	@CacheEvict(value = "media", allEntries = true)
	public void deleteMedia(long attachmentId, String path) {
		mediaDao.deleteMedia(attachmentId);
		//删除资源文件与文件关系
		fileinfoMediaService.deleteFileinfoMediaByMediaId(attachmentId);
		//删除资源文件与实体关系
		mediaEntityRelaService.deleteMediaEntityRelaByMediaId(attachmentId);
		MediaUtils.deleteFile(path);
	}

	/**
	 * @param attachmentId
	 * @return
	 */
	@Cacheable("media")
	public Media getMediaById(long attachmentId) {
		return mediaDao.getMediaById(attachmentId);
	}

	/**
	 * @param attachmentId
	 * @param link
	 * @return
	 */
	@CacheEvict(value = "media", allEntries = true)
	public int updateLinkByMediaId(long attachmentId, String link) {
		return mediaDao.updateLinkByMediaId(attachmentId, link);
	}

	@CacheEvict(value = "media", allEntries = true)
	public int updateNameByMediaId(long attachmentId, String name) {
		return mediaDao.updateNameByMediaId(attachmentId, name);

	}
	
	/**
	 * 得到所有资源列表
	 * @param rows
	 * @return
	 */
	public List<MediaVo> getMediaListAll(long entityId, int rows){
		List<MediaVo> list = new ArrayList<MediaVo>();
		List<MediaVo> mediaList = mediaDao.getMediaListAll(0, rows);
		for(MediaVo media : mediaList){
			MediaEntityRelaVo mediaEntityRelaVo = mediaEntityRelaService.getMediaEntityByEntityIdAndMediaId(entityId, media.getMediaId(), MediaEntityConstant.Entity.folder);
			if(mediaEntityRelaVo == null){
				list.add(media);
			}
		}
		return list;
	}
	
	/**
	 * 通过站点Id得到所有资源列表
	 * @param siteId
	 * @return
	 */
	public List<MediaVo> getMediaListAllBySiteId(long siteId){
		List<MediaVo> mediaList = mediaDao.getMediaListBySiteId(siteId, MediaEntityConstant.Entity.folder, MediaConstant.Type.file);
		List<FolderVo> folderList = folderService.getAllFolderList(siteId);
		for(MediaVo media : mediaList){
			long mfId = media.getFolderId();
			for (FolderVo folder : folderList) {
				if(folder.getFolderId()==mfId){
					media.setPathName(folder.getPathName());
					media.setPathEname(folder.getPathEname());
				}
			}
		}
		return mediaList;
	}
	
	/**
	 * 通过站点Id得到所有资源列表 打上是否属于该文件的标识
	 * @param siteId
	 * @param fileId
	 * @return
	 */
	public List<MediaVo> getMediaListAllBySiteId(long siteId, long fileId){
		List<MediaVo> mediaList = this.getMediaListAllBySiteId(siteId);
		for(MediaVo media : mediaList){
			FileinfoMediaRela fileinfoMediaRela = fileinfoMediaService.getFileinfoMediaByfileIdAndmediaId(fileId, media.getMediaId());
			if(fileinfoMediaRela == null){
				media.setOwner("no");
			} else {
				media.setOwner("yes");
			}
		}
		return mediaList;
	}

}
