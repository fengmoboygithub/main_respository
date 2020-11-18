/*
*
* RiskBreachCauseExample.java
*                    中证技术公司
* @date 2019-09-16
*/
package com.company.one.riskbreachcause.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.base.example.BaseExample;

public class RiskBreachCauseExample extends BaseExample implements Serializable {
    /**
     * risk_breach_cause
     */
    protected String orderByClause;

    /**
     * risk_breach_cause
     */
    protected boolean distinct;

    /**
     * risk_breach_cause
     */
    protected List<Criteria> oredCriteria;

    /**
     * risk_breach_cause
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public RiskBreachCauseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * risk_breach_cause 2019-09-16
     */
    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        public void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNull() {
            addCriterion("info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Integer value) {
            addCriterion("info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Integer value) {
            addCriterion("info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Integer value) {
            addCriterion("info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Integer value) {
            addCriterion("info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Integer> values) {
            addCriterion("info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Integer> values) {
            addCriterion("info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("info_id not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andBreachCauseIsNull() {
            addCriterion("breach_cause is null");
            return (Criteria) this;
        }

        public Criteria andBreachCauseIsNotNull() {
            addCriterion("breach_cause is not null");
            return (Criteria) this;
        }

        public Criteria andBreachCauseEqualTo(String value) {
            addCriterion("breach_cause =", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseNotEqualTo(String value) {
            addCriterion("breach_cause <>", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseGreaterThan(String value) {
            addCriterion("breach_cause >", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseGreaterThanOrEqualTo(String value) {
            addCriterion("breach_cause >=", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseLessThan(String value) {
            addCriterion("breach_cause <", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseLessThanOrEqualTo(String value) {
            addCriterion("breach_cause <=", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseLike(String value) {
            addCriterion("breach_cause like", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseNotLike(String value) {
            addCriterion("breach_cause not like", value, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseIn(List<String> values) {
            addCriterion("breach_cause in", values, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseNotIn(List<String> values) {
            addCriterion("breach_cause not in", values, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseBetween(String value1, String value2) {
            addCriterion("breach_cause between", value1, value2, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachCauseNotBetween(String value1, String value2) {
            addCriterion("breach_cause not between", value1, value2, "breachCause");
            return (Criteria) this;
        }

        public Criteria andBreachBatureIsNull() {
            addCriterion("breach_bature is null");
            return (Criteria) this;
        }

        public Criteria andBreachBatureIsNotNull() {
            addCriterion("breach_bature is not null");
            return (Criteria) this;
        }

        public Criteria andBreachBatureEqualTo(String value) {
            addCriterion("breach_bature =", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureNotEqualTo(String value) {
            addCriterion("breach_bature <>", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureGreaterThan(String value) {
            addCriterion("breach_bature >", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureGreaterThanOrEqualTo(String value) {
            addCriterion("breach_bature >=", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureLessThan(String value) {
            addCriterion("breach_bature <", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureLessThanOrEqualTo(String value) {
            addCriterion("breach_bature <=", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureLike(String value) {
            addCriterion("breach_bature like", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureNotLike(String value) {
            addCriterion("breach_bature not like", value, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureIn(List<String> values) {
            addCriterion("breach_bature in", values, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureNotIn(List<String> values) {
            addCriterion("breach_bature not in", values, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureBetween(String value1, String value2) {
            addCriterion("breach_bature between", value1, value2, "breachBature");
            return (Criteria) this;
        }

        public Criteria andBreachBatureNotBetween(String value1, String value2) {
            addCriterion("breach_bature not between", value1, value2, "breachBature");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationIsNull() {
            addCriterion("risk_progress_situation is null");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationIsNotNull() {
            addCriterion("risk_progress_situation is not null");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationEqualTo(String value) {
            addCriterion("risk_progress_situation =", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationNotEqualTo(String value) {
            addCriterion("risk_progress_situation <>", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationGreaterThan(String value) {
            addCriterion("risk_progress_situation >", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationGreaterThanOrEqualTo(String value) {
            addCriterion("risk_progress_situation >=", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationLessThan(String value) {
            addCriterion("risk_progress_situation <", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationLessThanOrEqualTo(String value) {
            addCriterion("risk_progress_situation <=", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationLike(String value) {
            addCriterion("risk_progress_situation like", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationNotLike(String value) {
            addCriterion("risk_progress_situation not like", value, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationIn(List<String> values) {
            addCriterion("risk_progress_situation in", values, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationNotIn(List<String> values) {
            addCriterion("risk_progress_situation not in", values, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationBetween(String value1, String value2) {
            addCriterion("risk_progress_situation between", value1, value2, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andRiskProgressSituationNotBetween(String value1, String value2) {
            addCriterion("risk_progress_situation not between", value1, value2, "riskProgressSituation");
            return (Criteria) this;
        }

        public Criteria andBreachTimeIsNull() {
            addCriterion("breach_time is null");
            return (Criteria) this;
        }

        public Criteria andBreachTimeIsNotNull() {
            addCriterion("breach_time is not null");
            return (Criteria) this;
        }

        public Criteria andBreachTimeEqualTo(Date value) {
            addCriterion("breach_time =", value, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeNotEqualTo(Date value) {
            addCriterion("breach_time <>", value, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeGreaterThan(Date value) {
            addCriterion("breach_time >", value, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("breach_time >=", value, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeLessThan(Date value) {
            addCriterion("breach_time <", value, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeLessThanOrEqualTo(Date value) {
            addCriterion("breach_time <=", value, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeIn(List<Date> values) {
            addCriterion("breach_time in", values, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeNotIn(List<Date> values) {
            addCriterion("breach_time not in", values, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeBetween(Date value1, Date value2) {
            addCriterion("breach_time between", value1, value2, "breachTime");
            return (Criteria) this;
        }

        public Criteria andBreachTimeNotBetween(Date value1, Date value2) {
            addCriterion("breach_time not between", value1, value2, "breachTime");
            return (Criteria) this;
        }

        public Criteria andPaidAmountIsNull() {
            addCriterion("paid_amount is null");
            return (Criteria) this;
        }

        public Criteria andPaidAmountIsNotNull() {
            addCriterion("paid_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPaidAmountEqualTo(String value) {
            addCriterion("paid_amount =", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountNotEqualTo(String value) {
            addCriterion("paid_amount <>", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountGreaterThan(String value) {
            addCriterion("paid_amount >", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountGreaterThanOrEqualTo(String value) {
            addCriterion("paid_amount >=", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountLessThan(String value) {
            addCriterion("paid_amount <", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountLessThanOrEqualTo(String value) {
            addCriterion("paid_amount <=", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountLike(String value) {
            addCriterion("paid_amount like", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountNotLike(String value) {
            addCriterion("paid_amount not like", value, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountIn(List<String> values) {
            addCriterion("paid_amount in", values, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountNotIn(List<String> values) {
            addCriterion("paid_amount not in", values, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountBetween(String value1, String value2) {
            addCriterion("paid_amount between", value1, value2, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmountNotBetween(String value1, String value2) {
            addCriterion("paid_amount not between", value1, value2, "paidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountIsNull() {
            addCriterion("unpaid_amount is null");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountIsNotNull() {
            addCriterion("unpaid_amount is not null");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountEqualTo(String value) {
            addCriterion("unpaid_amount =", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountNotEqualTo(String value) {
            addCriterion("unpaid_amount <>", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountGreaterThan(String value) {
            addCriterion("unpaid_amount >", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountGreaterThanOrEqualTo(String value) {
            addCriterion("unpaid_amount >=", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountLessThan(String value) {
            addCriterion("unpaid_amount <", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountLessThanOrEqualTo(String value) {
            addCriterion("unpaid_amount <=", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountLike(String value) {
            addCriterion("unpaid_amount like", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountNotLike(String value) {
            addCriterion("unpaid_amount not like", value, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountIn(List<String> values) {
            addCriterion("unpaid_amount in", values, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountNotIn(List<String> values) {
            addCriterion("unpaid_amount not in", values, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountBetween(String value1, String value2) {
            addCriterion("unpaid_amount between", value1, value2, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andUnpaidAmountNotBetween(String value1, String value2) {
            addCriterion("unpaid_amount not between", value1, value2, "unpaidAmount");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeIsNull() {
            addCriterion("all_paid_time is null");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeIsNotNull() {
            addCriterion("all_paid_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeEqualTo(Date value) {
            addCriterion("all_paid_time =", value, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeNotEqualTo(Date value) {
            addCriterion("all_paid_time <>", value, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeGreaterThan(Date value) {
            addCriterion("all_paid_time >", value, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("all_paid_time >=", value, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeLessThan(Date value) {
            addCriterion("all_paid_time <", value, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeLessThanOrEqualTo(Date value) {
            addCriterion("all_paid_time <=", value, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeIn(List<Date> values) {
            addCriterion("all_paid_time in", values, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeNotIn(List<Date> values) {
            addCriterion("all_paid_time not in", values, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeBetween(Date value1, Date value2) {
            addCriterion("all_paid_time between", value1, value2, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andAllPaidTimeNotBetween(Date value1, Date value2) {
            addCriterion("all_paid_time not between", value1, value2, "allPaidTime");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationIsNull() {
            addCriterion("supervision_situation is null");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationIsNotNull() {
            addCriterion("supervision_situation is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationEqualTo(String value) {
            addCriterion("supervision_situation =", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationNotEqualTo(String value) {
            addCriterion("supervision_situation <>", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationGreaterThan(String value) {
            addCriterion("supervision_situation >", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationGreaterThanOrEqualTo(String value) {
            addCriterion("supervision_situation >=", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationLessThan(String value) {
            addCriterion("supervision_situation <", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationLessThanOrEqualTo(String value) {
            addCriterion("supervision_situation <=", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationLike(String value) {
            addCriterion("supervision_situation like", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationNotLike(String value) {
            addCriterion("supervision_situation not like", value, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationIn(List<String> values) {
            addCriterion("supervision_situation in", values, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationNotIn(List<String> values) {
            addCriterion("supervision_situation not in", values, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationBetween(String value1, String value2) {
            addCriterion("supervision_situation between", value1, value2, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andSupervisionSituationNotBetween(String value1, String value2) {
            addCriterion("supervision_situation not between", value1, value2, "supervisionSituation");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     *  * risk_breach_cause
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * risk_breach_cause 2019-09-16
     */
    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}