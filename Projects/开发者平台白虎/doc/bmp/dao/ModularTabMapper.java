/*
*
* ModularTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.interapi.app.bmp.model.ModularTab;
import com.interapi.app.bmp.model.ModularTabExample;

public interface ModularTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(ModularTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(ModularTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<ModularTab> selectByExample(ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    ModularTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") ModularTab record, @Param("example") ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") ModularTab record, @Param("example") ModularTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(ModularTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(ModularTab record);
    
    /**
     * 通过用户ID获取模块列表
     * @param id
     * @return
     */
    List<ModularTab> getModularTabListByUserId(@Param("id") Long id);
}