/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.constant.FolderConstant;
import com.zzjs.cms.constant.FolderConstant.status;
import com.zzjs.cms.entity.Folder;
import com.zzjs.cms.entity.vo.FolderVo;

/**
 * 目录服务
 * 
 * @author yangyanchao
 * 
 */

@Repository
public interface FolderDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////
	/**
	 * 增加目录
	 * 
	 * @return Integer
	 */
	public int addFolder(Folder folder);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////
	/**
	 * 删除目录
	 * 
	 * @param folder
	 * @return boolean
	 */
	public boolean deleteFolder(@Param("folderId") long folderId);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * @param folderId
	 * @param name
	 * @param ename
	 * @param content
	 * @param status
	 */
	public void updateFolderById(@Param("folderId") long folderId,
			@Param("name") String name, @Param("ename") String ename,
			@Param("status") FolderConstant.status status);

	public int updateSort(@Param("folderId") long folderId,
			@Param("sort") int sort);

	// ///////////////////////////////
	// ///// 查询 ////////
	// ///////////////////////////////
	/**
	 * 得到目录
	 * 
	 * @param folderId
	 * @return Folder
	 */
	public FolderVo getFolderById(@Param("folderId") long folderId);
	
	/**
	 * 得到站点根目录
	 * @param folderId
	 * @return
	 */
	public FolderVo getRootFolderBySiteId(@Param("siteId") long siteId);

	/**
	 * 得到所有子目录
	 * 
	 * @param fatherId
	 * @return List<FolderVo>
	 */
	public List<FolderVo> getFolderListByFatherId(
			@Param("siteId") long siteId,
			@Param("fatherId") long fatherId,
			@Param("status") FolderConstant.status status);

	/**
	 * 通过ename和fatherId获得指定目录
	 * 
	 * @param ename
	 * @param fatherId
	 * @return
	 */
	public Folder getFolderByEname(@Param("ename") String ename,@Param("fatherId") long fatherId);

	/**
	 * @param folderId
	 * @param status
	 */
	public void updateStatus(@Param("folderId") long folderId,
			@Param("status") status status);

	public int updatePath(@Param("folderId") long folderId,
			@Param("path") String path);

	public List<FolderVo> getAllFolderList(@Param("siteId") long siteId);

}
