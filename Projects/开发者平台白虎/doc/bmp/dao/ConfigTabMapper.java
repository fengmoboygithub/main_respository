/*
*
* ConfigTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.ConfigTab;
import com.interapi.app.bmp.model.ConfigTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(ConfigTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(ConfigTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(ConfigTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(ConfigTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<ConfigTab> selectByExample(ConfigTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    ConfigTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") ConfigTab record, @Param("example") ConfigTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") ConfigTab record, @Param("example") ConfigTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(ConfigTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(ConfigTab record);
}