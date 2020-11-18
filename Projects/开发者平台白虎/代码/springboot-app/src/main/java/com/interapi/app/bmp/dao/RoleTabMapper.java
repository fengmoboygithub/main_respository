/*
*
* RoleTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.RoleTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(RoleTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(RoleTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<RoleTab> selectByExample(RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    RoleTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") RoleTab record, @Param("example") RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") RoleTab record, @Param("example") RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(RoleTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(RoleTab record);

	/**
	 * 通过用户ID获取角色列表
	 * @param id
	 * @return
	 */
	List<RoleTab> getRoleTabListByUserId(@Param("id") Long id);
}