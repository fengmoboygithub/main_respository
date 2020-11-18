package com.company.basedirectory.dao;

import com.company.base.dao.IBaseDao;
import com.company.basedirectory.model.BaseDirectory;
import com.company.basedirectory.model.BaseDirectoryExample;

import java.util.List;

public interface BaseDirectoryMapper extends IBaseDao<BaseDirectory, BaseDirectoryExample>{

    void batchInsertSelective(List list);
}