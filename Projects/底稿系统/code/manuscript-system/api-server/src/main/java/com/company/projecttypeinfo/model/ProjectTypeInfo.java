/*
*
* ProjectTypeInfo.java
*                    中证技术公司
* @date 2020-03-10
*/
package com.company.projecttypeinfo.model;

import com.company.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value="项目类型信息对象",description="项目类型信息表(PROJECTTYPEINFO)")
public class ProjectTypeInfo extends BaseModel implements Serializable {
    /**
     * 主键ID
     */
    @ApiModelProperty(value="主键ID",name="id")
    private String id;

    /**
     * 项目类型名称，包括承销与保荐、上市公司并购重组财务顾问、公司债券受托管理、非上市公众公司推荐、资产证券化
     */
    @ApiModelProperty(value="项目类型名称",name="typename")
    private String typename;

    /**
     * projecttypeinfo
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     *
     * @mbg.generated 2020-03-10
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typename=").append(typename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-03-10
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProjectTypeInfo other = (ProjectTypeInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypename() == null ? other.getTypename() == null : this.getTypename().equals(other.getTypename()));
    }

    /**
     *
     * @mbg.generated 2020-03-10
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypename() == null) ? 0 : getTypename().hashCode());
        return result;
    }
}