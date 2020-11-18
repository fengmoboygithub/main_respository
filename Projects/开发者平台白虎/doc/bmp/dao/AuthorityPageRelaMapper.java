/*
*
* AuthorityPageRelaMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.AuthorityPageRela;
import com.interapi.app.bmp.model.AuthorityPageRelaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorityPageRelaMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(AuthorityPageRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(AuthorityPageRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(AuthorityPageRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(AuthorityPageRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<AuthorityPageRela> selectByExample(AuthorityPageRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    AuthorityPageRela selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") AuthorityPageRela record, @Param("example") AuthorityPageRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") AuthorityPageRela record, @Param("example") AuthorityPageRelaExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(AuthorityPageRela record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(AuthorityPageRela record);
}