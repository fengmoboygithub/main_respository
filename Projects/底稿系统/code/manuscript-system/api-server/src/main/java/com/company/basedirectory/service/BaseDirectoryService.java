package com.company.basedirectory.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.projectdirectory.view.ProjectDirectoryTree;

import java.io.File;
import java.util.List;

public interface BaseDirectoryService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
    /**
     * 基础目录树含底稿文件(全部)查询
     * @param projecttype 项目类型ID
     * @param projectStage 项目阶段
     * @return
     */
    List<ProjectDirectoryTree> viewTreeForMe(String projecttype, String projectStage);

    /**
     * 递归删除基础目录信息
     * @param id 基础目录ID
     */
    void deleteForDeep(String id) throws BaseException;

    void export(File file, String projectType) throws BaseException ;
}