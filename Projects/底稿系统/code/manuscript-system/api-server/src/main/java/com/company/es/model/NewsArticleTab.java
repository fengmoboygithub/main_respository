///*
//*
//* NewsArticleTab.java
//*                    中证技术公司
//* @date 2019-12-05
//*/
//package com.company.es.model;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import com.company.base.model.BaseModel;
//
//import lombok.Data;
//@Data
//@Document(indexName = "demo",type = "newsArticle", shards = 5, replicas = 1)
//public class NewsArticleTab extends BaseModel implements Serializable {
////	Document
////	    String indexName();//索引库的名称，个人建议以项目的名称命名
////	    String type() default "";//类型，个人建议以实体的名称命名
////	    short shards() default 5;//默认分片数
////	    short replicas() default 1;//每个分片默认的备份数
////	    String refreshInterval() default "1s";//刷新间隔
////	    String indexStoreType() default "fs";//索引文件存储类型
////	Field
////	    FieldType type() default FieldType.Auto;#自动检测属性的类型
////	    FieldIndex index() default FieldIndex.analyzed;#默认情况下分词
////	    DateFormat format() default DateFormat.none;
////	    String pattern() default "";
////	    boolean store() default false;#默认情况下不存储原文
////	    String searchAnalyzer() default "";#指定字段搜索时使用的分词器
////	    String indexAnalyzer() default "";#指定字段建立索引时指定的分词器
////	    String[] ignoreFields() default {};#如果某个字段需要被忽略
////	    boolean includeInParent() default false;
//    /**
//     * 主键id
//     */
//    private Long id;
//
//	//    分词器:
//	//    	standard   :(默认的) 会将词汇转化为小写 并去除停用词标点符号,支持中文采用的方式是单字切片。
//	//    	simple ：首先通过非字母进行分割，然后转化为小写，会去掉数字类型的字符。
//	//    	whitespace :仅仅是去除空格
//	//    	language:特定语言的分词器,不支持中文。
//	//    	analysis-ik ：中文分词器    下面分为两种   ik_max_word   是尽可能多的分词    ik_smart   粗略的分词
//    //	是否需要分词？  Text 表示文本，可被分词也可以被索引，keyword表示为关键字，
//    //			不分词，但可以被索引，只是String可被分词
//    //	是否需要索引？  index为true表示可被索引，为false表示不可被索引
//    //	是否需要存储？  store为true表示可被存储，为false表示不可被存储
//    /**
//     * 新闻标题
//     */
//    @Field(type = FieldType.text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
//    private String newsTitle;
//
//    /**
//     * 新闻来源
//     */
//    private String newsResource;
//
//    /**
//     * 新闻类型
//     */
//    private String newsCate;
//
//    /**
//     * 新闻格式
//     */
//    private Byte formatType;
//
//    /**
//     * 新闻原地址
//     */
//    private String newsUrl;
//
//    /**
//     * 爬数据取唯一id
//     */
//    private String crawlerId;
//
//    /**
//     * 数据爬取来源
//     */
//    private String crawlerResource;
//
//    /**
//     * 标题图片，多张以逗号隔开
//     */
//    private String titlePic;
//
//    /**
//     * 新闻发布时间
//     */
//    private String newsDate;
//
//    /**
//     * 阅读次数
//     */
//    private Integer readNum;
//
//    /**
//     * 0 接口 1 自己 2 爬虫
//     */
//    private Byte pubMark;
//
//    /**
//     * 修改时间
//     */
//    private Date gtmModified;
//
//    /**
//     * 创建时间
//     */
//    private Date gtmCreated;
//
//    /**
//     * news_article
//     */
//    private static final long serialVersionUID = 1L;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNewsTitle() {
//        return newsTitle;
//    }
//
//    public void setNewsTitle(String newsTitle) {
//        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
//    }
//
//    public String getNewsResource() {
//        return newsResource;
//    }
//
//    public void setNewsResource(String newsResource) {
//        this.newsResource = newsResource == null ? null : newsResource.trim();
//    }
//
//    public String getNewsCate() {
//        return newsCate;
//    }
//
//    public void setNewsCate(String newsCate) {
//        this.newsCate = newsCate == null ? null : newsCate.trim();
//    }
//
//    public Byte getFormatType() {
//        return formatType;
//    }
//
//    public void setFormatType(Byte formatType) {
//        this.formatType = formatType;
//    }
//
//    public String getNewsUrl() {
//        return newsUrl;
//    }
//
//    public void setNewsUrl(String newsUrl) {
//        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
//    }
//
//    public String getCrawlerId() {
//        return crawlerId;
//    }
//
//    public void setCrawlerId(String crawlerId) {
//        this.crawlerId = crawlerId == null ? null : crawlerId.trim();
//    }
//
//    public String getCrawlerResource() {
//        return crawlerResource;
//    }
//
//    public void setCrawlerResource(String crawlerResource) {
//        this.crawlerResource = crawlerResource == null ? null : crawlerResource.trim();
//    }
//
//    public String getTitlePic() {
//        return titlePic;
//    }
//
//    public void setTitlePic(String titlePic) {
//        this.titlePic = titlePic == null ? null : titlePic.trim();
//    }
//
//    public String getNewsDate() {
//        return newsDate;
//    }
//
//    public void setNewsDate(String newsDate) {
//        this.newsDate = newsDate == null ? null : newsDate.trim();
//    }
//
//    public Integer getReadNum() {
//        return readNum;
//    }
//
//    public void setReadNum(Integer readNum) {
//        this.readNum = readNum;
//    }
//
//    public Byte getPubMark() {
//        return pubMark;
//    }
//
//    public void setPubMark(Byte pubMark) {
//        this.pubMark = pubMark;
//    }
//
//    public Date getGtmModified() {
//        return gtmModified;
//    }
//
//    public void setGtmModified(Date gtmModified) {
//        this.gtmModified = gtmModified;
//    }
//
//    public Date getGtmCreated() {
//        return gtmCreated;
//    }
//
//    public void setGtmCreated(Date gtmCreated) {
//        this.gtmCreated = gtmCreated;
//    }
//
//    /**
//     *
//     * @mbg.generated 2019-12-05
//     */
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("NewsArticleTab = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", newsTitle=").append(newsTitle);
//        sb.append(", newsResource=").append(newsResource);
//        sb.append(", newsCate=").append(newsCate);
//        sb.append(", formatType=").append(formatType);
//        sb.append(", newsUrl=").append(newsUrl);
//        sb.append(", crawlerId=").append(crawlerId);
//        sb.append(", crawlerResource=").append(crawlerResource);
//        sb.append(", titlePic=").append(titlePic);
//        sb.append(", newsDate=").append(newsDate);
//        sb.append(", readNum=").append(readNum);
//        sb.append(", pubMark=").append(pubMark);
//        sb.append(", gtmModified=").append(gtmModified);
//        sb.append(", gtmCreated=").append(gtmCreated);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
//
//    /**
//     *
//     * @mbg.generated 2019-12-05
//     */
//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        NewsArticleTab other = (NewsArticleTab) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//            && (this.getNewsTitle() == null ? other.getNewsTitle() == null : this.getNewsTitle().equals(other.getNewsTitle()))
//            && (this.getNewsResource() == null ? other.getNewsResource() == null : this.getNewsResource().equals(other.getNewsResource()))
//            && (this.getNewsCate() == null ? other.getNewsCate() == null : this.getNewsCate().equals(other.getNewsCate()))
//            && (this.getFormatType() == null ? other.getFormatType() == null : this.getFormatType().equals(other.getFormatType()))
//            && (this.getNewsUrl() == null ? other.getNewsUrl() == null : this.getNewsUrl().equals(other.getNewsUrl()))
//            && (this.getCrawlerId() == null ? other.getCrawlerId() == null : this.getCrawlerId().equals(other.getCrawlerId()))
//            && (this.getCrawlerResource() == null ? other.getCrawlerResource() == null : this.getCrawlerResource().equals(other.getCrawlerResource()))
//            && (this.getTitlePic() == null ? other.getTitlePic() == null : this.getTitlePic().equals(other.getTitlePic()))
//            && (this.getNewsDate() == null ? other.getNewsDate() == null : this.getNewsDate().equals(other.getNewsDate()))
//            && (this.getReadNum() == null ? other.getReadNum() == null : this.getReadNum().equals(other.getReadNum()))
//            && (this.getPubMark() == null ? other.getPubMark() == null : this.getPubMark().equals(other.getPubMark()))
//            && (this.getGtmModified() == null ? other.getGtmModified() == null : this.getGtmModified().equals(other.getGtmModified()))
//            && (this.getGtmCreated() == null ? other.getGtmCreated() == null : this.getGtmCreated().equals(other.getGtmCreated()));
//    }
//
//    /**
//     *
//     * @mbg.generated 2019-12-05
//     */
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getNewsTitle() == null) ? 0 : getNewsTitle().hashCode());
//        result = prime * result + ((getNewsResource() == null) ? 0 : getNewsResource().hashCode());
//        result = prime * result + ((getNewsCate() == null) ? 0 : getNewsCate().hashCode());
//        result = prime * result + ((getFormatType() == null) ? 0 : getFormatType().hashCode());
//        result = prime * result + ((getNewsUrl() == null) ? 0 : getNewsUrl().hashCode());
//        result = prime * result + ((getCrawlerId() == null) ? 0 : getCrawlerId().hashCode());
//        result = prime * result + ((getCrawlerResource() == null) ? 0 : getCrawlerResource().hashCode());
//        result = prime * result + ((getTitlePic() == null) ? 0 : getTitlePic().hashCode());
//        result = prime * result + ((getNewsDate() == null) ? 0 : getNewsDate().hashCode());
//        result = prime * result + ((getReadNum() == null) ? 0 : getReadNum().hashCode());
//        result = prime * result + ((getPubMark() == null) ? 0 : getPubMark().hashCode());
//        result = prime * result + ((getGtmModified() == null) ? 0 : getGtmModified().hashCode());
//        result = prime * result + ((getGtmCreated() == null) ? 0 : getGtmCreated().hashCode());
//        return result;
//    }
//}