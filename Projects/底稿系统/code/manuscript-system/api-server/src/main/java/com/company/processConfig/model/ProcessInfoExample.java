/*
*
* ProcessInfoExample.java
*                    中证技术公司
* @date 2020-08-04
*/
package com.company.processConfig.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProcessInfoExample extends BaseExample implements Serializable {
    /**
     * processinfo
     */
    protected String orderByClause;

    /**
     * processinfo
     */
    protected boolean distinct;

    /**
     * processinfo
     */
    protected List<Criteria> oredCriteria;

    /**
     * processinfo
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public ProcessInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-08-04
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
     * @mbg.generated 2020-08-04
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-08-04
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * processinfo 2020-08-04
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

        public Criteria andStartprocessnodeIsNull() {
            addCriterion("STARTPROCESSNODE is null");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeIsNotNull() {
            addCriterion("STARTPROCESSNODE is not null");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeEqualTo(String value) {
            addCriterion("STARTPROCESSNODE =", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeNotEqualTo(String value) {
            addCriterion("STARTPROCESSNODE <>", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeGreaterThan(String value) {
            addCriterion("STARTPROCESSNODE >", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeGreaterThanOrEqualTo(String value) {
            addCriterion("STARTPROCESSNODE >=", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeLessThan(String value) {
            addCriterion("STARTPROCESSNODE <", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeLessThanOrEqualTo(String value) {
            addCriterion("STARTPROCESSNODE <=", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeLike(String value) {
            addCriterion("STARTPROCESSNODE like", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeNotLike(String value) {
            addCriterion("STARTPROCESSNODE not like", value, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeIn(List<String> values) {
            addCriterion("STARTPROCESSNODE in", values, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeNotIn(List<String> values) {
            addCriterion("STARTPROCESSNODE not in", values, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeBetween(String value1, String value2) {
            addCriterion("STARTPROCESSNODE between", value1, value2, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andStartprocessnodeNotBetween(String value1, String value2) {
            addCriterion("STARTPROCESSNODE not between", value1, value2, "startprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeIsNull() {
            addCriterion("ENDPROCESSNODE is null");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeIsNotNull() {
            addCriterion("ENDPROCESSNODE is not null");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeEqualTo(String value) {
            addCriterion("ENDPROCESSNODE =", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeNotEqualTo(String value) {
            addCriterion("ENDPROCESSNODE <>", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeGreaterThan(String value) {
            addCriterion("ENDPROCESSNODE >", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeGreaterThanOrEqualTo(String value) {
            addCriterion("ENDPROCESSNODE >=", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeLessThan(String value) {
            addCriterion("ENDPROCESSNODE <", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeLessThanOrEqualTo(String value) {
            addCriterion("ENDPROCESSNODE <=", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeLike(String value) {
            addCriterion("ENDPROCESSNODE like", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeNotLike(String value) {
            addCriterion("ENDPROCESSNODE not like", value, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeIn(List<String> values) {
            addCriterion("ENDPROCESSNODE in", values, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeNotIn(List<String> values) {
            addCriterion("ENDPROCESSNODE not in", values, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeBetween(String value1, String value2) {
            addCriterion("ENDPROCESSNODE between", value1, value2, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andEndprocessnodeNotBetween(String value1, String value2) {
            addCriterion("ENDPROCESSNODE not between", value1, value2, "endprocessnode");
            return (Criteria) this;
        }

        public Criteria andOperidIsNull() {
            addCriterion("OPERID is null");
            return (Criteria) this;
        }

        public Criteria andOperidIsNotNull() {
            addCriterion("OPERID is not null");
            return (Criteria) this;
        }

        public Criteria andOperidEqualTo(String value) {
            addCriterion("OPERID =", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidNotEqualTo(String value) {
            addCriterion("OPERID <>", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidGreaterThan(String value) {
            addCriterion("OPERID >", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidGreaterThanOrEqualTo(String value) {
            addCriterion("OPERID >=", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidLessThan(String value) {
            addCriterion("OPERID <", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidLessThanOrEqualTo(String value) {
            addCriterion("OPERID <=", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidLike(String value) {
            addCriterion("OPERID like", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidNotLike(String value) {
            addCriterion("OPERID not like", value, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidIn(List<String> values) {
            addCriterion("OPERID in", values, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidNotIn(List<String> values) {
            addCriterion("OPERID not in", values, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidBetween(String value1, String value2) {
            addCriterion("OPERID between", value1, value2, "operid");
            return (Criteria) this;
        }

        public Criteria andOperidNotBetween(String value1, String value2) {
            addCriterion("OPERID not between", value1, value2, "operid");
            return (Criteria) this;
        }
    }

    /**
     *  * processinfo
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * processinfo 2020-08-04
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