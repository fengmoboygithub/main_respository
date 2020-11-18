package com.company.directoryopinion.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;

public interface DirectoryOpinionService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {

    /**
     *  保存意见信息
     * @param opinion
     * @param projectId
     * @param directoryId
     * @throws BaseException
     */
    void saveOpinion(String opinion, String projectId, String directoryId, String userName, String userId,  String hashname, String opinionType) throws BaseException;


    /**
     * 保存全部意见信息
     * @param projectid
     * @param treedag
     */
    void saveAllOpinion(String projectid, String processnode, String operId, String userName, String userId,  String treedag, String opinionType) throws BaseException;

    /**
     * 根据参数获取意见详情
     * @param directoryOpinion
     * @return
     */
    T getDirectoryOpinion(T directoryOpinion);
}