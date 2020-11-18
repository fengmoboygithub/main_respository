package com.company.manuscriptinfo.dao;

import com.company.base.dao.IBaseDao;
import com.company.manuscriptinfo.model.ManuscriptInfo;
import com.company.manuscriptinfo.model.ManuscriptInfoExample;

import java.util.Map;

public interface ManuscriptInfoMapper extends IBaseDao<ManuscriptInfo, ManuscriptInfoExample>{

    /**
     * 批量更新适用性
     * @param map
     */
    void batchUpdateIsapp(Map<String, Object> map);
}