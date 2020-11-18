/*
*
* BaseDirectoryExample.java
*                    中证技术公司
* @date 2020-03-21
*/
package com.company.basedirectory.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseDirectoryExample extends BaseExample implements Serializable {
    /**
     * basedirectory
     */
    protected String orderByClause;

    /**
     * basedirectory
     */
    protected boolean distinct;

    /**
     * basedirectory
     */
    protected List<Criteria> oredCriteria;

    /**
     * basedirectory
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public BaseDirectoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-03-21
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
     * @mbg.generated 2020-03-21
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-03-21
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * basedirectory 2020-03-21
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

        public Criteria andSnameIsNull() {
            addCriterion("SNAME is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("SNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("SNAME =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("SNAME <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("SNAME >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("SNAME >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("SNAME <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("SNAME <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("SNAME like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("SNAME not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("SNAME in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("SNAME not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("SNAME between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("SNAME not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNull() {
            addCriterion("FULLNAME is null");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNotNull() {
            addCriterion("FULLNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFullnameEqualTo(String value) {
            addCriterion("FULLNAME =", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotEqualTo(String value) {
            addCriterion("FULLNAME <>", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThan(String value) {
            addCriterion("FULLNAME >", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("FULLNAME >=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThan(String value) {
            addCriterion("FULLNAME <", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThanOrEqualTo(String value) {
            addCriterion("FULLNAME <=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLike(String value) {
            addCriterion("FULLNAME like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotLike(String value) {
            addCriterion("FULLNAME not like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameIn(List<String> values) {
            addCriterion("FULLNAME in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotIn(List<String> values) {
            addCriterion("FULLNAME not in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameBetween(String value1, String value2) {
            addCriterion("FULLNAME between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotBetween(String value1, String value2) {
            addCriterion("FULLNAME not between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("PARENTID is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("PARENTID is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("PARENTID =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("PARENTID <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("PARENTID >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTID >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("PARENTID <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("PARENTID <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("PARENTID like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("PARENTID not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("PARENTID in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("PARENTID not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("PARENTID between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("PARENTID not between", value1, value2, "parentid");
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

        public Criteria andLevelIsNull() {
            addCriterion("LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("LEVEL =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("LEVEL <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("LEVEL >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("LEVEL >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("LEVEL <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("LEVEL <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("LEVEL like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("LEVEL not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("LEVEL in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("LEVEL not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("LEVEL between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("LEVEL not between", value1, value2, "level");
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

        public Criteria andDirentorynoIsNull() {
            addCriterion("DIRENTORYNO is null");
            return (Criteria) this;
        }

        public Criteria andDirentorynoIsNotNull() {
            addCriterion("DIRENTORYNO is not null");
            return (Criteria) this;
        }

        public Criteria andDirentorynoEqualTo(String value) {
            addCriterion("DIRENTORYNO =", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoNotEqualTo(String value) {
            addCriterion("DIRENTORYNO <>", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoGreaterThan(String value) {
            addCriterion("DIRENTORYNO >", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoGreaterThanOrEqualTo(String value) {
            addCriterion("DIRENTORYNO >=", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoLessThan(String value) {
            addCriterion("DIRENTORYNO <", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoLessThanOrEqualTo(String value) {
            addCriterion("DIRENTORYNO <=", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoLike(String value) {
            addCriterion("DIRENTORYNO like", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoNotLike(String value) {
            addCriterion("DIRENTORYNO not like", value, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoIn(List<String> values) {
            addCriterion("DIRENTORYNO in", values, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoNotIn(List<String> values) {
            addCriterion("DIRENTORYNO not in", values, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoBetween(String value1, String value2) {
            addCriterion("DIRENTORYNO between", value1, value2, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andDirentorynoNotBetween(String value1, String value2) {
            addCriterion("DIRENTORYNO not between", value1, value2, "direntoryno");
            return (Criteria) this;
        }

        public Criteria andIsappIsNull() {
            addCriterion("ISAPP is null");
            return (Criteria) this;
        }

        public Criteria andIsappIsNotNull() {
            addCriterion("ISAPP is not null");
            return (Criteria) this;
        }

        public Criteria andIsappEqualTo(Integer value) {
            addCriterion("ISAPP =", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappNotEqualTo(Integer value) {
            addCriterion("ISAPP <>", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappGreaterThan(Integer value) {
            addCriterion("ISAPP >", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISAPP >=", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappLessThan(Integer value) {
            addCriterion("ISAPP <", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappLessThanOrEqualTo(Integer value) {
            addCriterion("ISAPP <=", value, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappIn(List<Integer> values) {
            addCriterion("ISAPP in", values, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappNotIn(List<Integer> values) {
            addCriterion("ISAPP not in", values, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappBetween(Integer value1, Integer value2) {
            addCriterion("ISAPP between", value1, value2, "isapp");
            return (Criteria) this;
        }

        public Criteria andIsappNotBetween(Integer value1, Integer value2) {
            addCriterion("ISAPP not between", value1, value2, "isapp");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("CREATEUSER is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("CREATEUSER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("CREATEUSER =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("CREATEUSER <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("CREATEUSER >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATEUSER >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("CREATEUSER <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("CREATEUSER <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("CREATEUSER like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("CREATEUSER not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("CREATEUSER in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("CREATEUSER not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("CREATEUSER between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("CREATEUSER not between", value1, value2, "createuser");
            return (Criteria) this;
        }
    }

    /**
     *  * basedirectory
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * basedirectory 2020-03-21
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