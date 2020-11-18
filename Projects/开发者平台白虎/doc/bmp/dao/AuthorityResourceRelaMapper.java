/*
*
* AuthorityResourceRelaMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.AuthorityResourceRela;
import com.interapi.app.bmp.model.AuthorityResourceRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorityResourceRelaMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(AuthorityResourceRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(AuthorityResourceRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(AuthorityResourceRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(AuthorityResourceRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<AuthorityResourceRela> selectByExample(AuthorityResourceRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    AuthorityResourceRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") AuthorityResourceRela record, @Param("example") AuthorityResourceRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") AuthorityResourceRela record, @Param("example") AuthorityResourceRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(AuthorityResourceRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(AuthorityResourceRela record);
}