package com.company.domain.comparisoninto;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.company.base.exception.BaseException;
import com.company.config.interfaceinfo.InterfaceParam;
import com.company.config.interfaceinfo.InterfaceParamInfo;
import com.company.config.job.JobParam;
import com.company.domain.conversion.ConversionDomain;
import com.company.domain.query.ExistHandle;
import com.company.domain.query.LoopEndHandle;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.NotExistHandle;
import com.company.domain.query.handfile.HandleFileTabQueryDomain;
import com.company.domain.query.handledetail.HandleDetailTabQueryDomain;
import com.company.domain.query.handplain.HandlePlainTabQueryDomain;
import com.company.enums.HandleDetailTabStatus;
import com.company.enums.HandleFileTabStatus;
import com.company.one.handledetail.dao.HandleDetailTabMapper;
import com.company.one.handledetail.model.HandleDetailTab;
import com.company.one.handlefile.model.HandleFileTab;
import com.company.one.handleplain.model.HandlePlainTmp;
import com.company.one.handletuple.model.HandleTupleTmp;
import com.company.utils.FileUtils;

/**
 * 比对数据并入库操作域
 * @author yangyanchao
 *
 */
public class ComparisonAndWarehousingDomain {
	/**
	 * 输出日志
	 */
	private Logger logger = LoggerFactory.getLogger(ComparisonAndWarehousingDomain.class);
	
	/**
	 * 处理明细--Mapper类
	 */
	@Autowired
	private HandleDetailTabMapper handleDetailTabMapper;
	
	/**
	 * 扫描目录
	 */
	private File scanDir;
    
	/**
	 * 备份目录
	 */
	private File backupDir;
	/**
	 * 临时目录
	 */
	private File tempDir;
	
	/**
	 * 字段分隔符
	 */
	private String separator;
	
	/**
	 * 设置查询一批次中最多行数
	 */
	private int queryBatchMaxNum;
	
	/**
	 * 接口信息参数信息
	 */
	private Map<String, InterfaceParam> info = new HashMap<String, InterfaceParam>();

	public File getBackupDir() {
		return backupDir;
	}

	public void setBackupDir(File backupDir) {
		this.backupDir = backupDir;
	}

	public File getTempDir() {
		return tempDir;
	}

	public void setTempDir(File tempDir) {
		this.tempDir = tempDir;
	}
	public File getScanDir() {
		return scanDir;
	}

	public void setScanDir(File scanDir) {
		this.scanDir = scanDir;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public int getQueryBatchMaxNum() {
		return queryBatchMaxNum;
	}

	public void setQueryBatchMaxNum(int queryBatchMaxNum) {
		this.queryBatchMaxNum = queryBatchMaxNum;
	}

	public Map<String, InterfaceParam> getInfo() {
		return info;
	}

	public void setInfo(Map<String, InterfaceParam> info) {
		this.info = info;
	}

	public ComparisonAndWarehousingDomain() {
		super();
	}

	public ComparisonAndWarehousingDomain(JobParam jobParam, InterfaceParamInfo interfaceParamInfo) {
		super();
		this.scanDir = jobParam.getScanDir();
		this.backupDir = jobParam.getBackupDir();
		this.tempDir = jobParam.getTempDir();
		this.separator = jobParam.getSeparator();
		this.queryBatchMaxNum = jobParam.getQueryBatchMaxNum();
		this.info = interfaceParamInfo.getInfo();
	}
	
	/**
	 * 查询临时表数据进行比对入库正式表
	 * 该过程有事务
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void comparisonAndWarehousingToFormal() throws BaseException {
		//处理文件表相关查询域
		HandleFileTabQueryDomain handleFileTabQueryDomain = new HandleFileTabQueryDomain(HandleFileTabStatus.WAREHOUSING);
		//判断存在循环操作接口
		handleFileTabQueryDomain.setLoopHandle(new LoopHandle<HandleFileTabQueryDomain>() {
			@Override
			public void handle(HandleFileTabQueryDomain t) throws BaseException {
				//处理文件表数据实体
				HandleFileTab handleFileTab = t.getLoopEntity();
				//文件内容表相关查询域
				HandlePlainTabQueryDomain handlePlainTabQueryDomain = new HandlePlainTabQueryDomain(handleFileTab, queryBatchMaxNum);
				//判断存在循环操作接口
				handlePlainTabQueryDomain.setLoopHandle(new LoopHandle<HandlePlainTabQueryDomain>() {
					@Override
					public void handle(HandlePlainTabQueryDomain t) throws BaseException {
						//文件内容表数据实体
						HandlePlainTmp loopEntity = t.getLoopEntity();
						//文件元组表数据实体列表
						List<HandleTupleTmp> loopEntityTuple = t.getLoopEntityTuple();
						//报送记录号
						String submissionRecordId = loopEntity.getSubmissionRecordId();
						//处理明细表相关查询域
						HandleDetailTabQueryDomain handleDetailTabQueryDomain = new HandleDetailTabQueryDomain(handleFileTab, submissionRecordId, HandleDetailTabStatus.SUBMITTEDSUCCESS);
						//数据比对入库
						handleDetailTabQueryDomain.setExistHandle(new ExistHandle<HandleDetailTabQueryDomain>() {
							@Override
							public void handle(HandleDetailTabQueryDomain t) throws BaseException {
								HandleDetailTab handleDetailTab = t.getComparisonEntity();
								handleDetailTab.setId(null);
								//处理文件表主键
								handleDetailTab.setFileId(handleFileTab.getId());
								//报送日期
								handleDetailTab.setSubmissionDate(handleFileTab.getSubmissionDate());
								//文件序号
								handleDetailTab.setFileNum(handleFileTab.getFileNum());
								//操作标识
								handleDetailTab.setOperationId(handleFileTab.getOperationId());	
								//状态 上报失败：32
								handleDetailTab.setStatus(HandleDetailTabStatus.SUBMITTEDERROR.getCode());
								//报送返回错误信息
								handleDetailTab.setSubmissionError("该报告已上报过，请勿重复上报");
								//创建时间
								handleDetailTab.setCreateDate(new Date());
								//入库
								handleDetailTabMapper.insertSelective(handleDetailTab);
							}
						});
						//数据正常入库
						handleDetailTabQueryDomain.setNotExistHandle(new NotExistHandle<HandleDetailTabQueryDomain>() {
							@Override
							public void handle(HandleDetailTabQueryDomain t) throws BaseException {
								HandleDetailTab handleDetailTab = new HandleDetailTab();
								handleDetailTab.setId(null);
								//处理文件表主键
								handleDetailTab.setFileId(handleFileTab.getId());
								//文件创建人代码
								handleDetailTab.setFileCreaterCode(handleFileTab.getFileCreaterCode());
								//文件接收人代码
								handleDetailTab.setFileReceiverCode(handleFileTab.getFileReceiverCode());
								String interfaceId = handleFileTab.getInterfaceId();
								//接口标识
								handleDetailTab.setInterfaceId(interfaceId);	
								//报送日期
								handleDetailTab.setSubmissionDate(handleFileTab.getSubmissionDate());
								//文件序号
								handleDetailTab.setFileNum(handleFileTab.getFileNum());
								//操作标识
								handleDetailTab.setOperationId(handleFileTab.getOperationId());
								//报送记录号
								handleDetailTab.setSubmissionRecordId(loopEntity.getSubmissionRecordId());
								//接口信息参数
								InterfaceParam interfaceParam = info.get(interfaceId);
								//将文本内容转化为对应的json内容相关的domain
								ConversionDomain conversionDomain = new ConversionDomain(loopEntity, loopEntityTuple, interfaceParam, separator);
								//json数据
								handleDetailTab.setDataJson(conversionDomain.conversion());	
								//状态 已入库：11
								handleDetailTab.setStatus(HandleDetailTabStatus.WAREHOUSING.getCode());
								//创建时间
								handleDetailTab.setCreateDate(new Date());
								//入库
								handleDetailTabMapper.insertSelective(handleDetailTab);
							}
						});
						//查询处理明细表数据用于比对
						handleDetailTabQueryDomain.queryForComparison();
					}
				});
				//循环完毕操作接口
				handlePlainTabQueryDomain.setLoopEndHandle(new LoopEndHandle<HandlePlainTabQueryDomain>() {
					@Override
					public void handle(HandlePlainTabQueryDomain t) throws BaseException {
						String zipFileName = handleFileTab.getZipFileName();
						File zipFile = new File(scanDir, zipFileName+".ZIP");
						//将zip文件移动到备份目录
						try {
							FileUtils.copyFileToDirectory(zipFile, backupDir, true);
						} catch (Exception e) {
							logger.info("将zip文件("+zipFile.getPath()+")移动到备份目录出错！！", e.fillInStackTrace());
						}
						//删除临时目录/zipFileName
						File srcDir = new File(tempDir, zipFileName);
						try {
							FileUtils.deleteDirectory(srcDir);
						} catch (Exception e) {
							logger.info("删除临时目录/zipFileName("+srcDir.getPath()+")出错！！", e.fillInStackTrace());
						}
						//删除文件内容表与文件内容元组表数据
					}
				});
				//查询文件内容表数据
				handlePlainTabQueryDomain.query();
			}
		});
		
		//根据字段status查询处理文件表数据
		handleFileTabQueryDomain.queryByStatus();
	}
	
	
	
}
