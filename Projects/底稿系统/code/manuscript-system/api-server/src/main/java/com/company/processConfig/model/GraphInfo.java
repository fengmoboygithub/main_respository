/*
*
* GraphInfo.java
*                    中证技术公司
* @date 2020-08-03
*/
package com.company.processConfig.model;

import com.company.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value="流程图像信息对象",description="流程图像信息表(GRAPHINFO)")
public class GraphInfo extends BaseModel implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="流程图像ID",name="id")
    private String id;

    /**
     * 项目类型
     */
    @ApiModelProperty(value="项目类型",name="projecttype")
    private String projecttype;

    /**
     * 项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="projectstage")
    private String projectstage;

    /**
     * 流程图像json数据
     */
    @ApiModelProperty(value="流程图像json数据",name="graphdata")
    private String graphdata;

    /**
     * graphinfo
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

    public String getGraphdata() {
        return graphdata;
    }

    public void setGraphdata(String graphdata) {
        this.graphdata = graphdata == null ? null : graphdata.trim();
    }

    /**
     *
     * @mbg.generated 2020-08-03
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
        sb.append(", graphdata=").append(graphdata);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-08-03
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
        GraphInfo other = (GraphInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
            && (this.getProjectstage() == null ? other.getProjectstage() == null : this.getProjectstage().equals(other.getProjectstage()))
            && (this.getGraphdata() == null ? other.getGraphdata() == null : this.getGraphdata().equals(other.getGraphdata()));
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getProjectstage() == null) ? 0 : getProjectstage().hashCode());
        result = prime * result + ((getGraphdata() == null) ? 0 : getGraphdata().hashCode());
        return result;
    }
}