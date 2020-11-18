/*
*
* ModularTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.ModularTab;
import com.interapi.app.bmp.model.ModularTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModularTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(ModularTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(ModularTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<ModularTab> selectByExample(ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    ModularTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") ModularTab record, @Param("example") ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") ModularTab record, @Param("example") ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(ModularTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(ModularTab record);
}