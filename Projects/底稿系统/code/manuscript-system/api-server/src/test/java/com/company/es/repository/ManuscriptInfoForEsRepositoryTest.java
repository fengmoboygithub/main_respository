package com.company.es.repository;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.BeforeClass;
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
import com.company.es.model.ManuscriptInfoForEs;

/**
 * 底稿信息 持久化测试类
 * @author yangyanchao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManuscriptInfoForEsRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(ManuscriptInfoForEsRepositoryTest.class);

	/**
	 * 存储在es里的持久化操作类
	 */
	@Autowired
    private ManuscriptInfoForEsRepository manuscriptInfoForEsRepository;

	/**
     * 将底稿信息 存入es中
     */
	@Test
    public void save() throws BaseException{
		logger.info("将底稿信息 存入es中");
		ManuscriptInfoForEs record = new ManuscriptInfoForEs();
		record.setId("fbabde83480c11ea820a507b9d975e7c");
		record.setDocname("1-1　改制与设立情况");
		record.setHashname("1909deab390565c1f1861120522b7035");
		record.setStatus("11");
		record.setUploadtime("2020-02-17 00:00:00");
		record.setUserid("23");
		record.setOrderno(1l);
		record.setIsapp(1);
		record.setProcessnode("");
		record.setNewversionflag("1");
		record.setVersion("1");
		record.setDirectoryid("18d2801c47fa11ea820a507b9d975e7c");
		record.setDirectorysname("第一章");
		record.setDirectoryfullname("第一章　发行人基本情况调查");
		record.setProjectid("32d2b0ea47c111ea820a507b9d975e7c");
		record.setProjectname("测试项目一");
		record.setProjectstage("阶段一");
		record.setProjecttype("项目类型");
		record.setProjectstarttime("2020-01-22");
		record.setProjectendtime("2020-06-30");
        manuscriptInfoForEsRepository.save(record);

        ManuscriptInfoForEs record1 = new ManuscriptInfoForEs();
		record1.setId("fbb8dc92480c11ea820a507b9d975e7c");
		record1.setDocname("1-1-1　改制前原企业（或主要发起人）的相关财务资料及审计报告");
		record1.setHashname("1909deab390565c1f1861120522b7035");
		record1.setStatus("11");
		record1.setUploadtime("2020-02-17 00:00:00");
		record1.setUserid("23");
		record1.setOrderno(2l);
		record1.setIsapp(1);
		record1.setProcessnode("");
		record1.setNewversionflag("0");
		record1.setVersion("1");
		record1.setDirectoryid("18d2801c47fa11ea820a507b9d975e7c");
		record1.setDirectorysname("第一章");
		record1.setDirectoryfullname("第一章　发行人基本情况调查");
		record1.setProjectid("32d2b0ea47c111ea820a507b9d975e7c");
		record1.setProjectname("测试项目一");
		record1.setProjectstage("阶段一");
		record1.setProjecttype("项目类型");
		record1.setProjectstarttime("2020-01-22");
		record1.setProjectendtime("2020-06-30");
        manuscriptInfoForEsRepository.save(record1);
    }

    /**
     * 根据文件名称，是否为新版本两个字段搜索
     * @param docname
     * @param newversionflag
     * @return
     */
	@Test
    public void findByDocnameAndNewversionflag() throws BaseException{
		String docname = "改制前原企业";
		String newversionflag = "0";
		List<ManuscriptInfoForEs> list = manuscriptInfoForEsRepository.findByDocnameAndNewversionflag(docname,newversionflag);
		list.forEach(item->{
			//打印结果
			logger.info(item.toString());
		});
    }

    /**
     * 分页查询 底稿信息
     * @param pageNum 页码
     * @param docname
     * @param newversionflag
     * @return
     */
	@Test
    public void fetchPageManuscriptInfoForEs() throws BaseException{
		int pageNum = 1;
		String docname = "改制前原企业";
		String newversionflag = "0";
		if(pageNum <= 0){
			pageNum = 0;
    	} else {
    		pageNum = pageNum - 1;
    	}
        QueryBuilder queryBuilder= QueryBuilders.boolQuery()
        		//分词查询，采用默认的分词器
                .must(QueryBuilders.matchQuery("docname",docname))
                .must(QueryBuilders.matchQuery("newversionflag",newversionflag));

        Sort sort = new Sort(Sort.Direction.DESC, "uploadtime");
        PageRequest pageRequest = PageRequest.of(pageNum, 20, sort);
        Page<ManuscriptInfoForEs> page = manuscriptInfoForEsRepository.search(queryBuilder, pageRequest);
        page.getContent().forEach(item->{
			//打印结果
			logger.info(item.toString());
		});
    }

    @Test
    public void deleteById() throws BaseException{
        String id = "fbabde83480c11ea820a507b9d975e7c";
        manuscriptInfoForEsRepository.deleteById(id);
    }

	@BeforeClass
	public static void before() {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
	}
}