/*
*
* UserRoleRelaMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.UserRoleRela;
import com.interapi.app.bmp.model.UserRoleRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelaMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(UserRoleRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(UserRoleRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<UserRoleRela> selectByExample(UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    UserRoleRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(UserRoleRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(UserRoleRela record);
}