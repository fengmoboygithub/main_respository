package com.company.projectdirectory.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.directoryversion.model.DirectoryVersion;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.view.ProjectDirectoryTree;

import java.util.List;
import java.util.Map;

public interface ProjectDirectoryService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

	/**
	 * 项目目录树用于导出某时间节点的数据展示接口
	 * @param projectid 项目id
	 * @param reptDate 报送日期时间
	 * @return
	 */
	List<ProjectDirectoryTree> viewTreeForExport(String projectid, String reptDate);

	/**
	 * 项目目录树含底稿文件(适用)查询
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @param directoryid 目录id
	 * @return
	 */
	List<ProjectDirectoryTree> viewTree(String projectid, String projectStage, String directoryid, String... userId);

	/**
	 * 项目目录树含底稿文件(全部)查询
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @return
	 */
	List<ProjectDirectoryTree> viewTreeForMe(String projectid, String projectStage);

	/**
	 * 项目目录树含底稿文件(全部)查询(全部层级)
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @return
	 */
	List<ProjectDirectoryTree> viewTreeAllByProjectDirectoryAndManuscriptInfo(String projectid, String projectStage, String stage);

	/**
	 * 向上遍历目录 计算目录hash值进行更改
	 * @param projectId 项目id
	 * @param directoryId 项目目录id
	 */
	void updateProjectDirectoryHashForDeep(String projectId, String directoryId) throws BaseException;

	void updateIsapp(String projectId, String projectStage, String treeDag, String userId) throws BaseException;

	/**
	 * 项目目录树含底稿文件(全部)查询
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @param directoryid 项目目录id
	 * @return
	 */
	String writeZipFile(String projectid, String projectStage, String directoryid);

	/**
	 * 项目目录树含底稿文件(haxVal)查询
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @param directoryid 项目目录id
	 * @return
	 */
	String writeTextFile(String projectid, String projectStage, String directoryid);

	/**
	 * 获取子节点树json
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @return
	 */
	String getSonTreeJson(String projectid, String projectStage, String directoryid);

	/**
	 * 查询所有项目目录树
	 * @param projectid 项目id
	 * @return
	 */
	List<ProjectDirectoryTree> viewAllProjectDirectoryTree(String projectid);

	/**
	 * 查询所有根目录节点
	 * @param projectid 项目id
	 * @return
	 */
	List<ProjectDirectoryTree> viewRootProjectDirectoryTree(String projectid);

	/**
	 * 根据项目id和
	 * @param projectid 项目id
	 * @return
	 */
	List<DirectoryVersion> viewTreeJsonList(String projectid, String directoryid, Map hashnameMap, Map versioncompositionMap);

	/**
	 * 项目目录树含底稿文件(适用)查询(只查询下一个层级，不分阶段和适用性)
	 * @param projectid 项目id
	 * @param directoryid 目录id
	 * @return
	 */
	List<ProjectDirectoryTree> viewNextTree(String projectid, String directoryid, String userId);

	/**
	 * 会签节点批量更新搭配47
	 * @param map
	 */
	void updateCountersignProcessnodeTo47(Map<String, Object> map);

	/**
	 * 修改项目目录信息
	 * @param record
	 */
    void updateProjectDirectory(T record, String userId) throws BaseException;


	/**
	 * 新增测试项目目录
	 * @param projectId
	 */
	List<ProjectDirectory> addTestProjectDirectory(String projectId) throws BaseException;


    void uploadfiletest(String projectId,String userId) throws BaseException;

	/**
	 * 查询所有上级父目录
	 * @param projectid 项目id
	 * @param directoryid 目录id
	 * @return
	 */
	List<ProjectDirectory> viewParentTree(String projectid, String directoryid);

	List<ProjectDirectoryTree> viewAllDirectoryTree(String projectId);

}