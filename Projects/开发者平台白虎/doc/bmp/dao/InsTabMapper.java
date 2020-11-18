/*
*
* InsTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.InsTab;
import com.interapi.app.bmp.model.InsTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(InsTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(InsTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(InsTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(InsTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<InsTab> selectByExample(InsTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    InsTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") InsTab record, @Param("example") InsTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") InsTab record, @Param("example") InsTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(InsTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(InsTab record);
}