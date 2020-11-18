package com.company.manuscriptversion.dao;

import com.company.base.dao.IBaseDao;
import com.company.manuscriptversion.model.ManuscriptVersion;
import com.company.manuscriptversion.model.ManuscriptVersionExample;

import java.util.List;

public interface ManuscriptVersionMapper extends IBaseDao<ManuscriptVersion, ManuscriptVersionExample>{

    /**
     * 查询最新版本的信息
     * @param example
     */
    ManuscriptVersion getNewVersionInfo(ManuscriptVersionExample example);

    /**
     * 批量更新
     * @param listtemp
     */
    void updateBatch(List listtemp);
}