/*
*
* AbsBaseInfoExample.java
*                    中证技术公司
* @date 2019-09-16
*/
package com.company.one.absinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.base.example.BaseExample;

public class AbsBaseInfoExample extends BaseExample implements Serializable {
    /**
     * abs_base_info
     */
    protected String orderByClause;

    /**
     * abs_base_info
     */
    protected boolean distinct;

    /**
     * abs_base_info
     */
    protected List<Criteria> oredCriteria;

    /**
     * abs_base_info
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-09-16
     */
    public AbsBaseInfoExample() {
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
     * abs_base_info 2019-09-16
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

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public void addCriterion(String condition, Object value, String property) {
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

        public Criteria andAbsNameIsNull() {
            addCriterion("abs_name is null");
            return (Criteria) this;
        }

        public Criteria andAbsNameIsNotNull() {
            addCriterion("abs_name is not null");
            return (Criteria) this;
        }

        public Criteria andAbsNameEqualTo(String value) {
            addCriterion("abs_name =", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameNotEqualTo(String value) {
            addCriterion("abs_name <>", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameGreaterThan(String value) {
            addCriterion("abs_name >", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameGreaterThanOrEqualTo(String value) {
            addCriterion("abs_name >=", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameLessThan(String value) {
            addCriterion("abs_name <", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameLessThanOrEqualTo(String value) {
            addCriterion("abs_name <=", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameLike(String value) {
            addCriterion("abs_name like", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameNotLike(String value) {
            addCriterion("abs_name not like", value, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameIn(List<String> values) {
            addCriterion("abs_name in", values, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameNotIn(List<String> values) {
            addCriterion("abs_name not in", values, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameBetween(String value1, String value2) {
            addCriterion("abs_name between", value1, value2, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsNameNotBetween(String value1, String value2) {
            addCriterion("abs_name not between", value1, value2, "absName");
            return (Criteria) this;
        }

        public Criteria andAbsTypeIsNull() {
            addCriterion("abs_type is null");
            return (Criteria) this;
        }

        public Criteria andAbsTypeIsNotNull() {
            addCriterion("abs_type is not null");
            return (Criteria) this;
        }

        public Criteria andAbsTypeEqualTo(String value) {
            addCriterion("abs_type =", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeNotEqualTo(String value) {
            addCriterion("abs_type <>", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeGreaterThan(String value) {
            addCriterion("abs_type >", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("abs_type >=", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeLessThan(String value) {
            addCriterion("abs_type <", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeLessThanOrEqualTo(String value) {
            addCriterion("abs_type <=", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeLike(String value) {
            addCriterion("abs_type like", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeNotLike(String value) {
            addCriterion("abs_type not like", value, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeIn(List<String> values) {
            addCriterion("abs_type in", values, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeNotIn(List<String> values) {
            addCriterion("abs_type not in", values, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeBetween(String value1, String value2) {
            addCriterion("abs_type between", value1, value2, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsTypeNotBetween(String value1, String value2) {
            addCriterion("abs_type not between", value1, value2, "absType");
            return (Criteria) this;
        }

        public Criteria andAbsCodeIsNull() {
            addCriterion("abs_code is null");
            return (Criteria) this;
        }

        public Criteria andAbsCodeIsNotNull() {
            addCriterion("abs_code is not null");
            return (Criteria) this;
        }

        public Criteria andAbsCodeEqualTo(String value) {
            addCriterion("abs_code =", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeNotEqualTo(String value) {
            addCriterion("abs_code <>", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeGreaterThan(String value) {
            addCriterion("abs_code >", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("abs_code >=", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeLessThan(String value) {
            addCriterion("abs_code <", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeLessThanOrEqualTo(String value) {
            addCriterion("abs_code <=", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeLike(String value) {
            addCriterion("abs_code like", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeNotLike(String value) {
            addCriterion("abs_code not like", value, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeIn(List<String> values) {
            addCriterion("abs_code in", values, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeNotIn(List<String> values) {
            addCriterion("abs_code not in", values, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeBetween(String value1, String value2) {
            addCriterion("abs_code between", value1, value2, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsCodeNotBetween(String value1, String value2) {
            addCriterion("abs_code not between", value1, value2, "absCode");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameIsNull() {
            addCriterion("abs_short_name is null");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameIsNotNull() {
            addCriterion("abs_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameEqualTo(String value) {
            addCriterion("abs_short_name =", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameNotEqualTo(String value) {
            addCriterion("abs_short_name <>", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameGreaterThan(String value) {
            addCriterion("abs_short_name >", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("abs_short_name >=", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameLessThan(String value) {
            addCriterion("abs_short_name <", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameLessThanOrEqualTo(String value) {
            addCriterion("abs_short_name <=", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameLike(String value) {
            addCriterion("abs_short_name like", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameNotLike(String value) {
            addCriterion("abs_short_name not like", value, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameIn(List<String> values) {
            addCriterion("abs_short_name in", values, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameNotIn(List<String> values) {
            addCriterion("abs_short_name not in", values, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameBetween(String value1, String value2) {
            addCriterion("abs_short_name between", value1, value2, "absShortName");
            return (Criteria) this;
        }

        public Criteria andAbsShortNameNotBetween(String value1, String value2) {
            addCriterion("abs_short_name not between", value1, value2, "absShortName");
            return (Criteria) this;
        }

        public Criteria andTremIsNull() {
            addCriterion("trem is null");
            return (Criteria) this;
        }

        public Criteria andTremIsNotNull() {
            addCriterion("trem is not null");
            return (Criteria) this;
        }

        public Criteria andTremEqualTo(String value) {
            addCriterion("trem =", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremNotEqualTo(String value) {
            addCriterion("trem <>", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremGreaterThan(String value) {
            addCriterion("trem >", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremGreaterThanOrEqualTo(String value) {
            addCriterion("trem >=", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremLessThan(String value) {
            addCriterion("trem <", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremLessThanOrEqualTo(String value) {
            addCriterion("trem <=", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremLike(String value) {
            addCriterion("trem like", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremNotLike(String value) {
            addCriterion("trem not like", value, "trem");
            return (Criteria) this;
        }

        public Criteria andTremIn(List<String> values) {
            addCriterion("trem in", values, "trem");
            return (Criteria) this;
        }

        public Criteria andTremNotIn(List<String> values) {
            addCriterion("trem not in", values, "trem");
            return (Criteria) this;
        }

        public Criteria andTremBetween(String value1, String value2) {
            addCriterion("trem between", value1, value2, "trem");
            return (Criteria) this;
        }

        public Criteria andTremNotBetween(String value1, String value2) {
            addCriterion("trem not between", value1, value2, "trem");
            return (Criteria) this;
        }

        public Criteria andTremRemarkIsNull() {
            addCriterion("trem_remark is null");
            return (Criteria) this;
        }

        public Criteria andTremRemarkIsNotNull() {
            addCriterion("trem_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTremRemarkEqualTo(String value) {
            addCriterion("trem_remark =", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkNotEqualTo(String value) {
            addCriterion("trem_remark <>", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkGreaterThan(String value) {
            addCriterion("trem_remark >", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("trem_remark >=", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkLessThan(String value) {
            addCriterion("trem_remark <", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkLessThanOrEqualTo(String value) {
            addCriterion("trem_remark <=", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkLike(String value) {
            addCriterion("trem_remark like", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkNotLike(String value) {
            addCriterion("trem_remark not like", value, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkIn(List<String> values) {
            addCriterion("trem_remark in", values, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkNotIn(List<String> values) {
            addCriterion("trem_remark not in", values, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkBetween(String value1, String value2) {
            addCriterion("trem_remark between", value1, value2, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andTremRemarkNotBetween(String value1, String value2) {
            addCriterion("trem_remark not between", value1, value2, "tremRemark");
            return (Criteria) this;
        }

        public Criteria andBondRatingIsNull() {
            addCriterion("bond_rating is null");
            return (Criteria) this;
        }

        public Criteria andBondRatingIsNotNull() {
            addCriterion("bond_rating is not null");
            return (Criteria) this;
        }

        public Criteria andBondRatingEqualTo(String value) {
            addCriterion("bond_rating =", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingNotEqualTo(String value) {
            addCriterion("bond_rating <>", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingGreaterThan(String value) {
            addCriterion("bond_rating >", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingGreaterThanOrEqualTo(String value) {
            addCriterion("bond_rating >=", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingLessThan(String value) {
            addCriterion("bond_rating <", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingLessThanOrEqualTo(String value) {
            addCriterion("bond_rating <=", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingLike(String value) {
            addCriterion("bond_rating like", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingNotLike(String value) {
            addCriterion("bond_rating not like", value, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingIn(List<String> values) {
            addCriterion("bond_rating in", values, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingNotIn(List<String> values) {
            addCriterion("bond_rating not in", values, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingBetween(String value1, String value2) {
            addCriterion("bond_rating between", value1, value2, "bondRating");
            return (Criteria) this;
        }

        public Criteria andBondRatingNotBetween(String value1, String value2) {
            addCriterion("bond_rating not between", value1, value2, "bondRating");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresIsNull() {
            addCriterion("credit_measures is null");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresIsNotNull() {
            addCriterion("credit_measures is not null");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresEqualTo(String value) {
            addCriterion("credit_measures =", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresNotEqualTo(String value) {
            addCriterion("credit_measures <>", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresGreaterThan(String value) {
            addCriterion("credit_measures >", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresGreaterThanOrEqualTo(String value) {
            addCriterion("credit_measures >=", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresLessThan(String value) {
            addCriterion("credit_measures <", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresLessThanOrEqualTo(String value) {
            addCriterion("credit_measures <=", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresLike(String value) {
            addCriterion("credit_measures like", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresNotLike(String value) {
            addCriterion("credit_measures not like", value, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresIn(List<String> values) {
            addCriterion("credit_measures in", values, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresNotIn(List<String> values) {
            addCriterion("credit_measures not in", values, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresBetween(String value1, String value2) {
            addCriterion("credit_measures between", value1, value2, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andCreditMeasuresNotBetween(String value1, String value2) {
            addCriterion("credit_measures not between", value1, value2, "creditMeasures");
            return (Criteria) this;
        }

        public Criteria andTradingLocationIsNull() {
            addCriterion("trading_location is null");
            return (Criteria) this;
        }

        public Criteria andTradingLocationIsNotNull() {
            addCriterion("trading_location is not null");
            return (Criteria) this;
        }

        public Criteria andTradingLocationEqualTo(String value) {
            addCriterion("trading_location =", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationNotEqualTo(String value) {
            addCriterion("trading_location <>", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationGreaterThan(String value) {
            addCriterion("trading_location >", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationGreaterThanOrEqualTo(String value) {
            addCriterion("trading_location >=", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationLessThan(String value) {
            addCriterion("trading_location <", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationLessThanOrEqualTo(String value) {
            addCriterion("trading_location <=", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationLike(String value) {
            addCriterion("trading_location like", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationNotLike(String value) {
            addCriterion("trading_location not like", value, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationIn(List<String> values) {
            addCriterion("trading_location in", values, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationNotIn(List<String> values) {
            addCriterion("trading_location not in", values, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationBetween(String value1, String value2) {
            addCriterion("trading_location between", value1, value2, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andTradingLocationNotBetween(String value1, String value2) {
            addCriterion("trading_location not between", value1, value2, "tradingLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingIsNull() {
            addCriterion("current_bond_rating is null");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingIsNotNull() {
            addCriterion("current_bond_rating is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingEqualTo(String value) {
            addCriterion("current_bond_rating =", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingNotEqualTo(String value) {
            addCriterion("current_bond_rating <>", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingGreaterThan(String value) {
            addCriterion("current_bond_rating >", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingGreaterThanOrEqualTo(String value) {
            addCriterion("current_bond_rating >=", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingLessThan(String value) {
            addCriterion("current_bond_rating <", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingLessThanOrEqualTo(String value) {
            addCriterion("current_bond_rating <=", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingLike(String value) {
            addCriterion("current_bond_rating like", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingNotLike(String value) {
            addCriterion("current_bond_rating not like", value, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingIn(List<String> values) {
            addCriterion("current_bond_rating in", values, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingNotIn(List<String> values) {
            addCriterion("current_bond_rating not in", values, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingBetween(String value1, String value2) {
            addCriterion("current_bond_rating between", value1, value2, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andCurrentBondRatingNotBetween(String value1, String value2) {
            addCriterion("current_bond_rating not between", value1, value2, "currentBondRating");
            return (Criteria) this;
        }

        public Criteria andIssueRateIsNull() {
            addCriterion("issue_rate is null");
            return (Criteria) this;
        }

        public Criteria andIssueRateIsNotNull() {
            addCriterion("issue_rate is not null");
            return (Criteria) this;
        }

        public Criteria andIssueRateEqualTo(String value) {
            addCriterion("issue_rate =", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateNotEqualTo(String value) {
            addCriterion("issue_rate <>", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateGreaterThan(String value) {
            addCriterion("issue_rate >", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateGreaterThanOrEqualTo(String value) {
            addCriterion("issue_rate >=", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateLessThan(String value) {
            addCriterion("issue_rate <", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateLessThanOrEqualTo(String value) {
            addCriterion("issue_rate <=", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateLike(String value) {
            addCriterion("issue_rate like", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateNotLike(String value) {
            addCriterion("issue_rate not like", value, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateIn(List<String> values) {
            addCriterion("issue_rate in", values, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateNotIn(List<String> values) {
            addCriterion("issue_rate not in", values, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateBetween(String value1, String value2) {
            addCriterion("issue_rate between", value1, value2, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueRateNotBetween(String value1, String value2) {
            addCriterion("issue_rate not between", value1, value2, "issueRate");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNull() {
            addCriterion("issue_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIsNotNull() {
            addCriterion("issue_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTimeEqualTo(Date value) {
            addCriterion("issue_time =", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotEqualTo(Date value) {
            addCriterion("issue_time <>", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThan(Date value) {
            addCriterion("issue_time >", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("issue_time >=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThan(Date value) {
            addCriterion("issue_time <", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeLessThanOrEqualTo(Date value) {
            addCriterion("issue_time <=", value, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeIn(List<Date> values) {
            addCriterion("issue_time in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotIn(List<Date> values) {
            addCriterion("issue_time not in", values, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeBetween(Date value1, Date value2) {
            addCriterion("issue_time between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andIssueTimeNotBetween(Date value1, Date value2) {
            addCriterion("issue_time not between", value1, value2, "issueTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeIsNull() {
            addCriterion("interest_time is null");
            return (Criteria) this;
        }

        public Criteria andInterestTimeIsNotNull() {
            addCriterion("interest_time is not null");
            return (Criteria) this;
        }

        public Criteria andInterestTimeEqualTo(Date value) {
            addCriterion("interest_time =", value, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeNotEqualTo(Date value) {
            addCriterion("interest_time <>", value, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeGreaterThan(Date value) {
            addCriterion("interest_time >", value, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("interest_time >=", value, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeLessThan(Date value) {
            addCriterion("interest_time <", value, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeLessThanOrEqualTo(Date value) {
            addCriterion("interest_time <=", value, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeIn(List<Date> values) {
            addCriterion("interest_time in", values, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeNotIn(List<Date> values) {
            addCriterion("interest_time not in", values, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeBetween(Date value1, Date value2) {
            addCriterion("interest_time between", value1, value2, "interestTime");
            return (Criteria) this;
        }

        public Criteria andInterestTimeNotBetween(Date value1, Date value2) {
            addCriterion("interest_time not between", value1, value2, "interestTime");
            return (Criteria) this;
        }

        public Criteria andDebtAccountIsNull() {
            addCriterion("debt_account is null");
            return (Criteria) this;
        }

        public Criteria andDebtAccountIsNotNull() {
            addCriterion("debt_account is not null");
            return (Criteria) this;
        }

        public Criteria andDebtAccountEqualTo(Integer value) {
            addCriterion("debt_account =", value, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountNotEqualTo(Integer value) {
            addCriterion("debt_account <>", value, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountGreaterThan(Integer value) {
            addCriterion("debt_account >", value, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("debt_account >=", value, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountLessThan(Integer value) {
            addCriterion("debt_account <", value, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountLessThanOrEqualTo(Integer value) {
            addCriterion("debt_account <=", value, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountIn(List<Integer> values) {
            addCriterion("debt_account in", values, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountNotIn(List<Integer> values) {
            addCriterion("debt_account not in", values, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountBetween(Integer value1, Integer value2) {
            addCriterion("debt_account between", value1, value2, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andDebtAccountNotBetween(Integer value1, Integer value2) {
            addCriterion("debt_account not between", value1, value2, "debtAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountIsNull() {
            addCriterion("individual_investor_account is null");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountIsNotNull() {
            addCriterion("individual_investor_account is not null");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountEqualTo(Integer value) {
            addCriterion("individual_investor_account =", value, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountNotEqualTo(Integer value) {
            addCriterion("individual_investor_account <>", value, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountGreaterThan(Integer value) {
            addCriterion("individual_investor_account >", value, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountGreaterThanOrEqualTo(Integer value) {
            addCriterion("individual_investor_account >=", value, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountLessThan(Integer value) {
            addCriterion("individual_investor_account <", value, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountLessThanOrEqualTo(Integer value) {
            addCriterion("individual_investor_account <=", value, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountIn(List<Integer> values) {
            addCriterion("individual_investor_account in", values, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountNotIn(List<Integer> values) {
            addCriterion("individual_investor_account not in", values, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountBetween(Integer value1, Integer value2) {
            addCriterion("individual_investor_account between", value1, value2, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andIndividualInvestorAccountNotBetween(Integer value1, Integer value2) {
            addCriterion("individual_investor_account not between", value1, value2, "individualInvestorAccount");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateIsNull() {
            addCriterion("personal_debt_rate is null");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateIsNotNull() {
            addCriterion("personal_debt_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateEqualTo(String value) {
            addCriterion("personal_debt_rate =", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateNotEqualTo(String value) {
            addCriterion("personal_debt_rate <>", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateGreaterThan(String value) {
            addCriterion("personal_debt_rate >", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateGreaterThanOrEqualTo(String value) {
            addCriterion("personal_debt_rate >=", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateLessThan(String value) {
            addCriterion("personal_debt_rate <", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateLessThanOrEqualTo(String value) {
            addCriterion("personal_debt_rate <=", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateLike(String value) {
            addCriterion("personal_debt_rate like", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateNotLike(String value) {
            addCriterion("personal_debt_rate not like", value, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateIn(List<String> values) {
            addCriterion("personal_debt_rate in", values, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateNotIn(List<String> values) {
            addCriterion("personal_debt_rate not in", values, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateBetween(String value1, String value2) {
            addCriterion("personal_debt_rate between", value1, value2, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andPersonalDebtRateNotBetween(String value1, String value2) {
            addCriterion("personal_debt_rate not between", value1, value2, "personalDebtRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateIsNull() {
            addCriterion("current_rate is null");
            return (Criteria) this;
        }

        public Criteria andCurrentRateIsNotNull() {
            addCriterion("current_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentRateEqualTo(String value) {
            addCriterion("current_rate =", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateNotEqualTo(String value) {
            addCriterion("current_rate <>", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateGreaterThan(String value) {
            addCriterion("current_rate >", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateGreaterThanOrEqualTo(String value) {
            addCriterion("current_rate >=", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateLessThan(String value) {
            addCriterion("current_rate <", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateLessThanOrEqualTo(String value) {
            addCriterion("current_rate <=", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateLike(String value) {
            addCriterion("current_rate like", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateNotLike(String value) {
            addCriterion("current_rate not like", value, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateIn(List<String> values) {
            addCriterion("current_rate in", values, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateNotIn(List<String> values) {
            addCriterion("current_rate not in", values, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateBetween(String value1, String value2) {
            addCriterion("current_rate between", value1, value2, "currentRate");
            return (Criteria) this;
        }

        public Criteria andCurrentRateNotBetween(String value1, String value2) {
            addCriterion("current_rate not between", value1, value2, "currentRate");
            return (Criteria) this;
        }

        public Criteria andDueTimeIsNull() {
            addCriterion("due_time is null");
            return (Criteria) this;
        }

        public Criteria andDueTimeIsNotNull() {
            addCriterion("due_time is not null");
            return (Criteria) this;
        }

        public Criteria andDueTimeEqualTo(Date value) {
            addCriterion("due_time =", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeNotEqualTo(Date value) {
            addCriterion("due_time <>", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeGreaterThan(Date value) {
            addCriterion("due_time >", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("due_time >=", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeLessThan(Date value) {
            addCriterion("due_time <", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeLessThanOrEqualTo(Date value) {
            addCriterion("due_time <=", value, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeIn(List<Date> values) {
            addCriterion("due_time in", values, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeNotIn(List<Date> values) {
            addCriterion("due_time not in", values, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeBetween(Date value1, Date value2) {
            addCriterion("due_time between", value1, value2, "dueTime");
            return (Criteria) this;
        }

        public Criteria andDueTimeNotBetween(Date value1, Date value2) {
            addCriterion("due_time not between", value1, value2, "dueTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementIsNull() {
            addCriterion("proper_management is null");
            return (Criteria) this;
        }

        public Criteria andProperManagementIsNotNull() {
            addCriterion("proper_management is not null");
            return (Criteria) this;
        }

        public Criteria andProperManagementEqualTo(String value) {
            addCriterion("proper_management =", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementNotEqualTo(String value) {
            addCriterion("proper_management <>", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementGreaterThan(String value) {
            addCriterion("proper_management >", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementGreaterThanOrEqualTo(String value) {
            addCriterion("proper_management >=", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementLessThan(String value) {
            addCriterion("proper_management <", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementLessThanOrEqualTo(String value) {
            addCriterion("proper_management <=", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementLike(String value) {
            addCriterion("proper_management like", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementNotLike(String value) {
            addCriterion("proper_management not like", value, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementIn(List<String> values) {
            addCriterion("proper_management in", values, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementNotIn(List<String> values) {
            addCriterion("proper_management not in", values, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementBetween(String value1, String value2) {
            addCriterion("proper_management between", value1, value2, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementNotBetween(String value1, String value2) {
            addCriterion("proper_management not between", value1, value2, "properManagement");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeIsNull() {
            addCriterion("proper_management_time is null");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeIsNotNull() {
            addCriterion("proper_management_time is not null");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeEqualTo(Date value) {
            addCriterion("proper_management_time =", value, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeNotEqualTo(Date value) {
            addCriterion("proper_management_time <>", value, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeGreaterThan(Date value) {
            addCriterion("proper_management_time >", value, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("proper_management_time >=", value, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeLessThan(Date value) {
            addCriterion("proper_management_time <", value, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeLessThanOrEqualTo(Date value) {
            addCriterion("proper_management_time <=", value, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeIn(List<Date> values) {
            addCriterion("proper_management_time in", values, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeNotIn(List<Date> values) {
            addCriterion("proper_management_time not in", values, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeBetween(Date value1, Date value2) {
            addCriterion("proper_management_time between", value1, value2, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andProperManagementTimeNotBetween(Date value1, Date value2) {
            addCriterion("proper_management_time not between", value1, value2, "properManagementTime");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameIsNull() {
            addCriterion("original_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameIsNotNull() {
            addCriterion("original_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameEqualTo(String value) {
            addCriterion("original_owner_name =", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameNotEqualTo(String value) {
            addCriterion("original_owner_name <>", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameGreaterThan(String value) {
            addCriterion("original_owner_name >", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("original_owner_name >=", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameLessThan(String value) {
            addCriterion("original_owner_name <", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("original_owner_name <=", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameLike(String value) {
            addCriterion("original_owner_name like", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameNotLike(String value) {
            addCriterion("original_owner_name not like", value, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameIn(List<String> values) {
            addCriterion("original_owner_name in", values, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameNotIn(List<String> values) {
            addCriterion("original_owner_name not in", values, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameBetween(String value1, String value2) {
            addCriterion("original_owner_name between", value1, value2, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerNameNotBetween(String value1, String value2) {
            addCriterion("original_owner_name not between", value1, value2, "originalOwnerName");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbIsNull() {
            addCriterion("original_owner_srb is null");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbIsNotNull() {
            addCriterion("original_owner_srb is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbEqualTo(String value) {
            addCriterion("original_owner_srb =", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbNotEqualTo(String value) {
            addCriterion("original_owner_srb <>", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbGreaterThan(String value) {
            addCriterion("original_owner_srb >", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbGreaterThanOrEqualTo(String value) {
            addCriterion("original_owner_srb >=", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbLessThan(String value) {
            addCriterion("original_owner_srb <", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbLessThanOrEqualTo(String value) {
            addCriterion("original_owner_srb <=", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbLike(String value) {
            addCriterion("original_owner_srb like", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbNotLike(String value) {
            addCriterion("original_owner_srb not like", value, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbIn(List<String> values) {
            addCriterion("original_owner_srb in", values, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbNotIn(List<String> values) {
            addCriterion("original_owner_srb not in", values, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbBetween(String value1, String value2) {
            addCriterion("original_owner_srb between", value1, value2, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andOriginalOwnerSrbNotBetween(String value1, String value2) {
            addCriterion("original_owner_srb not between", value1, value2, "originalOwnerSrb");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceIsNull() {
            addCriterion("registered_place is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceIsNotNull() {
            addCriterion("registered_place is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceEqualTo(String value) {
            addCriterion("registered_place =", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceNotEqualTo(String value) {
            addCriterion("registered_place <>", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceGreaterThan(String value) {
            addCriterion("registered_place >", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("registered_place >=", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceLessThan(String value) {
            addCriterion("registered_place <", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceLessThanOrEqualTo(String value) {
            addCriterion("registered_place <=", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceLike(String value) {
            addCriterion("registered_place like", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceNotLike(String value) {
            addCriterion("registered_place not like", value, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceIn(List<String> values) {
            addCriterion("registered_place in", values, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceNotIn(List<String> values) {
            addCriterion("registered_place not in", values, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceBetween(String value1, String value2) {
            addCriterion("registered_place between", value1, value2, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegisteredPlaceNotBetween(String value1, String value2) {
            addCriterion("registered_place not between", value1, value2, "registeredPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceIsNull() {
            addCriterion("registration_place is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceIsNotNull() {
            addCriterion("registration_place is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceEqualTo(String value) {
            addCriterion("registration_place =", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceNotEqualTo(String value) {
            addCriterion("registration_place <>", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceGreaterThan(String value) {
            addCriterion("registration_place >", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("registration_place >=", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceLessThan(String value) {
            addCriterion("registration_place <", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceLessThanOrEqualTo(String value) {
            addCriterion("registration_place <=", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceLike(String value) {
            addCriterion("registration_place like", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceNotLike(String value) {
            addCriterion("registration_place not like", value, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceIn(List<String> values) {
            addCriterion("registration_place in", values, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceNotIn(List<String> values) {
            addCriterion("registration_place not in", values, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceBetween(String value1, String value2) {
            addCriterion("registration_place between", value1, value2, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andRegistrationPlaceNotBetween(String value1, String value2) {
            addCriterion("registration_place not between", value1, value2, "registrationPlace");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andNatureIsNull() {
            addCriterion("nature is null");
            return (Criteria) this;
        }

        public Criteria andNatureIsNotNull() {
            addCriterion("nature is not null");
            return (Criteria) this;
        }

        public Criteria andNatureEqualTo(String value) {
            addCriterion("nature =", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotEqualTo(String value) {
            addCriterion("nature <>", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThan(String value) {
            addCriterion("nature >", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThanOrEqualTo(String value) {
            addCriterion("nature >=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThan(String value) {
            addCriterion("nature <", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThanOrEqualTo(String value) {
            addCriterion("nature <=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLike(String value) {
            addCriterion("nature like", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotLike(String value) {
            addCriterion("nature not like", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureIn(List<String> values) {
            addCriterion("nature in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotIn(List<String> values) {
            addCriterion("nature not in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureBetween(String value1, String value2) {
            addCriterion("nature between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotBetween(String value1, String value2) {
            addCriterion("nature not between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIsNull() {
            addCriterion("main_business is null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIsNotNull() {
            addCriterion("main_business is not null");
            return (Criteria) this;
        }

        public Criteria andMainBusinessEqualTo(String value) {
            addCriterion("main_business =", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotEqualTo(String value) {
            addCriterion("main_business <>", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessGreaterThan(String value) {
            addCriterion("main_business >", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("main_business >=", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessLessThan(String value) {
            addCriterion("main_business <", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessLessThanOrEqualTo(String value) {
            addCriterion("main_business <=", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessLike(String value) {
            addCriterion("main_business like", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotLike(String value) {
            addCriterion("main_business not like", value, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessIn(List<String> values) {
            addCriterion("main_business in", values, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotIn(List<String> values) {
            addCriterion("main_business not in", values, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessBetween(String value1, String value2) {
            addCriterion("main_business between", value1, value2, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andMainBusinessNotBetween(String value1, String value2) {
            addCriterion("main_business not between", value1, value2, "mainBusiness");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialIsNull() {
            addCriterion("if_belongs_financial is null");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialIsNotNull() {
            addCriterion("if_belongs_financial is not null");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialEqualTo(String value) {
            addCriterion("if_belongs_financial =", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialNotEqualTo(String value) {
            addCriterion("if_belongs_financial <>", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialGreaterThan(String value) {
            addCriterion("if_belongs_financial >", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialGreaterThanOrEqualTo(String value) {
            addCriterion("if_belongs_financial >=", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialLessThan(String value) {
            addCriterion("if_belongs_financial <", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialLessThanOrEqualTo(String value) {
            addCriterion("if_belongs_financial <=", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialLike(String value) {
            addCriterion("if_belongs_financial like", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialNotLike(String value) {
            addCriterion("if_belongs_financial not like", value, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialIn(List<String> values) {
            addCriterion("if_belongs_financial in", values, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialNotIn(List<String> values) {
            addCriterion("if_belongs_financial not in", values, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialBetween(String value1, String value2) {
            addCriterion("if_belongs_financial between", value1, value2, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andIfBelongsFinancialNotBetween(String value1, String value2) {
            addCriterion("if_belongs_financial not between", value1, value2, "ifBelongsFinancial");
            return (Criteria) this;
        }

        public Criteria andMainRatingIsNull() {
            addCriterion("main_rating is null");
            return (Criteria) this;
        }

        public Criteria andMainRatingIsNotNull() {
            addCriterion("main_rating is not null");
            return (Criteria) this;
        }

        public Criteria andMainRatingEqualTo(String value) {
            addCriterion("main_rating =", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingNotEqualTo(String value) {
            addCriterion("main_rating <>", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingGreaterThan(String value) {
            addCriterion("main_rating >", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingGreaterThanOrEqualTo(String value) {
            addCriterion("main_rating >=", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingLessThan(String value) {
            addCriterion("main_rating <", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingLessThanOrEqualTo(String value) {
            addCriterion("main_rating <=", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingLike(String value) {
            addCriterion("main_rating like", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingNotLike(String value) {
            addCriterion("main_rating not like", value, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingIn(List<String> values) {
            addCriterion("main_rating in", values, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingNotIn(List<String> values) {
            addCriterion("main_rating not in", values, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingBetween(String value1, String value2) {
            addCriterion("main_rating between", value1, value2, "mainRating");
            return (Criteria) this;
        }

        public Criteria andMainRatingNotBetween(String value1, String value2) {
            addCriterion("main_rating not between", value1, value2, "mainRating");
            return (Criteria) this;
        }

        public Criteria andRelateSrbIsNull() {
            addCriterion("relate_srb is null");
            return (Criteria) this;
        }

        public Criteria andRelateSrbIsNotNull() {
            addCriterion("relate_srb is not null");
            return (Criteria) this;
        }

        public Criteria andRelateSrbEqualTo(String value) {
            addCriterion("relate_srb =", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbNotEqualTo(String value) {
            addCriterion("relate_srb <>", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbGreaterThan(String value) {
            addCriterion("relate_srb >", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbGreaterThanOrEqualTo(String value) {
            addCriterion("relate_srb >=", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbLessThan(String value) {
            addCriterion("relate_srb <", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbLessThanOrEqualTo(String value) {
            addCriterion("relate_srb <=", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbLike(String value) {
            addCriterion("relate_srb like", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbNotLike(String value) {
            addCriterion("relate_srb not like", value, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbIn(List<String> values) {
            addCriterion("relate_srb in", values, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbNotIn(List<String> values) {
            addCriterion("relate_srb not in", values, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbBetween(String value1, String value2) {
            addCriterion("relate_srb between", value1, value2, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andRelateSrbNotBetween(String value1, String value2) {
            addCriterion("relate_srb not between", value1, value2, "relateSrb");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNull() {
            addCriterion("manager_name is null");
            return (Criteria) this;
        }

        public Criteria andManagerNameIsNotNull() {
            addCriterion("manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andManagerNameEqualTo(String value) {
            addCriterion("manager_name =", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotEqualTo(String value) {
            addCriterion("manager_name <>", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThan(String value) {
            addCriterion("manager_name >", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("manager_name >=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThan(String value) {
            addCriterion("manager_name <", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLessThanOrEqualTo(String value) {
            addCriterion("manager_name <=", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameLike(String value) {
            addCriterion("manager_name like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotLike(String value) {
            addCriterion("manager_name not like", value, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameIn(List<String> values) {
            addCriterion("manager_name in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotIn(List<String> values) {
            addCriterion("manager_name not in", values, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameBetween(String value1, String value2) {
            addCriterion("manager_name between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerNameNotBetween(String value1, String value2) {
            addCriterion("manager_name not between", value1, value2, "managerName");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistIsNull() {
            addCriterion("manager_disclosure_specialist is null");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistIsNotNull() {
            addCriterion("manager_disclosure_specialist is not null");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistEqualTo(String value) {
            addCriterion("manager_disclosure_specialist =", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistNotEqualTo(String value) {
            addCriterion("manager_disclosure_specialist <>", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistGreaterThan(String value) {
            addCriterion("manager_disclosure_specialist >", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistGreaterThanOrEqualTo(String value) {
            addCriterion("manager_disclosure_specialist >=", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistLessThan(String value) {
            addCriterion("manager_disclosure_specialist <", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistLessThanOrEqualTo(String value) {
            addCriterion("manager_disclosure_specialist <=", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistLike(String value) {
            addCriterion("manager_disclosure_specialist like", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistNotLike(String value) {
            addCriterion("manager_disclosure_specialist not like", value, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistIn(List<String> values) {
            addCriterion("manager_disclosure_specialist in", values, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistNotIn(List<String> values) {
            addCriterion("manager_disclosure_specialist not in", values, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistBetween(String value1, String value2) {
            addCriterion("manager_disclosure_specialist between", value1, value2, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andManagerDisclosureSpecialistNotBetween(String value1, String value2) {
            addCriterion("manager_disclosure_specialist not between", value1, value2, "managerDisclosureSpecialist");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayIsNull() {
            addCriterion("specialist_contact_way is null");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayIsNotNull() {
            addCriterion("specialist_contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayEqualTo(String value) {
            addCriterion("specialist_contact_way =", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayNotEqualTo(String value) {
            addCriterion("specialist_contact_way <>", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayGreaterThan(String value) {
            addCriterion("specialist_contact_way >", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("specialist_contact_way >=", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayLessThan(String value) {
            addCriterion("specialist_contact_way <", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayLessThanOrEqualTo(String value) {
            addCriterion("specialist_contact_way <=", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayLike(String value) {
            addCriterion("specialist_contact_way like", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayNotLike(String value) {
            addCriterion("specialist_contact_way not like", value, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayIn(List<String> values) {
            addCriterion("specialist_contact_way in", values, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayNotIn(List<String> values) {
            addCriterion("specialist_contact_way not in", values, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayBetween(String value1, String value2) {
            addCriterion("specialist_contact_way between", value1, value2, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andSpecialistContactWayNotBetween(String value1, String value2) {
            addCriterion("specialist_contact_way not between", value1, value2, "specialistContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerChargerIsNull() {
            addCriterion("manager_charger is null");
            return (Criteria) this;
        }

        public Criteria andManagerChargerIsNotNull() {
            addCriterion("manager_charger is not null");
            return (Criteria) this;
        }

        public Criteria andManagerChargerEqualTo(String value) {
            addCriterion("manager_charger =", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerNotEqualTo(String value) {
            addCriterion("manager_charger <>", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerGreaterThan(String value) {
            addCriterion("manager_charger >", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerGreaterThanOrEqualTo(String value) {
            addCriterion("manager_charger >=", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerLessThan(String value) {
            addCriterion("manager_charger <", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerLessThanOrEqualTo(String value) {
            addCriterion("manager_charger <=", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerLike(String value) {
            addCriterion("manager_charger like", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerNotLike(String value) {
            addCriterion("manager_charger not like", value, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerIn(List<String> values) {
            addCriterion("manager_charger in", values, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerNotIn(List<String> values) {
            addCriterion("manager_charger not in", values, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerBetween(String value1, String value2) {
            addCriterion("manager_charger between", value1, value2, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerChargerNotBetween(String value1, String value2) {
            addCriterion("manager_charger not between", value1, value2, "managerCharger");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayIsNull() {
            addCriterion("manager_contact_way is null");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayIsNotNull() {
            addCriterion("manager_contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayEqualTo(String value) {
            addCriterion("manager_contact_way =", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayNotEqualTo(String value) {
            addCriterion("manager_contact_way <>", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayGreaterThan(String value) {
            addCriterion("manager_contact_way >", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("manager_contact_way >=", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayLessThan(String value) {
            addCriterion("manager_contact_way <", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayLessThanOrEqualTo(String value) {
            addCriterion("manager_contact_way <=", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayLike(String value) {
            addCriterion("manager_contact_way like", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayNotLike(String value) {
            addCriterion("manager_contact_way not like", value, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayIn(List<String> values) {
            addCriterion("manager_contact_way in", values, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayNotIn(List<String> values) {
            addCriterion("manager_contact_way not in", values, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayBetween(String value1, String value2) {
            addCriterion("manager_contact_way between", value1, value2, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerContactWayNotBetween(String value1, String value2) {
            addCriterion("manager_contact_way not between", value1, value2, "managerContactWay");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceIsNull() {
            addCriterion("manager_registered_place is null");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceIsNotNull() {
            addCriterion("manager_registered_place is not null");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceEqualTo(String value) {
            addCriterion("manager_registered_place =", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceNotEqualTo(String value) {
            addCriterion("manager_registered_place <>", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceGreaterThan(String value) {
            addCriterion("manager_registered_place >", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("manager_registered_place >=", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceLessThan(String value) {
            addCriterion("manager_registered_place <", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceLessThanOrEqualTo(String value) {
            addCriterion("manager_registered_place <=", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceLike(String value) {
            addCriterion("manager_registered_place like", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceNotLike(String value) {
            addCriterion("manager_registered_place not like", value, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceIn(List<String> values) {
            addCriterion("manager_registered_place in", values, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceNotIn(List<String> values) {
            addCriterion("manager_registered_place not in", values, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceBetween(String value1, String value2) {
            addCriterion("manager_registered_place between", value1, value2, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerRegisteredPlaceNotBetween(String value1, String value2) {
            addCriterion("manager_registered_place not between", value1, value2, "managerRegisteredPlace");
            return (Criteria) this;
        }

        public Criteria andManagerSrbIsNull() {
            addCriterion("manager_srb is null");
            return (Criteria) this;
        }

        public Criteria andManagerSrbIsNotNull() {
            addCriterion("manager_srb is not null");
            return (Criteria) this;
        }

        public Criteria andManagerSrbEqualTo(String value) {
            addCriterion("manager_srb =", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbNotEqualTo(String value) {
            addCriterion("manager_srb <>", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbGreaterThan(String value) {
            addCriterion("manager_srb >", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbGreaterThanOrEqualTo(String value) {
            addCriterion("manager_srb >=", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbLessThan(String value) {
            addCriterion("manager_srb <", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbLessThanOrEqualTo(String value) {
            addCriterion("manager_srb <=", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbLike(String value) {
            addCriterion("manager_srb like", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbNotLike(String value) {
            addCriterion("manager_srb not like", value, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbIn(List<String> values) {
            addCriterion("manager_srb in", values, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbNotIn(List<String> values) {
            addCriterion("manager_srb not in", values, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbBetween(String value1, String value2) {
            addCriterion("manager_srb between", value1, value2, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andManagerSrbNotBetween(String value1, String value2) {
            addCriterion("manager_srb not between", value1, value2, "managerSrb");
            return (Criteria) this;
        }

        public Criteria andAccountingNameIsNull() {
            addCriterion("accounting_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountingNameIsNotNull() {
            addCriterion("accounting_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountingNameEqualTo(String value) {
            addCriterion("accounting_name =", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameNotEqualTo(String value) {
            addCriterion("accounting_name <>", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameGreaterThan(String value) {
            addCriterion("accounting_name >", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameGreaterThanOrEqualTo(String value) {
            addCriterion("accounting_name >=", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameLessThan(String value) {
            addCriterion("accounting_name <", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameLessThanOrEqualTo(String value) {
            addCriterion("accounting_name <=", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameLike(String value) {
            addCriterion("accounting_name like", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameNotLike(String value) {
            addCriterion("accounting_name not like", value, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameIn(List<String> values) {
            addCriterion("accounting_name in", values, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameNotIn(List<String> values) {
            addCriterion("accounting_name not in", values, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameBetween(String value1, String value2) {
            addCriterion("accounting_name between", value1, value2, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingNameNotBetween(String value1, String value2) {
            addCriterion("accounting_name not between", value1, value2, "accountingName");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureIsNull() {
            addCriterion("accounting_signature is null");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureIsNotNull() {
            addCriterion("accounting_signature is not null");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureEqualTo(String value) {
            addCriterion("accounting_signature =", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureNotEqualTo(String value) {
            addCriterion("accounting_signature <>", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureGreaterThan(String value) {
            addCriterion("accounting_signature >", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("accounting_signature >=", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureLessThan(String value) {
            addCriterion("accounting_signature <", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureLessThanOrEqualTo(String value) {
            addCriterion("accounting_signature <=", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureLike(String value) {
            addCriterion("accounting_signature like", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureNotLike(String value) {
            addCriterion("accounting_signature not like", value, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureIn(List<String> values) {
            addCriterion("accounting_signature in", values, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureNotIn(List<String> values) {
            addCriterion("accounting_signature not in", values, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureBetween(String value1, String value2) {
            addCriterion("accounting_signature between", value1, value2, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatureNotBetween(String value1, String value2) {
            addCriterion("accounting_signature not between", value1, value2, "accountingSignature");
            return (Criteria) this;
        }

        public Criteria andLawNameIsNull() {
            addCriterion("law_name is null");
            return (Criteria) this;
        }

        public Criteria andLawNameIsNotNull() {
            addCriterion("law_name is not null");
            return (Criteria) this;
        }

        public Criteria andLawNameEqualTo(String value) {
            addCriterion("law_name =", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameNotEqualTo(String value) {
            addCriterion("law_name <>", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameGreaterThan(String value) {
            addCriterion("law_name >", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameGreaterThanOrEqualTo(String value) {
            addCriterion("law_name >=", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameLessThan(String value) {
            addCriterion("law_name <", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameLessThanOrEqualTo(String value) {
            addCriterion("law_name <=", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameLike(String value) {
            addCriterion("law_name like", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameNotLike(String value) {
            addCriterion("law_name not like", value, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameIn(List<String> values) {
            addCriterion("law_name in", values, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameNotIn(List<String> values) {
            addCriterion("law_name not in", values, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameBetween(String value1, String value2) {
            addCriterion("law_name between", value1, value2, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawNameNotBetween(String value1, String value2) {
            addCriterion("law_name not between", value1, value2, "lawName");
            return (Criteria) this;
        }

        public Criteria andLawSignatureIsNull() {
            addCriterion("law_signature is null");
            return (Criteria) this;
        }

        public Criteria andLawSignatureIsNotNull() {
            addCriterion("law_signature is not null");
            return (Criteria) this;
        }

        public Criteria andLawSignatureEqualTo(String value) {
            addCriterion("law_signature =", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureNotEqualTo(String value) {
            addCriterion("law_signature <>", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureGreaterThan(String value) {
            addCriterion("law_signature >", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("law_signature >=", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureLessThan(String value) {
            addCriterion("law_signature <", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureLessThanOrEqualTo(String value) {
            addCriterion("law_signature <=", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureLike(String value) {
            addCriterion("law_signature like", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureNotLike(String value) {
            addCriterion("law_signature not like", value, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureIn(List<String> values) {
            addCriterion("law_signature in", values, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureNotIn(List<String> values) {
            addCriterion("law_signature not in", values, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureBetween(String value1, String value2) {
            addCriterion("law_signature between", value1, value2, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andLawSignatureNotBetween(String value1, String value2) {
            addCriterion("law_signature not between", value1, value2, "lawSignature");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameIsNull() {
            addCriterion("rating_agency_name is null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameIsNotNull() {
            addCriterion("rating_agency_name is not null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameEqualTo(String value) {
            addCriterion("rating_agency_name =", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameNotEqualTo(String value) {
            addCriterion("rating_agency_name <>", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameGreaterThan(String value) {
            addCriterion("rating_agency_name >", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("rating_agency_name >=", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameLessThan(String value) {
            addCriterion("rating_agency_name <", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameLessThanOrEqualTo(String value) {
            addCriterion("rating_agency_name <=", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameLike(String value) {
            addCriterion("rating_agency_name like", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameNotLike(String value) {
            addCriterion("rating_agency_name not like", value, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameIn(List<String> values) {
            addCriterion("rating_agency_name in", values, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameNotIn(List<String> values) {
            addCriterion("rating_agency_name not in", values, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameBetween(String value1, String value2) {
            addCriterion("rating_agency_name between", value1, value2, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyNameNotBetween(String value1, String value2) {
            addCriterion("rating_agency_name not between", value1, value2, "ratingAgencyName");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayIsNull() {
            addCriterion("rating_agency_contact_way is null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayIsNotNull() {
            addCriterion("rating_agency_contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayEqualTo(String value) {
            addCriterion("rating_agency_contact_way =", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayNotEqualTo(String value) {
            addCriterion("rating_agency_contact_way <>", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayGreaterThan(String value) {
            addCriterion("rating_agency_contact_way >", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("rating_agency_contact_way >=", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayLessThan(String value) {
            addCriterion("rating_agency_contact_way <", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayLessThanOrEqualTo(String value) {
            addCriterion("rating_agency_contact_way <=", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayLike(String value) {
            addCriterion("rating_agency_contact_way like", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayNotLike(String value) {
            addCriterion("rating_agency_contact_way not like", value, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayIn(List<String> values) {
            addCriterion("rating_agency_contact_way in", values, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayNotIn(List<String> values) {
            addCriterion("rating_agency_contact_way not in", values, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayBetween(String value1, String value2) {
            addCriterion("rating_agency_contact_way between", value1, value2, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyContactWayNotBetween(String value1, String value2) {
            addCriterion("rating_agency_contact_way not between", value1, value2, "ratingAgencyContactWay");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeIsNull() {
            addCriterion("rating_agency_charge is null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeIsNotNull() {
            addCriterion("rating_agency_charge is not null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeEqualTo(String value) {
            addCriterion("rating_agency_charge =", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeNotEqualTo(String value) {
            addCriterion("rating_agency_charge <>", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeGreaterThan(String value) {
            addCriterion("rating_agency_charge >", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeGreaterThanOrEqualTo(String value) {
            addCriterion("rating_agency_charge >=", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeLessThan(String value) {
            addCriterion("rating_agency_charge <", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeLessThanOrEqualTo(String value) {
            addCriterion("rating_agency_charge <=", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeLike(String value) {
            addCriterion("rating_agency_charge like", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeNotLike(String value) {
            addCriterion("rating_agency_charge not like", value, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeIn(List<String> values) {
            addCriterion("rating_agency_charge in", values, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeNotIn(List<String> values) {
            addCriterion("rating_agency_charge not in", values, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeBetween(String value1, String value2) {
            addCriterion("rating_agency_charge between", value1, value2, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andRatingAgencyChargeNotBetween(String value1, String value2) {
            addCriterion("rating_agency_charge not between", value1, value2, "ratingAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyIsNull() {
            addCriterion("asset_appraisal_agency is null");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyIsNotNull() {
            addCriterion("asset_appraisal_agency is not null");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyEqualTo(String value) {
            addCriterion("asset_appraisal_agency =", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyNotEqualTo(String value) {
            addCriterion("asset_appraisal_agency <>", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyGreaterThan(String value) {
            addCriterion("asset_appraisal_agency >", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyGreaterThanOrEqualTo(String value) {
            addCriterion("asset_appraisal_agency >=", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyLessThan(String value) {
            addCriterion("asset_appraisal_agency <", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyLessThanOrEqualTo(String value) {
            addCriterion("asset_appraisal_agency <=", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyLike(String value) {
            addCriterion("asset_appraisal_agency like", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyNotLike(String value) {
            addCriterion("asset_appraisal_agency not like", value, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyIn(List<String> values) {
            addCriterion("asset_appraisal_agency in", values, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyNotIn(List<String> values) {
            addCriterion("asset_appraisal_agency not in", values, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyBetween(String value1, String value2) {
            addCriterion("asset_appraisal_agency between", value1, value2, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyNotBetween(String value1, String value2) {
            addCriterion("asset_appraisal_agency not between", value1, value2, "assetAppraisalAgency");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeIsNull() {
            addCriterion("asset_appraisal_agency_charge is null");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeIsNotNull() {
            addCriterion("asset_appraisal_agency_charge is not null");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeEqualTo(String value) {
            addCriterion("asset_appraisal_agency_charge =", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeNotEqualTo(String value) {
            addCriterion("asset_appraisal_agency_charge <>", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeGreaterThan(String value) {
            addCriterion("asset_appraisal_agency_charge >", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_appraisal_agency_charge >=", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeLessThan(String value) {
            addCriterion("asset_appraisal_agency_charge <", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeLessThanOrEqualTo(String value) {
            addCriterion("asset_appraisal_agency_charge <=", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeLike(String value) {
            addCriterion("asset_appraisal_agency_charge like", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeNotLike(String value) {
            addCriterion("asset_appraisal_agency_charge not like", value, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeIn(List<String> values) {
            addCriterion("asset_appraisal_agency_charge in", values, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeNotIn(List<String> values) {
            addCriterion("asset_appraisal_agency_charge not in", values, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeBetween(String value1, String value2) {
            addCriterion("asset_appraisal_agency_charge between", value1, value2, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andAssetAppraisalAgencyChargeNotBetween(String value1, String value2) {
            addCriterion("asset_appraisal_agency_charge not between", value1, value2, "assetAppraisalAgencyCharge");
            return (Criteria) this;
        }

        public Criteria andSecurityRateIsNull() {
            addCriterion("security_rate is null");
            return (Criteria) this;
        }

        public Criteria andSecurityRateIsNotNull() {
            addCriterion("security_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityRateEqualTo(String value) {
            addCriterion("security_rate =", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateNotEqualTo(String value) {
            addCriterion("security_rate <>", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateGreaterThan(String value) {
            addCriterion("security_rate >", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateGreaterThanOrEqualTo(String value) {
            addCriterion("security_rate >=", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateLessThan(String value) {
            addCriterion("security_rate <", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateLessThanOrEqualTo(String value) {
            addCriterion("security_rate <=", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateLike(String value) {
            addCriterion("security_rate like", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateNotLike(String value) {
            addCriterion("security_rate not like", value, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateIn(List<String> values) {
            addCriterion("security_rate in", values, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateNotIn(List<String> values) {
            addCriterion("security_rate not in", values, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateBetween(String value1, String value2) {
            addCriterion("security_rate between", value1, value2, "securityRate");
            return (Criteria) this;
        }

        public Criteria andSecurityRateNotBetween(String value1, String value2) {
            addCriterion("security_rate not between", value1, value2, "securityRate");
            return (Criteria) this;
        }

        public Criteria andJurSrbIsNull() {
            addCriterion("JUR_SRB is null");
            return (Criteria) this;
        }

        public Criteria andJurSrbIsNotNull() {
            addCriterion("JUR_SRB is not null");
            return (Criteria) this;
        }

        public Criteria andJurSrbEqualTo(String value) {
            addCriterion("JUR_SRB =", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotEqualTo(String value) {
            addCriterion("JUR_SRB <>", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbGreaterThan(String value) {
            addCriterion("JUR_SRB >", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbGreaterThanOrEqualTo(String value) {
            addCriterion("JUR_SRB >=", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbLessThan(String value) {
            addCriterion("JUR_SRB <", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbLessThanOrEqualTo(String value) {
            addCriterion("JUR_SRB <=", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbLike(String value) {
            addCriterion("JUR_SRB like", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotLike(String value) {
            addCriterion("JUR_SRB not like", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbIn(List<String> values) {
            addCriterion("JUR_SRB in", values, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotIn(List<String> values) {
            addCriterion("JUR_SRB not in", values, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbBetween(String value1, String value2) {
            addCriterion("JUR_SRB between", value1, value2, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotBetween(String value1, String value2) {
            addCriterion("JUR_SRB not between", value1, value2, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andEditStateIsNull() {
            addCriterion("edit_state is null");
            return (Criteria) this;
        }

        public Criteria andEditStateIsNotNull() {
            addCriterion("edit_state is not null");
            return (Criteria) this;
        }

        public Criteria andEditStateEqualTo(Integer value) {
            addCriterion("edit_state =", value, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateNotEqualTo(Integer value) {
            addCriterion("edit_state <>", value, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateGreaterThan(Integer value) {
            addCriterion("edit_state >", value, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("edit_state >=", value, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateLessThan(Integer value) {
            addCriterion("edit_state <", value, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateLessThanOrEqualTo(Integer value) {
            addCriterion("edit_state <=", value, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateIn(List<Integer> values) {
            addCriterion("edit_state in", values, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateNotIn(List<Integer> values) {
            addCriterion("edit_state not in", values, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateBetween(Integer value1, Integer value2) {
            addCriterion("edit_state between", value1, value2, "editState");
            return (Criteria) this;
        }

        public Criteria andEditStateNotBetween(Integer value1, Integer value2) {
            addCriterion("edit_state not between", value1, value2, "editState");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeIsNull() {
            addCriterion("no_action_letter_time is null");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeIsNotNull() {
            addCriterion("no_action_letter_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeEqualTo(Date value) {
            addCriterion("no_action_letter_time =", value, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeNotEqualTo(Date value) {
            addCriterion("no_action_letter_time <>", value, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeGreaterThan(Date value) {
            addCriterion("no_action_letter_time >", value, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("no_action_letter_time >=", value, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeLessThan(Date value) {
            addCriterion("no_action_letter_time <", value, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeLessThanOrEqualTo(Date value) {
            addCriterion("no_action_letter_time <=", value, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeIn(List<Date> values) {
            addCriterion("no_action_letter_time in", values, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeNotIn(List<Date> values) {
            addCriterion("no_action_letter_time not in", values, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeBetween(Date value1, Date value2) {
            addCriterion("no_action_letter_time between", value1, value2, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andNoActionLetterTimeNotBetween(Date value1, Date value2) {
            addCriterion("no_action_letter_time not between", value1, value2, "noActionLetterTime");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andChildCodeIsNull() {
            addCriterion("child_code is null");
            return (Criteria) this;
        }

        public Criteria andChildCodeIsNotNull() {
            addCriterion("child_code is not null");
            return (Criteria) this;
        }

        public Criteria andChildCodeEqualTo(String value) {
            addCriterion("child_code =", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeNotEqualTo(String value) {
            addCriterion("child_code <>", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeGreaterThan(String value) {
            addCriterion("child_code >", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeGreaterThanOrEqualTo(String value) {
            addCriterion("child_code >=", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeLessThan(String value) {
            addCriterion("child_code <", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeLessThanOrEqualTo(String value) {
            addCriterion("child_code <=", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeLike(String value) {
            addCriterion("child_code like", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeNotLike(String value) {
            addCriterion("child_code not like", value, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeIn(List<String> values) {
            addCriterion("child_code in", values, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeNotIn(List<String> values) {
            addCriterion("child_code not in", values, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeBetween(String value1, String value2) {
            addCriterion("child_code between", value1, value2, "childCode");
            return (Criteria) this;
        }

        public Criteria andChildCodeNotBetween(String value1, String value2) {
            addCriterion("child_code not between", value1, value2, "childCode");
            return (Criteria) this;
        }

        public Criteria andCustodianIsNull() {
            addCriterion("Custodian is null");
            return (Criteria) this;
        }

        public Criteria andCustodianIsNotNull() {
            addCriterion("Custodian is not null");
            return (Criteria) this;
        }

        public Criteria andCustodianEqualTo(String value) {
            addCriterion("Custodian =", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianNotEqualTo(String value) {
            addCriterion("Custodian <>", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianGreaterThan(String value) {
            addCriterion("Custodian >", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianGreaterThanOrEqualTo(String value) {
            addCriterion("Custodian >=", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianLessThan(String value) {
            addCriterion("Custodian <", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianLessThanOrEqualTo(String value) {
            addCriterion("Custodian <=", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianLike(String value) {
            addCriterion("Custodian like", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianNotLike(String value) {
            addCriterion("Custodian not like", value, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianIn(List<String> values) {
            addCriterion("Custodian in", values, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianNotIn(List<String> values) {
            addCriterion("Custodian not in", values, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianBetween(String value1, String value2) {
            addCriterion("Custodian between", value1, value2, "custodian");
            return (Criteria) this;
        }

        public Criteria andCustodianNotBetween(String value1, String value2) {
            addCriterion("Custodian not between", value1, value2, "custodian");
            return (Criteria) this;
        }
    }

    /**
     *  * abs_base_info
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * abs_base_info 2019-09-16
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