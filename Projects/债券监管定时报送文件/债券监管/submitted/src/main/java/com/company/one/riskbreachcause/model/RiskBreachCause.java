/*
*
* RiskBreachCause.java
*                    中证技术公司
* @date 2019-09-16
*/
package com.company.one.riskbreachcause.model;

import java.io.Serializable;
import java.util.Date;

import com.company.base.model.BaseModel;
import com.company.utils.DateUtils;
import com.company.utils.DateUtils.DATE_PATTERN;
import com.company.utils.StringUtils;

public class RiskBreachCause extends BaseModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String bondCode;

    /**
     * 
     */
    private String bondType;

    /**
     * 
     */
    private String bondMainType;

    /**
     * 
     */
    private String trustCompensation;

    /**
     * 
     */
    private String riskState;

    /**
     * 
     */
    private Integer infoId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 违约原因
     */
    private String breachCause;

    /**
     * 违约性质
     */
    private String breachBature;

    /**
     * 风险发生及处置进展情况
     */
    private String riskProgressSituation;

    /**
     * 违约日期
     */
    private Date breachTime;

    /**
     * 已偿金额
     */
    private String paidAmount;

    /**
     * 未偿金额
     */
    private String unpaidAmount;

    /**
     * 全部清偿日期或风险化解日期
     */
    private Date allPaidTime;

    /**
     * 监管情况（主要针对违法违规
     */
    private String supervisionSituation;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer state;

    /**
     * 
     */
    private String operator;

    /**
     * 
     */
    private String remark;

    /**
     * risk_breach_cause
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBondCode() {
		return bondCode;
	}

	public void setBondCode(String bondCode) {
		this.bondCode = bondCode;
	}

	public String getBondType() {
		return bondType;
	}

	public void setBondType(String bondType) {
		this.bondType = bondType;
	}

	public String getBondMainType() {
		return bondMainType;
	}

	public void setBondMainType(String bondMainType) {
		this.bondMainType = bondMainType;
	}

	public String getTrustCompensation() {
		return trustCompensation;
	}

	public void setTrustCompensation(String trustCompensation) {
		this.trustCompensation = trustCompensation;
	}

	public String getRiskState() {
		return riskState;
	}

	public void setRiskState(String riskState) {
		this.riskState = riskState;
	}

	public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBreachCause() {
        return breachCause;
    }

    public void setBreachCause(String breachCause) {
        this.breachCause = breachCause == null ? null : breachCause.trim();
    }

    public String getBreachBature() {
        return breachBature;
    }

    public void setBreachBature(String breachBature) {
        this.breachBature = breachBature == null ? null : breachBature.trim();
    }

    public String getRiskProgressSituation() {
        return riskProgressSituation;
    }

    public void setRiskProgressSituation(String riskProgressSituation) {
        this.riskProgressSituation = riskProgressSituation == null ? null : riskProgressSituation.trim();
    }

    public Date getBreachTime() {
        return breachTime;
    }

    public void setBreachTime(Date breachTime) {
        this.breachTime = breachTime;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount == null ? null : paidAmount.trim();
    }

    public String getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(String unpaidAmount) {
        this.unpaidAmount = unpaidAmount == null ? null : unpaidAmount.trim();
    }

    public Date getAllPaidTime() {
        return allPaidTime;
    }

    public void setAllPaidTime(Date allPaidTime) {
        this.allPaidTime = allPaidTime;
    }

    public String getSupervisionSituation() {
        return supervisionSituation;
    }

    public void setSupervisionSituation(String supervisionSituation) {
        this.supervisionSituation = supervisionSituation == null ? null : supervisionSituation.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    @Override
    public String toString() {
    	String linefeed = this.getLinefeed();
    	String separator = this.getSeparator();
        StringBuilder sb = new StringBuilder();
        if("01".equals(bondMainType)){
        	sb.append(StringUtils.transfDeal("Z_ID_"+id)).append(separator);
        } else {
        	sb.append(StringUtils.transfDeal("ABS_ID_"+id)).append(separator);
        }
        sb.append("0114").append(separator);
        sb.append(StringUtils.transfDeal(bondCode)).append(separator);
        sb.append(StringUtils.transfDeal(bondType)).append(separator);
        sb.append(StringUtils.transfDeal(DateUtils.dataToString(updateTime,DATE_PATTERN.YYYYMMDDHH_MM_SS))).append(separator);
        sb.append(StringUtils.transfDeal(trustCompensation)).append(separator);
        sb.append(StringUtils.transfDeal(riskState)).append(separator);
        sb.append(StringUtils.transfDeal(DateUtils.dataToString(breachTime,DATE_PATTERN.YYYYMMDD))).append(separator);
        sb.append(StringUtils.transfDeal(breachBature)).append(separator);
        sb.append(StringUtils.transfDeal(breachCause)).append(separator);
        sb.append(StringUtils.transfDeal(paidAmount)).append(separator);
        sb.append(StringUtils.transfDeal(unpaidAmount)).append(separator);
        //sb.append(StringUtils.transfDeal(DateUtils.dataToString(allPaidTime,DATE_PATTERN.YYYYMMDD))).append(separator);
        //此字段暂定报送为空
        sb.append("").append(separator);
        sb.append(StringUtils.transfDeal(DateUtils.dataToString(allPaidTime,DATE_PATTERN.YYYYMMDD))).append(separator);
        sb.append(StringUtils.transfDeal(state+"")).append(separator);
        sb.append(StringUtils.decode(linefeed));
        return sb.toString();
    }

    /**
     *
     * @mbg.generated 2019-09-16
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
        RiskBreachCause other = (RiskBreachCause) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInfoId() == null ? other.getInfoId() == null : this.getInfoId().equals(other.getInfoId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBreachCause() == null ? other.getBreachCause() == null : this.getBreachCause().equals(other.getBreachCause()))
            && (this.getBreachBature() == null ? other.getBreachBature() == null : this.getBreachBature().equals(other.getBreachBature()))
            && (this.getRiskProgressSituation() == null ? other.getRiskProgressSituation() == null : this.getRiskProgressSituation().equals(other.getRiskProgressSituation()))
            && (this.getBreachTime() == null ? other.getBreachTime() == null : this.getBreachTime().equals(other.getBreachTime()))
            && (this.getPaidAmount() == null ? other.getPaidAmount() == null : this.getPaidAmount().equals(other.getPaidAmount()))
            && (this.getUnpaidAmount() == null ? other.getUnpaidAmount() == null : this.getUnpaidAmount().equals(other.getUnpaidAmount()))
            && (this.getAllPaidTime() == null ? other.getAllPaidTime() == null : this.getAllPaidTime().equals(other.getAllPaidTime()))
            && (this.getSupervisionSituation() == null ? other.getSupervisionSituation() == null : this.getSupervisionSituation().equals(other.getSupervisionSituation()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInfoId() == null) ? 0 : getInfoId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBreachCause() == null) ? 0 : getBreachCause().hashCode());
        result = prime * result + ((getBreachBature() == null) ? 0 : getBreachBature().hashCode());
        result = prime * result + ((getRiskProgressSituation() == null) ? 0 : getRiskProgressSituation().hashCode());
        result = prime * result + ((getBreachTime() == null) ? 0 : getBreachTime().hashCode());
        result = prime * result + ((getPaidAmount() == null) ? 0 : getPaidAmount().hashCode());
        result = prime * result + ((getUnpaidAmount() == null) ? 0 : getUnpaidAmount().hashCode());
        result = prime * result + ((getAllPaidTime() == null) ? 0 : getAllPaidTime().hashCode());
        result = prime * result + ((getSupervisionSituation() == null) ? 0 : getSupervisionSituation().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}