package com.company.directoryopinion.dao;

import com.company.base.dao.IBaseDao;
import com.company.directoryopinion.model.DirectoryOpinion;
import com.company.directoryopinion.model.DirectoryOpinionExample;
public interface DirectoryOpinionMapper extends IBaseDao<DirectoryOpinion, DirectoryOpinionExample>{

    DirectoryOpinion getDirectoryOpinion(DirectoryOpinion directoryOpinion);
}