/*
*
* MessageCenterExample.java
*                    中证技术公司
* @date 2020-07-27
*/
package com.company.messagecenter.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageCenterExample extends BaseExample implements Serializable {
    /**
     * messagecenter
     */
    protected String orderByClause;

    /**
     * messagecenter
     */
    protected boolean distinct;

    /**
     * messagecenter
     */
    protected List<Criteria> oredCriteria;

    /**
     * messagecenter
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public MessageCenterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-07-27
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
     * @mbg.generated 2020-07-27
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-07-27
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * messagecenter 2020-07-27
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

        public Criteria andMgcontentIsNull() {
            addCriterion("MGCONTENT is null");
            return (Criteria) this;
        }

        public Criteria andMgcontentIsNotNull() {
            addCriterion("MGCONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andMgcontentEqualTo(String value) {
            addCriterion("MGCONTENT =", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentNotEqualTo(String value) {
            addCriterion("MGCONTENT <>", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentGreaterThan(String value) {
            addCriterion("MGCONTENT >", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentGreaterThanOrEqualTo(String value) {
            addCriterion("MGCONTENT >=", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentLessThan(String value) {
            addCriterion("MGCONTENT <", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentLessThanOrEqualTo(String value) {
            addCriterion("MGCONTENT <=", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentLike(String value) {
            addCriterion("MGCONTENT like", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentNotLike(String value) {
            addCriterion("MGCONTENT not like", value, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentIn(List<String> values) {
            addCriterion("MGCONTENT in", values, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentNotIn(List<String> values) {
            addCriterion("MGCONTENT not in", values, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentBetween(String value1, String value2) {
            addCriterion("MGCONTENT between", value1, value2, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgcontentNotBetween(String value1, String value2) {
            addCriterion("MGCONTENT not between", value1, value2, "mgcontent");
            return (Criteria) this;
        }

        public Criteria andMgtypeIsNull() {
            addCriterion("MGTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMgtypeIsNotNull() {
            addCriterion("MGTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMgtypeEqualTo(String value) {
            addCriterion("MGTYPE =", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeNotEqualTo(String value) {
            addCriterion("MGTYPE <>", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeGreaterThan(String value) {
            addCriterion("MGTYPE >", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("MGTYPE >=", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeLessThan(String value) {
            addCriterion("MGTYPE <", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeLessThanOrEqualTo(String value) {
            addCriterion("MGTYPE <=", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeLike(String value) {
            addCriterion("MGTYPE like", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeNotLike(String value) {
            addCriterion("MGTYPE not like", value, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeIn(List<String> values) {
            addCriterion("MGTYPE in", values, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeNotIn(List<String> values) {
            addCriterion("MGTYPE not in", values, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeBetween(String value1, String value2) {
            addCriterion("MGTYPE between", value1, value2, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgtypeNotBetween(String value1, String value2) {
            addCriterion("MGTYPE not between", value1, value2, "mgtype");
            return (Criteria) this;
        }

        public Criteria andMgstateIsNull() {
            addCriterion("MGSTATE is null");
            return (Criteria) this;
        }

        public Criteria andMgstateIsNotNull() {
            addCriterion("MGSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andMgstateEqualTo(String value) {
            addCriterion("MGSTATE =", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateNotEqualTo(String value) {
            addCriterion("MGSTATE <>", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateGreaterThan(String value) {
            addCriterion("MGSTATE >", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateGreaterThanOrEqualTo(String value) {
            addCriterion("MGSTATE >=", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateLessThan(String value) {
            addCriterion("MGSTATE <", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateLessThanOrEqualTo(String value) {
            addCriterion("MGSTATE <=", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateLike(String value) {
            addCriterion("MGSTATE like", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateNotLike(String value) {
            addCriterion("MGSTATE not like", value, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateIn(List<String> values) {
            addCriterion("MGSTATE in", values, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateNotIn(List<String> values) {
            addCriterion("MGSTATE not in", values, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateBetween(String value1, String value2) {
            addCriterion("MGSTATE between", value1, value2, "mgstate");
            return (Criteria) this;
        }

        public Criteria andMgstateNotBetween(String value1, String value2) {
            addCriterion("MGSTATE not between", value1, value2, "mgstate");
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
    }

    /**
     *  * messagecenter
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * messagecenter 2020-07-27
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