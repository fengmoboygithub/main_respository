/*
*
* PageTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.bmp.model.PageTab;
import com.interapi.app.bmp.model.PageTabExample;

public interface PageTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(PageTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(PageTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(PageTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(PageTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<PageTab> selectByExample(PageTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    PageTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") PageTab record, @Param("example") PageTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") PageTab record, @Param("example") PageTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(PageTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(PageTab record);
    
    /**
     * 通过用户ID获取页面列表
     * @param id
     * @return
     */
    List<PageTab> getPageTabListByUserId(@Param("id") Long id);
}