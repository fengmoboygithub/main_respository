/*
*
* RoleTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.RoleTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(RoleTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(RoleTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<RoleTab> selectByExample(RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    RoleTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") RoleTab record, @Param("example") RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") RoleTab record, @Param("example") RoleTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(RoleTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(RoleTab record);
    
    /**
	 * 通过用户ID获取角色列表
	 * @param id
	 * @return
	 */
	List<RoleTab> getRoleTabListByUserId(@Param("id") Long id);
}