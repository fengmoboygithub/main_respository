/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.constant.MediaConstant.Type;
import com.zzjs.cms.constant.MediaEntityConstant.Entity;
import com.zzjs.cms.entity.Media;
import com.zzjs.cms.entity.vo.MediaEntityRelaVo;
import com.zzjs.cms.entity.vo.MediaVo;

@Repository
public interface MediaDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * @param att
	 * @return
	 */
	public int addMedia(Media att);

	// ///////////////////////////////
	// ///// 删除 ////////
	// ///////////////////////////////

	/**
	 * @param mediaId
	 * @return
	 */
	public int deleteMedia(@Param("mediaId") long mediaId);

	// ///////////////////////////////
	// ///// 修改////////
	// ///////////////////////////////

	public int updateLinkByMediaId(@Param("mediaId") long mediaId,
			@Param("link") String link);

	public int updateNameByMediaId(@Param("mediaId") long mediaId,
			@Param("name") String name);

	// ///////////////////////////////
	// ///// 查询////////
	// ///////////////////////////////

	/**
	 * @param mediaId
	 * @return
	 */
	public Media getMediaById(@Param("mediaId") long mediaId);
	
	/**
	 * 通过站点查询资源文件列表
	 * @param siteId
	 * @param kind
	 * @param type
	 * @return
	 */
	public List<MediaVo> getMediaListBySiteId(@Param("siteId") long siteId,
			@Param("entity") Entity entity, @Param("type") Type type);
	
	/**
	 * 所有资源文件列表
	 * @param rows
	 * @return
	 */
	public List<MediaVo> getMediaListAll(@Param("offset") int offset, @Param("rows")int rows);

}
