package com.company.directoryversion.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.directoryversion.model.DirectoryVersion;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectinfo.model.ProjectInfo;

import java.util.List;
import java.util.Map;

public interface DirectoryVersionService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    /**
     * 变更目录版本
     * @param projectId
     * @param treeDag
     * @throws BaseException
     */
    void updateVersion(String projectId, String projectStage, String treeDag) throws BaseException;


    /**
     * 初始化目录版本信息
     * @param info
     * @throws BaseException
     */
    void initDirectoryVersion(ProjectInfo info) throws BaseException;


    /**
     * 根据目录id更新目录版本信息
     * @throws BaseException
     */
    void updateDirectoryVersion(ProjectDirectory projectDirectory, String userId) throws BaseException;

    /**
     * 获取最新目录版本数据
     * @param projectId
     * @param directoryId
     * @return
     * @throws BaseException
     */
    List<DirectoryVersion> getNewDirectoryVersion(String projectId, String directoryId) throws BaseException;

    /**
     * 获取整个项目需要提交的目录版本list
     * @param projectId
     * @return
     */
    List<DirectoryVersion> viewProjectTreeDirectoryVersionList(String projectId, Map pidMap, String userId, Map hashnameMap, Map versioncompositionMa);


    /**
     * 获取最新目录版本数据
     * @param projectId
     * @param
     * @return
     * @throws BaseException
     */
    List<DirectoryVersion> test(String projectId) throws BaseException;
}