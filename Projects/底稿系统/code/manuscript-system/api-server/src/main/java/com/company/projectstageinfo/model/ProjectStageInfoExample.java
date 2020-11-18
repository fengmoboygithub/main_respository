/*
*
* ProjectStageInfoExample.java
*                    中证技术公司
* @date 2020-05-02
*/
package com.company.projectstageinfo.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectStageInfoExample extends BaseExample implements Serializable {
    /**
     * stageinfo
     */
    protected String orderByClause;

    /**
     * stageinfo
     */
    protected boolean distinct;

    /**
     * stageinfo
     */
    protected List<Criteria> oredCriteria;

    /**
     * stageinfo
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public ProjectStageInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-02
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
     * @mbg.generated 2020-05-02
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-02
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * stageinfo 2020-05-02
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

        public Criteria andStagenameIsNull() {
            addCriterion("STAGENAME is null");
            return (Criteria) this;
        }

        public Criteria andStagenameIsNotNull() {
            addCriterion("STAGENAME is not null");
            return (Criteria) this;
        }

        public Criteria andStagenameEqualTo(String value) {
            addCriterion("STAGENAME =", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotEqualTo(String value) {
            addCriterion("STAGENAME <>", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameGreaterThan(String value) {
            addCriterion("STAGENAME >", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameGreaterThanOrEqualTo(String value) {
            addCriterion("STAGENAME >=", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameLessThan(String value) {
            addCriterion("STAGENAME <", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameLessThanOrEqualTo(String value) {
            addCriterion("STAGENAME <=", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameLike(String value) {
            addCriterion("STAGENAME like", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotLike(String value) {
            addCriterion("STAGENAME not like", value, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameIn(List<String> values) {
            addCriterion("STAGENAME in", values, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotIn(List<String> values) {
            addCriterion("STAGENAME not in", values, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameBetween(String value1, String value2) {
            addCriterion("STAGENAME between", value1, value2, "stagename");
            return (Criteria) this;
        }

        public Criteria andStagenameNotBetween(String value1, String value2) {
            addCriterion("STAGENAME not between", value1, value2, "stagename");
            return (Criteria) this;
        }
    }

    /**
     *  * stageinfo
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * stageinfo 2020-05-02
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