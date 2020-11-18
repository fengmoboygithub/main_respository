/*
*
* ProcessStageInfoExample.java
*                    中证技术公司
* @date 2020-08-03
*/
package com.company.processConfig.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProcessStageInfoExample extends BaseExample implements Serializable {
    /**
     * processstage
     */
    protected String orderByClause;

    /**
     * processstage
     */
    protected boolean distinct;

    /**
     * processstage
     */
    protected List<Criteria> oredCriteria;

    /**
     * processstage
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public ProcessStageInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-08-03
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
     * @mbg.generated 2020-08-03
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-08-03
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * processstage 2020-08-03
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProcessidIsNull() {
            addCriterion("PROCESSID is null");
            return (Criteria) this;
        }

        public Criteria andProcessidIsNotNull() {
            addCriterion("PROCESSID is not null");
            return (Criteria) this;
        }

        public Criteria andProcessidEqualTo(String value) {
            addCriterion("PROCESSID =", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidNotEqualTo(String value) {
            addCriterion("PROCESSID <>", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidGreaterThan(String value) {
            addCriterion("PROCESSID >", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESSID >=", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidLessThan(String value) {
            addCriterion("PROCESSID <", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidLessThanOrEqualTo(String value) {
            addCriterion("PROCESSID <=", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidLike(String value) {
            addCriterion("PROCESSID like", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidNotLike(String value) {
            addCriterion("PROCESSID not like", value, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidIn(List<String> values) {
            addCriterion("PROCESSID in", values, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidNotIn(List<String> values) {
            addCriterion("PROCESSID not in", values, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidBetween(String value1, String value2) {
            addCriterion("PROCESSID between", value1, value2, "processid");
            return (Criteria) this;
        }

        public Criteria andProcessidNotBetween(String value1, String value2) {
            addCriterion("PROCESSID not between", value1, value2, "processid");
            return (Criteria) this;
        }

        public Criteria andProjecttypeIsNull() {
            addCriterion("PROJECTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andProjecttypeIsNotNull() {
            addCriterion("PROJECTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProjecttypeEqualTo(String value) {
            addCriterion("PROJECTTYPE =", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeNotEqualTo(String value) {
            addCriterion("PROJECTTYPE <>", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeGreaterThan(String value) {
            addCriterion("PROJECTTYPE >", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECTTYPE >=", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeLessThan(String value) {
            addCriterion("PROJECTTYPE <", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeLessThanOrEqualTo(String value) {
            addCriterion("PROJECTTYPE <=", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeLike(String value) {
            addCriterion("PROJECTTYPE like", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeNotLike(String value) {
            addCriterion("PROJECTTYPE not like", value, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeIn(List<String> values) {
            addCriterion("PROJECTTYPE in", values, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeNotIn(List<String> values) {
            addCriterion("PROJECTTYPE not in", values, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeBetween(String value1, String value2) {
            addCriterion("PROJECTTYPE between", value1, value2, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjecttypeNotBetween(String value1, String value2) {
            addCriterion("PROJECTTYPE not between", value1, value2, "projecttype");
            return (Criteria) this;
        }

        public Criteria andProjectstageIsNull() {
            addCriterion("PROJECTSTAGE is null");
            return (Criteria) this;
        }

        public Criteria andProjectstageIsNotNull() {
            addCriterion("PROJECTSTAGE is not null");
            return (Criteria) this;
        }

        public Criteria andProjectstageEqualTo(String value) {
            addCriterion("PROJECTSTAGE =", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageNotEqualTo(String value) {
            addCriterion("PROJECTSTAGE <>", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageGreaterThan(String value) {
            addCriterion("PROJECTSTAGE >", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECTSTAGE >=", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageLessThan(String value) {
            addCriterion("PROJECTSTAGE <", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageLessThanOrEqualTo(String value) {
            addCriterion("PROJECTSTAGE <=", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageLike(String value) {
            addCriterion("PROJECTSTAGE like", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageNotLike(String value) {
            addCriterion("PROJECTSTAGE not like", value, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageIn(List<String> values) {
            addCriterion("PROJECTSTAGE in", values, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageNotIn(List<String> values) {
            addCriterion("PROJECTSTAGE not in", values, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageBetween(String value1, String value2) {
            addCriterion("PROJECTSTAGE between", value1, value2, "projectstage");
            return (Criteria) this;
        }

        public Criteria andProjectstageNotBetween(String value1, String value2) {
            addCriterion("PROJECTSTAGE not between", value1, value2, "projectstage");
            return (Criteria) this;
        }

        public Criteria andGraphidIsNull() {
            addCriterion("GRAPHID is null");
            return (Criteria) this;
        }

        public Criteria andGraphidIsNotNull() {
            addCriterion("GRAPHID is not null");
            return (Criteria) this;
        }

        public Criteria andGraphidEqualTo(String value) {
            addCriterion("GRAPHID =", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidNotEqualTo(String value) {
            addCriterion("GRAPHID <>", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidGreaterThan(String value) {
            addCriterion("GRAPHID >", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidGreaterThanOrEqualTo(String value) {
            addCriterion("GRAPHID >=", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidLessThan(String value) {
            addCriterion("GRAPHID <", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidLessThanOrEqualTo(String value) {
            addCriterion("GRAPHID <=", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidLike(String value) {
            addCriterion("GRAPHID like", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidNotLike(String value) {
            addCriterion("GRAPHID not like", value, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidIn(List<String> values) {
            addCriterion("GRAPHID in", values, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidNotIn(List<String> values) {
            addCriterion("GRAPHID not in", values, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidBetween(String value1, String value2) {
            addCriterion("GRAPHID between", value1, value2, "graphid");
            return (Criteria) this;
        }

        public Criteria andGraphidNotBetween(String value1, String value2) {
            addCriterion("GRAPHID not between", value1, value2, "graphid");
            return (Criteria) this;
        }
    }

    /**
     *  * processstage
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * processstage 2020-08-03
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