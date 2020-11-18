/*
 *
 * ProjectDirectory.java
 *                    中证技术公司
 * @date 2020-03-10
 */
package com.company.projectdirectory.model;

import com.company.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ProjectDirectoryKey extends BaseModel implements Serializable {
    /**
     * 项目ID
     */
    private String projectid;

    /**
     * 目录ID
     */
    private String directoryid;

    /**
     * projectdirectory
     */
    private static final long serialVersionUID = 1L;

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid == null ? null : projectid.trim();
    }

    public String getDirectoryid() {
        return directoryid;
    }

    public void setDirectoryid(String directoryid) {
        this.directoryid = directoryid == null ? null : directoryid.trim();
    }


    /**
     *
     * @mbg.generated 2020-03-11
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectid=").append(projectid);
        sb.append(", directoryid=").append(directoryid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-03-11
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
        ProjectDirectoryKey other = (ProjectDirectoryKey) that;
        return (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
                && (this.getDirectoryid() == null ? other.getDirectoryid() == null : this.getDirectoryid().equals(other.getDirectoryid()));
    }

    /**
     *
     * @mbg.generated 2020-03-11
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectid() == null) ? 0 : getProjectid().hashCode());
        result = prime * result + ((getDirectoryid() == null) ? 0 : getDirectoryid().hashCode());
        return result;
    }
}