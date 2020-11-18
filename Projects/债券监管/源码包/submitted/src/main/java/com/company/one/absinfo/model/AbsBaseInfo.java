/*
*
* AbsBaseInfo.java
*                    中证技术公司
* @date 2019-09-16
*/
package com.company.one.absinfo.model;

import java.io.Serializable;
import java.util.Date;

import com.company.base.model.BaseModel;
import com.company.utils.DateUtils;
import com.company.utils.DateUtils.DATE_PATTERN;
import com.company.utils.StringUtils;

public class AbsBaseInfo extends BaseModel implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String absName;

    /**
     * 
     */
    private String absType;

    /**
     * 
     */
    private String absCode;

    /**
     * 
     */
    private String absShortName;

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
    private String bondRating;

    /**
     * 
     */
    private String creditMeasures;

    /**
     * 
     */
    private String tradingLocation;

    /**
     * 
     */
    private String currentBondRating;

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
    private Date listingTime;

    /**
     * 
     */
    private Date interestTime;

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
    private Date dueTime;

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
    private String originalOwnerName;

    /**
     * 原始权益人所属证监局
     */
    private String originalOwnerSrb;

    /**
     * 
     */
    private String registeredPlace;

    /**
     * 
     */
    private String registrationPlace;

    /**
     * 
     */
    private String industry;

    /**
     * 
     */
    private String businessScope;

    /**
     * 
     */
    private String nature;

    /**
     * 
     */
    private String mainBusiness;

    /**
     * 
     */
    private String ifBelongsFinancial;

    /**
     * 
     */
    private String mainRating;

    /**
     * 
     */
    private String relateSrb;

    /**
     * 
     */
    private String managerName;

    /**
     * 
     */
    private String managerDisclosureSpecialist;

    /**
     * 
     */
    private String specialistContactWay;

    /**
     * 
     */
    private String managerCharger;

    /**
     * 
     */
    private String managerContactWay;

    /**
     * 
     */
    private String managerRegisteredPlace;

    /**
     * 
     */
    private String managerSrb;

    /**
     * 
     */
    private String accountingName;

    /**
     * 
     */
    private String accountingSignature;

    /**
     * 
     */
    private String lawName;

    /**
     * 
     */
    private String lawSignature;

    /**
     * 
     */
    private String ratingAgencyName;

    /**
     * 
     */
    private String ratingAgencyContactWay;

    /**
     * 
     */
    private String ratingAgencyCharge;

    /**
     * 
     */
    private String assetAppraisalAgency;

    /**
     * 
     */
    private String assetAppraisalAgencyCharge;

    /**
     * 
     */
    private String securityRate;

    /**
     * 
     */
    private String jurSrb;

    /**
     * 
     */
    private Integer editState;
    
    /**
     * 
     */
    private Integer state;

    /**
     * 
     */
    private Date noActionLetterTime;

    /**
     * 
     */
    private String serialNumber;

    /**
     * 关联子产品代码
     */
    private String childCode;

    /**
     * 托管机构名称
     */
    private String custodian;

    /**
     * 其他资信评估机构名称
     */
    private String otherRatingAgencyName;

    /**
     * abs_base_info
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbsName() {
        return absName;
    }

    public void setAbsName(String absName) {
        this.absName = absName == null ? null : absName.trim();
    }

    public String getAbsType() {
        return absType;
    }

    public void setAbsType(String absType) {
        this.absType = absType == null ? null : absType.trim();
    }

    public String getAbsCode() {
        return absCode;
    }

    public void setAbsCode(String absCode) {
        this.absCode = absCode == null ? null : absCode.trim();
    }

    public String getAbsShortName() {
        return absShortName;
    }

    public void setAbsShortName(String absShortName) {
        this.absShortName = absShortName == null ? null : absShortName.trim();
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

    public String getBondRating() {
        return bondRating;
    }

    public void setBondRating(String bondRating) {
        this.bondRating = bondRating == null ? null : bondRating.trim();
    }

    public String getCreditMeasures() {
        return creditMeasures;
    }

    public void setCreditMeasures(String creditMeasures) {
        this.creditMeasures = creditMeasures == null ? null : creditMeasures.trim();
    }

    public String getTradingLocation() {
        return tradingLocation;
    }

    public void setTradingLocation(String tradingLocation) {
        this.tradingLocation = tradingLocation == null ? null : tradingLocation.trim();
    }

    public String getCurrentBondRating() {
        return currentBondRating;
    }

    public void setCurrentBondRating(String currentBondRating) {
        this.currentBondRating = currentBondRating == null ? null : currentBondRating.trim();
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
    
    public Date getListingTime() {
		return listingTime;
	}

	public void setListingTime(Date listingTime) {
		this.listingTime = listingTime;
	}

	public Date getInterestTime() {
        return interestTime;
    }

    public void setInterestTime(Date interestTime) {
        this.interestTime = interestTime;
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

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
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

    public String getOriginalOwnerName() {
        return originalOwnerName;
    }

    public void setOriginalOwnerName(String originalOwnerName) {
        this.originalOwnerName = originalOwnerName == null ? null : originalOwnerName.trim();
    }

    public String getOriginalOwnerSrb() {
        return originalOwnerSrb;
    }

    public void setOriginalOwnerSrb(String originalOwnerSrb) {
        this.originalOwnerSrb = originalOwnerSrb == null ? null : originalOwnerSrb.trim();
    }

    public String getRegisteredPlace() {
        return registeredPlace;
    }

    public void setRegisteredPlace(String registeredPlace) {
        this.registeredPlace = registeredPlace == null ? null : registeredPlace.trim();
    }

    public String getRegistrationPlace() {
        return registrationPlace;
    }

    public void setRegistrationPlace(String registrationPlace) {
        this.registrationPlace = registrationPlace == null ? null : registrationPlace.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness == null ? null : mainBusiness.trim();
    }

    public String getIfBelongsFinancial() {
        return ifBelongsFinancial;
    }

    public void setIfBelongsFinancial(String ifBelongsFinancial) {
        this.ifBelongsFinancial = ifBelongsFinancial == null ? null : ifBelongsFinancial.trim();
    }

    public String getMainRating() {
        return mainRating;
    }

    public void setMainRating(String mainRating) {
        this.mainRating = mainRating == null ? null : mainRating.trim();
    }

    public String getRelateSrb() {
        return relateSrb;
    }

    public void setRelateSrb(String relateSrb) {
        this.relateSrb = relateSrb == null ? null : relateSrb.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerDisclosureSpecialist() {
        return managerDisclosureSpecialist;
    }

    public void setManagerDisclosureSpecialist(String managerDisclosureSpecialist) {
        this.managerDisclosureSpecialist = managerDisclosureSpecialist == null ? null : managerDisclosureSpecialist.trim();
    }

    public String getSpecialistContactWay() {
        return specialistContactWay;
    }

    public void setSpecialistContactWay(String specialistContactWay) {
        this.specialistContactWay = specialistContactWay == null ? null : specialistContactWay.trim();
    }

    public String getManagerCharger() {
        return managerCharger;
    }

    public void setManagerCharger(String managerCharger) {
        this.managerCharger = managerCharger == null ? null : managerCharger.trim();
    }

    public String getManagerContactWay() {
        return managerContactWay;
    }

    public void setManagerContactWay(String managerContactWay) {
        this.managerContactWay = managerContactWay == null ? null : managerContactWay.trim();
    }

    public String getManagerRegisteredPlace() {
        return managerRegisteredPlace;
    }

    public void setManagerRegisteredPlace(String managerRegisteredPlace) {
        this.managerRegisteredPlace = managerRegisteredPlace == null ? null : managerRegisteredPlace.trim();
    }

    public String getManagerSrb() {
        return managerSrb;
    }

    public void setManagerSrb(String managerSrb) {
        this.managerSrb = managerSrb == null ? null : managerSrb.trim();
    }

    public String getAccountingName() {
        return accountingName;
    }

    public void setAccountingName(String accountingName) {
        this.accountingName = accountingName == null ? null : accountingName.trim();
    }

    public String getAccountingSignature() {
        return accountingSignature;
    }

    public void setAccountingSignature(String accountingSignature) {
        this.accountingSignature = accountingSignature == null ? null : accountingSignature.trim();
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName == null ? null : lawName.trim();
    }

    public String getLawSignature() {
        return lawSignature;
    }

    public void setLawSignature(String lawSignature) {
        this.lawSignature = lawSignature == null ? null : lawSignature.trim();
    }

    public String getRatingAgencyName() {
        return ratingAgencyName;
    }

    public void setRatingAgencyName(String ratingAgencyName) {
        this.ratingAgencyName = ratingAgencyName == null ? null : ratingAgencyName.trim();
    }

    public String getRatingAgencyContactWay() {
        return ratingAgencyContactWay;
    }

    public void setRatingAgencyContactWay(String ratingAgencyContactWay) {
        this.ratingAgencyContactWay = ratingAgencyContactWay == null ? null : ratingAgencyContactWay.trim();
    }

    public String getRatingAgencyCharge() {
        return ratingAgencyCharge;
    }

    public void setRatingAgencyCharge(String ratingAgencyCharge) {
        this.ratingAgencyCharge = ratingAgencyCharge == null ? null : ratingAgencyCharge.trim();
    }

    public String getAssetAppraisalAgency() {
        return assetAppraisalAgency;
    }

    public void setAssetAppraisalAgency(String assetAppraisalAgency) {
        this.assetAppraisalAgency = assetAppraisalAgency == null ? null : assetAppraisalAgency.trim();
    }

    public String getAssetAppraisalAgencyCharge() {
        return assetAppraisalAgencyCharge;
    }

    public void setAssetAppraisalAgencyCharge(String assetAppraisalAgencyCharge) {
        this.assetAppraisalAgencyCharge = assetAppraisalAgencyCharge == null ? null : assetAppraisalAgencyCharge.trim();
    }

    public String getSecurityRate() {
        return securityRate;
    }

    public void setSecurityRate(String securityRate) {
        this.securityRate = securityRate == null ? null : securityRate.trim();
    }

    public String getJurSrb() {
        return jurSrb;
    }

    public void setJurSrb(String jurSrb) {
        this.jurSrb = jurSrb == null ? null : jurSrb.trim();
    }
    
    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getEditState() {
        return editState;
    }

    public void setEditState(Integer editState) {
        this.editState = editState;
    }

    public Date getNoActionLetterTime() {
        return noActionLetterTime;
    }

    public void setNoActionLetterTime(Date noActionLetterTime) {
        this.noActionLetterTime = noActionLetterTime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getChildCode() {
        return childCode;
    }

    public void setChildCode(String childCode) {
        this.childCode = childCode == null ? null : childCode.trim();
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian == null ? null : custodian.trim();
    }

    public String getOtherRatingAgencyName() {
        return otherRatingAgencyName;
    }

    public void setOtherRatingAgencyName(String otherRatingAgencyName) {
        this.otherRatingAgencyName = otherRatingAgencyName == null ? null : otherRatingAgencyName.trim();
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
        sb.append(StringUtils.transfDeal(absCode)).append(separator);
        sb.append(StringUtils.transfDeal(absShortName)).append(separator);
        sb.append(StringUtils.transfDeal(absName)).append(separator);
        sb.append("0201").append(separator);
        //sb.append(StringUtils.transfDeal(absType)).append(separator);
        //此字段暂定报送为空
        sb.append("").append(separator);
        sb.append(StringUtils.transfDeal(bondRating)).append(separator);
        sb.append(StringUtils.transfDeal(trem)).append(separator);
        sb.append(StringUtils.transfDeal(DateUtils.dataToString(noActionLetterTime,DATE_PATTERN.YYYYMMDD))).append(separator);
        sb.append(StringUtils.transfDeal(DateUtils.dataToString(listingTime,DATE_PATTERN.YYYYMMDD))).append(separator);
        sb.append(StringUtils.transfDeal(DateUtils.dataToString(interestTime,DATE_PATTERN.YYYYMMDD))).append(separator);
        sb.append(StringUtils.transfDeal(DateUtils.dataToString(dueTime,DATE_PATTERN.YYYYMMDD)));
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
        AbsBaseInfo other = (AbsBaseInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAbsName() == null ? other.getAbsName() == null : this.getAbsName().equals(other.getAbsName()))
            && (this.getAbsType() == null ? other.getAbsType() == null : this.getAbsType().equals(other.getAbsType()))
            && (this.getAbsCode() == null ? other.getAbsCode() == null : this.getAbsCode().equals(other.getAbsCode()))
            && (this.getAbsShortName() == null ? other.getAbsShortName() == null : this.getAbsShortName().equals(other.getAbsShortName()))
            && (this.getTrem() == null ? other.getTrem() == null : this.getTrem().equals(other.getTrem()))
            && (this.getTremRemark() == null ? other.getTremRemark() == null : this.getTremRemark().equals(other.getTremRemark()))
            && (this.getBondRating() == null ? other.getBondRating() == null : this.getBondRating().equals(other.getBondRating()))
            && (this.getCreditMeasures() == null ? other.getCreditMeasures() == null : this.getCreditMeasures().equals(other.getCreditMeasures()))
            && (this.getTradingLocation() == null ? other.getTradingLocation() == null : this.getTradingLocation().equals(other.getTradingLocation()))
            && (this.getCurrentBondRating() == null ? other.getCurrentBondRating() == null : this.getCurrentBondRating().equals(other.getCurrentBondRating()))
            && (this.getIssueRate() == null ? other.getIssueRate() == null : this.getIssueRate().equals(other.getIssueRate()))
            && (this.getIssueTime() == null ? other.getIssueTime() == null : this.getIssueTime().equals(other.getIssueTime()))
            && (this.getInterestTime() == null ? other.getInterestTime() == null : this.getInterestTime().equals(other.getInterestTime()))
            && (this.getDebtAccount() == null ? other.getDebtAccount() == null : this.getDebtAccount().equals(other.getDebtAccount()))
            && (this.getIndividualInvestorAccount() == null ? other.getIndividualInvestorAccount() == null : this.getIndividualInvestorAccount().equals(other.getIndividualInvestorAccount()))
            && (this.getPersonalDebtRate() == null ? other.getPersonalDebtRate() == null : this.getPersonalDebtRate().equals(other.getPersonalDebtRate()))
            && (this.getCurrentRate() == null ? other.getCurrentRate() == null : this.getCurrentRate().equals(other.getCurrentRate()))
            && (this.getDueTime() == null ? other.getDueTime() == null : this.getDueTime().equals(other.getDueTime()))
            && (this.getProperManagement() == null ? other.getProperManagement() == null : this.getProperManagement().equals(other.getProperManagement()))
            && (this.getProperManagementTime() == null ? other.getProperManagementTime() == null : this.getProperManagementTime().equals(other.getProperManagementTime()))
            && (this.getOriginalOwnerName() == null ? other.getOriginalOwnerName() == null : this.getOriginalOwnerName().equals(other.getOriginalOwnerName()))
            && (this.getOriginalOwnerSrb() == null ? other.getOriginalOwnerSrb() == null : this.getOriginalOwnerSrb().equals(other.getOriginalOwnerSrb()))
            && (this.getRegisteredPlace() == null ? other.getRegisteredPlace() == null : this.getRegisteredPlace().equals(other.getRegisteredPlace()))
            && (this.getRegistrationPlace() == null ? other.getRegistrationPlace() == null : this.getRegistrationPlace().equals(other.getRegistrationPlace()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getBusinessScope() == null ? other.getBusinessScope() == null : this.getBusinessScope().equals(other.getBusinessScope()))
            && (this.getNature() == null ? other.getNature() == null : this.getNature().equals(other.getNature()))
            && (this.getMainBusiness() == null ? other.getMainBusiness() == null : this.getMainBusiness().equals(other.getMainBusiness()))
            && (this.getIfBelongsFinancial() == null ? other.getIfBelongsFinancial() == null : this.getIfBelongsFinancial().equals(other.getIfBelongsFinancial()))
            && (this.getMainRating() == null ? other.getMainRating() == null : this.getMainRating().equals(other.getMainRating()))
            && (this.getRelateSrb() == null ? other.getRelateSrb() == null : this.getRelateSrb().equals(other.getRelateSrb()))
            && (this.getManagerName() == null ? other.getManagerName() == null : this.getManagerName().equals(other.getManagerName()))
            && (this.getManagerDisclosureSpecialist() == null ? other.getManagerDisclosureSpecialist() == null : this.getManagerDisclosureSpecialist().equals(other.getManagerDisclosureSpecialist()))
            && (this.getSpecialistContactWay() == null ? other.getSpecialistContactWay() == null : this.getSpecialistContactWay().equals(other.getSpecialistContactWay()))
            && (this.getManagerCharger() == null ? other.getManagerCharger() == null : this.getManagerCharger().equals(other.getManagerCharger()))
            && (this.getManagerContactWay() == null ? other.getManagerContactWay() == null : this.getManagerContactWay().equals(other.getManagerContactWay()))
            && (this.getManagerRegisteredPlace() == null ? other.getManagerRegisteredPlace() == null : this.getManagerRegisteredPlace().equals(other.getManagerRegisteredPlace()))
            && (this.getManagerSrb() == null ? other.getManagerSrb() == null : this.getManagerSrb().equals(other.getManagerSrb()))
            && (this.getAccountingName() == null ? other.getAccountingName() == null : this.getAccountingName().equals(other.getAccountingName()))
            && (this.getAccountingSignature() == null ? other.getAccountingSignature() == null : this.getAccountingSignature().equals(other.getAccountingSignature()))
            && (this.getLawName() == null ? other.getLawName() == null : this.getLawName().equals(other.getLawName()))
            && (this.getLawSignature() == null ? other.getLawSignature() == null : this.getLawSignature().equals(other.getLawSignature()))
            && (this.getRatingAgencyName() == null ? other.getRatingAgencyName() == null : this.getRatingAgencyName().equals(other.getRatingAgencyName()))
            && (this.getRatingAgencyContactWay() == null ? other.getRatingAgencyContactWay() == null : this.getRatingAgencyContactWay().equals(other.getRatingAgencyContactWay()))
            && (this.getRatingAgencyCharge() == null ? other.getRatingAgencyCharge() == null : this.getRatingAgencyCharge().equals(other.getRatingAgencyCharge()))
            && (this.getAssetAppraisalAgency() == null ? other.getAssetAppraisalAgency() == null : this.getAssetAppraisalAgency().equals(other.getAssetAppraisalAgency()))
            && (this.getAssetAppraisalAgencyCharge() == null ? other.getAssetAppraisalAgencyCharge() == null : this.getAssetAppraisalAgencyCharge().equals(other.getAssetAppraisalAgencyCharge()))
            && (this.getSecurityRate() == null ? other.getSecurityRate() == null : this.getSecurityRate().equals(other.getSecurityRate()))
            && (this.getJurSrb() == null ? other.getJurSrb() == null : this.getJurSrb().equals(other.getJurSrb()))
            && (this.getEditState() == null ? other.getEditState() == null : this.getEditState().equals(other.getEditState()))
            && (this.getNoActionLetterTime() == null ? other.getNoActionLetterTime() == null : this.getNoActionLetterTime().equals(other.getNoActionLetterTime()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getChildCode() == null ? other.getChildCode() == null : this.getChildCode().equals(other.getChildCode()))
            && (this.getCustodian() == null ? other.getCustodian() == null : this.getCustodian().equals(other.getCustodian()))
            && (this.getOtherRatingAgencyName() == null ? other.getOtherRatingAgencyName() == null : this.getOtherRatingAgencyName().equals(other.getOtherRatingAgencyName()));
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
        result = prime * result + ((getAbsName() == null) ? 0 : getAbsName().hashCode());
        result = prime * result + ((getAbsType() == null) ? 0 : getAbsType().hashCode());
        result = prime * result + ((getAbsCode() == null) ? 0 : getAbsCode().hashCode());
        result = prime * result + ((getAbsShortName() == null) ? 0 : getAbsShortName().hashCode());
        result = prime * result + ((getTrem() == null) ? 0 : getTrem().hashCode());
        result = prime * result + ((getTremRemark() == null) ? 0 : getTremRemark().hashCode());
        result = prime * result + ((getBondRating() == null) ? 0 : getBondRating().hashCode());
        result = prime * result + ((getCreditMeasures() == null) ? 0 : getCreditMeasures().hashCode());
        result = prime * result + ((getTradingLocation() == null) ? 0 : getTradingLocation().hashCode());
        result = prime * result + ((getCurrentBondRating() == null) ? 0 : getCurrentBondRating().hashCode());
        result = prime * result + ((getIssueRate() == null) ? 0 : getIssueRate().hashCode());
        result = prime * result + ((getIssueTime() == null) ? 0 : getIssueTime().hashCode());
        result = prime * result + ((getInterestTime() == null) ? 0 : getInterestTime().hashCode());
        result = prime * result + ((getDebtAccount() == null) ? 0 : getDebtAccount().hashCode());
        result = prime * result + ((getIndividualInvestorAccount() == null) ? 0 : getIndividualInvestorAccount().hashCode());
        result = prime * result + ((getPersonalDebtRate() == null) ? 0 : getPersonalDebtRate().hashCode());
        result = prime * result + ((getCurrentRate() == null) ? 0 : getCurrentRate().hashCode());
        result = prime * result + ((getDueTime() == null) ? 0 : getDueTime().hashCode());
        result = prime * result + ((getProperManagement() == null) ? 0 : getProperManagement().hashCode());
        result = prime * result + ((getProperManagementTime() == null) ? 0 : getProperManagementTime().hashCode());
        result = prime * result + ((getOriginalOwnerName() == null) ? 0 : getOriginalOwnerName().hashCode());
        result = prime * result + ((getOriginalOwnerSrb() == null) ? 0 : getOriginalOwnerSrb().hashCode());
        result = prime * result + ((getRegisteredPlace() == null) ? 0 : getRegisteredPlace().hashCode());
        result = prime * result + ((getRegistrationPlace() == null) ? 0 : getRegistrationPlace().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getBusinessScope() == null) ? 0 : getBusinessScope().hashCode());
        result = prime * result + ((getNature() == null) ? 0 : getNature().hashCode());
        result = prime * result + ((getMainBusiness() == null) ? 0 : getMainBusiness().hashCode());
        result = prime * result + ((getIfBelongsFinancial() == null) ? 0 : getIfBelongsFinancial().hashCode());
        result = prime * result + ((getMainRating() == null) ? 0 : getMainRating().hashCode());
        result = prime * result + ((getRelateSrb() == null) ? 0 : getRelateSrb().hashCode());
        result = prime * result + ((getManagerName() == null) ? 0 : getManagerName().hashCode());
        result = prime * result + ((getManagerDisclosureSpecialist() == null) ? 0 : getManagerDisclosureSpecialist().hashCode());
        result = prime * result + ((getSpecialistContactWay() == null) ? 0 : getSpecialistContactWay().hashCode());
        result = prime * result + ((getManagerCharger() == null) ? 0 : getManagerCharger().hashCode());
        result = prime * result + ((getManagerContactWay() == null) ? 0 : getManagerContactWay().hashCode());
        result = prime * result + ((getManagerRegisteredPlace() == null) ? 0 : getManagerRegisteredPlace().hashCode());
        result = prime * result + ((getManagerSrb() == null) ? 0 : getManagerSrb().hashCode());
        result = prime * result + ((getAccountingName() == null) ? 0 : getAccountingName().hashCode());
        result = prime * result + ((getAccountingSignature() == null) ? 0 : getAccountingSignature().hashCode());
        result = prime * result + ((getLawName() == null) ? 0 : getLawName().hashCode());
        result = prime * result + ((getLawSignature() == null) ? 0 : getLawSignature().hashCode());
        result = prime * result + ((getRatingAgencyName() == null) ? 0 : getRatingAgencyName().hashCode());
        result = prime * result + ((getRatingAgencyContactWay() == null) ? 0 : getRatingAgencyContactWay().hashCode());
        result = prime * result + ((getRatingAgencyCharge() == null) ? 0 : getRatingAgencyCharge().hashCode());
        result = prime * result + ((getAssetAppraisalAgency() == null) ? 0 : getAssetAppraisalAgency().hashCode());
        result = prime * result + ((getAssetAppraisalAgencyCharge() == null) ? 0 : getAssetAppraisalAgencyCharge().hashCode());
        result = prime * result + ((getSecurityRate() == null) ? 0 : getSecurityRate().hashCode());
        result = prime * result + ((getJurSrb() == null) ? 0 : getJurSrb().hashCode());
        result = prime * result + ((getEditState() == null) ? 0 : getEditState().hashCode());
        result = prime * result + ((getNoActionLetterTime() == null) ? 0 : getNoActionLetterTime().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getChildCode() == null) ? 0 : getChildCode().hashCode());
        result = prime * result + ((getCustodian() == null) ? 0 : getCustodian().hashCode());
        result = prime * result + ((getOtherRatingAgencyName() == null) ? 0 : getOtherRatingAgencyName().hashCode());
        return result;
    }
}