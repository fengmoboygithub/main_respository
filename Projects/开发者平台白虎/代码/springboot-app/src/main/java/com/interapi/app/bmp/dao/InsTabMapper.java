/*
*
* InsTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.InsTab;
import com.interapi.app.bmp.model.InsTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(InsTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(InsTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(InsTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(InsTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<InsTab> selectByExample(InsTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    InsTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") InsTab record, @Param("example") InsTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") InsTab record, @Param("example") InsTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(InsTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(InsTab record);
}