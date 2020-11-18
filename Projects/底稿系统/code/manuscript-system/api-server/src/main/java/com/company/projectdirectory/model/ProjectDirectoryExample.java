/*
*
* ProjectDirectoryExample.java
*                    中证技术公司
* @date 2020-05-13
*/
package com.company.projectdirectory.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectDirectoryExample extends BaseExample implements Serializable {
    /**
     * projectdirectory
     */
    protected String orderByClause;

    /**
     * projectdirectory
     */
    protected boolean distinct;

    /**
     * projectdirectory
     */
    protected List<Criteria> oredCriteria;

    /**
     * projectdirectory
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public ProjectDirectoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-13
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
     * @mbg.generated 2020-05-13
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-13
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * projectdirectory 2020-05-13
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

        public Criteria andProjectidIsNull() {
            addCriterion("PROJECTID is null");
            return (Criteria) this;
        }

        public Criteria andProjectidIsNotNull() {
            addCriterion("PROJECTID is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidEqualTo(String value) {
            addCriterion("PROJECTID =", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotEqualTo(String value) {
            addCriterion("PROJECTID <>", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThan(String value) {
            addCriterion("PROJECTID >", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECTID >=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThan(String value) {
            addCriterion("PROJECTID <", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLessThanOrEqualTo(String value) {
            addCriterion("PROJECTID <=", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidLike(String value) {
            addCriterion("PROJECTID like", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotLike(String value) {
            addCriterion("PROJECTID not like", value, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidIn(List<String> values) {
            addCriterion("PROJECTID in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotIn(List<String> values) {
            addCriterion("PROJECTID not in", values, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidBetween(String value1, String value2) {
            addCriterion("PROJECTID between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andProjectidNotBetween(String value1, String value2) {
            addCriterion("PROJECTID not between", value1, value2, "projectid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidIsNull() {
            addCriterion("DIRECTORYID is null");
            return (Criteria) this;
        }

        public Criteria andDirectoryidIsNotNull() {
            addCriterion("DIRECTORYID is not null");
            return (Criteria) this;
        }

        public Criteria andDirectoryidEqualTo(String value) {
            addCriterion("DIRECTORYID =", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidNotEqualTo(String value) {
            addCriterion("DIRECTORYID <>", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidGreaterThan(String value) {
            addCriterion("DIRECTORYID >", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECTORYID >=", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidLessThan(String value) {
            addCriterion("DIRECTORYID <", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidLessThanOrEqualTo(String value) {
            addCriterion("DIRECTORYID <=", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidLike(String value) {
            addCriterion("DIRECTORYID like", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidNotLike(String value) {
            addCriterion("DIRECTORYID not like", value, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidIn(List<String> values) {
            addCriterion("DIRECTORYID in", values, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidNotIn(List<String> values) {
            addCriterion("DIRECTORYID not in", values, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidBetween(String value1, String value2) {
            addCriterion("DIRECTORYID between", value1, value2, "directoryid");
            return (Criteria) this;
        }

        public Criteria andDirectoryidNotBetween(String value1, String value2) {
            addCriterion("DIRECTORYID not between", value1, value2, "directoryid");
            return (Criteria) this;
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

        public Criteria andProcessnodeIsNull() {
            addCriterion("PROCESSNODE is null");
            return (Criteria) this;
        }

        public Criteria andProcessnodeIsNotNull() {
            addCriterion("PROCESSNODE is not null");
            return (Criteria) this;
        }

        public Criteria andProcessnodeEqualTo(String value) {
            addCriterion("PROCESSNODE =", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeNotEqualTo(String value) {
            addCriterion("PROCESSNODE <>", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeGreaterThan(String value) {
            addCriterion("PROCESSNODE >", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESSNODE >=", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeLessThan(String value) {
            addCriterion("PROCESSNODE <", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeLessThanOrEqualTo(String value) {
            addCriterion("PROCESSNODE <=", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeLike(String value) {
            addCriterion("PROCESSNODE like", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeNotLike(String value) {
            addCriterion("PROCESSNODE not like", value, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeIn(List<String> values) {
            addCriterion("PROCESSNODE in", values, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeNotIn(List<String> values) {
            addCriterion("PROCESSNODE not in", values, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeBetween(String value1, String value2) {
            addCriterion("PROCESSNODE between", value1, value2, "processnode");
            return (Criteria) this;
        }

        public Criteria andProcessnodeNotBetween(String value1, String value2) {
            addCriterion("PROCESSNODE not between", value1, value2, "processnode");
            return (Criteria) this;
        }

        public Criteria andDirectorynoIsNull() {
            addCriterion("DIRECTORYNO is null");
            return (Criteria) this;
        }

        public Criteria andDirectorynoIsNotNull() {
            addCriterion("DIRECTORYNO is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorynoEqualTo(String value) {
            addCriterion("DIRECTORYNO =", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoNotEqualTo(String value) {
            addCriterion("DIRECTORYNO <>", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoGreaterThan(String value) {
            addCriterion("DIRECTORYNO >", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECTORYNO >=", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoLessThan(String value) {
            addCriterion("DIRECTORYNO <", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoLessThanOrEqualTo(String value) {
            addCriterion("DIRECTORYNO <=", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoLike(String value) {
            addCriterion("DIRECTORYNO like", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoNotLike(String value) {
            addCriterion("DIRECTORYNO not like", value, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoIn(List<String> values) {
            addCriterion("DIRECTORYNO in", values, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoNotIn(List<String> values) {
            addCriterion("DIRECTORYNO not in", values, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoBetween(String value1, String value2) {
            addCriterion("DIRECTORYNO between", value1, value2, "directoryno");
            return (Criteria) this;
        }

        public Criteria andDirectorynoNotBetween(String value1, String value2) {
            addCriterion("DIRECTORYNO not between", value1, value2, "directoryno");
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

        public Criteria andVersionhashIsNull() {
            addCriterion("VERSIONHASH is null");
            return (Criteria) this;
        }

        public Criteria andVersionhashIsNotNull() {
            addCriterion("VERSIONHASH is not null");
            return (Criteria) this;
        }

        public Criteria andVersionhashEqualTo(String value) {
            addCriterion("VERSIONHASH =", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashNotEqualTo(String value) {
            addCriterion("VERSIONHASH <>", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashGreaterThan(String value) {
            addCriterion("VERSIONHASH >", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashGreaterThanOrEqualTo(String value) {
            addCriterion("VERSIONHASH >=", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashLessThan(String value) {
            addCriterion("VERSIONHASH <", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashLessThanOrEqualTo(String value) {
            addCriterion("VERSIONHASH <=", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashLike(String value) {
            addCriterion("VERSIONHASH like", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashNotLike(String value) {
            addCriterion("VERSIONHASH not like", value, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashIn(List<String> values) {
            addCriterion("VERSIONHASH in", values, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashNotIn(List<String> values) {
            addCriterion("VERSIONHASH not in", values, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashBetween(String value1, String value2) {
            addCriterion("VERSIONHASH between", value1, value2, "versionhash");
            return (Criteria) this;
        }

        public Criteria andVersionhashNotBetween(String value1, String value2) {
            addCriterion("VERSIONHASH not between", value1, value2, "versionhash");
            return (Criteria) this;
        }

        public Criteria andStageIsNull() {
            addCriterion("STAGE is null");
            return (Criteria) this;
        }

        public Criteria andStageIsNotNull() {
            addCriterion("STAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStageEqualTo(String value) {
            addCriterion("STAGE =", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotEqualTo(String value) {
            addCriterion("STAGE <>", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThan(String value) {
            addCriterion("STAGE >", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThanOrEqualTo(String value) {
            addCriterion("STAGE >=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThan(String value) {
            addCriterion("STAGE <", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThanOrEqualTo(String value) {
            addCriterion("STAGE <=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLike(String value) {
            addCriterion("STAGE like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotLike(String value) {
            addCriterion("STAGE not like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageIn(List<String> values) {
            addCriterion("STAGE in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotIn(List<String> values) {
            addCriterion("STAGE not in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageBetween(String value1, String value2) {
            addCriterion("STAGE between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotBetween(String value1, String value2) {
            addCriterion("STAGE not between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    /**
     *  * projectdirectory
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * projectdirectory 2020-05-13
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