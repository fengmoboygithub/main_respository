/*
*
* UserRoleRelaMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.UserRoleRela;
import com.interapi.app.bmp.model.UserRoleRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelaMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(UserRoleRela record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(UserRoleRela record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<UserRoleRela> selectByExample(UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    UserRoleRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") UserRoleRela record, @Param("example") UserRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(UserRoleRela record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(UserRoleRela record);
}