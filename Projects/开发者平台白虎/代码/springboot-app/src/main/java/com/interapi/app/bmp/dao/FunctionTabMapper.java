/*
*
* FunctionTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.FunctionTab;
import com.interapi.app.bmp.model.FunctionTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(FunctionTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(FunctionTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(FunctionTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(FunctionTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<FunctionTab> selectByExample(FunctionTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    FunctionTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") FunctionTab record, @Param("example") FunctionTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") FunctionTab record, @Param("example") FunctionTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(FunctionTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(FunctionTab record);
}