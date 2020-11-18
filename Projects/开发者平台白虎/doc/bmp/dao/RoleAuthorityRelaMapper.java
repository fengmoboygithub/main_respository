/*
*
* RoleAuthorityRelaMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.RoleAuthorityRela;
import com.interapi.app.bmp.model.RoleAuthorityRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAuthorityRelaMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(RoleAuthorityRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(RoleAuthorityRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(RoleAuthorityRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(RoleAuthorityRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<RoleAuthorityRela> selectByExample(RoleAuthorityRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    RoleAuthorityRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") RoleAuthorityRela record, @Param("example") RoleAuthorityRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") RoleAuthorityRela record, @Param("example") RoleAuthorityRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(RoleAuthorityRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(RoleAuthorityRela record);
}