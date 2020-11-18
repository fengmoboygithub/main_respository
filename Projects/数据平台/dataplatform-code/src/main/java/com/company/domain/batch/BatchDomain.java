package com.company.domain.batch;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.domain.analysis.AnalysisFileDomain;
import com.company.domain.analysis.CatchHandle;
import com.company.domain.analysis.FinallyHandle;
import com.company.domain.analysis.PlainLoopEndHandle;
import com.company.domain.analysis.PlainLoopHandle;
import com.company.domain.analysis.TupleLoopEndHandle;
import com.company.domain.analysis.TupleLoopHandle;
import com.company.one.handleplain.dao.HandlePlainTmpMapper;
import com.company.one.handleplain.model.HandlePlainTmp;
import com.company.one.handleplain.model.HandlePlainTmpExample;
import com.company.one.handleplain.model.HandlePlainTmpExample.Criteria;
import com.company.one.handletuple.model.HandleTupleTmp;

/**
 * 批处理相关的domain
 * @author yangyanchao
 *
 */
public class BatchDomain {
	
	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(BatchDomain.class);
	/**
     * 文件内容--Mapper类反射内容
     */
    public final static String handlePlainTmpMapperClass = "com.company.one.handleplain.dao.HandlePlainTmpMapper.insertSelective";
    /**
     * 文件内容元组--Mapper类反射内容
     */
    public final static String handleTupleTmpMapperClass = "com.company.one.handletuple.dao.HandleTupleTmpMapper.insertSelective";
	
	/**
	 * SqlSessionTemplate
	 */
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 文件内容--Mapper类
	 */
	@Autowired
	private HandlePlainTmpMapper handlePlainTmpMapper;
	
	/**
	 * 处理文件表主键
	 */
	private int handleFileId;
	
	/**
	 * 插入一批次中最多行数
	 */
	private int insertBatchMaxNum;
	
	
	public BatchDomain() {
		super();
	}
	
	public BatchDomain(int handleFileId, int insertBatchMaxNum) {
		super();
		this.handleFileId = handleFileId;
		this.insertBatchMaxNum = insertBatchMaxNum;
	}


	/**
	 * 将file内容批量导入文件内容和文件内容元组表
	 */
	public void batchInsert(AnalysisFileDomain analysisDomain) throws BaseException {
		//关闭session的自动提交
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false); 
		//普通信息循环处理操作
		analysisDomain.setPlainLoopHandle(new PlainLoopHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) {
				Matcher plainMatcher = analysisDomain.getPlainItemMatcher();
				int plainItemCount = analysisDomain.getPlainItemCount();
				//普通信息
				HandlePlainTmp handlePlainTmp = new HandlePlainTmp();
				//处理文件表主键
				handlePlainTmp.setFileId(handleFileId);
				//报送记录号
				handlePlainTmp.setSubmissionRecordId(plainMatcher.group(1));
				//文件条目内容
				handlePlainTmp.setFileItemContent(plainMatcher.group(2));
				//文件条目序号
				handlePlainTmp.setFileItemSort(plainItemCount);
				//创建时间
				handlePlainTmp.setCreateDate(new Date());
				session.insert(handlePlainTmpMapperClass, handlePlainTmp);
				if (plainItemCount % insertBatchMaxNum == 0) {
					//手动每insertBatchMaxNum个一提交，提交后无法回滚 
					session.commit(); 
					session.clearCache();
					//注意，如果没有这个动作，可能会导致内存崩溃。 
				}
			}
		});
		//元组信息循环处理操作
		analysisDomain.setTupleLoopHandle(new TupleLoopHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) {
				Matcher tupleItemMatcher = analysisDomain.getTupleItemMatcher();
				String tupleName = analysisDomain.getTupleName();
				int tupleItemCount = analysisDomain.getTupleItemCount();
				//根据处理文件表主键与报送记录号查询文件内容表数据
				String submissionRecordId = tupleItemMatcher.group(1);
				HandlePlainTmpExample example = new HandlePlainTmpExample();
				Criteria criteria = example.createCriteria();
				criteria.andFileIdEqualTo(handleFileId);
				criteria.andSubmissionRecordIdEqualTo(submissionRecordId);
				List<HandlePlainTmp> handlePlainTmpList = handlePlainTmpMapper.selectByExample(example);
				if(handlePlainTmpList != null && handlePlainTmpList.size() > 0){
					//存在则获取文件内容表主键
					Integer fileItemId = handlePlainTmpList.get(0).getId();
					//元组子项信息
					HandleTupleTmp handleTupleTmp = new HandleTupleTmp();
					//文件内容表主键
					handleTupleTmp.setFileItemId(fileItemId);
					//元组名称
					handleTupleTmp.setTupleName(tupleName);
					//报送记录号
					handleTupleTmp.setSubmissionRecordId(submissionRecordId);
					//元组条目内容
					handleTupleTmp.setTupleItemContent(tupleItemMatcher.group(2));
					//元组条目序号
					handleTupleTmp.setTupleItemSort(tupleItemCount);
					//创建时间
					handleTupleTmp.setCreateDate(new Date());
					session.insert(handleTupleTmpMapperClass, handleTupleTmp);
					if (tupleItemCount % insertBatchMaxNum == 0) {
						//手动每insertBatchMaxNum个一提交，提交后无法回滚 
						session.commit(); 
						session.clearCache();
						//注意，如果没有这个动作，可能会导致内存崩溃。 
					}
				}
			}
		});
		//普通信息循环结束处理操作
		analysisDomain.setPlainLoopEndHandle(new PlainLoopEndHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) {
				session.commit();
				session.clearCache();
			}
		});
		//元组信息循环结束处理操作
		analysisDomain.setTupleLoopEndHandle(new TupleLoopEndHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) {
				session.commit();
				session.clearCache();
			}
		});
		//catch处理操作接口
		analysisDomain.setCatchHandle(new CatchHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) {
				session.rollback();
			}
		});
		//finlly处理操作接口
		analysisDomain.setFinallyHandle(new FinallyHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) {
				session.close();
			}
		});
		//文件解析批量插入临时表
		analysisDomain.analysis();
	}
}
