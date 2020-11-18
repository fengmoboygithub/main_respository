/*
*
* AuthorityTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.bmp.model.AuthorityTab;
import com.interapi.app.bmp.model.AuthorityTabExample;

public interface AuthorityTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(AuthorityTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(AuthorityTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(AuthorityTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(AuthorityTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<AuthorityTab> selectByExample(AuthorityTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    AuthorityTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") AuthorityTab record, @Param("example") AuthorityTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") AuthorityTab record, @Param("example") AuthorityTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(AuthorityTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(AuthorityTab record);
    
    /**
     * 通过用户ID获取权限列表
     * @param id
     * @return
     */
    List<AuthorityTab> getAuthorityTabListByUserId(@Param("id") Long id);
}