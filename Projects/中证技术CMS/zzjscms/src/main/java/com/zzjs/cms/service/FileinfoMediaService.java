package com.zzjs.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.zzjs.cms.dao.FileinfoMediaRelaDao;
import com.zzjs.cms.entity.FileinfoMediaRela;
import com.zzjs.cms.entity.Media;
import com.zzjs.cms.entity.vo.FileinfoMediaRelaVo;
import com.zzjs.cms.entity.vo.MediaVo;
import com.zzjs.cms.util.SSUtils;

@Service
public class FileinfoMediaService {

	@Autowired
	private FileinfoMediaRelaDao fileinfoMediaRelaDao;
	
	@Autowired
	private MediaService mediaService;

	@CacheEvict(value = "fileInfo", allEntries = true)
	public FileinfoMediaRela addFileinfoMedia(long fileId, long mediaId) {
		FileinfoMediaRela fileinfoMediaRela = new FileinfoMediaRela();
		fileinfoMediaRela.setFileId(fileId);
		fileinfoMediaRela.setMediaId(mediaId);
		fileinfoMediaRela.setSort(1);
		fileinfoMediaRela.setCreateTime(new Date());
		fileinfoMediaRelaDao.addFileinfoMedia(fileinfoMediaRela);
		return fileinfoMediaRela;
	}
	
	/**
	 * 通过指定Id修改其引入文件的序列
	 * 
	 * @param folderId
	 * @param sort
	 * @return Integer
	 */
	@CacheEvict(value = "fileInfo", allEntries = true)
	public int updateSort(long mediaId, long fileId, int sort) {
		return fileinfoMediaRelaDao.updateSort(mediaId, fileId, sort);
	}

	@CacheEvict(value = "fileInfo", allEntries = true)
	public int deleteFileinfoMedia(long fileId, long mediaId) {
		return fileinfoMediaRelaDao.deleteFileinfoMedia(fileId, mediaId);
	}
	
	public int deleteFileinfoMediaByFileId(long fileId) {
		return fileinfoMediaRelaDao.deleteFileinfoMediaByFileId(fileId);
	}
	
	public int deleteFileinfoMediaByMediaId(long mediaId) {
		return fileinfoMediaRelaDao.deleteFileinfoMediaByMediaId(mediaId);
	}

	/**
	 * 通过文件Id查询与之关联的资源文件列表
	 * @param fileId
	 * @return
	 */
	public List<FileinfoMediaRelaVo> getFileinfoMediaListByFileId(long fileId, List<MediaVo> mediaAll) {
		List<FileinfoMediaRelaVo> list = fileinfoMediaRelaDao
				.getFileinfoMediaListByFileId(fileId);
		for(FileinfoMediaRelaVo fileinfoMediaRelaVo : list){
			if(mediaAll != null && mediaAll.size() > 0){
				for(MediaVo media : mediaAll){
					if(media.getMediaId() == fileinfoMediaRelaVo.getMediaId()){
						fileinfoMediaRelaVo.setMedia(media);
						//将目录去除
						String folerDir = media.getPathEname();
						folerDir = SSUtils.delRootFoler(folerDir);
						fileinfoMediaRelaVo.setPathEname(folerDir+"/"+media.getName());
						break;
					}
				}
			}
		}
		return list;
	}
	
	/**
	 * 通过文件Id查询与之关联的资源文件列表
	 * @param fileId
	 * @return
	 */
	public List<FileinfoMediaRelaVo> getFileinfoMediaListByFileId(long fileId) {
		List<FileinfoMediaRelaVo> list = fileinfoMediaRelaDao
				.getFileinfoMediaListByFileId(fileId);
		for(FileinfoMediaRelaVo fileinfoMediaRelaVo : list){
			Media media = mediaService.getMediaById(fileinfoMediaRelaVo.getMediaId());
			fileinfoMediaRelaVo.setMedia((MediaVo)media);
		}
		return list;
	}
	
	public FileinfoMediaRelaVo getFileinfoMediaByfileIdAndmediaId(long fileId, long mediaId) {
		return fileinfoMediaRelaDao.getFileinfoMediaByfileIdAndmediaId(fileId, mediaId);
	}
}
