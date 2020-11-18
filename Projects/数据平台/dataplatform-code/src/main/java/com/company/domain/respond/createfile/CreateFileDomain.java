package com.company.domain.respond.createfile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.base.exception.BaseException;
import com.company.domain.analysis.AnalysisFileDomain;
import com.company.domain.analysis.FinallyHandle;
import com.company.domain.analysis.FirstLineHandle;
import com.company.domain.analysis.PlainLoopEndHandle;
import com.company.domain.analysis.PlainLoopHandle;
import com.company.domain.query.FirstHandle;
import com.company.domain.query.LoopEndHandle;
import com.company.domain.query.LoopHandle;
import com.company.domain.query.handledetail.HandleDetailTabQueryDomain;
import com.company.enums.HandleDetailTabStatus;
import com.company.enums.HandleFileTabStatus;
import com.company.enums.SubmissionError;
import com.company.one.handledetail.model.HandleDetailTab;
import com.company.one.handlefile.dao.HandleFileTabMapper;
import com.company.one.handlefile.model.HandleFileTab;
import com.company.utils.DateUtils;
import com.company.utils.DateUtils.DATE_PATTERN;
import com.company.utils.FileUtils;
import com.company.utils.StringUtils;

/**
 * 生成应答文件的domain
 * @author yangyanchao
 *
 */
public class CreateFileDomain {
	
	private Logger logger = LoggerFactory.getLogger(CreateFileDomain.class);
	
	/**
	 * 压缩文件名
	 */
	private String zipFileName;
	
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
	 * 生成文件存在目录--应答目录/zipName/
	 */
	private File destDir;
	
	/**
	 * 字段分隔符
	 */
	private String separator;

	/**
	 * 换行符
	 */
	private String linefeed;

	/**
	 * 结束字符
	 */
	private String end;
	
	/**
     * 文件创建人代码
     */
    private String fileCreaterCode;

    /**
     * 文件接收人代码
     */
    private String fileReceiverCode;

    /**
	 * 接口编号
	 */
	private String interfaceId;
	
	/**
	 * 数据日期
	 */
	private String submissionDate = DateUtils.dataToString(new Date(),DATE_PATTERN.YYYYMMDD);
	
	/**
	 * 当日序号
	 */
	private String fileNum;
	
	/**
	 * 操作标识
	 */
	private String operationId = "R";
	
	/**
	 * 文件扩展名
	 */
	private String fileExt = "TXT";
	
	/**
	 * 报送错误枚举类
	 */
	private SubmissionError submissionError;

	private BufferedOutputStream bos = null;

	private FileOutputStream fos = null;
	
	/**
     * 处理文件--Mapper类
     */
    @Autowired
    private HandleFileTabMapper handleFileTabMapper;
	
	public CreateFileDomain() {
		super();
	}
	
	public CreateFileDomain(SubmissionError submissionError,String zipFileName, File scanDir ,File backupDir ,File tempDir,File destDir, String fileCreaterCode, String fileReceiverCode, 
			String interfaceId, String fileNum,
			String separator, String linefeed, String end) {
		super();
		this.submissionError = submissionError;
		this.zipFileName = zipFileName;
		this.scanDir = scanDir;
		this.backupDir = backupDir;
		this.tempDir = tempDir;
		this.destDir = destDir;
		this.fileCreaterCode = fileCreaterCode;
		this.fileReceiverCode = fileReceiverCode;
		this.interfaceId = interfaceId;
		this.fileNum = fileNum;
		this.separator = separator;
		this.linefeed = linefeed;
		this.end = end;
	}
	
	public CreateFileDomain(File destDir, String fileCreaterCode, String fileReceiverCode, 
			String interfaceId, String fileNum,
			String separator, String linefeed, String end) {
		super();
		this.destDir = destDir;
		this.fileCreaterCode = fileCreaterCode;
		this.fileReceiverCode = fileReceiverCode;
		this.interfaceId = interfaceId;
		this.fileNum = fileNum;
		this.separator = separator;
		this.linefeed = linefeed;
		this.end = end;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public File getDestDir() {
		return destDir;
	}

	public void setDestDir(File destDir) {
		this.destDir = destDir;
	}

	public String getFileCreaterCode() {
		return fileCreaterCode;
	}

	public void setFileCreaterCode(String fileCreaterCode) {
		this.fileCreaterCode = fileCreaterCode;
	}

	public String getFileReceiverCode() {
		return fileReceiverCode;
	}

	public void setFileReceiverCode(String fileReceiverCode) {
		this.fileReceiverCode = fileReceiverCode;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
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
	
	/**
	 * 获取文件名称
	 * @return
	 */
	public String toFileName() {
		return "OTC_" + fileReceiverCode + "_" + fileCreaterCode 
				+ "_" + interfaceId+ "_" + submissionDate
				+ "_" + fileNum + "_" + operationId + "." + fileExt;
	}
	
	/**
	 * 获取应答记录号
	 * 文件创建人代码（6位）+文件接收人代码（6位）+报送日期（8位）+当日顺序编号（8位）
	 * @return
	 */
	public String toAnsId(int num) {
		return fileReceiverCode + fileCreaterCode + submissionDate +
				String.format("%08d", num);
	}

	/**
	 * 将file内容解析 生成应答文件
	 */
	public void respondByAnalysisDomain(AnalysisFileDomain analysisDomain) throws BaseException {
		//应答文件
		File respondFile = new File(destDir, this.toFileName());
		try {
			fos = new FileOutputStream(respondFile);
		} catch (FileNotFoundException e1) {
			logger.info("文件不存在。",e1.fillInStackTrace());
		}
		bos = new BufferedOutputStream(fos);
		
		//finlly处理操作接口
		analysisDomain.setFinallyHandle(new FinallyHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) {
				try {
					if(bos != null){
						bos.close();
					}
					if(fos != null){
						fos.close();
					}
				} catch (Exception e) {
					logger.info("生成应答文件--流关闭出错",e.fillInStackTrace());
				}
			}
		});
		
		//普通信息循环处理操作
		analysisDomain.setPlainLoopHandle(new PlainLoopHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) throws BaseException{
				Matcher plainMatcher = analysisDomain.getPlainItemMatcher();
				String submissionRecordId = plainMatcher.group(1);
				int plainItemCount = analysisDomain.getPlainItemCount();
		        StringBuilder sb = new StringBuilder();
		        sb.append(StringUtils.transfDeal(toAnsId(plainItemCount+1))).append(separator);
		        sb.append(StringUtils.transfDeal(submissionRecordId)).append(separator);
		        sb.append(StringUtils.transfDeal("N")).append(separator);
		        sb.append(StringUtils.transfDeal(DateUtils.dataToString(new Date(),DATE_PATTERN.YYYYMMDDHH_MM_SS))).append(separator);
		        sb.append(submissionError.getValue()).append(separator);
		        sb.append(StringUtils.decode(linefeed));
				try {
					bos.write(sb.toString().getBytes("utf-8"));
					bos.flush();
				} catch (Exception e) {
					logger.info("生成应答文件--写入内容出错",e.fillInStackTrace());
					throw new BaseException("生成应答文件--写入内容出错", e);
				}
			}
		});
		//普通信息循环结束处理操作
		analysisDomain.setPlainLoopEndHandle(new PlainLoopEndHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) throws BaseException{
				StringBuilder sb = new StringBuilder(end);
				try {
					bos.write(sb.toString().getBytes("utf-8"));
					bos.flush();
				} catch (Exception e) {
					logger.info("生成应答文件--写入内容出错",e.fillInStackTrace());
					throw new BaseException("生成应答文件--写入内容出错", e);
				}
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
			}
		});
		//首行信息处理操作
		analysisDomain.setFirstLineHandle(new FirstLineHandle<AnalysisFileDomain>() {
			@Override
			public void handle(AnalysisFileDomain analysisDomain) throws BaseException{
				StringBuilder sb = new StringBuilder(analysisDomain.getTempLine());
				sb.append(StringUtils.decode(linefeed));
				try {
					bos.write(sb.toString().getBytes("utf-8"));
					bos.flush();
				} catch (Exception e) {
					logger.info("生成应答文件--写入内容出错",e.fillInStackTrace());
					throw new BaseException("生成应答文件--写入内容出错", e);
				}
			}
		});
		//文件解析--生成应答文件
		analysisDomain.analysis();
	}
	
	/**
	 * 遍历明细表数据生成应答文件
	 */
	public void respondByHandleDetailTabQueryDomain(HandleDetailTabQueryDomain handleDetailTabQueryDomain) throws BaseException {
		//应答文件
		File respondFile = new File(destDir, this.toFileName());
		try {
			fos = new FileOutputStream(respondFile);
		} catch (FileNotFoundException e1) {
			logger.info("文件不存在。",e1.fillInStackTrace());
		}
		bos = new BufferedOutputStream(fos);
		//第一次操作
		handleDetailTabQueryDomain.setFirstHandle(new FirstHandle<HandleDetailTabQueryDomain>() {
			@Override
			public void handle(HandleDetailTabQueryDomain t) throws BaseException {
				StringBuilder sb = new StringBuilder();
				sb.append(t.getTotalNum());
				sb.append(StringUtils.decode(linefeed));
				try {
					bos.write(sb.toString().getBytes("utf-8"));
					bos.flush();
				} catch (Exception e) {
					logger.info("生成应答文件--写入内容出错",e.fillInStackTrace());
					throw new BaseException("生成应答文件--写入内容出错", e);
				}
			}
		});
		//循环处理明细表操作
		handleDetailTabQueryDomain.setLoopHandle(new LoopHandle<HandleDetailTabQueryDomain>() {
			@Override
			public void handle(HandleDetailTabQueryDomain t) throws BaseException {
				HandleDetailTab handleDetailTab = t.getLoopEntity();
				int currCount = t.getCurrCount();
				String submissionRecordId = handleDetailTab.getSubmissionRecordId();
				int status = handleDetailTab.getStatus();
				String execType = (status==HandleDetailTabStatus.SUBMITTEDSUCCESS.getCode()?"Y":"N");
				String ansDetail = "";
				if(status==HandleDetailTabStatus.VERIFICATIONERROR.getCode()){
					//校验未通过
					ansDetail = handleDetailTab.getResponseMsg();
				} else if(status==HandleDetailTabStatus.SUBMITTEDERROR.getCode()){
					//上报失败
					ansDetail = handleDetailTab.getSubmissionError();
				}
				StringBuilder sb = new StringBuilder();
		        sb.append(StringUtils.transfDeal(toAnsId(currCount))).append(separator);
		        sb.append(StringUtils.transfDeal(submissionRecordId)).append(separator);
		        sb.append(StringUtils.transfDeal(execType)).append(separator);
		        sb.append(StringUtils.transfDeal(DateUtils.dataToString(new Date(),DATE_PATTERN.YYYYMMDDHH_MM_SS))).append(separator);
		        sb.append(ansDetail).append(separator);
		        sb.append(StringUtils.decode(linefeed));
				try {
					bos.write(sb.toString().getBytes("utf-8"));
					bos.flush();
				} catch (Exception e) {
					logger.info("生成应答文件--写入内容出错",e.fillInStackTrace());
					throw new BaseException("生成应答文件--写入内容出错", e);
				}
			}
		});
		//循环完毕操作
		handleDetailTabQueryDomain.setLoopEndHandle(new LoopEndHandle<HandleDetailTabQueryDomain>() {
			@Override
			public void handle(HandleDetailTabQueryDomain t) throws BaseException {
				StringBuilder sb = new StringBuilder(end);
				try {
					bos.write(sb.toString().getBytes("utf-8"));
					bos.flush();
				} catch (Exception e) {
					logger.info("生成应答文件--写入内容出错",e.fillInStackTrace());
					throw new BaseException("生成应答文件--写入内容出错", e);
				}
				HandleFileTab handleFileTab = t.getHandleFileTab();
				//将处理文件表数据状态置为"已应答：40"
				HandleFileTab record = new HandleFileTab();
				record.setId(handleFileTab.getId());
				record.setStatus(HandleFileTabStatus.RESPOND.getCode());
				handleFileTabMapper.updateByPrimaryKey(record);
			}
		});
		try {
			//查询处理明细表数据
			handleDetailTabQueryDomain.query();
		} catch (Exception e) {
			logger.info("查询处理明细表数据出错",e.fillInStackTrace());
		} finally {
			try {
				if(bos != null){
					bos.close();
				}
				if(fos != null){
					fos.close();
				}
			} catch (Exception e) {
				logger.info("生成应答文件--流关闭出错",e.fillInStackTrace());
			}
		}
	}
}
