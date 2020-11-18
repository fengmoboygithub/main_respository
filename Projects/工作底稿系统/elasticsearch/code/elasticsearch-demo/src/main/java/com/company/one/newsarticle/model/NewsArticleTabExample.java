/*
*
* NewsArticleTabExample.java
*                    中证技术公司
* @date 2019-12-05
*/
package com.company.one.newsarticle.model;

import com.company.base.example.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsArticleTabExample extends BaseExample implements Serializable {
    /**
     * news_article
     */
    protected String orderByClause;

    /**
     * news_article
     */
    protected boolean distinct;

    /**
     * news_article
     */
    protected List<Criteria> oredCriteria;

    /**
     * news_article
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public NewsArticleTabExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-12-05
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
     * @mbg.generated 2019-12-05
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-12-05
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * news_article 2019-12-05
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNull() {
            addCriterion("news_title is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNotNull() {
            addCriterion("news_title is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleEqualTo(String value) {
            addCriterion("news_title =", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotEqualTo(String value) {
            addCriterion("news_title <>", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThan(String value) {
            addCriterion("news_title >", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("news_title >=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThan(String value) {
            addCriterion("news_title <", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThanOrEqualTo(String value) {
            addCriterion("news_title <=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLike(String value) {
            addCriterion("news_title like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotLike(String value) {
            addCriterion("news_title not like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIn(List<String> values) {
            addCriterion("news_title in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotIn(List<String> values) {
            addCriterion("news_title not in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleBetween(String value1, String value2) {
            addCriterion("news_title between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotBetween(String value1, String value2) {
            addCriterion("news_title not between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsResourceIsNull() {
            addCriterion("news_resource is null");
            return (Criteria) this;
        }

        public Criteria andNewsResourceIsNotNull() {
            addCriterion("news_resource is not null");
            return (Criteria) this;
        }

        public Criteria andNewsResourceEqualTo(String value) {
            addCriterion("news_resource =", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotEqualTo(String value) {
            addCriterion("news_resource <>", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceGreaterThan(String value) {
            addCriterion("news_resource >", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceGreaterThanOrEqualTo(String value) {
            addCriterion("news_resource >=", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceLessThan(String value) {
            addCriterion("news_resource <", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceLessThanOrEqualTo(String value) {
            addCriterion("news_resource <=", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceLike(String value) {
            addCriterion("news_resource like", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotLike(String value) {
            addCriterion("news_resource not like", value, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceIn(List<String> values) {
            addCriterion("news_resource in", values, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotIn(List<String> values) {
            addCriterion("news_resource not in", values, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceBetween(String value1, String value2) {
            addCriterion("news_resource between", value1, value2, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsResourceNotBetween(String value1, String value2) {
            addCriterion("news_resource not between", value1, value2, "newsResource");
            return (Criteria) this;
        }

        public Criteria andNewsCateIsNull() {
            addCriterion("news_cate is null");
            return (Criteria) this;
        }

        public Criteria andNewsCateIsNotNull() {
            addCriterion("news_cate is not null");
            return (Criteria) this;
        }

        public Criteria andNewsCateEqualTo(String value) {
            addCriterion("news_cate =", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateNotEqualTo(String value) {
            addCriterion("news_cate <>", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateGreaterThan(String value) {
            addCriterion("news_cate >", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateGreaterThanOrEqualTo(String value) {
            addCriterion("news_cate >=", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateLessThan(String value) {
            addCriterion("news_cate <", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateLessThanOrEqualTo(String value) {
            addCriterion("news_cate <=", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateLike(String value) {
            addCriterion("news_cate like", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateNotLike(String value) {
            addCriterion("news_cate not like", value, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateIn(List<String> values) {
            addCriterion("news_cate in", values, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateNotIn(List<String> values) {
            addCriterion("news_cate not in", values, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateBetween(String value1, String value2) {
            addCriterion("news_cate between", value1, value2, "newsCate");
            return (Criteria) this;
        }

        public Criteria andNewsCateNotBetween(String value1, String value2) {
            addCriterion("news_cate not between", value1, value2, "newsCate");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIsNull() {
            addCriterion("format_type is null");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIsNotNull() {
            addCriterion("format_type is not null");
            return (Criteria) this;
        }

        public Criteria andFormatTypeEqualTo(Byte value) {
            addCriterion("format_type =", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotEqualTo(Byte value) {
            addCriterion("format_type <>", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeGreaterThan(Byte value) {
            addCriterion("format_type >", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("format_type >=", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLessThan(Byte value) {
            addCriterion("format_type <", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeLessThanOrEqualTo(Byte value) {
            addCriterion("format_type <=", value, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeIn(List<Byte> values) {
            addCriterion("format_type in", values, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotIn(List<Byte> values) {
            addCriterion("format_type not in", values, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeBetween(Byte value1, Byte value2) {
            addCriterion("format_type between", value1, value2, "formatType");
            return (Criteria) this;
        }

        public Criteria andFormatTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("format_type not between", value1, value2, "formatType");
            return (Criteria) this;
        }

        public Criteria andNewsUrlIsNull() {
            addCriterion("news_url is null");
            return (Criteria) this;
        }

        public Criteria andNewsUrlIsNotNull() {
            addCriterion("news_url is not null");
            return (Criteria) this;
        }

        public Criteria andNewsUrlEqualTo(String value) {
            addCriterion("news_url =", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotEqualTo(String value) {
            addCriterion("news_url <>", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlGreaterThan(String value) {
            addCriterion("news_url >", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("news_url >=", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlLessThan(String value) {
            addCriterion("news_url <", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlLessThanOrEqualTo(String value) {
            addCriterion("news_url <=", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlLike(String value) {
            addCriterion("news_url like", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotLike(String value) {
            addCriterion("news_url not like", value, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlIn(List<String> values) {
            addCriterion("news_url in", values, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotIn(List<String> values) {
            addCriterion("news_url not in", values, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlBetween(String value1, String value2) {
            addCriterion("news_url between", value1, value2, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andNewsUrlNotBetween(String value1, String value2) {
            addCriterion("news_url not between", value1, value2, "newsUrl");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdIsNull() {
            addCriterion("crawler_id is null");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdIsNotNull() {
            addCriterion("crawler_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdEqualTo(String value) {
            addCriterion("crawler_id =", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdNotEqualTo(String value) {
            addCriterion("crawler_id <>", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdGreaterThan(String value) {
            addCriterion("crawler_id >", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdGreaterThanOrEqualTo(String value) {
            addCriterion("crawler_id >=", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdLessThan(String value) {
            addCriterion("crawler_id <", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdLessThanOrEqualTo(String value) {
            addCriterion("crawler_id <=", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdLike(String value) {
            addCriterion("crawler_id like", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdNotLike(String value) {
            addCriterion("crawler_id not like", value, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdIn(List<String> values) {
            addCriterion("crawler_id in", values, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdNotIn(List<String> values) {
            addCriterion("crawler_id not in", values, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdBetween(String value1, String value2) {
            addCriterion("crawler_id between", value1, value2, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerIdNotBetween(String value1, String value2) {
            addCriterion("crawler_id not between", value1, value2, "crawlerId");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceIsNull() {
            addCriterion("crawler_resource is null");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceIsNotNull() {
            addCriterion("crawler_resource is not null");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceEqualTo(String value) {
            addCriterion("crawler_resource =", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceNotEqualTo(String value) {
            addCriterion("crawler_resource <>", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceGreaterThan(String value) {
            addCriterion("crawler_resource >", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceGreaterThanOrEqualTo(String value) {
            addCriterion("crawler_resource >=", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceLessThan(String value) {
            addCriterion("crawler_resource <", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceLessThanOrEqualTo(String value) {
            addCriterion("crawler_resource <=", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceLike(String value) {
            addCriterion("crawler_resource like", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceNotLike(String value) {
            addCriterion("crawler_resource not like", value, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceIn(List<String> values) {
            addCriterion("crawler_resource in", values, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceNotIn(List<String> values) {
            addCriterion("crawler_resource not in", values, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceBetween(String value1, String value2) {
            addCriterion("crawler_resource between", value1, value2, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andCrawlerResourceNotBetween(String value1, String value2) {
            addCriterion("crawler_resource not between", value1, value2, "crawlerResource");
            return (Criteria) this;
        }

        public Criteria andTitlePicIsNull() {
            addCriterion("title_pic is null");
            return (Criteria) this;
        }

        public Criteria andTitlePicIsNotNull() {
            addCriterion("title_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTitlePicEqualTo(String value) {
            addCriterion("title_pic =", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotEqualTo(String value) {
            addCriterion("title_pic <>", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicGreaterThan(String value) {
            addCriterion("title_pic >", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicGreaterThanOrEqualTo(String value) {
            addCriterion("title_pic >=", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicLessThan(String value) {
            addCriterion("title_pic <", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicLessThanOrEqualTo(String value) {
            addCriterion("title_pic <=", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicLike(String value) {
            addCriterion("title_pic like", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotLike(String value) {
            addCriterion("title_pic not like", value, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicIn(List<String> values) {
            addCriterion("title_pic in", values, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotIn(List<String> values) {
            addCriterion("title_pic not in", values, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicBetween(String value1, String value2) {
            addCriterion("title_pic between", value1, value2, "titlePic");
            return (Criteria) this;
        }

        public Criteria andTitlePicNotBetween(String value1, String value2) {
            addCriterion("title_pic not between", value1, value2, "titlePic");
            return (Criteria) this;
        }

        public Criteria andNewsDateIsNull() {
            addCriterion("news_date is null");
            return (Criteria) this;
        }

        public Criteria andNewsDateIsNotNull() {
            addCriterion("news_date is not null");
            return (Criteria) this;
        }

        public Criteria andNewsDateEqualTo(String value) {
            addCriterion("news_date =", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateNotEqualTo(String value) {
            addCriterion("news_date <>", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateGreaterThan(String value) {
            addCriterion("news_date >", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateGreaterThanOrEqualTo(String value) {
            addCriterion("news_date >=", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateLessThan(String value) {
            addCriterion("news_date <", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateLessThanOrEqualTo(String value) {
            addCriterion("news_date <=", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateLike(String value) {
            addCriterion("news_date like", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateNotLike(String value) {
            addCriterion("news_date not like", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateIn(List<String> values) {
            addCriterion("news_date in", values, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateNotIn(List<String> values) {
            addCriterion("news_date not in", values, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateBetween(String value1, String value2) {
            addCriterion("news_date between", value1, value2, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateNotBetween(String value1, String value2) {
            addCriterion("news_date not between", value1, value2, "newsDate");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNull() {
            addCriterion("read_num is null");
            return (Criteria) this;
        }

        public Criteria andReadNumIsNotNull() {
            addCriterion("read_num is not null");
            return (Criteria) this;
        }

        public Criteria andReadNumEqualTo(Integer value) {
            addCriterion("read_num =", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotEqualTo(Integer value) {
            addCriterion("read_num <>", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThan(Integer value) {
            addCriterion("read_num >", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_num >=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThan(Integer value) {
            addCriterion("read_num <", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumLessThanOrEqualTo(Integer value) {
            addCriterion("read_num <=", value, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumIn(List<Integer> values) {
            addCriterion("read_num in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotIn(List<Integer> values) {
            addCriterion("read_num not in", values, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumBetween(Integer value1, Integer value2) {
            addCriterion("read_num between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andReadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("read_num not between", value1, value2, "readNum");
            return (Criteria) this;
        }

        public Criteria andPubMarkIsNull() {
            addCriterion("pub_mark is null");
            return (Criteria) this;
        }

        public Criteria andPubMarkIsNotNull() {
            addCriterion("pub_mark is not null");
            return (Criteria) this;
        }

        public Criteria andPubMarkEqualTo(Byte value) {
            addCriterion("pub_mark =", value, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkNotEqualTo(Byte value) {
            addCriterion("pub_mark <>", value, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkGreaterThan(Byte value) {
            addCriterion("pub_mark >", value, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkGreaterThanOrEqualTo(Byte value) {
            addCriterion("pub_mark >=", value, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkLessThan(Byte value) {
            addCriterion("pub_mark <", value, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkLessThanOrEqualTo(Byte value) {
            addCriterion("pub_mark <=", value, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkIn(List<Byte> values) {
            addCriterion("pub_mark in", values, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkNotIn(List<Byte> values) {
            addCriterion("pub_mark not in", values, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkBetween(Byte value1, Byte value2) {
            addCriterion("pub_mark between", value1, value2, "pubMark");
            return (Criteria) this;
        }

        public Criteria andPubMarkNotBetween(Byte value1, Byte value2) {
            addCriterion("pub_mark not between", value1, value2, "pubMark");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedIsNull() {
            addCriterion("gtm_modified is null");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedIsNotNull() {
            addCriterion("gtm_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedEqualTo(Date value) {
            addCriterion("gtm_modified =", value, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedNotEqualTo(Date value) {
            addCriterion("gtm_modified <>", value, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedGreaterThan(Date value) {
            addCriterion("gtm_modified >", value, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gtm_modified >=", value, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedLessThan(Date value) {
            addCriterion("gtm_modified <", value, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gtm_modified <=", value, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedIn(List<Date> values) {
            addCriterion("gtm_modified in", values, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedNotIn(List<Date> values) {
            addCriterion("gtm_modified not in", values, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedBetween(Date value1, Date value2) {
            addCriterion("gtm_modified between", value1, value2, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gtm_modified not between", value1, value2, "gtmModified");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedIsNull() {
            addCriterion("gtm_created is null");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedIsNotNull() {
            addCriterion("gtm_created is not null");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedEqualTo(Date value) {
            addCriterion("gtm_created =", value, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedNotEqualTo(Date value) {
            addCriterion("gtm_created <>", value, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedGreaterThan(Date value) {
            addCriterion("gtm_created >", value, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gtm_created >=", value, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedLessThan(Date value) {
            addCriterion("gtm_created <", value, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gtm_created <=", value, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedIn(List<Date> values) {
            addCriterion("gtm_created in", values, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedNotIn(List<Date> values) {
            addCriterion("gtm_created not in", values, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedBetween(Date value1, Date value2) {
            addCriterion("gtm_created between", value1, value2, "gtmCreated");
            return (Criteria) this;
        }

        public Criteria andGtmCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gtm_created not between", value1, value2, "gtmCreated");
            return (Criteria) this;
        }
    }

    /**
     *  * news_article
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * news_article 2019-12-05
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