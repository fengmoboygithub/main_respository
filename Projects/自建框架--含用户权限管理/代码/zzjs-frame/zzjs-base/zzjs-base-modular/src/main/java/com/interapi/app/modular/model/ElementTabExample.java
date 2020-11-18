/*
*
* ElementTabExample.java
*                    中证技术公司
* @date 2018-11-23
*/
package com.interapi.app.modular.model;

import com.interapi.app.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElementTabExample extends BaseExample implements Serializable {
    /**
     * element_tab
     */
    protected String orderByClause;

    /**
     * element_tab
     */
    protected boolean distinct;

    /**
     * element_tab
     */
    protected List<Criteria> oredCriteria;

    /**
     * element_tab
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public ElementTabExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-11-23
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
     * @mbg.generated 2018-11-23
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-11-23
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * element_tab 2018-11-23
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFormItemIdIsNull() {
            addCriterion("FORM_ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andFormItemIdIsNotNull() {
            addCriterion("FORM_ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFormItemIdEqualTo(Long value) {
            addCriterion("FORM_ITEM_ID =", value, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdNotEqualTo(Long value) {
            addCriterion("FORM_ITEM_ID <>", value, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdGreaterThan(Long value) {
            addCriterion("FORM_ITEM_ID >", value, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FORM_ITEM_ID >=", value, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdLessThan(Long value) {
            addCriterion("FORM_ITEM_ID <", value, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdLessThanOrEqualTo(Long value) {
            addCriterion("FORM_ITEM_ID <=", value, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdIn(List<Long> values) {
            addCriterion("FORM_ITEM_ID in", values, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdNotIn(List<Long> values) {
            addCriterion("FORM_ITEM_ID not in", values, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdBetween(Long value1, Long value2) {
            addCriterion("FORM_ITEM_ID between", value1, value2, "formItemId");
            return (Criteria) this;
        }

        public Criteria andFormItemIdNotBetween(Long value1, Long value2) {
            addCriterion("FORM_ITEM_ID not between", value1, value2, "formItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdIsNull() {
            addCriterion("QUERY_CRITERIA_ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdIsNotNull() {
            addCriterion("QUERY_CRITERIA_ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdEqualTo(Long value) {
            addCriterion("QUERY_CRITERIA_ITEM_ID =", value, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdNotEqualTo(Long value) {
            addCriterion("QUERY_CRITERIA_ITEM_ID <>", value, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdGreaterThan(Long value) {
            addCriterion("QUERY_CRITERIA_ITEM_ID >", value, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("QUERY_CRITERIA_ITEM_ID >=", value, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdLessThan(Long value) {
            addCriterion("QUERY_CRITERIA_ITEM_ID <", value, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdLessThanOrEqualTo(Long value) {
            addCriterion("QUERY_CRITERIA_ITEM_ID <=", value, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdIn(List<Long> values) {
            addCriterion("QUERY_CRITERIA_ITEM_ID in", values, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdNotIn(List<Long> values) {
            addCriterion("QUERY_CRITERIA_ITEM_ID not in", values, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdBetween(Long value1, Long value2) {
            addCriterion("QUERY_CRITERIA_ITEM_ID between", value1, value2, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andQueryCriteriaItemIdNotBetween(Long value1, Long value2) {
            addCriterion("QUERY_CRITERIA_ITEM_ID not between", value1, value2, "queryCriteriaItemId");
            return (Criteria) this;
        }

        public Criteria andElementTypeIsNull() {
            addCriterion("ELEMENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andElementTypeIsNotNull() {
            addCriterion("ELEMENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andElementTypeEqualTo(String value) {
            addCriterion("ELEMENT_TYPE =", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNotEqualTo(String value) {
            addCriterion("ELEMENT_TYPE <>", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeGreaterThan(String value) {
            addCriterion("ELEMENT_TYPE >", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ELEMENT_TYPE >=", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeLessThan(String value) {
            addCriterion("ELEMENT_TYPE <", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeLessThanOrEqualTo(String value) {
            addCriterion("ELEMENT_TYPE <=", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeLike(String value) {
            addCriterion("ELEMENT_TYPE like", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNotLike(String value) {
            addCriterion("ELEMENT_TYPE not like", value, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeIn(List<String> values) {
            addCriterion("ELEMENT_TYPE in", values, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNotIn(List<String> values) {
            addCriterion("ELEMENT_TYPE not in", values, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeBetween(String value1, String value2) {
            addCriterion("ELEMENT_TYPE between", value1, value2, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNotBetween(String value1, String value2) {
            addCriterion("ELEMENT_TYPE not between", value1, value2, "elementType");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameIsNull() {
            addCriterion("ELEMENT_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameIsNotNull() {
            addCriterion("ELEMENT_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameEqualTo(String value) {
            addCriterion("ELEMENT_TYPE_NAME =", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameNotEqualTo(String value) {
            addCriterion("ELEMENT_TYPE_NAME <>", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameGreaterThan(String value) {
            addCriterion("ELEMENT_TYPE_NAME >", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("ELEMENT_TYPE_NAME >=", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameLessThan(String value) {
            addCriterion("ELEMENT_TYPE_NAME <", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameLessThanOrEqualTo(String value) {
            addCriterion("ELEMENT_TYPE_NAME <=", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameLike(String value) {
            addCriterion("ELEMENT_TYPE_NAME like", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameNotLike(String value) {
            addCriterion("ELEMENT_TYPE_NAME not like", value, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameIn(List<String> values) {
            addCriterion("ELEMENT_TYPE_NAME in", values, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameNotIn(List<String> values) {
            addCriterion("ELEMENT_TYPE_NAME not in", values, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameBetween(String value1, String value2) {
            addCriterion("ELEMENT_TYPE_NAME between", value1, value2, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andElementTypeNameNotBetween(String value1, String value2) {
            addCriterion("ELEMENT_TYPE_NAME not between", value1, value2, "elementTypeName");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("MODEL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("MODEL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("MODEL_NAME =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("MODEL_NAME <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("MODEL_NAME >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("MODEL_NAME <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("MODEL_NAME <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("MODEL_NAME like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("MODEL_NAME not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("MODEL_NAME in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("MODEL_NAME not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("MODEL_NAME between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("MODEL_NAME not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andStyleNameIsNull() {
            addCriterion("STYLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStyleNameIsNotNull() {
            addCriterion("STYLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStyleNameEqualTo(String value) {
            addCriterion("STYLE_NAME =", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotEqualTo(String value) {
            addCriterion("STYLE_NAME <>", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameGreaterThan(String value) {
            addCriterion("STYLE_NAME >", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameGreaterThanOrEqualTo(String value) {
            addCriterion("STYLE_NAME >=", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLessThan(String value) {
            addCriterion("STYLE_NAME <", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLessThanOrEqualTo(String value) {
            addCriterion("STYLE_NAME <=", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLike(String value) {
            addCriterion("STYLE_NAME like", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotLike(String value) {
            addCriterion("STYLE_NAME not like", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameIn(List<String> values) {
            addCriterion("STYLE_NAME in", values, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotIn(List<String> values) {
            addCriterion("STYLE_NAME not in", values, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameBetween(String value1, String value2) {
            addCriterion("STYLE_NAME between", value1, value2, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotBetween(String value1, String value2) {
            addCriterion("STYLE_NAME not between", value1, value2, "styleName");
            return (Criteria) this;
        }

        public Criteria andPlaceholderIsNull() {
            addCriterion("PLACEHOLDER is null");
            return (Criteria) this;
        }

        public Criteria andPlaceholderIsNotNull() {
            addCriterion("PLACEHOLDER is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceholderEqualTo(String value) {
            addCriterion("PLACEHOLDER =", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotEqualTo(String value) {
            addCriterion("PLACEHOLDER <>", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderGreaterThan(String value) {
            addCriterion("PLACEHOLDER >", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderGreaterThanOrEqualTo(String value) {
            addCriterion("PLACEHOLDER >=", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderLessThan(String value) {
            addCriterion("PLACEHOLDER <", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderLessThanOrEqualTo(String value) {
            addCriterion("PLACEHOLDER <=", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderLike(String value) {
            addCriterion("PLACEHOLDER like", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotLike(String value) {
            addCriterion("PLACEHOLDER not like", value, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderIn(List<String> values) {
            addCriterion("PLACEHOLDER in", values, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotIn(List<String> values) {
            addCriterion("PLACEHOLDER not in", values, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderBetween(String value1, String value2) {
            addCriterion("PLACEHOLDER between", value1, value2, "placeholder");
            return (Criteria) this;
        }

        public Criteria andPlaceholderNotBetween(String value1, String value2) {
            addCriterion("PLACEHOLDER not between", value1, value2, "placeholder");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNull() {
            addCriterion("MULTIPLE is null");
            return (Criteria) this;
        }

        public Criteria andMultipleIsNotNull() {
            addCriterion("MULTIPLE is not null");
            return (Criteria) this;
        }

        public Criteria andMultipleEqualTo(String value) {
            addCriterion("MULTIPLE =", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotEqualTo(String value) {
            addCriterion("MULTIPLE <>", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThan(String value) {
            addCriterion("MULTIPLE >", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleGreaterThanOrEqualTo(String value) {
            addCriterion("MULTIPLE >=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThan(String value) {
            addCriterion("MULTIPLE <", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLessThanOrEqualTo(String value) {
            addCriterion("MULTIPLE <=", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleLike(String value) {
            addCriterion("MULTIPLE like", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotLike(String value) {
            addCriterion("MULTIPLE not like", value, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleIn(List<String> values) {
            addCriterion("MULTIPLE in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotIn(List<String> values) {
            addCriterion("MULTIPLE not in", values, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleBetween(String value1, String value2) {
            addCriterion("MULTIPLE between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andMultipleNotBetween(String value1, String value2) {
            addCriterion("MULTIPLE not between", value1, value2, "multiple");
            return (Criteria) this;
        }

        public Criteria andFilterableIsNull() {
            addCriterion("FILTERABLE is null");
            return (Criteria) this;
        }

        public Criteria andFilterableIsNotNull() {
            addCriterion("FILTERABLE is not null");
            return (Criteria) this;
        }

        public Criteria andFilterableEqualTo(String value) {
            addCriterion("FILTERABLE =", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableNotEqualTo(String value) {
            addCriterion("FILTERABLE <>", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableGreaterThan(String value) {
            addCriterion("FILTERABLE >", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableGreaterThanOrEqualTo(String value) {
            addCriterion("FILTERABLE >=", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableLessThan(String value) {
            addCriterion("FILTERABLE <", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableLessThanOrEqualTo(String value) {
            addCriterion("FILTERABLE <=", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableLike(String value) {
            addCriterion("FILTERABLE like", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableNotLike(String value) {
            addCriterion("FILTERABLE not like", value, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableIn(List<String> values) {
            addCriterion("FILTERABLE in", values, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableNotIn(List<String> values) {
            addCriterion("FILTERABLE not in", values, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableBetween(String value1, String value2) {
            addCriterion("FILTERABLE between", value1, value2, "filterable");
            return (Criteria) this;
        }

        public Criteria andFilterableNotBetween(String value1, String value2) {
            addCriterion("FILTERABLE not between", value1, value2, "filterable");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNull() {
            addCriterion("OPTIONS is null");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNotNull() {
            addCriterion("OPTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andOptionsEqualTo(String value) {
            addCriterion("OPTIONS =", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotEqualTo(String value) {
            addCriterion("OPTIONS <>", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThan(String value) {
            addCriterion("OPTIONS >", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("OPTIONS >=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThan(String value) {
            addCriterion("OPTIONS <", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThanOrEqualTo(String value) {
            addCriterion("OPTIONS <=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLike(String value) {
            addCriterion("OPTIONS like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotLike(String value) {
            addCriterion("OPTIONS not like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsIn(List<String> values) {
            addCriterion("OPTIONS in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotIn(List<String> values) {
            addCriterion("OPTIONS not in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsBetween(String value1, String value2) {
            addCriterion("OPTIONS between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotBetween(String value1, String value2) {
            addCriterion("OPTIONS not between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("IS_DELETE like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("IS_DELETE not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Long> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Long> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }
    }

    /**
     *  * element_tab
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * element_tab 2018-11-23
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