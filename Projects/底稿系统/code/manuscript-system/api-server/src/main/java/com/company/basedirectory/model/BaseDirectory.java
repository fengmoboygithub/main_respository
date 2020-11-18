/*
*
* BaseDirectory.java
*                    中证技术公司
* @date 2020-03-21
*/
package com.company.basedirectory.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class BaseDirectory extends BaseModel implements Serializable {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 目录简称
     */
    private String sname;

    /**
     * 目录全称
     */
    private String fullname;

    /**
     * 父目录ID
     */
    private String parentid;

    /**
     * 项目类型
     */
    private String projecttype;

    /**
     * 目录层级
     */
    private String level;

    /**
     * 项目阶段
     */
    private String projectstage;

    /**
     * 目录顺序
     */
    private Integer direntoryno;

    /**
     * 是否适用默认值
     */
    private Integer isapp;

    /**
     * 创建人
     */
    private String createuser;

    /**
     * basedirectory
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype == null ? null : projecttype.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getProjectstage() {
        return projectstage;
    }

    public void setProjectstage(String projectstage) {
        this.projectstage = projectstage == null ? null : projectstage.trim();
    }

    public Integer getDirentoryno() {
        return direntoryno;
    }

    public void setDirentoryno(Integer direntoryno) {
        this.direntoryno = direntoryno == null ? null : direntoryno;
    }

    public Integer getIsapp() {
        return isapp;
    }

    public void setIsapp(Integer isapp) {
        this.isapp = isapp;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sname=").append(sname);
        sb.append(", fullname=").append(fullname);
        sb.append(", parentid=").append(parentid);
        sb.append(", projecttype=").append(projecttype);
        sb.append(", level=").append(level);
        sb.append(", projectstage=").append(projectstage);
        sb.append(", direntoryno=").append(direntoryno);
        sb.append(", isapp=").append(isapp);
        sb.append(", createuser=").append(createuser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-03-21
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
        BaseDirectory other = (BaseDirectory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSname() == null ? other.getSname() == null : this.getSname().equals(other.getSname()))
            && (this.getFullname() == null ? other.getFullname() == null : this.getFullname().equals(other.getFullname()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getProjecttype() == null ? other.getProjecttype() == null : this.getProjecttype().equals(other.getProjecttype()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getProjectstage() == null ? other.getProjectstage() == null : this.getProjectstage().equals(other.getProjectstage()))
            && (this.getDirentoryno() == null ? other.getDirentoryno() == null : this.getDirentoryno().equals(other.getDirentoryno()))
            && (this.getIsapp() == null ? other.getIsapp() == null : this.getIsapp().equals(other.getIsapp()))
            && (this.getCreateuser() == null ? other.getCreateuser() == null : this.getCreateuser().equals(other.getCreateuser()));
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSname() == null) ? 0 : getSname().hashCode());
        result = prime * result + ((getFullname() == null) ? 0 : getFullname().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getProjecttype() == null) ? 0 : getProjecttype().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getProjectstage() == null) ? 0 : getProjectstage().hashCode());
        result = prime * result + ((getDirentoryno() == null) ? 0 : getDirentoryno().hashCode());
        result = prime * result + ((getIsapp() == null) ? 0 : getIsapp().hashCode());
        result = prime * result + ((getCreateuser() == null) ? 0 : getCreateuser().hashCode());
        return result;
    }
}