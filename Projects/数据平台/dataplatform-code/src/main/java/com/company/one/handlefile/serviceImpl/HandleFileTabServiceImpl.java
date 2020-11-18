package com.company.one.handlefile.serviceImpl;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.config.interfaceinfo.InterfaceParamInfo;
import com.company.config.job.JobParam;
import com.company.domain.analysis.AnalysisFileDomain;
import com.company.domain.batch.BatchDomain;
import com.company.domain.respond.createfile.CreateFileDomain;
import com.company.enums.HandleFileTabStatus;
import com.company.one.handledetail.dao.HandleDetailTabMapper;
import com.company.one.handlefieldindex.dao.HandleFieldIndexTabMapper;
import com.company.one.handlefile.dao.HandleFileTabMapper;
import com.company.one.handlefile.model.HandleFileTab;
import com.company.one.handlefile.model.HandleFileTabExample;
import com.company.one.handlefile.model.HandleFileTabExample.Criteria;
import com.company.one.handlefile.service.HandleFileTabService;
import com.company.one.handleplain.dao.HandlePlainTmpMapper;
import com.company.one.handletuple.dao.HandleTupleTmpMapper;
import com.company.one.syslogging.dao.SysLoggingTabMapper;
import com.company.two.templatetab.dao.TabTemplateMapper;
import com.company.utils.FileUtils;
import com.company.utils.ZipUtils;

/**
 * 处理文件服务类
 * @author yangyanchao
 */
@Service
public class HandleFileTabServiceImpl extends BaseServiceImpl<HandleFileTab, HandleFileTabExample> implements HandleFileTabService<HandleFileTab, HandleFileTabExample>{
	private Logger logger = LoggerFactory.getLogger(HandleFileTabServiceImpl.class);
    
	/**
     * 处理文件--Mapper类
     */
    @Autowired
    private HandleFileTabMapper handleFileTabMapper;
    
    /**
	 * 文件内容--Mapper类
	 */
	@Autowired
	private HandlePlainTmpMapper handlePlainTmpMapper;
	/**
	 * 文件内容元组--Mapper类
	 */
	@Autowired
	private HandleTupleTmpMapper handleTupleTmpMapper;
    
	/**
	 * 接口模板--Mapper类
	 */
	@Autowired
	private TabTemplateMapper tabTemplateMapper;
	/**
	 * 字段索引--Mapper类
	 */
	@Autowired
    private HandleFieldIndexTabMapper handleFieldIndexTabMapper;
	/**
	 * 处理明细--Mapper类
	 */
	@Autowired
	private HandleDetailTabMapper handleDetailTabMapper;
	/**
	 * 系统日志--Mapper类
	 */
	@Autowired
	private SysLoggingTabMapper sysLoggingTabMapper;
	
	/**
	 * 扫描指定目录下的文件进行解析入库临时表   
	 * 该过程没有事务 原因：由于文件数据量过10W+时 数据库应分批次提交事务
	 * @param jobParam
	 * @throws BaseException
	 */
	@Override
	public void analysisAndWarehousingToTemp(JobParam jobParam) throws BaseException {
		//扫描目录
		File scanDir = jobParam.getScanDir();
		//临时目录
		File tempDir = jobParam.getTempDir();
		//附件目录
		File annexDir = jobParam.getAnnexDir();
		//应答目录
		File respondDir = jobParam.getRespondDir();
		//附件目录名称
		String attachmentName = jobParam.getAttachmentName();
		//普通信息正则表达式
		Pattern plainPattern = Pattern.compile(jobParam.getRegularPlain());
		//元组信息正则正则表达式
		Pattern tuplePattern = Pattern.compile(jobParam.getRegularTuple());
		//插入一批次中最多行数
		int insertBatchMaxNum = jobParam.getInsertBatchMaxNum();
		//字段分隔符
		String separator = jobParam.getSeparator();
		//换行符
		String linefeed = jobParam.getLinefeed();
		//结束符
		String end = jobParam.getEnd();
		//获取扫描目录下文件名符合regularZipPattern这个正则表达式的文件列表
		File[] scanFileList = scanDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				Pattern regularZipPattern = Pattern.compile(jobParam.getRegularZipname());
				Matcher fileNameMatcher = regularZipPattern.matcher(pathname.getName());
				return fileNameMatcher.find();
			}
		});
		if(scanFileList != null && scanFileList.length > 0){
			for(File zipFile : scanFileList){
				//获取压缩文件名称 去除后缀
				String zipName = FileUtils.getFileName(zipFile);
				//将压缩文件解压到临时目录中
				ZipUtils.unZip(zipFile, tempDir.getPath());
				//获取临时目录/zipName目录
				File txtParentDir = new File(tempDir,zipName);
				//获取临时目录/zipName目录文件列表
				File[] txtFiles = txtParentDir.listFiles();
				//TXT正则表达式
				Pattern regularTxtPattern = Pattern.compile(jobParam.getRegularTxtname());
				if(txtFiles != null && txtFiles.length > 0){
					for(File txtFile : txtFiles){
						Matcher regularTxtMatcher = regularTxtPattern.matcher(txtFile.getName());
						if(regularTxtMatcher.find()){
							//匹配成功获取TXT文件hash
							String txtHash = FileUtils.getFileHash(txtFile);
							//根据字段hash_file_entity查询处理文件表数据
							HandleFileTabExample example = new HandleFileTabExample();
							Criteria criteria = example.createCriteria();
							criteria.andHashFileEntityEqualTo(txtHash);
							List<HandleFileTab> handleFileTabList = handleFileTabMapper.selectByExample(example);
							if(handleFileTabList != null && handleFileTabList.size() > 0){
								//若存在则是重复传送且内容重复的文件，解析txt文本，生成应答文件(失败原因："该报告已上报过，请勿重复上报")
								//文件解析域
								AnalysisFileDomain analysisDomain = new AnalysisFileDomain(txtFile, end, plainPattern, tuplePattern);
								File destDir = new File(respondDir, zipName);
								//文件创建人代码
								String fileCreaterCode = regularTxtMatcher.group(1);
								//文件接收人代码
								String fileReceiverCode = regularTxtMatcher.group(2);
								//接口标识
								String interfaceId = regularTxtMatcher.group(3);
								//文件序号
								String fileNum = regularTxtMatcher.group(5);
								//生成应答文件域
								CreateFileDomain createFileDomain = new CreateFileDomain(destDir, fileCreaterCode, fileReceiverCode, interfaceId, fileNum, separator, linefeed, end);
								//将file内容解析 生成应答文件
								createFileDomain.respondByAnalysisDomain(analysisDomain);
							} else {
								//若不存在则获取临时目录/zipName/ATTACHMENT
								File attachmentDir = new File(txtParentDir,attachmentName);
								if(attachmentDir.exists()){
									//将临时目录/zipName/ATTACHMENT复制到附件目录/zipName/ATTACHMENT下
									try {
										FileUtils.copyDirectory(attachmentDir, new File(annexDir, zipName+File.separator+attachmentName) , true);
									} catch (Exception e) {
										logger.info("将临时目录/"+zipName+"/"+attachmentName+"复制到附件目录/"+zipName+"/"+attachmentName+"失败", e.fillInStackTrace());
									}
								}
								//获取TXT文件信息
								HandleFileTab handleFileTab = new HandleFileTab();
								//压缩文件名
								handleFileTab.setZipFileName(zipName);
								//TXT文件名
								handleFileTab.setFileName(FileUtils.getFileName(txtFile));
								//TXT文件hash
								handleFileTab.setHashFileEntity(txtHash);
								//文件创建人代码
								handleFileTab.setFileCreaterCode(regularTxtMatcher.group(1));
								//文件接收人代码
								handleFileTab.setFileReceiverCode(regularTxtMatcher.group(2));
								//接口标识
								handleFileTab.setInterfaceId(regularTxtMatcher.group(3));
								//数据日期
								handleFileTab.setSubmissionDate(regularTxtMatcher.group(4));
								//文件序号
								handleFileTab.setFileNum(regularTxtMatcher.group(5));
								//操作标识
								handleFileTab.setOperationId(regularTxtMatcher.group(6));
								//状态
								handleFileTab.setStatus(HandleFileTabStatus.WAREHOUSING.getCode());
								//创建时间
								handleFileTab.setCreateDate(new Date());
								//将文件信息存入处理文件表
								handleFileTabMapper.insertSelective(handleFileTab);
								//获取主键
								Integer handleFileId = handleFileTab.getId();
								//文件解析域
								AnalysisFileDomain analysisDomain = new AnalysisFileDomain(txtFile, end, plainPattern, tuplePattern);
								//批量操作域
								BatchDomain batchDomain = new BatchDomain(handleFileId, insertBatchMaxNum);
								//文件解析并将文件内容批量导入
								batchDomain.batchInsert(analysisDomain);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 查询临时表数据进行比对入库正式表
	 * 该过程有事务
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void comparisonAndWarehousingToFormal(JobParam jobParam, InterfaceParamInfo interfaceParamInfo) throws BaseException {
		//备份目录
		File backupDir = jobParam.getBackupDir();
		//临时目录
		File tempDir = jobParam.getTempDir();
	}
	
	/**
	 * 校验数据合法性，若不通过记录原因
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void verification() throws BaseException {
		
	}
	
	/**
	 * 报送数据，若报送失败记录原因
	 * @throws BaseException
	 */
	@Override
	public void submitted() throws BaseException {
		
	}
	
	/**
	 * 查询数据，生成应答文件
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void respond(JobParam jobParam) throws BaseException {
		
	}
}