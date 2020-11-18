package com.company.directoryversion.dao;

import com.company.base.dao.IBaseDao;
import com.company.directoryversion.model.DirectoryVersion;
import com.company.directoryversion.model.DirectoryVersionExample;

import java.util.List;

public interface DirectoryVersionMapper extends IBaseDao<DirectoryVersion, DirectoryVersionExample>{

    /**
     * 批量插入目录版本信息
     * @param dvList
     */
    void batchInsertSelective(List dvList);

    /**
     * 获取最新目录版本
     * @param example
     * @return
     */
    List<DirectoryVersion> getNewDirectoryVersion(DirectoryVersionExample example);
}