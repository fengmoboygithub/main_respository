package com.company.domain.analysisinto;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.config.job.JobParam;
import com.company.domain.analysis.AnalysisFileDomain;
import com.company.domain.batch.BatchDomain;
import com.company.domain.query.ExistHandle;
import com.company.domain.query.NotExistHandle;
import com.company.domain.query.handfile.HandleFileTabQueryDomain;
import com.company.domain.respond.createfile.CreateFileDomain;
import com.company.enums.HandleFileTabStatus;
import com.company.enums.SubmissionError;
import com.company.one.handlefile.dao.HandleFileTabMapper;
import com.company.one.handlefile.model.HandleFileTab;
import com.company.utils.FileUtils;
import com.company.utils.ZipUtils;

/**
 * 解析文件并入库操作域
 * @author yangyanchao
 *
 */
public class AnalysisAndWarehousingDomain {
	/**
	 * 输出日志
	 */
	private Logger logger = LoggerFactory.getLogger(AnalysisAndWarehousingDomain.class);
	
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
	 * 附件目录
	 */
	private File annexDir;
	/**
	 * 应答目录
	 */
	private File respondDir;
	/**
	 * 附件目录名称
	 */
	private String attachmentName;
	/**
	 * 普通信息正则表达式
	 */
	private Pattern plainPattern;
	/**
	 * 元组信息正则正则表达式
	 */
	private Pattern tuplePattern;
	/**
	 * 插入一批次中最多行数
	 */
	private int insertBatchMaxNum;
	/**
	 * 字段分隔符
	 */
	private String separator;
	/**
	 * 换行符
	 */
	private String linefeed;
	/**
	 * 结束符
	 */
	private String end;
	/**
	 * zip文件名正则表达式
	 */
	private String regularZipname;
	/**
	 * txt文件名正则表达式
	 */
	private String regularTxtname;
	
	/**
     * 处理文件--Mapper类
     */
    @Autowired
    private HandleFileTabMapper handleFileTabMapper;
    
    public AnalysisAndWarehousingDomain() {
		super();
	}
    
    public AnalysisAndWarehousingDomain(JobParam jobParam) {
		super();
		//扫描目录
		this.scanDir = jobParam.getScanDir();
		//备份目录
		this.backupDir = jobParam.getBackupDir();
		//临时目录
		this.tempDir = jobParam.getTempDir();
		//附件目录
		this.annexDir = jobParam.getAnnexDir();
		//应答目录
		this.respondDir = jobParam.getRespondDir();
		//附件目录名称
		this.attachmentName = jobParam.getAttachmentName();
		//普通信息正则表达式
		this.plainPattern = Pattern.compile(jobParam.getRegularPlain());
		//元组信息正则正则表达式
		this.tuplePattern = Pattern.compile(jobParam.getRegularTuple());
		//插入一批次中最多行数
		this.insertBatchMaxNum = jobParam.getInsertBatchMaxNum();
		//字段分隔符
		this.separator = jobParam.getSeparator();
		//换行符
		this.linefeed = jobParam.getLinefeed();
		//结束符
		this.end = jobParam.getEnd();
	}

    public File getBackupDir() {
		return backupDir;
	}

	public void setBackupDir(File backupDir) {
		this.backupDir = backupDir;
	}

	public File getScanDir() {
		return scanDir;
	}

	public void setScanDir(File scanDir) {
		this.scanDir = scanDir;
	}

	public File getTempDir() {
		return tempDir;
	}

	public void setTempDir(File tempDir) {
		this.tempDir = tempDir;
	}

	public File getAnnexDir() {
		return annexDir;
	}

	public void setAnnexDir(File annexDir) {
		this.annexDir = annexDir;
	}

	public File getRespondDir() {
		return respondDir;
	}

	public void setRespondDir(File respondDir) {
		this.respondDir = respondDir;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public Pattern getPlainPattern() {
		return plainPattern;
	}

	public void setPlainPattern(Pattern plainPattern) {
		this.plainPattern = plainPattern;
	}

	public Pattern getTuplePattern() {
		return tuplePattern;
	}

	public void setTuplePattern(Pattern tuplePattern) {
		this.tuplePattern = tuplePattern;
	}

	public int getInsertBatchMaxNum() {
		return insertBatchMaxNum;
	}

	public void setInsertBatchMaxNum(int insertBatchMaxNum) {
		this.insertBatchMaxNum = insertBatchMaxNum;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getLinefeed() {
		return linefeed;
	}

	public void setLinefeed(String linefeed) {
		this.linefeed = linefeed;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getRegularZipname() {
		return regularZipname;
	}

	public void setRegularZipname(String regularZipname) {
		this.regularZipname = regularZipname;
	}

	public String getRegularTxtname() {
		return regularTxtname;
	}

	public void setRegularTxtname(String regularTxtname) {
		this.regularTxtname = regularTxtname;
	}

	/**
	 * 扫描指定目录下的文件进行解析入库临时表   
	 * 该过程没有事务 原因：由于文件数据量过10W+时 数据库应分批次提交事务
	 * @throws BaseException
	 */
	public void analysisAndWarehousingToTemp() throws BaseException {
		//获取扫描目录下文件名符合regularZipPattern这个正则表达式的文件列表
		File[] scanFileList = scanDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				Pattern regularZipPattern = Pattern.compile(regularZipname);
				Matcher fileNameMatcher = regularZipPattern.matcher(pathname.getName());
				return fileNameMatcher.find();
			}
		});
		if(scanFileList != null && scanFileList.length > 0){
			for(File zipFile : scanFileList){
				//获取zipName文件名中的机构号（业务用户9位截取前6位）
				Pattern regularZipPattern = Pattern.compile(regularZipname);
				Matcher fileNameMatcher = regularZipPattern.matcher(zipFile.getName());
				String orgIdByZipName = "";
				if(fileNameMatcher.find()){
					orgIdByZipName = fileNameMatcher.group(4);
					if(orgIdByZipName.length() > 6){
						orgIdByZipName = orgIdByZipName.substring(0, 6);
					}
				}
				//获取压缩文件名称 去除后缀
				String zipName = FileUtils.getFileName(zipFile);
				//将压缩文件解压到临时目录中
				ZipUtils.unZip(zipFile, tempDir.getPath());
				//获取临时目录/zipName目录
				File txtParentDir = new File(tempDir,zipName);
				//获取临时目录/zipName目录文件列表
				File[] txtFiles = txtParentDir.listFiles();
				//TXT正则表达式
				Pattern regularTxtPattern = Pattern.compile(regularTxtname);
				if(txtFiles != null && txtFiles.length > 0){
					for(File txtFile : txtFiles){
						Matcher regularTxtMatcher = regularTxtPattern.matcher(txtFile.getName());
						if(regularTxtMatcher.find()){
							//比对TXT文件（文件创建人代码）与它的父目录zipName目录（业务用户9位截取前6位）
							String orgId = regularTxtMatcher.group(1);
							if(orgId.equals(orgIdByZipName)){
								//若一致则获取TXT文件hash
								String txtHash = FileUtils.getFileHash(txtFile);
								//处理文件表相关查询域
								HandleFileTabQueryDomain handleFileTabQueryDomain = new HandleFileTabQueryDomain(txtHash);
								handleFileTabQueryDomain.setExistHandle(new ExistHandle<HandleFileTabQueryDomain>() {
									public void handle(HandleFileTabQueryDomain t) throws BaseException {
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
										CreateFileDomain createFileDomain = new CreateFileDomain(SubmissionError.REPEAT, zipName, zipFile, txtParentDir, txtFile, destDir, fileCreaterCode, fileReceiverCode, interfaceId, fileNum, fileReceiverCode, interfaceId, fileNum);
										//将file内容解析 生成应答文件 将A.zip移动到备份目录中，删除临时目录/A
										createFileDomain.respondByAnalysisDomain(analysisDomain);
									}
								});
								handleFileTabQueryDomain.setNotExistHandle(new NotExistHandle<HandleFileTabQueryDomain>() {
									@Override
									public void handle(HandleFileTabQueryDomain t) throws BaseException {
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
								});
								handleFileTabQueryDomain.queryByhashFileEntity();
								
							} else {
								//若不一致则解析B.txt文本，生成应答文件(失败原因："文件名中的机构号与压缩文件中的不一致")，将A.zip移动到备份目录中，删除临时目录/A
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
								CreateFileDomain createFileDomain = new CreateFileDomain(SubmissionError.FILEANDZIPATYPISM, zipName, zipFile, txtParentDir, txtFile, destDir, fileCreaterCode, fileReceiverCode, interfaceId, fileNum, fileReceiverCode, interfaceId, fileNum);
								//将file内容解析 生成应答文件 将A.zip移动到备份目录中，删除临时目录/A
								createFileDomain.respondByAnalysisDomain(analysisDomain);
							}
						}
					}
				}
			}
		}
	}
}
