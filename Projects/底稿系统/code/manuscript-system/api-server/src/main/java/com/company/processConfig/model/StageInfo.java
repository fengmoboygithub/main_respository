/*
*
* StageInfo.java
*                    中证技术公司
* @date 2020-05-09
*/
package com.company.processConfig.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class StageInfo extends BaseModel implements Serializable {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 项目类型
     */
    private String projecttype;

    /**
     * 项目阶段
     */
    private String projectstage;

    /**
     * 阶段名称
     */
    private String stagename;

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

    /**
     *
     * @mbg.generated 2020-05-09
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
     * @mbg.generated 2020-05-09
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
        StageInfo other = (StageInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
            && (this.getProjectstage() == null ? other.getProjectstage() == null : this.getProjectstage().equals(other.getProjectstage()))
            && (this.getStagename() == null ? other.getStagename() == null : this.getStagename().equals(other.getStagename()));
    }

    /**
     *
     * @mbg.generated 2020-05-09
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