/*
*
* SmartQueryModelExample.java
*                    中证技术公司
* @date 2019-02-21
*/
package com.company.query.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmartQueryModelExample extends BaseExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SmartQueryModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public void addCriterion(String condition) {
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

        public Criteria andProperty1IsNull() {
            addCriterion("PROPERTY1 is null");
            return (Criteria) this;
        }

        public Criteria andProperty1IsNotNull() {
            addCriterion("PROPERTY1 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty1EqualTo(String value) {
            addCriterion("PROPERTY1 =", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotEqualTo(String value) {
            addCriterion("PROPERTY1 <>", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1GreaterThan(String value) {
            addCriterion("PROPERTY1 >", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY1 >=", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1LessThan(String value) {
            addCriterion("PROPERTY1 <", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY1 <=", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1Like(String value) {
            addCriterion("PROPERTY1 like", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotLike(String value) {
            addCriterion("PROPERTY1 not like", value, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1In(List<String> values) {
            addCriterion("PROPERTY1 in", values, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotIn(List<String> values) {
            addCriterion("PROPERTY1 not in", values, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1Between(String value1, String value2) {
            addCriterion("PROPERTY1 between", value1, value2, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty1NotBetween(String value1, String value2) {
            addCriterion("PROPERTY1 not between", value1, value2, "property1");
            return (Criteria) this;
        }

        public Criteria andProperty2IsNull() {
            addCriterion("PROPERTY2 is null");
            return (Criteria) this;
        }

        public Criteria andProperty2IsNotNull() {
            addCriterion("PROPERTY2 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty2EqualTo(String value) {
            addCriterion("PROPERTY2 =", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotEqualTo(String value) {
            addCriterion("PROPERTY2 <>", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2GreaterThan(String value) {
            addCriterion("PROPERTY2 >", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY2 >=", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2LessThan(String value) {
            addCriterion("PROPERTY2 <", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY2 <=", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2Like(String value) {
            addCriterion("PROPERTY2 like", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotLike(String value) {
            addCriterion("PROPERTY2 not like", value, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2In(List<String> values) {
            addCriterion("PROPERTY2 in", values, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotIn(List<String> values) {
            addCriterion("PROPERTY2 not in", values, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2Between(String value1, String value2) {
            addCriterion("PROPERTY2 between", value1, value2, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty2NotBetween(String value1, String value2) {
            addCriterion("PROPERTY2 not between", value1, value2, "property2");
            return (Criteria) this;
        }

        public Criteria andProperty3IsNull() {
            addCriterion("PROPERTY3 is null");
            return (Criteria) this;
        }

        public Criteria andProperty3IsNotNull() {
            addCriterion("PROPERTY3 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty3EqualTo(String value) {
            addCriterion("PROPERTY3 =", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotEqualTo(String value) {
            addCriterion("PROPERTY3 <>", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3GreaterThan(String value) {
            addCriterion("PROPERTY3 >", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY3 >=", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3LessThan(String value) {
            addCriterion("PROPERTY3 <", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY3 <=", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3Like(String value) {
            addCriterion("PROPERTY3 like", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotLike(String value) {
            addCriterion("PROPERTY3 not like", value, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3In(List<String> values) {
            addCriterion("PROPERTY3 in", values, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotIn(List<String> values) {
            addCriterion("PROPERTY3 not in", values, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3Between(String value1, String value2) {
            addCriterion("PROPERTY3 between", value1, value2, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty3NotBetween(String value1, String value2) {
            addCriterion("PROPERTY3 not between", value1, value2, "property3");
            return (Criteria) this;
        }

        public Criteria andProperty4IsNull() {
            addCriterion("PROPERTY4 is null");
            return (Criteria) this;
        }

        public Criteria andProperty4IsNotNull() {
            addCriterion("PROPERTY4 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty4EqualTo(String value) {
            addCriterion("PROPERTY4 =", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotEqualTo(String value) {
            addCriterion("PROPERTY4 <>", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4GreaterThan(String value) {
            addCriterion("PROPERTY4 >", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY4 >=", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4LessThan(String value) {
            addCriterion("PROPERTY4 <", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY4 <=", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4Like(String value) {
            addCriterion("PROPERTY4 like", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotLike(String value) {
            addCriterion("PROPERTY4 not like", value, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4In(List<String> values) {
            addCriterion("PROPERTY4 in", values, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotIn(List<String> values) {
            addCriterion("PROPERTY4 not in", values, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4Between(String value1, String value2) {
            addCriterion("PROPERTY4 between", value1, value2, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty4NotBetween(String value1, String value2) {
            addCriterion("PROPERTY4 not between", value1, value2, "property4");
            return (Criteria) this;
        }

        public Criteria andProperty5IsNull() {
            addCriterion("PROPERTY5 is null");
            return (Criteria) this;
        }

        public Criteria andProperty5IsNotNull() {
            addCriterion("PROPERTY5 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty5EqualTo(String value) {
            addCriterion("PROPERTY5 =", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotEqualTo(String value) {
            addCriterion("PROPERTY5 <>", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5GreaterThan(String value) {
            addCriterion("PROPERTY5 >", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY5 >=", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5LessThan(String value) {
            addCriterion("PROPERTY5 <", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY5 <=", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5Like(String value) {
            addCriterion("PROPERTY5 like", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotLike(String value) {
            addCriterion("PROPERTY5 not like", value, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5In(List<String> values) {
            addCriterion("PROPERTY5 in", values, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotIn(List<String> values) {
            addCriterion("PROPERTY5 not in", values, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5Between(String value1, String value2) {
            addCriterion("PROPERTY5 between", value1, value2, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty5NotBetween(String value1, String value2) {
            addCriterion("PROPERTY5 not between", value1, value2, "property5");
            return (Criteria) this;
        }

        public Criteria andProperty6IsNull() {
            addCriterion("PROPERTY6 is null");
            return (Criteria) this;
        }

        public Criteria andProperty6IsNotNull() {
            addCriterion("PROPERTY6 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty6EqualTo(String value) {
            addCriterion("PROPERTY6 =", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotEqualTo(String value) {
            addCriterion("PROPERTY6 <>", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6GreaterThan(String value) {
            addCriterion("PROPERTY6 >", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY6 >=", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6LessThan(String value) {
            addCriterion("PROPERTY6 <", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY6 <=", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6Like(String value) {
            addCriterion("PROPERTY6 like", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotLike(String value) {
            addCriterion("PROPERTY6 not like", value, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6In(List<String> values) {
            addCriterion("PROPERTY6 in", values, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotIn(List<String> values) {
            addCriterion("PROPERTY6 not in", values, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6Between(String value1, String value2) {
            addCriterion("PROPERTY6 between", value1, value2, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty6NotBetween(String value1, String value2) {
            addCriterion("PROPERTY6 not between", value1, value2, "property6");
            return (Criteria) this;
        }

        public Criteria andProperty7IsNull() {
            addCriterion("PROPERTY7 is null");
            return (Criteria) this;
        }

        public Criteria andProperty7IsNotNull() {
            addCriterion("PROPERTY7 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty7EqualTo(String value) {
            addCriterion("PROPERTY7 =", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotEqualTo(String value) {
            addCriterion("PROPERTY7 <>", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7GreaterThan(String value) {
            addCriterion("PROPERTY7 >", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY7 >=", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7LessThan(String value) {
            addCriterion("PROPERTY7 <", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY7 <=", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7Like(String value) {
            addCriterion("PROPERTY7 like", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotLike(String value) {
            addCriterion("PROPERTY7 not like", value, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7In(List<String> values) {
            addCriterion("PROPERTY7 in", values, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotIn(List<String> values) {
            addCriterion("PROPERTY7 not in", values, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7Between(String value1, String value2) {
            addCriterion("PROPERTY7 between", value1, value2, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty7NotBetween(String value1, String value2) {
            addCriterion("PROPERTY7 not between", value1, value2, "property7");
            return (Criteria) this;
        }

        public Criteria andProperty8IsNull() {
            addCriterion("PROPERTY8 is null");
            return (Criteria) this;
        }

        public Criteria andProperty8IsNotNull() {
            addCriterion("PROPERTY8 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty8EqualTo(String value) {
            addCriterion("PROPERTY8 =", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotEqualTo(String value) {
            addCriterion("PROPERTY8 <>", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8GreaterThan(String value) {
            addCriterion("PROPERTY8 >", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY8 >=", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8LessThan(String value) {
            addCriterion("PROPERTY8 <", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY8 <=", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8Like(String value) {
            addCriterion("PROPERTY8 like", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotLike(String value) {
            addCriterion("PROPERTY8 not like", value, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8In(List<String> values) {
            addCriterion("PROPERTY8 in", values, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotIn(List<String> values) {
            addCriterion("PROPERTY8 not in", values, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8Between(String value1, String value2) {
            addCriterion("PROPERTY8 between", value1, value2, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty8NotBetween(String value1, String value2) {
            addCriterion("PROPERTY8 not between", value1, value2, "property8");
            return (Criteria) this;
        }

        public Criteria andProperty9IsNull() {
            addCriterion("PROPERTY9 is null");
            return (Criteria) this;
        }

        public Criteria andProperty9IsNotNull() {
            addCriterion("PROPERTY9 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty9EqualTo(String value) {
            addCriterion("PROPERTY9 =", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotEqualTo(String value) {
            addCriterion("PROPERTY9 <>", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9GreaterThan(String value) {
            addCriterion("PROPERTY9 >", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY9 >=", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9LessThan(String value) {
            addCriterion("PROPERTY9 <", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY9 <=", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9Like(String value) {
            addCriterion("PROPERTY9 like", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotLike(String value) {
            addCriterion("PROPERTY9 not like", value, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9In(List<String> values) {
            addCriterion("PROPERTY9 in", values, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotIn(List<String> values) {
            addCriterion("PROPERTY9 not in", values, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9Between(String value1, String value2) {
            addCriterion("PROPERTY9 between", value1, value2, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty9NotBetween(String value1, String value2) {
            addCriterion("PROPERTY9 not between", value1, value2, "property9");
            return (Criteria) this;
        }

        public Criteria andProperty10IsNull() {
            addCriterion("PROPERTY10 is null");
            return (Criteria) this;
        }

        public Criteria andProperty10IsNotNull() {
            addCriterion("PROPERTY10 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty10EqualTo(String value) {
            addCriterion("PROPERTY10 =", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10NotEqualTo(String value) {
            addCriterion("PROPERTY10 <>", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10GreaterThan(String value) {
            addCriterion("PROPERTY10 >", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY10 >=", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10LessThan(String value) {
            addCriterion("PROPERTY10 <", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY10 <=", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10Like(String value) {
            addCriterion("PROPERTY10 like", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10NotLike(String value) {
            addCriterion("PROPERTY10 not like", value, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10In(List<String> values) {
            addCriterion("PROPERTY10 in", values, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10NotIn(List<String> values) {
            addCriterion("PROPERTY10 not in", values, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10Between(String value1, String value2) {
            addCriterion("PROPERTY10 between", value1, value2, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty10NotBetween(String value1, String value2) {
            addCriterion("PROPERTY10 not between", value1, value2, "property10");
            return (Criteria) this;
        }

        public Criteria andProperty11IsNull() {
            addCriterion("PROPERTY11 is null");
            return (Criteria) this;
        }

        public Criteria andProperty11IsNotNull() {
            addCriterion("PROPERTY11 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty11EqualTo(String value) {
            addCriterion("PROPERTY11 =", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11NotEqualTo(String value) {
            addCriterion("PROPERTY11 <>", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11GreaterThan(String value) {
            addCriterion("PROPERTY11 >", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY11 >=", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11LessThan(String value) {
            addCriterion("PROPERTY11 <", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY11 <=", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11Like(String value) {
            addCriterion("PROPERTY11 like", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11NotLike(String value) {
            addCriterion("PROPERTY11 not like", value, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11In(List<String> values) {
            addCriterion("PROPERTY11 in", values, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11NotIn(List<String> values) {
            addCriterion("PROPERTY11 not in", values, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11Between(String value1, String value2) {
            addCriterion("PROPERTY11 between", value1, value2, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty11NotBetween(String value1, String value2) {
            addCriterion("PROPERTY11 not between", value1, value2, "property11");
            return (Criteria) this;
        }

        public Criteria andProperty12IsNull() {
            addCriterion("PROPERTY12 is null");
            return (Criteria) this;
        }

        public Criteria andProperty12IsNotNull() {
            addCriterion("PROPERTY12 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty12EqualTo(String value) {
            addCriterion("PROPERTY12 =", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12NotEqualTo(String value) {
            addCriterion("PROPERTY12 <>", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12GreaterThan(String value) {
            addCriterion("PROPERTY12 >", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY12 >=", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12LessThan(String value) {
            addCriterion("PROPERTY12 <", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY12 <=", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12Like(String value) {
            addCriterion("PROPERTY12 like", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12NotLike(String value) {
            addCriterion("PROPERTY12 not like", value, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12In(List<String> values) {
            addCriterion("PROPERTY12 in", values, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12NotIn(List<String> values) {
            addCriterion("PROPERTY12 not in", values, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12Between(String value1, String value2) {
            addCriterion("PROPERTY12 between", value1, value2, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty12NotBetween(String value1, String value2) {
            addCriterion("PROPERTY12 not between", value1, value2, "property12");
            return (Criteria) this;
        }

        public Criteria andProperty13IsNull() {
            addCriterion("PROPERTY13 is null");
            return (Criteria) this;
        }

        public Criteria andProperty13IsNotNull() {
            addCriterion("PROPERTY13 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty13EqualTo(String value) {
            addCriterion("PROPERTY13 =", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13NotEqualTo(String value) {
            addCriterion("PROPERTY13 <>", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13GreaterThan(String value) {
            addCriterion("PROPERTY13 >", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY13 >=", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13LessThan(String value) {
            addCriterion("PROPERTY13 <", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY13 <=", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13Like(String value) {
            addCriterion("PROPERTY13 like", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13NotLike(String value) {
            addCriterion("PROPERTY13 not like", value, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13In(List<String> values) {
            addCriterion("PROPERTY13 in", values, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13NotIn(List<String> values) {
            addCriterion("PROPERTY13 not in", values, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13Between(String value1, String value2) {
            addCriterion("PROPERTY13 between", value1, value2, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty13NotBetween(String value1, String value2) {
            addCriterion("PROPERTY13 not between", value1, value2, "property13");
            return (Criteria) this;
        }

        public Criteria andProperty14IsNull() {
            addCriterion("PROPERTY14 is null");
            return (Criteria) this;
        }

        public Criteria andProperty14IsNotNull() {
            addCriterion("PROPERTY14 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty14EqualTo(String value) {
            addCriterion("PROPERTY14 =", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14NotEqualTo(String value) {
            addCriterion("PROPERTY14 <>", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14GreaterThan(String value) {
            addCriterion("PROPERTY14 >", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY14 >=", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14LessThan(String value) {
            addCriterion("PROPERTY14 <", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY14 <=", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14Like(String value) {
            addCriterion("PROPERTY14 like", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14NotLike(String value) {
            addCriterion("PROPERTY14 not like", value, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14In(List<String> values) {
            addCriterion("PROPERTY14 in", values, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14NotIn(List<String> values) {
            addCriterion("PROPERTY14 not in", values, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14Between(String value1, String value2) {
            addCriterion("PROPERTY14 between", value1, value2, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty14NotBetween(String value1, String value2) {
            addCriterion("PROPERTY14 not between", value1, value2, "property14");
            return (Criteria) this;
        }

        public Criteria andProperty15IsNull() {
            addCriterion("PROPERTY15 is null");
            return (Criteria) this;
        }

        public Criteria andProperty15IsNotNull() {
            addCriterion("PROPERTY15 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty15EqualTo(String value) {
            addCriterion("PROPERTY15 =", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15NotEqualTo(String value) {
            addCriterion("PROPERTY15 <>", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15GreaterThan(String value) {
            addCriterion("PROPERTY15 >", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY15 >=", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15LessThan(String value) {
            addCriterion("PROPERTY15 <", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY15 <=", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15Like(String value) {
            addCriterion("PROPERTY15 like", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15NotLike(String value) {
            addCriterion("PROPERTY15 not like", value, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15In(List<String> values) {
            addCriterion("PROPERTY15 in", values, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15NotIn(List<String> values) {
            addCriterion("PROPERTY15 not in", values, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15Between(String value1, String value2) {
            addCriterion("PROPERTY15 between", value1, value2, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty15NotBetween(String value1, String value2) {
            addCriterion("PROPERTY15 not between", value1, value2, "property15");
            return (Criteria) this;
        }

        public Criteria andProperty16IsNull() {
            addCriterion("PROPERTY16 is null");
            return (Criteria) this;
        }

        public Criteria andProperty16IsNotNull() {
            addCriterion("PROPERTY16 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty16EqualTo(String value) {
            addCriterion("PROPERTY16 =", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16NotEqualTo(String value) {
            addCriterion("PROPERTY16 <>", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16GreaterThan(String value) {
            addCriterion("PROPERTY16 >", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY16 >=", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16LessThan(String value) {
            addCriterion("PROPERTY16 <", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY16 <=", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16Like(String value) {
            addCriterion("PROPERTY16 like", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16NotLike(String value) {
            addCriterion("PROPERTY16 not like", value, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16In(List<String> values) {
            addCriterion("PROPERTY16 in", values, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16NotIn(List<String> values) {
            addCriterion("PROPERTY16 not in", values, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16Between(String value1, String value2) {
            addCriterion("PROPERTY16 between", value1, value2, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty16NotBetween(String value1, String value2) {
            addCriterion("PROPERTY16 not between", value1, value2, "property16");
            return (Criteria) this;
        }

        public Criteria andProperty17IsNull() {
            addCriterion("PROPERTY17 is null");
            return (Criteria) this;
        }

        public Criteria andProperty17IsNotNull() {
            addCriterion("PROPERTY17 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty17EqualTo(String value) {
            addCriterion("PROPERTY17 =", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17NotEqualTo(String value) {
            addCriterion("PROPERTY17 <>", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17GreaterThan(String value) {
            addCriterion("PROPERTY17 >", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY17 >=", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17LessThan(String value) {
            addCriterion("PROPERTY17 <", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY17 <=", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17Like(String value) {
            addCriterion("PROPERTY17 like", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17NotLike(String value) {
            addCriterion("PROPERTY17 not like", value, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17In(List<String> values) {
            addCriterion("PROPERTY17 in", values, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17NotIn(List<String> values) {
            addCriterion("PROPERTY17 not in", values, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17Between(String value1, String value2) {
            addCriterion("PROPERTY17 between", value1, value2, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty17NotBetween(String value1, String value2) {
            addCriterion("PROPERTY17 not between", value1, value2, "property17");
            return (Criteria) this;
        }

        public Criteria andProperty18IsNull() {
            addCriterion("PROPERTY18 is null");
            return (Criteria) this;
        }

        public Criteria andProperty18IsNotNull() {
            addCriterion("PROPERTY18 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty18EqualTo(String value) {
            addCriterion("PROPERTY18 =", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18NotEqualTo(String value) {
            addCriterion("PROPERTY18 <>", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18GreaterThan(String value) {
            addCriterion("PROPERTY18 >", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY18 >=", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18LessThan(String value) {
            addCriterion("PROPERTY18 <", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY18 <=", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18Like(String value) {
            addCriterion("PROPERTY18 like", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18NotLike(String value) {
            addCriterion("PROPERTY18 not like", value, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18In(List<String> values) {
            addCriterion("PROPERTY18 in", values, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18NotIn(List<String> values) {
            addCriterion("PROPERTY18 not in", values, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18Between(String value1, String value2) {
            addCriterion("PROPERTY18 between", value1, value2, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty18NotBetween(String value1, String value2) {
            addCriterion("PROPERTY18 not between", value1, value2, "property18");
            return (Criteria) this;
        }

        public Criteria andProperty19IsNull() {
            addCriterion("PROPERTY19 is null");
            return (Criteria) this;
        }

        public Criteria andProperty19IsNotNull() {
            addCriterion("PROPERTY19 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty19EqualTo(String value) {
            addCriterion("PROPERTY19 =", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19NotEqualTo(String value) {
            addCriterion("PROPERTY19 <>", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19GreaterThan(String value) {
            addCriterion("PROPERTY19 >", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY19 >=", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19LessThan(String value) {
            addCriterion("PROPERTY19 <", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY19 <=", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19Like(String value) {
            addCriterion("PROPERTY19 like", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19NotLike(String value) {
            addCriterion("PROPERTY19 not like", value, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19In(List<String> values) {
            addCriterion("PROPERTY19 in", values, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19NotIn(List<String> values) {
            addCriterion("PROPERTY19 not in", values, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19Between(String value1, String value2) {
            addCriterion("PROPERTY19 between", value1, value2, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty19NotBetween(String value1, String value2) {
            addCriterion("PROPERTY19 not between", value1, value2, "property19");
            return (Criteria) this;
        }

        public Criteria andProperty20IsNull() {
            addCriterion("PROPERTY20 is null");
            return (Criteria) this;
        }

        public Criteria andProperty20IsNotNull() {
            addCriterion("PROPERTY20 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty20EqualTo(String value) {
            addCriterion("PROPERTY20 =", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20NotEqualTo(String value) {
            addCriterion("PROPERTY20 <>", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20GreaterThan(String value) {
            addCriterion("PROPERTY20 >", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY20 >=", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20LessThan(String value) {
            addCriterion("PROPERTY20 <", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY20 <=", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20Like(String value) {
            addCriterion("PROPERTY20 like", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20NotLike(String value) {
            addCriterion("PROPERTY20 not like", value, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20In(List<String> values) {
            addCriterion("PROPERTY20 in", values, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20NotIn(List<String> values) {
            addCriterion("PROPERTY20 not in", values, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20Between(String value1, String value2) {
            addCriterion("PROPERTY20 between", value1, value2, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty20NotBetween(String value1, String value2) {
            addCriterion("PROPERTY20 not between", value1, value2, "property20");
            return (Criteria) this;
        }

        public Criteria andProperty21IsNull() {
            addCriterion("PROPERTY21 is null");
            return (Criteria) this;
        }

        public Criteria andProperty21IsNotNull() {
            addCriterion("PROPERTY21 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty21EqualTo(String value) {
            addCriterion("PROPERTY21 =", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21NotEqualTo(String value) {
            addCriterion("PROPERTY21 <>", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21GreaterThan(String value) {
            addCriterion("PROPERTY21 >", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY21 >=", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21LessThan(String value) {
            addCriterion("PROPERTY21 <", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY21 <=", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21Like(String value) {
            addCriterion("PROPERTY21 like", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21NotLike(String value) {
            addCriterion("PROPERTY21 not like", value, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21In(List<String> values) {
            addCriterion("PROPERTY21 in", values, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21NotIn(List<String> values) {
            addCriterion("PROPERTY21 not in", values, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21Between(String value1, String value2) {
            addCriterion("PROPERTY21 between", value1, value2, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty21NotBetween(String value1, String value2) {
            addCriterion("PROPERTY21 not between", value1, value2, "property21");
            return (Criteria) this;
        }

        public Criteria andProperty22IsNull() {
            addCriterion("PROPERTY22 is null");
            return (Criteria) this;
        }

        public Criteria andProperty22IsNotNull() {
            addCriterion("PROPERTY22 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty22EqualTo(String value) {
            addCriterion("PROPERTY22 =", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22NotEqualTo(String value) {
            addCriterion("PROPERTY22 <>", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22GreaterThan(String value) {
            addCriterion("PROPERTY22 >", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY22 >=", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22LessThan(String value) {
            addCriterion("PROPERTY22 <", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY22 <=", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22Like(String value) {
            addCriterion("PROPERTY22 like", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22NotLike(String value) {
            addCriterion("PROPERTY22 not like", value, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22In(List<String> values) {
            addCriterion("PROPERTY22 in", values, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22NotIn(List<String> values) {
            addCriterion("PROPERTY22 not in", values, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22Between(String value1, String value2) {
            addCriterion("PROPERTY22 between", value1, value2, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty22NotBetween(String value1, String value2) {
            addCriterion("PROPERTY22 not between", value1, value2, "property22");
            return (Criteria) this;
        }

        public Criteria andProperty23IsNull() {
            addCriterion("PROPERTY23 is null");
            return (Criteria) this;
        }

        public Criteria andProperty23IsNotNull() {
            addCriterion("PROPERTY23 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty23EqualTo(String value) {
            addCriterion("PROPERTY23 =", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23NotEqualTo(String value) {
            addCriterion("PROPERTY23 <>", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23GreaterThan(String value) {
            addCriterion("PROPERTY23 >", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY23 >=", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23LessThan(String value) {
            addCriterion("PROPERTY23 <", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY23 <=", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23Like(String value) {
            addCriterion("PROPERTY23 like", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23NotLike(String value) {
            addCriterion("PROPERTY23 not like", value, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23In(List<String> values) {
            addCriterion("PROPERTY23 in", values, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23NotIn(List<String> values) {
            addCriterion("PROPERTY23 not in", values, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23Between(String value1, String value2) {
            addCriterion("PROPERTY23 between", value1, value2, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty23NotBetween(String value1, String value2) {
            addCriterion("PROPERTY23 not between", value1, value2, "property23");
            return (Criteria) this;
        }

        public Criteria andProperty24IsNull() {
            addCriterion("PROPERTY24 is null");
            return (Criteria) this;
        }

        public Criteria andProperty24IsNotNull() {
            addCriterion("PROPERTY24 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty24EqualTo(String value) {
            addCriterion("PROPERTY24 =", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24NotEqualTo(String value) {
            addCriterion("PROPERTY24 <>", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24GreaterThan(String value) {
            addCriterion("PROPERTY24 >", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY24 >=", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24LessThan(String value) {
            addCriterion("PROPERTY24 <", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY24 <=", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24Like(String value) {
            addCriterion("PROPERTY24 like", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24NotLike(String value) {
            addCriterion("PROPERTY24 not like", value, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24In(List<String> values) {
            addCriterion("PROPERTY24 in", values, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24NotIn(List<String> values) {
            addCriterion("PROPERTY24 not in", values, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24Between(String value1, String value2) {
            addCriterion("PROPERTY24 between", value1, value2, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty24NotBetween(String value1, String value2) {
            addCriterion("PROPERTY24 not between", value1, value2, "property24");
            return (Criteria) this;
        }

        public Criteria andProperty25IsNull() {
            addCriterion("PROPERTY25 is null");
            return (Criteria) this;
        }

        public Criteria andProperty25IsNotNull() {
            addCriterion("PROPERTY25 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty25EqualTo(String value) {
            addCriterion("PROPERTY25 =", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25NotEqualTo(String value) {
            addCriterion("PROPERTY25 <>", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25GreaterThan(String value) {
            addCriterion("PROPERTY25 >", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY25 >=", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25LessThan(String value) {
            addCriterion("PROPERTY25 <", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY25 <=", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25Like(String value) {
            addCriterion("PROPERTY25 like", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25NotLike(String value) {
            addCriterion("PROPERTY25 not like", value, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25In(List<String> values) {
            addCriterion("PROPERTY25 in", values, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25NotIn(List<String> values) {
            addCriterion("PROPERTY25 not in", values, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25Between(String value1, String value2) {
            addCriterion("PROPERTY25 between", value1, value2, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty25NotBetween(String value1, String value2) {
            addCriterion("PROPERTY25 not between", value1, value2, "property25");
            return (Criteria) this;
        }

        public Criteria andProperty26IsNull() {
            addCriterion("PROPERTY26 is null");
            return (Criteria) this;
        }

        public Criteria andProperty26IsNotNull() {
            addCriterion("PROPERTY26 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty26EqualTo(String value) {
            addCriterion("PROPERTY26 =", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26NotEqualTo(String value) {
            addCriterion("PROPERTY26 <>", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26GreaterThan(String value) {
            addCriterion("PROPERTY26 >", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY26 >=", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26LessThan(String value) {
            addCriterion("PROPERTY26 <", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY26 <=", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26Like(String value) {
            addCriterion("PROPERTY26 like", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26NotLike(String value) {
            addCriterion("PROPERTY26 not like", value, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26In(List<String> values) {
            addCriterion("PROPERTY26 in", values, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26NotIn(List<String> values) {
            addCriterion("PROPERTY26 not in", values, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26Between(String value1, String value2) {
            addCriterion("PROPERTY26 between", value1, value2, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty26NotBetween(String value1, String value2) {
            addCriterion("PROPERTY26 not between", value1, value2, "property26");
            return (Criteria) this;
        }

        public Criteria andProperty27IsNull() {
            addCriterion("PROPERTY27 is null");
            return (Criteria) this;
        }

        public Criteria andProperty27IsNotNull() {
            addCriterion("PROPERTY27 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty27EqualTo(String value) {
            addCriterion("PROPERTY27 =", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27NotEqualTo(String value) {
            addCriterion("PROPERTY27 <>", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27GreaterThan(String value) {
            addCriterion("PROPERTY27 >", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY27 >=", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27LessThan(String value) {
            addCriterion("PROPERTY27 <", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY27 <=", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27Like(String value) {
            addCriterion("PROPERTY27 like", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27NotLike(String value) {
            addCriterion("PROPERTY27 not like", value, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27In(List<String> values) {
            addCriterion("PROPERTY27 in", values, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27NotIn(List<String> values) {
            addCriterion("PROPERTY27 not in", values, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27Between(String value1, String value2) {
            addCriterion("PROPERTY27 between", value1, value2, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty27NotBetween(String value1, String value2) {
            addCriterion("PROPERTY27 not between", value1, value2, "property27");
            return (Criteria) this;
        }

        public Criteria andProperty28IsNull() {
            addCriterion("PROPERTY28 is null");
            return (Criteria) this;
        }

        public Criteria andProperty28IsNotNull() {
            addCriterion("PROPERTY28 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty28EqualTo(String value) {
            addCriterion("PROPERTY28 =", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28NotEqualTo(String value) {
            addCriterion("PROPERTY28 <>", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28GreaterThan(String value) {
            addCriterion("PROPERTY28 >", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY28 >=", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28LessThan(String value) {
            addCriterion("PROPERTY28 <", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY28 <=", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28Like(String value) {
            addCriterion("PROPERTY28 like", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28NotLike(String value) {
            addCriterion("PROPERTY28 not like", value, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28In(List<String> values) {
            addCriterion("PROPERTY28 in", values, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28NotIn(List<String> values) {
            addCriterion("PROPERTY28 not in", values, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28Between(String value1, String value2) {
            addCriterion("PROPERTY28 between", value1, value2, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty28NotBetween(String value1, String value2) {
            addCriterion("PROPERTY28 not between", value1, value2, "property28");
            return (Criteria) this;
        }

        public Criteria andProperty29IsNull() {
            addCriterion("PROPERTY29 is null");
            return (Criteria) this;
        }

        public Criteria andProperty29IsNotNull() {
            addCriterion("PROPERTY29 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty29EqualTo(String value) {
            addCriterion("PROPERTY29 =", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29NotEqualTo(String value) {
            addCriterion("PROPERTY29 <>", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29GreaterThan(String value) {
            addCriterion("PROPERTY29 >", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY29 >=", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29LessThan(String value) {
            addCriterion("PROPERTY29 <", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY29 <=", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29Like(String value) {
            addCriterion("PROPERTY29 like", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29NotLike(String value) {
            addCriterion("PROPERTY29 not like", value, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29In(List<String> values) {
            addCriterion("PROPERTY29 in", values, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29NotIn(List<String> values) {
            addCriterion("PROPERTY29 not in", values, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29Between(String value1, String value2) {
            addCriterion("PROPERTY29 between", value1, value2, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty29NotBetween(String value1, String value2) {
            addCriterion("PROPERTY29 not between", value1, value2, "property29");
            return (Criteria) this;
        }

        public Criteria andProperty30IsNull() {
            addCriterion("PROPERTY30 is null");
            return (Criteria) this;
        }

        public Criteria andProperty30IsNotNull() {
            addCriterion("PROPERTY30 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty30EqualTo(String value) {
            addCriterion("PROPERTY30 =", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30NotEqualTo(String value) {
            addCriterion("PROPERTY30 <>", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30GreaterThan(String value) {
            addCriterion("PROPERTY30 >", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY30 >=", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30LessThan(String value) {
            addCriterion("PROPERTY30 <", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY30 <=", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30Like(String value) {
            addCriterion("PROPERTY30 like", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30NotLike(String value) {
            addCriterion("PROPERTY30 not like", value, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30In(List<String> values) {
            addCriterion("PROPERTY30 in", values, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30NotIn(List<String> values) {
            addCriterion("PROPERTY30 not in", values, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30Between(String value1, String value2) {
            addCriterion("PROPERTY30 between", value1, value2, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty30NotBetween(String value1, String value2) {
            addCriterion("PROPERTY30 not between", value1, value2, "property30");
            return (Criteria) this;
        }

        public Criteria andProperty31IsNull() {
            addCriterion("PROPERTY31 is null");
            return (Criteria) this;
        }

        public Criteria andProperty31IsNotNull() {
            addCriterion("PROPERTY31 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty31EqualTo(String value) {
            addCriterion("PROPERTY31 =", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31NotEqualTo(String value) {
            addCriterion("PROPERTY31 <>", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31GreaterThan(String value) {
            addCriterion("PROPERTY31 >", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY31 >=", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31LessThan(String value) {
            addCriterion("PROPERTY31 <", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY31 <=", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31Like(String value) {
            addCriterion("PROPERTY31 like", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31NotLike(String value) {
            addCriterion("PROPERTY31 not like", value, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31In(List<String> values) {
            addCriterion("PROPERTY31 in", values, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31NotIn(List<String> values) {
            addCriterion("PROPERTY31 not in", values, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31Between(String value1, String value2) {
            addCriterion("PROPERTY31 between", value1, value2, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty31NotBetween(String value1, String value2) {
            addCriterion("PROPERTY31 not between", value1, value2, "property31");
            return (Criteria) this;
        }

        public Criteria andProperty32IsNull() {
            addCriterion("PROPERTY32 is null");
            return (Criteria) this;
        }

        public Criteria andProperty32IsNotNull() {
            addCriterion("PROPERTY32 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty32EqualTo(String value) {
            addCriterion("PROPERTY32 =", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32NotEqualTo(String value) {
            addCriterion("PROPERTY32 <>", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32GreaterThan(String value) {
            addCriterion("PROPERTY32 >", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY32 >=", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32LessThan(String value) {
            addCriterion("PROPERTY32 <", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY32 <=", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32Like(String value) {
            addCriterion("PROPERTY32 like", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32NotLike(String value) {
            addCriterion("PROPERTY32 not like", value, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32In(List<String> values) {
            addCriterion("PROPERTY32 in", values, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32NotIn(List<String> values) {
            addCriterion("PROPERTY32 not in", values, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32Between(String value1, String value2) {
            addCriterion("PROPERTY32 between", value1, value2, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty32NotBetween(String value1, String value2) {
            addCriterion("PROPERTY32 not between", value1, value2, "property32");
            return (Criteria) this;
        }

        public Criteria andProperty33IsNull() {
            addCriterion("PROPERTY33 is null");
            return (Criteria) this;
        }

        public Criteria andProperty33IsNotNull() {
            addCriterion("PROPERTY33 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty33EqualTo(String value) {
            addCriterion("PROPERTY33 =", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33NotEqualTo(String value) {
            addCriterion("PROPERTY33 <>", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33GreaterThan(String value) {
            addCriterion("PROPERTY33 >", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY33 >=", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33LessThan(String value) {
            addCriterion("PROPERTY33 <", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY33 <=", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33Like(String value) {
            addCriterion("PROPERTY33 like", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33NotLike(String value) {
            addCriterion("PROPERTY33 not like", value, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33In(List<String> values) {
            addCriterion("PROPERTY33 in", values, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33NotIn(List<String> values) {
            addCriterion("PROPERTY33 not in", values, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33Between(String value1, String value2) {
            addCriterion("PROPERTY33 between", value1, value2, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty33NotBetween(String value1, String value2) {
            addCriterion("PROPERTY33 not between", value1, value2, "property33");
            return (Criteria) this;
        }

        public Criteria andProperty34IsNull() {
            addCriterion("PROPERTY34 is null");
            return (Criteria) this;
        }

        public Criteria andProperty34IsNotNull() {
            addCriterion("PROPERTY34 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty34EqualTo(String value) {
            addCriterion("PROPERTY34 =", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34NotEqualTo(String value) {
            addCriterion("PROPERTY34 <>", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34GreaterThan(String value) {
            addCriterion("PROPERTY34 >", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY34 >=", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34LessThan(String value) {
            addCriterion("PROPERTY34 <", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY34 <=", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34Like(String value) {
            addCriterion("PROPERTY34 like", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34NotLike(String value) {
            addCriterion("PROPERTY34 not like", value, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34In(List<String> values) {
            addCriterion("PROPERTY34 in", values, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34NotIn(List<String> values) {
            addCriterion("PROPERTY34 not in", values, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34Between(String value1, String value2) {
            addCriterion("PROPERTY34 between", value1, value2, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty34NotBetween(String value1, String value2) {
            addCriterion("PROPERTY34 not between", value1, value2, "property34");
            return (Criteria) this;
        }

        public Criteria andProperty35IsNull() {
            addCriterion("PROPERTY35 is null");
            return (Criteria) this;
        }

        public Criteria andProperty35IsNotNull() {
            addCriterion("PROPERTY35 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty35EqualTo(String value) {
            addCriterion("PROPERTY35 =", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35NotEqualTo(String value) {
            addCriterion("PROPERTY35 <>", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35GreaterThan(String value) {
            addCriterion("PROPERTY35 >", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY35 >=", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35LessThan(String value) {
            addCriterion("PROPERTY35 <", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY35 <=", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35Like(String value) {
            addCriterion("PROPERTY35 like", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35NotLike(String value) {
            addCriterion("PROPERTY35 not like", value, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35In(List<String> values) {
            addCriterion("PROPERTY35 in", values, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35NotIn(List<String> values) {
            addCriterion("PROPERTY35 not in", values, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35Between(String value1, String value2) {
            addCriterion("PROPERTY35 between", value1, value2, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty35NotBetween(String value1, String value2) {
            addCriterion("PROPERTY35 not between", value1, value2, "property35");
            return (Criteria) this;
        }

        public Criteria andProperty36IsNull() {
            addCriterion("PROPERTY36 is null");
            return (Criteria) this;
        }

        public Criteria andProperty36IsNotNull() {
            addCriterion("PROPERTY36 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty36EqualTo(String value) {
            addCriterion("PROPERTY36 =", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36NotEqualTo(String value) {
            addCriterion("PROPERTY36 <>", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36GreaterThan(String value) {
            addCriterion("PROPERTY36 >", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY36 >=", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36LessThan(String value) {
            addCriterion("PROPERTY36 <", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY36 <=", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36Like(String value) {
            addCriterion("PROPERTY36 like", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36NotLike(String value) {
            addCriterion("PROPERTY36 not like", value, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36In(List<String> values) {
            addCriterion("PROPERTY36 in", values, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36NotIn(List<String> values) {
            addCriterion("PROPERTY36 not in", values, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36Between(String value1, String value2) {
            addCriterion("PROPERTY36 between", value1, value2, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty36NotBetween(String value1, String value2) {
            addCriterion("PROPERTY36 not between", value1, value2, "property36");
            return (Criteria) this;
        }

        public Criteria andProperty37IsNull() {
            addCriterion("PROPERTY37 is null");
            return (Criteria) this;
        }

        public Criteria andProperty37IsNotNull() {
            addCriterion("PROPERTY37 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty37EqualTo(String value) {
            addCriterion("PROPERTY37 =", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37NotEqualTo(String value) {
            addCriterion("PROPERTY37 <>", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37GreaterThan(String value) {
            addCriterion("PROPERTY37 >", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY37 >=", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37LessThan(String value) {
            addCriterion("PROPERTY37 <", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY37 <=", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37Like(String value) {
            addCriterion("PROPERTY37 like", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37NotLike(String value) {
            addCriterion("PROPERTY37 not like", value, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37In(List<String> values) {
            addCriterion("PROPERTY37 in", values, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37NotIn(List<String> values) {
            addCriterion("PROPERTY37 not in", values, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37Between(String value1, String value2) {
            addCriterion("PROPERTY37 between", value1, value2, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty37NotBetween(String value1, String value2) {
            addCriterion("PROPERTY37 not between", value1, value2, "property37");
            return (Criteria) this;
        }

        public Criteria andProperty38IsNull() {
            addCriterion("PROPERTY38 is null");
            return (Criteria) this;
        }

        public Criteria andProperty38IsNotNull() {
            addCriterion("PROPERTY38 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty38EqualTo(String value) {
            addCriterion("PROPERTY38 =", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38NotEqualTo(String value) {
            addCriterion("PROPERTY38 <>", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38GreaterThan(String value) {
            addCriterion("PROPERTY38 >", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY38 >=", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38LessThan(String value) {
            addCriterion("PROPERTY38 <", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY38 <=", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38Like(String value) {
            addCriterion("PROPERTY38 like", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38NotLike(String value) {
            addCriterion("PROPERTY38 not like", value, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38In(List<String> values) {
            addCriterion("PROPERTY38 in", values, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38NotIn(List<String> values) {
            addCriterion("PROPERTY38 not in", values, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38Between(String value1, String value2) {
            addCriterion("PROPERTY38 between", value1, value2, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty38NotBetween(String value1, String value2) {
            addCriterion("PROPERTY38 not between", value1, value2, "property38");
            return (Criteria) this;
        }

        public Criteria andProperty39IsNull() {
            addCriterion("PROPERTY39 is null");
            return (Criteria) this;
        }

        public Criteria andProperty39IsNotNull() {
            addCriterion("PROPERTY39 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty39EqualTo(String value) {
            addCriterion("PROPERTY39 =", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39NotEqualTo(String value) {
            addCriterion("PROPERTY39 <>", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39GreaterThan(String value) {
            addCriterion("PROPERTY39 >", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY39 >=", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39LessThan(String value) {
            addCriterion("PROPERTY39 <", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY39 <=", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39Like(String value) {
            addCriterion("PROPERTY39 like", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39NotLike(String value) {
            addCriterion("PROPERTY39 not like", value, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39In(List<String> values) {
            addCriterion("PROPERTY39 in", values, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39NotIn(List<String> values) {
            addCriterion("PROPERTY39 not in", values, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39Between(String value1, String value2) {
            addCriterion("PROPERTY39 between", value1, value2, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty39NotBetween(String value1, String value2) {
            addCriterion("PROPERTY39 not between", value1, value2, "property39");
            return (Criteria) this;
        }

        public Criteria andProperty40IsNull() {
            addCriterion("PROPERTY40 is null");
            return (Criteria) this;
        }

        public Criteria andProperty40IsNotNull() {
            addCriterion("PROPERTY40 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty40EqualTo(String value) {
            addCriterion("PROPERTY40 =", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40NotEqualTo(String value) {
            addCriterion("PROPERTY40 <>", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40GreaterThan(String value) {
            addCriterion("PROPERTY40 >", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY40 >=", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40LessThan(String value) {
            addCriterion("PROPERTY40 <", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY40 <=", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40Like(String value) {
            addCriterion("PROPERTY40 like", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40NotLike(String value) {
            addCriterion("PROPERTY40 not like", value, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40In(List<String> values) {
            addCriterion("PROPERTY40 in", values, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40NotIn(List<String> values) {
            addCriterion("PROPERTY40 not in", values, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40Between(String value1, String value2) {
            addCriterion("PROPERTY40 between", value1, value2, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty40NotBetween(String value1, String value2) {
            addCriterion("PROPERTY40 not between", value1, value2, "property40");
            return (Criteria) this;
        }

        public Criteria andProperty41IsNull() {
            addCriterion("PROPERTY41 is null");
            return (Criteria) this;
        }

        public Criteria andProperty41IsNotNull() {
            addCriterion("PROPERTY41 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty41EqualTo(String value) {
            addCriterion("PROPERTY41 =", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41NotEqualTo(String value) {
            addCriterion("PROPERTY41 <>", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41GreaterThan(String value) {
            addCriterion("PROPERTY41 >", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY41 >=", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41LessThan(String value) {
            addCriterion("PROPERTY41 <", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY41 <=", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41Like(String value) {
            addCriterion("PROPERTY41 like", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41NotLike(String value) {
            addCriterion("PROPERTY41 not like", value, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41In(List<String> values) {
            addCriterion("PROPERTY41 in", values, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41NotIn(List<String> values) {
            addCriterion("PROPERTY41 not in", values, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41Between(String value1, String value2) {
            addCriterion("PROPERTY41 between", value1, value2, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty41NotBetween(String value1, String value2) {
            addCriterion("PROPERTY41 not between", value1, value2, "property41");
            return (Criteria) this;
        }

        public Criteria andProperty42IsNull() {
            addCriterion("PROPERTY42 is null");
            return (Criteria) this;
        }

        public Criteria andProperty42IsNotNull() {
            addCriterion("PROPERTY42 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty42EqualTo(String value) {
            addCriterion("PROPERTY42 =", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42NotEqualTo(String value) {
            addCriterion("PROPERTY42 <>", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42GreaterThan(String value) {
            addCriterion("PROPERTY42 >", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY42 >=", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42LessThan(String value) {
            addCriterion("PROPERTY42 <", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY42 <=", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42Like(String value) {
            addCriterion("PROPERTY42 like", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42NotLike(String value) {
            addCriterion("PROPERTY42 not like", value, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42In(List<String> values) {
            addCriterion("PROPERTY42 in", values, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42NotIn(List<String> values) {
            addCriterion("PROPERTY42 not in", values, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42Between(String value1, String value2) {
            addCriterion("PROPERTY42 between", value1, value2, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty42NotBetween(String value1, String value2) {
            addCriterion("PROPERTY42 not between", value1, value2, "property42");
            return (Criteria) this;
        }

        public Criteria andProperty43IsNull() {
            addCriterion("PROPERTY43 is null");
            return (Criteria) this;
        }

        public Criteria andProperty43IsNotNull() {
            addCriterion("PROPERTY43 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty43EqualTo(String value) {
            addCriterion("PROPERTY43 =", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43NotEqualTo(String value) {
            addCriterion("PROPERTY43 <>", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43GreaterThan(String value) {
            addCriterion("PROPERTY43 >", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY43 >=", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43LessThan(String value) {
            addCriterion("PROPERTY43 <", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY43 <=", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43Like(String value) {
            addCriterion("PROPERTY43 like", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43NotLike(String value) {
            addCriterion("PROPERTY43 not like", value, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43In(List<String> values) {
            addCriterion("PROPERTY43 in", values, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43NotIn(List<String> values) {
            addCriterion("PROPERTY43 not in", values, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43Between(String value1, String value2) {
            addCriterion("PROPERTY43 between", value1, value2, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty43NotBetween(String value1, String value2) {
            addCriterion("PROPERTY43 not between", value1, value2, "property43");
            return (Criteria) this;
        }

        public Criteria andProperty44IsNull() {
            addCriterion("PROPERTY44 is null");
            return (Criteria) this;
        }

        public Criteria andProperty44IsNotNull() {
            addCriterion("PROPERTY44 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty44EqualTo(String value) {
            addCriterion("PROPERTY44 =", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44NotEqualTo(String value) {
            addCriterion("PROPERTY44 <>", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44GreaterThan(String value) {
            addCriterion("PROPERTY44 >", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY44 >=", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44LessThan(String value) {
            addCriterion("PROPERTY44 <", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY44 <=", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44Like(String value) {
            addCriterion("PROPERTY44 like", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44NotLike(String value) {
            addCriterion("PROPERTY44 not like", value, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44In(List<String> values) {
            addCriterion("PROPERTY44 in", values, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44NotIn(List<String> values) {
            addCriterion("PROPERTY44 not in", values, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44Between(String value1, String value2) {
            addCriterion("PROPERTY44 between", value1, value2, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty44NotBetween(String value1, String value2) {
            addCriterion("PROPERTY44 not between", value1, value2, "property44");
            return (Criteria) this;
        }

        public Criteria andProperty45IsNull() {
            addCriterion("PROPERTY45 is null");
            return (Criteria) this;
        }

        public Criteria andProperty45IsNotNull() {
            addCriterion("PROPERTY45 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty45EqualTo(String value) {
            addCriterion("PROPERTY45 =", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45NotEqualTo(String value) {
            addCriterion("PROPERTY45 <>", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45GreaterThan(String value) {
            addCriterion("PROPERTY45 >", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY45 >=", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45LessThan(String value) {
            addCriterion("PROPERTY45 <", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY45 <=", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45Like(String value) {
            addCriterion("PROPERTY45 like", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45NotLike(String value) {
            addCriterion("PROPERTY45 not like", value, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45In(List<String> values) {
            addCriterion("PROPERTY45 in", values, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45NotIn(List<String> values) {
            addCriterion("PROPERTY45 not in", values, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45Between(String value1, String value2) {
            addCriterion("PROPERTY45 between", value1, value2, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty45NotBetween(String value1, String value2) {
            addCriterion("PROPERTY45 not between", value1, value2, "property45");
            return (Criteria) this;
        }

        public Criteria andProperty46IsNull() {
            addCriterion("PROPERTY46 is null");
            return (Criteria) this;
        }

        public Criteria andProperty46IsNotNull() {
            addCriterion("PROPERTY46 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty46EqualTo(String value) {
            addCriterion("PROPERTY46 =", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46NotEqualTo(String value) {
            addCriterion("PROPERTY46 <>", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46GreaterThan(String value) {
            addCriterion("PROPERTY46 >", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY46 >=", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46LessThan(String value) {
            addCriterion("PROPERTY46 <", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY46 <=", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46Like(String value) {
            addCriterion("PROPERTY46 like", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46NotLike(String value) {
            addCriterion("PROPERTY46 not like", value, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46In(List<String> values) {
            addCriterion("PROPERTY46 in", values, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46NotIn(List<String> values) {
            addCriterion("PROPERTY46 not in", values, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46Between(String value1, String value2) {
            addCriterion("PROPERTY46 between", value1, value2, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty46NotBetween(String value1, String value2) {
            addCriterion("PROPERTY46 not between", value1, value2, "property46");
            return (Criteria) this;
        }

        public Criteria andProperty47IsNull() {
            addCriterion("PROPERTY47 is null");
            return (Criteria) this;
        }

        public Criteria andProperty47IsNotNull() {
            addCriterion("PROPERTY47 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty47EqualTo(String value) {
            addCriterion("PROPERTY47 =", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47NotEqualTo(String value) {
            addCriterion("PROPERTY47 <>", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47GreaterThan(String value) {
            addCriterion("PROPERTY47 >", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY47 >=", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47LessThan(String value) {
            addCriterion("PROPERTY47 <", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY47 <=", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47Like(String value) {
            addCriterion("PROPERTY47 like", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47NotLike(String value) {
            addCriterion("PROPERTY47 not like", value, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47In(List<String> values) {
            addCriterion("PROPERTY47 in", values, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47NotIn(List<String> values) {
            addCriterion("PROPERTY47 not in", values, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47Between(String value1, String value2) {
            addCriterion("PROPERTY47 between", value1, value2, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty47NotBetween(String value1, String value2) {
            addCriterion("PROPERTY47 not between", value1, value2, "property47");
            return (Criteria) this;
        }

        public Criteria andProperty48IsNull() {
            addCriterion("PROPERTY48 is null");
            return (Criteria) this;
        }

        public Criteria andProperty48IsNotNull() {
            addCriterion("PROPERTY48 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty48EqualTo(String value) {
            addCriterion("PROPERTY48 =", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48NotEqualTo(String value) {
            addCriterion("PROPERTY48 <>", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48GreaterThan(String value) {
            addCriterion("PROPERTY48 >", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY48 >=", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48LessThan(String value) {
            addCriterion("PROPERTY48 <", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY48 <=", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48Like(String value) {
            addCriterion("PROPERTY48 like", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48NotLike(String value) {
            addCriterion("PROPERTY48 not like", value, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48In(List<String> values) {
            addCriterion("PROPERTY48 in", values, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48NotIn(List<String> values) {
            addCriterion("PROPERTY48 not in", values, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48Between(String value1, String value2) {
            addCriterion("PROPERTY48 between", value1, value2, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty48NotBetween(String value1, String value2) {
            addCriterion("PROPERTY48 not between", value1, value2, "property48");
            return (Criteria) this;
        }

        public Criteria andProperty49IsNull() {
            addCriterion("PROPERTY49 is null");
            return (Criteria) this;
        }

        public Criteria andProperty49IsNotNull() {
            addCriterion("PROPERTY49 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty49EqualTo(String value) {
            addCriterion("PROPERTY49 =", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49NotEqualTo(String value) {
            addCriterion("PROPERTY49 <>", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49GreaterThan(String value) {
            addCriterion("PROPERTY49 >", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY49 >=", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49LessThan(String value) {
            addCriterion("PROPERTY49 <", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY49 <=", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49Like(String value) {
            addCriterion("PROPERTY49 like", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49NotLike(String value) {
            addCriterion("PROPERTY49 not like", value, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49In(List<String> values) {
            addCriterion("PROPERTY49 in", values, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49NotIn(List<String> values) {
            addCriterion("PROPERTY49 not in", values, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49Between(String value1, String value2) {
            addCriterion("PROPERTY49 between", value1, value2, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty49NotBetween(String value1, String value2) {
            addCriterion("PROPERTY49 not between", value1, value2, "property49");
            return (Criteria) this;
        }

        public Criteria andProperty50IsNull() {
            addCriterion("PROPERTY50 is null");
            return (Criteria) this;
        }

        public Criteria andProperty50IsNotNull() {
            addCriterion("PROPERTY50 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty50EqualTo(String value) {
            addCriterion("PROPERTY50 =", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50NotEqualTo(String value) {
            addCriterion("PROPERTY50 <>", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50GreaterThan(String value) {
            addCriterion("PROPERTY50 >", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY50 >=", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50LessThan(String value) {
            addCriterion("PROPERTY50 <", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY50 <=", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50Like(String value) {
            addCriterion("PROPERTY50 like", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50NotLike(String value) {
            addCriterion("PROPERTY50 not like", value, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50In(List<String> values) {
            addCriterion("PROPERTY50 in", values, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50NotIn(List<String> values) {
            addCriterion("PROPERTY50 not in", values, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50Between(String value1, String value2) {
            addCriterion("PROPERTY50 between", value1, value2, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty50NotBetween(String value1, String value2) {
            addCriterion("PROPERTY50 not between", value1, value2, "property50");
            return (Criteria) this;
        }

        public Criteria andProperty51IsNull() {
            addCriterion("PROPERTY51 is null");
            return (Criteria) this;
        }

        public Criteria andProperty51IsNotNull() {
            addCriterion("PROPERTY51 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty51EqualTo(String value) {
            addCriterion("PROPERTY51 =", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51NotEqualTo(String value) {
            addCriterion("PROPERTY51 <>", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51GreaterThan(String value) {
            addCriterion("PROPERTY51 >", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY51 >=", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51LessThan(String value) {
            addCriterion("PROPERTY51 <", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY51 <=", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51Like(String value) {
            addCriterion("PROPERTY51 like", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51NotLike(String value) {
            addCriterion("PROPERTY51 not like", value, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51In(List<String> values) {
            addCriterion("PROPERTY51 in", values, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51NotIn(List<String> values) {
            addCriterion("PROPERTY51 not in", values, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51Between(String value1, String value2) {
            addCriterion("PROPERTY51 between", value1, value2, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty51NotBetween(String value1, String value2) {
            addCriterion("PROPERTY51 not between", value1, value2, "property51");
            return (Criteria) this;
        }

        public Criteria andProperty52IsNull() {
            addCriterion("PROPERTY52 is null");
            return (Criteria) this;
        }

        public Criteria andProperty52IsNotNull() {
            addCriterion("PROPERTY52 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty52EqualTo(String value) {
            addCriterion("PROPERTY52 =", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52NotEqualTo(String value) {
            addCriterion("PROPERTY52 <>", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52GreaterThan(String value) {
            addCriterion("PROPERTY52 >", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY52 >=", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52LessThan(String value) {
            addCriterion("PROPERTY52 <", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY52 <=", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52Like(String value) {
            addCriterion("PROPERTY52 like", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52NotLike(String value) {
            addCriterion("PROPERTY52 not like", value, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52In(List<String> values) {
            addCriterion("PROPERTY52 in", values, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52NotIn(List<String> values) {
            addCriterion("PROPERTY52 not in", values, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52Between(String value1, String value2) {
            addCriterion("PROPERTY52 between", value1, value2, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty52NotBetween(String value1, String value2) {
            addCriterion("PROPERTY52 not between", value1, value2, "property52");
            return (Criteria) this;
        }

        public Criteria andProperty53IsNull() {
            addCriterion("PROPERTY53 is null");
            return (Criteria) this;
        }

        public Criteria andProperty53IsNotNull() {
            addCriterion("PROPERTY53 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty53EqualTo(String value) {
            addCriterion("PROPERTY53 =", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53NotEqualTo(String value) {
            addCriterion("PROPERTY53 <>", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53GreaterThan(String value) {
            addCriterion("PROPERTY53 >", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY53 >=", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53LessThan(String value) {
            addCriterion("PROPERTY53 <", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY53 <=", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53Like(String value) {
            addCriterion("PROPERTY53 like", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53NotLike(String value) {
            addCriterion("PROPERTY53 not like", value, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53In(List<String> values) {
            addCriterion("PROPERTY53 in", values, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53NotIn(List<String> values) {
            addCriterion("PROPERTY53 not in", values, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53Between(String value1, String value2) {
            addCriterion("PROPERTY53 between", value1, value2, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty53NotBetween(String value1, String value2) {
            addCriterion("PROPERTY53 not between", value1, value2, "property53");
            return (Criteria) this;
        }

        public Criteria andProperty54IsNull() {
            addCriterion("PROPERTY54 is null");
            return (Criteria) this;
        }

        public Criteria andProperty54IsNotNull() {
            addCriterion("PROPERTY54 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty54EqualTo(String value) {
            addCriterion("PROPERTY54 =", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54NotEqualTo(String value) {
            addCriterion("PROPERTY54 <>", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54GreaterThan(String value) {
            addCriterion("PROPERTY54 >", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY54 >=", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54LessThan(String value) {
            addCriterion("PROPERTY54 <", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY54 <=", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54Like(String value) {
            addCriterion("PROPERTY54 like", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54NotLike(String value) {
            addCriterion("PROPERTY54 not like", value, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54In(List<String> values) {
            addCriterion("PROPERTY54 in", values, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54NotIn(List<String> values) {
            addCriterion("PROPERTY54 not in", values, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54Between(String value1, String value2) {
            addCriterion("PROPERTY54 between", value1, value2, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty54NotBetween(String value1, String value2) {
            addCriterion("PROPERTY54 not between", value1, value2, "property54");
            return (Criteria) this;
        }

        public Criteria andProperty55IsNull() {
            addCriterion("PROPERTY55 is null");
            return (Criteria) this;
        }

        public Criteria andProperty55IsNotNull() {
            addCriterion("PROPERTY55 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty55EqualTo(String value) {
            addCriterion("PROPERTY55 =", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55NotEqualTo(String value) {
            addCriterion("PROPERTY55 <>", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55GreaterThan(String value) {
            addCriterion("PROPERTY55 >", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY55 >=", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55LessThan(String value) {
            addCriterion("PROPERTY55 <", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY55 <=", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55Like(String value) {
            addCriterion("PROPERTY55 like", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55NotLike(String value) {
            addCriterion("PROPERTY55 not like", value, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55In(List<String> values) {
            addCriterion("PROPERTY55 in", values, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55NotIn(List<String> values) {
            addCriterion("PROPERTY55 not in", values, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55Between(String value1, String value2) {
            addCriterion("PROPERTY55 between", value1, value2, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty55NotBetween(String value1, String value2) {
            addCriterion("PROPERTY55 not between", value1, value2, "property55");
            return (Criteria) this;
        }

        public Criteria andProperty56IsNull() {
            addCriterion("PROPERTY56 is null");
            return (Criteria) this;
        }

        public Criteria andProperty56IsNotNull() {
            addCriterion("PROPERTY56 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty56EqualTo(String value) {
            addCriterion("PROPERTY56 =", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56NotEqualTo(String value) {
            addCriterion("PROPERTY56 <>", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56GreaterThan(String value) {
            addCriterion("PROPERTY56 >", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY56 >=", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56LessThan(String value) {
            addCriterion("PROPERTY56 <", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY56 <=", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56Like(String value) {
            addCriterion("PROPERTY56 like", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56NotLike(String value) {
            addCriterion("PROPERTY56 not like", value, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56In(List<String> values) {
            addCriterion("PROPERTY56 in", values, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56NotIn(List<String> values) {
            addCriterion("PROPERTY56 not in", values, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56Between(String value1, String value2) {
            addCriterion("PROPERTY56 between", value1, value2, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty56NotBetween(String value1, String value2) {
            addCriterion("PROPERTY56 not between", value1, value2, "property56");
            return (Criteria) this;
        }

        public Criteria andProperty57IsNull() {
            addCriterion("PROPERTY57 is null");
            return (Criteria) this;
        }

        public Criteria andProperty57IsNotNull() {
            addCriterion("PROPERTY57 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty57EqualTo(String value) {
            addCriterion("PROPERTY57 =", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57NotEqualTo(String value) {
            addCriterion("PROPERTY57 <>", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57GreaterThan(String value) {
            addCriterion("PROPERTY57 >", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY57 >=", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57LessThan(String value) {
            addCriterion("PROPERTY57 <", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY57 <=", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57Like(String value) {
            addCriterion("PROPERTY57 like", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57NotLike(String value) {
            addCriterion("PROPERTY57 not like", value, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57In(List<String> values) {
            addCriterion("PROPERTY57 in", values, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57NotIn(List<String> values) {
            addCriterion("PROPERTY57 not in", values, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57Between(String value1, String value2) {
            addCriterion("PROPERTY57 between", value1, value2, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty57NotBetween(String value1, String value2) {
            addCriterion("PROPERTY57 not between", value1, value2, "property57");
            return (Criteria) this;
        }

        public Criteria andProperty58IsNull() {
            addCriterion("PROPERTY58 is null");
            return (Criteria) this;
        }

        public Criteria andProperty58IsNotNull() {
            addCriterion("PROPERTY58 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty58EqualTo(String value) {
            addCriterion("PROPERTY58 =", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58NotEqualTo(String value) {
            addCriterion("PROPERTY58 <>", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58GreaterThan(String value) {
            addCriterion("PROPERTY58 >", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY58 >=", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58LessThan(String value) {
            addCriterion("PROPERTY58 <", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY58 <=", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58Like(String value) {
            addCriterion("PROPERTY58 like", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58NotLike(String value) {
            addCriterion("PROPERTY58 not like", value, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58In(List<String> values) {
            addCriterion("PROPERTY58 in", values, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58NotIn(List<String> values) {
            addCriterion("PROPERTY58 not in", values, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58Between(String value1, String value2) {
            addCriterion("PROPERTY58 between", value1, value2, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty58NotBetween(String value1, String value2) {
            addCriterion("PROPERTY58 not between", value1, value2, "property58");
            return (Criteria) this;
        }

        public Criteria andProperty59IsNull() {
            addCriterion("PROPERTY59 is null");
            return (Criteria) this;
        }

        public Criteria andProperty59IsNotNull() {
            addCriterion("PROPERTY59 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty59EqualTo(String value) {
            addCriterion("PROPERTY59 =", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59NotEqualTo(String value) {
            addCriterion("PROPERTY59 <>", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59GreaterThan(String value) {
            addCriterion("PROPERTY59 >", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY59 >=", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59LessThan(String value) {
            addCriterion("PROPERTY59 <", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY59 <=", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59Like(String value) {
            addCriterion("PROPERTY59 like", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59NotLike(String value) {
            addCriterion("PROPERTY59 not like", value, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59In(List<String> values) {
            addCriterion("PROPERTY59 in", values, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59NotIn(List<String> values) {
            addCriterion("PROPERTY59 not in", values, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59Between(String value1, String value2) {
            addCriterion("PROPERTY59 between", value1, value2, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty59NotBetween(String value1, String value2) {
            addCriterion("PROPERTY59 not between", value1, value2, "property59");
            return (Criteria) this;
        }

        public Criteria andProperty60IsNull() {
            addCriterion("PROPERTY60 is null");
            return (Criteria) this;
        }

        public Criteria andProperty60IsNotNull() {
            addCriterion("PROPERTY60 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty60EqualTo(String value) {
            addCriterion("PROPERTY60 =", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60NotEqualTo(String value) {
            addCriterion("PROPERTY60 <>", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60GreaterThan(String value) {
            addCriterion("PROPERTY60 >", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY60 >=", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60LessThan(String value) {
            addCriterion("PROPERTY60 <", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY60 <=", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60Like(String value) {
            addCriterion("PROPERTY60 like", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60NotLike(String value) {
            addCriterion("PROPERTY60 not like", value, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60In(List<String> values) {
            addCriterion("PROPERTY60 in", values, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60NotIn(List<String> values) {
            addCriterion("PROPERTY60 not in", values, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60Between(String value1, String value2) {
            addCriterion("PROPERTY60 between", value1, value2, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty60NotBetween(String value1, String value2) {
            addCriterion("PROPERTY60 not between", value1, value2, "property60");
            return (Criteria) this;
        }

        public Criteria andProperty61IsNull() {
            addCriterion("PROPERTY61 is null");
            return (Criteria) this;
        }

        public Criteria andProperty61IsNotNull() {
            addCriterion("PROPERTY61 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty61EqualTo(String value) {
            addCriterion("PROPERTY61 =", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61NotEqualTo(String value) {
            addCriterion("PROPERTY61 <>", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61GreaterThan(String value) {
            addCriterion("PROPERTY61 >", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY61 >=", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61LessThan(String value) {
            addCriterion("PROPERTY61 <", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY61 <=", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61Like(String value) {
            addCriterion("PROPERTY61 like", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61NotLike(String value) {
            addCriterion("PROPERTY61 not like", value, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61In(List<String> values) {
            addCriterion("PROPERTY61 in", values, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61NotIn(List<String> values) {
            addCriterion("PROPERTY61 not in", values, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61Between(String value1, String value2) {
            addCriterion("PROPERTY61 between", value1, value2, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty61NotBetween(String value1, String value2) {
            addCriterion("PROPERTY61 not between", value1, value2, "property61");
            return (Criteria) this;
        }

        public Criteria andProperty62IsNull() {
            addCriterion("PROPERTY62 is null");
            return (Criteria) this;
        }

        public Criteria andProperty62IsNotNull() {
            addCriterion("PROPERTY62 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty62EqualTo(String value) {
            addCriterion("PROPERTY62 =", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62NotEqualTo(String value) {
            addCriterion("PROPERTY62 <>", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62GreaterThan(String value) {
            addCriterion("PROPERTY62 >", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY62 >=", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62LessThan(String value) {
            addCriterion("PROPERTY62 <", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY62 <=", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62Like(String value) {
            addCriterion("PROPERTY62 like", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62NotLike(String value) {
            addCriterion("PROPERTY62 not like", value, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62In(List<String> values) {
            addCriterion("PROPERTY62 in", values, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62NotIn(List<String> values) {
            addCriterion("PROPERTY62 not in", values, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62Between(String value1, String value2) {
            addCriterion("PROPERTY62 between", value1, value2, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty62NotBetween(String value1, String value2) {
            addCriterion("PROPERTY62 not between", value1, value2, "property62");
            return (Criteria) this;
        }

        public Criteria andProperty63IsNull() {
            addCriterion("PROPERTY63 is null");
            return (Criteria) this;
        }

        public Criteria andProperty63IsNotNull() {
            addCriterion("PROPERTY63 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty63EqualTo(String value) {
            addCriterion("PROPERTY63 =", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63NotEqualTo(String value) {
            addCriterion("PROPERTY63 <>", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63GreaterThan(String value) {
            addCriterion("PROPERTY63 >", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY63 >=", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63LessThan(String value) {
            addCriterion("PROPERTY63 <", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY63 <=", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63Like(String value) {
            addCriterion("PROPERTY63 like", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63NotLike(String value) {
            addCriterion("PROPERTY63 not like", value, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63In(List<String> values) {
            addCriterion("PROPERTY63 in", values, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63NotIn(List<String> values) {
            addCriterion("PROPERTY63 not in", values, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63Between(String value1, String value2) {
            addCriterion("PROPERTY63 between", value1, value2, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty63NotBetween(String value1, String value2) {
            addCriterion("PROPERTY63 not between", value1, value2, "property63");
            return (Criteria) this;
        }

        public Criteria andProperty64IsNull() {
            addCriterion("PROPERTY64 is null");
            return (Criteria) this;
        }

        public Criteria andProperty64IsNotNull() {
            addCriterion("PROPERTY64 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty64EqualTo(String value) {
            addCriterion("PROPERTY64 =", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64NotEqualTo(String value) {
            addCriterion("PROPERTY64 <>", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64GreaterThan(String value) {
            addCriterion("PROPERTY64 >", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY64 >=", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64LessThan(String value) {
            addCriterion("PROPERTY64 <", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY64 <=", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64Like(String value) {
            addCriterion("PROPERTY64 like", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64NotLike(String value) {
            addCriterion("PROPERTY64 not like", value, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64In(List<String> values) {
            addCriterion("PROPERTY64 in", values, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64NotIn(List<String> values) {
            addCriterion("PROPERTY64 not in", values, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64Between(String value1, String value2) {
            addCriterion("PROPERTY64 between", value1, value2, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty64NotBetween(String value1, String value2) {
            addCriterion("PROPERTY64 not between", value1, value2, "property64");
            return (Criteria) this;
        }

        public Criteria andProperty65IsNull() {
            addCriterion("PROPERTY65 is null");
            return (Criteria) this;
        }

        public Criteria andProperty65IsNotNull() {
            addCriterion("PROPERTY65 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty65EqualTo(String value) {
            addCriterion("PROPERTY65 =", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65NotEqualTo(String value) {
            addCriterion("PROPERTY65 <>", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65GreaterThan(String value) {
            addCriterion("PROPERTY65 >", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY65 >=", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65LessThan(String value) {
            addCriterion("PROPERTY65 <", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY65 <=", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65Like(String value) {
            addCriterion("PROPERTY65 like", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65NotLike(String value) {
            addCriterion("PROPERTY65 not like", value, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65In(List<String> values) {
            addCriterion("PROPERTY65 in", values, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65NotIn(List<String> values) {
            addCriterion("PROPERTY65 not in", values, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65Between(String value1, String value2) {
            addCriterion("PROPERTY65 between", value1, value2, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty65NotBetween(String value1, String value2) {
            addCriterion("PROPERTY65 not between", value1, value2, "property65");
            return (Criteria) this;
        }

        public Criteria andProperty66IsNull() {
            addCriterion("PROPERTY66 is null");
            return (Criteria) this;
        }

        public Criteria andProperty66IsNotNull() {
            addCriterion("PROPERTY66 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty66EqualTo(String value) {
            addCriterion("PROPERTY66 =", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66NotEqualTo(String value) {
            addCriterion("PROPERTY66 <>", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66GreaterThan(String value) {
            addCriterion("PROPERTY66 >", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY66 >=", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66LessThan(String value) {
            addCriterion("PROPERTY66 <", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY66 <=", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66Like(String value) {
            addCriterion("PROPERTY66 like", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66NotLike(String value) {
            addCriterion("PROPERTY66 not like", value, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66In(List<String> values) {
            addCriterion("PROPERTY66 in", values, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66NotIn(List<String> values) {
            addCriterion("PROPERTY66 not in", values, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66Between(String value1, String value2) {
            addCriterion("PROPERTY66 between", value1, value2, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty66NotBetween(String value1, String value2) {
            addCriterion("PROPERTY66 not between", value1, value2, "property66");
            return (Criteria) this;
        }

        public Criteria andProperty67IsNull() {
            addCriterion("PROPERTY67 is null");
            return (Criteria) this;
        }

        public Criteria andProperty67IsNotNull() {
            addCriterion("PROPERTY67 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty67EqualTo(String value) {
            addCriterion("PROPERTY67 =", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67NotEqualTo(String value) {
            addCriterion("PROPERTY67 <>", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67GreaterThan(String value) {
            addCriterion("PROPERTY67 >", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY67 >=", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67LessThan(String value) {
            addCriterion("PROPERTY67 <", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY67 <=", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67Like(String value) {
            addCriterion("PROPERTY67 like", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67NotLike(String value) {
            addCriterion("PROPERTY67 not like", value, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67In(List<String> values) {
            addCriterion("PROPERTY67 in", values, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67NotIn(List<String> values) {
            addCriterion("PROPERTY67 not in", values, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67Between(String value1, String value2) {
            addCriterion("PROPERTY67 between", value1, value2, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty67NotBetween(String value1, String value2) {
            addCriterion("PROPERTY67 not between", value1, value2, "property67");
            return (Criteria) this;
        }

        public Criteria andProperty68IsNull() {
            addCriterion("PROPERTY68 is null");
            return (Criteria) this;
        }

        public Criteria andProperty68IsNotNull() {
            addCriterion("PROPERTY68 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty68EqualTo(String value) {
            addCriterion("PROPERTY68 =", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68NotEqualTo(String value) {
            addCriterion("PROPERTY68 <>", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68GreaterThan(String value) {
            addCriterion("PROPERTY68 >", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY68 >=", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68LessThan(String value) {
            addCriterion("PROPERTY68 <", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY68 <=", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68Like(String value) {
            addCriterion("PROPERTY68 like", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68NotLike(String value) {
            addCriterion("PROPERTY68 not like", value, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68In(List<String> values) {
            addCriterion("PROPERTY68 in", values, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68NotIn(List<String> values) {
            addCriterion("PROPERTY68 not in", values, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68Between(String value1, String value2) {
            addCriterion("PROPERTY68 between", value1, value2, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty68NotBetween(String value1, String value2) {
            addCriterion("PROPERTY68 not between", value1, value2, "property68");
            return (Criteria) this;
        }

        public Criteria andProperty69IsNull() {
            addCriterion("PROPERTY69 is null");
            return (Criteria) this;
        }

        public Criteria andProperty69IsNotNull() {
            addCriterion("PROPERTY69 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty69EqualTo(String value) {
            addCriterion("PROPERTY69 =", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69NotEqualTo(String value) {
            addCriterion("PROPERTY69 <>", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69GreaterThan(String value) {
            addCriterion("PROPERTY69 >", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY69 >=", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69LessThan(String value) {
            addCriterion("PROPERTY69 <", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY69 <=", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69Like(String value) {
            addCriterion("PROPERTY69 like", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69NotLike(String value) {
            addCriterion("PROPERTY69 not like", value, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69In(List<String> values) {
            addCriterion("PROPERTY69 in", values, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69NotIn(List<String> values) {
            addCriterion("PROPERTY69 not in", values, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69Between(String value1, String value2) {
            addCriterion("PROPERTY69 between", value1, value2, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty69NotBetween(String value1, String value2) {
            addCriterion("PROPERTY69 not between", value1, value2, "property69");
            return (Criteria) this;
        }

        public Criteria andProperty70IsNull() {
            addCriterion("PROPERTY70 is null");
            return (Criteria) this;
        }

        public Criteria andProperty70IsNotNull() {
            addCriterion("PROPERTY70 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty70EqualTo(String value) {
            addCriterion("PROPERTY70 =", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70NotEqualTo(String value) {
            addCriterion("PROPERTY70 <>", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70GreaterThan(String value) {
            addCriterion("PROPERTY70 >", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY70 >=", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70LessThan(String value) {
            addCriterion("PROPERTY70 <", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY70 <=", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70Like(String value) {
            addCriterion("PROPERTY70 like", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70NotLike(String value) {
            addCriterion("PROPERTY70 not like", value, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70In(List<String> values) {
            addCriterion("PROPERTY70 in", values, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70NotIn(List<String> values) {
            addCriterion("PROPERTY70 not in", values, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70Between(String value1, String value2) {
            addCriterion("PROPERTY70 between", value1, value2, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty70NotBetween(String value1, String value2) {
            addCriterion("PROPERTY70 not between", value1, value2, "property70");
            return (Criteria) this;
        }

        public Criteria andProperty71IsNull() {
            addCriterion("PROPERTY71 is null");
            return (Criteria) this;
        }

        public Criteria andProperty71IsNotNull() {
            addCriterion("PROPERTY71 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty71EqualTo(String value) {
            addCriterion("PROPERTY71 =", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71NotEqualTo(String value) {
            addCriterion("PROPERTY71 <>", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71GreaterThan(String value) {
            addCriterion("PROPERTY71 >", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY71 >=", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71LessThan(String value) {
            addCriterion("PROPERTY71 <", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY71 <=", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71Like(String value) {
            addCriterion("PROPERTY71 like", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71NotLike(String value) {
            addCriterion("PROPERTY71 not like", value, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71In(List<String> values) {
            addCriterion("PROPERTY71 in", values, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71NotIn(List<String> values) {
            addCriterion("PROPERTY71 not in", values, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71Between(String value1, String value2) {
            addCriterion("PROPERTY71 between", value1, value2, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty71NotBetween(String value1, String value2) {
            addCriterion("PROPERTY71 not between", value1, value2, "property71");
            return (Criteria) this;
        }

        public Criteria andProperty72IsNull() {
            addCriterion("PROPERTY72 is null");
            return (Criteria) this;
        }

        public Criteria andProperty72IsNotNull() {
            addCriterion("PROPERTY72 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty72EqualTo(String value) {
            addCriterion("PROPERTY72 =", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72NotEqualTo(String value) {
            addCriterion("PROPERTY72 <>", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72GreaterThan(String value) {
            addCriterion("PROPERTY72 >", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY72 >=", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72LessThan(String value) {
            addCriterion("PROPERTY72 <", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY72 <=", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72Like(String value) {
            addCriterion("PROPERTY72 like", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72NotLike(String value) {
            addCriterion("PROPERTY72 not like", value, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72In(List<String> values) {
            addCriterion("PROPERTY72 in", values, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72NotIn(List<String> values) {
            addCriterion("PROPERTY72 not in", values, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72Between(String value1, String value2) {
            addCriterion("PROPERTY72 between", value1, value2, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty72NotBetween(String value1, String value2) {
            addCriterion("PROPERTY72 not between", value1, value2, "property72");
            return (Criteria) this;
        }

        public Criteria andProperty73IsNull() {
            addCriterion("PROPERTY73 is null");
            return (Criteria) this;
        }

        public Criteria andProperty73IsNotNull() {
            addCriterion("PROPERTY73 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty73EqualTo(String value) {
            addCriterion("PROPERTY73 =", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73NotEqualTo(String value) {
            addCriterion("PROPERTY73 <>", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73GreaterThan(String value) {
            addCriterion("PROPERTY73 >", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY73 >=", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73LessThan(String value) {
            addCriterion("PROPERTY73 <", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY73 <=", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73Like(String value) {
            addCriterion("PROPERTY73 like", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73NotLike(String value) {
            addCriterion("PROPERTY73 not like", value, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73In(List<String> values) {
            addCriterion("PROPERTY73 in", values, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73NotIn(List<String> values) {
            addCriterion("PROPERTY73 not in", values, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73Between(String value1, String value2) {
            addCriterion("PROPERTY73 between", value1, value2, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty73NotBetween(String value1, String value2) {
            addCriterion("PROPERTY73 not between", value1, value2, "property73");
            return (Criteria) this;
        }

        public Criteria andProperty74IsNull() {
            addCriterion("PROPERTY74 is null");
            return (Criteria) this;
        }

        public Criteria andProperty74IsNotNull() {
            addCriterion("PROPERTY74 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty74EqualTo(String value) {
            addCriterion("PROPERTY74 =", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74NotEqualTo(String value) {
            addCriterion("PROPERTY74 <>", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74GreaterThan(String value) {
            addCriterion("PROPERTY74 >", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY74 >=", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74LessThan(String value) {
            addCriterion("PROPERTY74 <", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY74 <=", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74Like(String value) {
            addCriterion("PROPERTY74 like", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74NotLike(String value) {
            addCriterion("PROPERTY74 not like", value, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74In(List<String> values) {
            addCriterion("PROPERTY74 in", values, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74NotIn(List<String> values) {
            addCriterion("PROPERTY74 not in", values, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74Between(String value1, String value2) {
            addCriterion("PROPERTY74 between", value1, value2, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty74NotBetween(String value1, String value2) {
            addCriterion("PROPERTY74 not between", value1, value2, "property74");
            return (Criteria) this;
        }

        public Criteria andProperty75IsNull() {
            addCriterion("PROPERTY75 is null");
            return (Criteria) this;
        }

        public Criteria andProperty75IsNotNull() {
            addCriterion("PROPERTY75 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty75EqualTo(String value) {
            addCriterion("PROPERTY75 =", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75NotEqualTo(String value) {
            addCriterion("PROPERTY75 <>", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75GreaterThan(String value) {
            addCriterion("PROPERTY75 >", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY75 >=", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75LessThan(String value) {
            addCriterion("PROPERTY75 <", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY75 <=", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75Like(String value) {
            addCriterion("PROPERTY75 like", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75NotLike(String value) {
            addCriterion("PROPERTY75 not like", value, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75In(List<String> values) {
            addCriterion("PROPERTY75 in", values, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75NotIn(List<String> values) {
            addCriterion("PROPERTY75 not in", values, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75Between(String value1, String value2) {
            addCriterion("PROPERTY75 between", value1, value2, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty75NotBetween(String value1, String value2) {
            addCriterion("PROPERTY75 not between", value1, value2, "property75");
            return (Criteria) this;
        }

        public Criteria andProperty76IsNull() {
            addCriterion("PROPERTY76 is null");
            return (Criteria) this;
        }

        public Criteria andProperty76IsNotNull() {
            addCriterion("PROPERTY76 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty76EqualTo(String value) {
            addCriterion("PROPERTY76 =", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76NotEqualTo(String value) {
            addCriterion("PROPERTY76 <>", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76GreaterThan(String value) {
            addCriterion("PROPERTY76 >", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY76 >=", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76LessThan(String value) {
            addCriterion("PROPERTY76 <", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY76 <=", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76Like(String value) {
            addCriterion("PROPERTY76 like", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76NotLike(String value) {
            addCriterion("PROPERTY76 not like", value, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76In(List<String> values) {
            addCriterion("PROPERTY76 in", values, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76NotIn(List<String> values) {
            addCriterion("PROPERTY76 not in", values, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76Between(String value1, String value2) {
            addCriterion("PROPERTY76 between", value1, value2, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty76NotBetween(String value1, String value2) {
            addCriterion("PROPERTY76 not between", value1, value2, "property76");
            return (Criteria) this;
        }

        public Criteria andProperty77IsNull() {
            addCriterion("PROPERTY77 is null");
            return (Criteria) this;
        }

        public Criteria andProperty77IsNotNull() {
            addCriterion("PROPERTY77 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty77EqualTo(String value) {
            addCriterion("PROPERTY77 =", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77NotEqualTo(String value) {
            addCriterion("PROPERTY77 <>", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77GreaterThan(String value) {
            addCriterion("PROPERTY77 >", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY77 >=", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77LessThan(String value) {
            addCriterion("PROPERTY77 <", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY77 <=", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77Like(String value) {
            addCriterion("PROPERTY77 like", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77NotLike(String value) {
            addCriterion("PROPERTY77 not like", value, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77In(List<String> values) {
            addCriterion("PROPERTY77 in", values, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77NotIn(List<String> values) {
            addCriterion("PROPERTY77 not in", values, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77Between(String value1, String value2) {
            addCriterion("PROPERTY77 between", value1, value2, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty77NotBetween(String value1, String value2) {
            addCriterion("PROPERTY77 not between", value1, value2, "property77");
            return (Criteria) this;
        }

        public Criteria andProperty78IsNull() {
            addCriterion("PROPERTY78 is null");
            return (Criteria) this;
        }

        public Criteria andProperty78IsNotNull() {
            addCriterion("PROPERTY78 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty78EqualTo(String value) {
            addCriterion("PROPERTY78 =", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78NotEqualTo(String value) {
            addCriterion("PROPERTY78 <>", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78GreaterThan(String value) {
            addCriterion("PROPERTY78 >", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY78 >=", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78LessThan(String value) {
            addCriterion("PROPERTY78 <", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY78 <=", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78Like(String value) {
            addCriterion("PROPERTY78 like", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78NotLike(String value) {
            addCriterion("PROPERTY78 not like", value, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78In(List<String> values) {
            addCriterion("PROPERTY78 in", values, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78NotIn(List<String> values) {
            addCriterion("PROPERTY78 not in", values, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78Between(String value1, String value2) {
            addCriterion("PROPERTY78 between", value1, value2, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty78NotBetween(String value1, String value2) {
            addCriterion("PROPERTY78 not between", value1, value2, "property78");
            return (Criteria) this;
        }

        public Criteria andProperty79IsNull() {
            addCriterion("PROPERTY79 is null");
            return (Criteria) this;
        }

        public Criteria andProperty79IsNotNull() {
            addCriterion("PROPERTY79 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty79EqualTo(String value) {
            addCriterion("PROPERTY79 =", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79NotEqualTo(String value) {
            addCriterion("PROPERTY79 <>", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79GreaterThan(String value) {
            addCriterion("PROPERTY79 >", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY79 >=", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79LessThan(String value) {
            addCriterion("PROPERTY79 <", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY79 <=", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79Like(String value) {
            addCriterion("PROPERTY79 like", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79NotLike(String value) {
            addCriterion("PROPERTY79 not like", value, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79In(List<String> values) {
            addCriterion("PROPERTY79 in", values, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79NotIn(List<String> values) {
            addCriterion("PROPERTY79 not in", values, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79Between(String value1, String value2) {
            addCriterion("PROPERTY79 between", value1, value2, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty79NotBetween(String value1, String value2) {
            addCriterion("PROPERTY79 not between", value1, value2, "property79");
            return (Criteria) this;
        }

        public Criteria andProperty80IsNull() {
            addCriterion("PROPERTY80 is null");
            return (Criteria) this;
        }

        public Criteria andProperty80IsNotNull() {
            addCriterion("PROPERTY80 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty80EqualTo(String value) {
            addCriterion("PROPERTY80 =", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80NotEqualTo(String value) {
            addCriterion("PROPERTY80 <>", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80GreaterThan(String value) {
            addCriterion("PROPERTY80 >", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY80 >=", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80LessThan(String value) {
            addCriterion("PROPERTY80 <", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY80 <=", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80Like(String value) {
            addCriterion("PROPERTY80 like", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80NotLike(String value) {
            addCriterion("PROPERTY80 not like", value, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80In(List<String> values) {
            addCriterion("PROPERTY80 in", values, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80NotIn(List<String> values) {
            addCriterion("PROPERTY80 not in", values, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80Between(String value1, String value2) {
            addCriterion("PROPERTY80 between", value1, value2, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty80NotBetween(String value1, String value2) {
            addCriterion("PROPERTY80 not between", value1, value2, "property80");
            return (Criteria) this;
        }

        public Criteria andProperty81IsNull() {
            addCriterion("PROPERTY81 is null");
            return (Criteria) this;
        }

        public Criteria andProperty81IsNotNull() {
            addCriterion("PROPERTY81 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty81EqualTo(String value) {
            addCriterion("PROPERTY81 =", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81NotEqualTo(String value) {
            addCriterion("PROPERTY81 <>", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81GreaterThan(String value) {
            addCriterion("PROPERTY81 >", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY81 >=", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81LessThan(String value) {
            addCriterion("PROPERTY81 <", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY81 <=", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81Like(String value) {
            addCriterion("PROPERTY81 like", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81NotLike(String value) {
            addCriterion("PROPERTY81 not like", value, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81In(List<String> values) {
            addCriterion("PROPERTY81 in", values, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81NotIn(List<String> values) {
            addCriterion("PROPERTY81 not in", values, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81Between(String value1, String value2) {
            addCriterion("PROPERTY81 between", value1, value2, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty81NotBetween(String value1, String value2) {
            addCriterion("PROPERTY81 not between", value1, value2, "property81");
            return (Criteria) this;
        }

        public Criteria andProperty82IsNull() {
            addCriterion("PROPERTY82 is null");
            return (Criteria) this;
        }

        public Criteria andProperty82IsNotNull() {
            addCriterion("PROPERTY82 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty82EqualTo(String value) {
            addCriterion("PROPERTY82 =", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82NotEqualTo(String value) {
            addCriterion("PROPERTY82 <>", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82GreaterThan(String value) {
            addCriterion("PROPERTY82 >", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY82 >=", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82LessThan(String value) {
            addCriterion("PROPERTY82 <", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY82 <=", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82Like(String value) {
            addCriterion("PROPERTY82 like", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82NotLike(String value) {
            addCriterion("PROPERTY82 not like", value, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82In(List<String> values) {
            addCriterion("PROPERTY82 in", values, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82NotIn(List<String> values) {
            addCriterion("PROPERTY82 not in", values, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82Between(String value1, String value2) {
            addCriterion("PROPERTY82 between", value1, value2, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty82NotBetween(String value1, String value2) {
            addCriterion("PROPERTY82 not between", value1, value2, "property82");
            return (Criteria) this;
        }

        public Criteria andProperty83IsNull() {
            addCriterion("PROPERTY83 is null");
            return (Criteria) this;
        }

        public Criteria andProperty83IsNotNull() {
            addCriterion("PROPERTY83 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty83EqualTo(String value) {
            addCriterion("PROPERTY83 =", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83NotEqualTo(String value) {
            addCriterion("PROPERTY83 <>", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83GreaterThan(String value) {
            addCriterion("PROPERTY83 >", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY83 >=", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83LessThan(String value) {
            addCriterion("PROPERTY83 <", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY83 <=", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83Like(String value) {
            addCriterion("PROPERTY83 like", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83NotLike(String value) {
            addCriterion("PROPERTY83 not like", value, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83In(List<String> values) {
            addCriterion("PROPERTY83 in", values, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83NotIn(List<String> values) {
            addCriterion("PROPERTY83 not in", values, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83Between(String value1, String value2) {
            addCriterion("PROPERTY83 between", value1, value2, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty83NotBetween(String value1, String value2) {
            addCriterion("PROPERTY83 not between", value1, value2, "property83");
            return (Criteria) this;
        }

        public Criteria andProperty84IsNull() {
            addCriterion("PROPERTY84 is null");
            return (Criteria) this;
        }

        public Criteria andProperty84IsNotNull() {
            addCriterion("PROPERTY84 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty84EqualTo(String value) {
            addCriterion("PROPERTY84 =", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84NotEqualTo(String value) {
            addCriterion("PROPERTY84 <>", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84GreaterThan(String value) {
            addCriterion("PROPERTY84 >", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY84 >=", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84LessThan(String value) {
            addCriterion("PROPERTY84 <", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY84 <=", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84Like(String value) {
            addCriterion("PROPERTY84 like", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84NotLike(String value) {
            addCriterion("PROPERTY84 not like", value, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84In(List<String> values) {
            addCriterion("PROPERTY84 in", values, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84NotIn(List<String> values) {
            addCriterion("PROPERTY84 not in", values, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84Between(String value1, String value2) {
            addCriterion("PROPERTY84 between", value1, value2, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty84NotBetween(String value1, String value2) {
            addCriterion("PROPERTY84 not between", value1, value2, "property84");
            return (Criteria) this;
        }

        public Criteria andProperty85IsNull() {
            addCriterion("PROPERTY85 is null");
            return (Criteria) this;
        }

        public Criteria andProperty85IsNotNull() {
            addCriterion("PROPERTY85 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty85EqualTo(String value) {
            addCriterion("PROPERTY85 =", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85NotEqualTo(String value) {
            addCriterion("PROPERTY85 <>", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85GreaterThan(String value) {
            addCriterion("PROPERTY85 >", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY85 >=", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85LessThan(String value) {
            addCriterion("PROPERTY85 <", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY85 <=", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85Like(String value) {
            addCriterion("PROPERTY85 like", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85NotLike(String value) {
            addCriterion("PROPERTY85 not like", value, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85In(List<String> values) {
            addCriterion("PROPERTY85 in", values, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85NotIn(List<String> values) {
            addCriterion("PROPERTY85 not in", values, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85Between(String value1, String value2) {
            addCriterion("PROPERTY85 between", value1, value2, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty85NotBetween(String value1, String value2) {
            addCriterion("PROPERTY85 not between", value1, value2, "property85");
            return (Criteria) this;
        }

        public Criteria andProperty86IsNull() {
            addCriterion("PROPERTY86 is null");
            return (Criteria) this;
        }

        public Criteria andProperty86IsNotNull() {
            addCriterion("PROPERTY86 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty86EqualTo(String value) {
            addCriterion("PROPERTY86 =", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86NotEqualTo(String value) {
            addCriterion("PROPERTY86 <>", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86GreaterThan(String value) {
            addCriterion("PROPERTY86 >", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY86 >=", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86LessThan(String value) {
            addCriterion("PROPERTY86 <", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY86 <=", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86Like(String value) {
            addCriterion("PROPERTY86 like", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86NotLike(String value) {
            addCriterion("PROPERTY86 not like", value, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86In(List<String> values) {
            addCriterion("PROPERTY86 in", values, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86NotIn(List<String> values) {
            addCriterion("PROPERTY86 not in", values, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86Between(String value1, String value2) {
            addCriterion("PROPERTY86 between", value1, value2, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty86NotBetween(String value1, String value2) {
            addCriterion("PROPERTY86 not between", value1, value2, "property86");
            return (Criteria) this;
        }

        public Criteria andProperty87IsNull() {
            addCriterion("PROPERTY87 is null");
            return (Criteria) this;
        }

        public Criteria andProperty87IsNotNull() {
            addCriterion("PROPERTY87 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty87EqualTo(String value) {
            addCriterion("PROPERTY87 =", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87NotEqualTo(String value) {
            addCriterion("PROPERTY87 <>", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87GreaterThan(String value) {
            addCriterion("PROPERTY87 >", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY87 >=", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87LessThan(String value) {
            addCriterion("PROPERTY87 <", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY87 <=", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87Like(String value) {
            addCriterion("PROPERTY87 like", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87NotLike(String value) {
            addCriterion("PROPERTY87 not like", value, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87In(List<String> values) {
            addCriterion("PROPERTY87 in", values, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87NotIn(List<String> values) {
            addCriterion("PROPERTY87 not in", values, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87Between(String value1, String value2) {
            addCriterion("PROPERTY87 between", value1, value2, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty87NotBetween(String value1, String value2) {
            addCriterion("PROPERTY87 not between", value1, value2, "property87");
            return (Criteria) this;
        }

        public Criteria andProperty88IsNull() {
            addCriterion("PROPERTY88 is null");
            return (Criteria) this;
        }

        public Criteria andProperty88IsNotNull() {
            addCriterion("PROPERTY88 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty88EqualTo(String value) {
            addCriterion("PROPERTY88 =", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88NotEqualTo(String value) {
            addCriterion("PROPERTY88 <>", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88GreaterThan(String value) {
            addCriterion("PROPERTY88 >", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY88 >=", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88LessThan(String value) {
            addCriterion("PROPERTY88 <", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY88 <=", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88Like(String value) {
            addCriterion("PROPERTY88 like", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88NotLike(String value) {
            addCriterion("PROPERTY88 not like", value, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88In(List<String> values) {
            addCriterion("PROPERTY88 in", values, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88NotIn(List<String> values) {
            addCriterion("PROPERTY88 not in", values, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88Between(String value1, String value2) {
            addCriterion("PROPERTY88 between", value1, value2, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty88NotBetween(String value1, String value2) {
            addCriterion("PROPERTY88 not between", value1, value2, "property88");
            return (Criteria) this;
        }

        public Criteria andProperty89IsNull() {
            addCriterion("PROPERTY89 is null");
            return (Criteria) this;
        }

        public Criteria andProperty89IsNotNull() {
            addCriterion("PROPERTY89 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty89EqualTo(String value) {
            addCriterion("PROPERTY89 =", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89NotEqualTo(String value) {
            addCriterion("PROPERTY89 <>", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89GreaterThan(String value) {
            addCriterion("PROPERTY89 >", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY89 >=", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89LessThan(String value) {
            addCriterion("PROPERTY89 <", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY89 <=", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89Like(String value) {
            addCriterion("PROPERTY89 like", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89NotLike(String value) {
            addCriterion("PROPERTY89 not like", value, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89In(List<String> values) {
            addCriterion("PROPERTY89 in", values, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89NotIn(List<String> values) {
            addCriterion("PROPERTY89 not in", values, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89Between(String value1, String value2) {
            addCriterion("PROPERTY89 between", value1, value2, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty89NotBetween(String value1, String value2) {
            addCriterion("PROPERTY89 not between", value1, value2, "property89");
            return (Criteria) this;
        }

        public Criteria andProperty90IsNull() {
            addCriterion("PROPERTY90 is null");
            return (Criteria) this;
        }

        public Criteria andProperty90IsNotNull() {
            addCriterion("PROPERTY90 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty90EqualTo(String value) {
            addCriterion("PROPERTY90 =", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90NotEqualTo(String value) {
            addCriterion("PROPERTY90 <>", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90GreaterThan(String value) {
            addCriterion("PROPERTY90 >", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY90 >=", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90LessThan(String value) {
            addCriterion("PROPERTY90 <", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY90 <=", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90Like(String value) {
            addCriterion("PROPERTY90 like", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90NotLike(String value) {
            addCriterion("PROPERTY90 not like", value, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90In(List<String> values) {
            addCriterion("PROPERTY90 in", values, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90NotIn(List<String> values) {
            addCriterion("PROPERTY90 not in", values, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90Between(String value1, String value2) {
            addCriterion("PROPERTY90 between", value1, value2, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty90NotBetween(String value1, String value2) {
            addCriterion("PROPERTY90 not between", value1, value2, "property90");
            return (Criteria) this;
        }

        public Criteria andProperty91IsNull() {
            addCriterion("PROPERTY91 is null");
            return (Criteria) this;
        }

        public Criteria andProperty91IsNotNull() {
            addCriterion("PROPERTY91 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty91EqualTo(String value) {
            addCriterion("PROPERTY91 =", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91NotEqualTo(String value) {
            addCriterion("PROPERTY91 <>", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91GreaterThan(String value) {
            addCriterion("PROPERTY91 >", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY91 >=", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91LessThan(String value) {
            addCriterion("PROPERTY91 <", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY91 <=", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91Like(String value) {
            addCriterion("PROPERTY91 like", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91NotLike(String value) {
            addCriterion("PROPERTY91 not like", value, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91In(List<String> values) {
            addCriterion("PROPERTY91 in", values, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91NotIn(List<String> values) {
            addCriterion("PROPERTY91 not in", values, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91Between(String value1, String value2) {
            addCriterion("PROPERTY91 between", value1, value2, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty91NotBetween(String value1, String value2) {
            addCriterion("PROPERTY91 not between", value1, value2, "property91");
            return (Criteria) this;
        }

        public Criteria andProperty92IsNull() {
            addCriterion("PROPERTY92 is null");
            return (Criteria) this;
        }

        public Criteria andProperty92IsNotNull() {
            addCriterion("PROPERTY92 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty92EqualTo(String value) {
            addCriterion("PROPERTY92 =", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92NotEqualTo(String value) {
            addCriterion("PROPERTY92 <>", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92GreaterThan(String value) {
            addCriterion("PROPERTY92 >", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY92 >=", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92LessThan(String value) {
            addCriterion("PROPERTY92 <", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY92 <=", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92Like(String value) {
            addCriterion("PROPERTY92 like", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92NotLike(String value) {
            addCriterion("PROPERTY92 not like", value, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92In(List<String> values) {
            addCriterion("PROPERTY92 in", values, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92NotIn(List<String> values) {
            addCriterion("PROPERTY92 not in", values, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92Between(String value1, String value2) {
            addCriterion("PROPERTY92 between", value1, value2, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty92NotBetween(String value1, String value2) {
            addCriterion("PROPERTY92 not between", value1, value2, "property92");
            return (Criteria) this;
        }

        public Criteria andProperty93IsNull() {
            addCriterion("PROPERTY93 is null");
            return (Criteria) this;
        }

        public Criteria andProperty93IsNotNull() {
            addCriterion("PROPERTY93 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty93EqualTo(String value) {
            addCriterion("PROPERTY93 =", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93NotEqualTo(String value) {
            addCriterion("PROPERTY93 <>", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93GreaterThan(String value) {
            addCriterion("PROPERTY93 >", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY93 >=", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93LessThan(String value) {
            addCriterion("PROPERTY93 <", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY93 <=", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93Like(String value) {
            addCriterion("PROPERTY93 like", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93NotLike(String value) {
            addCriterion("PROPERTY93 not like", value, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93In(List<String> values) {
            addCriterion("PROPERTY93 in", values, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93NotIn(List<String> values) {
            addCriterion("PROPERTY93 not in", values, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93Between(String value1, String value2) {
            addCriterion("PROPERTY93 between", value1, value2, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty93NotBetween(String value1, String value2) {
            addCriterion("PROPERTY93 not between", value1, value2, "property93");
            return (Criteria) this;
        }

        public Criteria andProperty94IsNull() {
            addCriterion("PROPERTY94 is null");
            return (Criteria) this;
        }

        public Criteria andProperty94IsNotNull() {
            addCriterion("PROPERTY94 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty94EqualTo(String value) {
            addCriterion("PROPERTY94 =", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94NotEqualTo(String value) {
            addCriterion("PROPERTY94 <>", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94GreaterThan(String value) {
            addCriterion("PROPERTY94 >", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY94 >=", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94LessThan(String value) {
            addCriterion("PROPERTY94 <", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY94 <=", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94Like(String value) {
            addCriterion("PROPERTY94 like", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94NotLike(String value) {
            addCriterion("PROPERTY94 not like", value, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94In(List<String> values) {
            addCriterion("PROPERTY94 in", values, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94NotIn(List<String> values) {
            addCriterion("PROPERTY94 not in", values, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94Between(String value1, String value2) {
            addCriterion("PROPERTY94 between", value1, value2, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty94NotBetween(String value1, String value2) {
            addCriterion("PROPERTY94 not between", value1, value2, "property94");
            return (Criteria) this;
        }

        public Criteria andProperty95IsNull() {
            addCriterion("PROPERTY95 is null");
            return (Criteria) this;
        }

        public Criteria andProperty95IsNotNull() {
            addCriterion("PROPERTY95 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty95EqualTo(String value) {
            addCriterion("PROPERTY95 =", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95NotEqualTo(String value) {
            addCriterion("PROPERTY95 <>", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95GreaterThan(String value) {
            addCriterion("PROPERTY95 >", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY95 >=", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95LessThan(String value) {
            addCriterion("PROPERTY95 <", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY95 <=", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95Like(String value) {
            addCriterion("PROPERTY95 like", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95NotLike(String value) {
            addCriterion("PROPERTY95 not like", value, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95In(List<String> values) {
            addCriterion("PROPERTY95 in", values, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95NotIn(List<String> values) {
            addCriterion("PROPERTY95 not in", values, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95Between(String value1, String value2) {
            addCriterion("PROPERTY95 between", value1, value2, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty95NotBetween(String value1, String value2) {
            addCriterion("PROPERTY95 not between", value1, value2, "property95");
            return (Criteria) this;
        }

        public Criteria andProperty96IsNull() {
            addCriterion("PROPERTY96 is null");
            return (Criteria) this;
        }

        public Criteria andProperty96IsNotNull() {
            addCriterion("PROPERTY96 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty96EqualTo(String value) {
            addCriterion("PROPERTY96 =", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96NotEqualTo(String value) {
            addCriterion("PROPERTY96 <>", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96GreaterThan(String value) {
            addCriterion("PROPERTY96 >", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY96 >=", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96LessThan(String value) {
            addCriterion("PROPERTY96 <", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY96 <=", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96Like(String value) {
            addCriterion("PROPERTY96 like", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96NotLike(String value) {
            addCriterion("PROPERTY96 not like", value, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96In(List<String> values) {
            addCriterion("PROPERTY96 in", values, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96NotIn(List<String> values) {
            addCriterion("PROPERTY96 not in", values, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96Between(String value1, String value2) {
            addCriterion("PROPERTY96 between", value1, value2, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty96NotBetween(String value1, String value2) {
            addCriterion("PROPERTY96 not between", value1, value2, "property96");
            return (Criteria) this;
        }

        public Criteria andProperty97IsNull() {
            addCriterion("PROPERTY97 is null");
            return (Criteria) this;
        }

        public Criteria andProperty97IsNotNull() {
            addCriterion("PROPERTY97 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty97EqualTo(String value) {
            addCriterion("PROPERTY97 =", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97NotEqualTo(String value) {
            addCriterion("PROPERTY97 <>", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97GreaterThan(String value) {
            addCriterion("PROPERTY97 >", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY97 >=", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97LessThan(String value) {
            addCriterion("PROPERTY97 <", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY97 <=", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97Like(String value) {
            addCriterion("PROPERTY97 like", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97NotLike(String value) {
            addCriterion("PROPERTY97 not like", value, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97In(List<String> values) {
            addCriterion("PROPERTY97 in", values, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97NotIn(List<String> values) {
            addCriterion("PROPERTY97 not in", values, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97Between(String value1, String value2) {
            addCriterion("PROPERTY97 between", value1, value2, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty97NotBetween(String value1, String value2) {
            addCriterion("PROPERTY97 not between", value1, value2, "property97");
            return (Criteria) this;
        }

        public Criteria andProperty98IsNull() {
            addCriterion("PROPERTY98 is null");
            return (Criteria) this;
        }

        public Criteria andProperty98IsNotNull() {
            addCriterion("PROPERTY98 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty98EqualTo(String value) {
            addCriterion("PROPERTY98 =", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98NotEqualTo(String value) {
            addCriterion("PROPERTY98 <>", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98GreaterThan(String value) {
            addCriterion("PROPERTY98 >", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY98 >=", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98LessThan(String value) {
            addCriterion("PROPERTY98 <", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY98 <=", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98Like(String value) {
            addCriterion("PROPERTY98 like", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98NotLike(String value) {
            addCriterion("PROPERTY98 not like", value, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98In(List<String> values) {
            addCriterion("PROPERTY98 in", values, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98NotIn(List<String> values) {
            addCriterion("PROPERTY98 not in", values, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98Between(String value1, String value2) {
            addCriterion("PROPERTY98 between", value1, value2, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty98NotBetween(String value1, String value2) {
            addCriterion("PROPERTY98 not between", value1, value2, "property98");
            return (Criteria) this;
        }

        public Criteria andProperty99IsNull() {
            addCriterion("PROPERTY99 is null");
            return (Criteria) this;
        }

        public Criteria andProperty99IsNotNull() {
            addCriterion("PROPERTY99 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty99EqualTo(String value) {
            addCriterion("PROPERTY99 =", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99NotEqualTo(String value) {
            addCriterion("PROPERTY99 <>", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99GreaterThan(String value) {
            addCriterion("PROPERTY99 >", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99GreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTY99 >=", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99LessThan(String value) {
            addCriterion("PROPERTY99 <", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99LessThanOrEqualTo(String value) {
            addCriterion("PROPERTY99 <=", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99Like(String value) {
            addCriterion("PROPERTY99 like", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99NotLike(String value) {
            addCriterion("PROPERTY99 not like", value, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99In(List<String> values) {
            addCriterion("PROPERTY99 in", values, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99NotIn(List<String> values) {
            addCriterion("PROPERTY99 not in", values, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99Between(String value1, String value2) {
            addCriterion("PROPERTY99 between", value1, value2, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty99NotBetween(String value1, String value2) {
            addCriterion("PROPERTY99 not between", value1, value2, "property99");
            return (Criteria) this;
        }

        public Criteria andProperty100IsNull() {
            addCriterion("PROPERTY100 is null");
            return (Criteria) this;
        }

        public Criteria andProperty100IsNotNull() {
            addCriterion("PROPERTY100 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty100EqualTo(BigDecimal value) {
            addCriterion("PROPERTY100 =", value, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY100 <>", value, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY100 >", value, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY100 >=", value, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100LessThan(BigDecimal value) {
            addCriterion("PROPERTY100 <", value, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY100 <=", value, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100In(List<BigDecimal> values) {
            addCriterion("PROPERTY100 in", values, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY100 not in", values, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY100 between", value1, value2, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty100NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY100 not between", value1, value2, "property100");
            return (Criteria) this;
        }

        public Criteria andProperty101IsNull() {
            addCriterion("PROPERTY101 is null");
            return (Criteria) this;
        }

        public Criteria andProperty101IsNotNull() {
            addCriterion("PROPERTY101 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty101EqualTo(BigDecimal value) {
            addCriterion("PROPERTY101 =", value, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY101 <>", value, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY101 >", value, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY101 >=", value, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101LessThan(BigDecimal value) {
            addCriterion("PROPERTY101 <", value, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY101 <=", value, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101In(List<BigDecimal> values) {
            addCriterion("PROPERTY101 in", values, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY101 not in", values, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY101 between", value1, value2, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty101NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY101 not between", value1, value2, "property101");
            return (Criteria) this;
        }

        public Criteria andProperty102IsNull() {
            addCriterion("PROPERTY102 is null");
            return (Criteria) this;
        }

        public Criteria andProperty102IsNotNull() {
            addCriterion("PROPERTY102 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty102EqualTo(BigDecimal value) {
            addCriterion("PROPERTY102 =", value, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY102 <>", value, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY102 >", value, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY102 >=", value, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102LessThan(BigDecimal value) {
            addCriterion("PROPERTY102 <", value, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY102 <=", value, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102In(List<BigDecimal> values) {
            addCriterion("PROPERTY102 in", values, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY102 not in", values, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY102 between", value1, value2, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty102NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY102 not between", value1, value2, "property102");
            return (Criteria) this;
        }

        public Criteria andProperty103IsNull() {
            addCriterion("PROPERTY103 is null");
            return (Criteria) this;
        }

        public Criteria andProperty103IsNotNull() {
            addCriterion("PROPERTY103 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty103EqualTo(BigDecimal value) {
            addCriterion("PROPERTY103 =", value, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY103 <>", value, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY103 >", value, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY103 >=", value, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103LessThan(BigDecimal value) {
            addCriterion("PROPERTY103 <", value, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY103 <=", value, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103In(List<BigDecimal> values) {
            addCriterion("PROPERTY103 in", values, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY103 not in", values, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY103 between", value1, value2, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty103NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY103 not between", value1, value2, "property103");
            return (Criteria) this;
        }

        public Criteria andProperty104IsNull() {
            addCriterion("PROPERTY104 is null");
            return (Criteria) this;
        }

        public Criteria andProperty104IsNotNull() {
            addCriterion("PROPERTY104 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty104EqualTo(BigDecimal value) {
            addCriterion("PROPERTY104 =", value, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY104 <>", value, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY104 >", value, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY104 >=", value, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104LessThan(BigDecimal value) {
            addCriterion("PROPERTY104 <", value, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY104 <=", value, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104In(List<BigDecimal> values) {
            addCriterion("PROPERTY104 in", values, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY104 not in", values, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY104 between", value1, value2, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty104NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY104 not between", value1, value2, "property104");
            return (Criteria) this;
        }

        public Criteria andProperty105IsNull() {
            addCriterion("PROPERTY105 is null");
            return (Criteria) this;
        }

        public Criteria andProperty105IsNotNull() {
            addCriterion("PROPERTY105 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty105EqualTo(BigDecimal value) {
            addCriterion("PROPERTY105 =", value, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY105 <>", value, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY105 >", value, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY105 >=", value, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105LessThan(BigDecimal value) {
            addCriterion("PROPERTY105 <", value, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY105 <=", value, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105In(List<BigDecimal> values) {
            addCriterion("PROPERTY105 in", values, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY105 not in", values, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY105 between", value1, value2, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty105NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY105 not between", value1, value2, "property105");
            return (Criteria) this;
        }

        public Criteria andProperty106IsNull() {
            addCriterion("PROPERTY106 is null");
            return (Criteria) this;
        }

        public Criteria andProperty106IsNotNull() {
            addCriterion("PROPERTY106 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty106EqualTo(BigDecimal value) {
            addCriterion("PROPERTY106 =", value, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY106 <>", value, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY106 >", value, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY106 >=", value, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106LessThan(BigDecimal value) {
            addCriterion("PROPERTY106 <", value, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY106 <=", value, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106In(List<BigDecimal> values) {
            addCriterion("PROPERTY106 in", values, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY106 not in", values, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY106 between", value1, value2, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty106NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY106 not between", value1, value2, "property106");
            return (Criteria) this;
        }

        public Criteria andProperty107IsNull() {
            addCriterion("PROPERTY107 is null");
            return (Criteria) this;
        }

        public Criteria andProperty107IsNotNull() {
            addCriterion("PROPERTY107 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty107EqualTo(BigDecimal value) {
            addCriterion("PROPERTY107 =", value, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY107 <>", value, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY107 >", value, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY107 >=", value, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107LessThan(BigDecimal value) {
            addCriterion("PROPERTY107 <", value, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY107 <=", value, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107In(List<BigDecimal> values) {
            addCriterion("PROPERTY107 in", values, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY107 not in", values, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY107 between", value1, value2, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty107NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY107 not between", value1, value2, "property107");
            return (Criteria) this;
        }

        public Criteria andProperty108IsNull() {
            addCriterion("PROPERTY108 is null");
            return (Criteria) this;
        }

        public Criteria andProperty108IsNotNull() {
            addCriterion("PROPERTY108 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty108EqualTo(BigDecimal value) {
            addCriterion("PROPERTY108 =", value, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY108 <>", value, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY108 >", value, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY108 >=", value, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108LessThan(BigDecimal value) {
            addCriterion("PROPERTY108 <", value, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY108 <=", value, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108In(List<BigDecimal> values) {
            addCriterion("PROPERTY108 in", values, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY108 not in", values, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY108 between", value1, value2, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty108NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY108 not between", value1, value2, "property108");
            return (Criteria) this;
        }

        public Criteria andProperty109IsNull() {
            addCriterion("PROPERTY109 is null");
            return (Criteria) this;
        }

        public Criteria andProperty109IsNotNull() {
            addCriterion("PROPERTY109 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty109EqualTo(BigDecimal value) {
            addCriterion("PROPERTY109 =", value, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY109 <>", value, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY109 >", value, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY109 >=", value, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109LessThan(BigDecimal value) {
            addCriterion("PROPERTY109 <", value, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY109 <=", value, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109In(List<BigDecimal> values) {
            addCriterion("PROPERTY109 in", values, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY109 not in", values, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY109 between", value1, value2, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty109NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY109 not between", value1, value2, "property109");
            return (Criteria) this;
        }

        public Criteria andProperty110IsNull() {
            addCriterion("PROPERTY110 is null");
            return (Criteria) this;
        }

        public Criteria andProperty110IsNotNull() {
            addCriterion("PROPERTY110 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty110EqualTo(BigDecimal value) {
            addCriterion("PROPERTY110 =", value, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY110 <>", value, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY110 >", value, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY110 >=", value, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110LessThan(BigDecimal value) {
            addCriterion("PROPERTY110 <", value, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY110 <=", value, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110In(List<BigDecimal> values) {
            addCriterion("PROPERTY110 in", values, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY110 not in", values, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY110 between", value1, value2, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty110NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY110 not between", value1, value2, "property110");
            return (Criteria) this;
        }

        public Criteria andProperty111IsNull() {
            addCriterion("PROPERTY111 is null");
            return (Criteria) this;
        }

        public Criteria andProperty111IsNotNull() {
            addCriterion("PROPERTY111 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty111EqualTo(BigDecimal value) {
            addCriterion("PROPERTY111 =", value, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY111 <>", value, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY111 >", value, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY111 >=", value, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111LessThan(BigDecimal value) {
            addCriterion("PROPERTY111 <", value, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY111 <=", value, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111In(List<BigDecimal> values) {
            addCriterion("PROPERTY111 in", values, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY111 not in", values, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY111 between", value1, value2, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty111NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY111 not between", value1, value2, "property111");
            return (Criteria) this;
        }

        public Criteria andProperty112IsNull() {
            addCriterion("PROPERTY112 is null");
            return (Criteria) this;
        }

        public Criteria andProperty112IsNotNull() {
            addCriterion("PROPERTY112 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty112EqualTo(BigDecimal value) {
            addCriterion("PROPERTY112 =", value, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY112 <>", value, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY112 >", value, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY112 >=", value, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112LessThan(BigDecimal value) {
            addCriterion("PROPERTY112 <", value, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY112 <=", value, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112In(List<BigDecimal> values) {
            addCriterion("PROPERTY112 in", values, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY112 not in", values, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY112 between", value1, value2, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty112NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY112 not between", value1, value2, "property112");
            return (Criteria) this;
        }

        public Criteria andProperty113IsNull() {
            addCriterion("PROPERTY113 is null");
            return (Criteria) this;
        }

        public Criteria andProperty113IsNotNull() {
            addCriterion("PROPERTY113 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty113EqualTo(BigDecimal value) {
            addCriterion("PROPERTY113 =", value, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY113 <>", value, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY113 >", value, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY113 >=", value, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113LessThan(BigDecimal value) {
            addCriterion("PROPERTY113 <", value, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY113 <=", value, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113In(List<BigDecimal> values) {
            addCriterion("PROPERTY113 in", values, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY113 not in", values, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY113 between", value1, value2, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty113NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY113 not between", value1, value2, "property113");
            return (Criteria) this;
        }

        public Criteria andProperty114IsNull() {
            addCriterion("PROPERTY114 is null");
            return (Criteria) this;
        }

        public Criteria andProperty114IsNotNull() {
            addCriterion("PROPERTY114 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty114EqualTo(BigDecimal value) {
            addCriterion("PROPERTY114 =", value, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY114 <>", value, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY114 >", value, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY114 >=", value, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114LessThan(BigDecimal value) {
            addCriterion("PROPERTY114 <", value, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY114 <=", value, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114In(List<BigDecimal> values) {
            addCriterion("PROPERTY114 in", values, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY114 not in", values, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY114 between", value1, value2, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty114NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY114 not between", value1, value2, "property114");
            return (Criteria) this;
        }

        public Criteria andProperty115IsNull() {
            addCriterion("PROPERTY115 is null");
            return (Criteria) this;
        }

        public Criteria andProperty115IsNotNull() {
            addCriterion("PROPERTY115 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty115EqualTo(BigDecimal value) {
            addCriterion("PROPERTY115 =", value, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY115 <>", value, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY115 >", value, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY115 >=", value, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115LessThan(BigDecimal value) {
            addCriterion("PROPERTY115 <", value, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY115 <=", value, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115In(List<BigDecimal> values) {
            addCriterion("PROPERTY115 in", values, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY115 not in", values, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY115 between", value1, value2, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty115NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY115 not between", value1, value2, "property115");
            return (Criteria) this;
        }

        public Criteria andProperty116IsNull() {
            addCriterion("PROPERTY116 is null");
            return (Criteria) this;
        }

        public Criteria andProperty116IsNotNull() {
            addCriterion("PROPERTY116 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty116EqualTo(BigDecimal value) {
            addCriterion("PROPERTY116 =", value, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY116 <>", value, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY116 >", value, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY116 >=", value, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116LessThan(BigDecimal value) {
            addCriterion("PROPERTY116 <", value, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY116 <=", value, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116In(List<BigDecimal> values) {
            addCriterion("PROPERTY116 in", values, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY116 not in", values, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY116 between", value1, value2, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty116NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY116 not between", value1, value2, "property116");
            return (Criteria) this;
        }

        public Criteria andProperty117IsNull() {
            addCriterion("PROPERTY117 is null");
            return (Criteria) this;
        }

        public Criteria andProperty117IsNotNull() {
            addCriterion("PROPERTY117 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty117EqualTo(BigDecimal value) {
            addCriterion("PROPERTY117 =", value, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY117 <>", value, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY117 >", value, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY117 >=", value, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117LessThan(BigDecimal value) {
            addCriterion("PROPERTY117 <", value, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY117 <=", value, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117In(List<BigDecimal> values) {
            addCriterion("PROPERTY117 in", values, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY117 not in", values, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY117 between", value1, value2, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty117NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY117 not between", value1, value2, "property117");
            return (Criteria) this;
        }

        public Criteria andProperty118IsNull() {
            addCriterion("PROPERTY118 is null");
            return (Criteria) this;
        }

        public Criteria andProperty118IsNotNull() {
            addCriterion("PROPERTY118 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty118EqualTo(BigDecimal value) {
            addCriterion("PROPERTY118 =", value, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY118 <>", value, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY118 >", value, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY118 >=", value, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118LessThan(BigDecimal value) {
            addCriterion("PROPERTY118 <", value, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY118 <=", value, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118In(List<BigDecimal> values) {
            addCriterion("PROPERTY118 in", values, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY118 not in", values, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY118 between", value1, value2, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty118NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY118 not between", value1, value2, "property118");
            return (Criteria) this;
        }

        public Criteria andProperty119IsNull() {
            addCriterion("PROPERTY119 is null");
            return (Criteria) this;
        }

        public Criteria andProperty119IsNotNull() {
            addCriterion("PROPERTY119 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty119EqualTo(BigDecimal value) {
            addCriterion("PROPERTY119 =", value, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY119 <>", value, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY119 >", value, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY119 >=", value, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119LessThan(BigDecimal value) {
            addCriterion("PROPERTY119 <", value, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY119 <=", value, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119In(List<BigDecimal> values) {
            addCriterion("PROPERTY119 in", values, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY119 not in", values, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY119 between", value1, value2, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty119NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY119 not between", value1, value2, "property119");
            return (Criteria) this;
        }

        public Criteria andProperty120IsNull() {
            addCriterion("PROPERTY120 is null");
            return (Criteria) this;
        }

        public Criteria andProperty120IsNotNull() {
            addCriterion("PROPERTY120 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty120EqualTo(BigDecimal value) {
            addCriterion("PROPERTY120 =", value, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY120 <>", value, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY120 >", value, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY120 >=", value, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120LessThan(BigDecimal value) {
            addCriterion("PROPERTY120 <", value, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY120 <=", value, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120In(List<BigDecimal> values) {
            addCriterion("PROPERTY120 in", values, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY120 not in", values, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY120 between", value1, value2, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty120NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY120 not between", value1, value2, "property120");
            return (Criteria) this;
        }

        public Criteria andProperty121IsNull() {
            addCriterion("PROPERTY121 is null");
            return (Criteria) this;
        }

        public Criteria andProperty121IsNotNull() {
            addCriterion("PROPERTY121 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty121EqualTo(BigDecimal value) {
            addCriterion("PROPERTY121 =", value, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY121 <>", value, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY121 >", value, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY121 >=", value, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121LessThan(BigDecimal value) {
            addCriterion("PROPERTY121 <", value, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY121 <=", value, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121In(List<BigDecimal> values) {
            addCriterion("PROPERTY121 in", values, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY121 not in", values, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY121 between", value1, value2, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty121NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY121 not between", value1, value2, "property121");
            return (Criteria) this;
        }

        public Criteria andProperty122IsNull() {
            addCriterion("PROPERTY122 is null");
            return (Criteria) this;
        }

        public Criteria andProperty122IsNotNull() {
            addCriterion("PROPERTY122 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty122EqualTo(BigDecimal value) {
            addCriterion("PROPERTY122 =", value, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY122 <>", value, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY122 >", value, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY122 >=", value, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122LessThan(BigDecimal value) {
            addCriterion("PROPERTY122 <", value, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY122 <=", value, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122In(List<BigDecimal> values) {
            addCriterion("PROPERTY122 in", values, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY122 not in", values, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY122 between", value1, value2, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty122NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY122 not between", value1, value2, "property122");
            return (Criteria) this;
        }

        public Criteria andProperty123IsNull() {
            addCriterion("PROPERTY123 is null");
            return (Criteria) this;
        }

        public Criteria andProperty123IsNotNull() {
            addCriterion("PROPERTY123 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty123EqualTo(BigDecimal value) {
            addCriterion("PROPERTY123 =", value, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY123 <>", value, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY123 >", value, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY123 >=", value, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123LessThan(BigDecimal value) {
            addCriterion("PROPERTY123 <", value, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY123 <=", value, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123In(List<BigDecimal> values) {
            addCriterion("PROPERTY123 in", values, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY123 not in", values, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY123 between", value1, value2, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty123NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY123 not between", value1, value2, "property123");
            return (Criteria) this;
        }

        public Criteria andProperty124IsNull() {
            addCriterion("PROPERTY124 is null");
            return (Criteria) this;
        }

        public Criteria andProperty124IsNotNull() {
            addCriterion("PROPERTY124 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty124EqualTo(BigDecimal value) {
            addCriterion("PROPERTY124 =", value, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY124 <>", value, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY124 >", value, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY124 >=", value, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124LessThan(BigDecimal value) {
            addCriterion("PROPERTY124 <", value, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY124 <=", value, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124In(List<BigDecimal> values) {
            addCriterion("PROPERTY124 in", values, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY124 not in", values, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY124 between", value1, value2, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty124NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY124 not between", value1, value2, "property124");
            return (Criteria) this;
        }

        public Criteria andProperty125IsNull() {
            addCriterion("PROPERTY125 is null");
            return (Criteria) this;
        }

        public Criteria andProperty125IsNotNull() {
            addCriterion("PROPERTY125 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty125EqualTo(BigDecimal value) {
            addCriterion("PROPERTY125 =", value, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY125 <>", value, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY125 >", value, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY125 >=", value, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125LessThan(BigDecimal value) {
            addCriterion("PROPERTY125 <", value, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY125 <=", value, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125In(List<BigDecimal> values) {
            addCriterion("PROPERTY125 in", values, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY125 not in", values, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY125 between", value1, value2, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty125NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY125 not between", value1, value2, "property125");
            return (Criteria) this;
        }

        public Criteria andProperty126IsNull() {
            addCriterion("PROPERTY126 is null");
            return (Criteria) this;
        }

        public Criteria andProperty126IsNotNull() {
            addCriterion("PROPERTY126 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty126EqualTo(BigDecimal value) {
            addCriterion("PROPERTY126 =", value, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY126 <>", value, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY126 >", value, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY126 >=", value, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126LessThan(BigDecimal value) {
            addCriterion("PROPERTY126 <", value, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY126 <=", value, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126In(List<BigDecimal> values) {
            addCriterion("PROPERTY126 in", values, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY126 not in", values, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY126 between", value1, value2, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty126NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY126 not between", value1, value2, "property126");
            return (Criteria) this;
        }

        public Criteria andProperty127IsNull() {
            addCriterion("PROPERTY127 is null");
            return (Criteria) this;
        }

        public Criteria andProperty127IsNotNull() {
            addCriterion("PROPERTY127 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty127EqualTo(BigDecimal value) {
            addCriterion("PROPERTY127 =", value, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY127 <>", value, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY127 >", value, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY127 >=", value, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127LessThan(BigDecimal value) {
            addCriterion("PROPERTY127 <", value, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY127 <=", value, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127In(List<BigDecimal> values) {
            addCriterion("PROPERTY127 in", values, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY127 not in", values, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY127 between", value1, value2, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty127NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY127 not between", value1, value2, "property127");
            return (Criteria) this;
        }

        public Criteria andProperty128IsNull() {
            addCriterion("PROPERTY128 is null");
            return (Criteria) this;
        }

        public Criteria andProperty128IsNotNull() {
            addCriterion("PROPERTY128 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty128EqualTo(BigDecimal value) {
            addCriterion("PROPERTY128 =", value, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY128 <>", value, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY128 >", value, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY128 >=", value, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128LessThan(BigDecimal value) {
            addCriterion("PROPERTY128 <", value, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY128 <=", value, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128In(List<BigDecimal> values) {
            addCriterion("PROPERTY128 in", values, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY128 not in", values, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY128 between", value1, value2, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty128NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY128 not between", value1, value2, "property128");
            return (Criteria) this;
        }

        public Criteria andProperty129IsNull() {
            addCriterion("PROPERTY129 is null");
            return (Criteria) this;
        }

        public Criteria andProperty129IsNotNull() {
            addCriterion("PROPERTY129 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty129EqualTo(BigDecimal value) {
            addCriterion("PROPERTY129 =", value, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY129 <>", value, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY129 >", value, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY129 >=", value, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129LessThan(BigDecimal value) {
            addCriterion("PROPERTY129 <", value, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY129 <=", value, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129In(List<BigDecimal> values) {
            addCriterion("PROPERTY129 in", values, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY129 not in", values, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY129 between", value1, value2, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty129NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY129 not between", value1, value2, "property129");
            return (Criteria) this;
        }

        public Criteria andProperty130IsNull() {
            addCriterion("PROPERTY130 is null");
            return (Criteria) this;
        }

        public Criteria andProperty130IsNotNull() {
            addCriterion("PROPERTY130 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty130EqualTo(BigDecimal value) {
            addCriterion("PROPERTY130 =", value, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY130 <>", value, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY130 >", value, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY130 >=", value, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130LessThan(BigDecimal value) {
            addCriterion("PROPERTY130 <", value, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY130 <=", value, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130In(List<BigDecimal> values) {
            addCriterion("PROPERTY130 in", values, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY130 not in", values, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY130 between", value1, value2, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty130NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY130 not between", value1, value2, "property130");
            return (Criteria) this;
        }

        public Criteria andProperty131IsNull() {
            addCriterion("PROPERTY131 is null");
            return (Criteria) this;
        }

        public Criteria andProperty131IsNotNull() {
            addCriterion("PROPERTY131 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty131EqualTo(BigDecimal value) {
            addCriterion("PROPERTY131 =", value, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY131 <>", value, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY131 >", value, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY131 >=", value, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131LessThan(BigDecimal value) {
            addCriterion("PROPERTY131 <", value, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY131 <=", value, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131In(List<BigDecimal> values) {
            addCriterion("PROPERTY131 in", values, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY131 not in", values, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY131 between", value1, value2, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty131NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY131 not between", value1, value2, "property131");
            return (Criteria) this;
        }

        public Criteria andProperty132IsNull() {
            addCriterion("PROPERTY132 is null");
            return (Criteria) this;
        }

        public Criteria andProperty132IsNotNull() {
            addCriterion("PROPERTY132 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty132EqualTo(BigDecimal value) {
            addCriterion("PROPERTY132 =", value, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY132 <>", value, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY132 >", value, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY132 >=", value, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132LessThan(BigDecimal value) {
            addCriterion("PROPERTY132 <", value, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY132 <=", value, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132In(List<BigDecimal> values) {
            addCriterion("PROPERTY132 in", values, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY132 not in", values, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY132 between", value1, value2, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty132NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY132 not between", value1, value2, "property132");
            return (Criteria) this;
        }

        public Criteria andProperty133IsNull() {
            addCriterion("PROPERTY133 is null");
            return (Criteria) this;
        }

        public Criteria andProperty133IsNotNull() {
            addCriterion("PROPERTY133 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty133EqualTo(BigDecimal value) {
            addCriterion("PROPERTY133 =", value, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY133 <>", value, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY133 >", value, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY133 >=", value, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133LessThan(BigDecimal value) {
            addCriterion("PROPERTY133 <", value, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY133 <=", value, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133In(List<BigDecimal> values) {
            addCriterion("PROPERTY133 in", values, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY133 not in", values, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY133 between", value1, value2, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty133NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY133 not between", value1, value2, "property133");
            return (Criteria) this;
        }

        public Criteria andProperty134IsNull() {
            addCriterion("PROPERTY134 is null");
            return (Criteria) this;
        }

        public Criteria andProperty134IsNotNull() {
            addCriterion("PROPERTY134 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty134EqualTo(BigDecimal value) {
            addCriterion("PROPERTY134 =", value, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY134 <>", value, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY134 >", value, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY134 >=", value, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134LessThan(BigDecimal value) {
            addCriterion("PROPERTY134 <", value, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY134 <=", value, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134In(List<BigDecimal> values) {
            addCriterion("PROPERTY134 in", values, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY134 not in", values, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY134 between", value1, value2, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty134NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY134 not between", value1, value2, "property134");
            return (Criteria) this;
        }

        public Criteria andProperty135IsNull() {
            addCriterion("PROPERTY135 is null");
            return (Criteria) this;
        }

        public Criteria andProperty135IsNotNull() {
            addCriterion("PROPERTY135 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty135EqualTo(BigDecimal value) {
            addCriterion("PROPERTY135 =", value, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY135 <>", value, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY135 >", value, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY135 >=", value, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135LessThan(BigDecimal value) {
            addCriterion("PROPERTY135 <", value, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY135 <=", value, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135In(List<BigDecimal> values) {
            addCriterion("PROPERTY135 in", values, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY135 not in", values, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY135 between", value1, value2, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty135NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY135 not between", value1, value2, "property135");
            return (Criteria) this;
        }

        public Criteria andProperty136IsNull() {
            addCriterion("PROPERTY136 is null");
            return (Criteria) this;
        }

        public Criteria andProperty136IsNotNull() {
            addCriterion("PROPERTY136 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty136EqualTo(BigDecimal value) {
            addCriterion("PROPERTY136 =", value, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY136 <>", value, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY136 >", value, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY136 >=", value, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136LessThan(BigDecimal value) {
            addCriterion("PROPERTY136 <", value, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY136 <=", value, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136In(List<BigDecimal> values) {
            addCriterion("PROPERTY136 in", values, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY136 not in", values, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY136 between", value1, value2, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty136NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY136 not between", value1, value2, "property136");
            return (Criteria) this;
        }

        public Criteria andProperty137IsNull() {
            addCriterion("PROPERTY137 is null");
            return (Criteria) this;
        }

        public Criteria andProperty137IsNotNull() {
            addCriterion("PROPERTY137 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty137EqualTo(BigDecimal value) {
            addCriterion("PROPERTY137 =", value, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY137 <>", value, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY137 >", value, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY137 >=", value, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137LessThan(BigDecimal value) {
            addCriterion("PROPERTY137 <", value, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY137 <=", value, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137In(List<BigDecimal> values) {
            addCriterion("PROPERTY137 in", values, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY137 not in", values, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY137 between", value1, value2, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty137NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY137 not between", value1, value2, "property137");
            return (Criteria) this;
        }

        public Criteria andProperty138IsNull() {
            addCriterion("PROPERTY138 is null");
            return (Criteria) this;
        }

        public Criteria andProperty138IsNotNull() {
            addCriterion("PROPERTY138 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty138EqualTo(BigDecimal value) {
            addCriterion("PROPERTY138 =", value, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY138 <>", value, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY138 >", value, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY138 >=", value, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138LessThan(BigDecimal value) {
            addCriterion("PROPERTY138 <", value, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY138 <=", value, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138In(List<BigDecimal> values) {
            addCriterion("PROPERTY138 in", values, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY138 not in", values, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY138 between", value1, value2, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty138NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY138 not between", value1, value2, "property138");
            return (Criteria) this;
        }

        public Criteria andProperty139IsNull() {
            addCriterion("PROPERTY139 is null");
            return (Criteria) this;
        }

        public Criteria andProperty139IsNotNull() {
            addCriterion("PROPERTY139 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty139EqualTo(BigDecimal value) {
            addCriterion("PROPERTY139 =", value, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY139 <>", value, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY139 >", value, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY139 >=", value, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139LessThan(BigDecimal value) {
            addCriterion("PROPERTY139 <", value, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY139 <=", value, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139In(List<BigDecimal> values) {
            addCriterion("PROPERTY139 in", values, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY139 not in", values, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY139 between", value1, value2, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty139NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY139 not between", value1, value2, "property139");
            return (Criteria) this;
        }

        public Criteria andProperty140IsNull() {
            addCriterion("PROPERTY140 is null");
            return (Criteria) this;
        }

        public Criteria andProperty140IsNotNull() {
            addCriterion("PROPERTY140 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty140EqualTo(BigDecimal value) {
            addCriterion("PROPERTY140 =", value, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY140 <>", value, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY140 >", value, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY140 >=", value, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140LessThan(BigDecimal value) {
            addCriterion("PROPERTY140 <", value, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY140 <=", value, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140In(List<BigDecimal> values) {
            addCriterion("PROPERTY140 in", values, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY140 not in", values, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY140 between", value1, value2, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty140NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY140 not between", value1, value2, "property140");
            return (Criteria) this;
        }

        public Criteria andProperty141IsNull() {
            addCriterion("PROPERTY141 is null");
            return (Criteria) this;
        }

        public Criteria andProperty141IsNotNull() {
            addCriterion("PROPERTY141 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty141EqualTo(BigDecimal value) {
            addCriterion("PROPERTY141 =", value, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY141 <>", value, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY141 >", value, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY141 >=", value, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141LessThan(BigDecimal value) {
            addCriterion("PROPERTY141 <", value, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY141 <=", value, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141In(List<BigDecimal> values) {
            addCriterion("PROPERTY141 in", values, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY141 not in", values, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY141 between", value1, value2, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty141NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY141 not between", value1, value2, "property141");
            return (Criteria) this;
        }

        public Criteria andProperty142IsNull() {
            addCriterion("PROPERTY142 is null");
            return (Criteria) this;
        }

        public Criteria andProperty142IsNotNull() {
            addCriterion("PROPERTY142 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty142EqualTo(BigDecimal value) {
            addCriterion("PROPERTY142 =", value, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY142 <>", value, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY142 >", value, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY142 >=", value, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142LessThan(BigDecimal value) {
            addCriterion("PROPERTY142 <", value, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY142 <=", value, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142In(List<BigDecimal> values) {
            addCriterion("PROPERTY142 in", values, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY142 not in", values, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY142 between", value1, value2, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty142NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY142 not between", value1, value2, "property142");
            return (Criteria) this;
        }

        public Criteria andProperty143IsNull() {
            addCriterion("PROPERTY143 is null");
            return (Criteria) this;
        }

        public Criteria andProperty143IsNotNull() {
            addCriterion("PROPERTY143 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty143EqualTo(BigDecimal value) {
            addCriterion("PROPERTY143 =", value, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY143 <>", value, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY143 >", value, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY143 >=", value, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143LessThan(BigDecimal value) {
            addCriterion("PROPERTY143 <", value, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY143 <=", value, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143In(List<BigDecimal> values) {
            addCriterion("PROPERTY143 in", values, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY143 not in", values, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY143 between", value1, value2, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty143NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY143 not between", value1, value2, "property143");
            return (Criteria) this;
        }

        public Criteria andProperty144IsNull() {
            addCriterion("PROPERTY144 is null");
            return (Criteria) this;
        }

        public Criteria andProperty144IsNotNull() {
            addCriterion("PROPERTY144 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty144EqualTo(BigDecimal value) {
            addCriterion("PROPERTY144 =", value, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY144 <>", value, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY144 >", value, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY144 >=", value, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144LessThan(BigDecimal value) {
            addCriterion("PROPERTY144 <", value, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY144 <=", value, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144In(List<BigDecimal> values) {
            addCriterion("PROPERTY144 in", values, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY144 not in", values, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY144 between", value1, value2, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty144NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY144 not between", value1, value2, "property144");
            return (Criteria) this;
        }

        public Criteria andProperty145IsNull() {
            addCriterion("PROPERTY145 is null");
            return (Criteria) this;
        }

        public Criteria andProperty145IsNotNull() {
            addCriterion("PROPERTY145 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty145EqualTo(BigDecimal value) {
            addCriterion("PROPERTY145 =", value, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY145 <>", value, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY145 >", value, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY145 >=", value, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145LessThan(BigDecimal value) {
            addCriterion("PROPERTY145 <", value, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY145 <=", value, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145In(List<BigDecimal> values) {
            addCriterion("PROPERTY145 in", values, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY145 not in", values, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY145 between", value1, value2, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty145NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY145 not between", value1, value2, "property145");
            return (Criteria) this;
        }

        public Criteria andProperty146IsNull() {
            addCriterion("PROPERTY146 is null");
            return (Criteria) this;
        }

        public Criteria andProperty146IsNotNull() {
            addCriterion("PROPERTY146 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty146EqualTo(BigDecimal value) {
            addCriterion("PROPERTY146 =", value, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY146 <>", value, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY146 >", value, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY146 >=", value, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146LessThan(BigDecimal value) {
            addCriterion("PROPERTY146 <", value, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY146 <=", value, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146In(List<BigDecimal> values) {
            addCriterion("PROPERTY146 in", values, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY146 not in", values, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY146 between", value1, value2, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty146NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY146 not between", value1, value2, "property146");
            return (Criteria) this;
        }

        public Criteria andProperty147IsNull() {
            addCriterion("PROPERTY147 is null");
            return (Criteria) this;
        }

        public Criteria andProperty147IsNotNull() {
            addCriterion("PROPERTY147 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty147EqualTo(BigDecimal value) {
            addCriterion("PROPERTY147 =", value, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY147 <>", value, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY147 >", value, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY147 >=", value, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147LessThan(BigDecimal value) {
            addCriterion("PROPERTY147 <", value, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY147 <=", value, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147In(List<BigDecimal> values) {
            addCriterion("PROPERTY147 in", values, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY147 not in", values, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY147 between", value1, value2, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty147NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY147 not between", value1, value2, "property147");
            return (Criteria) this;
        }

        public Criteria andProperty148IsNull() {
            addCriterion("PROPERTY148 is null");
            return (Criteria) this;
        }

        public Criteria andProperty148IsNotNull() {
            addCriterion("PROPERTY148 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty148EqualTo(BigDecimal value) {
            addCriterion("PROPERTY148 =", value, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY148 <>", value, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY148 >", value, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY148 >=", value, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148LessThan(BigDecimal value) {
            addCriterion("PROPERTY148 <", value, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY148 <=", value, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148In(List<BigDecimal> values) {
            addCriterion("PROPERTY148 in", values, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY148 not in", values, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY148 between", value1, value2, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty148NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY148 not between", value1, value2, "property148");
            return (Criteria) this;
        }

        public Criteria andProperty149IsNull() {
            addCriterion("PROPERTY149 is null");
            return (Criteria) this;
        }

        public Criteria andProperty149IsNotNull() {
            addCriterion("PROPERTY149 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty149EqualTo(BigDecimal value) {
            addCriterion("PROPERTY149 =", value, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY149 <>", value, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY149 >", value, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY149 >=", value, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149LessThan(BigDecimal value) {
            addCriterion("PROPERTY149 <", value, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY149 <=", value, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149In(List<BigDecimal> values) {
            addCriterion("PROPERTY149 in", values, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY149 not in", values, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY149 between", value1, value2, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty149NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY149 not between", value1, value2, "property149");
            return (Criteria) this;
        }

        public Criteria andProperty150IsNull() {
            addCriterion("PROPERTY150 is null");
            return (Criteria) this;
        }

        public Criteria andProperty150IsNotNull() {
            addCriterion("PROPERTY150 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty150EqualTo(BigDecimal value) {
            addCriterion("PROPERTY150 =", value, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY150 <>", value, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY150 >", value, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY150 >=", value, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150LessThan(BigDecimal value) {
            addCriterion("PROPERTY150 <", value, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY150 <=", value, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150In(List<BigDecimal> values) {
            addCriterion("PROPERTY150 in", values, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY150 not in", values, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY150 between", value1, value2, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty150NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY150 not between", value1, value2, "property150");
            return (Criteria) this;
        }

        public Criteria andProperty151IsNull() {
            addCriterion("PROPERTY151 is null");
            return (Criteria) this;
        }

        public Criteria andProperty151IsNotNull() {
            addCriterion("PROPERTY151 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty151EqualTo(BigDecimal value) {
            addCriterion("PROPERTY151 =", value, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY151 <>", value, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY151 >", value, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY151 >=", value, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151LessThan(BigDecimal value) {
            addCriterion("PROPERTY151 <", value, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY151 <=", value, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151In(List<BigDecimal> values) {
            addCriterion("PROPERTY151 in", values, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY151 not in", values, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY151 between", value1, value2, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty151NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY151 not between", value1, value2, "property151");
            return (Criteria) this;
        }

        public Criteria andProperty152IsNull() {
            addCriterion("PROPERTY152 is null");
            return (Criteria) this;
        }

        public Criteria andProperty152IsNotNull() {
            addCriterion("PROPERTY152 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty152EqualTo(BigDecimal value) {
            addCriterion("PROPERTY152 =", value, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY152 <>", value, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY152 >", value, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY152 >=", value, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152LessThan(BigDecimal value) {
            addCriterion("PROPERTY152 <", value, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY152 <=", value, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152In(List<BigDecimal> values) {
            addCriterion("PROPERTY152 in", values, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY152 not in", values, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY152 between", value1, value2, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty152NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY152 not between", value1, value2, "property152");
            return (Criteria) this;
        }

        public Criteria andProperty153IsNull() {
            addCriterion("PROPERTY153 is null");
            return (Criteria) this;
        }

        public Criteria andProperty153IsNotNull() {
            addCriterion("PROPERTY153 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty153EqualTo(BigDecimal value) {
            addCriterion("PROPERTY153 =", value, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY153 <>", value, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY153 >", value, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY153 >=", value, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153LessThan(BigDecimal value) {
            addCriterion("PROPERTY153 <", value, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY153 <=", value, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153In(List<BigDecimal> values) {
            addCriterion("PROPERTY153 in", values, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY153 not in", values, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY153 between", value1, value2, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty153NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY153 not between", value1, value2, "property153");
            return (Criteria) this;
        }

        public Criteria andProperty154IsNull() {
            addCriterion("PROPERTY154 is null");
            return (Criteria) this;
        }

        public Criteria andProperty154IsNotNull() {
            addCriterion("PROPERTY154 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty154EqualTo(BigDecimal value) {
            addCriterion("PROPERTY154 =", value, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY154 <>", value, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY154 >", value, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY154 >=", value, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154LessThan(BigDecimal value) {
            addCriterion("PROPERTY154 <", value, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY154 <=", value, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154In(List<BigDecimal> values) {
            addCriterion("PROPERTY154 in", values, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY154 not in", values, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY154 between", value1, value2, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty154NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY154 not between", value1, value2, "property154");
            return (Criteria) this;
        }

        public Criteria andProperty155IsNull() {
            addCriterion("PROPERTY155 is null");
            return (Criteria) this;
        }

        public Criteria andProperty155IsNotNull() {
            addCriterion("PROPERTY155 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty155EqualTo(BigDecimal value) {
            addCriterion("PROPERTY155 =", value, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY155 <>", value, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY155 >", value, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY155 >=", value, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155LessThan(BigDecimal value) {
            addCriterion("PROPERTY155 <", value, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY155 <=", value, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155In(List<BigDecimal> values) {
            addCriterion("PROPERTY155 in", values, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY155 not in", values, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY155 between", value1, value2, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty155NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY155 not between", value1, value2, "property155");
            return (Criteria) this;
        }

        public Criteria andProperty156IsNull() {
            addCriterion("PROPERTY156 is null");
            return (Criteria) this;
        }

        public Criteria andProperty156IsNotNull() {
            addCriterion("PROPERTY156 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty156EqualTo(BigDecimal value) {
            addCriterion("PROPERTY156 =", value, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY156 <>", value, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY156 >", value, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY156 >=", value, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156LessThan(BigDecimal value) {
            addCriterion("PROPERTY156 <", value, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY156 <=", value, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156In(List<BigDecimal> values) {
            addCriterion("PROPERTY156 in", values, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY156 not in", values, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY156 between", value1, value2, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty156NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY156 not between", value1, value2, "property156");
            return (Criteria) this;
        }

        public Criteria andProperty157IsNull() {
            addCriterion("PROPERTY157 is null");
            return (Criteria) this;
        }

        public Criteria andProperty157IsNotNull() {
            addCriterion("PROPERTY157 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty157EqualTo(BigDecimal value) {
            addCriterion("PROPERTY157 =", value, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY157 <>", value, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY157 >", value, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY157 >=", value, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157LessThan(BigDecimal value) {
            addCriterion("PROPERTY157 <", value, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY157 <=", value, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157In(List<BigDecimal> values) {
            addCriterion("PROPERTY157 in", values, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY157 not in", values, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY157 between", value1, value2, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty157NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY157 not between", value1, value2, "property157");
            return (Criteria) this;
        }

        public Criteria andProperty158IsNull() {
            addCriterion("PROPERTY158 is null");
            return (Criteria) this;
        }

        public Criteria andProperty158IsNotNull() {
            addCriterion("PROPERTY158 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty158EqualTo(BigDecimal value) {
            addCriterion("PROPERTY158 =", value, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY158 <>", value, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY158 >", value, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY158 >=", value, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158LessThan(BigDecimal value) {
            addCriterion("PROPERTY158 <", value, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY158 <=", value, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158In(List<BigDecimal> values) {
            addCriterion("PROPERTY158 in", values, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY158 not in", values, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY158 between", value1, value2, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty158NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY158 not between", value1, value2, "property158");
            return (Criteria) this;
        }

        public Criteria andProperty159IsNull() {
            addCriterion("PROPERTY159 is null");
            return (Criteria) this;
        }

        public Criteria andProperty159IsNotNull() {
            addCriterion("PROPERTY159 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty159EqualTo(BigDecimal value) {
            addCriterion("PROPERTY159 =", value, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY159 <>", value, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY159 >", value, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY159 >=", value, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159LessThan(BigDecimal value) {
            addCriterion("PROPERTY159 <", value, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY159 <=", value, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159In(List<BigDecimal> values) {
            addCriterion("PROPERTY159 in", values, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY159 not in", values, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY159 between", value1, value2, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty159NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY159 not between", value1, value2, "property159");
            return (Criteria) this;
        }

        public Criteria andProperty160IsNull() {
            addCriterion("PROPERTY160 is null");
            return (Criteria) this;
        }

        public Criteria andProperty160IsNotNull() {
            addCriterion("PROPERTY160 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty160EqualTo(BigDecimal value) {
            addCriterion("PROPERTY160 =", value, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY160 <>", value, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY160 >", value, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY160 >=", value, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160LessThan(BigDecimal value) {
            addCriterion("PROPERTY160 <", value, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY160 <=", value, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160In(List<BigDecimal> values) {
            addCriterion("PROPERTY160 in", values, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY160 not in", values, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY160 between", value1, value2, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty160NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY160 not between", value1, value2, "property160");
            return (Criteria) this;
        }

        public Criteria andProperty161IsNull() {
            addCriterion("PROPERTY161 is null");
            return (Criteria) this;
        }

        public Criteria andProperty161IsNotNull() {
            addCriterion("PROPERTY161 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty161EqualTo(BigDecimal value) {
            addCriterion("PROPERTY161 =", value, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY161 <>", value, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY161 >", value, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY161 >=", value, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161LessThan(BigDecimal value) {
            addCriterion("PROPERTY161 <", value, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY161 <=", value, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161In(List<BigDecimal> values) {
            addCriterion("PROPERTY161 in", values, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY161 not in", values, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY161 between", value1, value2, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty161NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY161 not between", value1, value2, "property161");
            return (Criteria) this;
        }

        public Criteria andProperty162IsNull() {
            addCriterion("PROPERTY162 is null");
            return (Criteria) this;
        }

        public Criteria andProperty162IsNotNull() {
            addCriterion("PROPERTY162 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty162EqualTo(BigDecimal value) {
            addCriterion("PROPERTY162 =", value, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY162 <>", value, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY162 >", value, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY162 >=", value, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162LessThan(BigDecimal value) {
            addCriterion("PROPERTY162 <", value, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY162 <=", value, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162In(List<BigDecimal> values) {
            addCriterion("PROPERTY162 in", values, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY162 not in", values, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY162 between", value1, value2, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty162NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY162 not between", value1, value2, "property162");
            return (Criteria) this;
        }

        public Criteria andProperty163IsNull() {
            addCriterion("PROPERTY163 is null");
            return (Criteria) this;
        }

        public Criteria andProperty163IsNotNull() {
            addCriterion("PROPERTY163 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty163EqualTo(BigDecimal value) {
            addCriterion("PROPERTY163 =", value, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY163 <>", value, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY163 >", value, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY163 >=", value, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163LessThan(BigDecimal value) {
            addCriterion("PROPERTY163 <", value, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY163 <=", value, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163In(List<BigDecimal> values) {
            addCriterion("PROPERTY163 in", values, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY163 not in", values, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY163 between", value1, value2, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty163NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY163 not between", value1, value2, "property163");
            return (Criteria) this;
        }

        public Criteria andProperty164IsNull() {
            addCriterion("PROPERTY164 is null");
            return (Criteria) this;
        }

        public Criteria andProperty164IsNotNull() {
            addCriterion("PROPERTY164 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty164EqualTo(BigDecimal value) {
            addCriterion("PROPERTY164 =", value, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY164 <>", value, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY164 >", value, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY164 >=", value, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164LessThan(BigDecimal value) {
            addCriterion("PROPERTY164 <", value, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY164 <=", value, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164In(List<BigDecimal> values) {
            addCriterion("PROPERTY164 in", values, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY164 not in", values, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY164 between", value1, value2, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty164NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY164 not between", value1, value2, "property164");
            return (Criteria) this;
        }

        public Criteria andProperty165IsNull() {
            addCriterion("PROPERTY165 is null");
            return (Criteria) this;
        }

        public Criteria andProperty165IsNotNull() {
            addCriterion("PROPERTY165 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty165EqualTo(BigDecimal value) {
            addCriterion("PROPERTY165 =", value, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY165 <>", value, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY165 >", value, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY165 >=", value, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165LessThan(BigDecimal value) {
            addCriterion("PROPERTY165 <", value, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY165 <=", value, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165In(List<BigDecimal> values) {
            addCriterion("PROPERTY165 in", values, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY165 not in", values, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY165 between", value1, value2, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty165NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY165 not between", value1, value2, "property165");
            return (Criteria) this;
        }

        public Criteria andProperty166IsNull() {
            addCriterion("PROPERTY166 is null");
            return (Criteria) this;
        }

        public Criteria andProperty166IsNotNull() {
            addCriterion("PROPERTY166 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty166EqualTo(BigDecimal value) {
            addCriterion("PROPERTY166 =", value, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY166 <>", value, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY166 >", value, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY166 >=", value, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166LessThan(BigDecimal value) {
            addCriterion("PROPERTY166 <", value, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY166 <=", value, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166In(List<BigDecimal> values) {
            addCriterion("PROPERTY166 in", values, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY166 not in", values, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY166 between", value1, value2, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty166NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY166 not between", value1, value2, "property166");
            return (Criteria) this;
        }

        public Criteria andProperty167IsNull() {
            addCriterion("PROPERTY167 is null");
            return (Criteria) this;
        }

        public Criteria andProperty167IsNotNull() {
            addCriterion("PROPERTY167 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty167EqualTo(BigDecimal value) {
            addCriterion("PROPERTY167 =", value, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY167 <>", value, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY167 >", value, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY167 >=", value, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167LessThan(BigDecimal value) {
            addCriterion("PROPERTY167 <", value, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY167 <=", value, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167In(List<BigDecimal> values) {
            addCriterion("PROPERTY167 in", values, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY167 not in", values, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY167 between", value1, value2, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty167NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY167 not between", value1, value2, "property167");
            return (Criteria) this;
        }

        public Criteria andProperty168IsNull() {
            addCriterion("PROPERTY168 is null");
            return (Criteria) this;
        }

        public Criteria andProperty168IsNotNull() {
            addCriterion("PROPERTY168 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty168EqualTo(BigDecimal value) {
            addCriterion("PROPERTY168 =", value, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY168 <>", value, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY168 >", value, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY168 >=", value, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168LessThan(BigDecimal value) {
            addCriterion("PROPERTY168 <", value, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY168 <=", value, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168In(List<BigDecimal> values) {
            addCriterion("PROPERTY168 in", values, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY168 not in", values, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY168 between", value1, value2, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty168NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY168 not between", value1, value2, "property168");
            return (Criteria) this;
        }

        public Criteria andProperty169IsNull() {
            addCriterion("PROPERTY169 is null");
            return (Criteria) this;
        }

        public Criteria andProperty169IsNotNull() {
            addCriterion("PROPERTY169 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty169EqualTo(BigDecimal value) {
            addCriterion("PROPERTY169 =", value, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY169 <>", value, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY169 >", value, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY169 >=", value, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169LessThan(BigDecimal value) {
            addCriterion("PROPERTY169 <", value, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY169 <=", value, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169In(List<BigDecimal> values) {
            addCriterion("PROPERTY169 in", values, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY169 not in", values, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY169 between", value1, value2, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty169NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY169 not between", value1, value2, "property169");
            return (Criteria) this;
        }

        public Criteria andProperty170IsNull() {
            addCriterion("PROPERTY170 is null");
            return (Criteria) this;
        }

        public Criteria andProperty170IsNotNull() {
            addCriterion("PROPERTY170 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty170EqualTo(BigDecimal value) {
            addCriterion("PROPERTY170 =", value, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY170 <>", value, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY170 >", value, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY170 >=", value, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170LessThan(BigDecimal value) {
            addCriterion("PROPERTY170 <", value, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY170 <=", value, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170In(List<BigDecimal> values) {
            addCriterion("PROPERTY170 in", values, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY170 not in", values, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY170 between", value1, value2, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty170NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY170 not between", value1, value2, "property170");
            return (Criteria) this;
        }

        public Criteria andProperty171IsNull() {
            addCriterion("PROPERTY171 is null");
            return (Criteria) this;
        }

        public Criteria andProperty171IsNotNull() {
            addCriterion("PROPERTY171 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty171EqualTo(BigDecimal value) {
            addCriterion("PROPERTY171 =", value, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY171 <>", value, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY171 >", value, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY171 >=", value, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171LessThan(BigDecimal value) {
            addCriterion("PROPERTY171 <", value, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY171 <=", value, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171In(List<BigDecimal> values) {
            addCriterion("PROPERTY171 in", values, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY171 not in", values, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY171 between", value1, value2, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty171NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY171 not between", value1, value2, "property171");
            return (Criteria) this;
        }

        public Criteria andProperty172IsNull() {
            addCriterion("PROPERTY172 is null");
            return (Criteria) this;
        }

        public Criteria andProperty172IsNotNull() {
            addCriterion("PROPERTY172 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty172EqualTo(BigDecimal value) {
            addCriterion("PROPERTY172 =", value, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY172 <>", value, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY172 >", value, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY172 >=", value, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172LessThan(BigDecimal value) {
            addCriterion("PROPERTY172 <", value, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY172 <=", value, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172In(List<BigDecimal> values) {
            addCriterion("PROPERTY172 in", values, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY172 not in", values, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY172 between", value1, value2, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty172NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY172 not between", value1, value2, "property172");
            return (Criteria) this;
        }

        public Criteria andProperty173IsNull() {
            addCriterion("PROPERTY173 is null");
            return (Criteria) this;
        }

        public Criteria andProperty173IsNotNull() {
            addCriterion("PROPERTY173 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty173EqualTo(BigDecimal value) {
            addCriterion("PROPERTY173 =", value, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY173 <>", value, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY173 >", value, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY173 >=", value, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173LessThan(BigDecimal value) {
            addCriterion("PROPERTY173 <", value, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY173 <=", value, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173In(List<BigDecimal> values) {
            addCriterion("PROPERTY173 in", values, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY173 not in", values, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY173 between", value1, value2, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty173NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY173 not between", value1, value2, "property173");
            return (Criteria) this;
        }

        public Criteria andProperty174IsNull() {
            addCriterion("PROPERTY174 is null");
            return (Criteria) this;
        }

        public Criteria andProperty174IsNotNull() {
            addCriterion("PROPERTY174 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty174EqualTo(BigDecimal value) {
            addCriterion("PROPERTY174 =", value, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY174 <>", value, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY174 >", value, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY174 >=", value, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174LessThan(BigDecimal value) {
            addCriterion("PROPERTY174 <", value, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY174 <=", value, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174In(List<BigDecimal> values) {
            addCriterion("PROPERTY174 in", values, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY174 not in", values, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY174 between", value1, value2, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty174NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY174 not between", value1, value2, "property174");
            return (Criteria) this;
        }

        public Criteria andProperty175IsNull() {
            addCriterion("PROPERTY175 is null");
            return (Criteria) this;
        }

        public Criteria andProperty175IsNotNull() {
            addCriterion("PROPERTY175 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty175EqualTo(BigDecimal value) {
            addCriterion("PROPERTY175 =", value, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY175 <>", value, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY175 >", value, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY175 >=", value, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175LessThan(BigDecimal value) {
            addCriterion("PROPERTY175 <", value, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY175 <=", value, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175In(List<BigDecimal> values) {
            addCriterion("PROPERTY175 in", values, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY175 not in", values, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY175 between", value1, value2, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty175NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY175 not between", value1, value2, "property175");
            return (Criteria) this;
        }

        public Criteria andProperty176IsNull() {
            addCriterion("PROPERTY176 is null");
            return (Criteria) this;
        }

        public Criteria andProperty176IsNotNull() {
            addCriterion("PROPERTY176 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty176EqualTo(BigDecimal value) {
            addCriterion("PROPERTY176 =", value, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY176 <>", value, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY176 >", value, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY176 >=", value, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176LessThan(BigDecimal value) {
            addCriterion("PROPERTY176 <", value, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY176 <=", value, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176In(List<BigDecimal> values) {
            addCriterion("PROPERTY176 in", values, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY176 not in", values, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY176 between", value1, value2, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty176NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY176 not between", value1, value2, "property176");
            return (Criteria) this;
        }

        public Criteria andProperty177IsNull() {
            addCriterion("PROPERTY177 is null");
            return (Criteria) this;
        }

        public Criteria andProperty177IsNotNull() {
            addCriterion("PROPERTY177 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty177EqualTo(BigDecimal value) {
            addCriterion("PROPERTY177 =", value, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY177 <>", value, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY177 >", value, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY177 >=", value, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177LessThan(BigDecimal value) {
            addCriterion("PROPERTY177 <", value, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY177 <=", value, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177In(List<BigDecimal> values) {
            addCriterion("PROPERTY177 in", values, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY177 not in", values, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY177 between", value1, value2, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty177NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY177 not between", value1, value2, "property177");
            return (Criteria) this;
        }

        public Criteria andProperty178IsNull() {
            addCriterion("PROPERTY178 is null");
            return (Criteria) this;
        }

        public Criteria andProperty178IsNotNull() {
            addCriterion("PROPERTY178 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty178EqualTo(BigDecimal value) {
            addCriterion("PROPERTY178 =", value, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY178 <>", value, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY178 >", value, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY178 >=", value, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178LessThan(BigDecimal value) {
            addCriterion("PROPERTY178 <", value, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY178 <=", value, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178In(List<BigDecimal> values) {
            addCriterion("PROPERTY178 in", values, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY178 not in", values, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY178 between", value1, value2, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty178NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY178 not between", value1, value2, "property178");
            return (Criteria) this;
        }

        public Criteria andProperty179IsNull() {
            addCriterion("PROPERTY179 is null");
            return (Criteria) this;
        }

        public Criteria andProperty179IsNotNull() {
            addCriterion("PROPERTY179 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty179EqualTo(BigDecimal value) {
            addCriterion("PROPERTY179 =", value, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY179 <>", value, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY179 >", value, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY179 >=", value, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179LessThan(BigDecimal value) {
            addCriterion("PROPERTY179 <", value, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY179 <=", value, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179In(List<BigDecimal> values) {
            addCriterion("PROPERTY179 in", values, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY179 not in", values, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY179 between", value1, value2, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty179NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY179 not between", value1, value2, "property179");
            return (Criteria) this;
        }

        public Criteria andProperty180IsNull() {
            addCriterion("PROPERTY180 is null");
            return (Criteria) this;
        }

        public Criteria andProperty180IsNotNull() {
            addCriterion("PROPERTY180 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty180EqualTo(BigDecimal value) {
            addCriterion("PROPERTY180 =", value, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY180 <>", value, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY180 >", value, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY180 >=", value, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180LessThan(BigDecimal value) {
            addCriterion("PROPERTY180 <", value, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY180 <=", value, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180In(List<BigDecimal> values) {
            addCriterion("PROPERTY180 in", values, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY180 not in", values, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY180 between", value1, value2, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty180NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY180 not between", value1, value2, "property180");
            return (Criteria) this;
        }

        public Criteria andProperty181IsNull() {
            addCriterion("PROPERTY181 is null");
            return (Criteria) this;
        }

        public Criteria andProperty181IsNotNull() {
            addCriterion("PROPERTY181 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty181EqualTo(BigDecimal value) {
            addCriterion("PROPERTY181 =", value, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY181 <>", value, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY181 >", value, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY181 >=", value, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181LessThan(BigDecimal value) {
            addCriterion("PROPERTY181 <", value, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY181 <=", value, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181In(List<BigDecimal> values) {
            addCriterion("PROPERTY181 in", values, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY181 not in", values, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY181 between", value1, value2, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty181NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY181 not between", value1, value2, "property181");
            return (Criteria) this;
        }

        public Criteria andProperty182IsNull() {
            addCriterion("PROPERTY182 is null");
            return (Criteria) this;
        }

        public Criteria andProperty182IsNotNull() {
            addCriterion("PROPERTY182 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty182EqualTo(BigDecimal value) {
            addCriterion("PROPERTY182 =", value, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY182 <>", value, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY182 >", value, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY182 >=", value, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182LessThan(BigDecimal value) {
            addCriterion("PROPERTY182 <", value, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY182 <=", value, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182In(List<BigDecimal> values) {
            addCriterion("PROPERTY182 in", values, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY182 not in", values, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY182 between", value1, value2, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty182NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY182 not between", value1, value2, "property182");
            return (Criteria) this;
        }

        public Criteria andProperty183IsNull() {
            addCriterion("PROPERTY183 is null");
            return (Criteria) this;
        }

        public Criteria andProperty183IsNotNull() {
            addCriterion("PROPERTY183 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty183EqualTo(BigDecimal value) {
            addCriterion("PROPERTY183 =", value, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY183 <>", value, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY183 >", value, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY183 >=", value, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183LessThan(BigDecimal value) {
            addCriterion("PROPERTY183 <", value, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY183 <=", value, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183In(List<BigDecimal> values) {
            addCriterion("PROPERTY183 in", values, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY183 not in", values, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY183 between", value1, value2, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty183NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY183 not between", value1, value2, "property183");
            return (Criteria) this;
        }

        public Criteria andProperty184IsNull() {
            addCriterion("PROPERTY184 is null");
            return (Criteria) this;
        }

        public Criteria andProperty184IsNotNull() {
            addCriterion("PROPERTY184 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty184EqualTo(BigDecimal value) {
            addCriterion("PROPERTY184 =", value, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY184 <>", value, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY184 >", value, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY184 >=", value, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184LessThan(BigDecimal value) {
            addCriterion("PROPERTY184 <", value, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY184 <=", value, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184In(List<BigDecimal> values) {
            addCriterion("PROPERTY184 in", values, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY184 not in", values, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY184 between", value1, value2, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty184NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY184 not between", value1, value2, "property184");
            return (Criteria) this;
        }

        public Criteria andProperty185IsNull() {
            addCriterion("PROPERTY185 is null");
            return (Criteria) this;
        }

        public Criteria andProperty185IsNotNull() {
            addCriterion("PROPERTY185 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty185EqualTo(BigDecimal value) {
            addCriterion("PROPERTY185 =", value, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY185 <>", value, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY185 >", value, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY185 >=", value, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185LessThan(BigDecimal value) {
            addCriterion("PROPERTY185 <", value, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY185 <=", value, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185In(List<BigDecimal> values) {
            addCriterion("PROPERTY185 in", values, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY185 not in", values, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY185 between", value1, value2, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty185NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY185 not between", value1, value2, "property185");
            return (Criteria) this;
        }

        public Criteria andProperty186IsNull() {
            addCriterion("PROPERTY186 is null");
            return (Criteria) this;
        }

        public Criteria andProperty186IsNotNull() {
            addCriterion("PROPERTY186 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty186EqualTo(BigDecimal value) {
            addCriterion("PROPERTY186 =", value, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY186 <>", value, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY186 >", value, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY186 >=", value, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186LessThan(BigDecimal value) {
            addCriterion("PROPERTY186 <", value, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY186 <=", value, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186In(List<BigDecimal> values) {
            addCriterion("PROPERTY186 in", values, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY186 not in", values, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY186 between", value1, value2, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty186NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY186 not between", value1, value2, "property186");
            return (Criteria) this;
        }

        public Criteria andProperty187IsNull() {
            addCriterion("PROPERTY187 is null");
            return (Criteria) this;
        }

        public Criteria andProperty187IsNotNull() {
            addCriterion("PROPERTY187 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty187EqualTo(BigDecimal value) {
            addCriterion("PROPERTY187 =", value, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY187 <>", value, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY187 >", value, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY187 >=", value, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187LessThan(BigDecimal value) {
            addCriterion("PROPERTY187 <", value, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY187 <=", value, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187In(List<BigDecimal> values) {
            addCriterion("PROPERTY187 in", values, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY187 not in", values, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY187 between", value1, value2, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty187NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY187 not between", value1, value2, "property187");
            return (Criteria) this;
        }

        public Criteria andProperty188IsNull() {
            addCriterion("PROPERTY188 is null");
            return (Criteria) this;
        }

        public Criteria andProperty188IsNotNull() {
            addCriterion("PROPERTY188 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty188EqualTo(BigDecimal value) {
            addCriterion("PROPERTY188 =", value, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY188 <>", value, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY188 >", value, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY188 >=", value, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188LessThan(BigDecimal value) {
            addCriterion("PROPERTY188 <", value, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY188 <=", value, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188In(List<BigDecimal> values) {
            addCriterion("PROPERTY188 in", values, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY188 not in", values, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY188 between", value1, value2, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty188NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY188 not between", value1, value2, "property188");
            return (Criteria) this;
        }

        public Criteria andProperty189IsNull() {
            addCriterion("PROPERTY189 is null");
            return (Criteria) this;
        }

        public Criteria andProperty189IsNotNull() {
            addCriterion("PROPERTY189 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty189EqualTo(BigDecimal value) {
            addCriterion("PROPERTY189 =", value, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY189 <>", value, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY189 >", value, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY189 >=", value, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189LessThan(BigDecimal value) {
            addCriterion("PROPERTY189 <", value, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY189 <=", value, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189In(List<BigDecimal> values) {
            addCriterion("PROPERTY189 in", values, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY189 not in", values, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY189 between", value1, value2, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty189NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY189 not between", value1, value2, "property189");
            return (Criteria) this;
        }

        public Criteria andProperty190IsNull() {
            addCriterion("PROPERTY190 is null");
            return (Criteria) this;
        }

        public Criteria andProperty190IsNotNull() {
            addCriterion("PROPERTY190 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty190EqualTo(BigDecimal value) {
            addCriterion("PROPERTY190 =", value, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY190 <>", value, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY190 >", value, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY190 >=", value, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190LessThan(BigDecimal value) {
            addCriterion("PROPERTY190 <", value, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY190 <=", value, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190In(List<BigDecimal> values) {
            addCriterion("PROPERTY190 in", values, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY190 not in", values, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY190 between", value1, value2, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty190NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY190 not between", value1, value2, "property190");
            return (Criteria) this;
        }

        public Criteria andProperty191IsNull() {
            addCriterion("PROPERTY191 is null");
            return (Criteria) this;
        }

        public Criteria andProperty191IsNotNull() {
            addCriterion("PROPERTY191 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty191EqualTo(BigDecimal value) {
            addCriterion("PROPERTY191 =", value, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY191 <>", value, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY191 >", value, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY191 >=", value, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191LessThan(BigDecimal value) {
            addCriterion("PROPERTY191 <", value, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY191 <=", value, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191In(List<BigDecimal> values) {
            addCriterion("PROPERTY191 in", values, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY191 not in", values, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY191 between", value1, value2, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty191NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY191 not between", value1, value2, "property191");
            return (Criteria) this;
        }

        public Criteria andProperty192IsNull() {
            addCriterion("PROPERTY192 is null");
            return (Criteria) this;
        }

        public Criteria andProperty192IsNotNull() {
            addCriterion("PROPERTY192 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty192EqualTo(BigDecimal value) {
            addCriterion("PROPERTY192 =", value, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY192 <>", value, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY192 >", value, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY192 >=", value, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192LessThan(BigDecimal value) {
            addCriterion("PROPERTY192 <", value, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY192 <=", value, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192In(List<BigDecimal> values) {
            addCriterion("PROPERTY192 in", values, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY192 not in", values, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY192 between", value1, value2, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty192NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY192 not between", value1, value2, "property192");
            return (Criteria) this;
        }

        public Criteria andProperty193IsNull() {
            addCriterion("PROPERTY193 is null");
            return (Criteria) this;
        }

        public Criteria andProperty193IsNotNull() {
            addCriterion("PROPERTY193 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty193EqualTo(BigDecimal value) {
            addCriterion("PROPERTY193 =", value, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY193 <>", value, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY193 >", value, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY193 >=", value, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193LessThan(BigDecimal value) {
            addCriterion("PROPERTY193 <", value, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY193 <=", value, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193In(List<BigDecimal> values) {
            addCriterion("PROPERTY193 in", values, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY193 not in", values, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY193 between", value1, value2, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty193NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY193 not between", value1, value2, "property193");
            return (Criteria) this;
        }

        public Criteria andProperty194IsNull() {
            addCriterion("PROPERTY194 is null");
            return (Criteria) this;
        }

        public Criteria andProperty194IsNotNull() {
            addCriterion("PROPERTY194 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty194EqualTo(BigDecimal value) {
            addCriterion("PROPERTY194 =", value, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY194 <>", value, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY194 >", value, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY194 >=", value, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194LessThan(BigDecimal value) {
            addCriterion("PROPERTY194 <", value, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY194 <=", value, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194In(List<BigDecimal> values) {
            addCriterion("PROPERTY194 in", values, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY194 not in", values, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY194 between", value1, value2, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty194NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY194 not between", value1, value2, "property194");
            return (Criteria) this;
        }

        public Criteria andProperty195IsNull() {
            addCriterion("PROPERTY195 is null");
            return (Criteria) this;
        }

        public Criteria andProperty195IsNotNull() {
            addCriterion("PROPERTY195 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty195EqualTo(BigDecimal value) {
            addCriterion("PROPERTY195 =", value, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY195 <>", value, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY195 >", value, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY195 >=", value, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195LessThan(BigDecimal value) {
            addCriterion("PROPERTY195 <", value, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY195 <=", value, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195In(List<BigDecimal> values) {
            addCriterion("PROPERTY195 in", values, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY195 not in", values, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY195 between", value1, value2, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty195NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY195 not between", value1, value2, "property195");
            return (Criteria) this;
        }

        public Criteria andProperty196IsNull() {
            addCriterion("PROPERTY196 is null");
            return (Criteria) this;
        }

        public Criteria andProperty196IsNotNull() {
            addCriterion("PROPERTY196 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty196EqualTo(BigDecimal value) {
            addCriterion("PROPERTY196 =", value, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY196 <>", value, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY196 >", value, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY196 >=", value, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196LessThan(BigDecimal value) {
            addCriterion("PROPERTY196 <", value, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY196 <=", value, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196In(List<BigDecimal> values) {
            addCriterion("PROPERTY196 in", values, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY196 not in", values, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY196 between", value1, value2, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty196NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY196 not between", value1, value2, "property196");
            return (Criteria) this;
        }

        public Criteria andProperty197IsNull() {
            addCriterion("PROPERTY197 is null");
            return (Criteria) this;
        }

        public Criteria andProperty197IsNotNull() {
            addCriterion("PROPERTY197 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty197EqualTo(BigDecimal value) {
            addCriterion("PROPERTY197 =", value, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY197 <>", value, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY197 >", value, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY197 >=", value, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197LessThan(BigDecimal value) {
            addCriterion("PROPERTY197 <", value, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY197 <=", value, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197In(List<BigDecimal> values) {
            addCriterion("PROPERTY197 in", values, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY197 not in", values, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY197 between", value1, value2, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty197NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY197 not between", value1, value2, "property197");
            return (Criteria) this;
        }

        public Criteria andProperty198IsNull() {
            addCriterion("PROPERTY198 is null");
            return (Criteria) this;
        }

        public Criteria andProperty198IsNotNull() {
            addCriterion("PROPERTY198 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty198EqualTo(BigDecimal value) {
            addCriterion("PROPERTY198 =", value, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY198 <>", value, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY198 >", value, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY198 >=", value, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198LessThan(BigDecimal value) {
            addCriterion("PROPERTY198 <", value, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY198 <=", value, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198In(List<BigDecimal> values) {
            addCriterion("PROPERTY198 in", values, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY198 not in", values, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY198 between", value1, value2, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty198NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY198 not between", value1, value2, "property198");
            return (Criteria) this;
        }

        public Criteria andProperty199IsNull() {
            addCriterion("PROPERTY199 is null");
            return (Criteria) this;
        }

        public Criteria andProperty199IsNotNull() {
            addCriterion("PROPERTY199 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty199EqualTo(BigDecimal value) {
            addCriterion("PROPERTY199 =", value, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199NotEqualTo(BigDecimal value) {
            addCriterion("PROPERTY199 <>", value, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199GreaterThan(BigDecimal value) {
            addCriterion("PROPERTY199 >", value, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY199 >=", value, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199LessThan(BigDecimal value) {
            addCriterion("PROPERTY199 <", value, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROPERTY199 <=", value, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199In(List<BigDecimal> values) {
            addCriterion("PROPERTY199 in", values, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199NotIn(List<BigDecimal> values) {
            addCriterion("PROPERTY199 not in", values, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY199 between", value1, value2, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty199NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROPERTY199 not between", value1, value2, "property199");
            return (Criteria) this;
        }

        public Criteria andProperty200IsNull() {
            addCriterion("PROPERTY200 is null");
            return (Criteria) this;
        }

        public Criteria andProperty200IsNotNull() {
            addCriterion("PROPERTY200 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty200EqualTo(Date value) {
            addCriterion("PROPERTY200 =", value, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200NotEqualTo(Date value) {
            addCriterion("PROPERTY200 <>", value, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200GreaterThan(Date value) {
            addCriterion("PROPERTY200 >", value, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY200 >=", value, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200LessThan(Date value) {
            addCriterion("PROPERTY200 <", value, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY200 <=", value, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200In(List<Date> values) {
            addCriterion("PROPERTY200 in", values, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200NotIn(List<Date> values) {
            addCriterion("PROPERTY200 not in", values, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200Between(Date value1, Date value2) {
            addCriterion("PROPERTY200 between", value1, value2, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty200NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY200 not between", value1, value2, "property200");
            return (Criteria) this;
        }

        public Criteria andProperty201IsNull() {
            addCriterion("PROPERTY201 is null");
            return (Criteria) this;
        }

        public Criteria andProperty201IsNotNull() {
            addCriterion("PROPERTY201 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty201EqualTo(Date value) {
            addCriterion("PROPERTY201 =", value, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201NotEqualTo(Date value) {
            addCriterion("PROPERTY201 <>", value, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201GreaterThan(Date value) {
            addCriterion("PROPERTY201 >", value, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY201 >=", value, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201LessThan(Date value) {
            addCriterion("PROPERTY201 <", value, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY201 <=", value, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201In(List<Date> values) {
            addCriterion("PROPERTY201 in", values, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201NotIn(List<Date> values) {
            addCriterion("PROPERTY201 not in", values, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201Between(Date value1, Date value2) {
            addCriterion("PROPERTY201 between", value1, value2, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty201NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY201 not between", value1, value2, "property201");
            return (Criteria) this;
        }

        public Criteria andProperty202IsNull() {
            addCriterion("PROPERTY202 is null");
            return (Criteria) this;
        }

        public Criteria andProperty202IsNotNull() {
            addCriterion("PROPERTY202 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty202EqualTo(Date value) {
            addCriterion("PROPERTY202 =", value, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202NotEqualTo(Date value) {
            addCriterion("PROPERTY202 <>", value, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202GreaterThan(Date value) {
            addCriterion("PROPERTY202 >", value, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY202 >=", value, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202LessThan(Date value) {
            addCriterion("PROPERTY202 <", value, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY202 <=", value, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202In(List<Date> values) {
            addCriterion("PROPERTY202 in", values, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202NotIn(List<Date> values) {
            addCriterion("PROPERTY202 not in", values, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202Between(Date value1, Date value2) {
            addCriterion("PROPERTY202 between", value1, value2, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty202NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY202 not between", value1, value2, "property202");
            return (Criteria) this;
        }

        public Criteria andProperty203IsNull() {
            addCriterion("PROPERTY203 is null");
            return (Criteria) this;
        }

        public Criteria andProperty203IsNotNull() {
            addCriterion("PROPERTY203 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty203EqualTo(Date value) {
            addCriterion("PROPERTY203 =", value, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203NotEqualTo(Date value) {
            addCriterion("PROPERTY203 <>", value, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203GreaterThan(Date value) {
            addCriterion("PROPERTY203 >", value, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY203 >=", value, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203LessThan(Date value) {
            addCriterion("PROPERTY203 <", value, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY203 <=", value, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203In(List<Date> values) {
            addCriterion("PROPERTY203 in", values, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203NotIn(List<Date> values) {
            addCriterion("PROPERTY203 not in", values, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203Between(Date value1, Date value2) {
            addCriterion("PROPERTY203 between", value1, value2, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty203NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY203 not between", value1, value2, "property203");
            return (Criteria) this;
        }

        public Criteria andProperty204IsNull() {
            addCriterion("PROPERTY204 is null");
            return (Criteria) this;
        }

        public Criteria andProperty204IsNotNull() {
            addCriterion("PROPERTY204 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty204EqualTo(Date value) {
            addCriterion("PROPERTY204 =", value, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204NotEqualTo(Date value) {
            addCriterion("PROPERTY204 <>", value, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204GreaterThan(Date value) {
            addCriterion("PROPERTY204 >", value, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY204 >=", value, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204LessThan(Date value) {
            addCriterion("PROPERTY204 <", value, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY204 <=", value, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204In(List<Date> values) {
            addCriterion("PROPERTY204 in", values, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204NotIn(List<Date> values) {
            addCriterion("PROPERTY204 not in", values, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204Between(Date value1, Date value2) {
            addCriterion("PROPERTY204 between", value1, value2, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty204NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY204 not between", value1, value2, "property204");
            return (Criteria) this;
        }

        public Criteria andProperty205IsNull() {
            addCriterion("PROPERTY205 is null");
            return (Criteria) this;
        }

        public Criteria andProperty205IsNotNull() {
            addCriterion("PROPERTY205 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty205EqualTo(Date value) {
            addCriterion("PROPERTY205 =", value, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205NotEqualTo(Date value) {
            addCriterion("PROPERTY205 <>", value, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205GreaterThan(Date value) {
            addCriterion("PROPERTY205 >", value, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY205 >=", value, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205LessThan(Date value) {
            addCriterion("PROPERTY205 <", value, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY205 <=", value, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205In(List<Date> values) {
            addCriterion("PROPERTY205 in", values, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205NotIn(List<Date> values) {
            addCriterion("PROPERTY205 not in", values, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205Between(Date value1, Date value2) {
            addCriterion("PROPERTY205 between", value1, value2, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty205NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY205 not between", value1, value2, "property205");
            return (Criteria) this;
        }

        public Criteria andProperty206IsNull() {
            addCriterion("PROPERTY206 is null");
            return (Criteria) this;
        }

        public Criteria andProperty206IsNotNull() {
            addCriterion("PROPERTY206 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty206EqualTo(Date value) {
            addCriterion("PROPERTY206 =", value, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206NotEqualTo(Date value) {
            addCriterion("PROPERTY206 <>", value, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206GreaterThan(Date value) {
            addCriterion("PROPERTY206 >", value, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY206 >=", value, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206LessThan(Date value) {
            addCriterion("PROPERTY206 <", value, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY206 <=", value, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206In(List<Date> values) {
            addCriterion("PROPERTY206 in", values, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206NotIn(List<Date> values) {
            addCriterion("PROPERTY206 not in", values, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206Between(Date value1, Date value2) {
            addCriterion("PROPERTY206 between", value1, value2, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty206NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY206 not between", value1, value2, "property206");
            return (Criteria) this;
        }

        public Criteria andProperty207IsNull() {
            addCriterion("PROPERTY207 is null");
            return (Criteria) this;
        }

        public Criteria andProperty207IsNotNull() {
            addCriterion("PROPERTY207 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty207EqualTo(Date value) {
            addCriterion("PROPERTY207 =", value, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207NotEqualTo(Date value) {
            addCriterion("PROPERTY207 <>", value, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207GreaterThan(Date value) {
            addCriterion("PROPERTY207 >", value, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY207 >=", value, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207LessThan(Date value) {
            addCriterion("PROPERTY207 <", value, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY207 <=", value, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207In(List<Date> values) {
            addCriterion("PROPERTY207 in", values, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207NotIn(List<Date> values) {
            addCriterion("PROPERTY207 not in", values, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207Between(Date value1, Date value2) {
            addCriterion("PROPERTY207 between", value1, value2, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty207NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY207 not between", value1, value2, "property207");
            return (Criteria) this;
        }

        public Criteria andProperty208IsNull() {
            addCriterion("PROPERTY208 is null");
            return (Criteria) this;
        }

        public Criteria andProperty208IsNotNull() {
            addCriterion("PROPERTY208 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty208EqualTo(Date value) {
            addCriterion("PROPERTY208 =", value, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208NotEqualTo(Date value) {
            addCriterion("PROPERTY208 <>", value, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208GreaterThan(Date value) {
            addCriterion("PROPERTY208 >", value, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY208 >=", value, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208LessThan(Date value) {
            addCriterion("PROPERTY208 <", value, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY208 <=", value, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208In(List<Date> values) {
            addCriterion("PROPERTY208 in", values, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208NotIn(List<Date> values) {
            addCriterion("PROPERTY208 not in", values, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208Between(Date value1, Date value2) {
            addCriterion("PROPERTY208 between", value1, value2, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty208NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY208 not between", value1, value2, "property208");
            return (Criteria) this;
        }

        public Criteria andProperty209IsNull() {
            addCriterion("PROPERTY209 is null");
            return (Criteria) this;
        }

        public Criteria andProperty209IsNotNull() {
            addCriterion("PROPERTY209 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty209EqualTo(Date value) {
            addCriterion("PROPERTY209 =", value, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209NotEqualTo(Date value) {
            addCriterion("PROPERTY209 <>", value, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209GreaterThan(Date value) {
            addCriterion("PROPERTY209 >", value, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY209 >=", value, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209LessThan(Date value) {
            addCriterion("PROPERTY209 <", value, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY209 <=", value, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209In(List<Date> values) {
            addCriterion("PROPERTY209 in", values, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209NotIn(List<Date> values) {
            addCriterion("PROPERTY209 not in", values, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209Between(Date value1, Date value2) {
            addCriterion("PROPERTY209 between", value1, value2, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty209NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY209 not between", value1, value2, "property209");
            return (Criteria) this;
        }

        public Criteria andProperty210IsNull() {
            addCriterion("PROPERTY210 is null");
            return (Criteria) this;
        }

        public Criteria andProperty210IsNotNull() {
            addCriterion("PROPERTY210 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty210EqualTo(Date value) {
            addCriterion("PROPERTY210 =", value, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210NotEqualTo(Date value) {
            addCriterion("PROPERTY210 <>", value, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210GreaterThan(Date value) {
            addCriterion("PROPERTY210 >", value, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY210 >=", value, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210LessThan(Date value) {
            addCriterion("PROPERTY210 <", value, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY210 <=", value, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210In(List<Date> values) {
            addCriterion("PROPERTY210 in", values, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210NotIn(List<Date> values) {
            addCriterion("PROPERTY210 not in", values, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210Between(Date value1, Date value2) {
            addCriterion("PROPERTY210 between", value1, value2, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty210NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY210 not between", value1, value2, "property210");
            return (Criteria) this;
        }

        public Criteria andProperty211IsNull() {
            addCriterion("PROPERTY211 is null");
            return (Criteria) this;
        }

        public Criteria andProperty211IsNotNull() {
            addCriterion("PROPERTY211 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty211EqualTo(Date value) {
            addCriterion("PROPERTY211 =", value, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211NotEqualTo(Date value) {
            addCriterion("PROPERTY211 <>", value, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211GreaterThan(Date value) {
            addCriterion("PROPERTY211 >", value, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY211 >=", value, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211LessThan(Date value) {
            addCriterion("PROPERTY211 <", value, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY211 <=", value, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211In(List<Date> values) {
            addCriterion("PROPERTY211 in", values, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211NotIn(List<Date> values) {
            addCriterion("PROPERTY211 not in", values, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211Between(Date value1, Date value2) {
            addCriterion("PROPERTY211 between", value1, value2, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty211NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY211 not between", value1, value2, "property211");
            return (Criteria) this;
        }

        public Criteria andProperty212IsNull() {
            addCriterion("PROPERTY212 is null");
            return (Criteria) this;
        }

        public Criteria andProperty212IsNotNull() {
            addCriterion("PROPERTY212 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty212EqualTo(Date value) {
            addCriterion("PROPERTY212 =", value, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212NotEqualTo(Date value) {
            addCriterion("PROPERTY212 <>", value, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212GreaterThan(Date value) {
            addCriterion("PROPERTY212 >", value, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY212 >=", value, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212LessThan(Date value) {
            addCriterion("PROPERTY212 <", value, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY212 <=", value, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212In(List<Date> values) {
            addCriterion("PROPERTY212 in", values, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212NotIn(List<Date> values) {
            addCriterion("PROPERTY212 not in", values, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212Between(Date value1, Date value2) {
            addCriterion("PROPERTY212 between", value1, value2, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty212NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY212 not between", value1, value2, "property212");
            return (Criteria) this;
        }

        public Criteria andProperty213IsNull() {
            addCriterion("PROPERTY213 is null");
            return (Criteria) this;
        }

        public Criteria andProperty213IsNotNull() {
            addCriterion("PROPERTY213 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty213EqualTo(Date value) {
            addCriterion("PROPERTY213 =", value, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213NotEqualTo(Date value) {
            addCriterion("PROPERTY213 <>", value, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213GreaterThan(Date value) {
            addCriterion("PROPERTY213 >", value, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY213 >=", value, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213LessThan(Date value) {
            addCriterion("PROPERTY213 <", value, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY213 <=", value, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213In(List<Date> values) {
            addCriterion("PROPERTY213 in", values, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213NotIn(List<Date> values) {
            addCriterion("PROPERTY213 not in", values, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213Between(Date value1, Date value2) {
            addCriterion("PROPERTY213 between", value1, value2, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty213NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY213 not between", value1, value2, "property213");
            return (Criteria) this;
        }

        public Criteria andProperty214IsNull() {
            addCriterion("PROPERTY214 is null");
            return (Criteria) this;
        }

        public Criteria andProperty214IsNotNull() {
            addCriterion("PROPERTY214 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty214EqualTo(Date value) {
            addCriterion("PROPERTY214 =", value, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214NotEqualTo(Date value) {
            addCriterion("PROPERTY214 <>", value, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214GreaterThan(Date value) {
            addCriterion("PROPERTY214 >", value, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY214 >=", value, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214LessThan(Date value) {
            addCriterion("PROPERTY214 <", value, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY214 <=", value, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214In(List<Date> values) {
            addCriterion("PROPERTY214 in", values, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214NotIn(List<Date> values) {
            addCriterion("PROPERTY214 not in", values, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214Between(Date value1, Date value2) {
            addCriterion("PROPERTY214 between", value1, value2, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty214NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY214 not between", value1, value2, "property214");
            return (Criteria) this;
        }

        public Criteria andProperty215IsNull() {
            addCriterion("PROPERTY215 is null");
            return (Criteria) this;
        }

        public Criteria andProperty215IsNotNull() {
            addCriterion("PROPERTY215 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty215EqualTo(Date value) {
            addCriterion("PROPERTY215 =", value, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215NotEqualTo(Date value) {
            addCriterion("PROPERTY215 <>", value, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215GreaterThan(Date value) {
            addCriterion("PROPERTY215 >", value, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY215 >=", value, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215LessThan(Date value) {
            addCriterion("PROPERTY215 <", value, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY215 <=", value, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215In(List<Date> values) {
            addCriterion("PROPERTY215 in", values, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215NotIn(List<Date> values) {
            addCriterion("PROPERTY215 not in", values, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215Between(Date value1, Date value2) {
            addCriterion("PROPERTY215 between", value1, value2, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty215NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY215 not between", value1, value2, "property215");
            return (Criteria) this;
        }

        public Criteria andProperty216IsNull() {
            addCriterion("PROPERTY216 is null");
            return (Criteria) this;
        }

        public Criteria andProperty216IsNotNull() {
            addCriterion("PROPERTY216 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty216EqualTo(Date value) {
            addCriterion("PROPERTY216 =", value, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216NotEqualTo(Date value) {
            addCriterion("PROPERTY216 <>", value, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216GreaterThan(Date value) {
            addCriterion("PROPERTY216 >", value, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY216 >=", value, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216LessThan(Date value) {
            addCriterion("PROPERTY216 <", value, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY216 <=", value, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216In(List<Date> values) {
            addCriterion("PROPERTY216 in", values, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216NotIn(List<Date> values) {
            addCriterion("PROPERTY216 not in", values, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216Between(Date value1, Date value2) {
            addCriterion("PROPERTY216 between", value1, value2, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty216NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY216 not between", value1, value2, "property216");
            return (Criteria) this;
        }

        public Criteria andProperty217IsNull() {
            addCriterion("PROPERTY217 is null");
            return (Criteria) this;
        }

        public Criteria andProperty217IsNotNull() {
            addCriterion("PROPERTY217 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty217EqualTo(Date value) {
            addCriterion("PROPERTY217 =", value, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217NotEqualTo(Date value) {
            addCriterion("PROPERTY217 <>", value, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217GreaterThan(Date value) {
            addCriterion("PROPERTY217 >", value, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY217 >=", value, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217LessThan(Date value) {
            addCriterion("PROPERTY217 <", value, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY217 <=", value, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217In(List<Date> values) {
            addCriterion("PROPERTY217 in", values, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217NotIn(List<Date> values) {
            addCriterion("PROPERTY217 not in", values, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217Between(Date value1, Date value2) {
            addCriterion("PROPERTY217 between", value1, value2, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty217NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY217 not between", value1, value2, "property217");
            return (Criteria) this;
        }

        public Criteria andProperty218IsNull() {
            addCriterion("PROPERTY218 is null");
            return (Criteria) this;
        }

        public Criteria andProperty218IsNotNull() {
            addCriterion("PROPERTY218 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty218EqualTo(Date value) {
            addCriterion("PROPERTY218 =", value, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218NotEqualTo(Date value) {
            addCriterion("PROPERTY218 <>", value, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218GreaterThan(Date value) {
            addCriterion("PROPERTY218 >", value, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY218 >=", value, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218LessThan(Date value) {
            addCriterion("PROPERTY218 <", value, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY218 <=", value, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218In(List<Date> values) {
            addCriterion("PROPERTY218 in", values, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218NotIn(List<Date> values) {
            addCriterion("PROPERTY218 not in", values, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218Between(Date value1, Date value2) {
            addCriterion("PROPERTY218 between", value1, value2, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty218NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY218 not between", value1, value2, "property218");
            return (Criteria) this;
        }

        public Criteria andProperty219IsNull() {
            addCriterion("PROPERTY219 is null");
            return (Criteria) this;
        }

        public Criteria andProperty219IsNotNull() {
            addCriterion("PROPERTY219 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty219EqualTo(Date value) {
            addCriterion("PROPERTY219 =", value, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219NotEqualTo(Date value) {
            addCriterion("PROPERTY219 <>", value, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219GreaterThan(Date value) {
            addCriterion("PROPERTY219 >", value, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY219 >=", value, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219LessThan(Date value) {
            addCriterion("PROPERTY219 <", value, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY219 <=", value, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219In(List<Date> values) {
            addCriterion("PROPERTY219 in", values, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219NotIn(List<Date> values) {
            addCriterion("PROPERTY219 not in", values, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219Between(Date value1, Date value2) {
            addCriterion("PROPERTY219 between", value1, value2, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty219NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY219 not between", value1, value2, "property219");
            return (Criteria) this;
        }

        public Criteria andProperty220IsNull() {
            addCriterion("PROPERTY220 is null");
            return (Criteria) this;
        }

        public Criteria andProperty220IsNotNull() {
            addCriterion("PROPERTY220 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty220EqualTo(Date value) {
            addCriterion("PROPERTY220 =", value, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220NotEqualTo(Date value) {
            addCriterion("PROPERTY220 <>", value, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220GreaterThan(Date value) {
            addCriterion("PROPERTY220 >", value, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY220 >=", value, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220LessThan(Date value) {
            addCriterion("PROPERTY220 <", value, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY220 <=", value, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220In(List<Date> values) {
            addCriterion("PROPERTY220 in", values, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220NotIn(List<Date> values) {
            addCriterion("PROPERTY220 not in", values, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220Between(Date value1, Date value2) {
            addCriterion("PROPERTY220 between", value1, value2, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty220NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY220 not between", value1, value2, "property220");
            return (Criteria) this;
        }

        public Criteria andProperty221IsNull() {
            addCriterion("PROPERTY221 is null");
            return (Criteria) this;
        }

        public Criteria andProperty221IsNotNull() {
            addCriterion("PROPERTY221 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty221EqualTo(Date value) {
            addCriterion("PROPERTY221 =", value, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221NotEqualTo(Date value) {
            addCriterion("PROPERTY221 <>", value, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221GreaterThan(Date value) {
            addCriterion("PROPERTY221 >", value, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY221 >=", value, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221LessThan(Date value) {
            addCriterion("PROPERTY221 <", value, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY221 <=", value, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221In(List<Date> values) {
            addCriterion("PROPERTY221 in", values, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221NotIn(List<Date> values) {
            addCriterion("PROPERTY221 not in", values, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221Between(Date value1, Date value2) {
            addCriterion("PROPERTY221 between", value1, value2, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty221NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY221 not between", value1, value2, "property221");
            return (Criteria) this;
        }

        public Criteria andProperty222IsNull() {
            addCriterion("PROPERTY222 is null");
            return (Criteria) this;
        }

        public Criteria andProperty222IsNotNull() {
            addCriterion("PROPERTY222 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty222EqualTo(Date value) {
            addCriterion("PROPERTY222 =", value, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222NotEqualTo(Date value) {
            addCriterion("PROPERTY222 <>", value, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222GreaterThan(Date value) {
            addCriterion("PROPERTY222 >", value, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY222 >=", value, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222LessThan(Date value) {
            addCriterion("PROPERTY222 <", value, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY222 <=", value, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222In(List<Date> values) {
            addCriterion("PROPERTY222 in", values, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222NotIn(List<Date> values) {
            addCriterion("PROPERTY222 not in", values, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222Between(Date value1, Date value2) {
            addCriterion("PROPERTY222 between", value1, value2, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty222NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY222 not between", value1, value2, "property222");
            return (Criteria) this;
        }

        public Criteria andProperty223IsNull() {
            addCriterion("PROPERTY223 is null");
            return (Criteria) this;
        }

        public Criteria andProperty223IsNotNull() {
            addCriterion("PROPERTY223 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty223EqualTo(Date value) {
            addCriterion("PROPERTY223 =", value, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223NotEqualTo(Date value) {
            addCriterion("PROPERTY223 <>", value, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223GreaterThan(Date value) {
            addCriterion("PROPERTY223 >", value, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY223 >=", value, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223LessThan(Date value) {
            addCriterion("PROPERTY223 <", value, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY223 <=", value, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223In(List<Date> values) {
            addCriterion("PROPERTY223 in", values, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223NotIn(List<Date> values) {
            addCriterion("PROPERTY223 not in", values, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223Between(Date value1, Date value2) {
            addCriterion("PROPERTY223 between", value1, value2, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty223NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY223 not between", value1, value2, "property223");
            return (Criteria) this;
        }

        public Criteria andProperty224IsNull() {
            addCriterion("PROPERTY224 is null");
            return (Criteria) this;
        }

        public Criteria andProperty224IsNotNull() {
            addCriterion("PROPERTY224 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty224EqualTo(Date value) {
            addCriterion("PROPERTY224 =", value, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224NotEqualTo(Date value) {
            addCriterion("PROPERTY224 <>", value, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224GreaterThan(Date value) {
            addCriterion("PROPERTY224 >", value, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY224 >=", value, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224LessThan(Date value) {
            addCriterion("PROPERTY224 <", value, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY224 <=", value, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224In(List<Date> values) {
            addCriterion("PROPERTY224 in", values, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224NotIn(List<Date> values) {
            addCriterion("PROPERTY224 not in", values, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224Between(Date value1, Date value2) {
            addCriterion("PROPERTY224 between", value1, value2, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty224NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY224 not between", value1, value2, "property224");
            return (Criteria) this;
        }

        public Criteria andProperty225IsNull() {
            addCriterion("PROPERTY225 is null");
            return (Criteria) this;
        }

        public Criteria andProperty225IsNotNull() {
            addCriterion("PROPERTY225 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty225EqualTo(Date value) {
            addCriterion("PROPERTY225 =", value, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225NotEqualTo(Date value) {
            addCriterion("PROPERTY225 <>", value, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225GreaterThan(Date value) {
            addCriterion("PROPERTY225 >", value, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY225 >=", value, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225LessThan(Date value) {
            addCriterion("PROPERTY225 <", value, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY225 <=", value, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225In(List<Date> values) {
            addCriterion("PROPERTY225 in", values, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225NotIn(List<Date> values) {
            addCriterion("PROPERTY225 not in", values, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225Between(Date value1, Date value2) {
            addCriterion("PROPERTY225 between", value1, value2, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty225NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY225 not between", value1, value2, "property225");
            return (Criteria) this;
        }

        public Criteria andProperty226IsNull() {
            addCriterion("PROPERTY226 is null");
            return (Criteria) this;
        }

        public Criteria andProperty226IsNotNull() {
            addCriterion("PROPERTY226 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty226EqualTo(Date value) {
            addCriterion("PROPERTY226 =", value, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226NotEqualTo(Date value) {
            addCriterion("PROPERTY226 <>", value, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226GreaterThan(Date value) {
            addCriterion("PROPERTY226 >", value, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY226 >=", value, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226LessThan(Date value) {
            addCriterion("PROPERTY226 <", value, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY226 <=", value, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226In(List<Date> values) {
            addCriterion("PROPERTY226 in", values, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226NotIn(List<Date> values) {
            addCriterion("PROPERTY226 not in", values, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226Between(Date value1, Date value2) {
            addCriterion("PROPERTY226 between", value1, value2, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty226NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY226 not between", value1, value2, "property226");
            return (Criteria) this;
        }

        public Criteria andProperty227IsNull() {
            addCriterion("PROPERTY227 is null");
            return (Criteria) this;
        }

        public Criteria andProperty227IsNotNull() {
            addCriterion("PROPERTY227 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty227EqualTo(Date value) {
            addCriterion("PROPERTY227 =", value, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227NotEqualTo(Date value) {
            addCriterion("PROPERTY227 <>", value, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227GreaterThan(Date value) {
            addCriterion("PROPERTY227 >", value, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY227 >=", value, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227LessThan(Date value) {
            addCriterion("PROPERTY227 <", value, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY227 <=", value, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227In(List<Date> values) {
            addCriterion("PROPERTY227 in", values, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227NotIn(List<Date> values) {
            addCriterion("PROPERTY227 not in", values, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227Between(Date value1, Date value2) {
            addCriterion("PROPERTY227 between", value1, value2, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty227NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY227 not between", value1, value2, "property227");
            return (Criteria) this;
        }

        public Criteria andProperty228IsNull() {
            addCriterion("PROPERTY228 is null");
            return (Criteria) this;
        }

        public Criteria andProperty228IsNotNull() {
            addCriterion("PROPERTY228 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty228EqualTo(Date value) {
            addCriterion("PROPERTY228 =", value, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228NotEqualTo(Date value) {
            addCriterion("PROPERTY228 <>", value, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228GreaterThan(Date value) {
            addCriterion("PROPERTY228 >", value, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY228 >=", value, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228LessThan(Date value) {
            addCriterion("PROPERTY228 <", value, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY228 <=", value, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228In(List<Date> values) {
            addCriterion("PROPERTY228 in", values, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228NotIn(List<Date> values) {
            addCriterion("PROPERTY228 not in", values, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228Between(Date value1, Date value2) {
            addCriterion("PROPERTY228 between", value1, value2, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty228NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY228 not between", value1, value2, "property228");
            return (Criteria) this;
        }

        public Criteria andProperty229IsNull() {
            addCriterion("PROPERTY229 is null");
            return (Criteria) this;
        }

        public Criteria andProperty229IsNotNull() {
            addCriterion("PROPERTY229 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty229EqualTo(Date value) {
            addCriterion("PROPERTY229 =", value, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229NotEqualTo(Date value) {
            addCriterion("PROPERTY229 <>", value, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229GreaterThan(Date value) {
            addCriterion("PROPERTY229 >", value, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY229 >=", value, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229LessThan(Date value) {
            addCriterion("PROPERTY229 <", value, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY229 <=", value, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229In(List<Date> values) {
            addCriterion("PROPERTY229 in", values, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229NotIn(List<Date> values) {
            addCriterion("PROPERTY229 not in", values, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229Between(Date value1, Date value2) {
            addCriterion("PROPERTY229 between", value1, value2, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty229NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY229 not between", value1, value2, "property229");
            return (Criteria) this;
        }

        public Criteria andProperty230IsNull() {
            addCriterion("PROPERTY230 is null");
            return (Criteria) this;
        }

        public Criteria andProperty230IsNotNull() {
            addCriterion("PROPERTY230 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty230EqualTo(Date value) {
            addCriterion("PROPERTY230 =", value, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230NotEqualTo(Date value) {
            addCriterion("PROPERTY230 <>", value, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230GreaterThan(Date value) {
            addCriterion("PROPERTY230 >", value, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY230 >=", value, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230LessThan(Date value) {
            addCriterion("PROPERTY230 <", value, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY230 <=", value, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230In(List<Date> values) {
            addCriterion("PROPERTY230 in", values, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230NotIn(List<Date> values) {
            addCriterion("PROPERTY230 not in", values, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230Between(Date value1, Date value2) {
            addCriterion("PROPERTY230 between", value1, value2, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty230NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY230 not between", value1, value2, "property230");
            return (Criteria) this;
        }

        public Criteria andProperty231IsNull() {
            addCriterion("PROPERTY231 is null");
            return (Criteria) this;
        }

        public Criteria andProperty231IsNotNull() {
            addCriterion("PROPERTY231 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty231EqualTo(Date value) {
            addCriterion("PROPERTY231 =", value, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231NotEqualTo(Date value) {
            addCriterion("PROPERTY231 <>", value, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231GreaterThan(Date value) {
            addCriterion("PROPERTY231 >", value, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY231 >=", value, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231LessThan(Date value) {
            addCriterion("PROPERTY231 <", value, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY231 <=", value, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231In(List<Date> values) {
            addCriterion("PROPERTY231 in", values, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231NotIn(List<Date> values) {
            addCriterion("PROPERTY231 not in", values, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231Between(Date value1, Date value2) {
            addCriterion("PROPERTY231 between", value1, value2, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty231NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY231 not between", value1, value2, "property231");
            return (Criteria) this;
        }

        public Criteria andProperty232IsNull() {
            addCriterion("PROPERTY232 is null");
            return (Criteria) this;
        }

        public Criteria andProperty232IsNotNull() {
            addCriterion("PROPERTY232 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty232EqualTo(Date value) {
            addCriterion("PROPERTY232 =", value, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232NotEqualTo(Date value) {
            addCriterion("PROPERTY232 <>", value, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232GreaterThan(Date value) {
            addCriterion("PROPERTY232 >", value, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY232 >=", value, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232LessThan(Date value) {
            addCriterion("PROPERTY232 <", value, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY232 <=", value, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232In(List<Date> values) {
            addCriterion("PROPERTY232 in", values, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232NotIn(List<Date> values) {
            addCriterion("PROPERTY232 not in", values, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232Between(Date value1, Date value2) {
            addCriterion("PROPERTY232 between", value1, value2, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty232NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY232 not between", value1, value2, "property232");
            return (Criteria) this;
        }

        public Criteria andProperty233IsNull() {
            addCriterion("PROPERTY233 is null");
            return (Criteria) this;
        }

        public Criteria andProperty233IsNotNull() {
            addCriterion("PROPERTY233 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty233EqualTo(Date value) {
            addCriterion("PROPERTY233 =", value, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233NotEqualTo(Date value) {
            addCriterion("PROPERTY233 <>", value, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233GreaterThan(Date value) {
            addCriterion("PROPERTY233 >", value, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY233 >=", value, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233LessThan(Date value) {
            addCriterion("PROPERTY233 <", value, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY233 <=", value, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233In(List<Date> values) {
            addCriterion("PROPERTY233 in", values, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233NotIn(List<Date> values) {
            addCriterion("PROPERTY233 not in", values, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233Between(Date value1, Date value2) {
            addCriterion("PROPERTY233 between", value1, value2, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty233NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY233 not between", value1, value2, "property233");
            return (Criteria) this;
        }

        public Criteria andProperty234IsNull() {
            addCriterion("PROPERTY234 is null");
            return (Criteria) this;
        }

        public Criteria andProperty234IsNotNull() {
            addCriterion("PROPERTY234 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty234EqualTo(Date value) {
            addCriterion("PROPERTY234 =", value, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234NotEqualTo(Date value) {
            addCriterion("PROPERTY234 <>", value, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234GreaterThan(Date value) {
            addCriterion("PROPERTY234 >", value, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY234 >=", value, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234LessThan(Date value) {
            addCriterion("PROPERTY234 <", value, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY234 <=", value, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234In(List<Date> values) {
            addCriterion("PROPERTY234 in", values, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234NotIn(List<Date> values) {
            addCriterion("PROPERTY234 not in", values, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234Between(Date value1, Date value2) {
            addCriterion("PROPERTY234 between", value1, value2, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty234NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY234 not between", value1, value2, "property234");
            return (Criteria) this;
        }

        public Criteria andProperty235IsNull() {
            addCriterion("PROPERTY235 is null");
            return (Criteria) this;
        }

        public Criteria andProperty235IsNotNull() {
            addCriterion("PROPERTY235 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty235EqualTo(Date value) {
            addCriterion("PROPERTY235 =", value, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235NotEqualTo(Date value) {
            addCriterion("PROPERTY235 <>", value, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235GreaterThan(Date value) {
            addCriterion("PROPERTY235 >", value, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY235 >=", value, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235LessThan(Date value) {
            addCriterion("PROPERTY235 <", value, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY235 <=", value, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235In(List<Date> values) {
            addCriterion("PROPERTY235 in", values, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235NotIn(List<Date> values) {
            addCriterion("PROPERTY235 not in", values, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235Between(Date value1, Date value2) {
            addCriterion("PROPERTY235 between", value1, value2, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty235NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY235 not between", value1, value2, "property235");
            return (Criteria) this;
        }

        public Criteria andProperty236IsNull() {
            addCriterion("PROPERTY236 is null");
            return (Criteria) this;
        }

        public Criteria andProperty236IsNotNull() {
            addCriterion("PROPERTY236 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty236EqualTo(Date value) {
            addCriterion("PROPERTY236 =", value, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236NotEqualTo(Date value) {
            addCriterion("PROPERTY236 <>", value, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236GreaterThan(Date value) {
            addCriterion("PROPERTY236 >", value, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY236 >=", value, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236LessThan(Date value) {
            addCriterion("PROPERTY236 <", value, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY236 <=", value, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236In(List<Date> values) {
            addCriterion("PROPERTY236 in", values, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236NotIn(List<Date> values) {
            addCriterion("PROPERTY236 not in", values, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236Between(Date value1, Date value2) {
            addCriterion("PROPERTY236 between", value1, value2, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty236NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY236 not between", value1, value2, "property236");
            return (Criteria) this;
        }

        public Criteria andProperty237IsNull() {
            addCriterion("PROPERTY237 is null");
            return (Criteria) this;
        }

        public Criteria andProperty237IsNotNull() {
            addCriterion("PROPERTY237 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty237EqualTo(Date value) {
            addCriterion("PROPERTY237 =", value, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237NotEqualTo(Date value) {
            addCriterion("PROPERTY237 <>", value, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237GreaterThan(Date value) {
            addCriterion("PROPERTY237 >", value, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY237 >=", value, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237LessThan(Date value) {
            addCriterion("PROPERTY237 <", value, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY237 <=", value, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237In(List<Date> values) {
            addCriterion("PROPERTY237 in", values, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237NotIn(List<Date> values) {
            addCriterion("PROPERTY237 not in", values, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237Between(Date value1, Date value2) {
            addCriterion("PROPERTY237 between", value1, value2, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty237NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY237 not between", value1, value2, "property237");
            return (Criteria) this;
        }

        public Criteria andProperty238IsNull() {
            addCriterion("PROPERTY238 is null");
            return (Criteria) this;
        }

        public Criteria andProperty238IsNotNull() {
            addCriterion("PROPERTY238 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty238EqualTo(Date value) {
            addCriterion("PROPERTY238 =", value, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238NotEqualTo(Date value) {
            addCriterion("PROPERTY238 <>", value, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238GreaterThan(Date value) {
            addCriterion("PROPERTY238 >", value, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY238 >=", value, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238LessThan(Date value) {
            addCriterion("PROPERTY238 <", value, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY238 <=", value, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238In(List<Date> values) {
            addCriterion("PROPERTY238 in", values, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238NotIn(List<Date> values) {
            addCriterion("PROPERTY238 not in", values, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238Between(Date value1, Date value2) {
            addCriterion("PROPERTY238 between", value1, value2, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty238NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY238 not between", value1, value2, "property238");
            return (Criteria) this;
        }

        public Criteria andProperty239IsNull() {
            addCriterion("PROPERTY239 is null");
            return (Criteria) this;
        }

        public Criteria andProperty239IsNotNull() {
            addCriterion("PROPERTY239 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty239EqualTo(Date value) {
            addCriterion("PROPERTY239 =", value, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239NotEqualTo(Date value) {
            addCriterion("PROPERTY239 <>", value, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239GreaterThan(Date value) {
            addCriterion("PROPERTY239 >", value, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY239 >=", value, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239LessThan(Date value) {
            addCriterion("PROPERTY239 <", value, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY239 <=", value, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239In(List<Date> values) {
            addCriterion("PROPERTY239 in", values, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239NotIn(List<Date> values) {
            addCriterion("PROPERTY239 not in", values, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239Between(Date value1, Date value2) {
            addCriterion("PROPERTY239 between", value1, value2, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty239NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY239 not between", value1, value2, "property239");
            return (Criteria) this;
        }

        public Criteria andProperty240IsNull() {
            addCriterion("PROPERTY240 is null");
            return (Criteria) this;
        }

        public Criteria andProperty240IsNotNull() {
            addCriterion("PROPERTY240 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty240EqualTo(Date value) {
            addCriterion("PROPERTY240 =", value, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240NotEqualTo(Date value) {
            addCriterion("PROPERTY240 <>", value, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240GreaterThan(Date value) {
            addCriterion("PROPERTY240 >", value, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY240 >=", value, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240LessThan(Date value) {
            addCriterion("PROPERTY240 <", value, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY240 <=", value, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240In(List<Date> values) {
            addCriterion("PROPERTY240 in", values, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240NotIn(List<Date> values) {
            addCriterion("PROPERTY240 not in", values, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240Between(Date value1, Date value2) {
            addCriterion("PROPERTY240 between", value1, value2, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty240NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY240 not between", value1, value2, "property240");
            return (Criteria) this;
        }

        public Criteria andProperty241IsNull() {
            addCriterion("PROPERTY241 is null");
            return (Criteria) this;
        }

        public Criteria andProperty241IsNotNull() {
            addCriterion("PROPERTY241 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty241EqualTo(Date value) {
            addCriterion("PROPERTY241 =", value, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241NotEqualTo(Date value) {
            addCriterion("PROPERTY241 <>", value, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241GreaterThan(Date value) {
            addCriterion("PROPERTY241 >", value, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY241 >=", value, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241LessThan(Date value) {
            addCriterion("PROPERTY241 <", value, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY241 <=", value, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241In(List<Date> values) {
            addCriterion("PROPERTY241 in", values, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241NotIn(List<Date> values) {
            addCriterion("PROPERTY241 not in", values, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241Between(Date value1, Date value2) {
            addCriterion("PROPERTY241 between", value1, value2, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty241NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY241 not between", value1, value2, "property241");
            return (Criteria) this;
        }

        public Criteria andProperty242IsNull() {
            addCriterion("PROPERTY242 is null");
            return (Criteria) this;
        }

        public Criteria andProperty242IsNotNull() {
            addCriterion("PROPERTY242 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty242EqualTo(Date value) {
            addCriterion("PROPERTY242 =", value, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242NotEqualTo(Date value) {
            addCriterion("PROPERTY242 <>", value, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242GreaterThan(Date value) {
            addCriterion("PROPERTY242 >", value, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY242 >=", value, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242LessThan(Date value) {
            addCriterion("PROPERTY242 <", value, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY242 <=", value, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242In(List<Date> values) {
            addCriterion("PROPERTY242 in", values, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242NotIn(List<Date> values) {
            addCriterion("PROPERTY242 not in", values, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242Between(Date value1, Date value2) {
            addCriterion("PROPERTY242 between", value1, value2, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty242NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY242 not between", value1, value2, "property242");
            return (Criteria) this;
        }

        public Criteria andProperty243IsNull() {
            addCriterion("PROPERTY243 is null");
            return (Criteria) this;
        }

        public Criteria andProperty243IsNotNull() {
            addCriterion("PROPERTY243 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty243EqualTo(Date value) {
            addCriterion("PROPERTY243 =", value, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243NotEqualTo(Date value) {
            addCriterion("PROPERTY243 <>", value, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243GreaterThan(Date value) {
            addCriterion("PROPERTY243 >", value, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY243 >=", value, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243LessThan(Date value) {
            addCriterion("PROPERTY243 <", value, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY243 <=", value, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243In(List<Date> values) {
            addCriterion("PROPERTY243 in", values, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243NotIn(List<Date> values) {
            addCriterion("PROPERTY243 not in", values, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243Between(Date value1, Date value2) {
            addCriterion("PROPERTY243 between", value1, value2, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty243NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY243 not between", value1, value2, "property243");
            return (Criteria) this;
        }

        public Criteria andProperty244IsNull() {
            addCriterion("PROPERTY244 is null");
            return (Criteria) this;
        }

        public Criteria andProperty244IsNotNull() {
            addCriterion("PROPERTY244 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty244EqualTo(Date value) {
            addCriterion("PROPERTY244 =", value, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244NotEqualTo(Date value) {
            addCriterion("PROPERTY244 <>", value, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244GreaterThan(Date value) {
            addCriterion("PROPERTY244 >", value, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY244 >=", value, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244LessThan(Date value) {
            addCriterion("PROPERTY244 <", value, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY244 <=", value, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244In(List<Date> values) {
            addCriterion("PROPERTY244 in", values, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244NotIn(List<Date> values) {
            addCriterion("PROPERTY244 not in", values, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244Between(Date value1, Date value2) {
            addCriterion("PROPERTY244 between", value1, value2, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty244NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY244 not between", value1, value2, "property244");
            return (Criteria) this;
        }

        public Criteria andProperty245IsNull() {
            addCriterion("PROPERTY245 is null");
            return (Criteria) this;
        }

        public Criteria andProperty245IsNotNull() {
            addCriterion("PROPERTY245 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty245EqualTo(Date value) {
            addCriterion("PROPERTY245 =", value, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245NotEqualTo(Date value) {
            addCriterion("PROPERTY245 <>", value, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245GreaterThan(Date value) {
            addCriterion("PROPERTY245 >", value, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY245 >=", value, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245LessThan(Date value) {
            addCriterion("PROPERTY245 <", value, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY245 <=", value, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245In(List<Date> values) {
            addCriterion("PROPERTY245 in", values, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245NotIn(List<Date> values) {
            addCriterion("PROPERTY245 not in", values, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245Between(Date value1, Date value2) {
            addCriterion("PROPERTY245 between", value1, value2, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty245NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY245 not between", value1, value2, "property245");
            return (Criteria) this;
        }

        public Criteria andProperty246IsNull() {
            addCriterion("PROPERTY246 is null");
            return (Criteria) this;
        }

        public Criteria andProperty246IsNotNull() {
            addCriterion("PROPERTY246 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty246EqualTo(Date value) {
            addCriterion("PROPERTY246 =", value, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246NotEqualTo(Date value) {
            addCriterion("PROPERTY246 <>", value, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246GreaterThan(Date value) {
            addCriterion("PROPERTY246 >", value, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY246 >=", value, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246LessThan(Date value) {
            addCriterion("PROPERTY246 <", value, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY246 <=", value, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246In(List<Date> values) {
            addCriterion("PROPERTY246 in", values, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246NotIn(List<Date> values) {
            addCriterion("PROPERTY246 not in", values, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246Between(Date value1, Date value2) {
            addCriterion("PROPERTY246 between", value1, value2, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty246NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY246 not between", value1, value2, "property246");
            return (Criteria) this;
        }

        public Criteria andProperty247IsNull() {
            addCriterion("PROPERTY247 is null");
            return (Criteria) this;
        }

        public Criteria andProperty247IsNotNull() {
            addCriterion("PROPERTY247 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty247EqualTo(Date value) {
            addCriterion("PROPERTY247 =", value, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247NotEqualTo(Date value) {
            addCriterion("PROPERTY247 <>", value, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247GreaterThan(Date value) {
            addCriterion("PROPERTY247 >", value, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY247 >=", value, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247LessThan(Date value) {
            addCriterion("PROPERTY247 <", value, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY247 <=", value, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247In(List<Date> values) {
            addCriterion("PROPERTY247 in", values, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247NotIn(List<Date> values) {
            addCriterion("PROPERTY247 not in", values, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247Between(Date value1, Date value2) {
            addCriterion("PROPERTY247 between", value1, value2, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty247NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY247 not between", value1, value2, "property247");
            return (Criteria) this;
        }

        public Criteria andProperty248IsNull() {
            addCriterion("PROPERTY248 is null");
            return (Criteria) this;
        }

        public Criteria andProperty248IsNotNull() {
            addCriterion("PROPERTY248 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty248EqualTo(Date value) {
            addCriterion("PROPERTY248 =", value, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248NotEqualTo(Date value) {
            addCriterion("PROPERTY248 <>", value, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248GreaterThan(Date value) {
            addCriterion("PROPERTY248 >", value, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY248 >=", value, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248LessThan(Date value) {
            addCriterion("PROPERTY248 <", value, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY248 <=", value, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248In(List<Date> values) {
            addCriterion("PROPERTY248 in", values, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248NotIn(List<Date> values) {
            addCriterion("PROPERTY248 not in", values, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248Between(Date value1, Date value2) {
            addCriterion("PROPERTY248 between", value1, value2, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty248NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY248 not between", value1, value2, "property248");
            return (Criteria) this;
        }

        public Criteria andProperty249IsNull() {
            addCriterion("PROPERTY249 is null");
            return (Criteria) this;
        }

        public Criteria andProperty249IsNotNull() {
            addCriterion("PROPERTY249 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty249EqualTo(Date value) {
            addCriterion("PROPERTY249 =", value, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249NotEqualTo(Date value) {
            addCriterion("PROPERTY249 <>", value, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249GreaterThan(Date value) {
            addCriterion("PROPERTY249 >", value, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY249 >=", value, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249LessThan(Date value) {
            addCriterion("PROPERTY249 <", value, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY249 <=", value, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249In(List<Date> values) {
            addCriterion("PROPERTY249 in", values, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249NotIn(List<Date> values) {
            addCriterion("PROPERTY249 not in", values, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249Between(Date value1, Date value2) {
            addCriterion("PROPERTY249 between", value1, value2, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty249NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY249 not between", value1, value2, "property249");
            return (Criteria) this;
        }

        public Criteria andProperty250IsNull() {
            addCriterion("PROPERTY250 is null");
            return (Criteria) this;
        }

        public Criteria andProperty250IsNotNull() {
            addCriterion("PROPERTY250 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty250EqualTo(Date value) {
            addCriterion("PROPERTY250 =", value, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250NotEqualTo(Date value) {
            addCriterion("PROPERTY250 <>", value, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250GreaterThan(Date value) {
            addCriterion("PROPERTY250 >", value, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY250 >=", value, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250LessThan(Date value) {
            addCriterion("PROPERTY250 <", value, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY250 <=", value, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250In(List<Date> values) {
            addCriterion("PROPERTY250 in", values, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250NotIn(List<Date> values) {
            addCriterion("PROPERTY250 not in", values, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250Between(Date value1, Date value2) {
            addCriterion("PROPERTY250 between", value1, value2, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty250NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY250 not between", value1, value2, "property250");
            return (Criteria) this;
        }

        public Criteria andProperty251IsNull() {
            addCriterion("PROPERTY251 is null");
            return (Criteria) this;
        }

        public Criteria andProperty251IsNotNull() {
            addCriterion("PROPERTY251 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty251EqualTo(Date value) {
            addCriterion("PROPERTY251 =", value, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251NotEqualTo(Date value) {
            addCriterion("PROPERTY251 <>", value, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251GreaterThan(Date value) {
            addCriterion("PROPERTY251 >", value, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY251 >=", value, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251LessThan(Date value) {
            addCriterion("PROPERTY251 <", value, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY251 <=", value, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251In(List<Date> values) {
            addCriterion("PROPERTY251 in", values, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251NotIn(List<Date> values) {
            addCriterion("PROPERTY251 not in", values, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251Between(Date value1, Date value2) {
            addCriterion("PROPERTY251 between", value1, value2, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty251NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY251 not between", value1, value2, "property251");
            return (Criteria) this;
        }

        public Criteria andProperty252IsNull() {
            addCriterion("PROPERTY252 is null");
            return (Criteria) this;
        }

        public Criteria andProperty252IsNotNull() {
            addCriterion("PROPERTY252 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty252EqualTo(Date value) {
            addCriterion("PROPERTY252 =", value, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252NotEqualTo(Date value) {
            addCriterion("PROPERTY252 <>", value, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252GreaterThan(Date value) {
            addCriterion("PROPERTY252 >", value, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY252 >=", value, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252LessThan(Date value) {
            addCriterion("PROPERTY252 <", value, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY252 <=", value, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252In(List<Date> values) {
            addCriterion("PROPERTY252 in", values, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252NotIn(List<Date> values) {
            addCriterion("PROPERTY252 not in", values, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252Between(Date value1, Date value2) {
            addCriterion("PROPERTY252 between", value1, value2, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty252NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY252 not between", value1, value2, "property252");
            return (Criteria) this;
        }

        public Criteria andProperty253IsNull() {
            addCriterion("PROPERTY253 is null");
            return (Criteria) this;
        }

        public Criteria andProperty253IsNotNull() {
            addCriterion("PROPERTY253 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty253EqualTo(Date value) {
            addCriterion("PROPERTY253 =", value, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253NotEqualTo(Date value) {
            addCriterion("PROPERTY253 <>", value, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253GreaterThan(Date value) {
            addCriterion("PROPERTY253 >", value, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY253 >=", value, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253LessThan(Date value) {
            addCriterion("PROPERTY253 <", value, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY253 <=", value, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253In(List<Date> values) {
            addCriterion("PROPERTY253 in", values, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253NotIn(List<Date> values) {
            addCriterion("PROPERTY253 not in", values, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253Between(Date value1, Date value2) {
            addCriterion("PROPERTY253 between", value1, value2, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty253NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY253 not between", value1, value2, "property253");
            return (Criteria) this;
        }

        public Criteria andProperty254IsNull() {
            addCriterion("PROPERTY254 is null");
            return (Criteria) this;
        }

        public Criteria andProperty254IsNotNull() {
            addCriterion("PROPERTY254 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty254EqualTo(Date value) {
            addCriterion("PROPERTY254 =", value, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254NotEqualTo(Date value) {
            addCriterion("PROPERTY254 <>", value, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254GreaterThan(Date value) {
            addCriterion("PROPERTY254 >", value, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY254 >=", value, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254LessThan(Date value) {
            addCriterion("PROPERTY254 <", value, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY254 <=", value, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254In(List<Date> values) {
            addCriterion("PROPERTY254 in", values, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254NotIn(List<Date> values) {
            addCriterion("PROPERTY254 not in", values, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254Between(Date value1, Date value2) {
            addCriterion("PROPERTY254 between", value1, value2, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty254NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY254 not between", value1, value2, "property254");
            return (Criteria) this;
        }

        public Criteria andProperty255IsNull() {
            addCriterion("PROPERTY255 is null");
            return (Criteria) this;
        }

        public Criteria andProperty255IsNotNull() {
            addCriterion("PROPERTY255 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty255EqualTo(Date value) {
            addCriterion("PROPERTY255 =", value, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255NotEqualTo(Date value) {
            addCriterion("PROPERTY255 <>", value, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255GreaterThan(Date value) {
            addCriterion("PROPERTY255 >", value, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY255 >=", value, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255LessThan(Date value) {
            addCriterion("PROPERTY255 <", value, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY255 <=", value, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255In(List<Date> values) {
            addCriterion("PROPERTY255 in", values, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255NotIn(List<Date> values) {
            addCriterion("PROPERTY255 not in", values, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255Between(Date value1, Date value2) {
            addCriterion("PROPERTY255 between", value1, value2, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty255NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY255 not between", value1, value2, "property255");
            return (Criteria) this;
        }

        public Criteria andProperty256IsNull() {
            addCriterion("PROPERTY256 is null");
            return (Criteria) this;
        }

        public Criteria andProperty256IsNotNull() {
            addCriterion("PROPERTY256 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty256EqualTo(Date value) {
            addCriterion("PROPERTY256 =", value, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256NotEqualTo(Date value) {
            addCriterion("PROPERTY256 <>", value, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256GreaterThan(Date value) {
            addCriterion("PROPERTY256 >", value, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY256 >=", value, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256LessThan(Date value) {
            addCriterion("PROPERTY256 <", value, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY256 <=", value, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256In(List<Date> values) {
            addCriterion("PROPERTY256 in", values, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256NotIn(List<Date> values) {
            addCriterion("PROPERTY256 not in", values, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256Between(Date value1, Date value2) {
            addCriterion("PROPERTY256 between", value1, value2, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty256NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY256 not between", value1, value2, "property256");
            return (Criteria) this;
        }

        public Criteria andProperty257IsNull() {
            addCriterion("PROPERTY257 is null");
            return (Criteria) this;
        }

        public Criteria andProperty257IsNotNull() {
            addCriterion("PROPERTY257 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty257EqualTo(Date value) {
            addCriterion("PROPERTY257 =", value, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257NotEqualTo(Date value) {
            addCriterion("PROPERTY257 <>", value, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257GreaterThan(Date value) {
            addCriterion("PROPERTY257 >", value, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY257 >=", value, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257LessThan(Date value) {
            addCriterion("PROPERTY257 <", value, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY257 <=", value, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257In(List<Date> values) {
            addCriterion("PROPERTY257 in", values, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257NotIn(List<Date> values) {
            addCriterion("PROPERTY257 not in", values, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257Between(Date value1, Date value2) {
            addCriterion("PROPERTY257 between", value1, value2, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty257NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY257 not between", value1, value2, "property257");
            return (Criteria) this;
        }

        public Criteria andProperty258IsNull() {
            addCriterion("PROPERTY258 is null");
            return (Criteria) this;
        }

        public Criteria andProperty258IsNotNull() {
            addCriterion("PROPERTY258 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty258EqualTo(Date value) {
            addCriterion("PROPERTY258 =", value, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258NotEqualTo(Date value) {
            addCriterion("PROPERTY258 <>", value, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258GreaterThan(Date value) {
            addCriterion("PROPERTY258 >", value, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY258 >=", value, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258LessThan(Date value) {
            addCriterion("PROPERTY258 <", value, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY258 <=", value, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258In(List<Date> values) {
            addCriterion("PROPERTY258 in", values, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258NotIn(List<Date> values) {
            addCriterion("PROPERTY258 not in", values, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258Between(Date value1, Date value2) {
            addCriterion("PROPERTY258 between", value1, value2, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty258NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY258 not between", value1, value2, "property258");
            return (Criteria) this;
        }

        public Criteria andProperty259IsNull() {
            addCriterion("PROPERTY259 is null");
            return (Criteria) this;
        }

        public Criteria andProperty259IsNotNull() {
            addCriterion("PROPERTY259 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty259EqualTo(Date value) {
            addCriterion("PROPERTY259 =", value, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259NotEqualTo(Date value) {
            addCriterion("PROPERTY259 <>", value, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259GreaterThan(Date value) {
            addCriterion("PROPERTY259 >", value, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY259 >=", value, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259LessThan(Date value) {
            addCriterion("PROPERTY259 <", value, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY259 <=", value, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259In(List<Date> values) {
            addCriterion("PROPERTY259 in", values, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259NotIn(List<Date> values) {
            addCriterion("PROPERTY259 not in", values, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259Between(Date value1, Date value2) {
            addCriterion("PROPERTY259 between", value1, value2, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty259NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY259 not between", value1, value2, "property259");
            return (Criteria) this;
        }

        public Criteria andProperty260IsNull() {
            addCriterion("PROPERTY260 is null");
            return (Criteria) this;
        }

        public Criteria andProperty260IsNotNull() {
            addCriterion("PROPERTY260 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty260EqualTo(Date value) {
            addCriterion("PROPERTY260 =", value, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260NotEqualTo(Date value) {
            addCriterion("PROPERTY260 <>", value, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260GreaterThan(Date value) {
            addCriterion("PROPERTY260 >", value, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY260 >=", value, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260LessThan(Date value) {
            addCriterion("PROPERTY260 <", value, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY260 <=", value, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260In(List<Date> values) {
            addCriterion("PROPERTY260 in", values, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260NotIn(List<Date> values) {
            addCriterion("PROPERTY260 not in", values, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260Between(Date value1, Date value2) {
            addCriterion("PROPERTY260 between", value1, value2, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty260NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY260 not between", value1, value2, "property260");
            return (Criteria) this;
        }

        public Criteria andProperty261IsNull() {
            addCriterion("PROPERTY261 is null");
            return (Criteria) this;
        }

        public Criteria andProperty261IsNotNull() {
            addCriterion("PROPERTY261 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty261EqualTo(Date value) {
            addCriterion("PROPERTY261 =", value, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261NotEqualTo(Date value) {
            addCriterion("PROPERTY261 <>", value, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261GreaterThan(Date value) {
            addCriterion("PROPERTY261 >", value, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY261 >=", value, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261LessThan(Date value) {
            addCriterion("PROPERTY261 <", value, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY261 <=", value, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261In(List<Date> values) {
            addCriterion("PROPERTY261 in", values, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261NotIn(List<Date> values) {
            addCriterion("PROPERTY261 not in", values, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261Between(Date value1, Date value2) {
            addCriterion("PROPERTY261 between", value1, value2, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty261NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY261 not between", value1, value2, "property261");
            return (Criteria) this;
        }

        public Criteria andProperty262IsNull() {
            addCriterion("PROPERTY262 is null");
            return (Criteria) this;
        }

        public Criteria andProperty262IsNotNull() {
            addCriterion("PROPERTY262 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty262EqualTo(Date value) {
            addCriterion("PROPERTY262 =", value, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262NotEqualTo(Date value) {
            addCriterion("PROPERTY262 <>", value, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262GreaterThan(Date value) {
            addCriterion("PROPERTY262 >", value, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY262 >=", value, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262LessThan(Date value) {
            addCriterion("PROPERTY262 <", value, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY262 <=", value, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262In(List<Date> values) {
            addCriterion("PROPERTY262 in", values, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262NotIn(List<Date> values) {
            addCriterion("PROPERTY262 not in", values, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262Between(Date value1, Date value2) {
            addCriterion("PROPERTY262 between", value1, value2, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty262NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY262 not between", value1, value2, "property262");
            return (Criteria) this;
        }

        public Criteria andProperty263IsNull() {
            addCriterion("PROPERTY263 is null");
            return (Criteria) this;
        }

        public Criteria andProperty263IsNotNull() {
            addCriterion("PROPERTY263 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty263EqualTo(Date value) {
            addCriterion("PROPERTY263 =", value, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263NotEqualTo(Date value) {
            addCriterion("PROPERTY263 <>", value, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263GreaterThan(Date value) {
            addCriterion("PROPERTY263 >", value, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY263 >=", value, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263LessThan(Date value) {
            addCriterion("PROPERTY263 <", value, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY263 <=", value, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263In(List<Date> values) {
            addCriterion("PROPERTY263 in", values, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263NotIn(List<Date> values) {
            addCriterion("PROPERTY263 not in", values, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263Between(Date value1, Date value2) {
            addCriterion("PROPERTY263 between", value1, value2, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty263NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY263 not between", value1, value2, "property263");
            return (Criteria) this;
        }

        public Criteria andProperty264IsNull() {
            addCriterion("PROPERTY264 is null");
            return (Criteria) this;
        }

        public Criteria andProperty264IsNotNull() {
            addCriterion("PROPERTY264 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty264EqualTo(Date value) {
            addCriterion("PROPERTY264 =", value, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264NotEqualTo(Date value) {
            addCriterion("PROPERTY264 <>", value, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264GreaterThan(Date value) {
            addCriterion("PROPERTY264 >", value, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY264 >=", value, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264LessThan(Date value) {
            addCriterion("PROPERTY264 <", value, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY264 <=", value, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264In(List<Date> values) {
            addCriterion("PROPERTY264 in", values, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264NotIn(List<Date> values) {
            addCriterion("PROPERTY264 not in", values, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264Between(Date value1, Date value2) {
            addCriterion("PROPERTY264 between", value1, value2, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty264NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY264 not between", value1, value2, "property264");
            return (Criteria) this;
        }

        public Criteria andProperty265IsNull() {
            addCriterion("PROPERTY265 is null");
            return (Criteria) this;
        }

        public Criteria andProperty265IsNotNull() {
            addCriterion("PROPERTY265 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty265EqualTo(Date value) {
            addCriterion("PROPERTY265 =", value, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265NotEqualTo(Date value) {
            addCriterion("PROPERTY265 <>", value, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265GreaterThan(Date value) {
            addCriterion("PROPERTY265 >", value, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY265 >=", value, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265LessThan(Date value) {
            addCriterion("PROPERTY265 <", value, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY265 <=", value, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265In(List<Date> values) {
            addCriterion("PROPERTY265 in", values, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265NotIn(List<Date> values) {
            addCriterion("PROPERTY265 not in", values, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265Between(Date value1, Date value2) {
            addCriterion("PROPERTY265 between", value1, value2, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty265NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY265 not between", value1, value2, "property265");
            return (Criteria) this;
        }

        public Criteria andProperty266IsNull() {
            addCriterion("PROPERTY266 is null");
            return (Criteria) this;
        }

        public Criteria andProperty266IsNotNull() {
            addCriterion("PROPERTY266 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty266EqualTo(Date value) {
            addCriterion("PROPERTY266 =", value, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266NotEqualTo(Date value) {
            addCriterion("PROPERTY266 <>", value, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266GreaterThan(Date value) {
            addCriterion("PROPERTY266 >", value, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY266 >=", value, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266LessThan(Date value) {
            addCriterion("PROPERTY266 <", value, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY266 <=", value, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266In(List<Date> values) {
            addCriterion("PROPERTY266 in", values, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266NotIn(List<Date> values) {
            addCriterion("PROPERTY266 not in", values, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266Between(Date value1, Date value2) {
            addCriterion("PROPERTY266 between", value1, value2, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty266NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY266 not between", value1, value2, "property266");
            return (Criteria) this;
        }

        public Criteria andProperty267IsNull() {
            addCriterion("PROPERTY267 is null");
            return (Criteria) this;
        }

        public Criteria andProperty267IsNotNull() {
            addCriterion("PROPERTY267 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty267EqualTo(Date value) {
            addCriterion("PROPERTY267 =", value, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267NotEqualTo(Date value) {
            addCriterion("PROPERTY267 <>", value, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267GreaterThan(Date value) {
            addCriterion("PROPERTY267 >", value, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY267 >=", value, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267LessThan(Date value) {
            addCriterion("PROPERTY267 <", value, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY267 <=", value, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267In(List<Date> values) {
            addCriterion("PROPERTY267 in", values, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267NotIn(List<Date> values) {
            addCriterion("PROPERTY267 not in", values, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267Between(Date value1, Date value2) {
            addCriterion("PROPERTY267 between", value1, value2, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty267NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY267 not between", value1, value2, "property267");
            return (Criteria) this;
        }

        public Criteria andProperty268IsNull() {
            addCriterion("PROPERTY268 is null");
            return (Criteria) this;
        }

        public Criteria andProperty268IsNotNull() {
            addCriterion("PROPERTY268 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty268EqualTo(Date value) {
            addCriterion("PROPERTY268 =", value, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268NotEqualTo(Date value) {
            addCriterion("PROPERTY268 <>", value, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268GreaterThan(Date value) {
            addCriterion("PROPERTY268 >", value, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY268 >=", value, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268LessThan(Date value) {
            addCriterion("PROPERTY268 <", value, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY268 <=", value, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268In(List<Date> values) {
            addCriterion("PROPERTY268 in", values, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268NotIn(List<Date> values) {
            addCriterion("PROPERTY268 not in", values, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268Between(Date value1, Date value2) {
            addCriterion("PROPERTY268 between", value1, value2, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty268NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY268 not between", value1, value2, "property268");
            return (Criteria) this;
        }

        public Criteria andProperty269IsNull() {
            addCriterion("PROPERTY269 is null");
            return (Criteria) this;
        }

        public Criteria andProperty269IsNotNull() {
            addCriterion("PROPERTY269 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty269EqualTo(Date value) {
            addCriterion("PROPERTY269 =", value, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269NotEqualTo(Date value) {
            addCriterion("PROPERTY269 <>", value, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269GreaterThan(Date value) {
            addCriterion("PROPERTY269 >", value, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY269 >=", value, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269LessThan(Date value) {
            addCriterion("PROPERTY269 <", value, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY269 <=", value, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269In(List<Date> values) {
            addCriterion("PROPERTY269 in", values, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269NotIn(List<Date> values) {
            addCriterion("PROPERTY269 not in", values, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269Between(Date value1, Date value2) {
            addCriterion("PROPERTY269 between", value1, value2, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty269NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY269 not between", value1, value2, "property269");
            return (Criteria) this;
        }

        public Criteria andProperty270IsNull() {
            addCriterion("PROPERTY270 is null");
            return (Criteria) this;
        }

        public Criteria andProperty270IsNotNull() {
            addCriterion("PROPERTY270 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty270EqualTo(Date value) {
            addCriterion("PROPERTY270 =", value, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270NotEqualTo(Date value) {
            addCriterion("PROPERTY270 <>", value, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270GreaterThan(Date value) {
            addCriterion("PROPERTY270 >", value, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY270 >=", value, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270LessThan(Date value) {
            addCriterion("PROPERTY270 <", value, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY270 <=", value, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270In(List<Date> values) {
            addCriterion("PROPERTY270 in", values, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270NotIn(List<Date> values) {
            addCriterion("PROPERTY270 not in", values, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270Between(Date value1, Date value2) {
            addCriterion("PROPERTY270 between", value1, value2, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty270NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY270 not between", value1, value2, "property270");
            return (Criteria) this;
        }

        public Criteria andProperty271IsNull() {
            addCriterion("PROPERTY271 is null");
            return (Criteria) this;
        }

        public Criteria andProperty271IsNotNull() {
            addCriterion("PROPERTY271 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty271EqualTo(Date value) {
            addCriterion("PROPERTY271 =", value, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271NotEqualTo(Date value) {
            addCriterion("PROPERTY271 <>", value, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271GreaterThan(Date value) {
            addCriterion("PROPERTY271 >", value, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY271 >=", value, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271LessThan(Date value) {
            addCriterion("PROPERTY271 <", value, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY271 <=", value, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271In(List<Date> values) {
            addCriterion("PROPERTY271 in", values, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271NotIn(List<Date> values) {
            addCriterion("PROPERTY271 not in", values, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271Between(Date value1, Date value2) {
            addCriterion("PROPERTY271 between", value1, value2, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty271NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY271 not between", value1, value2, "property271");
            return (Criteria) this;
        }

        public Criteria andProperty272IsNull() {
            addCriterion("PROPERTY272 is null");
            return (Criteria) this;
        }

        public Criteria andProperty272IsNotNull() {
            addCriterion("PROPERTY272 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty272EqualTo(Date value) {
            addCriterion("PROPERTY272 =", value, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272NotEqualTo(Date value) {
            addCriterion("PROPERTY272 <>", value, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272GreaterThan(Date value) {
            addCriterion("PROPERTY272 >", value, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY272 >=", value, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272LessThan(Date value) {
            addCriterion("PROPERTY272 <", value, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY272 <=", value, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272In(List<Date> values) {
            addCriterion("PROPERTY272 in", values, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272NotIn(List<Date> values) {
            addCriterion("PROPERTY272 not in", values, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272Between(Date value1, Date value2) {
            addCriterion("PROPERTY272 between", value1, value2, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty272NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY272 not between", value1, value2, "property272");
            return (Criteria) this;
        }

        public Criteria andProperty273IsNull() {
            addCriterion("PROPERTY273 is null");
            return (Criteria) this;
        }

        public Criteria andProperty273IsNotNull() {
            addCriterion("PROPERTY273 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty273EqualTo(Date value) {
            addCriterion("PROPERTY273 =", value, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273NotEqualTo(Date value) {
            addCriterion("PROPERTY273 <>", value, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273GreaterThan(Date value) {
            addCriterion("PROPERTY273 >", value, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY273 >=", value, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273LessThan(Date value) {
            addCriterion("PROPERTY273 <", value, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY273 <=", value, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273In(List<Date> values) {
            addCriterion("PROPERTY273 in", values, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273NotIn(List<Date> values) {
            addCriterion("PROPERTY273 not in", values, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273Between(Date value1, Date value2) {
            addCriterion("PROPERTY273 between", value1, value2, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty273NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY273 not between", value1, value2, "property273");
            return (Criteria) this;
        }

        public Criteria andProperty274IsNull() {
            addCriterion("PROPERTY274 is null");
            return (Criteria) this;
        }

        public Criteria andProperty274IsNotNull() {
            addCriterion("PROPERTY274 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty274EqualTo(Date value) {
            addCriterion("PROPERTY274 =", value, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274NotEqualTo(Date value) {
            addCriterion("PROPERTY274 <>", value, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274GreaterThan(Date value) {
            addCriterion("PROPERTY274 >", value, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY274 >=", value, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274LessThan(Date value) {
            addCriterion("PROPERTY274 <", value, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY274 <=", value, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274In(List<Date> values) {
            addCriterion("PROPERTY274 in", values, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274NotIn(List<Date> values) {
            addCriterion("PROPERTY274 not in", values, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274Between(Date value1, Date value2) {
            addCriterion("PROPERTY274 between", value1, value2, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty274NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY274 not between", value1, value2, "property274");
            return (Criteria) this;
        }

        public Criteria andProperty275IsNull() {
            addCriterion("PROPERTY275 is null");
            return (Criteria) this;
        }

        public Criteria andProperty275IsNotNull() {
            addCriterion("PROPERTY275 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty275EqualTo(Date value) {
            addCriterion("PROPERTY275 =", value, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275NotEqualTo(Date value) {
            addCriterion("PROPERTY275 <>", value, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275GreaterThan(Date value) {
            addCriterion("PROPERTY275 >", value, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY275 >=", value, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275LessThan(Date value) {
            addCriterion("PROPERTY275 <", value, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY275 <=", value, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275In(List<Date> values) {
            addCriterion("PROPERTY275 in", values, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275NotIn(List<Date> values) {
            addCriterion("PROPERTY275 not in", values, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275Between(Date value1, Date value2) {
            addCriterion("PROPERTY275 between", value1, value2, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty275NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY275 not between", value1, value2, "property275");
            return (Criteria) this;
        }

        public Criteria andProperty276IsNull() {
            addCriterion("PROPERTY276 is null");
            return (Criteria) this;
        }

        public Criteria andProperty276IsNotNull() {
            addCriterion("PROPERTY276 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty276EqualTo(Date value) {
            addCriterion("PROPERTY276 =", value, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276NotEqualTo(Date value) {
            addCriterion("PROPERTY276 <>", value, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276GreaterThan(Date value) {
            addCriterion("PROPERTY276 >", value, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY276 >=", value, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276LessThan(Date value) {
            addCriterion("PROPERTY276 <", value, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY276 <=", value, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276In(List<Date> values) {
            addCriterion("PROPERTY276 in", values, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276NotIn(List<Date> values) {
            addCriterion("PROPERTY276 not in", values, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276Between(Date value1, Date value2) {
            addCriterion("PROPERTY276 between", value1, value2, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty276NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY276 not between", value1, value2, "property276");
            return (Criteria) this;
        }

        public Criteria andProperty277IsNull() {
            addCriterion("PROPERTY277 is null");
            return (Criteria) this;
        }

        public Criteria andProperty277IsNotNull() {
            addCriterion("PROPERTY277 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty277EqualTo(Date value) {
            addCriterion("PROPERTY277 =", value, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277NotEqualTo(Date value) {
            addCriterion("PROPERTY277 <>", value, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277GreaterThan(Date value) {
            addCriterion("PROPERTY277 >", value, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY277 >=", value, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277LessThan(Date value) {
            addCriterion("PROPERTY277 <", value, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY277 <=", value, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277In(List<Date> values) {
            addCriterion("PROPERTY277 in", values, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277NotIn(List<Date> values) {
            addCriterion("PROPERTY277 not in", values, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277Between(Date value1, Date value2) {
            addCriterion("PROPERTY277 between", value1, value2, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty277NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY277 not between", value1, value2, "property277");
            return (Criteria) this;
        }

        public Criteria andProperty278IsNull() {
            addCriterion("PROPERTY278 is null");
            return (Criteria) this;
        }

        public Criteria andProperty278IsNotNull() {
            addCriterion("PROPERTY278 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty278EqualTo(Date value) {
            addCriterion("PROPERTY278 =", value, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278NotEqualTo(Date value) {
            addCriterion("PROPERTY278 <>", value, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278GreaterThan(Date value) {
            addCriterion("PROPERTY278 >", value, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY278 >=", value, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278LessThan(Date value) {
            addCriterion("PROPERTY278 <", value, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY278 <=", value, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278In(List<Date> values) {
            addCriterion("PROPERTY278 in", values, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278NotIn(List<Date> values) {
            addCriterion("PROPERTY278 not in", values, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278Between(Date value1, Date value2) {
            addCriterion("PROPERTY278 between", value1, value2, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty278NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY278 not between", value1, value2, "property278");
            return (Criteria) this;
        }

        public Criteria andProperty279IsNull() {
            addCriterion("PROPERTY279 is null");
            return (Criteria) this;
        }

        public Criteria andProperty279IsNotNull() {
            addCriterion("PROPERTY279 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty279EqualTo(Date value) {
            addCriterion("PROPERTY279 =", value, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279NotEqualTo(Date value) {
            addCriterion("PROPERTY279 <>", value, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279GreaterThan(Date value) {
            addCriterion("PROPERTY279 >", value, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY279 >=", value, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279LessThan(Date value) {
            addCriterion("PROPERTY279 <", value, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY279 <=", value, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279In(List<Date> values) {
            addCriterion("PROPERTY279 in", values, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279NotIn(List<Date> values) {
            addCriterion("PROPERTY279 not in", values, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279Between(Date value1, Date value2) {
            addCriterion("PROPERTY279 between", value1, value2, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty279NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY279 not between", value1, value2, "property279");
            return (Criteria) this;
        }

        public Criteria andProperty280IsNull() {
            addCriterion("PROPERTY280 is null");
            return (Criteria) this;
        }

        public Criteria andProperty280IsNotNull() {
            addCriterion("PROPERTY280 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty280EqualTo(Date value) {
            addCriterion("PROPERTY280 =", value, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280NotEqualTo(Date value) {
            addCriterion("PROPERTY280 <>", value, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280GreaterThan(Date value) {
            addCriterion("PROPERTY280 >", value, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY280 >=", value, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280LessThan(Date value) {
            addCriterion("PROPERTY280 <", value, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY280 <=", value, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280In(List<Date> values) {
            addCriterion("PROPERTY280 in", values, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280NotIn(List<Date> values) {
            addCriterion("PROPERTY280 not in", values, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280Between(Date value1, Date value2) {
            addCriterion("PROPERTY280 between", value1, value2, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty280NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY280 not between", value1, value2, "property280");
            return (Criteria) this;
        }

        public Criteria andProperty281IsNull() {
            addCriterion("PROPERTY281 is null");
            return (Criteria) this;
        }

        public Criteria andProperty281IsNotNull() {
            addCriterion("PROPERTY281 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty281EqualTo(Date value) {
            addCriterion("PROPERTY281 =", value, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281NotEqualTo(Date value) {
            addCriterion("PROPERTY281 <>", value, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281GreaterThan(Date value) {
            addCriterion("PROPERTY281 >", value, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY281 >=", value, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281LessThan(Date value) {
            addCriterion("PROPERTY281 <", value, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY281 <=", value, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281In(List<Date> values) {
            addCriterion("PROPERTY281 in", values, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281NotIn(List<Date> values) {
            addCriterion("PROPERTY281 not in", values, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281Between(Date value1, Date value2) {
            addCriterion("PROPERTY281 between", value1, value2, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty281NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY281 not between", value1, value2, "property281");
            return (Criteria) this;
        }

        public Criteria andProperty282IsNull() {
            addCriterion("PROPERTY282 is null");
            return (Criteria) this;
        }

        public Criteria andProperty282IsNotNull() {
            addCriterion("PROPERTY282 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty282EqualTo(Date value) {
            addCriterion("PROPERTY282 =", value, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282NotEqualTo(Date value) {
            addCriterion("PROPERTY282 <>", value, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282GreaterThan(Date value) {
            addCriterion("PROPERTY282 >", value, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY282 >=", value, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282LessThan(Date value) {
            addCriterion("PROPERTY282 <", value, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY282 <=", value, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282In(List<Date> values) {
            addCriterion("PROPERTY282 in", values, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282NotIn(List<Date> values) {
            addCriterion("PROPERTY282 not in", values, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282Between(Date value1, Date value2) {
            addCriterion("PROPERTY282 between", value1, value2, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty282NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY282 not between", value1, value2, "property282");
            return (Criteria) this;
        }

        public Criteria andProperty283IsNull() {
            addCriterion("PROPERTY283 is null");
            return (Criteria) this;
        }

        public Criteria andProperty283IsNotNull() {
            addCriterion("PROPERTY283 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty283EqualTo(Date value) {
            addCriterion("PROPERTY283 =", value, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283NotEqualTo(Date value) {
            addCriterion("PROPERTY283 <>", value, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283GreaterThan(Date value) {
            addCriterion("PROPERTY283 >", value, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY283 >=", value, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283LessThan(Date value) {
            addCriterion("PROPERTY283 <", value, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY283 <=", value, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283In(List<Date> values) {
            addCriterion("PROPERTY283 in", values, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283NotIn(List<Date> values) {
            addCriterion("PROPERTY283 not in", values, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283Between(Date value1, Date value2) {
            addCriterion("PROPERTY283 between", value1, value2, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty283NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY283 not between", value1, value2, "property283");
            return (Criteria) this;
        }

        public Criteria andProperty284IsNull() {
            addCriterion("PROPERTY284 is null");
            return (Criteria) this;
        }

        public Criteria andProperty284IsNotNull() {
            addCriterion("PROPERTY284 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty284EqualTo(Date value) {
            addCriterion("PROPERTY284 =", value, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284NotEqualTo(Date value) {
            addCriterion("PROPERTY284 <>", value, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284GreaterThan(Date value) {
            addCriterion("PROPERTY284 >", value, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY284 >=", value, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284LessThan(Date value) {
            addCriterion("PROPERTY284 <", value, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY284 <=", value, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284In(List<Date> values) {
            addCriterion("PROPERTY284 in", values, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284NotIn(List<Date> values) {
            addCriterion("PROPERTY284 not in", values, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284Between(Date value1, Date value2) {
            addCriterion("PROPERTY284 between", value1, value2, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty284NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY284 not between", value1, value2, "property284");
            return (Criteria) this;
        }

        public Criteria andProperty285IsNull() {
            addCriterion("PROPERTY285 is null");
            return (Criteria) this;
        }

        public Criteria andProperty285IsNotNull() {
            addCriterion("PROPERTY285 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty285EqualTo(Date value) {
            addCriterion("PROPERTY285 =", value, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285NotEqualTo(Date value) {
            addCriterion("PROPERTY285 <>", value, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285GreaterThan(Date value) {
            addCriterion("PROPERTY285 >", value, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY285 >=", value, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285LessThan(Date value) {
            addCriterion("PROPERTY285 <", value, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY285 <=", value, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285In(List<Date> values) {
            addCriterion("PROPERTY285 in", values, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285NotIn(List<Date> values) {
            addCriterion("PROPERTY285 not in", values, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285Between(Date value1, Date value2) {
            addCriterion("PROPERTY285 between", value1, value2, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty285NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY285 not between", value1, value2, "property285");
            return (Criteria) this;
        }

        public Criteria andProperty286IsNull() {
            addCriterion("PROPERTY286 is null");
            return (Criteria) this;
        }

        public Criteria andProperty286IsNotNull() {
            addCriterion("PROPERTY286 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty286EqualTo(Date value) {
            addCriterion("PROPERTY286 =", value, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286NotEqualTo(Date value) {
            addCriterion("PROPERTY286 <>", value, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286GreaterThan(Date value) {
            addCriterion("PROPERTY286 >", value, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY286 >=", value, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286LessThan(Date value) {
            addCriterion("PROPERTY286 <", value, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY286 <=", value, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286In(List<Date> values) {
            addCriterion("PROPERTY286 in", values, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286NotIn(List<Date> values) {
            addCriterion("PROPERTY286 not in", values, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286Between(Date value1, Date value2) {
            addCriterion("PROPERTY286 between", value1, value2, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty286NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY286 not between", value1, value2, "property286");
            return (Criteria) this;
        }

        public Criteria andProperty287IsNull() {
            addCriterion("PROPERTY287 is null");
            return (Criteria) this;
        }

        public Criteria andProperty287IsNotNull() {
            addCriterion("PROPERTY287 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty287EqualTo(Date value) {
            addCriterion("PROPERTY287 =", value, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287NotEqualTo(Date value) {
            addCriterion("PROPERTY287 <>", value, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287GreaterThan(Date value) {
            addCriterion("PROPERTY287 >", value, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY287 >=", value, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287LessThan(Date value) {
            addCriterion("PROPERTY287 <", value, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY287 <=", value, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287In(List<Date> values) {
            addCriterion("PROPERTY287 in", values, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287NotIn(List<Date> values) {
            addCriterion("PROPERTY287 not in", values, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287Between(Date value1, Date value2) {
            addCriterion("PROPERTY287 between", value1, value2, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty287NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY287 not between", value1, value2, "property287");
            return (Criteria) this;
        }

        public Criteria andProperty288IsNull() {
            addCriterion("PROPERTY288 is null");
            return (Criteria) this;
        }

        public Criteria andProperty288IsNotNull() {
            addCriterion("PROPERTY288 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty288EqualTo(Date value) {
            addCriterion("PROPERTY288 =", value, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288NotEqualTo(Date value) {
            addCriterion("PROPERTY288 <>", value, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288GreaterThan(Date value) {
            addCriterion("PROPERTY288 >", value, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY288 >=", value, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288LessThan(Date value) {
            addCriterion("PROPERTY288 <", value, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY288 <=", value, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288In(List<Date> values) {
            addCriterion("PROPERTY288 in", values, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288NotIn(List<Date> values) {
            addCriterion("PROPERTY288 not in", values, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288Between(Date value1, Date value2) {
            addCriterion("PROPERTY288 between", value1, value2, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty288NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY288 not between", value1, value2, "property288");
            return (Criteria) this;
        }

        public Criteria andProperty289IsNull() {
            addCriterion("PROPERTY289 is null");
            return (Criteria) this;
        }

        public Criteria andProperty289IsNotNull() {
            addCriterion("PROPERTY289 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty289EqualTo(Date value) {
            addCriterion("PROPERTY289 =", value, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289NotEqualTo(Date value) {
            addCriterion("PROPERTY289 <>", value, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289GreaterThan(Date value) {
            addCriterion("PROPERTY289 >", value, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY289 >=", value, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289LessThan(Date value) {
            addCriterion("PROPERTY289 <", value, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY289 <=", value, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289In(List<Date> values) {
            addCriterion("PROPERTY289 in", values, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289NotIn(List<Date> values) {
            addCriterion("PROPERTY289 not in", values, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289Between(Date value1, Date value2) {
            addCriterion("PROPERTY289 between", value1, value2, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty289NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY289 not between", value1, value2, "property289");
            return (Criteria) this;
        }

        public Criteria andProperty290IsNull() {
            addCriterion("PROPERTY290 is null");
            return (Criteria) this;
        }

        public Criteria andProperty290IsNotNull() {
            addCriterion("PROPERTY290 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty290EqualTo(Date value) {
            addCriterion("PROPERTY290 =", value, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290NotEqualTo(Date value) {
            addCriterion("PROPERTY290 <>", value, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290GreaterThan(Date value) {
            addCriterion("PROPERTY290 >", value, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY290 >=", value, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290LessThan(Date value) {
            addCriterion("PROPERTY290 <", value, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY290 <=", value, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290In(List<Date> values) {
            addCriterion("PROPERTY290 in", values, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290NotIn(List<Date> values) {
            addCriterion("PROPERTY290 not in", values, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290Between(Date value1, Date value2) {
            addCriterion("PROPERTY290 between", value1, value2, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty290NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY290 not between", value1, value2, "property290");
            return (Criteria) this;
        }

        public Criteria andProperty291IsNull() {
            addCriterion("PROPERTY291 is null");
            return (Criteria) this;
        }

        public Criteria andProperty291IsNotNull() {
            addCriterion("PROPERTY291 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty291EqualTo(Date value) {
            addCriterion("PROPERTY291 =", value, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291NotEqualTo(Date value) {
            addCriterion("PROPERTY291 <>", value, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291GreaterThan(Date value) {
            addCriterion("PROPERTY291 >", value, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY291 >=", value, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291LessThan(Date value) {
            addCriterion("PROPERTY291 <", value, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY291 <=", value, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291In(List<Date> values) {
            addCriterion("PROPERTY291 in", values, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291NotIn(List<Date> values) {
            addCriterion("PROPERTY291 not in", values, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291Between(Date value1, Date value2) {
            addCriterion("PROPERTY291 between", value1, value2, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty291NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY291 not between", value1, value2, "property291");
            return (Criteria) this;
        }

        public Criteria andProperty292IsNull() {
            addCriterion("PROPERTY292 is null");
            return (Criteria) this;
        }

        public Criteria andProperty292IsNotNull() {
            addCriterion("PROPERTY292 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty292EqualTo(Date value) {
            addCriterion("PROPERTY292 =", value, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292NotEqualTo(Date value) {
            addCriterion("PROPERTY292 <>", value, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292GreaterThan(Date value) {
            addCriterion("PROPERTY292 >", value, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY292 >=", value, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292LessThan(Date value) {
            addCriterion("PROPERTY292 <", value, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY292 <=", value, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292In(List<Date> values) {
            addCriterion("PROPERTY292 in", values, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292NotIn(List<Date> values) {
            addCriterion("PROPERTY292 not in", values, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292Between(Date value1, Date value2) {
            addCriterion("PROPERTY292 between", value1, value2, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty292NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY292 not between", value1, value2, "property292");
            return (Criteria) this;
        }

        public Criteria andProperty293IsNull() {
            addCriterion("PROPERTY293 is null");
            return (Criteria) this;
        }

        public Criteria andProperty293IsNotNull() {
            addCriterion("PROPERTY293 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty293EqualTo(Date value) {
            addCriterion("PROPERTY293 =", value, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293NotEqualTo(Date value) {
            addCriterion("PROPERTY293 <>", value, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293GreaterThan(Date value) {
            addCriterion("PROPERTY293 >", value, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY293 >=", value, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293LessThan(Date value) {
            addCriterion("PROPERTY293 <", value, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY293 <=", value, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293In(List<Date> values) {
            addCriterion("PROPERTY293 in", values, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293NotIn(List<Date> values) {
            addCriterion("PROPERTY293 not in", values, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293Between(Date value1, Date value2) {
            addCriterion("PROPERTY293 between", value1, value2, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty293NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY293 not between", value1, value2, "property293");
            return (Criteria) this;
        }

        public Criteria andProperty294IsNull() {
            addCriterion("PROPERTY294 is null");
            return (Criteria) this;
        }

        public Criteria andProperty294IsNotNull() {
            addCriterion("PROPERTY294 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty294EqualTo(Date value) {
            addCriterion("PROPERTY294 =", value, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294NotEqualTo(Date value) {
            addCriterion("PROPERTY294 <>", value, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294GreaterThan(Date value) {
            addCriterion("PROPERTY294 >", value, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY294 >=", value, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294LessThan(Date value) {
            addCriterion("PROPERTY294 <", value, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY294 <=", value, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294In(List<Date> values) {
            addCriterion("PROPERTY294 in", values, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294NotIn(List<Date> values) {
            addCriterion("PROPERTY294 not in", values, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294Between(Date value1, Date value2) {
            addCriterion("PROPERTY294 between", value1, value2, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty294NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY294 not between", value1, value2, "property294");
            return (Criteria) this;
        }

        public Criteria andProperty295IsNull() {
            addCriterion("PROPERTY295 is null");
            return (Criteria) this;
        }

        public Criteria andProperty295IsNotNull() {
            addCriterion("PROPERTY295 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty295EqualTo(Date value) {
            addCriterion("PROPERTY295 =", value, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295NotEqualTo(Date value) {
            addCriterion("PROPERTY295 <>", value, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295GreaterThan(Date value) {
            addCriterion("PROPERTY295 >", value, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY295 >=", value, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295LessThan(Date value) {
            addCriterion("PROPERTY295 <", value, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY295 <=", value, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295In(List<Date> values) {
            addCriterion("PROPERTY295 in", values, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295NotIn(List<Date> values) {
            addCriterion("PROPERTY295 not in", values, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295Between(Date value1, Date value2) {
            addCriterion("PROPERTY295 between", value1, value2, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty295NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY295 not between", value1, value2, "property295");
            return (Criteria) this;
        }

        public Criteria andProperty296IsNull() {
            addCriterion("PROPERTY296 is null");
            return (Criteria) this;
        }

        public Criteria andProperty296IsNotNull() {
            addCriterion("PROPERTY296 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty296EqualTo(Date value) {
            addCriterion("PROPERTY296 =", value, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296NotEqualTo(Date value) {
            addCriterion("PROPERTY296 <>", value, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296GreaterThan(Date value) {
            addCriterion("PROPERTY296 >", value, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY296 >=", value, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296LessThan(Date value) {
            addCriterion("PROPERTY296 <", value, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY296 <=", value, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296In(List<Date> values) {
            addCriterion("PROPERTY296 in", values, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296NotIn(List<Date> values) {
            addCriterion("PROPERTY296 not in", values, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296Between(Date value1, Date value2) {
            addCriterion("PROPERTY296 between", value1, value2, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty296NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY296 not between", value1, value2, "property296");
            return (Criteria) this;
        }

        public Criteria andProperty297IsNull() {
            addCriterion("PROPERTY297 is null");
            return (Criteria) this;
        }

        public Criteria andProperty297IsNotNull() {
            addCriterion("PROPERTY297 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty297EqualTo(Date value) {
            addCriterion("PROPERTY297 =", value, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297NotEqualTo(Date value) {
            addCriterion("PROPERTY297 <>", value, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297GreaterThan(Date value) {
            addCriterion("PROPERTY297 >", value, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY297 >=", value, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297LessThan(Date value) {
            addCriterion("PROPERTY297 <", value, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY297 <=", value, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297In(List<Date> values) {
            addCriterion("PROPERTY297 in", values, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297NotIn(List<Date> values) {
            addCriterion("PROPERTY297 not in", values, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297Between(Date value1, Date value2) {
            addCriterion("PROPERTY297 between", value1, value2, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty297NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY297 not between", value1, value2, "property297");
            return (Criteria) this;
        }

        public Criteria andProperty298IsNull() {
            addCriterion("PROPERTY298 is null");
            return (Criteria) this;
        }

        public Criteria andProperty298IsNotNull() {
            addCriterion("PROPERTY298 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty298EqualTo(Date value) {
            addCriterion("PROPERTY298 =", value, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298NotEqualTo(Date value) {
            addCriterion("PROPERTY298 <>", value, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298GreaterThan(Date value) {
            addCriterion("PROPERTY298 >", value, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY298 >=", value, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298LessThan(Date value) {
            addCriterion("PROPERTY298 <", value, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY298 <=", value, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298In(List<Date> values) {
            addCriterion("PROPERTY298 in", values, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298NotIn(List<Date> values) {
            addCriterion("PROPERTY298 not in", values, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298Between(Date value1, Date value2) {
            addCriterion("PROPERTY298 between", value1, value2, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty298NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY298 not between", value1, value2, "property298");
            return (Criteria) this;
        }

        public Criteria andProperty299IsNull() {
            addCriterion("PROPERTY299 is null");
            return (Criteria) this;
        }

        public Criteria andProperty299IsNotNull() {
            addCriterion("PROPERTY299 is not null");
            return (Criteria) this;
        }

        public Criteria andProperty299EqualTo(Date value) {
            addCriterion("PROPERTY299 =", value, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299NotEqualTo(Date value) {
            addCriterion("PROPERTY299 <>", value, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299GreaterThan(Date value) {
            addCriterion("PROPERTY299 >", value, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299GreaterThanOrEqualTo(Date value) {
            addCriterion("PROPERTY299 >=", value, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299LessThan(Date value) {
            addCriterion("PROPERTY299 <", value, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299LessThanOrEqualTo(Date value) {
            addCriterion("PROPERTY299 <=", value, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299In(List<Date> values) {
            addCriterion("PROPERTY299 in", values, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299NotIn(List<Date> values) {
            addCriterion("PROPERTY299 not in", values, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299Between(Date value1, Date value2) {
            addCriterion("PROPERTY299 between", value1, value2, "property299");
            return (Criteria) this;
        }

        public Criteria andProperty299NotBetween(Date value1, Date value2) {
            addCriterion("PROPERTY299 not between", value1, value2, "property299");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

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