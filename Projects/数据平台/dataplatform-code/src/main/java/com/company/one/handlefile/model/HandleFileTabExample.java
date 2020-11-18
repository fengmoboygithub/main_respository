/*
*
* HandleFileTabExample.java
*                    中证技术公司
* @date 2019-10-31
*/
package com.company.one.handlefile.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HandleFileTabExample extends BaseExample implements Serializable {
    /**
     * handle_file_tab
     */
    protected String orderByClause;

    /**
     * handle_file_tab
     */
    protected boolean distinct;

    /**
     * handle_file_tab
     */
    protected List<Criteria> oredCriteria;

    /**
     * handle_file_tab
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-10-31
     */
    public HandleFileTabExample() {
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
     * handle_file_tab 2019-10-31
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

        public Criteria andZipFileNameIsNull() {
            addCriterion("zip_file_name is null");
            return (Criteria) this;
        }

        public Criteria andZipFileNameIsNotNull() {
            addCriterion("zip_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andZipFileNameEqualTo(String value) {
            addCriterion("zip_file_name =", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameNotEqualTo(String value) {
            addCriterion("zip_file_name <>", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameGreaterThan(String value) {
            addCriterion("zip_file_name >", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("zip_file_name >=", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameLessThan(String value) {
            addCriterion("zip_file_name <", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameLessThanOrEqualTo(String value) {
            addCriterion("zip_file_name <=", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameLike(String value) {
            addCriterion("zip_file_name like", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameNotLike(String value) {
            addCriterion("zip_file_name not like", value, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameIn(List<String> values) {
            addCriterion("zip_file_name in", values, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameNotIn(List<String> values) {
            addCriterion("zip_file_name not in", values, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameBetween(String value1, String value2) {
            addCriterion("zip_file_name between", value1, value2, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andZipFileNameNotBetween(String value1, String value2) {
            addCriterion("zip_file_name not between", value1, value2, "zipFileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityIsNull() {
            addCriterion("hash_file_entity is null");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityIsNotNull() {
            addCriterion("hash_file_entity is not null");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityEqualTo(String value) {
            addCriterion("hash_file_entity =", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityNotEqualTo(String value) {
            addCriterion("hash_file_entity <>", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityGreaterThan(String value) {
            addCriterion("hash_file_entity >", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityGreaterThanOrEqualTo(String value) {
            addCriterion("hash_file_entity >=", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityLessThan(String value) {
            addCriterion("hash_file_entity <", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityLessThanOrEqualTo(String value) {
            addCriterion("hash_file_entity <=", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityLike(String value) {
            addCriterion("hash_file_entity like", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityNotLike(String value) {
            addCriterion("hash_file_entity not like", value, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityIn(List<String> values) {
            addCriterion("hash_file_entity in", values, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityNotIn(List<String> values) {
            addCriterion("hash_file_entity not in", values, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityBetween(String value1, String value2) {
            addCriterion("hash_file_entity between", value1, value2, "hashFileEntity");
            return (Criteria) this;
        }

        public Criteria andHashFileEntityNotBetween(String value1, String value2) {
            addCriterion("hash_file_entity not between", value1, value2, "hashFileEntity");
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
     *  * handle_file_tab
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * handle_file_tab 2019-10-31
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