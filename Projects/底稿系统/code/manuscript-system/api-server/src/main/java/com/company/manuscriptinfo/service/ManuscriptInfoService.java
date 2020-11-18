package com.company.manuscriptinfo.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.enums.ManuscriptInfoEsMode;
import com.company.enums.ManuscriptInfoEsVersion;
import com.company.manuscriptinfo.model.ManuscriptInfo;

import java.io.Serializable;

public interface ManuscriptInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
    /**
     * 保存底稿信息
     * @param info
     * @throws BaseException
     */
    void saveForMe(ManuscriptInfo info) throws BaseException;
    /**
     * 保存底稿信息检索
     * @param info
     * @throws BaseException
     */
    void saveForManuscriptInfoForEsRepository(ManuscriptInfo info, ManuscriptInfoEsMode mode, ManuscriptInfoEsVersion version) throws BaseException;

    /**
     * 	根据主键查询单个记录
     * @param id
     * @return
     * @throws BaseException
     */
    ManuscriptInfo getByMe(String id, String userId) throws BaseException;

    /**
     * 	更新数据
     * @param model
     * @throws BaseException
     */
    void updateByMe(ManuscriptInfo model) throws BaseException;

    /**
     * 删除底稿信息
     * @param id
     * @throws BaseException
     */
    void delForMe(String id) throws BaseException;
}