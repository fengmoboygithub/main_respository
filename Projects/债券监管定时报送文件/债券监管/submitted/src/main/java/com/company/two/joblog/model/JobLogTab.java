/*
*
* JobLogTab.java
*                    中证技术公司
* @date 2019-09-18
*/
package com.company.two.joblog.model;

import com.company.base.model.BaseModel;
import java.io.Serializable;

public class JobLogTab extends BaseModel implements Serializable {
    /**
     * null
     */
    private Integer id = null;

    /**
     * null
     */
    private String interfaceCode;

    /**
     * null
     */
    private Integer versionNumber;

    /**
     * null
     */
    private String interfaceDate;

    /**
     * null
     */
    private Integer totalNumber;

    /**
     * job_log_tab
     */
    private static final long serialVersionUID = 1L;
    
    public JobLogTab(){
    	super();
    }

    public JobLogTab(String interfaceCode, Integer versionNumber, String interfaceDate) {
		super();
		this.interfaceCode = interfaceCode;
		this.versionNumber = versionNumber;
		this.interfaceDate = interfaceDate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode == null ? null : interfaceCode.trim();
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getInterfaceDate() {
        return interfaceDate;
    }

    public void setInterfaceDate(String interfaceDate) {
        this.interfaceDate = interfaceDate == null ? null : interfaceDate.trim();
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     *
     * @mbg.generated 2019-09-18
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", interfaceCode=").append(interfaceCode);
        sb.append(", versionNumber=").append(versionNumber);
        sb.append(", interfaceDate=").append(interfaceDate);
        sb.append(", totalNumber=").append(totalNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2019-09-18
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
        JobLogTab other = (JobLogTab) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInterfaceCode() == null ? other.getInterfaceCode() == null : this.getInterfaceCode().equals(other.getInterfaceCode()))
            && (this.getVersionNumber() == null ? other.getVersionNumber() == null : this.getVersionNumber().equals(other.getVersionNumber()))
            && (this.getInterfaceDate() == null ? other.getInterfaceDate() == null : this.getInterfaceDate().equals(other.getInterfaceDate()))
            && (this.getTotalNumber() == null ? other.getTotalNumber() == null : this.getTotalNumber().equals(other.getTotalNumber()));
    }

    /**
     *
     * @mbg.generated 2019-09-18
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInterfaceCode() == null) ? 0 : getInterfaceCode().hashCode());
        result = prime * result + ((getVersionNumber() == null) ? 0 : getVersionNumber().hashCode());
        result = prime * result + ((getInterfaceDate() == null) ? 0 : getInterfaceDate().hashCode());
        result = prime * result + ((getTotalNumber() == null) ? 0 : getTotalNumber().hashCode());
        return result;
    }
}