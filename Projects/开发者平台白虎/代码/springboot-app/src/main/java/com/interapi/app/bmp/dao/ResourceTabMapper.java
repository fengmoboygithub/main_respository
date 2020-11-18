/*
*
* ResourceTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.ResourceTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(ResourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(ResourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<ResourceTab> selectByExample(ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    ResourceTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") ResourceTab record, @Param("example") ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") ResourceTab record, @Param("example") ResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(ResourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(ResourceTab record);

	/**
	 * 通过用户ID获取资源列表
	 * @param userId
	 * @return
	 */
	List<ResourceTab> getResourceTabListByUserId(Long userId);
}