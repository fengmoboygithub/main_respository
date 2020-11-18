/*
*
* PostRoleRelaMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.PostRoleRela;
import com.interapi.app.bmp.model.PostRoleRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostRoleRelaMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(PostRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(PostRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(PostRoleRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(PostRoleRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<PostRoleRela> selectByExample(PostRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    PostRoleRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") PostRoleRela record, @Param("example") PostRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") PostRoleRela record, @Param("example") PostRoleRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(PostRoleRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(PostRoleRela record);
}