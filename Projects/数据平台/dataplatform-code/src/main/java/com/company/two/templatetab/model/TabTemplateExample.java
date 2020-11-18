/*
*
* TabTemplateExample.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.two.templatetab.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TabTemplateExample extends BaseExample implements Serializable {
    /**
     * tab_template
     */
    protected String orderByClause;

    /**
     * tab_template
     */
    protected boolean distinct;

    /**
     * tab_template
     */
    protected List<Criteria> oredCriteria;

    /**
     * tab_template
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public TabTemplateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-10-31
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
     * @mbg.generated 2019-10-31
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * tab_template 2019-10-31
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

        public Criteria andTTemplateTypeIsNull() {
            addCriterion("T_TEMPLATE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeIsNotNull() {
            addCriterion("T_TEMPLATE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeEqualTo(String value) {
            addCriterion("T_TEMPLATE_TYPE =", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeNotEqualTo(String value) {
            addCriterion("T_TEMPLATE_TYPE <>", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeGreaterThan(String value) {
            addCriterion("T_TEMPLATE_TYPE >", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("T_TEMPLATE_TYPE >=", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeLessThan(String value) {
            addCriterion("T_TEMPLATE_TYPE <", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeLessThanOrEqualTo(String value) {
            addCriterion("T_TEMPLATE_TYPE <=", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeLike(String value) {
            addCriterion("T_TEMPLATE_TYPE like", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeNotLike(String value) {
            addCriterion("T_TEMPLATE_TYPE not like", value, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeIn(List<String> values) {
            addCriterion("T_TEMPLATE_TYPE in", values, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeNotIn(List<String> values) {
            addCriterion("T_TEMPLATE_TYPE not in", values, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeBetween(String value1, String value2) {
            addCriterion("T_TEMPLATE_TYPE between", value1, value2, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTTemplateTypeNotBetween(String value1, String value2) {
            addCriterion("T_TEMPLATE_TYPE not between", value1, value2, "tTemplateType");
            return (Criteria) this;
        }

        public Criteria andTElementIdIsNull() {
            addCriterion("T_ELEMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTElementIdIsNotNull() {
            addCriterion("T_ELEMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTElementIdEqualTo(String value) {
            addCriterion("T_ELEMENT_ID =", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdNotEqualTo(String value) {
            addCriterion("T_ELEMENT_ID <>", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdGreaterThan(String value) {
            addCriterion("T_ELEMENT_ID >", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdGreaterThanOrEqualTo(String value) {
            addCriterion("T_ELEMENT_ID >=", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdLessThan(String value) {
            addCriterion("T_ELEMENT_ID <", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdLessThanOrEqualTo(String value) {
            addCriterion("T_ELEMENT_ID <=", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdLike(String value) {
            addCriterion("T_ELEMENT_ID like", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdNotLike(String value) {
            addCriterion("T_ELEMENT_ID not like", value, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdIn(List<String> values) {
            addCriterion("T_ELEMENT_ID in", values, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdNotIn(List<String> values) {
            addCriterion("T_ELEMENT_ID not in", values, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdBetween(String value1, String value2) {
            addCriterion("T_ELEMENT_ID between", value1, value2, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementIdNotBetween(String value1, String value2) {
            addCriterion("T_ELEMENT_ID not between", value1, value2, "tElementId");
            return (Criteria) this;
        }

        public Criteria andTElementNameIsNull() {
            addCriterion("T_ELEMENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTElementNameIsNotNull() {
            addCriterion("T_ELEMENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTElementNameEqualTo(String value) {
            addCriterion("T_ELEMENT_NAME =", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameNotEqualTo(String value) {
            addCriterion("T_ELEMENT_NAME <>", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameGreaterThan(String value) {
            addCriterion("T_ELEMENT_NAME >", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameGreaterThanOrEqualTo(String value) {
            addCriterion("T_ELEMENT_NAME >=", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameLessThan(String value) {
            addCriterion("T_ELEMENT_NAME <", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameLessThanOrEqualTo(String value) {
            addCriterion("T_ELEMENT_NAME <=", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameLike(String value) {
            addCriterion("T_ELEMENT_NAME like", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameNotLike(String value) {
            addCriterion("T_ELEMENT_NAME not like", value, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameIn(List<String> values) {
            addCriterion("T_ELEMENT_NAME in", values, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameNotIn(List<String> values) {
            addCriterion("T_ELEMENT_NAME not in", values, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameBetween(String value1, String value2) {
            addCriterion("T_ELEMENT_NAME between", value1, value2, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTElementNameNotBetween(String value1, String value2) {
            addCriterion("T_ELEMENT_NAME not between", value1, value2, "tElementName");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesIsNull() {
            addCriterion("T_VALIDATE_RULES is null");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesIsNotNull() {
            addCriterion("T_VALIDATE_RULES is not null");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesEqualTo(String value) {
            addCriterion("T_VALIDATE_RULES =", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesNotEqualTo(String value) {
            addCriterion("T_VALIDATE_RULES <>", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesGreaterThan(String value) {
            addCriterion("T_VALIDATE_RULES >", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesGreaterThanOrEqualTo(String value) {
            addCriterion("T_VALIDATE_RULES >=", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesLessThan(String value) {
            addCriterion("T_VALIDATE_RULES <", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesLessThanOrEqualTo(String value) {
            addCriterion("T_VALIDATE_RULES <=", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesLike(String value) {
            addCriterion("T_VALIDATE_RULES like", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesNotLike(String value) {
            addCriterion("T_VALIDATE_RULES not like", value, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesIn(List<String> values) {
            addCriterion("T_VALIDATE_RULES in", values, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesNotIn(List<String> values) {
            addCriterion("T_VALIDATE_RULES not in", values, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesBetween(String value1, String value2) {
            addCriterion("T_VALIDATE_RULES between", value1, value2, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andTValidateRulesNotBetween(String value1, String value2) {
            addCriterion("T_VALIDATE_RULES not between", value1, value2, "tValidateRules");
            return (Criteria) this;
        }

        public Criteria andDFieldIsNull() {
            addCriterion("D_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andDFieldIsNotNull() {
            addCriterion("D_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andDFieldEqualTo(String value) {
            addCriterion("D_FIELD =", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldNotEqualTo(String value) {
            addCriterion("D_FIELD <>", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldGreaterThan(String value) {
            addCriterion("D_FIELD >", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldGreaterThanOrEqualTo(String value) {
            addCriterion("D_FIELD >=", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldLessThan(String value) {
            addCriterion("D_FIELD <", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldLessThanOrEqualTo(String value) {
            addCriterion("D_FIELD <=", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldLike(String value) {
            addCriterion("D_FIELD like", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldNotLike(String value) {
            addCriterion("D_FIELD not like", value, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldIn(List<String> values) {
            addCriterion("D_FIELD in", values, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldNotIn(List<String> values) {
            addCriterion("D_FIELD not in", values, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldBetween(String value1, String value2) {
            addCriterion("D_FIELD between", value1, value2, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldNotBetween(String value1, String value2) {
            addCriterion("D_FIELD not between", value1, value2, "dField");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeIsNull() {
            addCriterion("D_FIELD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeIsNotNull() {
            addCriterion("D_FIELD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeEqualTo(String value) {
            addCriterion("D_FIELD_TYPE =", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeNotEqualTo(String value) {
            addCriterion("D_FIELD_TYPE <>", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeGreaterThan(String value) {
            addCriterion("D_FIELD_TYPE >", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeGreaterThanOrEqualTo(String value) {
            addCriterion("D_FIELD_TYPE >=", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeLessThan(String value) {
            addCriterion("D_FIELD_TYPE <", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeLessThanOrEqualTo(String value) {
            addCriterion("D_FIELD_TYPE <=", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeLike(String value) {
            addCriterion("D_FIELD_TYPE like", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeNotLike(String value) {
            addCriterion("D_FIELD_TYPE not like", value, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeIn(List<String> values) {
            addCriterion("D_FIELD_TYPE in", values, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeNotIn(List<String> values) {
            addCriterion("D_FIELD_TYPE not in", values, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeBetween(String value1, String value2) {
            addCriterion("D_FIELD_TYPE between", value1, value2, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDFieldTypeNotBetween(String value1, String value2) {
            addCriterion("D_FIELD_TYPE not between", value1, value2, "dFieldType");
            return (Criteria) this;
        }

        public Criteria andDTableNameIsNull() {
            addCriterion("D_TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDTableNameIsNotNull() {
            addCriterion("D_TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDTableNameEqualTo(String value) {
            addCriterion("D_TABLE_NAME =", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameNotEqualTo(String value) {
            addCriterion("D_TABLE_NAME <>", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameGreaterThan(String value) {
            addCriterion("D_TABLE_NAME >", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("D_TABLE_NAME >=", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameLessThan(String value) {
            addCriterion("D_TABLE_NAME <", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameLessThanOrEqualTo(String value) {
            addCriterion("D_TABLE_NAME <=", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameLike(String value) {
            addCriterion("D_TABLE_NAME like", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameNotLike(String value) {
            addCriterion("D_TABLE_NAME not like", value, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameIn(List<String> values) {
            addCriterion("D_TABLE_NAME in", values, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameNotIn(List<String> values) {
            addCriterion("D_TABLE_NAME not in", values, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameBetween(String value1, String value2) {
            addCriterion("D_TABLE_NAME between", value1, value2, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDTableNameNotBetween(String value1, String value2) {
            addCriterion("D_TABLE_NAME not between", value1, value2, "dTableName");
            return (Criteria) this;
        }

        public Criteria andDIsTupleIsNull() {
            addCriterion("D_IS_TUPLE is null");
            return (Criteria) this;
        }

        public Criteria andDIsTupleIsNotNull() {
            addCriterion("D_IS_TUPLE is not null");
            return (Criteria) this;
        }

        public Criteria andDIsTupleEqualTo(String value) {
            addCriterion("D_IS_TUPLE =", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleNotEqualTo(String value) {
            addCriterion("D_IS_TUPLE <>", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleGreaterThan(String value) {
            addCriterion("D_IS_TUPLE >", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleGreaterThanOrEqualTo(String value) {
            addCriterion("D_IS_TUPLE >=", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleLessThan(String value) {
            addCriterion("D_IS_TUPLE <", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleLessThanOrEqualTo(String value) {
            addCriterion("D_IS_TUPLE <=", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleLike(String value) {
            addCriterion("D_IS_TUPLE like", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleNotLike(String value) {
            addCriterion("D_IS_TUPLE not like", value, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleIn(List<String> values) {
            addCriterion("D_IS_TUPLE in", values, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleNotIn(List<String> values) {
            addCriterion("D_IS_TUPLE not in", values, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleBetween(String value1, String value2) {
            addCriterion("D_IS_TUPLE between", value1, value2, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andDIsTupleNotBetween(String value1, String value2) {
            addCriterion("D_IS_TUPLE not between", value1, value2, "dIsTuple");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDDictIsNull() {
            addCriterion("D_DICT is null");
            return (Criteria) this;
        }

        public Criteria andDDictIsNotNull() {
            addCriterion("D_DICT is not null");
            return (Criteria) this;
        }

        public Criteria andDDictEqualTo(String value) {
            addCriterion("D_DICT =", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictNotEqualTo(String value) {
            addCriterion("D_DICT <>", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictGreaterThan(String value) {
            addCriterion("D_DICT >", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictGreaterThanOrEqualTo(String value) {
            addCriterion("D_DICT >=", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictLessThan(String value) {
            addCriterion("D_DICT <", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictLessThanOrEqualTo(String value) {
            addCriterion("D_DICT <=", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictLike(String value) {
            addCriterion("D_DICT like", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictNotLike(String value) {
            addCriterion("D_DICT not like", value, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictIn(List<String> values) {
            addCriterion("D_DICT in", values, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictNotIn(List<String> values) {
            addCriterion("D_DICT not in", values, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictBetween(String value1, String value2) {
            addCriterion("D_DICT between", value1, value2, "dDict");
            return (Criteria) this;
        }

        public Criteria andDDictNotBetween(String value1, String value2) {
            addCriterion("D_DICT not between", value1, value2, "dDict");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameIsNull() {
            addCriterion("D_TUPLE_UP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameIsNotNull() {
            addCriterion("D_TUPLE_UP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameEqualTo(String value) {
            addCriterion("D_TUPLE_UP_NAME =", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameNotEqualTo(String value) {
            addCriterion("D_TUPLE_UP_NAME <>", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameGreaterThan(String value) {
            addCriterion("D_TUPLE_UP_NAME >", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameGreaterThanOrEqualTo(String value) {
            addCriterion("D_TUPLE_UP_NAME >=", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameLessThan(String value) {
            addCriterion("D_TUPLE_UP_NAME <", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameLessThanOrEqualTo(String value) {
            addCriterion("D_TUPLE_UP_NAME <=", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameLike(String value) {
            addCriterion("D_TUPLE_UP_NAME like", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameNotLike(String value) {
            addCriterion("D_TUPLE_UP_NAME not like", value, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameIn(List<String> values) {
            addCriterion("D_TUPLE_UP_NAME in", values, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameNotIn(List<String> values) {
            addCriterion("D_TUPLE_UP_NAME not in", values, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameBetween(String value1, String value2) {
            addCriterion("D_TUPLE_UP_NAME between", value1, value2, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpNameNotBetween(String value1, String value2) {
            addCriterion("D_TUPLE_UP_NAME not between", value1, value2, "dTupleUpName");
            return (Criteria) this;
        }

        public Criteria andTControlTypeIsNull() {
            addCriterion("T_CONTROL_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTControlTypeIsNotNull() {
            addCriterion("T_CONTROL_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTControlTypeEqualTo(String value) {
            addCriterion("T_CONTROL_TYPE =", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeNotEqualTo(String value) {
            addCriterion("T_CONTROL_TYPE <>", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeGreaterThan(String value) {
            addCriterion("T_CONTROL_TYPE >", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("T_CONTROL_TYPE >=", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeLessThan(String value) {
            addCriterion("T_CONTROL_TYPE <", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeLessThanOrEqualTo(String value) {
            addCriterion("T_CONTROL_TYPE <=", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeLike(String value) {
            addCriterion("T_CONTROL_TYPE like", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeNotLike(String value) {
            addCriterion("T_CONTROL_TYPE not like", value, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeIn(List<String> values) {
            addCriterion("T_CONTROL_TYPE in", values, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeNotIn(List<String> values) {
            addCriterion("T_CONTROL_TYPE not in", values, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeBetween(String value1, String value2) {
            addCriterion("T_CONTROL_TYPE between", value1, value2, "tControlType");
            return (Criteria) this;
        }

        public Criteria andTControlTypeNotBetween(String value1, String value2) {
            addCriterion("T_CONTROL_TYPE not between", value1, value2, "tControlType");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameIsNull() {
            addCriterion("D_TUPLE_UP_XBRL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameIsNotNull() {
            addCriterion("D_TUPLE_UP_XBRL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameEqualTo(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME =", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameNotEqualTo(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME <>", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameGreaterThan(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME >", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameGreaterThanOrEqualTo(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME >=", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameLessThan(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME <", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameLessThanOrEqualTo(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME <=", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameLike(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME like", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameNotLike(String value) {
            addCriterion("D_TUPLE_UP_XBRL_NAME not like", value, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameIn(List<String> values) {
            addCriterion("D_TUPLE_UP_XBRL_NAME in", values, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameNotIn(List<String> values) {
            addCriterion("D_TUPLE_UP_XBRL_NAME not in", values, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameBetween(String value1, String value2) {
            addCriterion("D_TUPLE_UP_XBRL_NAME between", value1, value2, "dTupleUpXbrlName");
            return (Criteria) this;
        }

        public Criteria andDTupleUpXbrlNameNotBetween(String value1, String value2) {
            addCriterion("D_TUPLE_UP_XBRL_NAME not between", value1, value2, "dTupleUpXbrlName");
            return (Criteria) this;
        }
    }

    /**
     *  * tab_template
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * tab_template 2019-10-31
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