package com.company.personnelinfo.service;

import com.company.base.example.BaseExample;
import com.company.base.exception.BaseException;
import com.company.base.model.BaseModel;
import com.company.base.service.IBaseService;
import com.company.personnelinfo.model.PersonnelInfo;
import com.github.pagehelper.PageInfo;

public interface PersonnelInfoService<T extends BaseModel,E extends BaseExample> extends IBaseService<T, E> {
    /**
     * 	项目人员信息分页查询(从统一用户系统获取)
     * @param currentPage 当前页码
     * @param itemsPerPage 每页最大条数
     * @return 分页对象信息
     */
    PageInfo<PersonnelInfo> getListByPageForUserSys(int currentPage, int itemsPerPage) throws BaseException;
}