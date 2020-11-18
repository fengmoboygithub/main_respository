/*
*
* HandleDetailTabExample.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handledetail.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HandleDetailTabExample extends BaseExample implements Serializable {
    /**
     * handle_detail_tab
     */
    protected String orderByClause;

    /**
     * handle_detail_tab
     */
    protected boolean distinct;

    /**
     * handle_detail_tab
     */
    protected List<Criteria> oredCriteria;

    /**
     * handle_detail_tab
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public HandleDetailTabExample() {
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
     * handle_detail_tab 2019-10-31
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

        public Criteria andFileCreaterCodeIsNull() {
            addCriterion("file_creater_code is null");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeIsNotNull() {
            addCriterion("file_creater_code is not null");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeEqualTo(String value) {
            addCriterion("file_creater_code =", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeNotEqualTo(String value) {
            addCriterion("file_creater_code <>", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeGreaterThan(String value) {
            addCriterion("file_creater_code >", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("file_creater_code >=", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeLessThan(String value) {
            addCriterion("file_creater_code <", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeLessThanOrEqualTo(String value) {
            addCriterion("file_creater_code <=", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeLike(String value) {
            addCriterion("file_creater_code like", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeNotLike(String value) {
            addCriterion("file_creater_code not like", value, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeIn(List<String> values) {
            addCriterion("file_creater_code in", values, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeNotIn(List<String> values) {
            addCriterion("file_creater_code not in", values, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeBetween(String value1, String value2) {
            addCriterion("file_creater_code between", value1, value2, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileCreaterCodeNotBetween(String value1, String value2) {
            addCriterion("file_creater_code not between", value1, value2, "fileCreaterCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeIsNull() {
            addCriterion("file_receiver_code is null");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeIsNotNull() {
            addCriterion("file_receiver_code is not null");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeEqualTo(String value) {
            addCriterion("file_receiver_code =", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeNotEqualTo(String value) {
            addCriterion("file_receiver_code <>", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeGreaterThan(String value) {
            addCriterion("file_receiver_code >", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeGreaterThanOrEqualTo(String value) {
            addCriterion("file_receiver_code >=", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeLessThan(String value) {
            addCriterion("file_receiver_code <", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeLessThanOrEqualTo(String value) {
            addCriterion("file_receiver_code <=", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeLike(String value) {
            addCriterion("file_receiver_code like", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeNotLike(String value) {
            addCriterion("file_receiver_code not like", value, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeIn(List<String> values) {
            addCriterion("file_receiver_code in", values, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeNotIn(List<String> values) {
            addCriterion("file_receiver_code not in", values, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeBetween(String value1, String value2) {
            addCriterion("file_receiver_code between", value1, value2, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andFileReceiverCodeNotBetween(String value1, String value2) {
            addCriterion("file_receiver_code not between", value1, value2, "fileReceiverCode");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIsNull() {
            addCriterion("interface_id is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIsNotNull() {
            addCriterion("interface_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdEqualTo(String value) {
            addCriterion("interface_id =", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotEqualTo(String value) {
            addCriterion("interface_id <>", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThan(String value) {
            addCriterion("interface_id >", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("interface_id >=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThan(String value) {
            addCriterion("interface_id <", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLessThanOrEqualTo(String value) {
            addCriterion("interface_id <=", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdLike(String value) {
            addCriterion("interface_id like", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotLike(String value) {
            addCriterion("interface_id not like", value, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdIn(List<String> values) {
            addCriterion("interface_id in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotIn(List<String> values) {
            addCriterion("interface_id not in", values, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdBetween(String value1, String value2) {
            addCriterion("interface_id between", value1, value2, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andInterfaceIdNotBetween(String value1, String value2) {
            addCriterion("interface_id not between", value1, value2, "interfaceId");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateIsNull() {
            addCriterion("submission_date is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateIsNotNull() {
            addCriterion("submission_date is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateEqualTo(String value) {
            addCriterion("submission_date =", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateNotEqualTo(String value) {
            addCriterion("submission_date <>", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateGreaterThan(String value) {
            addCriterion("submission_date >", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateGreaterThanOrEqualTo(String value) {
            addCriterion("submission_date >=", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateLessThan(String value) {
            addCriterion("submission_date <", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateLessThanOrEqualTo(String value) {
            addCriterion("submission_date <=", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateLike(String value) {
            addCriterion("submission_date like", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateNotLike(String value) {
            addCriterion("submission_date not like", value, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateIn(List<String> values) {
            addCriterion("submission_date in", values, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateNotIn(List<String> values) {
            addCriterion("submission_date not in", values, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateBetween(String value1, String value2) {
            addCriterion("submission_date between", value1, value2, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andSubmissionDateNotBetween(String value1, String value2) {
            addCriterion("submission_date not between", value1, value2, "submissionDate");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNull() {
            addCriterion("file_num is null");
            return (Criteria) this;
        }

        public Criteria andFileNumIsNotNull() {
            addCriterion("file_num is not null");
            return (Criteria) this;
        }

        public Criteria andFileNumEqualTo(String value) {
            addCriterion("file_num =", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotEqualTo(String value) {
            addCriterion("file_num <>", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThan(String value) {
            addCriterion("file_num >", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumGreaterThanOrEqualTo(String value) {
            addCriterion("file_num >=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThan(String value) {
            addCriterion("file_num <", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLessThanOrEqualTo(String value) {
            addCriterion("file_num <=", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumLike(String value) {
            addCriterion("file_num like", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotLike(String value) {
            addCriterion("file_num not like", value, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumIn(List<String> values) {
            addCriterion("file_num in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotIn(List<String> values) {
            addCriterion("file_num not in", values, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumBetween(String value1, String value2) {
            addCriterion("file_num between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andFileNumNotBetween(String value1, String value2) {
            addCriterion("file_num not between", value1, value2, "fileNum");
            return (Criteria) this;
        }

        public Criteria andOperationIdIsNull() {
            addCriterion("operation_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationIdIsNotNull() {
            addCriterion("operation_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationIdEqualTo(String value) {
            addCriterion("operation_id =", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotEqualTo(String value) {
            addCriterion("operation_id <>", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThan(String value) {
            addCriterion("operation_id >", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThanOrEqualTo(String value) {
            addCriterion("operation_id >=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThan(String value) {
            addCriterion("operation_id <", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThanOrEqualTo(String value) {
            addCriterion("operation_id <=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLike(String value) {
            addCriterion("operation_id like", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotLike(String value) {
            addCriterion("operation_id not like", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdIn(List<String> values) {
            addCriterion("operation_id in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotIn(List<String> values) {
            addCriterion("operation_id not in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdBetween(String value1, String value2) {
            addCriterion("operation_id between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotBetween(String value1, String value2) {
            addCriterion("operation_id not between", value1, value2, "operationId");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgIsNull() {
            addCriterion("submission_msg is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgIsNotNull() {
            addCriterion("submission_msg is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgEqualTo(String value) {
            addCriterion("submission_msg =", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgNotEqualTo(String value) {
            addCriterion("submission_msg <>", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgGreaterThan(String value) {
            addCriterion("submission_msg >", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgGreaterThanOrEqualTo(String value) {
            addCriterion("submission_msg >=", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgLessThan(String value) {
            addCriterion("submission_msg <", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgLessThanOrEqualTo(String value) {
            addCriterion("submission_msg <=", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgLike(String value) {
            addCriterion("submission_msg like", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgNotLike(String value) {
            addCriterion("submission_msg not like", value, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgIn(List<String> values) {
            addCriterion("submission_msg in", values, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgNotIn(List<String> values) {
            addCriterion("submission_msg not in", values, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgBetween(String value1, String value2) {
            addCriterion("submission_msg between", value1, value2, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionMsgNotBetween(String value1, String value2) {
            addCriterion("submission_msg not between", value1, value2, "submissionMsg");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorIsNull() {
            addCriterion("submission_error is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorIsNotNull() {
            addCriterion("submission_error is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorEqualTo(String value) {
            addCriterion("submission_error =", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorNotEqualTo(String value) {
            addCriterion("submission_error <>", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorGreaterThan(String value) {
            addCriterion("submission_error >", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorGreaterThanOrEqualTo(String value) {
            addCriterion("submission_error >=", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorLessThan(String value) {
            addCriterion("submission_error <", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorLessThanOrEqualTo(String value) {
            addCriterion("submission_error <=", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorLike(String value) {
            addCriterion("submission_error like", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorNotLike(String value) {
            addCriterion("submission_error not like", value, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorIn(List<String> values) {
            addCriterion("submission_error in", values, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorNotIn(List<String> values) {
            addCriterion("submission_error not in", values, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorBetween(String value1, String value2) {
            addCriterion("submission_error between", value1, value2, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionErrorNotBetween(String value1, String value2) {
            addCriterion("submission_error not between", value1, value2, "submissionError");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidIsNull() {
            addCriterion("submission_bizid is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidIsNotNull() {
            addCriterion("submission_bizid is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidEqualTo(String value) {
            addCriterion("submission_bizid =", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidNotEqualTo(String value) {
            addCriterion("submission_bizid <>", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidGreaterThan(String value) {
            addCriterion("submission_bizid >", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidGreaterThanOrEqualTo(String value) {
            addCriterion("submission_bizid >=", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidLessThan(String value) {
            addCriterion("submission_bizid <", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidLessThanOrEqualTo(String value) {
            addCriterion("submission_bizid <=", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidLike(String value) {
            addCriterion("submission_bizid like", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidNotLike(String value) {
            addCriterion("submission_bizid not like", value, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidIn(List<String> values) {
            addCriterion("submission_bizid in", values, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidNotIn(List<String> values) {
            addCriterion("submission_bizid not in", values, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidBetween(String value1, String value2) {
            addCriterion("submission_bizid between", value1, value2, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionBizidNotBetween(String value1, String value2) {
            addCriterion("submission_bizid not between", value1, value2, "submissionBizid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidIsNull() {
            addCriterion("submission_protcolid is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidIsNotNull() {
            addCriterion("submission_protcolid is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidEqualTo(String value) {
            addCriterion("submission_protcolid =", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidNotEqualTo(String value) {
            addCriterion("submission_protcolid <>", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidGreaterThan(String value) {
            addCriterion("submission_protcolid >", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidGreaterThanOrEqualTo(String value) {
            addCriterion("submission_protcolid >=", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidLessThan(String value) {
            addCriterion("submission_protcolid <", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidLessThanOrEqualTo(String value) {
            addCriterion("submission_protcolid <=", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidLike(String value) {
            addCriterion("submission_protcolid like", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidNotLike(String value) {
            addCriterion("submission_protcolid not like", value, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidIn(List<String> values) {
            addCriterion("submission_protcolid in", values, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidNotIn(List<String> values) {
            addCriterion("submission_protcolid not in", values, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidBetween(String value1, String value2) {
            addCriterion("submission_protcolid between", value1, value2, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionProtcolidNotBetween(String value1, String value2) {
            addCriterion("submission_protcolid not between", value1, value2, "submissionProtcolid");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataIsNull() {
            addCriterion("submission_data is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataIsNotNull() {
            addCriterion("submission_data is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataEqualTo(String value) {
            addCriterion("submission_data =", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataNotEqualTo(String value) {
            addCriterion("submission_data <>", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataGreaterThan(String value) {
            addCriterion("submission_data >", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataGreaterThanOrEqualTo(String value) {
            addCriterion("submission_data >=", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataLessThan(String value) {
            addCriterion("submission_data <", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataLessThanOrEqualTo(String value) {
            addCriterion("submission_data <=", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataLike(String value) {
            addCriterion("submission_data like", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataNotLike(String value) {
            addCriterion("submission_data not like", value, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataIn(List<String> values) {
            addCriterion("submission_data in", values, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataNotIn(List<String> values) {
            addCriterion("submission_data not in", values, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataBetween(String value1, String value2) {
            addCriterion("submission_data between", value1, value2, "submissionData");
            return (Criteria) this;
        }

        public Criteria andSubmissionDataNotBetween(String value1, String value2) {
            addCriterion("submission_data not between", value1, value2, "submissionData");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNull() {
            addCriterion("response_msg is null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNotNull() {
            addCriterion("response_msg is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgEqualTo(String value) {
            addCriterion("response_msg =", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotEqualTo(String value) {
            addCriterion("response_msg <>", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThan(String value) {
            addCriterion("response_msg >", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThanOrEqualTo(String value) {
            addCriterion("response_msg >=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThan(String value) {
            addCriterion("response_msg <", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThanOrEqualTo(String value) {
            addCriterion("response_msg <=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLike(String value) {
            addCriterion("response_msg like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotLike(String value) {
            addCriterion("response_msg not like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIn(List<String> values) {
            addCriterion("response_msg in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotIn(List<String> values) {
            addCriterion("response_msg not in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgBetween(String value1, String value2) {
            addCriterion("response_msg between", value1, value2, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotBetween(String value1, String value2) {
            addCriterion("response_msg not between", value1, value2, "responseMsg");
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
     *  * handle_detail_tab
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * handle_detail_tab 2019-10-31
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