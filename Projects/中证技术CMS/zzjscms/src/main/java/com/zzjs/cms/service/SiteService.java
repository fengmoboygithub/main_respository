/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	中证技术股份有限公司 版权所有
 *	http://www.otc-tech.cn/
 */

package com.zzjs.cms.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzjs.cms.constant.ConfigConstant;
import com.zzjs.cms.constant.FolderConstant;
import com.zzjs.cms.constant.MediaEntityConstant.Entity;
import com.zzjs.cms.constant.SystemConstant;
import com.zzjs.cms.dao.SiteDao;
import com.zzjs.cms.entity.Site;
import com.zzjs.cms.entity.vo.AdminSiteRelaVo;
import com.zzjs.cms.entity.vo.FileInfoVo;
import com.zzjs.cms.entity.vo.FileinfoMediaRelaVo;
import com.zzjs.cms.entity.vo.FolderVo;
import com.zzjs.cms.entity.vo.MediaEntityRelaVo;
import com.zzjs.cms.entity.vo.MediaVo;
import com.zzjs.cms.entity.vo.PageVo;
import com.zzjs.cms.entity.vo.SiteVo;
import com.zzjs.cms.exception.AuthException;
import com.zzjs.cms.exception.BaseException;
import com.zzjs.cms.exception.FileInfoNotFoundException;
import com.zzjs.cms.exception.FolderNotFoundException;
import com.zzjs.cms.util.SSUtils;

/**
 * 站点
 * 
 * @author yangyanchao
 * 
 */
@Service
public class SiteService {
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private SiteDao siteDao;
	
	@Autowired
	private AdminSiteService adminSiteService;
	
	@Autowired
	private FolderService folderService;
	
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private MediaEntityRelaService mediaEntityRelaService;
	
	@Autowired
	private FileInfoService fileInfoService;
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private MediaService attachmentService;
	
	@Autowired
	private FileinfoMediaService fileinfoMediaService;
	
	@Autowired
	private ComponentInstanceTabService componentInstanceTabService;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 添加站点和用户站点关系数据
	 * @param adminId
	 * @param siteName
	 * @param siteAddress
	 * @return Site
	 */
	public Site addSite(long adminId, String siteName, String siteEname, String siteAddress)
			throws FolderNotFoundException {
		Date now = new Date();
		Site site = new Site();
		site.setSiteName(siteName);
		site.setSiteEname(siteEname);
		site.setSiteAddress(siteAddress);
		site.setCreateTime(now);
		site.setCreaterAdminId(adminId);
		//添加站点数据
		siteDao.addSite(site);
		long siteId = site.getSiteId();
		//添加用户站点关系
		adminSiteService.addAdminSite(adminId, siteId);
		//添加目录 站点根目录
		folderService.addFolder(siteId, 0, siteName+"-根目录", siteEname+"-root", FolderConstant.status.display);
		return site;
	}

	// ///////////////////////////////
	// ///// 刪除 ////////
	// ///////////////////////////////

	/**
	 * 删除站点
	 * 
	 * @param siteId
	 * @return Integer
	 */
	public int deleteSite(long siteId) {
		adminSiteService.deleteAdminSiteBySiteId(siteId);
		return siteDao.deleteSite(siteId);
	}

	// ///////////////////////////////
	// ///// 修改 ////////
	// ///////////////////////////////

	/**
	 * 修改站点信息
	 * 
	 * @param siteId
	 * @param siteName
	 * @param siteAddress
	 * @param checkStatus
	 * @throws AuthException
	 */

	public Site updateSiteBySiteId(long siteId, String siteName, String siteEname, String siteAddress)
			throws FolderNotFoundException {
		Date now = new Date();
		Site site = new Site();
		site.setSiteId(siteId);
		site.setSiteName(siteName);
		site.setSiteEname(siteEname);
		site.setSiteAddress(siteAddress);
		site.setCreateTime(now);
		site.setUpdateTime(now);
		//更新站点
		siteDao.updateSiteBySiteId(site);
		//得到站点根目录
		FolderVo folder = folderService.getRootFolderBySiteId(siteId);
		//更新站点根目录
		folderService.updateFolderById(folder.getFolderId(), siteName+"-根目录", siteEname+"-root", folder.getStatus());
		return site;
	}
	
	
	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////


	/**
	 * 通过Id获得指定站点信息
	 */
	public SiteVo getSiteById(long siteId) {
		return siteDao.getSiteById(siteId);
	}
	
	/**
	 * 获得所有站点数据
	 * 
	 * @param offset
	 * @param rows
	 * @return List<Site>
	 */
	public List<SiteVo> getAllSiteList() {
		return siteDao.getAllSiteList();
	}
	/**
	 * 获得所有站点的分页数据
	 * 
	 * @param offset
	 * @param rows
	 * @return List<Site>
	 */
	public List<SiteVo> getAllList(long offset, long rows) {
		return siteDao.getAllList(offset, rows);
	}

	/**
	 * 获得所有站点的数量
	 * 
	 * @return Integer
	 */
	public int getAllListCount() {
		return siteDao.getAllListCount();
	}

	/**
	 * 获得所有站点的分页
	 * 
	 * @param Integer
	 * @return PageVo<Site>
	 */
	public PageVo<SiteVo> getAllListPage(int pageNum) {
		PageVo<SiteVo> pageVo = new PageVo<SiteVo>(pageNum);
		pageVo.setRows(configService.getIntKey(ConfigConstant.ZZJS_CMS_ROWS));
		List<SiteVo> list = this.getAllList(pageVo.getOffset(),
				pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getAllListCount());
		pageVo.getPageNumHtml();
		return pageVo;
	}

	public List<SiteVo> getAllSiteList(long adminId) {
		List<SiteVo> allList =  this.getAllSiteList();
		for(SiteVo site:allList){
			AdminSiteRelaVo adminSiteRelaVo = adminSiteService.getAdminSiteById(adminId, site.getSiteId());
			if(adminSiteRelaVo == null){
				site.setOwner("no");
			} else {
				site.setOwner("yes");
			}
		}
		return allList;
	}
	
	
	/**
	 * 通过adminId 获取该adminId下所有站点的数量
	 * 
	 * @return Integer
	 */
	public int getSiteListCountByAdminId(long adminId) {
		return siteDao.getSiteListCountByAdminId(adminId);
	}
	
	/**
	 * 通过adminId 获取该adminId下 所有站点数据
	 * 
	 * @param offset
	 * @param rows
	 * @param adminId
	 * @return List<Site>
	 */
	public List<SiteVo> getSiteListByAdminId(long offset, long rows, long adminId) {
		return siteDao.getSiteListByAdminId(offset, rows, adminId);
	}
	
	/**
	 * 通过adminId 获取该adminId下所有站点的分页
	 * @param Integer
	 * @return PageVo<Site>
	 */
	public PageVo<SiteVo> getSiteListPageByAdminId(int pageNum, long adminId) {
		PageVo<SiteVo> pageVo = new PageVo<SiteVo>(pageNum);
		pageVo.getArgs().put("adminId", adminId+"");
		pageVo.setRows(configService.getIntKey(ConfigConstant.ZZJS_CMS_ROWS));
		List<SiteVo> list = this.getSiteListByAdminId(pageVo.getOffset(),
				pageVo.getRows(), adminId);
		pageVo.setList(list);
		pageVo.setCount(this.getSiteListCountByAdminId(adminId));
		pageVo.getPageNumHtml();
		return pageVo;
	}

	/**
	 * 站点导出
	 * @param siteId
	 * @return
	 * @throws FolderNotFoundException 
	 * @throws BaseException 
	 * @throws IOException 
	 */
	public boolean export(long siteId) throws FolderNotFoundException, BaseException, FileInfoNotFoundException {
		SiteVo siteVo = siteDao.getSiteById(siteId);
		String siteEname = siteVo.getSiteEname();
		String siteAddress = siteVo.getSiteAddress();
		//服务模式
		String model = configService.getStringByKey(ConfigConstant.ZZJS_CMS_MODEL);
		//资源项目真实地址
		String outputDir = configService.getStringByKey(ConfigConstant.ZZJS_CMS_SOURCE_REAL_ADDRESS+model);
		//通过站点ID得到目录列表
		List<FolderVo> folderList = folderService.getAllFolderList(siteId);
		for(FolderVo folder : folderList){
			//创建目录
			File folderFile = new File(outputDir + siteEname + "/" + folder.getPathEname());
			if (!folderFile.exists()) {
				folderFile.mkdirs();
			}
			long folderId = folder.getFolderId();
			//查询目录所属的资源文件
			List<MediaEntityRelaVo> attachmentList = mediaEntityRelaService.getMediaListByEntityId(
					folderId, Entity.folder, 500);
			for(MediaEntityRelaVo mrv : attachmentList){
				MediaVo media = mrv.getMedia();
				//真实资源文件
				File uploadFile = new File(SystemConstant.ZZJS_CMS_ROOT + "/" + media.getPath());
				//输出资源文件
				File destFile = new File(folderFile, media.getName());
				try {
					FileUtils.copyFile(uploadFile, destFile);
				} catch (IOException e) {
					logger.info("文件复制失败",e.fillInStackTrace());
					return false;
				}
			}
			//查询目录所属的页面文件
			List<FileInfoVo> fileInfoList = fileInfoService.getFileInfoListBySiteIdAndFolderId(siteId, folderId, 0, 100);
			for(FileInfoVo fileInfo : fileInfoList){
				long fileId = fileInfo.getFileId();
				//通过站点Id得到所有资源列表 打上是否属于该文件的标识
				List<MediaVo> mediaAll = attachmentService.getMediaListAllBySiteId(siteId, fileId);
				//通过文件ID得到资源列表
				List<FileinfoMediaRelaVo> mediaFileList = fileinfoMediaService.getFileinfoMediaListByFileId(fileId, mediaAll);
				File resultFile = new File(folderFile, fileInfo.getEname()+"."+fileInfo.getFileType().name());
				//通过文件ID得到js脚本
				Map<String,String> map = componentInstanceTabService.selectAllCodeByPageId(fileId);
				String sourceCode = SSUtils.toHTML(fileInfo.getSourceCode());
				Map<String,Object> data = new HashMap<String, Object>();
				data.put("pageInfo", fileInfo);
				data.put("sourceCode", sourceCode);
				data.put("outputPath", siteAddress);
				data.put("mediaFileList", mediaFileList);
				data.put("pageAllCode", SSUtils.decodeByMe(map.get("jsCode")));
				templateService.staticTemplate(resultFile, data);
			}
		}
		return true;
	}

}
