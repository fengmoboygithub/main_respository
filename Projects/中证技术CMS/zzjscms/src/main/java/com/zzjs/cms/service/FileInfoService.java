/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zzjs.cms.constant.ConfigConstant;
import com.zzjs.cms.constant.FileInfoConstant;
import com.zzjs.cms.dao.ComponentInstanceTabDao;
import com.zzjs.cms.dao.DataJsonInstanceDao;
import com.zzjs.cms.dao.FileInfoDao;
import com.zzjs.cms.dao.FileinfoMediaRelaDao;
import com.zzjs.cms.entity.ComponentInstanceTab;
import com.zzjs.cms.entity.FileInfo;
import com.zzjs.cms.entity.Folder;
import com.zzjs.cms.entity.vo.FileInfoVo;
import com.zzjs.cms.entity.vo.FolderVo;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.exception.FolderNotFoundException;
import com.zzjs.cms.exception.UploadException;

/**
 * 
 * 文件服务
 * 
 * @author yangyanchao
 * 
 */
@Service
public class FileInfoService {

	@Autowired
	private FileInfoDao fileInfoDao;
	
	@Autowired
	private FileinfoMediaRelaDao fileinfoMediaRelaDao;
	
	@Autowired
	private ComponentInstanceTabDao componentInstanceTabDao;
	
	@Autowired
	private DataJsonInstanceDao dataJsonInstanceDao;

	@Autowired
	private FolderService folderService;
	
	@Autowired
	private ConfigService configService;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * @param folderId
	 * @param adminId
	 * @param title
	 * @param summary
	 * @param status
	 * @param content
	 * @param file
	 * @param createTime
	 * @return
	 * @throws FolderNotFoundException
	 * @throws UploadException
	 * @throws IOException
	 */
	@CacheEvict(value = "fileInfo", allEntries = true)
	public FileInfo addFileInfo(long siteId, long folderId, String ename, String name,
			FileInfoConstant.Status status, String createTime)
			throws FolderNotFoundException, UploadException,
			IOException {
		FolderVo folder = folderService.getFolderById(folderId);
		FileInfo fileInfo = new FileInfo();
		Date now = new Date();
		fileInfo.setSiteId(siteId);
		fileInfo.setFolderId(folder.getFolderId());
		fileInfo.setPath(folder.getPath());
		fileInfo.setEname(ename);
		fileInfo.setName(name);
		fileInfo.setStatus(status);
		if (StringUtils.isBlank(createTime)) {
			fileInfo.setCreateTime(now);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(createTime);
			} catch (ParseException e) {
				date = now;
			}
			fileInfo.setCreateTime(date);
		}
		fileInfo.setUpdateTime(now);
		fileInfoDao.addFileInfo(fileInfo);
		return fileInfoDao.getFileInfoById(fileInfo.getFileId());
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除文件
	 * 
	 * @param fileId
	 * @return boolean
	 */
	@CacheEvict(value = "fileInfo", allEntries = true)
	public boolean deleteFileInfoById(long fileId) throws BaseException{
		boolean flag = true;
		try{
			//删除数据源实例表数据
			dataJsonInstanceDao.deleteByEntityByFileId(fileId);
			//删除组件实例表数据
			ComponentInstanceTab cit = new ComponentInstanceTab();
			cit.setFileId(fileId);
			componentInstanceTabDao.deleteByEntity(cit);
			//删除文件与资源文件关系表数据
			fileinfoMediaRelaDao.deleteFileinfoMediaByFileId(fileId);
			//删除文件与资源文件关系表数据
			fileInfoDao.deleteFileInfoById(fileId);
		} catch(Exception e){
			e.fillInStackTrace();
			flag = false;
			throw new BaseException("删除站点文件失败--"+fileId);
		}
		return flag;
		
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改文件
	 * 
	 * @param fileId
	 * @param folderId
	 * @param adminId
	 * @param picture
	 * @param name
	 * @param content
	 * @param type
	 * @param status
	 * @return
	 * @throws UploadException
	 * @throws ParseException
	 * @throws IOException
	 * @throws FolderNotFoundException 
	 */
	@CacheEvict(value = "fileInfo", allEntries = true)
	public FileInfo updateFileInfo(long fileId, long folderId,
			String ename, String name, String sourceCode, String htmlCodeByEdit, 
			FileInfoConstant.Status status,
			String time) throws UploadException, IOException, FolderNotFoundException {
		Date now = new Date();
		FileInfo fileInfo = fileInfoDao.getFileInfoById(fileId);
		FolderVo folder = folderService.getFolderById(folderId);
		fileInfo.setFolderId(folder.getFolderId());
		fileInfo.setPath(folder.getPath());
		fileInfo.setEname(ename);
		fileInfo.setName(name);
		fileInfo.setSourceCode(sourceCode);
		fileInfo.setHtmlCodeByEdit(htmlCodeByEdit);
		fileInfo.setStatus(status);
		fileInfo.setFileVersion(fileInfo.getFileVersion()+1);
		if (StringUtils.isBlank(time)) {
			fileInfo.setCreateTime(now);
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date date;
			try {
				date = sdf.parse(time);
			} catch (ParseException e) {
				date = now;
			}
			fileInfo.setCreateTime(date);
		}
		fileInfoDao.updateFileInfo(fileInfo);
		return fileInfo;
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 得到文件
	 * 
	 * @param fileId
	 * @return File
	 * @throws FileInfoNotFoundException
	 */
	@Cacheable(value = "fileInfo", key = "'getFileInfoById_'+#fileId")
	public FileInfoVo getFileInfoById(long fileId)
			throws FileInfoNotFoundException {
		FileInfoVo fileInfoVo = fileInfoDao.getFileInfoById(fileId);
		if (fileInfoVo == null) {
			throw new FileInfoNotFoundException(fileId
					+ " 文件，不存在");
		} else {
			return fileInfoVo;
		}
	}

	/**
	 * 得到目录的显示的文件分页
	 * 
	 * @param folderId
	 * @return pageVo
	 * @throws FolderNotFoundException
	 */
	@Cacheable(value = "fileInfo")
	public PageVo<FileInfoVo> getFileInfoPageByFolderId(long folderId,
			int pageNum, int rows) throws FolderNotFoundException {
		PageVo<FileInfoVo> pageVo = new PageVo<FileInfoVo>(pageNum);
		FolderVo folder = folderService.getFolderById(folderId);
		pageVo.getArgs().put("folderId", folderId+"");
		pageVo.setRows(rows);
		pageVo.setCount(fileInfoDao
				.getFileInfoCountOfDisplayByPath(folder
						.getPath()));
		List<FileInfoVo> fileInfolist = fileInfoDao
				.getFileInfoListOfDisplayByPath(
						folder.getPath(),
						pageVo.getOffset(),
						pageVo.getRows());
		for (FileInfoVo artcle : fileInfolist) {
			FolderVo artcleFolder = folderService
					.getFolderById(artcle.getFolderId());
			artcle.setFolder(artcleFolder);
		}
		pageVo.setList(fileInfolist);
		pageVo.getPageNumHtml();
		return pageVo;
	}

	/**
	 * 获取某种文件的分页
	 * 
	 * @param type
	 * @param status
	 * @param pageNum
	 * @return PageVo<File>
	 * @throws FolderNotFoundException
	 * 
	 */
	public PageVo<FileInfoVo> getFileInfoPageByFolderId(long siteId,
			long folderId, int pageNum)
			throws FolderNotFoundException {
		PageVo<FileInfoVo> pageVo = new PageVo<FileInfoVo>(pageNum);
		pageVo.getArgs().put("siteId", siteId+"");
		pageVo.getArgs().put("folderId", folderId+"");
		pageVo.setRows(configService.getIntKey(ConfigConstant.ZZJS_CMS_ROWS));
		List<FileInfoVo> list = new ArrayList<FileInfoVo>();
		int count = 0;
		if (folderId == 0) {
			count = this.getFileInfoCountBySiteIdAndFolderId(siteId, 
					0);
			list = this.getFileInfoListBySiteIdAndFolderId(siteId,
					0, pageVo.getOffset(),
					pageVo.getRows());
		} else {
			list = this.getFileInfoListBySiteIdAndFolderId(siteId,
					folderId, pageVo.getOffset(),
					pageVo.getRows());
			count = this.getFileInfoCountBySiteIdAndFolderId(siteId,
					folderId);
		}
		for (FileInfoVo fileInfo : list) {
			try {
				fileInfo.setFolder(folderService
						.getFolderById(fileInfo
								.getFolderId()));
				fileInfo.setFolderPathList(folderService
						.getFolderPathListByFolderId(fileInfo
								.getFolderId()));
			} catch (FolderNotFoundException e) {
				fileInfo.setFolder(new Folder());
			}
		}
		pageVo.setList(list);
		pageVo.setCount(count);
		pageVo.getPageNumHtml();
		return pageVo;
	}

	/**
	 * @param adminId
	 * @param folderId
	 * @param offset
	 * @param rows
	 * @return
	 * @throws FolderNotFoundException
	 */
	public List<FileInfoVo> getFileInfoListBySiteIdAndFolderId(long siteId,
			long folderId,
			long offset, long rows) throws FolderNotFoundException {
		String path = "";
		if (folderId != 0) {
			Folder folder = folderService.getFolderById(folderId);
			path = folder.getPath();
		}
		List<FileInfoVo> fileInfoList = fileInfoDao
				.getFileInfoListBySiteIdAndPath(path,siteId, offset, rows);
		return fileInfoList;
	}

	/**
	 * @param adminId
	 * @param folderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	public int getFileInfoCountBySiteIdAndFolderId(long siteId,
			long folderId)
			throws FolderNotFoundException {
		String path = "";
		if (folderId != 0) {
			Folder folder = folderService.getFolderById(folderId);
			path = folder.getPath();
		}
		return fileInfoDao.getFileInfoCountBySiteIdAndPath(
				path,siteId);
	}

	/**
	 * @param folderId
	 * @return
	 * @throws FolderNotFoundException
	 */
	public int getFileInfoCountByFolderId(long folderId)
			throws FolderNotFoundException {
		return fileInfoDao.getFileInfoCountByFolderId(folderId);
	}

	/**
	 * @param path
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<FileInfoVo> getFileInfoListOfDisplayByPath(String path,
			int offset, int rows) {
		List<FileInfoVo> fileInfolist = fileInfoDao
				.getFileInfoListOfDisplayByPath(path, offset,
						rows);
		return fileInfolist;
	}

}
