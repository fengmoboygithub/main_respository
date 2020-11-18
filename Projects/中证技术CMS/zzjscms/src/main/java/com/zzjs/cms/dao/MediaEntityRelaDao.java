/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.constant.MediaEntityConstant.Entity;
import com.zzjs.cms.entity.MediaEntityRela;
import com.zzjs.cms.entity.vo.MediaEntityRelaVo;

@Repository
public interface MediaEntityRelaDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * @param mediaEntityRela
	 * @return
	 */
	public int addMediaEntityRela(MediaEntityRela mediaEntityRela);

	// ///////////////////////////////
	// ///// 删除 ////////
	// ///////////////////////////////

	/**
	 * @param mediaId
	 * @return
	 */
	public int deleteMediaEntityRela(long relaId);
	
	/**
	 * @param mediaId
	 * @return
	 */
	public int deleteMediaEntityRelaByMediaId(long mediaId);

	// ///////////////////////////////
	// ///// 修改////////
	// ///////////////////////////////
	
	/**
	 * @return
	 */
	public int updateSort(MediaEntityRela mediaEntityRela);
	
	// ///////////////////////////////
	// ///// 查询////////
	// ///////////////////////////////

	/**
	 * 通过实体ID和类型查询资源文件列表
	 * @param entityId
	 * @param entity
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<MediaEntityRelaVo> getMediaListByEntityId(@Param("entityId") long entityId,
			@Param("entity") Entity entity,
			@Param("offset") int offset, @Param("rows") int rows);

	public MediaEntityRelaVo getMediaEntityByEntityIdAndMediaId(MediaEntityRela mediaEntityRela);

}
