package com.company.projectinfo.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.model.ProjectInfoExample;
import com.company.projectinfo.view.DealtInfo;
import com.github.pagehelper.PageInfo;

public interface ProjectInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    /**
     * 新增数据权限信息
     * @param info  给项目ID 赋值 info.id
     *              给角色列表字符串‘逗号分隔’ 赋值 info.roleList
     *              用户列表字符串‘逗号分隔’ 赋值 info.userId
     * @throws BaseException
     */
    void saveDataRole(ProjectInfo info) throws BaseException;

    /**
     * 保存项目信息及项目目录信息
     * @param info
     * @throws BaseException
     */
    void saveForMe(ProjectInfo info) throws BaseException;

    /**
     * 编辑项目信息及同步数据项信息
     * @param info
     * @throws BaseException
     */
    void editForMe(ProjectInfo info) throws BaseException;
    /**
     * 项目阶段改变--推进
     * @param info
     * @throws BaseException
     */
    String advance(ProjectInfo info) throws BaseException;
    /**
     * 项目阶段改变--回退
     * @param info
     * @throws BaseException
     */
    void back(ProjectInfo info) throws BaseException;
    /**
     * 	分页查询--待办信息
     * @param currentPage  起始页目
     * @param itemsPerPage 每页最多显示条目
     * @param itemsPerPage
     * @param example
     * @return
     * @throws BaseException
     */
    PageInfo<DealtInfo> getListByPageForDealt(int currentPage, int itemsPerPage, ProjectInfoExample example) throws BaseException;
}