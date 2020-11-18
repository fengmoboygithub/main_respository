package com.company.projectinfo.dao;

import com.company.base.dao.IBaseDao;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.model.ProjectInfoExample;
import com.company.projectinfo.view.DealtInfo;

public interface ProjectInfoMapper extends IBaseDao<ProjectInfo, ProjectInfoExample>{
    /**
     * 新增项目项目操作-对最小“项目阶段”的项目，按“基础目录表”的“是否适用”填写
     * @param info
     * @return
     */
    void insertProjectDirectoryMin(ProjectInfo info);
    /**
     * 新增项目项目操作-对其他“项目阶段”项目，“是否适用”写为不适用
     * @param info
     * @return
     */
    void insertProjectDirectoryOther(ProjectInfo info);
    /**
     * 项目阶段改变-推进-更新项目信息
     * @param info
     * @return
     */
    void updateProjectInfoForAdvance(ProjectInfo info);

    /**
     * 根据项目类型与阶段值获取下个阶段值
     * @param info
     * @return
     */
    Integer selectNextStageVal(ProjectInfo info);
    /**
     * 项目阶段改变-推进-更新项目目录信息
     * @param info
     * @return
     */
    void updateProjectDirectoryForAdvance(ProjectInfo info);
    /**
     * 项目阶段改变-回退-更新项目信息
     * @param info
     * @return
     */
    void updateProjectInfoForBack(ProjectInfo info);
    /**
     * 项目阶段改变-回退-更新项目目录信息
     * @param info
     * @return
     */
    void updateProjectDirectoryForBack(ProjectInfo info);
    /**
     * 根据项目id与项目阶段查询正常项目下的最小流程状态且适用的项目目录
     * @param info
     * @return
     */
    DealtInfo selectByDealt(ProjectInfo info);

}