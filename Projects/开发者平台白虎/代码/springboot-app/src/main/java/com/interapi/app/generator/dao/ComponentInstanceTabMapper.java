/*
*
* ComponentInstanceTabMapper.java
*                    中证技术公司
* @date 2018-09-09
*/
package com.interapi.app.generator.dao;

import com.interapi.app.generator.model.ComponentInstanceTab;
import com.interapi.app.generator.model.ComponentInstanceTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComponentInstanceTabMapper {
    /**
     *
     * @mbg.generated 2018-09-09
     */
    long countByExample(ComponentInstanceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int deleteByExample(ComponentInstanceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int insert(ComponentInstanceTab record);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int insertSelective(ComponentInstanceTab record);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    List<ComponentInstanceTab> selectByExampleWithBLOBs(ComponentInstanceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    List<ComponentInstanceTab> selectByExample(ComponentInstanceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    ComponentInstanceTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int updateByExampleSelective(@Param("record") ComponentInstanceTab record, @Param("example") ComponentInstanceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int updateByExampleWithBLOBs(@Param("record") ComponentInstanceTab record, @Param("example") ComponentInstanceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int updateByExample(@Param("record") ComponentInstanceTab record, @Param("example") ComponentInstanceTabExample example);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int updateByPrimaryKeySelective(ComponentInstanceTab record);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int updateByPrimaryKeyWithBLOBs(ComponentInstanceTab record);

    /**
     *
     * @mbg.generated 2018-09-09
     */
    int updateByPrimaryKey(ComponentInstanceTab record);
}