package com.company.projectdirectory.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.basedirectory.dao.BaseDirectoryMapper;
import com.company.basedirectory.model.BaseDirectoryExample;
import com.company.constant.BaseConstant;
import com.company.directoryversion.dao.DirectoryVersionMapper;
import com.company.directoryversion.model.DirectoryVersion;
import com.company.directoryversion.model.DirectoryVersionExample;
import com.company.directoryversion.service.DirectoryVersionService;
import com.company.docuserremarksmap.dao.DocUserRemarksMapMapper;
import com.company.docuserremarksmap.model.DocUserRemarksMap;
import com.company.docuserremarksmap.model.DocUserRemarksMapExample;
import com.company.enums.ManuscriptInfoApply;
import com.company.enums.ManuscriptInfoStatus;
import com.company.enums.ProjectDirectoryStatus;
import com.company.enums.ProjectDirectoryType;
import com.company.manuscriptinfo.dao.ManuscriptInfoMapper;
import com.company.manuscriptinfo.model.ManuscriptInfo;
import com.company.manuscriptinfo.model.ManuscriptInfoExample;
import com.company.manuscriptinfo.service.ManuscriptInfoService;
import com.company.manuscriptversion.dao.ManuscriptVersionMapper;
import com.company.manuscriptversion.model.ManuscriptVersion;
import com.company.manuscriptversion.model.ManuscriptVersionExample;
import com.company.processnodeinfo.dao.ProcessNodeInfoMapper;
import com.company.processnodeinfo.model.ProcessNodeInfo;
import com.company.projectdirectory.dao.ProjectDirectoryMapper;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.model.ProjectDirectoryExample;
import com.company.projectdirectory.model.ProjectDirectoryExample.Criteria;
import com.company.projectdirectory.model.ProjectDirectoryKey;
import com.company.projectdirectory.service.ProjectDirectoryService;
import com.company.projectdirectory.view.ProjectDirectoryTree;
import com.company.projectinfo.dao.ProjectInfoMapper;
import com.company.projectinfo.model.ProjectInfo;
import com.company.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ProjectDirectoryServiceImpl extends BaseServiceImpl<ProjectDirectory, ProjectDirectoryExample> implements ProjectDirectoryService<ProjectDirectory, ProjectDirectoryExample>{

    /**
     * 项目目录信息mapper
     */
    @Autowired
    private ProjectDirectoryMapper mapper;

	/**
	 * 项目信息mapper
	 */
	@Autowired
	private ProjectInfoMapper projectInfoMapper;
    
    /**
     * 底稿信息mapper
     */
    @Autowired
    private ManuscriptInfoMapper manuscriptInfoMapper;

    @Autowired
    private ManuscriptInfoService manuscriptInfoService;

	/**
	 * 目录版本mapper
	 */
	@Autowired
	private DirectoryVersionMapper directoryVersionMapper;

	@Autowired
	public ManuscriptVersionMapper manuscriptVersionMapper;

	/**
	 * 备注信息关系mapper
	 */
	@Autowired
	private DocUserRemarksMapMapper docUserRemarksMapMapper;

	/**
	 * 基础目录mapper
	 */
	@Autowired
	private BaseDirectoryMapper baseDirectoryMapper;

	@Autowired
	private DirectoryVersionService directoryVersionService;

	@Autowired
	private ProcessNodeInfoMapper processNodeInfoMapper;

	/**
	 * 上传资源目录
	 */
	@Value("${web.upload-file-path}")
	private String fileUploadPath;

	/**
	 * 导出文件目录
	 */
	@Value("${web.download-file-path}")
	private String fileDownloadPath;

	
	public IBaseDao<ProjectDirectory, ProjectDirectoryExample> getMapper(){
		return mapper;
	}

	public static Logger logger = LoggerFactory.getLogger(ProjectDirectoryServiceImpl.class);
	/**
	 * 项目目录树含底稿文件(全部)查询
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @param directoryid 项目目录id
	 * @return
	 */
	public String writeZipFile(String projectid, String projectStage, String directoryid){
		LocalDate end = LocalDate.now();
		ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectid);
		String filename = projectInfo.getProjectname() + "-" + projectInfo.getStagename() + "-" + end.format(DateTimeFormatter.ISO_DATE);
		ProjectDirectoryKey key = new ProjectDirectoryKey();
		key.setProjectid(projectid);
		key.setDirectoryid(directoryid);
		ProjectDirectory entity = mapper.selectByPrimaryKey(key);
		String rootPath = fileDownloadPath + filename + File.separatorChar + entity.getFullname();
		this.viewTreeByProjectDirectoryForDeepToFile(projectid, directoryid, rootPath);
		//目录压缩
		File destDir = new File(fileDownloadPath + filename);
		String zipName = destDir.getName()+".zip";
		try {
			FileOutputStream fos1 = new FileOutputStream(new File(destDir.getParent()+File.separatorChar+zipName));
			ZipUtils.toZip(destDir.getAbsolutePath(), fos1,true);
			FileUtils.deleteDirectory(destDir);
		} catch (Exception e) {
			logger.error("压缩文件失败", e.fillInStackTrace());
		}
		return zipName;
	}

	/**
	 * 项目目录树含底稿文件(haxVal)查询
	 * @param projectid 项目id
	 * @param projectStage 项目阶段
	 * @param directoryid 项目目录id
	 * @return
	 */
	public String writeTextFile(String projectid, String projectStage, String directoryid){
		LocalDate end = LocalDate.now();
		ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectid);
		ProjectDirectoryKey key = new ProjectDirectoryKey();
		key.setProjectid(projectid);
		key.setDirectoryid(directoryid);
		ProjectDirectory entity = mapper.selectByPrimaryKey(key);
		String filename = projectInfo.getProjectname() + "-" + projectInfo.getStagename() + "-" +  entity.getFullname() + "-" + end.format(DateTimeFormatter.ISO_DATE) + ".txt";
		String rootFilePath = fileDownloadPath + filename;
		Map<String, Object> map = new HashMap<String, Object>();
		String fileContont = entity.getFullname() + "\n";
		Integer level = 0;
		map.put("fileContont", fileContont);
		map.put("level", level);
		this.viewTreeByProjectDirectoryForDeepToTxtFile(projectid, projectStage, directoryid, map);
		File destDir = new File(rootFilePath);
		//写入文本文件
		FileUtils.writeFile(destDir, (String) map.get("fileContont"));
		return filename;
		//目录压缩
//		String zipName = destDir.getName()+".zip";
//		try {
//			FileOutputStream fos1 = new FileOutputStream(new File(destDir.getParent()+File.separatorChar+zipName));
//			ZipUtils.toZip(destDir.getAbsolutePath(), fos1,true);
//			FileUtils.deleteDirectory(destDir);
//		} catch (Exception e) {
//			logger.error("压缩文件失败", e.fillInStackTrace());
//		}
//		return zipName;
	}

	@Override
	public String getSonTreeJson(String projectId, String projectStage, String directoryid) {
		//查询目录下全部子目录和子文件
		List<ProjectDirectoryTree> sonList = this.viewTree(projectId,projectStage,directoryid);
		JSONArray jsonArray = new JSONArray();
		for(ProjectDirectoryTree pdt:sonList){
			if("file".equals(pdt.getType())){	//如果是文件，则拼装json
				JSONObject json = new JSONObject();
				json.put("type",pdt.getType());
				json.put("name",pdt.getName());
				json.put("value",pdt.getHashname());
				json.put("isapp",pdt.getIsapp());
				jsonArray.add(json);
			}else if("dir".equals(pdt.getType())){	//如果是目录，则再去下钻查询
				getSonTreeJson(projectId,projectStage,directoryid);
			}
		}
		return jsonArray.toString();
	}

	/**
	 * 查询全部项目目录树(只有目录)
	 * @param projectid 项目id
	 * @return
	 */
	@Override
	public List<ProjectDirectoryTree> viewAllProjectDirectoryTree(String projectid) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		//获取项目id和适用并且父id为null的数据--递归获取此项目下的所有数据
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(projectid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewAllProjectDirectoryTreeForDeep(projectid1, directoryid1);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		return list;
	}

	/**
	 * 查询全部项目目录树(只有目录)用于递归（适用）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	public List<ProjectDirectoryTree> viewAllProjectDirectoryTreeForDeep(String projectid, String directoryid) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewAllProjectDirectoryTreeForDeep(projectid1, directoryid1);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		return list;
	}

	/**
	 * 查询目录所有根目录节点
	 * @param projectid 项目id
	 * @return
	 */
	@Override
	public List<ProjectDirectoryTree> viewRootProjectDirectoryTree(String projectid) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		//获取项目id和适用并且父id为null的数据--递归获取此项目下的所有数据
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(projectid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				list.add(pdt);
			}
		}
		return list;
	}

	/**
	 * 查询下级目录并拼接json
	 * @param projectid 项目id
	 * @param directoryid
	 * @param hashnameMap
	 * @param versioncompositionMap
	 * @return
	 */
	@Override
	public List<DirectoryVersion> viewTreeJsonList(String projectid, String directoryid, Map hashnameMap, Map versioncompositionMap) {
		List dvList = new ArrayList();
		//通过项目id和目录id获取此目录下全部目录
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
//			JSONArray jsonArray = new JSONArray();
			for(ProjectDirectory pd : tempList){
				String directoryid1 = pd.getDirectoryid();
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeJsonListForDeep(projectid, directoryid1, hashnameMap, versioncompositionMap);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					dvList.addAll(projectDirectoryList);
				}else{
					JSONArray jsonArray1 = new JSONArray();
					JSONObject json = new JSONObject();
					json.put("type",ProjectDirectoryType.DIR.getCode());
					json.put("name",pd.getFullname());
					json.put("value",pd.getVersionhash()==null?"":pd.getVersionhash());
					json.put("isapp",1);
					jsonArray1.add(json);
					DirectoryVersion dv = new DirectoryVersion();
					dv.setId(UUID.randomUUID().toString().replace("-",""));
					dv.setProjectid(projectid);
					dv.setDirectoryid(directoryid1);
					dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
					dv.setCreateTime(new Date());
//					dv.setCreateUser("1");
					dv.setUpdateTime(new Date());
//					dv.setUpdateUser("1");
					//版本组成，最底层目录没有版本组成，也没有hash
					dv.setVersioncomposition("");
					versioncompositionMap.put(directoryid1,json);
					//目录版本，需要计算版本组成hash
					dv.setVersionhash("");
					hashnameMap.put(directoryid1,dv.getVersionhash());
					dvList.add(dv);
				}
			}
			DirectoryVersion dv = new DirectoryVersion();
			dv.setId(UUID.randomUUID().toString().replace("-",""));
			dv.setProjectid(projectid);
			dv.setDirectoryid(directoryid);
			dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
			dv.setCreateTime(new Date());
//			dv.setCreateUser("1");
			dv.setUpdateTime(new Date());
//			dv.setUpdateUser("1");
			//版本组成，需要拼装json
			//目录版本，需要计算版本组成hash
			//判断目录id是否有hash，没有就放进去，有就取出来放进去
			ProjectDirectoryExample example1 = new ProjectDirectoryExample();
			example1.setOrderByClause(" directoryno asc");
			Criteria criteria1 = example1.createCriteria();
			criteria1.andProjectidEqualTo(projectid);
			criteria1.andDirectoryidEqualTo(directoryid);
			List<ProjectDirectory> tempList1 = mapper.selectByExample(example1);
			JSONArray jsonArray = new JSONArray();
			for(ProjectDirectory pd : tempList){
				if(!"".equals(versioncompositionMap.get(pd.getDirectoryid())) && null!=versioncompositionMap.get(pd.getDirectoryid())){
					jsonArray.add(versioncompositionMap.get(pd.getDirectoryid()));
				}
			}
			JSONObject json = new JSONObject();
			json.put("type",ProjectDirectoryType.DIR.getCode());
			json.put("name",tempList1.get(0).getFullname());
			json.put("value", SHA256Util.getSHA256(jsonArray.toString()));
			json.put("isapp",1);
			dv.setVersioncomposition(jsonArray.toString());
			versioncompositionMap.put(directoryid,json);
			dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
			hashnameMap.put(directoryid, dv.getVersionhash());

			dvList.add(dv);
		}else{
			return null;
		}
		return dvList;
	}



    /**
	 * 查询下级目录并拼装json(递归)
	 * @param projectid
	 * @param directoryid
	 * @param hashnameMap
	 * @param versioncompositionMap
	 * @return
	 */
	public List<ProjectDirectoryTree> viewTreeJsonListForDeep(String projectid, String directoryid, Map hashnameMap, Map versioncompositionMap) {
		List list = new ArrayList<ProjectDirectoryTree>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		//通过项目id和目录id查询是否有下级目录，如果有，则继续递归，如果没有，则返回null，并在上一级拼装json
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
//			JSONArray jsonArray = new JSONArray();
			for(ProjectDirectory pd : tempList){
				String directoryid1 = pd.getDirectoryid();
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeJsonListForDeep(projectid, directoryid1, hashnameMap, versioncompositionMap);
				//如果返回是空的，说明再往下没有目录了，如果返回不是空的，说明下面还有目录，返回的是目录的list
				if(projectDirectoryList != null && projectDirectoryList.size()>0){
					list.addAll(projectDirectoryList);
				}else{
					JSONArray jsonArray = new JSONArray();
					JSONObject json = new JSONObject();
					json.put("type",ProjectDirectoryType.DIR.getCode());
					json.put("name",pd.getFullname());
					json.put("value",pd.getVersionhash()==null?"":pd.getVersionhash());
					json.put("isapp",1);
					jsonArray.add(json);
					DirectoryVersion dv = new DirectoryVersion();
					dv.setId(UUID.randomUUID().toString().replace("-",""));
					dv.setProjectid(projectid);
					dv.setDirectoryid(directoryid1);
					dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
					dv.setCreateTime(new Date());
//					dv.setCreateUser("1");
					dv.setUpdateTime(new Date());
//					dv.setUpdateUser("1");
					//版本组成，最底层目录没有版本组成，也没有hash
					dv.setVersioncomposition("");
					versioncompositionMap.put(directoryid1,json);
					//目录版本，需要计算版本组成hash
					dv.setVersionhash("");
					hashnameMap.put(directoryid1,dv.getVersionhash());
					list.add(dv);
				}
			}
			DirectoryVersion dv = new DirectoryVersion();
			dv.setId(UUID.randomUUID().toString().replace("-",""));
			dv.setProjectid(projectid);
			dv.setDirectoryid(directoryid);
			dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
			dv.setCreateTime(new Date());
//			dv.setCreateUser("1");
			dv.setUpdateTime(new Date());
//			dv.setUpdateUser("1");
			//版本组成，需要拼装json
			//目录版本，需要计算版本组成hash
			//判断目录id是否有hash，没有就放进去，有就取出来放进去
			ProjectDirectoryExample example1 = new ProjectDirectoryExample();
			example1.setOrderByClause(" directoryno asc");
			Criteria criteria1 = example1.createCriteria();
			criteria1.andProjectidEqualTo(projectid);
			criteria1.andDirectoryidEqualTo(directoryid);
			List<ProjectDirectory> tempList1 = mapper.selectByExample(example1);
			JSONArray jsonArray = new JSONArray();
			for(ProjectDirectory pd : tempList){
				if(!"".equals(versioncompositionMap.get(pd.getDirectoryid())) && null!=versioncompositionMap.get(pd.getDirectoryid())){
					jsonArray.add(versioncompositionMap.get(pd.getDirectoryid()));
				}
			}
			JSONObject json = new JSONObject();
			json.put("type",ProjectDirectoryType.DIR.getCode());
			json.put("name",tempList1.get(0).getFullname());
			json.put("value",SHA256Util.getSHA256(jsonArray.toString()));
			json.put("isapp",1);
			dv.setVersioncomposition(jsonArray.toString());
			versioncompositionMap.put(directoryid,json);
			dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
			hashnameMap.put(directoryid, dv.getVersionhash());

			list.add(dv);
		}else{
			return null;
		}
		return list;
	}



	/**
	 * 获取项目目录信息树类型对象用于递归（适用）生成目录
	 * @param projectid
	 * @param directoryid
	 * @param rootPath
	 */
	public void viewTreeByProjectDirectoryForDeepToFile(String projectid, String directoryid, String rootPath) {
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				rootPath += (File.separatorChar + pd.getFullname());
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				this.viewTreeByProjectDirectoryForDeepToFile(projectid1, directoryid1, rootPath);
			}
		}
		this.viewTreeByManuscriptInfoToFile(projectid, directoryid, rootPath);
	}

	/**
	 * 获取项目目录信息树类型对象用于递归（适用）生成树形结构文本文件
	 * @param projectid
	 * @param directoryid
	 * @param map
	 */
	public void viewTreeByProjectDirectoryForDeepToTxtFile(String projectid, String projectStage, String directoryid, Map<String, Object> map) {
		Integer level = (Integer) map.get("level");
		String meContont = (String) map.get("fileContont");
		String prefix = "";
		for(int i = 0; i <= level; i++){
			prefix += "\t";
		}
		meContont += prefix;
		level++;
		map.put("level", level);
		map.put("fileContont", meContont);
		System.out.print(level+"--------------"+meContont);
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andStageLessThanOrEqualTo(projectStage);
		criteria.andParentidEqualTo(directoryid);
		criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				meContont += (pd.getFullname()+"\n");
				System.out.print(meContont);
				map.put("fileContont", meContont);
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				String stage1 = pd.getStage();
				this.viewTreeByProjectDirectoryForDeepToTxtFile(projectid1, stage1, directoryid1, map);
			}
		}
		this.viewTreeByManuscriptInfoToTxtFile(projectid, directoryid, map);
	}

	/**
	 * 获取底稿信息树类型对象（适用）
	 * @param projectid
	 * @param directoryid
	 * @param rootPath
	 */
	private void viewTreeByManuscriptInfoToFile(String projectid, String directoryid, String rootPath){
		ManuscriptInfoExample example = new ManuscriptInfoExample();
		example.setOrderByClause(" orderno asc");
		ManuscriptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andDirectoryidEqualTo(directoryid);
		criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
		List<ManuscriptInfo> tempList = manuscriptInfoMapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ManuscriptInfo mi : tempList){
				File destFile = new File(rootPath + File.separatorChar + mi.getDocname() + ".pdf");
				File srcFile = new File(fileUploadPath + File.separatorChar + mi.getHashname());
				try {
					FileUtils.copyFileToFile(srcFile, destFile);
				} catch (Exception e) {
					logger.error("复制文件失败", e.fillInStackTrace());
				}
			}
		}
	}

	/**
	 * 获取底稿信息树类型对象（适用）
	 * @param projectid
	 * @param directoryid
	 * @param map
	 */
	private void viewTreeByManuscriptInfoToTxtFile(String projectid, String directoryid, Map<String, Object> map){
		String meContont = (String) map.get("fileContont");
		ManuscriptInfoExample example = new ManuscriptInfoExample();
		example.setOrderByClause(" orderno asc");
		ManuscriptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andDirectoryidEqualTo(directoryid);
		criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
		List<ManuscriptInfo> tempList = manuscriptInfoMapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ManuscriptInfo mi : tempList){
				meContont += (mi.getHashname() + "\n");
			}
		}
		System.out.print(meContont);
		map.put("fileContont", meContont);
	}

	/**
	 * 根据项目id和目录id查询下级节点集合并计算hash
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	public String getHashByProjectDirectoryForMe(String projectid, String directoryid) {
		JSONArray jsonArray = new JSONArray();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				JSONObject json = new JSONObject();
				json.put("type",ProjectDirectoryType.DIR.getCode());
				json.put("name",pd.getFullname());
				json.put("value",pd.getVersionhash());
				json.put("isapp",pd.getIsapp());
				jsonArray.add(json);
			}
		}
		List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfoForMe(projectid, directoryid);
		if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
			for(ProjectDirectoryTree pd : manuscriptInfoList){
				JSONObject json = new JSONObject();
				json.put("type",pd.getType());
				json.put("name",pd.getName());
				json.put("value",pd.getHashname());
				json.put("isapp",pd.getIsapp());
				jsonArray.add(json);
			}
		}
		return SHA256Util.getSHA256(jsonArray.toJSONString());
	}

	/**
	 * 向上遍历目录 计算目录hash值进行更改
	 * @param projectId 项目ID
	 * @param directoryId 项目目录ID
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateProjectDirectoryHashForDeep(String projectId, String directoryId) throws BaseException{
		//根据项目id和目录id查询下级节点集合并计算hash
		String hashVal = this.getHashByProjectDirectoryForMe(projectId, directoryId);
		ProjectDirectory updateInfo = new ProjectDirectory();
		updateInfo.setProjectid(projectId);
		updateInfo.setDirectoryid(directoryId);
		updateInfo.setVersionhash(hashVal);
		mapper.updateByPrimaryKeySelective(updateInfo);
		ProjectDirectoryKey key = new ProjectDirectoryKey();
		key.setProjectid(projectId);
		key.setDirectoryid(directoryId);
		logger.info("projectId:{},directoryId:{}", projectId, directoryId);
		ProjectDirectory projectDirectory = mapper.selectByPrimaryKey(key);
		logger.info("projectDirectory:{}", projectDirectory);
		String parentId = projectDirectory.getParentid();
		if(parentId != null && parentId.trim().length() > 0 && !projectId.equals(parentId)){
			this.updateProjectDirectoryHashForDeep(projectId, parentId);
		}
	}
	/**
	 * 获取项目目录信息树类型对象（全部）
	 * @param projectid
	 * @param projectStage
	 * @return
	 */
//	@Cacheable(value="projectdirectorys")
	@Override
	public List<ProjectDirectoryTree> viewTreeForMe(String projectid, String projectStage) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		//获取项目id和适用并且父id为null的数据--递归获取此项目下的所有数据
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andStageLessThanOrEqualTo(projectStage);
		criteria.andParentidEqualTo(projectid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				/******************************判断目录是否可以删除**********************************************/
				BaseDirectoryExample beExample = new BaseDirectoryExample();
				BaseDirectoryExample.Criteria becriteria = beExample.createCriteria();
				becriteria.andIdEqualTo(directoryid1);
				long countBe = baseDirectoryMapper.countByExample(beExample);
				if(countBe > 0){
					//是来自基础目录 不能删除
					pdt.setIsdel(false);
				} else {
					DirectoryVersionExample mvExample = new DirectoryVersionExample();
					DirectoryVersionExample.Criteria mvcriteria = mvExample.createCriteria();
					mvcriteria.andDirectoryidEqualTo(directoryid1);
					mvcriteria.andProjectidEqualTo(projectid);
					long count = directoryVersionMapper.countByExample(mvExample);
					if(count > 0){
						//是有目录版本信息的 不能删除
						pdt.setIsdel(false);
					} else {
						pdt.setIsdel(true);
					}
				}
				/******************************判断目录是否可以删除**********************************************/
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeByProjectDirectoryForDeepForMe(projectid1, directoryid1, projectStage);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		//获取根目录
		ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectid);
		ProjectDirectoryTree pdt = new ProjectDirectoryTree();
		pdt.setProjectid(projectid);
		pdt.setId(projectid);
		pdt.setName(projectInfo.getProjectname());
		pdt.setPid(null);
		pdt.setType(ProjectDirectoryType.ROOT.getCode());
		pdt.setNocheck(true);
		list.add(pdt);
		return list;
	}

	/**
	 * 获取项目目录信息树类型对象（适用）
	 * @param projectid
	 * @param projectStage
	 * @param directoryid
	 * @return
	 */
//	@Cacheable(value="projectdirectorys")
	@Override
	public List<ProjectDirectoryTree> viewTree(String projectid, String projectStage, String directoryid, String... userId) {
		directoryid = StringUtil.getNotEmptyString(directoryid);
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		if(directoryid.length() == 0){
			//获取项目id和适用并且父id为null的数据--递归获取此项目下的所有数据
			ProjectDirectoryExample example = new ProjectDirectoryExample();
			example.setOrderByClause(" directoryno asc");
	        Criteria criteria = example.createCriteria();
	        criteria.andProjectidEqualTo(projectid);
			criteria.andStageLessThanOrEqualTo(projectStage);
	        criteria.andParentidEqualTo(projectid);
	        criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
	        List<ProjectDirectory> tempList = mapper.selectByExample(example);
	        if(tempList != null && tempList.size() > 0){
	        	for(ProjectDirectory pd : tempList){
	        		ProjectDirectoryTree pdt = new ProjectDirectoryTree();
	        		String projectid1 = pd.getProjectid();
	        		String directoryid1 = pd.getDirectoryid();
					String stage1 = pd.getStage();
	        		pdt.setProjectid(projectid1);
	        		pdt.setId(directoryid1);
					pdt.setStage(pd.getStage());
					pdt.setHashname(pd.getVersionhash());
	        		pdt.setName(pd.getFullname());
	        		pdt.setPid(pd.getParentid());
					pdt.setProcessnode(pd.getProcessnode());
					pdt.setProcessnodename(pd.getProcessnodename());
					pdt.setType(ProjectDirectoryType.DIR.getCode());
	        		pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
					pdt.setIsapp(pd.getIsapp());
	        		list.add(pdt);
	        		List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeByProjectDirectoryForDeep(projectid1, directoryid1, projectStage, userId);
	        		if(projectDirectoryList != null && projectDirectoryList.size() > 0){
	    	        	list.addAll(projectDirectoryList);
	    	        }
	        	}
	        }
	        List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfo(projectid, directoryid, userId);
	        if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
	        	list.addAll(manuscriptInfoList);
	        }
		} else {
			//异步加载下级信息
			List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeByProjectDirectory(projectid, projectStage, directoryid, userId);
    		if(projectDirectoryList != null && projectDirectoryList.size() > 0){
	        	list.addAll(projectDirectoryList);
	        }
		}
		if(userId != null && userId.length != 0){
			//添加根目录
			Boolean nocheck = Boolean.valueOf(userId[1]);
			Integer minVal = 999999999;
			if(list != null && list.size() > 0){
				//获取所有一级目录的流程状态最小的那个 给根目录赋值
				for(ProjectDirectoryTree pt : list){
					String pId = pt.getPid();
					if(pId.equals(projectid)){
						Integer processnodeInt = Integer.parseInt(pt.getProcessnode());
						minVal = Math.min(processnodeInt, minVal);
					}
				}
			}
			if(minVal == 999999999){
				minVal = 11;
			}
			//获取根目录
			ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectid);
			ProjectDirectoryTree pdt = new ProjectDirectoryTree();
			pdt.setProjectid(projectid);
			pdt.setId(projectid);
			pdt.setName(projectInfo.getProjectname());
			pdt.setPid(null);
			pdt.setType(ProjectDirectoryType.ROOT.getCode());
			String processNodeRoot = minVal+"";
			String processNodeNameRoot = "";
			pdt.setProcessnode(processNodeRoot);
			ProcessNodeInfo processNodeInfo = processNodeInfoMapper.selectByPrimaryKey(processNodeRoot);
			pdt.setProcessnodename(processNodeInfo.getProcessnodename());
			if(nocheck == null){
				nocheck = false;
			}
			pdt.setNocheck(nocheck);
			list.add(pdt);
		}


		return list;
	}
	
	/**
	 * 获取项目目录信息树类型对象（适用）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	public List<ProjectDirectoryTree> viewTreeByProjectDirectory(String projectid, String projectStage, String directoryid, String... userId) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		if(!org.springframework.util.StringUtils.isEmpty(projectStage)){
			criteria.andStageLessThanOrEqualTo(projectStage);
		}
		criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
        if(tempList != null && tempList.size() > 0){
        	for(ProjectDirectory pd : tempList){
        		ProjectDirectoryTree pdt = new ProjectDirectoryTree();
        		String projectid1 = pd.getProjectid();
        		String directoryid1 = pd.getDirectoryid();
        		pdt.setProjectid(projectid1);
        		pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
        		pdt.setName(pd.getFullname());
        		pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
        		pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
        		list.add(pdt);
        	}
        }
        List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfo(projectid, directoryid, userId);
        if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
        	list.addAll(manuscriptInfoList);
        }
		return list;
	}
	
	/**
	 * 获取项目目录信息树类型对象用于递归（适用）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	public List<ProjectDirectoryTree> viewTreeByProjectDirectoryForDeep(String projectid, String directoryid, String stage, String... userId) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		criteria.andStageLessThanOrEqualTo(stage);
		criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeByProjectDirectoryForDeep(projectid1, directoryid1, stage, userId);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfo(projectid, directoryid, userId);
		if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
			list.addAll(manuscriptInfoList);
		}
		return list;
	}

	/**
	 * 获取项目目录信息树类型对象用于递归（全部）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	public List<ProjectDirectoryTree> viewTreeByProjectDirectoryForDeepForMe(String projectid, String directoryid, String stage) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		criteria.andStageLessThanOrEqualTo(stage);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				/******************************判断目录是否可以删除**********************************************/
				BaseDirectoryExample beExample = new BaseDirectoryExample();
				BaseDirectoryExample.Criteria becriteria = beExample.createCriteria();
				becriteria.andIdEqualTo(directoryid1);
				long countBe = baseDirectoryMapper.countByExample(beExample);
				if(countBe > 0){
					//是来自基础目录 不能删除
					pdt.setIsdel(false);
				} else {
					DirectoryVersionExample mvExample = new DirectoryVersionExample();
					DirectoryVersionExample.Criteria mvcriteria = mvExample.createCriteria();
					mvcriteria.andDirectoryidEqualTo(directoryid1);
					mvcriteria.andProjectidEqualTo(projectid);
					long count = directoryVersionMapper.countByExample(mvExample);
					if(count > 0){
						//是有目录版本信息的 不能删除
						pdt.setIsdel(false);
					} else {
						pdt.setIsdel(true);
					}
				}
				/******************************判断目录是否可以删除**********************************************/
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeByProjectDirectoryForDeepForMe(projectid1, directoryid1, stage);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
//		List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfoForMe(projectid, directoryid);
//		if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
//			list.addAll(manuscriptInfoList);
//		}
		return list;
	}
	
	/**
	 * 获取底稿信息树类型对象（适用）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	private List<ProjectDirectoryTree> viewTreeByManuscriptInfo(String projectid, String directoryid, String... userId){
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		ManuscriptInfoExample example = new ManuscriptInfoExample();
		example.setOrderByClause(" orderno asc");
		ManuscriptInfoExample.Criteria criteria = example.createCriteria();
        criteria.andProjectidEqualTo(projectid);
        criteria.andDirectoryidEqualTo(directoryid);
        criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
        List<ManuscriptInfo> tempList = manuscriptInfoMapper.selectByExample(example);
        if(tempList != null && tempList.size() > 0){
        	for(ManuscriptInfo mi : tempList){
        		ProjectDirectoryTree pdt = new ProjectDirectoryTree();
        		pdt.setProjectid(mi.getProjectid());
        		pdt.setId(mi.getId());
        		pdt.setName(mi.getDocname());
        		pdt.setPid(mi.getDirectoryid());
				pdt.setProcessnode(mi.getProcessnode());
				pdt.setType(ProjectDirectoryType.FILE.getCode());
				if(userId != null && userId.length != 0){
					String userIdStr = userId[0];
					String idStr = mi.getId();
					//根据userId和底稿id查询底稿的状态信息
					DocUserRemarksMapExample exampleMe = new DocUserRemarksMapExample();
					DocUserRemarksMapExample.Criteria criteriaMe = exampleMe.createCriteria();
					criteriaMe.andDocidEqualTo(idStr);
					criteriaMe.andUseridEqualTo(userIdStr);
					List<DocUserRemarksMap> listMe = docUserRemarksMapMapper.selectByExample(exampleMe);
					if(listMe != null && listMe.size() > 0){
						DocUserRemarksMap drm = listMe.get(0);
						pdt.setStatus(drm.getStatus());
					} else {
						pdt.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
					}
					pdt.setStatus(ManuscriptInfoStatus.getEnumsByCode(pdt.getStatus()).getValue());
				} else {
					pdt.setStatus(ManuscriptInfoStatus.NOTREAD.getValue());
				}
        		pdt.setHashname(mi.getHashname());
				pdt.setIsapp(mi.getIsapp());
				pdt.setFiletype(mi.getFiletype());
				pdt.setNocheck(true);
				/******************************判断文件是否可以删除**********************************************/
				ManuscriptVersionExample mvExample = new ManuscriptVersionExample();
				mvExample.setOrderByClause("VERSION desc");
				ManuscriptVersionExample.Criteria mvcriteria = mvExample.createCriteria();
				mvcriteria.andDocidEqualTo(mi.getId());
				mvcriteria.andProjectidEqualTo(projectid);
				long count = manuscriptVersionMapper.countByExample(mvExample);
				if(count > 0){
					//文件存在版本信息 不能删除
					pdt.setIsdel(false);
				} else {
					pdt.setIsdel(true);
				}
				/******************************判断文件是否可以删除**********************************************/
        		list.add(pdt);
        	}
        }
        return list;
	}

	/**
	 * 获取底稿信息树类型对象（全部）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	private List<ProjectDirectoryTree> viewTreeByManuscriptInfoForMe(String projectid, String directoryid){
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		ManuscriptInfoExample example = new ManuscriptInfoExample();
		example.setOrderByClause(" orderno asc");
		ManuscriptInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andDirectoryidEqualTo(directoryid);

		List<ManuscriptInfo> tempList = manuscriptInfoMapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ManuscriptInfo mi : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				pdt.setProjectid(mi.getProjectid());
				pdt.setId(mi.getId());
				pdt.setName(mi.getDocname());
				pdt.setPid(mi.getDirectoryid());
				pdt.setProcessnode(mi.getProcessnode());
				pdt.setType(ProjectDirectoryType.FILE.getCode());
				pdt.setStatus(ManuscriptInfoStatus.getEnumsByCode(mi.getStatus()).getValue());
				pdt.setHashname(mi.getHashname());
				pdt.setIsapp(mi.getIsapp());
				pdt.setNocheck(true);
				list.add(pdt);
			}
		}
		return list;
	}

	/**
	 * 项目目录树含底稿文件(全部)查询(全部层级)(指定目录下全部层级)
	 * @param projectid 项目id
	 * @param directoryid
	 * @return
	 */
	@Override
	public List<ProjectDirectoryTree> viewTreeAllByProjectDirectoryAndManuscriptInfo(String projectid, String directoryid, String stage){
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		//获取项目id和适用并且父id为null的数据--递归获取此项目下的所有数据
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andDirectoryidEqualTo(directoryid);
		if(!StringUtils.isEmpty(stage)){
			criteria.andStageEqualTo(stage);
		}
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeAllByProjectDirectoryAndManuscriptInfoForDeepFor(projectid1, directoryid1,stage);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfoForMe(projectid, directoryid);
		if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
			list.addAll(manuscriptInfoList);
		}
		return list;
	}

	/**
	 * 获取项目目录信息树类型对象用于递归（全部）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	public List<ProjectDirectoryTree> viewTreeAllByProjectDirectoryAndManuscriptInfoForDeepFor(String projectid, String directoryid, String stage) {
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		if(!StringUtils.isEmpty(stage)){
			criteria.andStageEqualTo(stage);
		}
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
				String projectid1 = pd.getProjectid();
				String directoryid1 = pd.getDirectoryid();
				String stage1 = pd.getStage();
				pdt.setProjectid(projectid1);
				pdt.setId(directoryid1);
				pdt.setStage(pd.getStage());
				pdt.setHashname(pd.getVersionhash());
				pdt.setName(pd.getFullname());
				pdt.setPid(pd.getParentid());
				pdt.setProcessnode(pd.getProcessnode());
				pdt.setProcessnodename(pd.getProcessnodename());
				pdt.setType(ProjectDirectoryType.DIR.getCode());
				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
				pdt.setIsapp(pd.getIsapp());
				list.add(pdt);
				List<ProjectDirectoryTree> projectDirectoryList = this.viewTreeAllByProjectDirectoryAndManuscriptInfoForDeepFor(projectid1, directoryid1, stage);
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfoForMe(projectid, directoryid);
		if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
			list.addAll(manuscriptInfoList);
		}
		return list;
	}


	/**
	 *	修改目录的适用性dag
	 * 			[{"id":"id","type":"dir","pid":"pid","isapp","isapp"}]
	 * @param projectId
	 * @param projectStage
	 * @param treeDag
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateIsapp(String projectId, String projectStage, String treeDag, String userId) throws BaseException {
        /*
			更改适用性，需要修改该目录下所有的目录适用性，底稿适用性目前先取消掉
			更改目录版本
         */
        //首先更改该目录下全部目录的适用性
		try {
			JSONArray rootArray = JSONArray.parseArray(treeDag);
			JSONObject jsonObject = null;
			List pdList = new ArrayList();
			//		List miList = new ArrayList();
			Map<String, Object> map = new HashMap<>();
			map.put("projectid", projectId);
			jsonObject = rootArray.getJSONObject(0);
			String directoryid = jsonObject.get("id").toString();    //当类型为底稿时，此id为底稿文件id
			String isapp = jsonObject.get("isapp").toString();
			map.put("isapp", isapp);
			String remarks = "";
			if (jsonObject.get("remarks") != null) {
				remarks = jsonObject.get("remarks").toString();
			}
			map.put("remarks", remarks);
			String pidtemp = "";
			List<ProjectDirectoryTree> allList = this.viewTreeAllByProjectDirectoryAndManuscriptInfo(projectId, directoryid, null);
			for (int i = 0; i < allList.size(); i++) {
				String type = allList.get(i).getType();
				//修改信息表
				if ("dir".equals(type)) {    //如果是目录
					//修改项目目录表是否适用
					pdList.add(allList.get(i).getId());
				} else if ("file".equals(type)) {    //如果是底稿
					//				//修改底稿信息表是否适用字段
					//				miList.add(directoryid);
				}
			}
			//批量修改信息表
			if (pdList != null && pdList.size() > 0) {
				map.put("pdlist", pdList);
				mapper.batchUpdateIsapp(map);
			}
			//		if(miList!=null && miList.size()>0){
			//			map.put("milist",miList);
			//			manuscriptInfoMapper.batchUpdateIsapp(map);
			//		}

			//修改版本表，目录版本
			//根据修改的目录id，新增目录版本
			ProjectDirectoryExample example = new ProjectDirectoryExample();
			example.setOrderByClause(" directoryno asc");
			Criteria criteria = example.createCriteria();
			criteria.andProjectidEqualTo(projectId);
			criteria.andDirectoryidEqualTo(directoryid);
			List<ProjectDirectory> tempList = mapper.selectByExample(example);
			if (tempList != null && tempList.size() > 0) {
				directoryVersionService.updateDirectoryVersion(tempList.get(0), userId);
			}

			//		List dvList = new ArrayList();
			//		List lastDvList = new ArrayList();
			//		for(int i=allList.size()-1;i>=0;i--) {
			//			ProjectDirectoryTree projectDirectoryTree = allList.get(i);
			//			String id = projectDirectoryTree.getId();	//当类型为底稿时，此id为底稿文件id
			//			String pid = projectDirectoryTree.getPid();	//父目录id
			//			String type = projectDirectoryTree.getType();
			//			if ("dir".equals(type)) {    //如果是目录
			//				//查询此目录是否在目录版本信息表中，通过项目id，目录id，查询版本
			//				DirectoryVersionExample dvExample = new DirectoryVersionExample();
			//				DirectoryVersionExample.Criteria criteria = dvExample.createCriteria();
			//				criteria.andProjectidEqualTo(projectId);
			//				criteria.andDirectoryidEqualTo(id);
			//				List list = directoryVersionMapper.selectByExample(dvExample);
			//				//如果存在版本，则新增版本；如果不存在版本，则不对版本做处理
			//				if(list.size()>0 && list!=null){
			//					/*
			//						倒序时，查看pid字段，给pid赋一个临时变量，遍历下一个的时候，判断
			//						如果下一个的目录id等于上一个pid临时变量，说明下一个是上一个的父目录，需要通过下一个目录的id查出全部下一级子文件和子目录，拼装json，和计算拼装后的hash
			//						如果下一个的目录id不等于上一个pid临时变量，则再判断
			//						如果上一个pid临时变量不等于下一个目录pid，说明上一个目录的父目录和下一个目录的父目录不是一个目录，需要通过上一个目录的父目录id查出全部下一级子文件和子目录，拼装json，和计算拼装后的hash
			//						如果上一个pid临时变量等于下一个目录pid，则不做处理，继续循环下一个
			//						还得考虑如果是单独的一个目录的处理方式
			//						如果处理完最后一个，还没有到根目录，则需要查询最后一个目录的全部父目录，然后依次根据每个父目录的id，查询自己的下一级子文件和目录，然后拼装json和重新计算hash
			//					 */
			//					if(!"".equals(pidtemp)){
			//						//如果下一个的目录id等于上一个pid临时变量,说明下一个是上一个的父目录
			//						if(id.equals(pidtemp)){
			//							//需要通过下一个目录的id查出全部下一级子文件和子目录，拼装json，和计算拼装后的hash
			//							List<ProjectDirectoryTree> sonList = viewTree(projectId,projectStage,id);
			//							JSONArray jsonArray = new JSONArray();
			//							for(ProjectDirectoryTree pdt : sonList){
			//								JSONObject json = new JSONObject();
			//								json.put("type",pdt.getType());
			//								json.put("name",pdt.getName());
			//								json.put("value",pdt.getHashname());
			//								json.put("isapp",pdt.getIsapp());
			//								jsonArray.add(json);
			//							}
			//							DirectoryVersion dv = new DirectoryVersion();
			//							dv.setId(UUID.randomUUID().toString().replace("-",""));
			//							dv.setProjectid(projectId);
			//							dv.setDirectoryid(id);
			//							dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
			//							dv.setCreateTime(new Date());
			//							dv.setCreateUser("1");
			//							dv.setUpdateTime(new Date());
			//							dv.setUpdateUser("1");
			//							//版本组成，需要拼装json
			//							dv.setVersioncomposition(jsonArray.toString());
			//							//目录版本，需要计算版本组成hash
			//							dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
			//							//放到list，后面批量处理
			//							dvList.add(dv);
			//						}else{	//如果下一个的目录id不等于上一个pid临时变量
			//							//判断（因为没有多选操作，所以目前以下情况不会出现）
			//							//如果上一个pid临时变量不等于下一个目录pid，说明上一个目录的父目录和下一个目录的父目录不是一个目录
			//							// 需要通过上一个目录的父目录id查出全部下一级子文件和子目录，拼装json，和计算拼装后的hash
			//							//如果上一个pid临时变量等于下一个目录pid，则不做处理，继续循环下一个
			//						}
			//					}
			//					pidtemp = pid;
			//				}
			//			}else if("file".equals(type)) {    //如果是底稿
			//				//查询此文件是否在底稿版本信息表中，通过项目id，底稿id
			//				ManuscriptVersionExample mvExample = new ManuscriptVersionExample();
			//				mvExample.setOrderByClause("VERSION desc");
			//				ManuscriptVersionExample.Criteria criteria1 = mvExample.createCriteria();
			//				criteria1.andIdEqualTo(id);
			//				criteria1.andProjectidEqualTo(projectId);
			//				List list = manuscriptVersionMapper.selectByExample(mvExample);
			//				//如果存在版本，则新增版本，并处理上一个版本失效时间，以及版本号+1，如果不存在，则不对版本做处理
			//				//首先处理底稿版本信息表
			//				if(list.size()>0 && list!=null){
			//					//处理上一个版本的失效时间
			//					ManuscriptVersion mv = (ManuscriptVersion)list.get(0);
			//					mv.setEndtime(new Date());
			//					manuscriptVersionMapper.updateByPrimaryKeySelective(mv);
			//					//新增版本号+1
			//					int version = Integer.parseInt(((ManuscriptVersion)list.get(0)).getVersion().replace("v",""));
			//					ManuscriptVersion newMv = new ManuscriptVersion();
			//					newMv.setId(UUID.randomUUID().toString().replace("-",""));
			//					newMv.setVersion("v"+(version+1));
			//					newMv.setProjectid(projectId);
			//					newMv.setDocid(id);
			//					newMv.setHashname(mv.getHashname());
			//					newMv.setIsDelete(BaseConstant.DEL_FLAG_NO);
			//					newMv.setCreateTime(new Date());
			//					manuscriptVersionMapper.insertSelective(newMv);
			//					//再处理目录版本
			//					//这里只会作用于只提交一个底稿是否适用时候的修改,所以只会通过底稿的父目录id查询全部的子目录和子文件，因为如果提交的是一个目录，那么最后的循环会是对目录类型的处理。
			//					//如果下一个的目录id等于上一个pid临时变量,说明下一个是上一个的父目录
			//					//需要通过下一个目录的id查出全部下一级子文件和子目录，拼装json，和计算拼装后的hash
			//					if(rootArray.size()==1){
			//						List<ProjectDirectoryTree> sonList = viewTree(projectId,projectStage,pid);
			//						JSONArray jsonArray = new JSONArray();
			//						for(ProjectDirectoryTree pdt : sonList){
			//							JSONObject json = new JSONObject();
			//							json.put("type",pdt.getType());
			//							json.put("name",pdt.getName());
			//							json.put("value",pdt.getHashname());
			//							json.put("isapp",pdt.getIsapp());
			//							jsonArray.add(json);
			//						}
			//						DirectoryVersion dv = new DirectoryVersion();
			//						dv.setId(UUID.randomUUID().toString().replace("-",""));
			//						dv.setProjectid(projectId);
			//						dv.setDirectoryid(id);
			//						dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
			//						dv.setCreateTime(new Date());
			//						dv.setCreateUser("1");
			//						dv.setUpdateTime(new Date());
			//						dv.setUpdateUser("1");
			//						//版本组成，需要拼装json
			//						dv.setVersioncomposition(jsonArray.toString());
			//						//目录版本，需要计算版本组成hash
			//						dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
			//						//插入数据库
			//						dvList.add(dv);
			//						//如果只有一个的时候，就把底稿文件的父id当做目录id，便于做最后一次查询剩余的父目录
			//						id=pid;
			//					}
			//				}
			//			}
			//			//当是最后一个元素的时候
			//			/*
			//				如果处理完最后一个，还没有到根目录，则需要查询最后一个目录的全部父目录，然后依次根据每个父目录的id，
			//				查询自己的下一级子文件和目录，然后拼装json和重新计算hash
			//			 */
			//			if(i==0){
			//				Map<String, Object> paramMap = new HashMap<String, Object>();
			//				paramMap.put("pid",id);
			//				paramMap.put("projectId",projectId);
			//				List<ProjectDirectory> allParentDirectoryList = mapper.getAllParentDirectoryById(paramMap);
			//				for(ProjectDirectory p: allParentDirectoryList){
			//					List<ProjectDirectoryTree> sonList = viewTree(projectId,projectStage,p.getDirectoryid());
			//					JSONArray jsonArray = new JSONArray();
			//					for(ProjectDirectoryTree pdt : sonList){
			//						JSONObject json = new JSONObject();
			//						json.put("type",pdt.getType());
			//						json.put("name",pdt.getName());
			//						json.put("value",pdt.getHashname());
			//						json.put("isapp",pdt.getIsapp());
			//						jsonArray.add(json);
			//					}
			//					DirectoryVersion dv = new DirectoryVersion();
			//					dv.setId(UUID.randomUUID().toString().replace("-",""));
			//					dv.setProjectid(projectId);
			//					dv.setDirectoryid(id);
			//					dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
			//					dv.setCreateTime(new Date());
			//					dv.setCreateUser("1");
			//					dv.setUpdateTime(new Date());
			//					dv.setUpdateUser("1");
			//					//版本组成，需要拼装json
			//					dv.setVersioncomposition(jsonArray.toString());
			//					//目录版本，需要计算版本组成hash
			//					dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
			//					lastDvList.add(dv);
			//				}
			//			}
			//		}
			//		//处理目录版本表
			//		if(dvList!=null && dvList.size()>0){
			//			directoryVersionMapper.batchInsertSelective(dvList);
			//		}
			//		if(lastDvList!=null && lastDvList.size()>0){
			//			directoryVersionMapper.batchInsertSelective(lastDvList);
			//		}
		}catch (BaseException e){
			logger.info("修改目录的适用性错误");
			throw new BaseException("修改目录的适用性错误");
		}
	}

    /**
     * 项目目录树含底稿文件(适用)查询(只查询下一个层级，不分阶段和适用性)
     * @param projectid 项目id
     * @param directoryid 目录id
     * @param userId
     * @return
     */
    @Override
    public List<ProjectDirectoryTree> viewNextTree(String projectid, String directoryid, String userId) {
        directoryid = StringUtil.getNotEmptyString(directoryid);
        List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
        List<ProjectDirectoryTree> projectDirectoryList = this.viewNextTreeByProjectDirectory(projectid, directoryid, userId);
        if(projectDirectoryList != null && projectDirectoryList.size() > 0){
            list.addAll(projectDirectoryList);
        }
        return list;
    }



	/**
     * 获取项目目录信息树类型对象（适用）(只查询下一个层级，不分阶段和适用性)
     * @param projectid
     * @param directoryid
     * @return
     */
    public List<ProjectDirectoryTree> viewNextTreeByProjectDirectory(String projectid, String directoryid, String userId) {
        List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
        ProjectDirectoryExample example = new ProjectDirectoryExample();
        example.setOrderByClause(" directoryno asc");
        Criteria criteria = example.createCriteria();
        criteria.andProjectidEqualTo(projectid);
        if(!org.springframework.util.StringUtils.isEmpty(directoryid)){
            criteria.andParentidEqualTo(directoryid);
        }else{
            criteria.andParentidEqualTo(projectid);
        }
        criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
        List<ProjectDirectory> tempList = mapper.selectByExample(example);
        //获取项目id和适用并且父id为directoryid的数据
        if(tempList != null && tempList.size() > 0){
            for(ProjectDirectory pd : tempList){
                ProjectDirectoryTree pdt = new ProjectDirectoryTree();
                String projectid1 = pd.getProjectid();
                String directoryid1 = pd.getDirectoryid();
                pdt.setProjectid(projectid1);
                pdt.setId(directoryid1);
                pdt.setStage(pd.getStage());
                pdt.setHashname(pd.getVersionhash());
                pdt.setName(pd.getFullname());
                pdt.setPid(pd.getParentid());
                pdt.setProcessnode(pd.getProcessnode());
                pdt.setProcessnodename(pd.getProcessnodename());
                pdt.setType(ProjectDirectoryType.DIR.getCode());
                pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
                pdt.setIsapp(pd.getIsapp());
                list.add(pdt);
            }
        }
        List<ProjectDirectoryTree> manuscriptInfoList = this.viewTreeByManuscriptInfo(projectid, directoryid, userId);
        if(manuscriptInfoList != null && manuscriptInfoList.size() > 0){
            list.addAll(manuscriptInfoList);
        }
        return list;
    }

	/**
	 *
	 * @param map
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateCountersignProcessnodeTo47(Map<String, Object> map) {
		mapper.updateCountersignProcessnodeTo47(map);
	}

	/**
	 * 修改项目目录信息
	 * @param record
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateProjectDirectory(ProjectDirectory record, String userId) throws BaseException{
		try{
			//更新项目目录信息
			int success = getMapper().updateByPrimaryKeySelective(record);
			if (success <= 0) {
				logger.error("更新项目目录信息错误{}",  record.toString());
				throw new BaseException("更新项目目录信息错误");
			}
			List<DirectoryVersion> newDvList = directoryVersionService.getNewDirectoryVersion(record.getProjectid(),record.getDirectoryid());
			if(newDvList.size()>0){
				//更新目录版本表信息
				ProjectDirectory projectDirectory = new ProjectDirectory();
				projectDirectory.setProjectid(record.getProjectid());
				projectDirectory.setDirectoryid(record.getDirectoryid());
				projectDirectory.setFullname(record.getFullname());
				projectDirectory.setIsapp(record.getIsapp());
				directoryVersionService.updateDirectoryVersion(projectDirectory,userId);
			}
		}catch (BaseException e){
			logger.info("修改项目目录信息错误");
			throw new BaseException("修改项目目录信息错误");
		}
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public List<ProjectDirectory> addTestProjectDirectory(String projectId) throws BaseException {
		//根据项目id
		//一级目录
		List list = new ArrayList();

		for(int i=0;i<5;i++){
			String directoryId = UUID.randomUUID().toString().replace("-","");
			ProjectDirectory parentProjectDirectory = new ProjectDirectory();
			parentProjectDirectory.setId(UUID.randomUUID().toString().replace("-",""));
			parentProjectDirectory.setDirectoryid(directoryId);
			parentProjectDirectory.setProjectid(projectId);
			parentProjectDirectory.setStage("100");
			parentProjectDirectory.setFullname("测试目录父目录");
			parentProjectDirectory.setSname("测试目录父目录");
			parentProjectDirectory.setParentid("018b1f673ac4436e9fd8e0f9ce7a9936");
			parentProjectDirectory.setIsapp(ManuscriptInfoApply.YES.getCode());
			parentProjectDirectory.setProcessnode("11");
			parentProjectDirectory.setDirectoryno((20+i));
			parentProjectDirectory.setLevel("2");
			list.add(parentProjectDirectory);
			for(int j=0;j<10;j++){
				String directoryId1 = UUID.randomUUID().toString().replace("-","");
				ProjectDirectory sonProjectDirectory = new ProjectDirectory();
				sonProjectDirectory.setId(UUID.randomUUID().toString().replace("-",""));
				sonProjectDirectory.setDirectoryid(directoryId1);
				sonProjectDirectory.setProjectid(projectId);
				sonProjectDirectory.setStage("100");
				sonProjectDirectory.setFullname(i+"."+j+"测试目录"+i+""+j);
				sonProjectDirectory.setSname(i+"."+j+"测试目录"+i+""+j);
				sonProjectDirectory.setParentid(directoryId);
				sonProjectDirectory.setIsapp(ManuscriptInfoApply.YES.getCode());
				sonProjectDirectory.setProcessnode("11");
				sonProjectDirectory.setDirectoryno(j);
				sonProjectDirectory.setLevel("3");
				list.add(sonProjectDirectory);
				for(int k=0;k<10;k++){
					String directoryId2 = UUID.randomUUID().toString().replace("-","");
					ProjectDirectory grandsonProjectDirectory = new ProjectDirectory();
					grandsonProjectDirectory.setId(UUID.randomUUID().toString().replace("-",""));
					grandsonProjectDirectory.setDirectoryid(directoryId2);
					grandsonProjectDirectory.setProjectid(projectId);
					grandsonProjectDirectory.setStage("100");
					grandsonProjectDirectory.setFullname(i+"."+j+"."+k+"测试目录"+i+""+j+""+k);
					grandsonProjectDirectory.setSname(i+"."+j+"."+k+"测试目录"+i+""+j+""+k);
					grandsonProjectDirectory.setParentid(directoryId1);
					grandsonProjectDirectory.setIsapp(ManuscriptInfoApply.YES.getCode());
					grandsonProjectDirectory.setProcessnode("11");
					grandsonProjectDirectory.setDirectoryno(k);
					grandsonProjectDirectory.setLevel("4");
					list.add(grandsonProjectDirectory);
				}
			}
		}
		mapper.batchInsertSelective(list);
		return list;
	}

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
    public void uploadfiletest(String projectId,String userId) throws BaseException{
        //项目目录树查询
        //遍历所有目录
        try {
            List<ProjectDirectoryTree> list = this.viewAllDirectoryTree(projectId);
            for (int i = 0; i < list.size(); i++) {
                ManuscriptInfo record = new ManuscriptInfo();
                record.setProjectid(projectId);
                record.setDirectoryid(list.get(i).getId());
                record.setDocname("NSCaster-351介绍.pdf");
                record.setHashname("ef999fa6958d3fff67dfb5a634921481124991a37d60f8c1e7030f915751bb39");
                record.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
                record.setIsapp(ManuscriptInfoApply.YES.getCode());
                record.setUploaddate(new Date());
                record.setFiletype("11");
                record.setUserid(userId);
                ManuscriptInfo record1 = new ManuscriptInfo();
                record1.setProjectid(projectId);
                record1.setDirectoryid(list.get(i).getId());
                record1.setDocname("天创恒达便携式课堂实录方案.pdf");
                record1.setHashname("1e911820200d44a367838aa102f138b15b1d428b48e1ef7ff00508267d81414e");
                record1.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
                record1.setIsapp(ManuscriptInfoApply.YES.getCode());
                record1.setUploaddate(new Date());
                record1.setFiletype("11");
                record1.setUserid(userId);
                ManuscriptInfo record2 = new ManuscriptInfo();
                record2.setProjectid(projectId);
                record2.setDirectoryid(list.get(i).getId());
                record2.setDocname("iCaster产品介绍.pdf");
                record2.setHashname("e5a55e60b1bb5e148df60b8c4c82d8ff6eea1c6899d81ab964fad559c2310f0c");
                record2.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
                record2.setIsapp(ManuscriptInfoApply.YES.getCode());
                record2.setUploaddate(new Date());
                record2.setFiletype("11");
                record2.setUserid(userId);
                ManuscriptInfo record3 = new ManuscriptInfo();
                record3.setProjectid(projectId);
                record3.setDirectoryid(list.get(i).getId());
                record3.setDocname("6-CFCA数 据服务产品接入规范(6.0开发文档)-用户版.pdf");
                record3.setHashname("cce6dae5a6989401e054d86a48b70e3561b643502edd5dded202ad9624d9f19d");
                record3.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
                record3.setIsapp(ManuscriptInfoApply.YES.getCode());
                record3.setUploaddate(new Date());
                record3.setFiletype("11");
                record3.setUserid(userId);

				ManuscriptInfo record4 = new ManuscriptInfo();
				record4.setProjectid(projectId);
				record4.setDirectoryid(list.get(i).getId());
				record4.setDocname("终止附件1.pdf");
				record4.setHashname("bda47d0fe85f7233b751d95d4442f1271fb179ed5bc91f2a655f12489892af28");
				record4.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
				record4.setIsapp(ManuscriptInfoApply.YES.getCode());
				record4.setUploaddate(new Date());
				record4.setFiletype("11");
				record4.setUserid(userId);

				ManuscriptInfo record5 = new ManuscriptInfo();
				record5.setProjectid(projectId);
				record5.setDirectoryid(list.get(i).getId());
				record5.setDocname("第1章软件测试概述_1.pdf");
				record5.setHashname("0d01dee42d1398fea2bf9610dddfa0ac629707cffa65de43a00d2fa2c58d1c23");
				record5.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
				record5.setIsapp(ManuscriptInfoApply.YES.getCode());
				record5.setUploaddate(new Date());
				record5.setFiletype("11");
				record5.setUserid(userId);

				ManuscriptInfo record6 = new ManuscriptInfo();
				record6.setProjectid(projectId);
				record6.setDirectoryid(list.get(i).getId());
				record6.setDocname("第1章识别和描述缺陷_2.pdf");
				record6.setHashname("5ab49009c847b2825104aa12d01c6ffe2e572d8c3d642bbf7d49b5ea032ef502");
				record6.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
				record6.setIsapp(ManuscriptInfoApply.YES.getCode());
				record6.setUploaddate(new Date());
				record6.setFiletype("11");
				record6.setUserid(userId);

				ManuscriptInfo record7 = new ManuscriptInfo();
				record7.setProjectid(projectId);
				record7.setDirectoryid(list.get(i).getId());
				record7.setDocname("证券公司公司债券承销业务工作底稿目录模版.pdf");
				record7.setHashname("198746ed9bbc84497bb6d772dbb0d321456b35452a8728a8873183e17983f96a");
				record7.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
				record7.setIsapp(ManuscriptInfoApply.YES.getCode());
				record7.setUploaddate(new Date());
				record7.setFiletype("11");
				record7.setUserid(userId);

				ManuscriptInfo record8 = new ManuscriptInfo();
				record8.setProjectid(projectId);
				record8.setDirectoryid(list.get(i).getId());
				record8.setDocname("证券期货业软件测试规范 (2).pdf");
				record8.setHashname("368f6c805a05e8e1f98d4f5dfdf03ce8c3858e3356d723c3f7930609368858d7");
				record8.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
				record8.setIsapp(ManuscriptInfoApply.YES.getCode());
				record8.setUploaddate(new Date());
				record8.setFiletype("11");
				record8.setUserid(userId);

				ManuscriptInfo record9 = new ManuscriptInfo();
				record9.setProjectid(projectId);
				record9.setDirectoryid(list.get(i).getId());
				record9.setDocname("主协议-01.pdf");
				record9.setHashname("0980b4c81d86eadc03b393ae5f45586d66158948d71f439dd6347a3058be7c1c");
				record9.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
				record9.setIsapp(ManuscriptInfoApply.YES.getCode());
				record9.setUploaddate(new Date());
				record9.setFiletype("11");
				record9.setUserid(userId);

                manuscriptInfoService.saveForMe(record);
                manuscriptInfoService.saveForMe(record1);
                manuscriptInfoService.saveForMe(record2);
                manuscriptInfoService.saveForMe(record3);
				manuscriptInfoService.saveForMe(record4);
				manuscriptInfoService.saveForMe(record5);
				manuscriptInfoService.saveForMe(record6);
				manuscriptInfoService.saveForMe(record7);
				manuscriptInfoService.saveForMe(record8);
				manuscriptInfoService.saveForMe(record9);
            }
        }catch (BaseException e){
            throw new BaseException("插入失败");
        }
    }

	/**
	 * 查询所有上级父目录
	 * @param projectid 项目id
	 * @param directoryid 目录id
	 * @return
	 */
	@Override
	public List<ProjectDirectory> viewParentTree(String projectid, String directoryid) {
		List<ProjectDirectory> list = new ArrayList<ProjectDirectory>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andDirectoryidEqualTo(directoryid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
//				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
//				String projectid1 = pd.getProjectid();
//				String directoryid1 = pd.getDirectoryid();
//				String stage1 = pd.getStage();
//				pdt.setProjectid(projectid1);
//				pdt.setId(directoryid1);
//				pdt.setStage(pd.getStage());
//				pdt.setHashname(pd.getVersionhash());
//				pdt.setName(pd.getFullname());
//				pdt.setPid(pd.getParentid());
//				pdt.setProcessnode(pd.getProcessnode());
//				pdt.setProcessnodename(pd.getProcessnodename());
//				pdt.setType(ProjectDirectoryType.DIR.getCode());
//				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
//				pdt.setIsapp(pd.getIsapp());
//				list.add(pd);
				List<ProjectDirectory> projectDirectoryList = this.viewParentTreeForDeepFor(projectid, pd.getParentid());
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					list.addAll(projectDirectoryList);
				}
			}
		}
		return list;
	}

	/**
	 * 获取项目目录信息树类型对象用于递归（全部）
	 * @param projectid
	 * @param directoryid
	 * @return
	 */
	public List<ProjectDirectory> viewParentTreeForDeepFor(String projectid, String directoryid) {
		List<ProjectDirectory> list = new ArrayList<ProjectDirectory>();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andDirectoryidEqualTo(directoryid);
		List<ProjectDirectory> tempList = mapper.selectByExample(example);
		//获取项目id和适用并且父id为directoryid的数据
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
//				ProjectDirectoryTree pdt = new ProjectDirectoryTree();
//				String projectid1 = pd.getProjectid();
//				String directoryid1 = pd.getDirectoryid();
//				String stage1 = pd.getStage();
//				pdt.setProjectid(projectid1);
//				pdt.setId(directoryid1);
//				pdt.setStage(pd.getStage());
//				pdt.setHashname(pd.getVersionhash());
//				pdt.setName(pd.getFullname());
//				pdt.setPid(pd.getParentid());
//				pdt.setProcessnode(pd.getProcessnode());
//				pdt.setProcessnodename(pd.getProcessnodename());
//				pdt.setType(ProjectDirectoryType.DIR.getCode());
//				pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
//				pdt.setIsapp(pd.getIsapp());
				list.add(pd);
				if(!org.springframework.util.StringUtils.isEmpty(pd.getParentid())) {
					List<ProjectDirectory> projectDirectoryList = this.viewParentTreeForDeepFor(projectid, pd.getParentid());
					if (projectDirectoryList != null && projectDirectoryList.size() > 0) {
						list.addAll(projectDirectoryList);
					}
				}
			}
		}
		return list;
	}

	@Override
	public List<ProjectDirectoryTree> viewAllDirectoryTree(String projectid){
        List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
        ProjectDirectoryExample example = new ProjectDirectoryExample();
        example.setOrderByClause(" directoryno asc");
        Criteria criteria = example.createCriteria();
        criteria.andProjectidEqualTo(projectid);
        criteria.andParentidEqualTo(projectid);
        criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
        List<ProjectDirectory> tempList = mapper.selectByExample(example);
        if(tempList != null && tempList.size() > 0){
            for(ProjectDirectory pd : tempList){
                ProjectDirectoryTree pdt = new ProjectDirectoryTree();
                String projectid1 = pd.getProjectid();
                String directoryid1 = pd.getDirectoryid();
                String stage1 = pd.getStage();
                pdt.setProjectid(projectid1);
                pdt.setId(directoryid1);
                pdt.setStage(pd.getStage());
                pdt.setHashname(pd.getVersionhash());
                pdt.setName(pd.getFullname());
                pdt.setPid(pd.getParentid());
                pdt.setProcessnode(pd.getProcessnode());
                pdt.setProcessnodename(pd.getProcessnodename());
                pdt.setType(ProjectDirectoryType.DIR.getCode());
                pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
                pdt.setIsapp(pd.getIsapp());
                list.add(pdt);
                List<ProjectDirectoryTree> projectDirectoryList = this.viewAllDirectoryTreeForDeep(projectid1, directoryid1);
                if(projectDirectoryList != null && projectDirectoryList.size() > 0){
                    list.addAll(projectDirectoryList);
                }
            }
        }
        return list;
    }

	public List<ProjectDirectoryTree> viewAllDirectoryTreeForDeep(String projectid, String directoryid){
        List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
        ProjectDirectoryExample example = new ProjectDirectoryExample();
        example.setOrderByClause(" directoryno asc");
        Criteria criteria = example.createCriteria();
        criteria.andProjectidEqualTo(projectid);
        criteria.andParentidEqualTo(directoryid);
        criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
        List<ProjectDirectory> tempList = mapper.selectByExample(example);
        //获取项目id和适用并且父id为directoryid的数据
        if(tempList != null && tempList.size() > 0){
            for(ProjectDirectory pd : tempList){
                ProjectDirectoryTree pdt = new ProjectDirectoryTree();
                String projectid1 = pd.getProjectid();
                String directoryid1 = pd.getDirectoryid();
                pdt.setProjectid(projectid1);
                pdt.setId(directoryid1);
                pdt.setStage(pd.getStage());
                pdt.setHashname(pd.getVersionhash());
                pdt.setName(pd.getFullname());
                pdt.setPid(pd.getParentid());
                pdt.setProcessnode(pd.getProcessnode());
                pdt.setProcessnodename(pd.getProcessnodename());
                pdt.setType(ProjectDirectoryType.DIR.getCode());
                pdt.setStatus(ProjectDirectoryStatus.getEnumsByCode("11").getValue());
                pdt.setIsapp(pd.getIsapp());
                list.add(pdt);
                List<ProjectDirectoryTree> projectDirectoryList = this.viewAllDirectoryTreeForDeep(projectid1, directoryid1);
                if(projectDirectoryList != null && projectDirectoryList.size() > 0){
                    list.addAll(projectDirectoryList);
                }
            }
        }
        return list;
    }

	/**
	 * 项目目录树用于导出某时间节点的数据展示接口
	 * @param projectid     项目ID
	 * @param reptDate      报送日期时间
	 * @return
	 */
	//@Cacheable(value="projectdirectorys")
	@Override
	public List<ProjectDirectoryTree> viewTreeForExport(String projectid, String reptDate) {
		Date repDateTime = new Date();
		if(reptDate != null){
			repDateTime = DateUtils.stringToDateTime(reptDate);
		}
		List<ProjectDirectoryTree> list = new ArrayList<ProjectDirectoryTree>();
		//通过项目id及时间 获取根目录版本组成
		DirectoryVersionExample example = new DirectoryVersionExample();
		example.setOrderByClause(" create_time desc");
		DirectoryVersionExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andDirectoryidEqualTo(projectid);
		criteria.andCreateTimeLessThanOrEqualTo(repDateTime);
		List<DirectoryVersion> tempList = directoryVersionMapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			DirectoryVersion dv = tempList.get(0);
			//目录Hash
			String versionHash = dv.getVersionhash();
			//目录版本组成
			String versioncomposition = dv.getVersioncomposition();
			//获取根目录
			ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectid);
			ProjectDirectoryTree pdt = new ProjectDirectoryTree();
			pdt.setProjectid(projectid);
			pdt.setId(versionHash);
			pdt.setName(projectInfo.getProjectname());
			pdt.setPid(null);
			pdt.setType(ProjectDirectoryType.ROOT.getCode());
			pdt.setHashname(versionHash);
			pdt.setNocheck(true);
			list.add(pdt);
			List<ProjectDirectoryTree> subList = this.viewTreeForExportDeep(projectid, versioncomposition, versionHash, repDateTime);
			if(subList != null && subList.size() > 0){
				list.addAll(subList);
			}
		}
		return list;
	}

	/**
	 * 项目目录树用于导出某时间节点的数据展示接口 递归
	 * @param projectid           项目ID
	 * @param versioncomposition  目录版本组成
	 * @param versionHash         目录Hashval
	 * @param repDateTime         报送日期时间
	 * @return
	 */
	private List<ProjectDirectoryTree> viewTreeForExportDeep(String projectid, String versioncomposition, String versionHash, Date repDateTime) {
		List<ProjectDirectoryTree> subList = new ArrayList<ProjectDirectoryTree>();
		//解析目录版本组成 获取目录hash值
		JSONArray verArray = JSONArray.parseArray(versioncomposition);
		JSONObject verObject = null;
		for( int i = 0; i < verArray.size() ; i++ ) {
			verObject = verArray.getJSONObject(i);
			//类型，dir:目录，file:文件
			String type = verObject.get("type").toString();
			if("dir".equals(type)){
				String value = verObject.get("value").toString();
				String name = verObject.get("name").toString();
				ProjectDirectoryTree pdt = this.viewDirectoryVersionInfo(projectid, value, repDateTime);
				pdt.setPid(versionHash);
				pdt.setName(name);
				subList.add(pdt);
				//目录版本组成
				String versioncomposition1 = pdt.getVersioncomposition();
				List<ProjectDirectoryTree> subList1 = this.viewTreeForExportDeep(projectid, versioncomposition1, versionHash, repDateTime);
				if(subList1 != null && subList1.size() > 0){
					subList.addAll(subList1);
				}
			} else if("file".equals(type)){
				String value = verObject.get("value").toString();
				String name = verObject.get("name").toString();
				ProjectDirectoryTree pdt = this.viewManuscriptVersionInfo(projectid, value, repDateTime);
				pdt.setPid(versionHash);
				pdt.setName(name);
				subList.add(pdt);
			}
		}
		return subList;
	}

	/**
	 *  通过hash值获取目录版本信息
 	 * @param projectid         项目ID
	 * @param versionHash       hash值
	 * @param repDateTime       报送日期时间
	 * @return
	 */
	private ProjectDirectoryTree viewDirectoryVersionInfo(String projectid, String versionHash, Date repDateTime){
		ProjectDirectoryTree pdt = null;
		DirectoryVersionExample example = new DirectoryVersionExample();
		example.setOrderByClause(" create_time desc");
		DirectoryVersionExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andVersionhashEqualTo(versionHash);
		criteria.andCreateTimeLessThanOrEqualTo(repDateTime);
		List<DirectoryVersion> tempList = directoryVersionMapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			DirectoryVersion dv = tempList.get(0);
			//目录Hash
			String hashval = dv.getVersionhash();
			String versioncomposition = dv.getVersioncomposition();
			pdt = new ProjectDirectoryTree();
			pdt.setProjectid(projectid);
			pdt.setId(hashval);
			pdt.setType(ProjectDirectoryType.DIR.getCode());
			pdt.setHashname(hashval);
			pdt.setVersioncomposition(versioncomposition);
			pdt.setNocheck(true);
		}
		return pdt;
	}

	/**
	 *  通过hash值获取文件版本信息
	 * @param projectid         项目ID
	 * @param versionHash       hash值
	 * @param repDateTime       报送日期时间
	 * @return
	 */
	private ProjectDirectoryTree viewManuscriptVersionInfo(String projectid, String versionHash, Date repDateTime){
		ProjectDirectoryTree pdt = null;
		ManuscriptVersionExample example = new ManuscriptVersionExample();
		example.setOrderByClause(" create_time desc");
		ManuscriptVersionExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andHashnameEqualTo(versionHash);
		criteria.andCreateTimeLessThanOrEqualTo(repDateTime);
		List<ManuscriptVersion> tempList = manuscriptVersionMapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			ManuscriptVersion mv = tempList.get(0);
			//目录Hash
			String hashval = mv.getHashname();
			pdt = new ProjectDirectoryTree();
			pdt.setProjectid(projectid);
			pdt.setId(hashval);
			pdt.setType(ProjectDirectoryType.FILE.getCode());
			pdt.setHashname(hashval);
			pdt.setNocheck(true);
		}
		return pdt;
	}
}