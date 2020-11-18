/*
*
* ProjectStageInfo.java
*                    中证技术公司
* @date 2020-03-10
*/
package com.company.projectstageinfo.model;

import com.company.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value="项目阶段信息对象",description="项目阶段信息表(STAGEINFO)")
public class ProjectStageInfo extends BaseModel implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty(value="项目阶段",name="id")
    private String id;
    /**
     * 项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="projectstage")
    private String projectstage;

    /**
     * 项目类型
     */
    @ApiModelProperty(value="项目类型",name="projecttype")
    private String projecttype;

    /**
     * 阶段名称
     */
    @ApiModelProperty(value="阶段名称",name="stagename")
    private String stagename;

    /**
     * 项目类型名称
     */
    @ApiModelProperty(value="项目类型名称",name="typename")
    private String typename;

    /**
     * stageinfo
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype == null ? null : projecttype.trim();
    }

    public String getProjectstage() {
        return projectstage;
    }

    public void setProjectstage(String projectstage) {
        this.projectstage = projectstage == null ? null : projectstage.trim();
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename == null ? null : stagename.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projecttype=").append(projecttype);
        sb.append(", projectstage=").append(projectstage);
        sb.append(", stagename=").append(stagename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-05-02
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
        ProjectStageInfo other = (ProjectStageInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
                && (this.getProjectstage() == null ? other.getProjectstage() == null : this.getProjectstage().equals(other.getProjectstage()))
                && (this.getStagename() == null ? other.getStagename() == null : this.getStagename().equals(other.getStagename()));
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getProjectstage() == null) ? 0 : getProjectstage().hashCode());
        result = prime * result + ((getStagename() == null) ? 0 : getStagename().hashCode());
        return result;
    }
}