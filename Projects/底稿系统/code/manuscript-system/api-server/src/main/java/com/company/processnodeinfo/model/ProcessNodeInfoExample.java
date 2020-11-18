/*
*
* ProcessNodeInfoExample.java
*                    中证技术公司
* @date 2020-02-03
*/
package com.company.processnodeinfo.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProcessNodeInfoExample extends BaseExample implements Serializable {
    /**
     * processnodeinfo
     */
    protected String orderByClause;

    /**
     * processnodeinfo
     */
    protected boolean distinct;

    /**
     * processnodeinfo
     */
    protected List<Criteria> oredCriteria;

    /**
     * processnodeinfo
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public ProcessNodeInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-02-03
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
     * @mbg.generated 2020-02-03
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-02-03
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * processnodeinfo 2020-02-03
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andProcessnodenameIsNull() {
            addCriterion("PROCESSNODENAME is null");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameIsNotNull() {
            addCriterion("PROCESSNODENAME is not null");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameEqualTo(String value) {
            addCriterion("PROCESSNODENAME =", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameNotEqualTo(String value) {
            addCriterion("PROCESSNODENAME <>", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameGreaterThan(String value) {
            addCriterion("PROCESSNODENAME >", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameGreaterThanOrEqualTo(String value) {
            addCriterion("PROCESSNODENAME >=", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameLessThan(String value) {
            addCriterion("PROCESSNODENAME <", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameLessThanOrEqualTo(String value) {
            addCriterion("PROCESSNODENAME <=", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameLike(String value) {
            addCriterion("PROCESSNODENAME like", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameNotLike(String value) {
            addCriterion("PROCESSNODENAME not like", value, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameIn(List<String> values) {
            addCriterion("PROCESSNODENAME in", values, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameNotIn(List<String> values) {
            addCriterion("PROCESSNODENAME not in", values, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameBetween(String value1, String value2) {
            addCriterion("PROCESSNODENAME between", value1, value2, "processnodename");
            return (Criteria) this;
        }

        public Criteria andProcessnodenameNotBetween(String value1, String value2) {
            addCriterion("PROCESSNODENAME not between", value1, value2, "processnodename");
            return (Criteria) this;
        }

        public Criteria andOpertypeIsNull() {
            addCriterion("OPERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOpertypeIsNotNull() {
            addCriterion("OPERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpertypeEqualTo(String value) {
            addCriterion("OPERTYPE =", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotEqualTo(String value) {
            addCriterion("OPERTYPE <>", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeGreaterThan(String value) {
            addCriterion("OPERTYPE >", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPERTYPE >=", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeLessThan(String value) {
            addCriterion("OPERTYPE <", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeLessThanOrEqualTo(String value) {
            addCriterion("OPERTYPE <=", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeLike(String value) {
            addCriterion("OPERTYPE like", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotLike(String value) {
            addCriterion("OPERTYPE not like", value, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeIn(List<String> values) {
            addCriterion("OPERTYPE in", values, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotIn(List<String> values) {
            addCriterion("OPERTYPE not in", values, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeBetween(String value1, String value2) {
            addCriterion("OPERTYPE between", value1, value2, "opertype");
            return (Criteria) this;
        }

        public Criteria andOpertypeNotBetween(String value1, String value2) {
            addCriterion("OPERTYPE not between", value1, value2, "opertype");
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
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
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

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
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
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
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

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
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
    }

    /**
     *  * processnodeinfo
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * processnodeinfo 2020-02-03
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