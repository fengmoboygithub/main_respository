/*
*
* ProcessStageInfo.java
*                    中证技术公司
* @date 2020-08-03
*/
package com.company.processConfig.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class ProcessStageInfo extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 流程ID
     */
    private String processid;

    /**
     * 项目类型
     */
    private String projecttype;

    /**
     * 项目阶段
     */
    private String projectstage;

    /**
     * 流程图像ID
     */
    private String graphid;

    /**
     * processstage
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid == null ? null : processid.trim();
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

    public String getGraphid() {
        return graphid;
    }

    public void setGraphid(String graphid) {
        this.graphid = graphid == null ? null : graphid.trim();
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
        sb.append(", processid=").append(processid);
        sb.append(", projecttype=").append(projecttype);
        sb.append(", projectstage=").append(projectstage);
        sb.append(", graphid=").append(graphid);
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
        ProcessStageInfo other = (ProcessStageInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProcessid() == null ? other.getProcessid() == null : this.getProcessid().equals(other.getProcessid()))
            && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
            && (this.getProjectstage() == null ? other.getProjectstage() == null : this.getProjectstage().equals(other.getProjectstage()))
            && (this.getGraphid() == null ? other.getGraphid() == null : this.getGraphid().equals(other.getGraphid()));
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
        result = prime * result + ((getProcessid() == null) ? 0 : getProcessid().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getProjectstage() == null) ? 0 : getProjectstage().hashCode());
        result = prime * result + ((getGraphid() == null) ? 0 : getGraphid().hashCode());
        return result;
    }
}