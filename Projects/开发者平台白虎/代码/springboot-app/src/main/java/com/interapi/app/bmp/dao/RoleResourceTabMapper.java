/*
*
* RoleResourceTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.RoleResourceTab;
import com.interapi.app.bmp.model.RoleResourceTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(RoleResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(RoleResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(RoleResourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(RoleResourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<RoleResourceTab> selectByExample(RoleResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    RoleResourceTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") RoleResourceTab record, @Param("example") RoleResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") RoleResourceTab record, @Param("example") RoleResourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(RoleResourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(RoleResourceTab record);
}