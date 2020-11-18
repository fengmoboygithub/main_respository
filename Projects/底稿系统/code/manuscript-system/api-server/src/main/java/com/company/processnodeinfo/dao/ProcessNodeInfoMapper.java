package com.company.processnodeinfo.dao;

import com.company.base.dao.IBaseDao;
import com.company.processnodeinfo.model.ProcessNodeInfo;
import com.company.processnodeinfo.model.ProcessNodeInfoExample;
import com.company.projectinfo.model.ProjectInfo;

import java.util.Map;

public interface ProcessNodeInfoMapper extends IBaseDao<ProcessNodeInfo, ProcessNodeInfoExample>{

    ProcessNodeInfo getNextProcessNode(Map<String,Object> map);

    /**
     * 查询当前阶段流程的最大节点
     * @param info
     * @return
     */
    ProcessNodeInfo selectMaxProcessnodeByStage(ProjectInfo info);
}