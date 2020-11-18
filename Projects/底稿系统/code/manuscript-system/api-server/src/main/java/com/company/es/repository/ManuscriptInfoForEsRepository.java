package com.company.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.company.es.model.ManuscriptInfoForEs;

/**
 * 底稿索引信息 持久化类
 * @author yangyanchao
 *
 */
public interface ManuscriptInfoForEsRepository extends ElasticsearchRepository<ManuscriptInfoForEs,String> {

    /**
     * 根据文件名称，是否为新版本两个字段搜索
     * @param docname
     * @param newversionflag
     * @return
     */
    List<ManuscriptInfoForEs> findByDocnameAndNewversionflag(String docname,String newversionflag);

}