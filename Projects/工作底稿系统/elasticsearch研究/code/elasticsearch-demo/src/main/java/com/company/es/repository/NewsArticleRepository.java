package com.company.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.company.one.newsarticle.model.NewsArticleTab;

/**
 * 新闻报道 持久化类
 * @author yangyanchao
 *
 */
public interface NewsArticleRepository extends ElasticsearchRepository<NewsArticleTab,Long> {

    /**
     * 根据标题，类别两个字段搜索
     * @param newsTitle
     * @param newsCate
     * @return
     */
    List<NewsArticleTab> findByNewsTitleAndAndNewsCate(String newsTitle,String newsCate);
	
}