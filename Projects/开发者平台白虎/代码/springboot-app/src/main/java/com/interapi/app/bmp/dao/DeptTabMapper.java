/*
*
* DeptTabMapper.java
*                    中证技术公司
* @date 2018-09-18
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.DeptTab;
import com.interapi.app.bmp.model.DeptTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptTabMapper {
    /**
     *
     * @mbg.generated 2018-09-18
     */
    long countByExample(DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByExample(DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insert(DeptTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int insertSelective(DeptTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    List<DeptTab> selectByExample(DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    DeptTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExampleSelective(@Param("record") DeptTab record, @Param("example") DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByExample(@Param("record") DeptTab record, @Param("example") DeptTabExample example);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKeySelective(DeptTab record);

    /**
     *
     * @mbg.generated 2018-09-18
     */
    int updateByPrimaryKey(DeptTab record);
}