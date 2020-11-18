/*
*
* BondBaseInfoExample.java
*                    中证技术公司
* @date 2019-09-14
*/
package com.company.one.baseinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.base.example.BaseExample;

public class BondBaseInfoExample extends BaseExample implements Serializable {
    /**
     * bond_base_info
     */
    protected String orderByClause;

    /**
     * bond_base_info
     */
    protected boolean distinct;

    /**
     * bond_base_info
     */
    protected List<Criteria> oredCriteria;

    /**
     * bond_base_info
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public BondBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-09-14
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
     * @mbg.generated 2019-09-14
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-09-14
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * bond_base_info 2019-09-14
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBondCodeIsNull() {
            addCriterion("bond_code is null");
            return (Criteria) this;
        }

        public Criteria andBondCodeIsNotNull() {
            addCriterion("bond_code is not null");
            return (Criteria) this;
        }

        public Criteria andBondCodeEqualTo(String value) {
            addCriterion("bond_code =", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeNotEqualTo(String value) {
            addCriterion("bond_code <>", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeGreaterThan(String value) {
            addCriterion("bond_code >", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bond_code >=", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeLessThan(String value) {
            addCriterion("bond_code <", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeLessThanOrEqualTo(String value) {
            addCriterion("bond_code <=", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeLike(String value) {
            addCriterion("bond_code like", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeNotLike(String value) {
            addCriterion("bond_code not like", value, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeIn(List<String> values) {
            addCriterion("bond_code in", values, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeNotIn(List<String> values) {
            addCriterion("bond_code not in", values, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeBetween(String value1, String value2) {
            addCriterion("bond_code between", value1, value2, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondCodeNotBetween(String value1, String value2) {
            addCriterion("bond_code not between", value1, value2, "bondCode");
            return (Criteria) this;
        }

        public Criteria andBondNameIsNull() {
            addCriterion("bond_name is null");
            return (Criteria) this;
        }

        public Criteria andBondNameIsNotNull() {
            addCriterion("bond_name is not null");
            return (Criteria) this;
        }

        public Criteria andBondNameEqualTo(String value) {
            addCriterion("bond_name =", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameNotEqualTo(String value) {
            addCriterion("bond_name <>", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameGreaterThan(String value) {
            addCriterion("bond_name >", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameGreaterThanOrEqualTo(String value) {
            addCriterion("bond_name >=", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameLessThan(String value) {
            addCriterion("bond_name <", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameLessThanOrEqualTo(String value) {
            addCriterion("bond_name <=", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameLike(String value) {
            addCriterion("bond_name like", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameNotLike(String value) {
            addCriterion("bond_name not like", value, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameIn(List<String> values) {
            addCriterion("bond_name in", values, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameNotIn(List<String> values) {
            addCriterion("bond_name not in", values, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameBetween(String value1, String value2) {
            addCriterion("bond_name between", value1, value2, "bondName");
            return (Criteria) this;
        }

        public Criteria andBondNameNotBetween(String value1, String value2) {
            addCriterion("bond_name not between", value1, value2, "bondName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andBondTypeIsNull() {
            addCriterion("bond_type is null");
            return (Criteria) this;
        }

        public Criteria andBondTypeIsNotNull() {
            addCriterion("bond_type is not null");
            return (Criteria) this;
        }

        public Criteria andBondTypeEqualTo(String value) {
            addCriterion("bond_type =", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeNotEqualTo(String value) {
            addCriterion("bond_type <>", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeGreaterThan(String value) {
            addCriterion("bond_type >", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bond_type >=", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeLessThan(String value) {
            addCriterion("bond_type <", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeLessThanOrEqualTo(String value) {
            addCriterion("bond_type <=", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeLike(String value) {
            addCriterion("bond_type like", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeNotLike(String value) {
            addCriterion("bond_type not like", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeIn(List<String> values) {
            addCriterion("bond_type in", values, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeNotIn(List<String> values) {
            addCriterion("bond_type not in", values, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeBetween(String value1, String value2) {
            addCriterion("bond_type between", value1, value2, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeNotBetween(String value1, String value2) {
            addCriterion("bond_type not between", value1, value2, "bondType");
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

        public Criteria andRatingIsNull() {
            addCriterion("rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(String value) {
            addCriterion("rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(String value) {
            addCriterion("rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(String value) {
            addCriterion("rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(String value) {
            addCriterion("rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(String value) {
            addCriterion("rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(String value) {
            addCriterion("rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLike(String value) {
            addCriterion("rating like", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotLike(String value) {
            addCriterion("rating not like", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<String> values) {
            addCriterion("rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<String> values) {
            addCriterion("rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(String value1, String value2) {
            addCriterion("rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(String value1, String value2) {
            addCriterion("rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingIsNull() {
            addCriterion("initial_rating is null");
            return (Criteria) this;
        }

        public Criteria andInitialRatingIsNotNull() {
            addCriterion("initial_rating is not null");
            return (Criteria) this;
        }

        public Criteria andInitialRatingEqualTo(String value) {
            addCriterion("initial_rating =", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingNotEqualTo(String value) {
            addCriterion("initial_rating <>", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingGreaterThan(String value) {
            addCriterion("initial_rating >", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingGreaterThanOrEqualTo(String value) {
            addCriterion("initial_rating >=", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingLessThan(String value) {
            addCriterion("initial_rating <", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingLessThanOrEqualTo(String value) {
            addCriterion("initial_rating <=", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingLike(String value) {
            addCriterion("initial_rating like", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingNotLike(String value) {
            addCriterion("initial_rating not like", value, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingIn(List<String> values) {
            addCriterion("initial_rating in", values, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingNotIn(List<String> values) {
            addCriterion("initial_rating not in", values, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingBetween(String value1, String value2) {
            addCriterion("initial_rating between", value1, value2, "initialRating");
            return (Criteria) this;
        }

        public Criteria andInitialRatingNotBetween(String value1, String value2) {
            addCriterion("initial_rating not between", value1, value2, "initialRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingIsNull() {
            addCriterion("current_rating is null");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingIsNotNull() {
            addCriterion("current_rating is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingEqualTo(String value) {
            addCriterion("current_rating =", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingNotEqualTo(String value) {
            addCriterion("current_rating <>", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingGreaterThan(String value) {
            addCriterion("current_rating >", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingGreaterThanOrEqualTo(String value) {
            addCriterion("current_rating >=", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingLessThan(String value) {
            addCriterion("current_rating <", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingLessThanOrEqualTo(String value) {
            addCriterion("current_rating <=", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingLike(String value) {
            addCriterion("current_rating like", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingNotLike(String value) {
            addCriterion("current_rating not like", value, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingIn(List<String> values) {
            addCriterion("current_rating in", values, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingNotIn(List<String> values) {
            addCriterion("current_rating not in", values, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingBetween(String value1, String value2) {
            addCriterion("current_rating between", value1, value2, "currentRating");
            return (Criteria) this;
        }

        public Criteria andCurrentRatingNotBetween(String value1, String value2) {
            addCriterion("current_rating not between", value1, value2, "currentRating");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNull() {
            addCriterion("stock_code is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNotNull() {
            addCriterion("stock_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeEqualTo(String value) {
            addCriterion("stock_code =", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotEqualTo(String value) {
            addCriterion("stock_code <>", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThan(String value) {
            addCriterion("stock_code >", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code >=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThan(String value) {
            addCriterion("stock_code <", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_code <=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLike(String value) {
            addCriterion("stock_code like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotLike(String value) {
            addCriterion("stock_code not like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeIn(List<String> values) {
            addCriterion("stock_code in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotIn(List<String> values) {
            addCriterion("stock_code not in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeBetween(String value1, String value2) {
            addCriterion("stock_code between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotBetween(String value1, String value2) {
            addCriterion("stock_code not between", value1, value2, "stockCode");
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

        public Criteria andIssueWayIsNull() {
            addCriterion("issue_way is null");
            return (Criteria) this;
        }

        public Criteria andIssueWayIsNotNull() {
            addCriterion("issue_way is not null");
            return (Criteria) this;
        }

        public Criteria andIssueWayEqualTo(String value) {
            addCriterion("issue_way =", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayNotEqualTo(String value) {
            addCriterion("issue_way <>", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayGreaterThan(String value) {
            addCriterion("issue_way >", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayGreaterThanOrEqualTo(String value) {
            addCriterion("issue_way >=", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayLessThan(String value) {
            addCriterion("issue_way <", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayLessThanOrEqualTo(String value) {
            addCriterion("issue_way <=", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayLike(String value) {
            addCriterion("issue_way like", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayNotLike(String value) {
            addCriterion("issue_way not like", value, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayIn(List<String> values) {
            addCriterion("issue_way in", values, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayNotIn(List<String> values) {
            addCriterion("issue_way not in", values, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayBetween(String value1, String value2) {
            addCriterion("issue_way between", value1, value2, "issueWay");
            return (Criteria) this;
        }

        public Criteria andIssueWayNotBetween(String value1, String value2) {
            addCriterion("issue_way not between", value1, value2, "issueWay");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountIsNull() {
            addCriterion("be_issue_amount is null");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountIsNotNull() {
            addCriterion("be_issue_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountEqualTo(String value) {
            addCriterion("be_issue_amount =", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountNotEqualTo(String value) {
            addCriterion("be_issue_amount <>", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountGreaterThan(String value) {
            addCriterion("be_issue_amount >", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountGreaterThanOrEqualTo(String value) {
            addCriterion("be_issue_amount >=", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountLessThan(String value) {
            addCriterion("be_issue_amount <", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountLessThanOrEqualTo(String value) {
            addCriterion("be_issue_amount <=", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountLike(String value) {
            addCriterion("be_issue_amount like", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountNotLike(String value) {
            addCriterion("be_issue_amount not like", value, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountIn(List<String> values) {
            addCriterion("be_issue_amount in", values, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountNotIn(List<String> values) {
            addCriterion("be_issue_amount not in", values, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountBetween(String value1, String value2) {
            addCriterion("be_issue_amount between", value1, value2, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andBeIssueAmountNotBetween(String value1, String value2) {
            addCriterion("be_issue_amount not between", value1, value2, "beIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountIsNull() {
            addCriterion("real_issue_amount is null");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountIsNotNull() {
            addCriterion("real_issue_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountEqualTo(String value) {
            addCriterion("real_issue_amount =", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountNotEqualTo(String value) {
            addCriterion("real_issue_amount <>", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountGreaterThan(String value) {
            addCriterion("real_issue_amount >", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountGreaterThanOrEqualTo(String value) {
            addCriterion("real_issue_amount >=", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountLessThan(String value) {
            addCriterion("real_issue_amount <", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountLessThanOrEqualTo(String value) {
            addCriterion("real_issue_amount <=", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountLike(String value) {
            addCriterion("real_issue_amount like", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountNotLike(String value) {
            addCriterion("real_issue_amount not like", value, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountIn(List<String> values) {
            addCriterion("real_issue_amount in", values, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountNotIn(List<String> values) {
            addCriterion("real_issue_amount not in", values, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountBetween(String value1, String value2) {
            addCriterion("real_issue_amount between", value1, value2, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andRealIssueAmountNotBetween(String value1, String value2) {
            addCriterion("real_issue_amount not between", value1, value2, "realIssueAmount");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipIsNull() {
            addCriterion("trusteeship is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipIsNotNull() {
            addCriterion("trusteeship is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipEqualTo(String value) {
            addCriterion("trusteeship =", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipNotEqualTo(String value) {
            addCriterion("trusteeship <>", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipGreaterThan(String value) {
            addCriterion("trusteeship >", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipGreaterThanOrEqualTo(String value) {
            addCriterion("trusteeship >=", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipLessThan(String value) {
            addCriterion("trusteeship <", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipLessThanOrEqualTo(String value) {
            addCriterion("trusteeship <=", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipLike(String value) {
            addCriterion("trusteeship like", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipNotLike(String value) {
            addCriterion("trusteeship not like", value, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipIn(List<String> values) {
            addCriterion("trusteeship in", values, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipNotIn(List<String> values) {
            addCriterion("trusteeship not in", values, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipBetween(String value1, String value2) {
            addCriterion("trusteeship between", value1, value2, "trusteeship");
            return (Criteria) this;
        }

        public Criteria andTrusteeshipNotBetween(String value1, String value2) {
            addCriterion("trusteeship not between", value1, value2, "trusteeship");
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

        public Criteria andListTimeIsNull() {
            addCriterion("list_time is null");
            return (Criteria) this;
        }

        public Criteria andListTimeIsNotNull() {
            addCriterion("list_time is not null");
            return (Criteria) this;
        }

        public Criteria andListTimeEqualTo(Date value) {
            addCriterion("list_time =", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotEqualTo(Date value) {
            addCriterion("list_time <>", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeGreaterThan(Date value) {
            addCriterion("list_time >", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("list_time >=", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeLessThan(Date value) {
            addCriterion("list_time <", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeLessThanOrEqualTo(Date value) {
            addCriterion("list_time <=", value, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeIn(List<Date> values) {
            addCriterion("list_time in", values, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotIn(List<Date> values) {
            addCriterion("list_time not in", values, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeBetween(Date value1, Date value2) {
            addCriterion("list_time between", value1, value2, "listTime");
            return (Criteria) this;
        }

        public Criteria andListTimeNotBetween(Date value1, Date value2) {
            addCriterion("list_time not between", value1, value2, "listTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approval_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approval_time =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approval_time <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approval_time >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_time >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approval_time <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approval_time <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approval_time in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approval_time not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approval_time between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approval_time not between", value1, value2, "approvalTime");
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

        public Criteria andResaleTimeIsNull() {
            addCriterion("resale_time is null");
            return (Criteria) this;
        }

        public Criteria andResaleTimeIsNotNull() {
            addCriterion("resale_time is not null");
            return (Criteria) this;
        }

        public Criteria andResaleTimeEqualTo(Date value) {
            addCriterion("resale_time =", value, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeNotEqualTo(Date value) {
            addCriterion("resale_time <>", value, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeGreaterThan(Date value) {
            addCriterion("resale_time >", value, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resale_time >=", value, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeLessThan(Date value) {
            addCriterion("resale_time <", value, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeLessThanOrEqualTo(Date value) {
            addCriterion("resale_time <=", value, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeIn(List<Date> values) {
            addCriterion("resale_time in", values, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeNotIn(List<Date> values) {
            addCriterion("resale_time not in", values, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeBetween(Date value1, Date value2) {
            addCriterion("resale_time between", value1, value2, "resaleTime");
            return (Criteria) this;
        }

        public Criteria andResaleTimeNotBetween(Date value1, Date value2) {
            addCriterion("resale_time not between", value1, value2, "resaleTime");
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

        public Criteria andIssuerNameIsNull() {
            addCriterion("issuer_name is null");
            return (Criteria) this;
        }

        public Criteria andIssuerNameIsNotNull() {
            addCriterion("issuer_name is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerNameEqualTo(String value) {
            addCriterion("issuer_name =", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameNotEqualTo(String value) {
            addCriterion("issuer_name <>", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameGreaterThan(String value) {
            addCriterion("issuer_name >", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_name >=", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameLessThan(String value) {
            addCriterion("issuer_name <", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameLessThanOrEqualTo(String value) {
            addCriterion("issuer_name <=", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameLike(String value) {
            addCriterion("issuer_name like", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameNotLike(String value) {
            addCriterion("issuer_name not like", value, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameIn(List<String> values) {
            addCriterion("issuer_name in", values, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameNotIn(List<String> values) {
            addCriterion("issuer_name not in", values, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameBetween(String value1, String value2) {
            addCriterion("issuer_name between", value1, value2, "issuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerNameNotBetween(String value1, String value2) {
            addCriterion("issuer_name not between", value1, value2, "issuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameIsNull() {
            addCriterion("other_issuer_name is null");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameIsNotNull() {
            addCriterion("other_issuer_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameEqualTo(String value) {
            addCriterion("other_issuer_name =", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameNotEqualTo(String value) {
            addCriterion("other_issuer_name <>", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameGreaterThan(String value) {
            addCriterion("other_issuer_name >", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameGreaterThanOrEqualTo(String value) {
            addCriterion("other_issuer_name >=", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameLessThan(String value) {
            addCriterion("other_issuer_name <", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameLessThanOrEqualTo(String value) {
            addCriterion("other_issuer_name <=", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameLike(String value) {
            addCriterion("other_issuer_name like", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameNotLike(String value) {
            addCriterion("other_issuer_name not like", value, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameIn(List<String> values) {
            addCriterion("other_issuer_name in", values, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameNotIn(List<String> values) {
            addCriterion("other_issuer_name not in", values, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameBetween(String value1, String value2) {
            addCriterion("other_issuer_name between", value1, value2, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andOtherIssuerNameNotBetween(String value1, String value2) {
            addCriterion("other_issuer_name not between", value1, value2, "otherIssuerName");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryIsNull() {
            addCriterion("issuer_industry is null");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryIsNotNull() {
            addCriterion("issuer_industry is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryEqualTo(String value) {
            addCriterion("issuer_industry =", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryNotEqualTo(String value) {
            addCriterion("issuer_industry <>", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryGreaterThan(String value) {
            addCriterion("issuer_industry >", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_industry >=", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryLessThan(String value) {
            addCriterion("issuer_industry <", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryLessThanOrEqualTo(String value) {
            addCriterion("issuer_industry <=", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryLike(String value) {
            addCriterion("issuer_industry like", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryNotLike(String value) {
            addCriterion("issuer_industry not like", value, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryIn(List<String> values) {
            addCriterion("issuer_industry in", values, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryNotIn(List<String> values) {
            addCriterion("issuer_industry not in", values, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryBetween(String value1, String value2) {
            addCriterion("issuer_industry between", value1, value2, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerIndustryNotBetween(String value1, String value2) {
            addCriterion("issuer_industry not between", value1, value2, "issuerIndustry");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceIsNull() {
            addCriterion("issuer_province is null");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceIsNotNull() {
            addCriterion("issuer_province is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceEqualTo(String value) {
            addCriterion("issuer_province =", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceNotEqualTo(String value) {
            addCriterion("issuer_province <>", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceGreaterThan(String value) {
            addCriterion("issuer_province >", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_province >=", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceLessThan(String value) {
            addCriterion("issuer_province <", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceLessThanOrEqualTo(String value) {
            addCriterion("issuer_province <=", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceLike(String value) {
            addCriterion("issuer_province like", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceNotLike(String value) {
            addCriterion("issuer_province not like", value, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceIn(List<String> values) {
            addCriterion("issuer_province in", values, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceNotIn(List<String> values) {
            addCriterion("issuer_province not in", values, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceBetween(String value1, String value2) {
            addCriterion("issuer_province between", value1, value2, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerProvinceNotBetween(String value1, String value2) {
            addCriterion("issuer_province not between", value1, value2, "issuerProvince");
            return (Criteria) this;
        }

        public Criteria andIssuerCityIsNull() {
            addCriterion("issuer_city is null");
            return (Criteria) this;
        }

        public Criteria andIssuerCityIsNotNull() {
            addCriterion("issuer_city is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerCityEqualTo(String value) {
            addCriterion("issuer_city =", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityNotEqualTo(String value) {
            addCriterion("issuer_city <>", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityGreaterThan(String value) {
            addCriterion("issuer_city >", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_city >=", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityLessThan(String value) {
            addCriterion("issuer_city <", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityLessThanOrEqualTo(String value) {
            addCriterion("issuer_city <=", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityLike(String value) {
            addCriterion("issuer_city like", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityNotLike(String value) {
            addCriterion("issuer_city not like", value, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityIn(List<String> values) {
            addCriterion("issuer_city in", values, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityNotIn(List<String> values) {
            addCriterion("issuer_city not in", values, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityBetween(String value1, String value2) {
            addCriterion("issuer_city between", value1, value2, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerCityNotBetween(String value1, String value2) {
            addCriterion("issuer_city not between", value1, value2, "issuerCity");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbIsNull() {
            addCriterion("issuer_srb is null");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbIsNotNull() {
            addCriterion("issuer_srb is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbEqualTo(String value) {
            addCriterion("issuer_srb =", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbNotEqualTo(String value) {
            addCriterion("issuer_srb <>", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbGreaterThan(String value) {
            addCriterion("issuer_srb >", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_srb >=", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbLessThan(String value) {
            addCriterion("issuer_srb <", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbLessThanOrEqualTo(String value) {
            addCriterion("issuer_srb <=", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbLike(String value) {
            addCriterion("issuer_srb like", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbNotLike(String value) {
            addCriterion("issuer_srb not like", value, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbIn(List<String> values) {
            addCriterion("issuer_srb in", values, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbNotIn(List<String> values) {
            addCriterion("issuer_srb not in", values, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbBetween(String value1, String value2) {
            addCriterion("issuer_srb between", value1, value2, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerSrbNotBetween(String value1, String value2) {
            addCriterion("issuer_srb not between", value1, value2, "issuerSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessIsNull() {
            addCriterion("issuer_business is null");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessIsNotNull() {
            addCriterion("issuer_business is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessEqualTo(String value) {
            addCriterion("issuer_business =", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessNotEqualTo(String value) {
            addCriterion("issuer_business <>", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessGreaterThan(String value) {
            addCriterion("issuer_business >", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_business >=", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessLessThan(String value) {
            addCriterion("issuer_business <", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessLessThanOrEqualTo(String value) {
            addCriterion("issuer_business <=", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessLike(String value) {
            addCriterion("issuer_business like", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessNotLike(String value) {
            addCriterion("issuer_business not like", value, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessIn(List<String> values) {
            addCriterion("issuer_business in", values, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessNotIn(List<String> values) {
            addCriterion("issuer_business not in", values, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessBetween(String value1, String value2) {
            addCriterion("issuer_business between", value1, value2, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerBusinessNotBetween(String value1, String value2) {
            addCriterion("issuer_business not between", value1, value2, "issuerBusiness");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureIsNull() {
            addCriterion("issuer_nature is null");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureIsNotNull() {
            addCriterion("issuer_nature is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureEqualTo(String value) {
            addCriterion("issuer_nature =", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureNotEqualTo(String value) {
            addCriterion("issuer_nature <>", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureGreaterThan(String value) {
            addCriterion("issuer_nature >", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_nature >=", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureLessThan(String value) {
            addCriterion("issuer_nature <", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureLessThanOrEqualTo(String value) {
            addCriterion("issuer_nature <=", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureLike(String value) {
            addCriterion("issuer_nature like", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureNotLike(String value) {
            addCriterion("issuer_nature not like", value, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureIn(List<String> values) {
            addCriterion("issuer_nature in", values, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureNotIn(List<String> values) {
            addCriterion("issuer_nature not in", values, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureBetween(String value1, String value2) {
            addCriterion("issuer_nature between", value1, value2, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerNatureNotBetween(String value1, String value2) {
            addCriterion("issuer_nature not between", value1, value2, "issuerNature");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialIsNull() {
            addCriterion("issuer_financial is null");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialIsNotNull() {
            addCriterion("issuer_financial is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialEqualTo(String value) {
            addCriterion("issuer_financial =", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialNotEqualTo(String value) {
            addCriterion("issuer_financial <>", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialGreaterThan(String value) {
            addCriterion("issuer_financial >", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_financial >=", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialLessThan(String value) {
            addCriterion("issuer_financial <", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialLessThanOrEqualTo(String value) {
            addCriterion("issuer_financial <=", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialLike(String value) {
            addCriterion("issuer_financial like", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialNotLike(String value) {
            addCriterion("issuer_financial not like", value, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialIn(List<String> values) {
            addCriterion("issuer_financial in", values, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialNotIn(List<String> values) {
            addCriterion("issuer_financial not in", values, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialBetween(String value1, String value2) {
            addCriterion("issuer_financial between", value1, value2, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerFinancialNotBetween(String value1, String value2) {
            addCriterion("issuer_financial not between", value1, value2, "issuerFinancial");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingIsNull() {
            addCriterion("issuer_rating is null");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingIsNotNull() {
            addCriterion("issuer_rating is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingEqualTo(String value) {
            addCriterion("issuer_rating =", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingNotEqualTo(String value) {
            addCriterion("issuer_rating <>", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingGreaterThan(String value) {
            addCriterion("issuer_rating >", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_rating >=", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingLessThan(String value) {
            addCriterion("issuer_rating <", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingLessThanOrEqualTo(String value) {
            addCriterion("issuer_rating <=", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingLike(String value) {
            addCriterion("issuer_rating like", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingNotLike(String value) {
            addCriterion("issuer_rating not like", value, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingIn(List<String> values) {
            addCriterion("issuer_rating in", values, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingNotIn(List<String> values) {
            addCriterion("issuer_rating not in", values, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingBetween(String value1, String value2) {
            addCriterion("issuer_rating between", value1, value2, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andIssuerRatingNotBetween(String value1, String value2) {
            addCriterion("issuer_rating not between", value1, value2, "issuerRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingIsNull() {
            addCriterion("com_initial_rating is null");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingIsNotNull() {
            addCriterion("com_initial_rating is not null");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingEqualTo(String value) {
            addCriterion("com_initial_rating =", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingNotEqualTo(String value) {
            addCriterion("com_initial_rating <>", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingGreaterThan(String value) {
            addCriterion("com_initial_rating >", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingGreaterThanOrEqualTo(String value) {
            addCriterion("com_initial_rating >=", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingLessThan(String value) {
            addCriterion("com_initial_rating <", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingLessThanOrEqualTo(String value) {
            addCriterion("com_initial_rating <=", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingLike(String value) {
            addCriterion("com_initial_rating like", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingNotLike(String value) {
            addCriterion("com_initial_rating not like", value, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingIn(List<String> values) {
            addCriterion("com_initial_rating in", values, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingNotIn(List<String> values) {
            addCriterion("com_initial_rating not in", values, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingBetween(String value1, String value2) {
            addCriterion("com_initial_rating between", value1, value2, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComInitialRatingNotBetween(String value1, String value2) {
            addCriterion("com_initial_rating not between", value1, value2, "comInitialRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingIsNull() {
            addCriterion("com_current_rating is null");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingIsNotNull() {
            addCriterion("com_current_rating is not null");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingEqualTo(String value) {
            addCriterion("com_current_rating =", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingNotEqualTo(String value) {
            addCriterion("com_current_rating <>", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingGreaterThan(String value) {
            addCriterion("com_current_rating >", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingGreaterThanOrEqualTo(String value) {
            addCriterion("com_current_rating >=", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingLessThan(String value) {
            addCriterion("com_current_rating <", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingLessThanOrEqualTo(String value) {
            addCriterion("com_current_rating <=", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingLike(String value) {
            addCriterion("com_current_rating like", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingNotLike(String value) {
            addCriterion("com_current_rating not like", value, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingIn(List<String> values) {
            addCriterion("com_current_rating in", values, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingNotIn(List<String> values) {
            addCriterion("com_current_rating not in", values, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingBetween(String value1, String value2) {
            addCriterion("com_current_rating between", value1, value2, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andComCurrentRatingNotBetween(String value1, String value2) {
            addCriterion("com_current_rating not between", value1, value2, "comCurrentRating");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayIsNull() {
            addCriterion("issuer_contact_way is null");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayIsNotNull() {
            addCriterion("issuer_contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayEqualTo(String value) {
            addCriterion("issuer_contact_way =", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayNotEqualTo(String value) {
            addCriterion("issuer_contact_way <>", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayGreaterThan(String value) {
            addCriterion("issuer_contact_way >", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("issuer_contact_way >=", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayLessThan(String value) {
            addCriterion("issuer_contact_way <", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayLessThanOrEqualTo(String value) {
            addCriterion("issuer_contact_way <=", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayLike(String value) {
            addCriterion("issuer_contact_way like", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayNotLike(String value) {
            addCriterion("issuer_contact_way not like", value, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayIn(List<String> values) {
            addCriterion("issuer_contact_way in", values, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayNotIn(List<String> values) {
            addCriterion("issuer_contact_way not in", values, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayBetween(String value1, String value2) {
            addCriterion("issuer_contact_way between", value1, value2, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andIssuerContactWayNotBetween(String value1, String value2) {
            addCriterion("issuer_contact_way not between", value1, value2, "issuerContactWay");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameIsNull() {
            addCriterion("underwriter_name is null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameIsNotNull() {
            addCriterion("underwriter_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameEqualTo(String value) {
            addCriterion("underwriter_name =", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameNotEqualTo(String value) {
            addCriterion("underwriter_name <>", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameGreaterThan(String value) {
            addCriterion("underwriter_name >", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameGreaterThanOrEqualTo(String value) {
            addCriterion("underwriter_name >=", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameLessThan(String value) {
            addCriterion("underwriter_name <", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameLessThanOrEqualTo(String value) {
            addCriterion("underwriter_name <=", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameLike(String value) {
            addCriterion("underwriter_name like", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameNotLike(String value) {
            addCriterion("underwriter_name not like", value, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameIn(List<String> values) {
            addCriterion("underwriter_name in", values, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameNotIn(List<String> values) {
            addCriterion("underwriter_name not in", values, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameBetween(String value1, String value2) {
            addCriterion("underwriter_name between", value1, value2, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterNameNotBetween(String value1, String value2) {
            addCriterion("underwriter_name not between", value1, value2, "underwriterName");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeIsNull() {
            addCriterion("underwriter_charge is null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeIsNotNull() {
            addCriterion("underwriter_charge is not null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeEqualTo(String value) {
            addCriterion("underwriter_charge =", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeNotEqualTo(String value) {
            addCriterion("underwriter_charge <>", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeGreaterThan(String value) {
            addCriterion("underwriter_charge >", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeGreaterThanOrEqualTo(String value) {
            addCriterion("underwriter_charge >=", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeLessThan(String value) {
            addCriterion("underwriter_charge <", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeLessThanOrEqualTo(String value) {
            addCriterion("underwriter_charge <=", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeLike(String value) {
            addCriterion("underwriter_charge like", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeNotLike(String value) {
            addCriterion("underwriter_charge not like", value, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeIn(List<String> values) {
            addCriterion("underwriter_charge in", values, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeNotIn(List<String> values) {
            addCriterion("underwriter_charge not in", values, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeBetween(String value1, String value2) {
            addCriterion("underwriter_charge between", value1, value2, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterChargeNotBetween(String value1, String value2) {
            addCriterion("underwriter_charge not between", value1, value2, "underwriterCharge");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbIsNull() {
            addCriterion("underwriter_srb is null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbIsNotNull() {
            addCriterion("underwriter_srb is not null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbEqualTo(String value) {
            addCriterion("underwriter_srb =", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbNotEqualTo(String value) {
            addCriterion("underwriter_srb <>", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbGreaterThan(String value) {
            addCriterion("underwriter_srb >", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbGreaterThanOrEqualTo(String value) {
            addCriterion("underwriter_srb >=", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbLessThan(String value) {
            addCriterion("underwriter_srb <", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbLessThanOrEqualTo(String value) {
            addCriterion("underwriter_srb <=", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbLike(String value) {
            addCriterion("underwriter_srb like", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbNotLike(String value) {
            addCriterion("underwriter_srb not like", value, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbIn(List<String> values) {
            addCriterion("underwriter_srb in", values, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbNotIn(List<String> values) {
            addCriterion("underwriter_srb not in", values, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbBetween(String value1, String value2) {
            addCriterion("underwriter_srb between", value1, value2, "underwriterSrb");
            return (Criteria) this;
        }

        public Criteria andUnderwriterSrbNotBetween(String value1, String value2) {
            addCriterion("underwriter_srb not between", value1, value2, "underwriterSrb");
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

        public Criteria andAccountingSignatoryIsNull() {
            addCriterion("accounting_signatory is null");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryIsNotNull() {
            addCriterion("accounting_signatory is not null");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryEqualTo(String value) {
            addCriterion("accounting_signatory =", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryNotEqualTo(String value) {
            addCriterion("accounting_signatory <>", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryGreaterThan(String value) {
            addCriterion("accounting_signatory >", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryGreaterThanOrEqualTo(String value) {
            addCriterion("accounting_signatory >=", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryLessThan(String value) {
            addCriterion("accounting_signatory <", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryLessThanOrEqualTo(String value) {
            addCriterion("accounting_signatory <=", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryLike(String value) {
            addCriterion("accounting_signatory like", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryNotLike(String value) {
            addCriterion("accounting_signatory not like", value, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryIn(List<String> values) {
            addCriterion("accounting_signatory in", values, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryNotIn(List<String> values) {
            addCriterion("accounting_signatory not in", values, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryBetween(String value1, String value2) {
            addCriterion("accounting_signatory between", value1, value2, "accountingSignatory");
            return (Criteria) this;
        }

        public Criteria andAccountingSignatoryNotBetween(String value1, String value2) {
            addCriterion("accounting_signatory not between", value1, value2, "accountingSignatory");
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

        public Criteria andLawSignatoryIsNull() {
            addCriterion("law_signatory is null");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryIsNotNull() {
            addCriterion("law_signatory is not null");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryEqualTo(String value) {
            addCriterion("law_signatory =", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryNotEqualTo(String value) {
            addCriterion("law_signatory <>", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryGreaterThan(String value) {
            addCriterion("law_signatory >", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryGreaterThanOrEqualTo(String value) {
            addCriterion("law_signatory >=", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryLessThan(String value) {
            addCriterion("law_signatory <", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryLessThanOrEqualTo(String value) {
            addCriterion("law_signatory <=", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryLike(String value) {
            addCriterion("law_signatory like", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryNotLike(String value) {
            addCriterion("law_signatory not like", value, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryIn(List<String> values) {
            addCriterion("law_signatory in", values, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryNotIn(List<String> values) {
            addCriterion("law_signatory not in", values, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryBetween(String value1, String value2) {
            addCriterion("law_signatory between", value1, value2, "lawSignatory");
            return (Criteria) this;
        }

        public Criteria andLawSignatoryNotBetween(String value1, String value2) {
            addCriterion("law_signatory not between", value1, value2, "lawSignatory");
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

        public Criteria andOtherRatingAgencyNameIsNull() {
            addCriterion("other_rating_agency_name is null");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameIsNotNull() {
            addCriterion("other_rating_agency_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameEqualTo(String value) {
            addCriterion("other_rating_agency_name =", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameNotEqualTo(String value) {
            addCriterion("other_rating_agency_name <>", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameGreaterThan(String value) {
            addCriterion("other_rating_agency_name >", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameGreaterThanOrEqualTo(String value) {
            addCriterion("other_rating_agency_name >=", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameLessThan(String value) {
            addCriterion("other_rating_agency_name <", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameLessThanOrEqualTo(String value) {
            addCriterion("other_rating_agency_name <=", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameLike(String value) {
            addCriterion("other_rating_agency_name like", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameNotLike(String value) {
            addCriterion("other_rating_agency_name not like", value, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameIn(List<String> values) {
            addCriterion("other_rating_agency_name in", values, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameNotIn(List<String> values) {
            addCriterion("other_rating_agency_name not in", values, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameBetween(String value1, String value2) {
            addCriterion("other_rating_agency_name between", value1, value2, "otherRatingAgencyName");
            return (Criteria) this;
        }

        public Criteria andOtherRatingAgencyNameNotBetween(String value1, String value2) {
            addCriterion("other_rating_agency_name not between", value1, value2, "otherRatingAgencyName");
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

        public Criteria andRatingAgencySrbIsNull() {
            addCriterion("rating_agency_srb is null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbIsNotNull() {
            addCriterion("rating_agency_srb is not null");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbEqualTo(String value) {
            addCriterion("rating_agency_srb =", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbNotEqualTo(String value) {
            addCriterion("rating_agency_srb <>", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbGreaterThan(String value) {
            addCriterion("rating_agency_srb >", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbGreaterThanOrEqualTo(String value) {
            addCriterion("rating_agency_srb >=", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbLessThan(String value) {
            addCriterion("rating_agency_srb <", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbLessThanOrEqualTo(String value) {
            addCriterion("rating_agency_srb <=", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbLike(String value) {
            addCriterion("rating_agency_srb like", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbNotLike(String value) {
            addCriterion("rating_agency_srb not like", value, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbIn(List<String> values) {
            addCriterion("rating_agency_srb in", values, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbNotIn(List<String> values) {
            addCriterion("rating_agency_srb not in", values, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbBetween(String value1, String value2) {
            addCriterion("rating_agency_srb between", value1, value2, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andRatingAgencySrbNotBetween(String value1, String value2) {
            addCriterion("rating_agency_srb not between", value1, value2, "ratingAgencySrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameIsNull() {
            addCriterion("trustee_name is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameIsNotNull() {
            addCriterion("trustee_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameEqualTo(String value) {
            addCriterion("trustee_name =", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotEqualTo(String value) {
            addCriterion("trustee_name <>", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameGreaterThan(String value) {
            addCriterion("trustee_name >", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_name >=", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameLessThan(String value) {
            addCriterion("trustee_name <", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameLessThanOrEqualTo(String value) {
            addCriterion("trustee_name <=", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameLike(String value) {
            addCriterion("trustee_name like", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotLike(String value) {
            addCriterion("trustee_name not like", value, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameIn(List<String> values) {
            addCriterion("trustee_name in", values, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotIn(List<String> values) {
            addCriterion("trustee_name not in", values, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameBetween(String value1, String value2) {
            addCriterion("trustee_name between", value1, value2, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeNameNotBetween(String value1, String value2) {
            addCriterion("trustee_name not between", value1, value2, "trusteeName");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeIsNull() {
            addCriterion("trustee_charge is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeIsNotNull() {
            addCriterion("trustee_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeEqualTo(String value) {
            addCriterion("trustee_charge =", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeNotEqualTo(String value) {
            addCriterion("trustee_charge <>", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeGreaterThan(String value) {
            addCriterion("trustee_charge >", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_charge >=", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeLessThan(String value) {
            addCriterion("trustee_charge <", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeLessThanOrEqualTo(String value) {
            addCriterion("trustee_charge <=", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeLike(String value) {
            addCriterion("trustee_charge like", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeNotLike(String value) {
            addCriterion("trustee_charge not like", value, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeIn(List<String> values) {
            addCriterion("trustee_charge in", values, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeNotIn(List<String> values) {
            addCriterion("trustee_charge not in", values, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeBetween(String value1, String value2) {
            addCriterion("trustee_charge between", value1, value2, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeNotBetween(String value1, String value2) {
            addCriterion("trustee_charge not between", value1, value2, "trusteeCharge");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayIsNull() {
            addCriterion("trustee_charge_contact_way is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayIsNotNull() {
            addCriterion("trustee_charge_contact_way is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayEqualTo(String value) {
            addCriterion("trustee_charge_contact_way =", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayNotEqualTo(String value) {
            addCriterion("trustee_charge_contact_way <>", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayGreaterThan(String value) {
            addCriterion("trustee_charge_contact_way >", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_charge_contact_way >=", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayLessThan(String value) {
            addCriterion("trustee_charge_contact_way <", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayLessThanOrEqualTo(String value) {
            addCriterion("trustee_charge_contact_way <=", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayLike(String value) {
            addCriterion("trustee_charge_contact_way like", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayNotLike(String value) {
            addCriterion("trustee_charge_contact_way not like", value, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayIn(List<String> values) {
            addCriterion("trustee_charge_contact_way in", values, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayNotIn(List<String> values) {
            addCriterion("trustee_charge_contact_way not in", values, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayBetween(String value1, String value2) {
            addCriterion("trustee_charge_contact_way between", value1, value2, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeChargeContactWayNotBetween(String value1, String value2) {
            addCriterion("trustee_charge_contact_way not between", value1, value2, "trusteeChargeContactWay");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbIsNull() {
            addCriterion("trustee_srb is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbIsNotNull() {
            addCriterion("trustee_srb is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbEqualTo(String value) {
            addCriterion("trustee_srb =", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbNotEqualTo(String value) {
            addCriterion("trustee_srb <>", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbGreaterThan(String value) {
            addCriterion("trustee_srb >", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbGreaterThanOrEqualTo(String value) {
            addCriterion("trustee_srb >=", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbLessThan(String value) {
            addCriterion("trustee_srb <", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbLessThanOrEqualTo(String value) {
            addCriterion("trustee_srb <=", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbLike(String value) {
            addCriterion("trustee_srb like", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbNotLike(String value) {
            addCriterion("trustee_srb not like", value, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbIn(List<String> values) {
            addCriterion("trustee_srb in", values, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbNotIn(List<String> values) {
            addCriterion("trustee_srb not in", values, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbBetween(String value1, String value2) {
            addCriterion("trustee_srb between", value1, value2, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andTrusteeSrbNotBetween(String value1, String value2) {
            addCriterion("trustee_srb not between", value1, value2, "trusteeSrb");
            return (Criteria) this;
        }

        public Criteria andIssuerIdIsNull() {
            addCriterion("issuer_id is null");
            return (Criteria) this;
        }

        public Criteria andIssuerIdIsNotNull() {
            addCriterion("issuer_id is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerIdEqualTo(Integer value) {
            addCriterion("issuer_id =", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdNotEqualTo(Integer value) {
            addCriterion("issuer_id <>", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdGreaterThan(Integer value) {
            addCriterion("issuer_id >", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("issuer_id >=", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdLessThan(Integer value) {
            addCriterion("issuer_id <", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdLessThanOrEqualTo(Integer value) {
            addCriterion("issuer_id <=", value, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdIn(List<Integer> values) {
            addCriterion("issuer_id in", values, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdNotIn(List<Integer> values) {
            addCriterion("issuer_id not in", values, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdBetween(Integer value1, Integer value2) {
            addCriterion("issuer_id between", value1, value2, "issuerId");
            return (Criteria) this;
        }

        public Criteria andIssuerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("issuer_id not between", value1, value2, "issuerId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdIsNull() {
            addCriterion("underwriter_id is null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdIsNotNull() {
            addCriterion("underwriter_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdEqualTo(Integer value) {
            addCriterion("underwriter_id =", value, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdNotEqualTo(Integer value) {
            addCriterion("underwriter_id <>", value, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdGreaterThan(Integer value) {
            addCriterion("underwriter_id >", value, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("underwriter_id >=", value, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdLessThan(Integer value) {
            addCriterion("underwriter_id <", value, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdLessThanOrEqualTo(Integer value) {
            addCriterion("underwriter_id <=", value, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdIn(List<Integer> values) {
            addCriterion("underwriter_id in", values, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdNotIn(List<Integer> values) {
            addCriterion("underwriter_id not in", values, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdBetween(Integer value1, Integer value2) {
            addCriterion("underwriter_id between", value1, value2, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andUnderwriterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("underwriter_id not between", value1, value2, "underwriterId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdIsNull() {
            addCriterion("law_firm_id is null");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdIsNotNull() {
            addCriterion("law_firm_id is not null");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdEqualTo(Integer value) {
            addCriterion("law_firm_id =", value, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdNotEqualTo(Integer value) {
            addCriterion("law_firm_id <>", value, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdGreaterThan(Integer value) {
            addCriterion("law_firm_id >", value, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("law_firm_id >=", value, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdLessThan(Integer value) {
            addCriterion("law_firm_id <", value, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdLessThanOrEqualTo(Integer value) {
            addCriterion("law_firm_id <=", value, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdIn(List<Integer> values) {
            addCriterion("law_firm_id in", values, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdNotIn(List<Integer> values) {
            addCriterion("law_firm_id not in", values, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdBetween(Integer value1, Integer value2) {
            addCriterion("law_firm_id between", value1, value2, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andLawFirmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("law_firm_id not between", value1, value2, "lawFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdIsNull() {
            addCriterion("accounting_firm_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdIsNotNull() {
            addCriterion("accounting_firm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdEqualTo(Integer value) {
            addCriterion("accounting_firm_id =", value, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdNotEqualTo(Integer value) {
            addCriterion("accounting_firm_id <>", value, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdGreaterThan(Integer value) {
            addCriterion("accounting_firm_id >", value, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("accounting_firm_id >=", value, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdLessThan(Integer value) {
            addCriterion("accounting_firm_id <", value, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdLessThanOrEqualTo(Integer value) {
            addCriterion("accounting_firm_id <=", value, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdIn(List<Integer> values) {
            addCriterion("accounting_firm_id in", values, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdNotIn(List<Integer> values) {
            addCriterion("accounting_firm_id not in", values, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdBetween(Integer value1, Integer value2) {
            addCriterion("accounting_firm_id between", value1, value2, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andAccountingFirmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("accounting_firm_id not between", value1, value2, "accountingFirmId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdIsNull() {
            addCriterion("guarantor_id is null");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdIsNotNull() {
            addCriterion("guarantor_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdEqualTo(Integer value) {
            addCriterion("guarantor_id =", value, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdNotEqualTo(Integer value) {
            addCriterion("guarantor_id <>", value, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdGreaterThan(Integer value) {
            addCriterion("guarantor_id >", value, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guarantor_id >=", value, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdLessThan(Integer value) {
            addCriterion("guarantor_id <", value, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdLessThanOrEqualTo(Integer value) {
            addCriterion("guarantor_id <=", value, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdIn(List<Integer> values) {
            addCriterion("guarantor_id in", values, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdNotIn(List<Integer> values) {
            addCriterion("guarantor_id not in", values, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdBetween(Integer value1, Integer value2) {
            addCriterion("guarantor_id between", value1, value2, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andGuarantorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guarantor_id not between", value1, value2, "guarantorId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdIsNull() {
            addCriterion("credit_rating_agency_id is null");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdIsNotNull() {
            addCriterion("credit_rating_agency_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdEqualTo(Integer value) {
            addCriterion("credit_rating_agency_id =", value, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdNotEqualTo(Integer value) {
            addCriterion("credit_rating_agency_id <>", value, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdGreaterThan(Integer value) {
            addCriterion("credit_rating_agency_id >", value, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_rating_agency_id >=", value, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdLessThan(Integer value) {
            addCriterion("credit_rating_agency_id <", value, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdLessThanOrEqualTo(Integer value) {
            addCriterion("credit_rating_agency_id <=", value, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdIn(List<Integer> values) {
            addCriterion("credit_rating_agency_id in", values, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdNotIn(List<Integer> values) {
            addCriterion("credit_rating_agency_id not in", values, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdBetween(Integer value1, Integer value2) {
            addCriterion("credit_rating_agency_id between", value1, value2, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andCreditRatingAgencyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_rating_agency_id not between", value1, value2, "creditRatingAgencyId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdIsNull() {
            addCriterion("trustee_id is null");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdIsNotNull() {
            addCriterion("trustee_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdEqualTo(Integer value) {
            addCriterion("trustee_id =", value, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdNotEqualTo(Integer value) {
            addCriterion("trustee_id <>", value, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdGreaterThan(Integer value) {
            addCriterion("trustee_id >", value, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trustee_id >=", value, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdLessThan(Integer value) {
            addCriterion("trustee_id <", value, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdLessThanOrEqualTo(Integer value) {
            addCriterion("trustee_id <=", value, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdIn(List<Integer> values) {
            addCriterion("trustee_id in", values, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdNotIn(List<Integer> values) {
            addCriterion("trustee_id not in", values, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdBetween(Integer value1, Integer value2) {
            addCriterion("trustee_id between", value1, value2, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andTrusteeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trustee_id not between", value1, value2, "trusteeId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdIsNull() {
            addCriterion("intermediary_agency_id is null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdIsNotNull() {
            addCriterion("intermediary_agency_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdEqualTo(Integer value) {
            addCriterion("intermediary_agency_id =", value, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdNotEqualTo(Integer value) {
            addCriterion("intermediary_agency_id <>", value, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdGreaterThan(Integer value) {
            addCriterion("intermediary_agency_id >", value, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("intermediary_agency_id >=", value, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdLessThan(Integer value) {
            addCriterion("intermediary_agency_id <", value, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdLessThanOrEqualTo(Integer value) {
            addCriterion("intermediary_agency_id <=", value, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdIn(List<Integer> values) {
            addCriterion("intermediary_agency_id in", values, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdNotIn(List<Integer> values) {
            addCriterion("intermediary_agency_id not in", values, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdBetween(Integer value1, Integer value2) {
            addCriterion("intermediary_agency_id between", value1, value2, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andIntermediaryAgencyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("intermediary_agency_id not between", value1, value2, "intermediaryAgencyId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNull() {
            addCriterion("publisher_id is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNotNull() {
            addCriterion("publisher_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdEqualTo(Integer value) {
            addCriterion("publisher_id =", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotEqualTo(Integer value) {
            addCriterion("publisher_id <>", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThan(Integer value) {
            addCriterion("publisher_id >", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisher_id >=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThan(Integer value) {
            addCriterion("publisher_id <", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThanOrEqualTo(Integer value) {
            addCriterion("publisher_id <=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIn(List<Integer> values) {
            addCriterion("publisher_id in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotIn(List<Integer> values) {
            addCriterion("publisher_id not in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id not between", value1, value2, "publisherId");
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

        public Criteria andJurSrbIsNull() {
            addCriterion("jur_srb is null");
            return (Criteria) this;
        }

        public Criteria andJurSrbIsNotNull() {
            addCriterion("jur_srb is not null");
            return (Criteria) this;
        }

        public Criteria andJurSrbEqualTo(String value) {
            addCriterion("jur_srb =", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotEqualTo(String value) {
            addCriterion("jur_srb <>", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbGreaterThan(String value) {
            addCriterion("jur_srb >", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbGreaterThanOrEqualTo(String value) {
            addCriterion("jur_srb >=", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbLessThan(String value) {
            addCriterion("jur_srb <", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbLessThanOrEqualTo(String value) {
            addCriterion("jur_srb <=", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbLike(String value) {
            addCriterion("jur_srb like", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotLike(String value) {
            addCriterion("jur_srb not like", value, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbIn(List<String> values) {
            addCriterion("jur_srb in", values, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotIn(List<String> values) {
            addCriterion("jur_srb not in", values, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbBetween(String value1, String value2) {
            addCriterion("jur_srb between", value1, value2, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andJurSrbNotBetween(String value1, String value2) {
            addCriterion("jur_srb not between", value1, value2, "jurSrb");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNull() {
            addCriterion("audit_state is null");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNotNull() {
            addCriterion("audit_state is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStateEqualTo(Integer value) {
            addCriterion("audit_state =", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotEqualTo(Integer value) {
            addCriterion("audit_state <>", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThan(Integer value) {
            addCriterion("audit_state >", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_state >=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThan(Integer value) {
            addCriterion("audit_state <", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThanOrEqualTo(Integer value) {
            addCriterion("audit_state <=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateIn(List<Integer> values) {
            addCriterion("audit_state in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotIn(List<Integer> values) {
            addCriterion("audit_state not in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateBetween(Integer value1, Integer value2) {
            addCriterion("audit_state between", value1, value2, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_state not between", value1, value2, "auditState");
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
    }

    /**
     *  * bond_base_info
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * bond_base_info 2019-09-14
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