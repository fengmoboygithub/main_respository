/*
*
* HandlePlainTmpExample.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handleplain.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HandlePlainTmpExample extends BaseExample implements Serializable {
    /**
     * handle_plain_tmp
     */
    protected String orderByClause;

    /**
     * handle_plain_tmp
     */
    protected boolean distinct;

    /**
     * handle_plain_tmp
     */
    protected List<Criteria> oredCriteria;

    /**
     * handle_plain_tmp
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public HandlePlainTmpExample() {
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
     * handle_plain_tmp 2019-10-31
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdIsNull() {
            addCriterion("submission_record_id is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdIsNotNull() {
            addCriterion("submission_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdEqualTo(String value) {
            addCriterion("submission_record_id =", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdNotEqualTo(String value) {
            addCriterion("submission_record_id <>", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdGreaterThan(String value) {
            addCriterion("submission_record_id >", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("submission_record_id >=", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdLessThan(String value) {
            addCriterion("submission_record_id <", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdLessThanOrEqualTo(String value) {
            addCriterion("submission_record_id <=", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdLike(String value) {
            addCriterion("submission_record_id like", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdNotLike(String value) {
            addCriterion("submission_record_id not like", value, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdIn(List<String> values) {
            addCriterion("submission_record_id in", values, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdNotIn(List<String> values) {
            addCriterion("submission_record_id not in", values, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdBetween(String value1, String value2) {
            addCriterion("submission_record_id between", value1, value2, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andSubmissionRecordIdNotBetween(String value1, String value2) {
            addCriterion("submission_record_id not between", value1, value2, "submissionRecordId");
            return (Criteria) this;
        }

        public Criteria andFileItemSortIsNull() {
            addCriterion("file_item_sort is null");
            return (Criteria) this;
        }

        public Criteria andFileItemSortIsNotNull() {
            addCriterion("file_item_sort is not null");
            return (Criteria) this;
        }

        public Criteria andFileItemSortEqualTo(Integer value) {
            addCriterion("file_item_sort =", value, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortNotEqualTo(Integer value) {
            addCriterion("file_item_sort <>", value, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortGreaterThan(Integer value) {
            addCriterion("file_item_sort >", value, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_item_sort >=", value, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortLessThan(Integer value) {
            addCriterion("file_item_sort <", value, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortLessThanOrEqualTo(Integer value) {
            addCriterion("file_item_sort <=", value, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortIn(List<Integer> values) {
            addCriterion("file_item_sort in", values, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortNotIn(List<Integer> values) {
            addCriterion("file_item_sort not in", values, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortBetween(Integer value1, Integer value2) {
            addCriterion("file_item_sort between", value1, value2, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andFileItemSortNotBetween(Integer value1, Integer value2) {
            addCriterion("file_item_sort not between", value1, value2, "fileItemSort");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    /**
     *  * handle_plain_tmp
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * handle_plain_tmp 2019-10-31
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