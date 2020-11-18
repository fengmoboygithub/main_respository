/*
*
* UserTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(UserTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(UserTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(UserTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(UserTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<UserTab> selectByExample(UserTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    UserTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") UserTab record, @Param("example") UserTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") UserTab record, @Param("example") UserTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(UserTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(UserTab record);
}