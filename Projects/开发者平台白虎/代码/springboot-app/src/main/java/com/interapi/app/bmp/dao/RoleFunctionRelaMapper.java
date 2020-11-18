/*
*
* RoleFunctionRelaMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.RoleFunctionRela;
import com.interapi.app.bmp.model.RoleFunctionRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleFunctionRelaMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(RoleFunctionRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(RoleFunctionRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(RoleFunctionRela record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(RoleFunctionRela record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<RoleFunctionRela> selectByExample(RoleFunctionRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    RoleFunctionRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") RoleFunctionRela record, @Param("example") RoleFunctionRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") RoleFunctionRela record, @Param("example") RoleFunctionRelaExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(RoleFunctionRela record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(RoleFunctionRela record);
}