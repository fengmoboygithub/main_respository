/*
*
* UserPostRelaMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.UserPostRela;
import com.interapi.app.bmp.model.UserPostRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPostRelaMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(UserPostRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(UserPostRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(UserPostRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(UserPostRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<UserPostRela> selectByExample(UserPostRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    UserPostRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") UserPostRela record, @Param("example") UserPostRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") UserPostRela record, @Param("example") UserPostRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(UserPostRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(UserPostRela record);
}