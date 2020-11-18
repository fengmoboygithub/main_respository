/*
*
* DictionaryTabExample.java
*                    中证技术公司
* @date 2018-11-06
*/
package com.interapi.app.component.model;

import com.interapi.app.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictionaryTabExample extends BaseExample implements Serializable {
    /**
     * dictionary_tab
     */
    protected String orderByClause;

    /**
     * dictionary_tab
     */
    protected boolean distinct;

    /**
     * dictionary_tab
     */
    protected List<Criteria> oredCriteria;

    /**
     * dictionary_tab
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public DictionaryTabExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-11-06
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
     * @mbg.generated 2018-11-06
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2018-11-06
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * dictionary_tab 2018-11-06
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

        public Criteria andDicKeyIsNull() {
            addCriterion("DIC_KEY is null");
            return (Criteria) this;
        }

        public Criteria andDicKeyIsNotNull() {
            addCriterion("DIC_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andDicKeyEqualTo(String value) {
            addCriterion("DIC_KEY =", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotEqualTo(String value) {
            addCriterion("DIC_KEY <>", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThan(String value) {
            addCriterion("DIC_KEY >", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_KEY >=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThan(String value) {
            addCriterion("DIC_KEY <", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThanOrEqualTo(String value) {
            addCriterion("DIC_KEY <=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLike(String value) {
            addCriterion("DIC_KEY like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotLike(String value) {
            addCriterion("DIC_KEY not like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyIn(List<String> values) {
            addCriterion("DIC_KEY in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotIn(List<String> values) {
            addCriterion("DIC_KEY not in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyBetween(String value1, String value2) {
            addCriterion("DIC_KEY between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotBetween(String value1, String value2) {
            addCriterion("DIC_KEY not between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNull() {
            addCriterion("DIC_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNotNull() {
            addCriterion("DIC_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDicValueEqualTo(String value) {
            addCriterion("DIC_VALUE =", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotEqualTo(String value) {
            addCriterion("DIC_VALUE <>", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThan(String value) {
            addCriterion("DIC_VALUE >", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_VALUE >=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThan(String value) {
            addCriterion("DIC_VALUE <", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThanOrEqualTo(String value) {
            addCriterion("DIC_VALUE <=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLike(String value) {
            addCriterion("DIC_VALUE like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotLike(String value) {
            addCriterion("DIC_VALUE not like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueIn(List<String> values) {
            addCriterion("DIC_VALUE in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotIn(List<String> values) {
            addCriterion("DIC_VALUE not in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueBetween(String value1, String value2) {
            addCriterion("DIC_VALUE between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotBetween(String value1, String value2) {
            addCriterion("DIC_VALUE not between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicDescIsNull() {
            addCriterion("DIC_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDicDescIsNotNull() {
            addCriterion("DIC_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDicDescEqualTo(String value) {
            addCriterion("DIC_DESC =", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescNotEqualTo(String value) {
            addCriterion("DIC_DESC <>", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescGreaterThan(String value) {
            addCriterion("DIC_DESC >", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_DESC >=", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescLessThan(String value) {
            addCriterion("DIC_DESC <", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescLessThanOrEqualTo(String value) {
            addCriterion("DIC_DESC <=", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescLike(String value) {
            addCriterion("DIC_DESC like", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescNotLike(String value) {
            addCriterion("DIC_DESC not like", value, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescIn(List<String> values) {
            addCriterion("DIC_DESC in", values, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescNotIn(List<String> values) {
            addCriterion("DIC_DESC not in", values, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescBetween(String value1, String value2) {
            addCriterion("DIC_DESC between", value1, value2, "dicDesc");
            return (Criteria) this;
        }

        public Criteria andDicDescNotBetween(String value1, String value2) {
            addCriterion("DIC_DESC not between", value1, value2, "dicDesc");
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
     *  * dictionary_tab
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * dictionary_tab 2018-11-06
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