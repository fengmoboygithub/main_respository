/*
*
* PostTabMapper.java
*                    中证技术公司
* @date 2018-10-16
*/
package com.interapi.app.bmp.dao;

import com.interapi.app.bmp.model.PostTab;
import com.interapi.app.bmp.model.PostTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostTabMapper {
    /**
     *
     * @mbg.generated 2018-10-16
     */
    long countByExample(PostTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByExample(PostTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insert(PostTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int insertSelective(PostTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    List<PostTab> selectByExample(PostTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    PostTab selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExampleSelective(@Param("record") PostTab record, @Param("example") PostTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByExample(@Param("record") PostTab record, @Param("example") PostTabExample example);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKeySelective(PostTab record);

    /**
     *
     * @mbg.generated 2018-10-16
     */
    int updateByPrimaryKey(PostTab record);
}