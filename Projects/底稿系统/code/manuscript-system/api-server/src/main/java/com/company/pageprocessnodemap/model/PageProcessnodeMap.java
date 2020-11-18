/*
*
* PageProcessnodeMap.java
*                    中证技术公司
* @date 2020-05-07
*/
package com.company.pageprocessnodemap.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class PageProcessnodeMap extends BaseModel implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 页面值
     */
    private String pagevalue;

    /**
     * 可操作流程节点
     */
    private String processnode;

    /**
     * pageprocessnodemap
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPagevalue() {
        return pagevalue;
    }

    public void setPagevalue(String pagevalue) {
        this.pagevalue = pagevalue == null ? null : pagevalue.trim();
    }

    public String getProcessnode() {
        return processnode;
    }

    public void setProcessnode(String processnode) {
        this.processnode = processnode == null ? null : processnode.trim();
    }

    /**
     *
     * @mbg.generated 2020-05-07
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pagevalue=").append(pagevalue);
        sb.append(", processnode=").append(processnode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-05-07
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
        PageProcessnodeMap other = (PageProcessnodeMap) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPagevalue() == null ? other.getPagevalue() == null : this.getPagevalue().equals(other.getPagevalue()))
            && (this.getProcessnode() == null ? other.getProcessnode() == null : this.getProcessnode().equals(other.getProcessnode()));
    }

    /**
     *
     * @mbg.generated 2020-05-07
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPagevalue() == null) ? 0 : getPagevalue().hashCode());
        result = prime * result + ((getProcessnode() == null) ? 0 : getProcessnode().hashCode());
        return result;
    }
}