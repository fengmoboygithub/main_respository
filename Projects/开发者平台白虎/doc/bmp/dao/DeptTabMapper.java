/*
*
* DeptTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.DeptTab;
import com.interapi.app.bmp.model.DeptTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(DeptTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(DeptTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<DeptTab> selectByExample(DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    DeptTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") DeptTab record, @Param("example") DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") DeptTab record, @Param("example") DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(DeptTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(DeptTab record);
}