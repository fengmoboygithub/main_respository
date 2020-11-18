package com.company.processnodeinfo.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;

public interface ProcessNodeInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {


//    /**
//     * 根据源节点和操作ID查询下一节点
//     * @param processnode
//     * @param opertype
//     * @return
//     * @throws BaseException
//     */
//    ProcessNodeInfo getNextProcessNode(String processnode, String opertype) throws BaseException;

    /**
     * 流程处理
     * @param processnode
     * @param operId
     * @param treeDag
     * @throws BaseException
     */
    String updateProcess(String projectid, String projectStage, String processnode, String operId, String userName, String userId, String treeDag, String countersignUserIds) throws BaseException;

    /**
     * 更新项目阶段
     * @param projectid
     * @param projectStage
     */
    void updateStage(String projectid, String projectStage) throws BaseException;

//    /**
//     *  保存意见信息
//     * @param opinion
//     * @param projectId
//     * @param directoryId
//     * @throws BaseException
//     */
//    void saveOpinion(String opinion, String projectId, String directoryId, String hashname) throws BaseException;
//
//
//    /**
//     * 保存全部意见信息
//     * @param projectid
//     * @param treedag
//     */
//    void saveAllOpinion(String projectid, String processnode, String operId, String treedag) throws BaseException;
}