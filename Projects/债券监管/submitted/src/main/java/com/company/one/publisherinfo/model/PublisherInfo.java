/*
*
* PublisherInfo.java
*                    中证技术公司
* @date 2019-09-16
*/
package com.company.one.publisherinfo.model;

import java.io.Serializable;
import java.util.Date;

import com.company.base.model.BaseModel;
import com.company.utils.StringUtils;

public class PublisherInfo extends BaseModel implements Serializable {
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
    private String bondMainType;

    /**
     * 
     */
    private String bondName;

    /**
     * 
     */
    private String shortName;

    /**
     * 
     */
    private String bondType;

    /**
     * 
     */
    private String tradingLocation;

    /**
     * 
     */
    private String rating;

    /**
     * 
     */
    private String initialRating;

    /**
     * 
     */
    private String currentRating;

    /**
     * 
     */
    private String stockCode;

    /**
     * 
     */
    private String creditMeasures;

    /**
     * 
     */
    private String issueWay;

    /**
     * 
     */
    private String beIssueAmount;

    /**
     * 
     */
    private String realIssueAmount;

    /**
     * 
     */
    private String trusteeship;

    /**
     * 
     */
    private String trem;

    /**
     * 
     */
    private String tremRemark;

    /**
     * 
     */
    private String issueRate;

    /**
     * 
     */
    private Date issueTime;

    /**
     * 
     */
    private Date listTime;

    /**
     * 
     */
    private Date approvalTime;

    /**
     * 
     */
    private Date interestTime;

    /**
     * 
     */
    private Date dueTime;

    /**
     * 
     */
    private Date resaleTime;

    /**
     * 
     */
    private String relateSrb;

    /**
     * 
     */
    private Integer debtAccount;

    /**
     * 
     */
    private Integer individualInvestorAccount;

    /**
     * 
     */
    private String personalDebtRate;

    /**
     * 
     */
    private String currentRate;

    /**
     * 
     */
    private String properManagement;

    /**
     * 
     */
    private Date properManagementTime;

    /**
     * 
     */
    private String issuerName;

    /**
     * 其他发行人
     */
    private String otherIssuerName;

    /**
     * 
     */
    private String issuerIndustry;

    /**
     * 
     */
    private String issuerProvince;

    /**
     * 
     */
    private String issuerCity;

    /**
     * 
     */
    private String issuerSrb;

    /**
     * 
     */
    private String issuerBusiness;

    /**
     * 
     */
    private String issuerNature;

    /**
     * 
     */
    private String issuerFinancial;

    /**
     * 
     */
    private String issuerRating;

    /**
     * 
     */
    private String comInitialRating;

    /**
     * 
     */
    private String comCurrentRating;

    /**
     * 
     */
    private String issuerContactWay;

    /**
     * 
     */
    private String underwriterName;

    /**
     * 
     */
    private String underwriterCharge;

    /**
     * 
     */
    private String underwriterSrb;

    /**
     * 
     */
    private String accountingName;

    /**
     * 
     */
    private String accountingSignatory;

    /**
     * 
     */
    private String lawName;

    /**
     * 
     */
    private String lawSignatory;

    /**
     * 
     */
    private String ratingAgencyName;

    /**
     * 其他资信评级机构名称
     */
    private String otherRatingAgencyName;

    /**
     * 
     */
    private String ratingAgencyCharge;

    /**
     * 
     */
    private String ratingAgencySrb;

    /**
     * 
     */
    private String trusteeName;

    /**
     * 
     */
    private String trusteeCharge;

    /**
     * 
     */
    private String trusteeChargeContactWay;

    /**
     * 
     */
    private String trusteeSrb;

    /**
     * 
     */
    private Integer issuerId;

    /**
     * 
     */
    private Integer underwriterId;

    /**
     * 
     */
    private Integer lawFirmId;

    /**
     * 
     */
    private Integer accountingFirmId;

    /**
     * 
     */
    private Integer guarantorId;

    /**
     * 
     */
    private Integer creditRatingAgencyId;

    /**
     * 
     */
    private Integer trusteeId;

    /**
     * 
     */
    private Integer intermediaryAgencyId;

    /**
     * 
     */
    private Integer publisherId;

    /**
     * 
     */
    private Integer state;

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
    private String remark;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String jurSrb;

    /**
     * 
     */
    private Integer auditState;

    /**
     * 
     */
    private Integer editState;

    /**
     * 
     */
    private String serialNumber;

    /**
     * bond_base_info
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
        this.bondCode = bondCode == null ? null : bondCode.trim();
    }
    
    public String getBondMainType() {
		return bondMainType;
	}

	public void setBondMainType(String bondMainType) {
		this.bondMainType = bondMainType;
	}

	public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName == null ? null : bondName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType == null ? null : bondType.trim();
    }

    public String getTradingLocation() {
        return tradingLocation;
    }

    public void setTradingLocation(String tradingLocation) {
        this.tradingLocation = tradingLocation == null ? null : tradingLocation.trim();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating == null ? null : rating.trim();
    }

    public String getInitialRating() {
        return initialRating;
    }

    public void setInitialRating(String initialRating) {
        this.initialRating = initialRating == null ? null : initialRating.trim();
    }

    public String getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(String currentRating) {
        this.currentRating = currentRating == null ? null : currentRating.trim();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getCreditMeasures() {
        return creditMeasures;
    }

    public void setCreditMeasures(String creditMeasures) {
        this.creditMeasures = creditMeasures == null ? null : creditMeasures.trim();
    }

    public String getIssueWay() {
        return issueWay;
    }

    public void setIssueWay(String issueWay) {
        this.issueWay = issueWay == null ? null : issueWay.trim();
    }

    public String getBeIssueAmount() {
        return beIssueAmount;
    }

    public void setBeIssueAmount(String beIssueAmount) {
        this.beIssueAmount = beIssueAmount == null ? null : beIssueAmount.trim();
    }

    public String getRealIssueAmount() {
        return realIssueAmount;
    }

    public void setRealIssueAmount(String realIssueAmount) {
        this.realIssueAmount = realIssueAmount == null ? null : realIssueAmount.trim();
    }

    public String getTrusteeship() {
        return trusteeship;
    }

    public void setTrusteeship(String trusteeship) {
        this.trusteeship = trusteeship == null ? null : trusteeship.trim();
    }

    public String getTrem() {
        return trem;
    }

    public void setTrem(String trem) {
        this.trem = trem == null ? null : trem.trim();
    }

    public String getTremRemark() {
        return tremRemark;
    }

    public void setTremRemark(String tremRemark) {
        this.tremRemark = tremRemark == null ? null : tremRemark.trim();
    }

    public String getIssueRate() {
        return issueRate;
    }

    public void setIssueRate(String issueRate) {
        this.issueRate = issueRate == null ? null : issueRate.trim();
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Date getInterestTime() {
        return interestTime;
    }

    public void setInterestTime(Date interestTime) {
        this.interestTime = interestTime;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Date getResaleTime() {
        return resaleTime;
    }

    public void setResaleTime(Date resaleTime) {
        this.resaleTime = resaleTime;
    }

    public String getRelateSrb() {
        return relateSrb;
    }

    public void setRelateSrb(String relateSrb) {
        this.relateSrb = relateSrb == null ? null : relateSrb.trim();
    }

    public Integer getDebtAccount() {
        return debtAccount;
    }

    public void setDebtAccount(Integer debtAccount) {
        this.debtAccount = debtAccount;
    }

    public Integer getIndividualInvestorAccount() {
        return individualInvestorAccount;
    }

    public void setIndividualInvestorAccount(Integer individualInvestorAccount) {
        this.individualInvestorAccount = individualInvestorAccount;
    }

    public String getPersonalDebtRate() {
        return personalDebtRate;
    }

    public void setPersonalDebtRate(String personalDebtRate) {
        this.personalDebtRate = personalDebtRate == null ? null : personalDebtRate.trim();
    }

    public String getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(String currentRate) {
        this.currentRate = currentRate == null ? null : currentRate.trim();
    }

    public String getProperManagement() {
        return properManagement;
    }

    public void setProperManagement(String properManagement) {
        this.properManagement = properManagement == null ? null : properManagement.trim();
    }

    public Date getProperManagementTime() {
        return properManagementTime;
    }

    public void setProperManagementTime(Date properManagementTime) {
        this.properManagementTime = properManagementTime;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName == null ? null : issuerName.trim();
    }

    public String getOtherIssuerName() {
        return otherIssuerName;
    }

    public void setOtherIssuerName(String otherIssuerName) {
        this.otherIssuerName = otherIssuerName == null ? null : otherIssuerName.trim();
    }

    public String getIssuerIndustry() {
        return issuerIndustry;
    }

    public void setIssuerIndustry(String issuerIndustry) {
        this.issuerIndustry = issuerIndustry == null ? null : issuerIndustry.trim();
    }

    public String getIssuerProvince() {
        return issuerProvince;
    }

    public void setIssuerProvince(String issuerProvince) {
        this.issuerProvince = issuerProvince == null ? null : issuerProvince.trim();
    }

    public String getIssuerCity() {
        return issuerCity;
    }

    public void setIssuerCity(String issuerCity) {
        this.issuerCity = issuerCity == null ? null : issuerCity.trim();
    }

    public String getIssuerSrb() {
        return issuerSrb;
    }

    public void setIssuerSrb(String issuerSrb) {
        this.issuerSrb = issuerSrb == null ? null : issuerSrb.trim();
    }

    public String getIssuerBusiness() {
        return issuerBusiness;
    }

    public void setIssuerBusiness(String issuerBusiness) {
        this.issuerBusiness = issuerBusiness == null ? null : issuerBusiness.trim();
    }

    public String getIssuerNature() {
        return issuerNature;
    }

    public void setIssuerNature(String issuerNature) {
        this.issuerNature = issuerNature == null ? null : issuerNature.trim();
    }

    public String getIssuerFinancial() {
        return issuerFinancial;
    }

    public void setIssuerFinancial(String issuerFinancial) {
        this.issuerFinancial = issuerFinancial == null ? null : issuerFinancial.trim();
    }

    public String getIssuerRating() {
        return issuerRating;
    }

    public void setIssuerRating(String issuerRating) {
        this.issuerRating = issuerRating == null ? null : issuerRating.trim();
    }

    public String getComInitialRating() {
        return comInitialRating;
    }

    public void setComInitialRating(String comInitialRating) {
        this.comInitialRating = comInitialRating == null ? null : comInitialRating.trim();
    }

    public String getComCurrentRating() {
        return comCurrentRating;
    }

    public void setComCurrentRating(String comCurrentRating) {
        this.comCurrentRating = comCurrentRating == null ? null : comCurrentRating.trim();
    }

    public String getIssuerContactWay() {
        return issuerContactWay;
    }

    public void setIssuerContactWay(String issuerContactWay) {
        this.issuerContactWay = issuerContactWay == null ? null : issuerContactWay.trim();
    }

    public String getUnderwriterName() {
        return underwriterName;
    }

    public void setUnderwriterName(String underwriterName) {
        this.underwriterName = underwriterName == null ? null : underwriterName.trim();
    }

    public String getUnderwriterCharge() {
        return underwriterCharge;
    }

    public void setUnderwriterCharge(String underwriterCharge) {
        this.underwriterCharge = underwriterCharge == null ? null : underwriterCharge.trim();
    }

    public String getUnderwriterSrb() {
        return underwriterSrb;
    }

    public void setUnderwriterSrb(String underwriterSrb) {
        this.underwriterSrb = underwriterSrb == null ? null : underwriterSrb.trim();
    }

    public String getAccountingName() {
        return accountingName;
    }

    public void setAccountingName(String accountingName) {
        this.accountingName = accountingName == null ? null : accountingName.trim();
    }

    public String getAccountingSignatory() {
        return accountingSignatory;
    }

    public void setAccountingSignatory(String accountingSignatory) {
        this.accountingSignatory = accountingSignatory == null ? null : accountingSignatory.trim();
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName == null ? null : lawName.trim();
    }

    public String getLawSignatory() {
        return lawSignatory;
    }

    public void setLawSignatory(String lawSignatory) {
        this.lawSignatory = lawSignatory == null ? null : lawSignatory.trim();
    }

    public String getRatingAgencyName() {
        return ratingAgencyName;
    }

    public void setRatingAgencyName(String ratingAgencyName) {
        this.ratingAgencyName = ratingAgencyName == null ? null : ratingAgencyName.trim();
    }

    public String getOtherRatingAgencyName() {
        return otherRatingAgencyName;
    }

    public void setOtherRatingAgencyName(String otherRatingAgencyName) {
        this.otherRatingAgencyName = otherRatingAgencyName == null ? null : otherRatingAgencyName.trim();
    }

    public String getRatingAgencyCharge() {
        return ratingAgencyCharge;
    }

    public void setRatingAgencyCharge(String ratingAgencyCharge) {
        this.ratingAgencyCharge = ratingAgencyCharge == null ? null : ratingAgencyCharge.trim();
    }

    public String getRatingAgencySrb() {
        return ratingAgencySrb;
    }

    public void setRatingAgencySrb(String ratingAgencySrb) {
        this.ratingAgencySrb = ratingAgencySrb == null ? null : ratingAgencySrb.trim();
    }

    public String getTrusteeName() {
        return trusteeName;
    }

    public void setTrusteeName(String trusteeName) {
        this.trusteeName = trusteeName == null ? null : trusteeName.trim();
    }

    public String getTrusteeCharge() {
        return trusteeCharge;
    }

    public void setTrusteeCharge(String trusteeCharge) {
        this.trusteeCharge = trusteeCharge == null ? null : trusteeCharge.trim();
    }

    public String getTrusteeChargeContactWay() {
        return trusteeChargeContactWay;
    }

    public void setTrusteeChargeContactWay(String trusteeChargeContactWay) {
        this.trusteeChargeContactWay = trusteeChargeContactWay == null ? null : trusteeChargeContactWay.trim();
    }

    public String getTrusteeSrb() {
        return trusteeSrb;
    }

    public void setTrusteeSrb(String trusteeSrb) {
        this.trusteeSrb = trusteeSrb == null ? null : trusteeSrb.trim();
    }

    public Integer getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Integer issuerId) {
        this.issuerId = issuerId;
    }

    public Integer getUnderwriterId() {
        return underwriterId;
    }

    public void setUnderwriterId(Integer underwriterId) {
        this.underwriterId = underwriterId;
    }

    public Integer getLawFirmId() {
        return lawFirmId;
    }

    public void setLawFirmId(Integer lawFirmId) {
        this.lawFirmId = lawFirmId;
    }

    public Integer getAccountingFirmId() {
        return accountingFirmId;
    }

    public void setAccountingFirmId(Integer accountingFirmId) {
        this.accountingFirmId = accountingFirmId;
    }

    public Integer getGuarantorId() {
        return guarantorId;
    }

    public void setGuarantorId(Integer guarantorId) {
        this.guarantorId = guarantorId;
    }

    public Integer getCreditRatingAgencyId() {
        return creditRatingAgencyId;
    }

    public void setCreditRatingAgencyId(Integer creditRatingAgencyId) {
        this.creditRatingAgencyId = creditRatingAgencyId;
    }

    public Integer getTrusteeId() {
        return trusteeId;
    }

    public void setTrusteeId(Integer trusteeId) {
        this.trusteeId = trusteeId;
    }

    public Integer getIntermediaryAgencyId() {
        return intermediaryAgencyId;
    }

    public void setIntermediaryAgencyId(Integer intermediaryAgencyId) {
        this.intermediaryAgencyId = intermediaryAgencyId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getJurSrb() {
        return jurSrb;
    }

    public void setJurSrb(String jurSrb) {
        this.jurSrb = jurSrb == null ? null : jurSrb.trim();
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Integer getEditState() {
        return editState;
    }

    public void setEditState(Integer editState) {
        this.editState = editState;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
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
        sb.append("0114").append(separator);
        sb.append(StringUtils.transfDeal(bondCode)).append(separator);
        sb.append(StringUtils.transfDeal(issuerName)).append(separator);
        sb.append(StringUtils.transfDeal(bondMainType)).append(separator);
        sb.append(StringUtils.transfDeal(StringUtils.conversionForNature(issuerNature))).append(separator);
        sb.append(StringUtils.transfDeal(issuerRating)).append(separator);
        if("02".equals(bondMainType)){
        	//此字段暂定报送为空
            sb.append("").append(separator);
        } else {
        	sb.append(StringUtils.transfDeal(issuerBusiness)).append(separator);
        }
        //sb.append(StringUtils.transfDeal(issuerIndustry)).append(separator);
        //此字段暂定报送为空
        sb.append("");
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
        PublisherInfo other = (PublisherInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBondCode() == null ? other.getBondCode() == null : this.getBondCode().equals(other.getBondCode()))
            && (this.getBondName() == null ? other.getBondName() == null : this.getBondName().equals(other.getBondName()))
            && (this.getShortName() == null ? other.getShortName() == null : this.getShortName().equals(other.getShortName()))
            && (this.getBondType() == null ? other.getBondType() == null : this.getBondType().equals(other.getBondType()))
            && (this.getTradingLocation() == null ? other.getTradingLocation() == null : this.getTradingLocation().equals(other.getTradingLocation()))
            && (this.getRating() == null ? other.getRating() == null : this.getRating().equals(other.getRating()))
            && (this.getInitialRating() == null ? other.getInitialRating() == null : this.getInitialRating().equals(other.getInitialRating()))
            && (this.getCurrentRating() == null ? other.getCurrentRating() == null : this.getCurrentRating().equals(other.getCurrentRating()))
            && (this.getStockCode() == null ? other.getStockCode() == null : this.getStockCode().equals(other.getStockCode()))
            && (this.getCreditMeasures() == null ? other.getCreditMeasures() == null : this.getCreditMeasures().equals(other.getCreditMeasures()))
            && (this.getIssueWay() == null ? other.getIssueWay() == null : this.getIssueWay().equals(other.getIssueWay()))
            && (this.getBeIssueAmount() == null ? other.getBeIssueAmount() == null : this.getBeIssueAmount().equals(other.getBeIssueAmount()))
            && (this.getRealIssueAmount() == null ? other.getRealIssueAmount() == null : this.getRealIssueAmount().equals(other.getRealIssueAmount()))
            && (this.getTrusteeship() == null ? other.getTrusteeship() == null : this.getTrusteeship().equals(other.getTrusteeship()))
            && (this.getTrem() == null ? other.getTrem() == null : this.getTrem().equals(other.getTrem()))
            && (this.getTremRemark() == null ? other.getTremRemark() == null : this.getTremRemark().equals(other.getTremRemark()))
            && (this.getIssueRate() == null ? other.getIssueRate() == null : this.getIssueRate().equals(other.getIssueRate()))
            && (this.getIssueTime() == null ? other.getIssueTime() == null : this.getIssueTime().equals(other.getIssueTime()))
            && (this.getListTime() == null ? other.getListTime() == null : this.getListTime().equals(other.getListTime()))
            && (this.getApprovalTime() == null ? other.getApprovalTime() == null : this.getApprovalTime().equals(other.getApprovalTime()))
            && (this.getInterestTime() == null ? other.getInterestTime() == null : this.getInterestTime().equals(other.getInterestTime()))
            && (this.getDueTime() == null ? other.getDueTime() == null : this.getDueTime().equals(other.getDueTime()))
            && (this.getResaleTime() == null ? other.getResaleTime() == null : this.getResaleTime().equals(other.getResaleTime()))
            && (this.getRelateSrb() == null ? other.getRelateSrb() == null : this.getRelateSrb().equals(other.getRelateSrb()))
            && (this.getDebtAccount() == null ? other.getDebtAccount() == null : this.getDebtAccount().equals(other.getDebtAccount()))
            && (this.getIndividualInvestorAccount() == null ? other.getIndividualInvestorAccount() == null : this.getIndividualInvestorAccount().equals(other.getIndividualInvestorAccount()))
            && (this.getPersonalDebtRate() == null ? other.getPersonalDebtRate() == null : this.getPersonalDebtRate().equals(other.getPersonalDebtRate()))
            && (this.getCurrentRate() == null ? other.getCurrentRate() == null : this.getCurrentRate().equals(other.getCurrentRate()))
            && (this.getProperManagement() == null ? other.getProperManagement() == null : this.getProperManagement().equals(other.getProperManagement()))
            && (this.getProperManagementTime() == null ? other.getProperManagementTime() == null : this.getProperManagementTime().equals(other.getProperManagementTime()))
            && (this.getIssuerName() == null ? other.getIssuerName() == null : this.getIssuerName().equals(other.getIssuerName()))
            && (this.getOtherIssuerName() == null ? other.getOtherIssuerName() == null : this.getOtherIssuerName().equals(other.getOtherIssuerName()))
            && (this.getIssuerIndustry() == null ? other.getIssuerIndustry() == null : this.getIssuerIndustry().equals(other.getIssuerIndustry()))
            && (this.getIssuerProvince() == null ? other.getIssuerProvince() == null : this.getIssuerProvince().equals(other.getIssuerProvince()))
            && (this.getIssuerCity() == null ? other.getIssuerCity() == null : this.getIssuerCity().equals(other.getIssuerCity()))
            && (this.getIssuerSrb() == null ? other.getIssuerSrb() == null : this.getIssuerSrb().equals(other.getIssuerSrb()))
            && (this.getIssuerBusiness() == null ? other.getIssuerBusiness() == null : this.getIssuerBusiness().equals(other.getIssuerBusiness()))
            && (this.getIssuerNature() == null ? other.getIssuerNature() == null : this.getIssuerNature().equals(other.getIssuerNature()))
            && (this.getIssuerFinancial() == null ? other.getIssuerFinancial() == null : this.getIssuerFinancial().equals(other.getIssuerFinancial()))
            && (this.getIssuerRating() == null ? other.getIssuerRating() == null : this.getIssuerRating().equals(other.getIssuerRating()))
            && (this.getComInitialRating() == null ? other.getComInitialRating() == null : this.getComInitialRating().equals(other.getComInitialRating()))
            && (this.getComCurrentRating() == null ? other.getComCurrentRating() == null : this.getComCurrentRating().equals(other.getComCurrentRating()))
            && (this.getIssuerContactWay() == null ? other.getIssuerContactWay() == null : this.getIssuerContactWay().equals(other.getIssuerContactWay()))
            && (this.getUnderwriterName() == null ? other.getUnderwriterName() == null : this.getUnderwriterName().equals(other.getUnderwriterName()))
            && (this.getUnderwriterCharge() == null ? other.getUnderwriterCharge() == null : this.getUnderwriterCharge().equals(other.getUnderwriterCharge()))
            && (this.getUnderwriterSrb() == null ? other.getUnderwriterSrb() == null : this.getUnderwriterSrb().equals(other.getUnderwriterSrb()))
            && (this.getAccountingName() == null ? other.getAccountingName() == null : this.getAccountingName().equals(other.getAccountingName()))
            && (this.getAccountingSignatory() == null ? other.getAccountingSignatory() == null : this.getAccountingSignatory().equals(other.getAccountingSignatory()))
            && (this.getLawName() == null ? other.getLawName() == null : this.getLawName().equals(other.getLawName()))
            && (this.getLawSignatory() == null ? other.getLawSignatory() == null : this.getLawSignatory().equals(other.getLawSignatory()))
            && (this.getRatingAgencyName() == null ? other.getRatingAgencyName() == null : this.getRatingAgencyName().equals(other.getRatingAgencyName()))
            && (this.getOtherRatingAgencyName() == null ? other.getOtherRatingAgencyName() == null : this.getOtherRatingAgencyName().equals(other.getOtherRatingAgencyName()))
            && (this.getRatingAgencyCharge() == null ? other.getRatingAgencyCharge() == null : this.getRatingAgencyCharge().equals(other.getRatingAgencyCharge()))
            && (this.getRatingAgencySrb() == null ? other.getRatingAgencySrb() == null : this.getRatingAgencySrb().equals(other.getRatingAgencySrb()))
            && (this.getTrusteeName() == null ? other.getTrusteeName() == null : this.getTrusteeName().equals(other.getTrusteeName()))
            && (this.getTrusteeCharge() == null ? other.getTrusteeCharge() == null : this.getTrusteeCharge().equals(other.getTrusteeCharge()))
            && (this.getTrusteeChargeContactWay() == null ? other.getTrusteeChargeContactWay() == null : this.getTrusteeChargeContactWay().equals(other.getTrusteeChargeContactWay()))
            && (this.getTrusteeSrb() == null ? other.getTrusteeSrb() == null : this.getTrusteeSrb().equals(other.getTrusteeSrb()))
            && (this.getIssuerId() == null ? other.getIssuerId() == null : this.getIssuerId().equals(other.getIssuerId()))
            && (this.getUnderwriterId() == null ? other.getUnderwriterId() == null : this.getUnderwriterId().equals(other.getUnderwriterId()))
            && (this.getLawFirmId() == null ? other.getLawFirmId() == null : this.getLawFirmId().equals(other.getLawFirmId()))
            && (this.getAccountingFirmId() == null ? other.getAccountingFirmId() == null : this.getAccountingFirmId().equals(other.getAccountingFirmId()))
            && (this.getGuarantorId() == null ? other.getGuarantorId() == null : this.getGuarantorId().equals(other.getGuarantorId()))
            && (this.getCreditRatingAgencyId() == null ? other.getCreditRatingAgencyId() == null : this.getCreditRatingAgencyId().equals(other.getCreditRatingAgencyId()))
            && (this.getTrusteeId() == null ? other.getTrusteeId() == null : this.getTrusteeId().equals(other.getTrusteeId()))
            && (this.getIntermediaryAgencyId() == null ? other.getIntermediaryAgencyId() == null : this.getIntermediaryAgencyId().equals(other.getIntermediaryAgencyId()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getJurSrb() == null ? other.getJurSrb() == null : this.getJurSrb().equals(other.getJurSrb()))
            && (this.getAuditState() == null ? other.getAuditState() == null : this.getAuditState().equals(other.getAuditState()))
            && (this.getEditState() == null ? other.getEditState() == null : this.getEditState().equals(other.getEditState()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()));
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
        result = prime * result + ((getBondCode() == null) ? 0 : getBondCode().hashCode());
        result = prime * result + ((getBondName() == null) ? 0 : getBondName().hashCode());
        result = prime * result + ((getShortName() == null) ? 0 : getShortName().hashCode());
        result = prime * result + ((getBondType() == null) ? 0 : getBondType().hashCode());
        result = prime * result + ((getTradingLocation() == null) ? 0 : getTradingLocation().hashCode());
        result = prime * result + ((getRating() == null) ? 0 : getRating().hashCode());
        result = prime * result + ((getInitialRating() == null) ? 0 : getInitialRating().hashCode());
        result = prime * result + ((getCurrentRating() == null) ? 0 : getCurrentRating().hashCode());
        result = prime * result + ((getStockCode() == null) ? 0 : getStockCode().hashCode());
        result = prime * result + ((getCreditMeasures() == null) ? 0 : getCreditMeasures().hashCode());
        result = prime * result + ((getIssueWay() == null) ? 0 : getIssueWay().hashCode());
        result = prime * result + ((getBeIssueAmount() == null) ? 0 : getBeIssueAmount().hashCode());
        result = prime * result + ((getRealIssueAmount() == null) ? 0 : getRealIssueAmount().hashCode());
        result = prime * result + ((getTrusteeship() == null) ? 0 : getTrusteeship().hashCode());
        result = prime * result + ((getTrem() == null) ? 0 : getTrem().hashCode());
        result = prime * result + ((getTremRemark() == null) ? 0 : getTremRemark().hashCode());
        result = prime * result + ((getIssueRate() == null) ? 0 : getIssueRate().hashCode());
        result = prime * result + ((getIssueTime() == null) ? 0 : getIssueTime().hashCode());
        result = prime * result + ((getListTime() == null) ? 0 : getListTime().hashCode());
        result = prime * result + ((getApprovalTime() == null) ? 0 : getApprovalTime().hashCode());
        result = prime * result + ((getInterestTime() == null) ? 0 : getInterestTime().hashCode());
        result = prime * result + ((getDueTime() == null) ? 0 : getDueTime().hashCode());
        result = prime * result + ((getResaleTime() == null) ? 0 : getResaleTime().hashCode());
        result = prime * result + ((getRelateSrb() == null) ? 0 : getRelateSrb().hashCode());
        result = prime * result + ((getDebtAccount() == null) ? 0 : getDebtAccount().hashCode());
        result = prime * result + ((getIndividualInvestorAccount() == null) ? 0 : getIndividualInvestorAccount().hashCode());
        result = prime * result + ((getPersonalDebtRate() == null) ? 0 : getPersonalDebtRate().hashCode());
        result = prime * result + ((getCurrentRate() == null) ? 0 : getCurrentRate().hashCode());
        result = prime * result + ((getProperManagement() == null) ? 0 : getProperManagement().hashCode());
        result = prime * result + ((getProperManagementTime() == null) ? 0 : getProperManagementTime().hashCode());
        result = prime * result + ((getIssuerName() == null) ? 0 : getIssuerName().hashCode());
        result = prime * result + ((getOtherIssuerName() == null) ? 0 : getOtherIssuerName().hashCode());
        result = prime * result + ((getIssuerIndustry() == null) ? 0 : getIssuerIndustry().hashCode());
        result = prime * result + ((getIssuerProvince() == null) ? 0 : getIssuerProvince().hashCode());
        result = prime * result + ((getIssuerCity() == null) ? 0 : getIssuerCity().hashCode());
        result = prime * result + ((getIssuerSrb() == null) ? 0 : getIssuerSrb().hashCode());
        result = prime * result + ((getIssuerBusiness() == null) ? 0 : getIssuerBusiness().hashCode());
        result = prime * result + ((getIssuerNature() == null) ? 0 : getIssuerNature().hashCode());
        result = prime * result + ((getIssuerFinancial() == null) ? 0 : getIssuerFinancial().hashCode());
        result = prime * result + ((getIssuerRating() == null) ? 0 : getIssuerRating().hashCode());
        result = prime * result + ((getComInitialRating() == null) ? 0 : getComInitialRating().hashCode());
        result = prime * result + ((getComCurrentRating() == null) ? 0 : getComCurrentRating().hashCode());
        result = prime * result + ((getIssuerContactWay() == null) ? 0 : getIssuerContactWay().hashCode());
        result = prime * result + ((getUnderwriterName() == null) ? 0 : getUnderwriterName().hashCode());
        result = prime * result + ((getUnderwriterCharge() == null) ? 0 : getUnderwriterCharge().hashCode());
        result = prime * result + ((getUnderwriterSrb() == null) ? 0 : getUnderwriterSrb().hashCode());
        result = prime * result + ((getAccountingName() == null) ? 0 : getAccountingName().hashCode());
        result = prime * result + ((getAccountingSignatory() == null) ? 0 : getAccountingSignatory().hashCode());
        result = prime * result + ((getLawName() == null) ? 0 : getLawName().hashCode());
        result = prime * result + ((getLawSignatory() == null) ? 0 : getLawSignatory().hashCode());
        result = prime * result + ((getRatingAgencyName() == null) ? 0 : getRatingAgencyName().hashCode());
        result = prime * result + ((getOtherRatingAgencyName() == null) ? 0 : getOtherRatingAgencyName().hashCode());
        result = prime * result + ((getRatingAgencyCharge() == null) ? 0 : getRatingAgencyCharge().hashCode());
        result = prime * result + ((getRatingAgencySrb() == null) ? 0 : getRatingAgencySrb().hashCode());
        result = prime * result + ((getTrusteeName() == null) ? 0 : getTrusteeName().hashCode());
        result = prime * result + ((getTrusteeCharge() == null) ? 0 : getTrusteeCharge().hashCode());
        result = prime * result + ((getTrusteeChargeContactWay() == null) ? 0 : getTrusteeChargeContactWay().hashCode());
        result = prime * result + ((getTrusteeSrb() == null) ? 0 : getTrusteeSrb().hashCode());
        result = prime * result + ((getIssuerId() == null) ? 0 : getIssuerId().hashCode());
        result = prime * result + ((getUnderwriterId() == null) ? 0 : getUnderwriterId().hashCode());
        result = prime * result + ((getLawFirmId() == null) ? 0 : getLawFirmId().hashCode());
        result = prime * result + ((getAccountingFirmId() == null) ? 0 : getAccountingFirmId().hashCode());
        result = prime * result + ((getGuarantorId() == null) ? 0 : getGuarantorId().hashCode());
        result = prime * result + ((getCreditRatingAgencyId() == null) ? 0 : getCreditRatingAgencyId().hashCode());
        result = prime * result + ((getTrusteeId() == null) ? 0 : getTrusteeId().hashCode());
        result = prime * result + ((getIntermediaryAgencyId() == null) ? 0 : getIntermediaryAgencyId().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getJurSrb() == null) ? 0 : getJurSrb().hashCode());
        result = prime * result + ((getAuditState() == null) ? 0 : getAuditState().hashCode());
        result = prime * result + ((getEditState() == null) ? 0 : getEditState().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        return result;
    }
}