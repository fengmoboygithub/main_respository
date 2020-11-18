/*
*
* ProcessInfo.java
*                    中证技术公司
* @date 2020-08-04
*/
package com.company.processConfig.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class ProcessInfo extends BaseModel implements Serializable {
    /**
     * 流程ID
     */
    private String processid;

    /**
     * 起点流程节点
     */
    private String startprocessnode;

    /**
     * 终点流程节点
     */
    private String endprocessnode;

    /**
     * 操作ID
     */
    private String operid;

    /**
     * processinfo
     */
    private static final long serialVersionUID = 1L;

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid == null ? null : processid.trim();
    }

    public String getStartprocessnode() {
        return startprocessnode;
    }

    public void setStartprocessnode(String startprocessnode) {
        this.startprocessnode = startprocessnode == null ? null : startprocessnode.trim();
    }

    public String getEndprocessnode() {
        return endprocessnode;
    }

    public void setEndprocessnode(String endprocessnode) {
        this.endprocessnode = endprocessnode == null ? null : endprocessnode.trim();
    }

    public String getOperid() {
        return operid;
    }

    public void setOperid(String operid) {
        this.operid = operid == null ? null : operid.trim();
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", processid=").append(processid);
        sb.append(", startprocessnode=").append(startprocessnode);
        sb.append(", endprocessnode=").append(endprocessnode);
        sb.append(", operid=").append(operid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2020-08-04
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
        ProcessInfo other = (ProcessInfo) that;
        return (this.getProcessid() == null ? other.getProcessid() == null : this.getProcessid().equals(other.getProcessid()))
            && (this.getStartprocessnode() == null ? other.getStartprocessnode() == null : this.getStartprocessnode().equals(other.getStartprocessnode()))
            && (this.getEndprocessnode() == null ? other.getEndprocessnode() == null : this.getEndprocessnode().equals(other.getEndprocessnode()))
            && (this.getOperid() == null ? other.getOperid() == null : this.getOperid().equals(other.getOperid()));
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProcessid() == null) ? 0 : getProcessid().hashCode());
        result = prime * result + ((getStartprocessnode() == null) ? 0 : getStartprocessnode().hashCode());
        result = prime * result + ((getEndprocessnode() == null) ? 0 : getEndprocessnode().hashCode());
        result = prime * result + ((getOperid() == null) ? 0 : getOperid().hashCode());
        return result;
    }
}