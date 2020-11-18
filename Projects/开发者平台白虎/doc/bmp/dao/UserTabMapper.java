/*
*
* UserTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(UserTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(UserTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(UserTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(UserTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<UserTab> selectByExample(UserTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    UserTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") UserTab record, @Param("example") UserTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") UserTab record, @Param("example") UserTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(UserTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(UserTab record);
}