/*
*
* PersonnelInfo.java
*                    中证技术公司
* @date 2020-04-20
*/
package com.company.personnelinfo.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class PersonnelInfo extends BaseModel implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 人员名称
     */
    private String name;

    /**
     * 角色类型 1:'项目成员' 2:'项目经理'
     */
    private Integer roletype;

    /**
     * 排序值
     */
    private Integer sortno;

    /**
     * personnelinfo
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    /**
     *
     * @mbg.generated 2020-04-20
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", roletype=").append(roletype);
        sb.append(", sortno=").append(sortno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-04-20
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
        PersonnelInfo other = (PersonnelInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRoletype() == null ? other.getRoletype() == null : this.getRoletype().equals(other.getRoletype()))
            && (this.getSortno() == null ? other.getSortno() == null : this.getSortno().equals(other.getSortno()));
    }

    /**
     *
     * @mbg.generated 2020-04-20
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRoletype() == null) ? 0 : getRoletype().hashCode());
        result = prime * result + ((getSortno() == null) ? 0 : getSortno().hashCode());
        return result;
    }
}