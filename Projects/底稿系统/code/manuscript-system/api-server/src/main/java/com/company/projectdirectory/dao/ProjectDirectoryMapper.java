package com.company.projectdirectory.dao;

import com.company.base.dao.IBaseDao;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.model.ProjectDirectoryExample;

import java.util.List;
import java.util.Map;

public interface ProjectDirectoryMapper extends IBaseDao<ProjectDirectory, ProjectDirectoryExample>{

    List<ProjectDirectory> getSiblingDirectoryProcessnode(Map<String, Object> paramMap);

    int batchUpdateByPrimaryKey(Map<String,Object> map);

    /**
     * 获取该目录全部父目录
     * @param paramMap
     * @return
     */
    List<ProjectDirectory> getAllParentDirectoryById(Map<String, Object> paramMap);

    /**
     * 批量修改适用性
     * @param map
     */
    void batchUpdateIsapp(Map<String, Object> map);

    /**
     * 	新增不为空的字段
     */
    int insertSelectiveForMe(ProjectDirectory record);

    /**
     * 不符合条件的目录数量
     * @param map
     * @return
     */
    int countIneligible(Map<String, Object> map);

    /**
     * 查询全部目录
     * @param map
     * @return
     */
    List<ProjectDirectory> selectAllDirectory(Map<String, Object> map);

    /**
     * 会签节点批量更新搭配47
     * @param map
     */
    void updateCountersignProcessnodeTo47(Map<String, Object> map);

    /**
     * 根据目录id查询项目目录信息
     * @param mapTemp
     * @return
     */
    List<ProjectDirectory> selectAllDirectoryById(Map<String, Object> mapTemp);


    void batchInsertSelective(List list);
}