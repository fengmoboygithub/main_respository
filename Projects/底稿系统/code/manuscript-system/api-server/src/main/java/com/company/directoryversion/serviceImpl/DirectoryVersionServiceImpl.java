package com.company.directoryversion.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.constant.BaseConstant;
import com.company.directoryversion.dao.DirectoryVersionMapper;
import com.company.directoryversion.model.DirectoryVersion;
import com.company.directoryversion.model.DirectoryVersionExample;
import com.company.directoryversion.service.DirectoryVersionService;
import com.company.enums.ProjectDirectoryType;
import com.company.manuscriptinfo.dao.ManuscriptInfoMapper;
import com.company.manuscriptinfo.model.ManuscriptInfo;
import com.company.manuscriptversion.dao.ManuscriptVersionMapper;
import com.company.manuscriptversion.model.ManuscriptVersion;
import com.company.manuscriptversion.model.ManuscriptVersionExample;
import com.company.projectdirectory.dao.ProjectDirectoryMapper;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.model.ProjectDirectoryExample;
import com.company.projectdirectory.service.ProjectDirectoryService;
import com.company.projectdirectory.view.ProjectDirectoryTree;
import com.company.projectinfo.dao.ProjectInfoMapper;
import com.company.projectinfo.model.ProjectInfo;
import com.company.utils.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class DirectoryVersionServiceImpl extends BaseServiceImpl<DirectoryVersion, DirectoryVersionExample> implements DirectoryVersionService<DirectoryVersion, DirectoryVersionExample>{

    @Autowired
    private DirectoryVersionMapper mapper;
	
	public IBaseDao<DirectoryVersion, DirectoryVersionExample> getMapper(){
		return mapper;
	}

	@Autowired
	public ProjectDirectoryMapper projectDirectoryMapper;

	@Autowired
	public ProjectDirectoryService projectDirectoryService;

	@Autowired
	public ManuscriptVersionMapper manuscriptVersionMapper;

	@Autowired
	public ManuscriptInfoMapper manuscriptInfoMapper;

	@Autowired
	private ProjectInfoMapper projectInfoMapper;

	@Override
	@Transactional
	public void updateVersion(String projectId, String projectStage, String treeDag) throws BaseException {
		/*
			文件提交是一个重要环节，只有在这个环节可以变更文件的内容。所有在这个环节的变更，都需要进行记录。
			通过“文件提交表”可以确定任何文件在任何时间的内容。
			相关表；文件版本表；主要字段：“项目：ID”、“文件：ID”、 “文件存储名：HASH”、“用户：ID”、“提交时间：TIME”、“失效时间：TIME”
			同样文件内容（哈希值）的文件，可能在不同位置，不同时间段多次出现。记录为多条记录。
			对于新输入，但没有提交的文件，存在于“当前文件表”，但不存在于“文件版本表”。
			整体流程
			1.底稿版本
			如果类型为文件，保存该文件的主键id，项目id，底稿文件id，文件存储名hash，用户id，提交时间，失效时间，以及版本号到底稿版本表中
			其中，文件存储名为dag中传来，底稿版本号需要通过数据库最大值加一

			2.目录版本
			(文件提交，以及文件、目录的“是否适用”修改，会改变“目录版本”。要注意“项目阶段”改变引起的适用变化。“目录版本表”不带时间属性（由意见表的
			时间属性确认），同样的内容再次出现，使用原有记录（如“是否适用”的频繁变化）。
			相关表；目录版本表；主要字段：“项目：ID”、“目录：ID”、 “目录版本：HASH”、“版本组成：VCHAR”
			PK：“目录版本：HASH”
			如目录1-1-1，包含不适用的1-1-1-1子目录和一个文件，则版本组成类似下列表示：
			[ {“type”: “dir-not-use”, “name”:“1-1-1-1 …”, “value”:“1234abcd…” },
			{ “type”:“file”, “name”:一个文件显示名，“value”：一个哈希] ]
			“目录版本”就是“版本组成”的hash值，因为需要进行验证，所以格式必须规范，多一个空格都不行。
			“目录版本表”记录所有历史版本录，“项目目录表”是指当前版本。尚未有文件提交的目录，会有“项目目录表”的记录，但没有“目录版本表”的记录。
			当一个文件的版本发生变化时，最多生成与目录级次数量相同的新目录版本（如有三级目录，1-1-1下的文件变化，新增1,1-1,1-1-1的三个新版本）。为减少
			这个数量，所以新增文件（指上传）和提交文件（进入流程）是两个操作，对一个目录下的文件，尽量同时提交。
			会有表示多选的“目录版本”，在对多个目录提出意见时产生。)
			如果类型为目录的，保存该目录版本的主键id，项目id，目录id，目录版本hash和版本组成
			目录版本hash，是根据版本组成计算的hash
			版本组成，是该目录所有祖先节点的组成
			底稿发生变化，目录版本也要发生变化

			我记得上次说的是版本组成不包括自身，只包括自己的子节点文件和目录，再次确认下。
			比如目录1的版本组成是[{"type":"dir","name":"1-1","value":"1234abcd"},{"type":"dir","name":"1-2","value":"1234abcd"}]
			那么目录1的hash就是1的版本组成字符串计算hash的值
			目录1-1就是[{"type":"dir","name":"1-1-1","value":"1234abcd"},{"type":"dir","name":"1-1-2","value":"1234abcd"},
						{"type":"file","name":"1-1文件1","value":"1234abcd"}]
			那么目录1-1的hash就是1-1的版本组成字符串计算hash的值，里面的底稿文件
			目录1-1-1就是[{"type":"file","name":"1-1-1文件1","value":"1234abcd"},{"type":"file","name":"1-1-1文件2","value":"1234abcd"}]
			那么目录1-1-1的hash就是1-1-1的版本组成字符串计算hash的值
			所以需要逆向，从子目录向父目录进行计算。此处可能需要全部逆向遍历处理，平铺的dag是按照1,1-1,1-1-1,1-2,1-2-1这样

			1.如果是文件变化，则更改文件父目录的版本，然后计算父目录的目录版本hash
			分为两种，一种是文件提交，一种是文件适用不适用
			文件提交：
				将通过底稿文件的目录id，为该目录的父目录节点，查询全部子节点上目录和文件，拼装版本组成json，之后通过版本组成，计算目录版本hash，放入list
				将此步骤重复执行至根目录，然后批量插入目录版本信息表
			文件适用不适用：
				先更改底稿信息表中当前文件适用不适用字段
				然后通过底稿文件的目录id，为该目录的父目录节点查询全部子节点上目录和文件，拼装版本组成json，之后通过版本组成，计算目录版本hash，放入list
				将此步骤重复执行至根目录，然后批量插入目录版本信息表

			2.如果是目录变化，则更改当前目录父目录的版本组成，然后计算父目录的目录版本hash。
			先更改项目目录表中当前节点适用不适用字段
			然后通过父目录节点查询全部子节点上目录和文件，拼装版本组成json，之后通过版本组成，计算目录版本hash，放入list
			将此步骤重复执行至根目录，然后批量插入目录版本信息表


			需要确认更改文件适用不适用是否是一个什么样的操作，单独操作，还是批量操作，是否需要点保存？那么提交又是另一种？
		*/
		JSONArray rootArray = JSONArray.parseArray(treeDag);
		JSONObject jsonObject = null;
		Map map = new HashMap();
		List plist = new ArrayList();
		List listtemp = new ArrayList();
		List<ManuscriptInfo> manuscriptInfoList = new ArrayList();
		String pidtemp = "";
		for(int i=0;i<rootArray.size();i++) {
			jsonObject = rootArray.getJSONObject(i);
			String id = jsonObject.get("id").toString();	//当类型为底稿时，此id为底稿文件id
			String pid = jsonObject.get("pid").toString();
			boolean flag = false;
			if(id.equals(pidtemp)){
				flag = true;
			}
			pidtemp = pid;
			//类型，dir:目录，file:文件
			String type = jsonObject.get("type").toString();
			if ("dir".equals(type)) {    //如果是目录
				//当目录是否适用更改时，进行版本变更
				String isappbefore = jsonObject.get("isappbefore").toString();
				String isappafter = jsonObject.get("isappafter").toString();
				if(!isappbefore.equals(isappafter)){
					//先更改项目目录表中当前节点适用不适用字段
					ProjectDirectory pd = new ProjectDirectory();
					pd.setProjectid(projectId);
					pd.setDirectoryid(id);
					pd.setIsapp(Integer.parseInt(isappafter));
					projectDirectoryMapper.updateByPrimaryKeySelective(pd);
					//避免重复修改，如，三级目录或文件修改时，修改当前级别全部目录或文件之后，才会新增修改父目录版本，也就是说，循环到当前的目录id等于上一个的父目录id时，才会修改父目录
					//if  id==beforepid   update parent
					if(flag){
						//然后通过父目录节点查询全部子节点上目录和文件，拼装版本组成json，之后通过版本组成，计算目录版本hash，放入list(舍弃这个)
						//为父节点时，则查询全部子节点上目录合文件，拼装版本组成json，之后通过版本组成，计算目录版本hash，放入list，等待最后批量处理
						//查询所有父目录
//						List<ProjectDirectory> allParentDirectoryList = projectDirectoryMapper.getAllParentDirectoryById(id);
//						for(ProjectDirectory p: allParentDirectoryList){
						List<ProjectDirectoryTree> list = projectDirectoryService.viewTree(projectId,projectStage,id);
						//{"type":"dir","name":"1-1-1","value":"1234abcd"}
						JSONArray jsonArray = new JSONArray();
						for(ProjectDirectoryTree pdt : list){
							JSONObject json = new JSONObject();
							json.put("type",pdt.getType());
							json.put("name",pdt.getName());
							json.put("value",pdt.getHashname());
							json.put("isapp",pdt.getIsapp());
							jsonArray.add(json);
						}
						//查询当前目录的全部父目录，从根节点向子节点，逐一拼装json，同时计算json的hash，
						// 并将版本组成和目录版本(版本组成计算的hash)，放到实体中插入数据库
						DirectoryVersion dv = new DirectoryVersion();
						dv.setId(UUID.randomUUID().toString().replace("-",""));
						dv.setProjectid(projectId);
						dv.setDirectoryid(id);
						dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
						dv.setCreateTime(new Date());
						dv.setCreateUser("1");
						dv.setUpdateTime(new Date());
						dv.setUpdateUser("1");
						//版本组成，需要拼装json
						dv.setVersioncomposition(jsonArray.toString());
						//目录版本，需要计算版本组成hash
						dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
						plist.add(dv);
//						}
					}
					//批量插入数据
				}
			}else if ("file".equals(type)) {    //如果是底稿文件
				String isappbefore = jsonObject.get("isappbefore").toString();
				String isappafter = jsonObject.get("isappafter").toString();
				String hashname = jsonObject.get("hashname").toString();
				/*
					目的：底稿版本信息中，根据底稿id查询底稿版本信息是否存在
						如果这个文件不存在，则设置版本号为v1
						如果存在，那么通过底稿id查询底稿版本信息中版本倒序最大版本的hash
							如果一样，则判断是否适用发生改变，改变，则update版本，同时更新底稿信息表
							不一样，则+1
				*/
				//提交底稿信息版本和底稿信息表
				ManuscriptVersionExample example = new ManuscriptVersionExample();
				ManuscriptVersionExample.Criteria criteria = example.createCriteria();
				criteria.andDocidEqualTo(id);
				List<ManuscriptVersion> manuscriptVersionList = manuscriptVersionMapper.selectByExample(example);
				ManuscriptVersion mv = new ManuscriptVersion();
				mv.setId(UUID.randomUUID().toString().replace("-",""));
				mv.setProjectid(projectId);
				mv.setDocid(id);
				mv.setHashname(hashname);
				mv.setCreateTime(new Date());
				if(manuscriptVersionList.size()>0 && manuscriptVersionList!=null){
					//按版本号 查询最新版本的数据
					example.setOrderByClause("version desc");
					ManuscriptVersion manuscriptVersion = manuscriptVersionMapper.getNewVersionInfo(example);
					int version = ((Integer.parseInt(manuscriptVersion.getVersion().replace("v","")))+1);
					mv.setVersion(String.valueOf(version));
					if(!hashname.equals(manuscriptVersion.getHashname())){	//如果hashname不一样
						listtemp.add(mv);
						//更改上一个版本的失效时间
						manuscriptVersion.setEndtime(new Date());
						listtemp.add(manuscriptVersion);
					}else{	//如果hashname一样
						if(!isappbefore.equals(isappafter)){	//当是否适用发生变化时
							listtemp.add(mv);
							manuscriptVersion.setEndtime(new Date());
							listtemp.add(manuscriptVersion);
							//更改底稿信息表中当前文件适用不适用字段
							ManuscriptInfo mi = new ManuscriptInfo();
							mi.setId(id);
							mi.setIsapp(Integer.parseInt(isappafter));
							manuscriptInfoList.add(mi);
//							manuscriptInfoMapper.updateByPrimaryKeySelective(mi);
						}
					}
				}else{
					mv.setVersion("v1");
					listtemp.add(mv);
				}
			}
		}
	}

	/**
	 * 初始化目录版本信息
	 * @param info
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void initDirectoryVersion(ProjectInfo info) throws BaseException {
		try{
			List dvList = new ArrayList();
			Map hashnameMap = new HashMap();
			Map versioncompositionMap = new HashMap();
			/*
				1.通过项目id获取全部的根节点目录
				2.遍历目录list，递归
			 */
			ProjectDirectoryExample example = new ProjectDirectoryExample();
			example.setOrderByClause(" directoryno asc");
			ProjectDirectoryExample.Criteria criteria = example.createCriteria();
			criteria.andProjectidEqualTo(info.getId());
			criteria.andParentidEqualTo(info.getId());
			List<ProjectDirectory> tempList = projectDirectoryMapper.selectByExample(example);
			if(tempList != null && tempList.size() > 0){
				for(ProjectDirectory pd : tempList){
					String directoryid1 = pd.getDirectoryid();
					List<DirectoryVersion> directoryVersionList = projectDirectoryService.viewTreeJsonList(info.getId(), directoryid1, hashnameMap, versioncompositionMap);
					if(directoryVersionList != null && directoryVersionList.size() > 0){
						dvList.addAll(directoryVersionList);
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
						dv.setProjectid(info.getId());
						dv.setDirectoryid(directoryid1);
						dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
						dv.setCreateTime(new Date());
						dv.setCreateUser(info.getCreateUser());
						dv.setUpdateTime(new Date());
						dv.setUpdateUser(info.getCreateUser());
						//版本组成，最底层目录没有版本组成，也没有hash
						dv.setVersioncomposition("");
						versioncompositionMap.put(directoryid1,json);
						//目录版本，需要计算版本组成hash
						dv.setVersionhash("");
						hashnameMap.put(directoryid1,dv.getVersionhash());
						dvList.add(dv);
					}
				}
			}
			//处理根目录也就是项目目录的hash，则需要把项目表中的项目信息当做一个顶级的目录版本
			//查询所有根目录节点
			List<ProjectDirectoryTree> parentProjectDirectoryList = projectDirectoryService.viewRootProjectDirectoryTree(info.getId());
			DirectoryVersion dv = new DirectoryVersion();
			dv.setId(UUID.randomUUID().toString().replace("-",""));
			dv.setProjectid(info.getId());
			dv.setDirectoryid(info.getId());
			dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
			dv.setCreateTime(new Date());
			dv.setCreateUser(info.getCreateUser());
			dv.setUpdateTime(new Date());
			dv.setUpdateUser(info.getCreateUser());
			JSONArray jsonArray = new JSONArray();
			if(parentProjectDirectoryList.size()>0){  //如果下一级有目录或文件，则遍历拼装	，目录层级，下一级默认不可能没有目录
				for(ProjectDirectoryTree pdt : parentProjectDirectoryList){
					JSONObject json = new JSONObject();
					json.put("type",pdt.getType());
					json.put("name",pdt.getName());
					if(versioncompositionMap.get(pdt.getId())!=null){	//如果下一级的目录id是之前存在的
						json.put("value",hashnameMap.get(pdt.getId()));
					}else{	//如果下一级的目录id不是之前存在的，则拼装
						if("dir".equals(pdt.getType())){	//如果是目录，需要到目录版本表中去查该目录最新版本的hash
							List<DirectoryVersion> newDvList = this.getNewDirectoryVersion(info.getId(),pdt.getId());
							json.put("value",newDvList.get(0).getVersionhash());
						}else{	//如果是底稿文件，直接取hashname就可以了
							json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
						}
					}
					json.put("isapp",pdt.getIsapp());
					jsonArray.add(json);
				}
				//如果目录的一级目录进行了修改，那么需要对整个项目的hash也要进行一个拼装计算，所以多加一个json
				JSONObject json = new JSONObject();
				json.put("projectname",info.getProjectname());
//				json.put("value",SHA256Util.getSHA256(jsonArray.toString()));
				jsonArray.add(json);
				dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
				hashnameMap.put(info.getId(), dv.getVersionhash());
				dv.setVersioncomposition(jsonArray.toString());
				versioncompositionMap.put(info.getId(),jsonArray);
				dvList.add(dv);
			}
			mapper.batchInsertSelective(dvList);
		}catch (BaseException e){
			logger.error("初始化目录版本信息错误");
			throw new BaseException("初始化目录版本信息错误");
		}
	}

	/**
	 * 根据项目目录信息更新目录版本信息(指定目录id)
	 * @return
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateDirectoryVersion(ProjectDirectory projectDirectory, String userId) throws BaseException {
		/*
			新建/修改自定义目录需要完成：
			1.创建自定义目录是空目录，所以需要新建目录的项目目录信息
				首先新建的目录是空的，hash和版本组成也一定是空的，所以需要查询他的下一级目录和文件的hash
				但是只需要查下一级就可以了，如果下一级没有任何目录或文件，则将版本组成和hash置空，如果有，则遍历拼装。然后将结果拼装起来
				然后依次拼装上级所有目录的json，然后批量insert
			2.更改自定义目录，不一定是空目录，需要修改目录的项目目录信息
				首先更改的目录不一定是空的，hash和版本组成不一定是空的，所以需要查询他的下一级目录和文件的hash
				但是只需要查下一级就可以了，如果下一级没有任何目录或文件，则将版本组成和hash置空，如果有，则遍历拼装。然后将结果拼装起来
				然后依次拼装上级所有目录的json，然后批量insert
		 */
		try{
			List dvList = new ArrayList();
			//hash值
			Map hashnameMap = new HashMap();
			//版本组成
			Map versioncompositionMap = new HashMap();
			//查询下一级目录和文件的hash
		//        List<ProjectDirectoryTree> projectDirectoryList = projectDirectoryService.viewNextTree(projectDirectory.getProjectid(),projectDirectory.getDirectoryid(),userId);
		//		DirectoryVersion dv = new DirectoryVersion();
		//		dv.setId(UUID.randomUUID().toString().replace("-",""));
		//		dv.setProjectid(projectDirectory.getProjectid());
		//		dv.setDirectoryid(projectDirectory.getDirectoryid());
		//		dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
		//		dv.setCreateTime(new Date());
		//		dv.setCreateUser(userId);
		//		dv.setUpdateTime(new Date());
		//		dv.setUpdateUser(userId);
		//        if(projectDirectoryList.size()>0){  //如果下一级有目录或文件，则遍历拼装本级目录的json
		//            JSONArray jsonArray = new JSONArray();
		//            for(ProjectDirectoryTree pd : projectDirectoryList){
		//                JSONObject json = new JSONObject();
		//                json.put("type",pd.getType());
		//                json.put("name",pd.getName());
		//                if("dir".equals(pd.getType())){	//如果是目录，需要到目录版本表中去查该目录最新版本的hash
		//                	List<DirectoryVersion> newDvList = this.getNewDirectoryVersion(projectDirectory.getProjectid(),pd.getId());
		//					json.put("value",newDvList.get(0).getVersionhash());
		//				}else{	//如果是底稿文件，直接取hashname就可以了
		//					json.put("value",pd.getHashname()==null?"":pd.getHashname());
		//				}
		//                json.put("isapp",pd.getIsapp());
		//                jsonArray.add(json);
		//            }
		//            dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
		//            hashnameMap.put(projectDirectory.getDirectoryid(), dv.getVersionhash());
		//            dv.setVersioncomposition(jsonArray.toString());
		//            versioncompositionMap.put(projectDirectory.getDirectoryid(),jsonArray);
		//            dvList.add(dv);
		//        }else{  //如果下一级没有任何目录或文件则将本级目录版本组成和hash置空，再拼装
		//			JSONObject json = new JSONObject();
		//			json.put("type",ProjectDirectoryType.DIR.getCode());
		//			json.put("name",projectDirectory.getFullname());
		//			json.put("value","");
		//			json.put("isapp",projectDirectory.getIsapp());
		//			//版本组成，最底层目录没有版本组成，也没有hash
		//			dv.setVersioncomposition("");
		//			versioncompositionMap.put(projectDirectory.getDirectoryid(),json);
		//			//目录版本，需要计算版本组成hash
		//			dv.setVersionhash("");
		//			hashnameMap.put(projectDirectory.getDirectoryid(),dv.getVersionhash());
		//			dvList.add(dv);
		//        }
			//然后依次拼装上级所有目录的json，此处存储过程查询太慢，优化为递归查询全部上层目录
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("pid",projectDirectory.getDirectoryid());
			paramMap.put("projectId",projectDirectory.getProjectid());
//			List<ProjectDirectory> allParentDirectoryList = projectDirectoryMapper.getAllParentDirectoryById(paramMap);
			List<ProjectDirectory> allParentDirectoryList = projectDirectoryService.viewParentTree(projectDirectory.getProjectid(),projectDirectory.getDirectoryid());

			if(allParentDirectoryList.size()>0){    //如果有上级目录，那么遍历上级目录的子目录和子文件
				for(ProjectDirectory pd : allParentDirectoryList){
					//查询下一级目录和文件的hash
					List<ProjectDirectoryTree> parentProjectDirectoryList = projectDirectoryService.viewNextTree(pd.getProjectid(),pd.getDirectoryid(),userId);
					DirectoryVersion dv1 = new DirectoryVersion();
					dv1.setId(UUID.randomUUID().toString().replace("-",""));
					dv1.setProjectid(pd.getProjectid());
					dv1.setDirectoryid(pd.getDirectoryid());
					dv1.setIsDelete(BaseConstant.DEL_FLAG_NO);
					dv1.setCreateTime(new Date());
					dv1.setCreateUser(userId);
					dv1.setUpdateTime(new Date());
					dv1.setUpdateUser(userId);
					if(parentProjectDirectoryList.size()>0){  //如果下一级有目录或文件，则遍历拼装
						JSONArray jsonArray = new JSONArray();
						for(ProjectDirectoryTree pdt : parentProjectDirectoryList){
							if(pdt.getId().equals(projectDirectory.getDirectoryid())){	//如果遍历的目录是所改的目录
								JSONObject json = new JSONObject();
								json.put("type",ProjectDirectoryType.DIR.getCode());
								json.put("name",projectDirectory.getFullname());
		//							json.put("value",hashnameMap.get(projectDirectory.getDirectoryid()));
								if("dir".equals(pdt.getType())){	//如果是目录，需要到目录版本表中去查该目录最新版本的hash
									List<DirectoryVersion> newDvList = this.getNewDirectoryVersion(projectDirectory.getProjectid(),pdt.getId());
									//如果目录版本表中没有版本，则是新目录，直接置空
									if(newDvList.size()>0){
										json.put("value",newDvList.get(0).getVersionhash());
									}else{
										json.put("value","");
									}
								}else{	//如果是底稿文件，直接取hashname就可以了
									json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
								}
								json.put("isapp",projectDirectory.getIsapp());
								jsonArray.add(json);
							}else{	//如果是其他目录
								JSONObject json = new JSONObject();
								json.put("type",pdt.getType());
								json.put("name",pdt.getName());
								if(versioncompositionMap.get(pdt.getId())!=null){	//如果下一级的目录id是之前存在的
									json.put("value",hashnameMap.get(pdt.getId()));
								}else{	//如果下一级的目录id不是之前存在的，则拼装
									if("dir".equals(pdt.getType())){	//如果是目录，需要到目录版本表中去查该目录最新版本的hash
										List<DirectoryVersion> newDvList = this.getNewDirectoryVersion(projectDirectory.getProjectid(),pdt.getId());
										if(newDvList.size()>0){
											json.put("value",newDvList.get(0).getVersionhash());
										}else{
											json.put("value","");
										}
									}else{	//如果是底稿文件，直接取hashname就可以了
										json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
									}
								}
								json.put("isapp",pdt.getIsapp());
								jsonArray.add(json);
							}
						}
						dv1.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
						hashnameMap.put(projectDirectory.getDirectoryid(), dv1.getVersionhash());
						dv1.setVersioncomposition(jsonArray.toString());
						versioncompositionMap.put(projectDirectory.getDirectoryid(),jsonArray);
					}else{  //如果下一级没有任何目录或文件则将版本组成和hash置空，再拼装(当前目录的父目录不可能没有下级目录，就像我师父的徒弟是谁一个道理)

					}
					dvList.add(dv1);
				}
			}
			//处理根目录也就是项目目录的hash，则需要把项目表中的项目信息当做一个顶级的目录版本
			List<DirectoryVersion> rootProjectDirectoryDvList=  this.getRootProjectDirectoryDv(projectDirectory,hashnameMap,versioncompositionMap,userId);
			dvList.addAll(rootProjectDirectoryDvList);
			mapper.batchInsertSelective(dvList);
		}catch (BaseException e){
			logger.error("根据项目目录信息更新目录版本信息错误");
			throw new BaseException("根据项目目录信息更新目录版本信息错误");
		}
	}

	/**
	 * 获取根目录节点的目录版本
	 * @param projectDirectory
	 * @param hashnameMap
	 * @param versioncompositionMap
	 * @param userId
	 * @return
	 * @throws BaseException
	 */
	public List<DirectoryVersion> getRootProjectDirectoryDv(ProjectDirectory projectDirectory, Map hashnameMap, Map versioncompositionMap, String userId) throws  BaseException{
		List dvList = new ArrayList();
		//查询项目信息
		ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(projectDirectory.getProjectid());
		//查询所有根目录节点
		List<ProjectDirectoryTree> parentProjectDirectoryList = projectDirectoryService.viewRootProjectDirectoryTree(projectDirectory.getProjectid());
		DirectoryVersion dv = new DirectoryVersion();
		dv.setId(UUID.randomUUID().toString().replace("-",""));
		dv.setProjectid(projectDirectory.getProjectid());
		dv.setDirectoryid(projectDirectory.getProjectid());
		dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
		dv.setCreateTime(new Date());
		dv.setCreateUser(userId);
		dv.setUpdateTime(new Date());
		dv.setUpdateUser(userId);
		JSONArray jsonArray = new JSONArray();
		if(parentProjectDirectoryList.size()>0){  //如果下一级有目录或文件，则遍历拼装	，目录层级，下一级默认不可能没有目录
			for(ProjectDirectoryTree pdt : parentProjectDirectoryList){
				if(pdt.getId().equals(projectDirectory.getDirectoryid())){	//如果遍历的目录是所改的目录
					JSONObject json = new JSONObject();
					json.put("type",ProjectDirectoryType.DIR.getCode());
					json.put("name",projectDirectory.getFullname());
					if("dir".equals(pdt.getType())){	//如果是目录，需要到目录版本表中去查该目录最新版本的hash
						List<DirectoryVersion> newDvList = this.getNewDirectoryVersion(projectDirectory.getProjectid(),pdt.getId());
//						json.put("value",newDvList.get(0).getVersionhash());
						if(newDvList.size()>0){
							json.put("value",newDvList.get(0).getVersionhash());
						}else{
							json.put("value","");
						}
					}else{	//如果是底稿文件，直接取hashname就可以了
						json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
					}
					json.put("isapp",projectDirectory.getIsapp());
					jsonArray.add(json);
				}else{	//如果是其他目录
					JSONObject json = new JSONObject();
					json.put("type",pdt.getType());
					json.put("name",pdt.getName());
					if(versioncompositionMap.get(pdt.getId())!=null){	//如果下一级的目录id是之前存在的
						json.put("value",hashnameMap.get(pdt.getId()));
					}else{	//如果下一级的目录id不是之前存在的，则拼装
						if("dir".equals(pdt.getType())){	//如果是目录，需要到目录版本表中去查该目录最新版本的hash
							List<DirectoryVersion> newDvList = this.getNewDirectoryVersion(projectDirectory.getProjectid(),pdt.getId());
//							json.put("value",newDvList.get(0).getVersionhash());
							if(newDvList.size()>0){
								json.put("value",newDvList.get(0).getVersionhash());
							}else{
								json.put("value","");
							}
						}else{	//如果是底稿文件，直接取hashname就可以了
							json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
						}
					}
					json.put("isapp",pdt.getIsapp());
					jsonArray.add(json);
				}
			}
			//如果目录的一级目录进行了修改，那么需要对整个项目的hash也要进行一个拼装计算，所以多加一个json
			JSONObject json = new JSONObject();
			json.put("projectname",projectInfo.getProjectname());
			json.put("value",SHA256Util.getSHA256(jsonArray.toString()));
			jsonArray.add(json);
			dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
			hashnameMap.put(projectDirectory.getDirectoryid(), dv.getVersionhash());
			dv.setVersioncomposition(jsonArray.toString());
			versioncompositionMap.put(projectDirectory.getDirectoryid(),jsonArray);
			dvList.add(dv);
		}
		return dvList;
	}

	/**
	 * 获取最新的目录版本
	 * @param projectId
	 * @param directoryId
	 * @return
	 * @throws BaseException
	 */
	@Override
	public List<DirectoryVersion> getNewDirectoryVersion(String projectId, String directoryId) throws BaseException {
		List<DirectoryVersion> list = new ArrayList<DirectoryVersion>();
		DirectoryVersionExample example = new DirectoryVersionExample();
		//按主键倒序 查询
		example.setOrderByClause("create_time desc");
		DirectoryVersionExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
		if (!StringUtils.isEmpty(projectId)) {
			criteria.andProjectidEqualTo(projectId);
		}
		if (!StringUtils.isEmpty(directoryId)) {
			criteria.andDirectoryidEqualTo(directoryId);
		}
		list = mapper.getNewDirectoryVersion(example);
		return list;
	}

	/**
	 * 获取整个项目需要提交的目录版本
	 * @param projectId
	 * @return
	 */
	@Override
	public List<DirectoryVersion> viewProjectTreeDirectoryVersionList(String projectId, Map pidMap, String userId,  Map hashnameMap, Map versioncompositionMap) {
//		Map hashnameMap = new HashMap();
//		Map versioncompositionMap = new HashMap();
		List dvList = new ArrayList();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		ProjectDirectoryExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectId);
		criteria.andParentidEqualTo(projectId);
		List<ProjectDirectory> tempList = projectDirectoryMapper.selectByExample(example);
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList) {
				String directoryId = pd.getDirectoryid();
				List<DirectoryVersion> projectDirectoryList = this.viewTreeJsonListForDeep(projectId, directoryId, hashnameMap, versioncompositionMap, pidMap, userId);
				if(projectDirectoryList!=null && projectDirectoryList.size()>0){
					dvList.addAll(projectDirectoryList);
				}
			}
		}
		return dvList;
	}

	@Override
	public List<DirectoryVersion> test(String projectId) throws BaseException {
		List dvList = new ArrayList();
		Map hashnameMap = new HashMap();
		Map versioncompositionMap = new HashMap();
		List<ProjectDirectoryTree> parentProjectDirectoryList = projectDirectoryService.viewRootProjectDirectoryTree(projectId);
		DirectoryVersion dv = new DirectoryVersion();
		dv.setId(UUID.randomUUID().toString().replace("-",""));
		dv.setProjectid(projectId);
		dv.setDirectoryid(projectId);
		dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
		dv.setCreateTime(new Date());
//		dv.setCreateUser(info.getCreateUser());
		dv.setUpdateTime(new Date());
//		dv.setUpdateUser(info.getCreateUser());
		JSONArray jsonArray = new JSONArray();
		if(parentProjectDirectoryList.size()>0){  //如果下一级有目录或文件，则遍历拼装	，目录层级，下一级默认不可能没有目录
			for(ProjectDirectoryTree pdt : parentProjectDirectoryList){
				JSONObject json = new JSONObject();
				json.put("type",pdt.getType());
				json.put("name",pdt.getName());
				if(versioncompositionMap.get(pdt.getId())!=null){	//如果下一级的目录id是之前存在的
					json.put("value",hashnameMap.get(pdt.getId()));
				}else{	//如果下一级的目录id不是之前存在的，则拼装
					if("dir".equals(pdt.getType())){	//如果是目录，需要到目录版本表中去查该目录最新版本的hash
						List<DirectoryVersion> newDvList = this.getNewDirectoryVersion(projectId,pdt.getId());
						json.put("value",newDvList.get(0).getVersionhash());
					}else{	//如果是底稿文件，直接取hashname就可以了
						json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
					}
				}
				json.put("isapp",pdt.getIsapp());
				jsonArray.add(json);
			}
			//如果目录的一级目录进行了修改，那么需要对整个项目的hash也要进行一个拼装计算，所以多加一个json
			JSONObject json = new JSONObject();
			json.put("projectname","aasdasdas");
//				json.put("value",SHA256Util.getSHA256(jsonArray.toString()));
			jsonArray.add(json);
			dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
			hashnameMap.put(projectId, dv.getVersionhash());
			dv.setVersioncomposition(jsonArray.toString());
			versioncompositionMap.put(projectId,jsonArray);
			dvList.add(dv);
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
	public List<DirectoryVersion> viewTreeJsonListForDeep(String projectid, String directoryid, Map hashnameMap, Map versioncompositionMap, Map pidMap, String userId) {
		List list = new ArrayList();
		ProjectDirectoryExample example = new ProjectDirectoryExample();
		example.setOrderByClause(" directoryno asc");
		ProjectDirectoryExample.Criteria criteria = example.createCriteria();
		criteria.andProjectidEqualTo(projectid);
		criteria.andParentidEqualTo(directoryid);
		//通过项目id和目录id查询是否有下级目录和文件
		List<ProjectDirectory> tempList = projectDirectoryMapper.selectByExample(example);
		//如果有，则继续递归
		boolean flag = false;
		if(tempList != null && tempList.size() > 0){
			for(ProjectDirectory pd : tempList){
				String directoryid1 = pd.getDirectoryid();
				List<DirectoryVersion> projectDirectoryList = this.viewTreeJsonListForDeep(projectid, directoryid1, hashnameMap, versioncompositionMap, pidMap, userId);
				//如果返回是空的，说明再往下没有目录了，如果返回不是空的，说明下面还有目录，返回的是目录的list
				if(projectDirectoryList != null && projectDirectoryList.size()>0){
					list.addAll(projectDirectoryList);
					flag = true;
				}
			}
			//目的：
			//判断该目录是否是之前已经拼装过
			if(versioncompositionMap.get(directoryid)!=null){	//如果不存在

			}else{
				if(flag){
					//目录都处理完之后，用目录id当做父目录id去查询该目录下的所有目录
					DirectoryVersion dv = new DirectoryVersion();
					dv.setId(UUID.randomUUID().toString().replace("-",""));
					dv.setProjectid(projectid);
					dv.setDirectoryid(directoryid);
					dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
					dv.setCreateTime(new Date());
					dv.setCreateUser("1");
					dv.setUpdateTime(new Date());
					dv.setUpdateUser("1");
					//查询该目录下全部目录和文件
					List<ProjectDirectoryTree> projectDirectoryList = projectDirectoryService.viewNextTree(projectid,directoryid,userId);
					JSONArray jsonArray = new JSONArray();
					if(projectDirectoryList != null && projectDirectoryList.size() > 0){
						for(ProjectDirectoryTree pdt:projectDirectoryList){
							JSONObject json = new JSONObject();
							json.put("type",pdt.getType());
							json.put("name",pdt.getName());
							if(versioncompositionMap.get(pdt.getId())!=null){
								json.put("value",hashnameMap.get(pdt.getId()));
							}else{
								json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
							}
							json.put("isapp",pdt.getIsapp());
							jsonArray.add(json);
						}
					}
					dv.setVersioncomposition(jsonArray.toString());
					versioncompositionMap.put(directoryid,jsonArray);
					dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
					hashnameMap.put(directoryid, dv.getVersionhash());
					list.add(dv);
				}
			}
		}else{	//如果下面没有目录了
			//判断该目录的id是否在新增或变更的底稿文件中pid中
			//如果有，则需要重新组装目录版本
			if(pidMap.get(directoryid)!=null){
				DirectoryVersion dv = new DirectoryVersion();
				dv.setId(UUID.randomUUID().toString().replace("-",""));
				dv.setProjectid(projectid);
				dv.setDirectoryid(directoryid);
				dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
				dv.setCreateTime(new Date());
				dv.setCreateUser("1");
				dv.setUpdateTime(new Date());
				dv.setUpdateUser("1");
				//查询该目录下全部目录和文件
				List<ProjectDirectoryTree> projectDirectoryList = projectDirectoryService.viewNextTree(projectid,directoryid,"1");
				JSONArray jsonArray = new JSONArray();
				if(projectDirectoryList != null && projectDirectoryList.size() > 0){
					for(ProjectDirectoryTree pdt:projectDirectoryList){
						JSONObject json = new JSONObject();
						json.put("type",pdt.getType());
						json.put("name",pdt.getName());
						if(versioncompositionMap.get(pdt.getId())!=null){
							json.put("value",hashnameMap.get(pdt.getId()));
						}else{
							json.put("value",pdt.getHashname()==null?"":pdt.getHashname());
						}
						json.put("isapp",pdt.getIsapp());
						jsonArray.add(json);
					}
				}
				dv.setVersioncomposition(jsonArray.toString());
				versioncompositionMap.put(directoryid,jsonArray);
				dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
				hashnameMap.put(directoryid, dv.getVersionhash());
				list.add(dv);
			}
		}
		return list;
	}
}