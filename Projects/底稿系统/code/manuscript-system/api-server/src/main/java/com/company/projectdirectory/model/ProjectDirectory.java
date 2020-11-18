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
@ApiModel(value="项目目录信息对象",description="项目目录信息表(PROJECTDIRECTORY)")
public class ProjectDirectory extends BaseModel implements Serializable {
    /**
     * 项目ID
     */
    @ApiModelProperty(value="项目ID",name="projectid")
    private String projectid;

    /**
     * 目录ID
     */
    @ApiModelProperty(value="目录ID",name="directoryid")
    private String directoryid;

    /**
     * 主键ID
     */
    @ApiModelProperty(value="主键ID",name="id")
    private String id;

    /**
     * 项目阶段
     */
    @ApiModelProperty(value="项目阶段",name="stage")
    private String stage;

    /**
     * 目录版本HASH
     */
    @ApiModelProperty(value="目录版本HASH",name="versionhash")
    private String versionhash;

    /**
     * 目录全称
     */
    @ApiModelProperty(value="目录全称",name="fullname")
    private String fullname;

    /**
     * 目录简称
     */
    @ApiModelProperty(value="目录简称",name="sname")
    private String sname;

    /**
     * 父目录ID
     */
    @ApiModelProperty(value="父目录ID",name="parentid")
    private String parentid;

    /**
     * 是否适用
     */
    @ApiModelProperty(value="是否适用",name="isapp")
    private Integer isapp;

    /**
     * 流程节点
     */
    @ApiModelProperty(value="流程节点",name="processnode")
    private String processnode;

    /**
     * 流程节点名称
     */
    @ApiModelProperty(value="流程节点名称",name="processnodename")
    private String processnodename;

    /**
     * 目录顺序
     */
    @ApiModelProperty(value="目录顺序",name="directoryno")
    private Integer directoryno;

    /**
     * 目录级别
     */
    @ApiModelProperty(value="目录级别",name="level")
    private String level;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注",name="remarks")
    private String remarks;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getVersionhash() {
        return versionhash;
    }

    public void setVersionhash(String versionhash) {
        this.versionhash = versionhash == null ? null : versionhash.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public Integer getIsapp() {
        return isapp;
    }

    public void setIsapp(Integer isapp) {
        this.isapp = isapp;
    }

    public String getProcessnode() {
        return processnode;
    }

    public void setProcessnode(String processnode) {
        this.processnode = processnode == null ? null : processnode.trim();
    }

    public String getProcessnodename() {
        return processnodename;
    }

    public void setProcessnodename(String processnodename) {
        this.processnodename = processnodename == null ? null : processnodename.trim();
    }

    public Integer getDirectoryno() {
        return directoryno;
    }

    public void setDirectoryno(Integer directoryno) {
        this.directoryno = directoryno == null ? null : directoryno;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
        sb.append(", id=").append(id);
        sb.append(", stage=").append(stage);
        sb.append(", versionhash=").append(versionhash);
        sb.append(", fullname=").append(fullname);
        sb.append(", sname=").append(sname);
        sb.append(", parentid=").append(parentid);
        sb.append(", isapp=").append(isapp);
        sb.append(", processnode=").append(processnode);
        sb.append(", directoryno=").append(directoryno);
        sb.append(", level=").append(level);
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
        ProjectDirectory other = (ProjectDirectory) that;
        return (this.getProjectid() == null ? other.getProjectid() == null : this.getProjectid().equals(other.getProjectid()))
                && (this.getDirectoryid() == null ? other.getDirectoryid() == null : this.getDirectoryid().equals(other.getDirectoryid()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getStage() == null ? other.getStage() == null : this.getStage().equals(other.getStage()))
                && (this.getVersionhash() == null ? other.getVersionhash() == null : this.getVersionhash().equals(other.getVersionhash()))
                && (this.getFullname() == null ? other.getFullname() == null : this.getFullname().equals(other.getFullname()))
                && (this.getSname() == null ? other.getSname() == null : this.getSname().equals(other.getSname()))
                && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
                && (this.getIsapp() == null ? other.getIsapp() == null : this.getIsapp().equals(other.getIsapp()))
                && (this.getProcessnode() == null ? other.getProcessnode() == null : this.getProcessnode().equals(other.getProcessnode()))
                && (this.getDirectoryno() == null ? other.getDirectoryno() == null : this.getDirectoryno().equals(other.getDirectoryno()))
                && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
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
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStage() == null) ? 0 : getStage().hashCode());
        result = prime * result + ((getVersionhash() == null) ? 0 : getVersionhash().hashCode());
        result = prime * result + ((getFullname() == null) ? 0 : getFullname().hashCode());
        result = prime * result + ((getSname() == null) ? 0 : getSname().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getIsapp() == null) ? 0 : getIsapp().hashCode());
        result = prime * result + ((getProcessnode() == null) ? 0 : getProcessnode().hashCode());
        result = prime * result + ((getDirectoryno() == null) ? 0 : getDirectoryno().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }
}