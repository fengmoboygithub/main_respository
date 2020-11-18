package com.company.es.repository;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.base.exception.BaseException;
import com.company.one.newsarticle.dao.NewsArticleTabMapper;
import com.company.one.newsarticle.model.NewsArticleTab;
import com.company.one.newsarticle.model.NewsArticleTabExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 新闻报道 持久化测试类
 * @author yangyanchao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsArticleRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(NewsArticleRepositoryTest.class);
    /**
     * 存储在mysql库里的数据操作类
     */
    @Autowired
    private NewsArticleTabMapper newsArticleTabMapper;
	
	/**
	 * 存储在es里的持久化操作类
	 */
	@Autowired
    private NewsArticleRepository newsArticleRepository;
	
	/**
     * 从mysql库里获取新闻报道数据 存入es中
     */
	@Test
    public void save() throws BaseException{
		PageHelper.startPage(1, 2);
		NewsArticleTabExample example = new NewsArticleTabExample();
		List<NewsArticleTab> oneList = newsArticleTabMapper.selectByExample(example);
		PageInfo<NewsArticleTab> page = new PageInfo<NewsArticleTab>(oneList);
		if(page != null && page.getTotal() > 0 && page.getList() != null && page.getList().size() > 0){
			//总页数
			int totalPages = page.getPages();
			for(int pageNum=1; pageNum<=totalPages; pageNum++){
				//分批查询 200条一批
				PageHelper.startPage(pageNum, 200);
				List<NewsArticleTab> list = newsArticleTabMapper.selectByExample(example);
				if(list != null && list.size() > 0){
					Iterable<NewsArticleTab> res=  newsArticleRepository.saveAll(list);
					res.forEach(item->{
						//打印结果
						logger.info(item.toString());
					});
				}
			}
		} else {
			logger.info("mysql库没有查询到新闻报道数据");
		}
    }

    /**
     * 根据标题，类别两个字段搜索  默认支持字段全文（模糊）查询
     * @param newsTitle
     * @param newsCate
     * @return
     */
	@Test
    public void findByNewsTitleAndAndNewsCate() throws BaseException{
		String newsTitle = "";
		String newsCate = "";
		List<NewsArticleTab> list = newsArticleRepository.findByNewsTitleAndAndNewsCate(newsTitle,newsCate);
		list.forEach(item->{
			//打印结果
			logger.info(item.toString());
		});
    }
    
    /**
     * 分页查询 新闻报道信息
     * @param pageNum 页码
     * @param newsTitle
     * @param newsCate
     * @return
     */
	@Test
    public void fetchPageNewsArticleTab() throws BaseException{
		int pageNum = 1;
		String newsTitle = "";
		String newsCate = "";
		if(pageNum <= 0){
    		pageNum = 0;
    	} else {
    		pageNum = pageNum - 1;
    	}
        QueryBuilder queryBuilder= QueryBuilders.boolQuery()
        		//分词查询，采用默认的分词器
                .must(QueryBuilders.matchQuery("newsTitle",newsTitle))
                .must(QueryBuilders.matchQuery("newsCate",newsCate));
        
        Sort sort = new Sort(Sort.Direction.DESC, "newsCate.keyword");
        PageRequest pageRequest = PageRequest.of(pageNum, 10, sort);
        Page<NewsArticleTab> page = newsArticleRepository.search(queryBuilder, pageRequest);
        page.getContent().forEach(item->{
			//打印结果
			logger.info(item.toString());
		});
    }
	
}