package com.company.projectstageinfo.dao;

import com.company.base.dao.IBaseDao;
import com.company.projectstageinfo.model.ProjectStageInfo;
import com.company.projectstageinfo.model.ProjectStageInfoExample;
public interface ProjectStageInfoMapper extends IBaseDao<ProjectStageInfo, ProjectStageInfoExample>{

    ProjectStageInfo getNextStageinfoByExample(ProjectStageInfoExample example);
}