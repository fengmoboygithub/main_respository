/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zzjs.cms.constant.MediaEntityConstant.Entity;
import com.zzjs.cms.dao.MediaDao;
import com.zzjs.cms.dao.MediaEntityRelaDao;
import com.zzjs.cms.entity.MediaEntityRela;
import com.zzjs.cms.entity.vo.MediaEntityRelaVo;
import com.zzjs.cms.entity.vo.MediaVo;

@Service
public class MediaEntityRelaService {

	@Autowired
	private MediaEntityRelaDao mediaEntityRelaDao;
	
	@Autowired
	private MediaDao mediaDao;
	
	public MediaEntityRela addMediaEntityRela(long mediaId, long entityId, Entity entity) {
		MediaEntityRela mediaEntityRela = new MediaEntityRela();
		mediaEntityRela.setMediaId(mediaId);
		mediaEntityRela.setEntityId(entityId);
		mediaEntityRela.setEntity(entity);
		mediaEntityRela.setSort(1);
		mediaEntityRela.setCreateTime(new Date());
		mediaEntityRelaDao.addMediaEntityRela(mediaEntityRela);
		return mediaEntityRela;
	}

	public void deleteMediaEntityRela(long relaId) {
		mediaEntityRelaDao.deleteMediaEntityRela(relaId);
	}
	
	public void deleteMediaEntityRelaByMediaId(long mediaId){
		mediaEntityRelaDao.deleteMediaEntityRelaByMediaId(mediaId);
	}

	/**
	 * 通过实体ID和类型查询资源文件列表
	 * @param entityId
	 * @param entity
	 * @param rows
	 * @return
	 */
	public List<MediaEntityRelaVo> getMediaListByEntityId(long entityId,
			Entity entity, int rows) {
		List<MediaEntityRelaVo> list = mediaEntityRelaDao.getMediaListByEntityId(entityId, entity, 0, rows);
		for(MediaEntityRelaVo mediaEntityRelaVo : list){
			long mediaId = mediaEntityRelaVo.getMediaId();
			MediaVo media = (MediaVo)mediaDao.getMediaById(mediaId);
			mediaEntityRelaVo.setMedia(media);
		}
		return list;

	}

	/**
	 * 查询关系
	 * @param entityId
	 * @param mediaId
	 * @param entity
	 * @return
	 */
	public MediaEntityRelaVo getMediaEntityByEntityIdAndMediaId(long entityId, long mediaId, Entity entity) {
		MediaEntityRela mediaEntityRela = new MediaEntityRela();
		mediaEntityRela.setMediaId(mediaId);
		mediaEntityRela.setEntityId(entityId);
		mediaEntityRela.setEntity(entity);
		return mediaEntityRelaDao.getMediaEntityByEntityIdAndMediaId(mediaEntityRela);
	}

	public void updateSort(long relaId, int sort) {
		MediaEntityRela mediaEntityRela = new MediaEntityRela();
		mediaEntityRela.setRelaId(relaId);
		mediaEntityRela.setSort(sort);
		mediaEntityRelaDao.updateSort(mediaEntityRela);
	}

}
