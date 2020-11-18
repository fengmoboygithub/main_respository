/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zzjs.cms.entity.FileInfo;
import com.zzjs.cms.entity.vo.FileInfoVo;

/**
 * 文件服务
 * 
 * @author yangyanchao
 * 
 */
@Repository
public interface FileInfoDao {

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加文件
	 * 
	 * @return Integer
	 */
	public int addFileInfo(FileInfo fileInfo);

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除文件
	 * 
	 * @return boolean
	 */
	public boolean deleteFileInfoById(@Param("fileId") long fileId);

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改文件
	 * 
	 * @param fileInfo
	 * @return Integer
	 */
	public int updateFileInfo(FileInfo fileInfo);

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 */
	public FileInfoVo getFileInfoById(@Param("fileId") long fileId);

	/**
	 * 得到目录的文件的列表
	 * 
	 * @param foderId
	 * @return List<FileVo>
	 */
	public List<FileInfoVo> getFileInfoListOfDisplayByPath(
			@Param("path") String path, @Param("offset") long offset,
			@Param("rows") long rows);

	/**
	 * 得到目录的所有文件的数量
	 * 
	 * @param foderId
	 * @return Integer
	 */
	public int getFileInfoCountOfDisplayByPath(@Param("path") String path);

	/**
	 * 得到某种显示的文件的列表
	 * 
	 * @param foderId
	 * @return List<FileVo>
	 */
	public List<FileInfoVo> getFileInfoListBySiteIdAndPath(
			@Param("path") String path,@Param("siteId") long siteId,
			@Param("offset") long offset, @Param("rows") long rows);

	/**
	 * @param firstFolderId
	 * @param secondFolderId
	 * @param thirdFolderId
	 * @param fourthFolderId
	 * @return
	 */
	public int getFileInfoCountBySiteIdAndPath(
			@Param("path") String path,@Param("siteId") long siteId);

	/**
	 * @param path
	 * @return
	 */
	public int getFileInfoCountByFolderId(@Param("folderId") long folderId);

}
