/*
*
* DataSourceTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.DataSourceTab;
import com.interapi.app.bmp.model.DataSourceTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataSourceTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(DataSourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(DataSourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(DataSourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(DataSourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<DataSourceTab> selectByExample(DataSourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    DataSourceTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") DataSourceTab record, @Param("example") DataSourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") DataSourceTab record, @Param("example") DataSourceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(DataSourceTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(DataSourceTab record);
}