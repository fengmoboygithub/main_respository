package com.company.one.newsarticle.serviceImpl;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.es.repository.NewsArticleRepository;
import com.company.one.newsarticle.dao.NewsArticleTabMapper;
import com.company.one.newsarticle.model.NewsArticleTab;
import com.company.one.newsarticle.model.NewsArticleTabExample;
import com.company.one.newsarticle.service.NewsArticleTabService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class NewsArticleTabServiceImpl extends BaseServiceImpl<NewsArticleTab, NewsArticleTabExample> implements NewsArticleTabService<NewsArticleTab, NewsArticleTabExample>{
	private Logger logger = LoggerFactory.getLogger(NewsArticleTabServiceImpl.class);
    /**
     * 存储在mysql库里的数据操作类
     */
    @Autowired
    private NewsArticleTabMapper newsArticleTabMapper;
	
	public IBaseDao<NewsArticleTab, NewsArticleTabExample> getMapper(){
		return newsArticleTabMapper;
	}
	
	/**
	 * 存储在es里的持久化操作类
	 */
	@Autowired
    private NewsArticleRepository newsArticleRepository;
	
    /**
     * 从mysql库里获取新闻报道数据 存入es中
     */
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
    public List<NewsArticleTab> findByNewsTitleAndAndNewsCate(String newsTitle,String newsCate) throws BaseException{
        return newsArticleRepository.findByNewsTitleAndAndNewsCate(newsTitle,newsCate);
    }
    
    /**
     * 分页查询 新闻报道信息
     * @param pageNum 页码
     * @param newsTitle
     * @param newsCate
     * @return
     */
    public Page<NewsArticleTab> fetchPageNewsArticleTab(int pageNum, String newsTitle, String newsCate) throws BaseException{
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
        return newsArticleRepository.search(queryBuilder, pageRequest);
    }
}