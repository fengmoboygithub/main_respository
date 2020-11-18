/*
*
* ResourceTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.ResourceTabExample;

public interface ResourceTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(ResourceTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(ResourceTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<ResourceTab> selectByExample(ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    ResourceTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") ResourceTab record, @Param("example") ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") ResourceTab record, @Param("example") ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(ResourceTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(ResourceTab record);
    
    /**
     * 通过用户ID获取接口资源列表
     * @param id
     * @return
     */
    List<ResourceTab> getResourceTabListByUserId(@Param("id") Long id);
}