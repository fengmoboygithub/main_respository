package com.company.processnodeinfo.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.config.ProcessEngineConfig;
import com.company.constant.BaseConstant;
import com.company.directoryopinion.dao.DirectoryOpinionMapper;
import com.company.directoryopinion.model.DirectoryOpinion;
import com.company.directoryopinion.model.DirectoryOpinionExample;
import com.company.directoryopinion.service.DirectoryOpinionService;
import com.company.directoryversion.dao.DirectoryVersionMapper;
import com.company.directoryversion.model.DirectoryVersion;
import com.company.directoryversion.service.DirectoryVersionService;
import com.company.enums.DirectoryOpinionType;
import com.company.manuscriptinfo.service.ManuscriptInfoService;
import com.company.manuscriptversion.dao.ManuscriptVersionMapper;
import com.company.manuscriptversion.model.ManuscriptVersion;
import com.company.manuscriptversion.model.ManuscriptVersionExample;
import com.company.processnodeinfo.dao.ProcessNodeInfoMapper;
import com.company.processnodeinfo.model.ProcessNodeInfo;
import com.company.processnodeinfo.model.ProcessNodeInfoExample;
import com.company.processnodeinfo.service.ProcessNodeInfoService;
import com.company.projectdirectory.dao.ProjectDirectoryMapper;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.service.ProjectDirectoryService;
import com.company.projectdirectory.view.ProjectDirectoryTree;
import com.company.projectinfo.dao.ProjectInfoMapper;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.service.ProjectInfoService;
import com.company.projectstageinfo.dao.ProjectStageInfoMapper;
import com.company.projectstageinfo.model.ProjectStageInfo;
import com.company.projectstageinfo.model.ProjectStageInfoExample;
import com.company.utils.SHA256Util;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

@Service
public class ProcessNodeInfoServiceImpl extends BaseServiceImpl<ProcessNodeInfo, ProcessNodeInfoExample> implements ProcessNodeInfoService<ProcessNodeInfo, ProcessNodeInfoExample>{

    @Autowired
    private ProcessNodeInfoMapper mapper;
	
	public IBaseDao<ProcessNodeInfo, ProcessNodeInfoExample> getMapper(){
		return mapper;
	}

	/**
	 * 项目目录信息service
	 */
	@Autowired
	private ProjectDirectoryService projectDirectoryService;

	/**
	 * 项目目录信息mapper
	 */
	@Autowired
	private ProjectDirectoryMapper projectDirectoryMapper;

	/**
	 * 目录意见信息mapper
	 */
	@Autowired
	private DirectoryOpinionMapper directoryOpinionMapper;

	/**
	 * 目录版本mapper
	 */
	@Autowired
	private DirectoryVersionMapper directoryVersionMapper;

	@Autowired
	private DirectoryVersionService directoryVersionService;

	/**
	 * 底稿文件版本mapper
	 */
	@Autowired
	private ManuscriptVersionMapper manuscriptVersionMapper;

	@Autowired
	private ManuscriptInfoService manuscriptInfoService;

	@Autowired
	private DirectoryOpinionService directoryOpinionService;

	@Autowired
	private ProjectInfoMapper projectInfoMapper;

	@Autowired
	private ProjectStageInfoMapper projectStageInfoMapper;

	@Autowired
	private ProcessEngineConfig processEngine;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private ProjectInfoService projectInfoService;

	/**
	 * 统一账户管理外部调用url
	 */
	@Value("${web.user-system-url}")
	private String userSystemUrl;

	/**
	 * 内核管理员角色id
	 */
	@Value("${role.internalreviewroleid}")
	private String internalReviewRoleId;


	public ProcessNodeInfo getNextProcessNode(String processnode, String opertype) throws BaseException {
		ProjectInfo projectinfo = projectInfoMapper.selectByPrimaryKey("c9c70c4d82964f049339a7458670e760");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startprocessnode","21");
		map.put("operid","1");
		map.put("projectstage","100");
		map.put("projecttype",projectinfo.getProjecttype());
		ProcessNodeInfo targetProcessNodeInfo = mapper.getNextProcessNode(map);
		return mapper.getNextProcessNode(map);
	}

	/**
	 * 1.保存意见的操作，要保存意见信息，底稿信息也要保存吗？底稿信息保存是在上传那时候就保存了还是保存操作时候才保存？
	 * 2.所有下一级节点，所在的流程必须大于当前节点,这里指的是所有子节点还是所有子孙节点
	 * 3.流程处理时候操作目录树，提交的时候是多个？那目录树DAG也是多个？
	 * @param projectId		项目id
	 * @param projectStage	项目阶段
	 * @param processnode	当前目录流程节点
	 * @param operId	操作id
	 * @param treeDag	dag树
	 *                  id：目录id，opinion：意见， type：类型,dir和file，pid：父目录id，processnode：当前流程节点，isappbefore：是否适用(改之前)1-适用  2-不适用，
	 *                  isappafter：是否适用(改之后)1-适用  2-不适用，hashname：文件存储名，docname：文件显示名
	 *               dag格式:
	 * 				[{"id":"id","opinion":"opinion","type":"dir","pid":"pid"},
	 * 				{"id":"id","opinion":"opinion","type":"dir","pid":"pid"},
	 * 				{"id":"id","opinion":"opinion","type":"dir","pid":"pid"},
	 * 				{"id":"id","opinion":"opinion","type":"dir","pid":"pid"},
	 * 				{"id":"id","opinion":"opinion","type":"dir","pid":"pid"},
	 * 				{"id":"id","opinion":"opinion","type":"dir","pid":"pid"},
	 * 				{"id":"id","opinion":"opinion","type":"dir","pid":"pid"},
	 * 				{"id":"id","opinion":"opinion","type":"file","pid":"pid","hashname":"hashname"}]
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public String updateProcess(String projectId, String projectStage, String processnode, String operId, String userName, String userId, String treeDag, String countersignUserIds) throws BaseException {
		JSONArray rootArray = JSONArray.parseArray(treeDag);
		//判断treedag中目录的所在流程节点是否和当前操作流程节点相等
		JSONObject validateJsonObject = null;
		for(int i=0;i<rootArray.size();i++) {        //同级目录查询，上级目录查询
			validateJsonObject = rootArray.getJSONObject(i);
			String id = validateJsonObject.get("id").toString();
			//此处改为从数据库再去查询一遍项目目录表，避免并发操作出现
//			String directoryProcessnode = validateJsonObject.get("processnode").toString();
			ProjectDirectory queryCriteria = new ProjectDirectory();
			queryCriteria.setProjectid(projectId);
			queryCriteria.setDirectoryid(id);
			ProjectDirectory projectDirectory = projectDirectoryMapper.selectByPrimaryKey(queryCriteria);
			//类型，dir:目录，file:文件
			String type = validateJsonObject.get("type").toString();
			if("dir".equals(type) && !processnode.equals(projectDirectory.getProcessnode())){
				throw new BaseException("所选全部目录流程节点必须为当前节点！");
			}
		}
		//后续需要验证目录内是否有文件，如果是子目录内有文件也算有文件
		/*
			思路：每个目录都递归查询
		 */

		// 处理历史库
		if("1".equals(operId)){	//提交操作
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
			 */
			JSONObject jsonObject = null;
			List listtemp = new ArrayList();
			List<DirectoryVersion> dvList = new ArrayList<>();
			Map pidMap = new HashMap();
			//倒序处理历史版本
			for(int i=rootArray.size()-1;i>=0;i--) {
				jsonObject = rootArray.getJSONObject(i);
				String id = jsonObject.get("id").toString();	//当类型为底稿时，此id为底稿文件id
				String pid = "";
				//当pid为空时，该目录为父目录
				if(null!=jsonObject.get("pid")){
					pid = jsonObject.get("pid").toString();
				}
				//类型，dir:目录，file:文件
				String type = jsonObject.get("type").toString();
				if ("dir".equals(type)) {    //如果是目录

				} else if ("file".equals(type)) {    //如果是底稿文件
					String hashname = jsonObject.get("hashname").toString();
					//首先处理底稿版本信息表
					//底稿版本信息中，根据底稿id查询底稿版本信息是否存在
					ManuscriptVersionExample example = new ManuscriptVersionExample();
					ManuscriptVersionExample.Criteria criteria = example.createCriteria();
					criteria.andDocidEqualTo(id);
					criteria.andHashnameEqualTo(hashname);
					List<ManuscriptVersion> manuscriptVersionList = manuscriptVersionMapper.selectByExample(example);
					ManuscriptVersion mv = new ManuscriptVersion();
					mv.setId(UUID.randomUUID().toString().replace("-",""));
					mv.setProjectid(projectId);
					mv.setDocid(id);
					mv.setHashname(hashname);
					mv.setIsDelete(BaseConstant.DEL_FLAG_NO);
					mv.setCreateTime(new Date());
					if(manuscriptVersionList.size()>0 && manuscriptVersionList!=null){	//如果存在
						//通过底稿id查询底稿版本信息中版本倒序最大版本的hash
                        ManuscriptVersionExample example1 = new ManuscriptVersionExample();
                        ManuscriptVersionExample.Criteria criteria1 = example1.createCriteria();
                        criteria1.andDocidEqualTo(id);
						example.setOrderByClause("version desc");
						ManuscriptVersion manuscriptVersion = manuscriptVersionMapper.getNewVersionInfo(example1);
						if(!hashname.equals(manuscriptVersion.getHashname())){	//如果hashname和提交的不一样,则+1
							int version = ((Integer.parseInt(manuscriptVersion.getVersion().replace("v","")))+1);
							mv.setVersion(String.valueOf(version));
							listtemp.add(mv);
							//更改上一个版本的失效时间
							manuscriptVersion.setEndtime(new Date());
							listtemp.add(manuscriptVersion);
							pidMap.put(pid,pid);
						}else{	//如果hashname和提交的一样，此处不变

						}
					}else{	//如果这个文件不存在，则设置版本号为v1
						mv.setVersion("v1");
						listtemp.add(mv);
						pidMap.put(pid,pid);
					}
					//加入底稿文件索引中
//                    ManuscriptInfo info = new ManuscriptInfo();
//                    info = (ManuscriptInfo) manuscriptInfoService.get(id);
//                    info.setId(mv.getId());
//                    manuscriptInfoService.saveForManuscriptInfoForEsRepository(info, ManuscriptInfoEsMode.ADD, ManuscriptInfoEsVersion.HISTORY);
//					/*
//						查看pid字段，给pid赋一个临时变量，遍历下一个的时候，判断
//						如果下一个的目录id等于上一个pid临时变量，说明下一个是上一个的父目录，需要通过下一个目录的id查出全部下一级子文件和子目录，拼装json，和计算拼装后的hash
//						如果下一个的目录id不等于上一个pid临时变量，则再判断
//							如果上一个pid临时变量不等于下一个目录pid，说明上一个目录的父目录和下一个目录的父目录不是一个目录，需要通过上一个目录的父目录id查出全部下一级子文件和子目录，拼装json，和计算拼装后的hash
//							如果上一个pid临时变量等于下一个目录pid，则不做处理，继续循环下一个
//						还得考虑如果是单独的一个目录的处理方式
//						如果处理完最后一个，还没有到根目录，则需要查询最后一个目录的全部父目录，然后依次根据每个父目录的id，查询自己的下一级子文件和目录，然后拼装json和重新计算hash
//					 */
//					//两种做法，第一种是只要是提交，就生成一个目录版本，第二种是有文件变化才提交目录版本，先采用第二种方式
//					//由于上传文件时已经重新计算目录的相关路径的hash了，所以此处不用重新计算了，都放到list中批量插入即可，注意去重
//					//查询底稿文件的父节点，再查父节点的全部父节点
//					//先看map中是否有该目录的值，如果有，就不用再处理了
					/*
						插入目录版本
						原则：只修改有底稿文件且是新增或者修改了底稿的父目录及祖先目录的目录版本
						也就是说需要把符合条件的父目录拿出来(可以把底稿文件的pid拿出来)，放到map中，倒序放到list中
						遍历list，通过pid查询子目录id和文件
							如果id在之前的pid的map中，那么用pid的hash
							如果id不在之前的pid的map中，那么直接用查出来的目录和文件hash
						然后计算这些父目录的hash，如果并放到map中,key是目录id,value是hash值
						根据父目录的再查询上级目录的hash，如果遇到map中存在的目录id，则用

						将pid放到in里，查询项目目录表中的level最大级别
						然后用最大级别当做条件，查询in中的项目目录list，然后依次根据目录id去查下级目录，拼装并计算hash，并放到map中
						然后递减level级别

						根据项目id递归查询全部目录，在递归中，只计算有pid的目录

					 */
				}
			}
			//批量更新文件版本
			if(listtemp!=null && listtemp.size()>0){
				manuscriptVersionMapper.updateBatch(listtemp);
			}
			//查询项目信息
			ProjectInfo projectInfo = (ProjectInfo)projectInfoService.get(projectId);

			//处理目录版本信息表
            Map hashnameMap = new HashMap();
            Map versioncompositionMap = new HashMap();
			dvList = directoryVersionService.viewProjectTreeDirectoryVersionList(projectId,pidMap,userId,hashnameMap,versioncompositionMap);
            List<ProjectDirectoryTree> parentProjectDirectoryList = projectDirectoryService.viewRootProjectDirectoryTree(projectId);
            DirectoryVersion dv = new DirectoryVersion();
            dv.setId(UUID.randomUUID().toString().replace("-",""));
            dv.setProjectid(projectId);
            dv.setDirectoryid(projectId);
            dv.setIsDelete(BaseConstant.DEL_FLAG_NO);
            dv.setCreateTime(new Date());
            dv.setCreateUser(userId);
            dv.setUpdateTime(new Date());
            dv.setUpdateUser(userId);
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
                            List<DirectoryVersion> newDvList = directoryVersionService.getNewDirectoryVersion(projectId,pdt.getId());
//                            json.put("value",newDvList.get(0).getVersionhash());
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
                //如果目录的一级目录进行了修改，那么需要对整个项目的hash也要进行一个拼装计算，所以多加一个json
                JSONObject json = new JSONObject();
                json.put("projectname",projectInfo.getProjectname());
//				json.put("value",SHA256Util.getSHA256(jsonArray.toString()));
                jsonArray.add(json);
                dv.setVersionhash(SHA256Util.getSHA256(jsonArray.toString()));
                hashnameMap.put(projectId, dv.getVersionhash());
                dv.setVersioncomposition(jsonArray.toString());
                versioncompositionMap.put(projectId,jsonArray);
                dvList.add(dv);
            }
			//批量插入目录版本
			if(dvList!=null && dvList.size()>0){
				directoryVersionMapper.batchInsertSelective(dvList);
			}
		}
		/*
			提交多个流程节点，如提交2的时候会将2下所有节点提交，可以将2和3.1同时提交，但是不会存在2和2.1，
			当2全选后，取消2.1时，那么提交的就是单纯的2.2，2.3....
		 */
		//获取目标流程节点 = 工作流下一节点（输入 用户名、当前流程节点、操作）
		ProjectInfo projectinfo = projectInfoMapper.selectByPrimaryKey(projectId);
		Map<String,Object> parmaMap = new HashMap<String,Object>();
		parmaMap.put("startprocessnode",processnode);
		parmaMap.put("operid",operId);
		parmaMap.put("projectstage",projectStage);
		parmaMap.put("projecttype",projectinfo.getProjecttype());
		ProcessNodeInfo targetProcessNodeInfo = mapper.getNextProcessNode(parmaMap);
		if(null == targetProcessNodeInfo){
			throw new BaseException("目标节点不能为空！");
		}else if(Integer.parseInt(targetProcessNodeInfo.getProcessnode())>Integer.parseInt(processnode)){	//当 目标流程 > 当前流程节点 则是正向提交
			JSONObject jsonObject = null;
			String tempPid = "";
			/*
				循环遍历dag
				循环中需要做的事情
				1.当类型是dir目录时，则将意见保存到目录意见表；当类型是file底稿文件，则将意见保存到底稿意见表(保存底稿意见可暂缓做)
				2.所有目录节点的下一级目录节点必须大于当前节点，如果有一个下一级目录流程节点小于当前流程节点，则err
				3.查询当前节点的父节点，
		 	*/
			for(int i=0;i<rootArray.size();i++){		//同级目录查询，上级目录查询
				jsonObject = rootArray.getJSONObject(i);
				String id = jsonObject.get("id").toString();
				//类型，dir:目录，file:文件
				String type = jsonObject.get("type").toString();
				//验证全部目录的流程节点必须都在当前操作节点上，避免多人同时操作同一个目录。如果目录数据库中的流程节点不在当前操作节点上，则不更新该节点
				//查询下级目录树
				List<ProjectDirectoryTree> list = projectDirectoryService.viewTree(projectId, projectStage, id);
				//遍历所有目录的流程
				if(list.size()>0){
					for (ProjectDirectoryTree projectDirectoryTree:list) {
						//此处如接口加入子目录流程节点，则不需要再调接口查询，直接使用下面代码即可
						String targetProcessNode = projectDirectoryTree.getProcessnode();
						//只有类型为目录的时候才会去查节点，需要提供该字段
						if("dir".equals(projectDirectoryTree.getType())){
							//所有下一级目录流程节点，必须大于当前节点
							if(Integer.parseInt(targetProcessNode)<Integer.parseInt(processnode)){
								logger.error("目录流程节点小于当前流程节点");
								throw new BaseException("目录流程节点小于当前流程节点");
							}
						}
					}
				}
				//意见内容
                //待录入提交时，不更新意见内容表
                if(Integer.parseInt(processnode)>20){
                    //意见内容
                    String opinion = "";
                    if(jsonObject.get("opinion")!=null){
                        opinion = jsonObject.get("opinion").toString();
                    }
                    if(StringUtils.isEmpty(opinion)){
                        opinion = "同意";
                    }
                    String hashname = "";
                    if(jsonObject.get("hashname")!=null){
                        hashname = jsonObject.get("hashname").toString();
                    }
					if("dir".equals(type)){	//如果是目录
						//提交意见，将意见内容insert一份正式的，并删除掉草稿
						directoryOpinionService.saveOpinion(opinion, projectId, id, userName, userId, hashname, DirectoryOpinionType.SUBMIT.getCode());
						DirectoryOpinion directoryOpinion = new DirectoryOpinion();
						directoryOpinion.setProjectid(projectId);
						directoryOpinion.setDirectoryid(id);
						directoryOpinion.setOpinionType(DirectoryOpinionType.DFAFT.getCode());
						directoryOpinion = directoryOpinionMapper.getDirectoryOpinion(directoryOpinion);
						if(directoryOpinion!=null){
							DirectoryOpinionExample example = new DirectoryOpinionExample();
							DirectoryOpinionExample.Criteria criteria = example.createCriteria();
							criteria.andProjectidEqualTo(projectId);
							criteria.andDirectoryidEqualTo(id);
							criteria.andOpiniontypeEqualTo(DirectoryOpinionType.DFAFT.getCode());
							directoryOpinionService.deleteByExample(example);
						}
					}else if("file".equals(type)){	//如果是底稿文件

					}
				}
				//父目录id
				String pid = "";
				//当pid为空时，该目录为父目录
				if(null!=jsonObject.get("pid")){
					pid = jsonObject.get("pid").toString();
				}
				//通过当前目录的父目录id获取父目录流程节点
				String pProcessnode = "";
//				if(!tempPid.equals(pid) && !projectId.equals(pid)){	//如果父目录id临时变量和父目录id不同，则给父目录id临时变量重新赋值，并查询父目录的流程节点
//                tempPid = pid;
                if(!projectId.equals(pid)){	//如果父目录id不是项目id，则查询父目录的流程节点
                    //通过查询项目目录表获取父目录流程节点（此处可以改成先获取dag中全部的pid，然后通过sql的in去查，然后再去结果集中获取，可以避免多次和数据库交互）
					ProjectDirectory queryCriteria = new ProjectDirectory();
					queryCriteria.setProjectid(projectId);
					queryCriteria.setDirectoryid(pid);
					ProjectDirectory projectDirectory = projectDirectoryMapper.selectByPrimaryKey(queryCriteria);
					pProcessnode = projectDirectory.getProcessnode();

					//通过父目录id查询同级全部目录的流程节点
					Map<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.put("projectStage",projectStage);
					paramMap.put("pid",pid);
					paramMap.put("projectId",projectId);
					List<ProjectDirectory> siblingList = projectDirectoryMapper.getSiblingDirectoryProcessnode(paramMap);
					//遍历同级目录流程节点，如果有目录节点小于目标节点的，就设置个flag，在下面判断
					boolean flag = true;
					if(siblingList.size()>0){
						for(ProjectDirectory temp:siblingList){
							//除去当前节点
							if(!temp.getDirectoryid().equals(id)){
								if(Integer.parseInt(temp.getProcessnode())<Integer.parseInt(targetProcessNodeInfo.getProcessnode())){
									flag = false;
									break;
								}
							}
						}
					}
					//父目录节点小于目标节点  并且  同级目录节点大于等于目标节点
					if(Integer.parseInt(pProcessnode)<Integer.parseInt(targetProcessNodeInfo.getProcessnode()) && flag){
						//更新上级目录流程节点
						ProjectDirectory model = new ProjectDirectory();
						model.setProjectid(projectId);
						model.setDirectoryid(pid);
						model.setProcessnode(targetProcessNodeInfo.getProcessnode());
						int success = projectDirectoryMapper.updateByPrimaryKeySelective(model);
						if (success <= 0) {
							logger.error("更新上级目录流程节点实体错误{}",  model.toString());
							throw new BaseException("更新上级目录流程节点实体错误");
						}
						//更新上级目录意见，加入临时变量的目的是不重复保存上级目录意见
                        if(Integer.parseInt(processnode)>20 && !tempPid.equals(pid)) {
                            tempPid = pid;
                            DirectoryOpinion directoryOpinion = new DirectoryOpinion();
                            directoryOpinion.setProjectid(projectId);
                            directoryOpinion.setDirectoryid(pid);
                            directoryOpinion.setOpinionType(DirectoryOpinionType.DFAFT.getCode());
                            directoryOpinion = directoryOpinionMapper.getDirectoryOpinion(directoryOpinion);
                            String opinion = "";
                            if (directoryOpinion == null) {
                                opinion = "同意";
                            } else {
                                opinion = directoryOpinion.getContents();
                            }
                            if (directoryOpinion != null) {
                                DirectoryOpinionExample example = new DirectoryOpinionExample();
                                DirectoryOpinionExample.Criteria criteria = example.createCriteria();
                                criteria.andProjectidEqualTo(projectId);
                                criteria.andDirectoryidEqualTo(pid);
                                criteria.andOpiniontypeEqualTo(DirectoryOpinionType.DFAFT.getCode());
                                directoryOpinionService.deleteByExample(example);
                            }
                            directoryOpinionService.saveOpinion(opinion, projectId, pid, userName, userId, model.getVersionhash(), DirectoryOpinionType.SUBMIT.getCode());
                        }
					}
				}else{	//如果和上一个循环中是同一个父节点，则不需再查

				}
				//变更当前目录节点
                if("dir".equals(type)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("projectid", projectId);
                    map.put("projectStage", projectStage);
                    map.put("processnode", targetProcessNodeInfo.getProcessnode());
                    List<String> currentDirectoryList = new ArrayList<>();
                    currentDirectoryList.add(id);
                    map.put("list", currentDirectoryList);
                    int success1 = projectDirectoryMapper.batchUpdateByPrimaryKey(map);
                    if (success1 <= 0) {
                        logger.error("变更当前目录节点实体错误{}");
                        throw new BaseException("变更当前目录节点实体错误");
                    }
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("projectid", projectId);
                    map1.put("projectStage", projectStage);
                    map1.put("processnode", targetProcessNodeInfo.getProcessnode());
                    List<String> directoryList = new ArrayList<>();
                    if (list.size() > 0) {
                        for (ProjectDirectoryTree temp1 : list) {
                            //延超更新接口后，此注释放开
                            if ("dir".equals(temp1.getType())) {
                                if (Integer.parseInt(temp1.getProcessnode()) < Integer.parseInt(targetProcessNodeInfo.getProcessnode())) {
                                    directoryList.add(temp1.getId());
                                }
                            }
                        }
                        if (directoryList.size() > 0) {
                            map1.put("list", directoryList);
                            int success2 = projectDirectoryMapper.batchUpdateByPrimaryKey(map1);
                            if (success2 <= 0) {
                                logger.error("变更所有子目录流程节点实体错误{}");
                                throw new BaseException("变更所有子目录流程节点实体错误");
                            }
                        }
                    }
                }
			}
			if("45".equals(targetProcessNodeInfo.getProcessnode())){	//当审议发起人发起审议时，自动创建会签流程实例，并将会签人员当做参数传入,目前暂时写死人员
				//启动流程
				HashMap<String, Object> map = new HashMap<>();
				//定义会签人员，此处后面可以根据角色来查询userid或其他
				map.put("assigneeList", (List)JSONObject.parseArray(countersignUserIds));
				//完成会签的人员，完成一个就+1
				map.put("signCount", 0);
				//审核发起人，此处后面可以根据角色来查询userid或其他
				map.put("projectid",projectId);
				map.put("projectstage",projectStage);
				map.put("internalAuditListener","internalAuditListener");
				ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Countersign", map);
				logger.info("提交成功\n流程实例id==：" + processInstance.getId()+"\n流程实例Name==" + processInstance.getName());
				//更新项目表
				ProjectInfo record = new ProjectInfo();
				record.setId(projectId);
				record.setProcessInstanceId(processInstance.getId());
				int success = projectInfoMapper.updateByPrimaryKeySelective(record);
				if (success <= 0) {
					logger.error("更新项目信息错误{}",  record.toString());
					throw new BaseException("更新项目信息错误");
				}
				//此处还需要直接调用权限平台接口配置会签人员权限
				List list = (List)JSONObject.parseArray(countersignUserIds);
				StringBuffer sb = new StringBuffer("");
				for(int i=0;i<list.size();i++){
					sb.append(list.get(i));
					if(i!=list.size()-1) {
						sb.append(",");
					}
				}
				this.saveDataItem(projectId,sb.toString(),internalReviewRoleId);
			}
		}else if(Integer.parseInt(processnode)>Integer.parseInt(targetProcessNodeInfo.getProcessnode())){	//逆向，目标流程节点小于当前流程节点
			//递归更新上级目录节点（如果上级目录节点比目标节点大），并递归变更下级目录节点（如果大于目标节点）。
			JSONObject jsonObject = null;
			String tempPid = "";
			for(int i=0;i<rootArray.size();i++){		//同级目录查询，上级目录查询
				jsonObject = rootArray.getJSONObject(i);
				String id = jsonObject.get("id").toString();
				//所有下一级节点，所在的流程必须大于当前节点
				//查询下级目录树
				List<ProjectDirectoryTree> list = projectDirectoryService.viewTree(projectId, projectStage, id);
				//遍历所有目录的流程
				if(list.size()>0){
					for (ProjectDirectoryTree projectDirectoryTree:list) {
						//此处如接口加入子目录流程节点，则不需要再调接口查询，直接使用下面代码即可
						String targetProcessNode = projectDirectoryTree.getProcessnode();
						//If .流程节点 > 当前流程节点 return err
						//只有类型为目录的时候才会去查节点，需要提供该字段
						if("dir".equals(projectDirectoryTree.getType())) {
							if (Integer.parseInt(targetProcessNode) > Integer.parseInt(processnode)) {
								logger.error("目录流程节点大于当前流程节点");
								throw new BaseException("目录流程节点大于当前流程节点");
							}
						}
					}
				}
				String opinion = jsonObject.get("opinion").toString();
                String hashname = "";
				if(jsonObject.get("hashname")!=null){
					hashname = jsonObject.get("hashname").toString();
				}
				String type = jsonObject.get("type").toString();
				if("dir".equals(type)){
					//提交意见，将意见内容insert一份正式的，并删除掉草稿
					directoryOpinionService.saveOpinion(opinion, projectId, id, userName, userId, hashname, DirectoryOpinionType.SUBMIT.getCode());
					DirectoryOpinion directoryOpinion = new DirectoryOpinion();
					directoryOpinion.setProjectid(projectId);
					directoryOpinion.setDirectoryid(id);
					directoryOpinion.setOpinionType(DirectoryOpinionType.DFAFT.getCode());
					directoryOpinion = directoryOpinionMapper.getDirectoryOpinion(directoryOpinion);
					if(directoryOpinion!=null){
						DirectoryOpinionExample example = new DirectoryOpinionExample();
						DirectoryOpinionExample.Criteria criteria = example.createCriteria();
						criteria.andProjectidEqualTo(projectId);
						criteria.andDirectoryidEqualTo(id);
						criteria.andOpiniontypeEqualTo(DirectoryOpinionType.DFAFT.getCode());
						directoryOpinionService.deleteByExample(example);
					}
				}
				String pid = "";
				//当pid为空时，该目录为父目录
				if(null!=jsonObject.get("pid")){
					pid = jsonObject.get("pid").toString();
				}
				//通过当前目录的父目录id获取父目录的节点
				String pProcessnode = "";
//				if(!tempPid.equals(pid) && !projectId.equals(pid)){	//如果父目录id临时变量和父目录id不同，则给父目录id临时变量重新赋值，并查询父目录的流程节点
//					tempPid = pid;
                if(!projectId.equals(pid)){	//如果父目录id不是项目id，并查询父目录的流程节点
                        //通过数据库查询，通过查询项目目录表（此处可以改成先获取dag中全部的pid，然后通过sql的in去查，然后再去结果集中获取，可以避免多次和数据库交互）
					ProjectDirectory queryCriteria = new ProjectDirectory();
					queryCriteria.setProjectid(projectId);
					queryCriteria.setDirectoryid(pid);
					ProjectDirectory projectDirectory = projectDirectoryMapper.selectByPrimaryKey(queryCriteria);
					pProcessnode = projectDirectory.getProcessnode();

					//父目录节点大于目标节点  并且  同级目录节点小于等于目标节点
					if(Integer.parseInt(pProcessnode)>Integer.parseInt(targetProcessNodeInfo.getProcessnode())){
						//更新上级目录流程节点
						ProjectDirectory model = new ProjectDirectory();
						model.setProjectid(projectId);
						model.setDirectoryid(pid);
						model.setProcessnode(targetProcessNodeInfo.getProcessnode());
						int success = projectDirectoryMapper.updateByPrimaryKeySelective(model);
						if (success <= 0) {
							logger.error("更新上级目录流程节点实体错误{}",  model.toString());
							throw new BaseException("更新上级目录流程节点实体错误");
						}
						//更新上级意见
                        if(!tempPid.equals(pid)) {
                            tempPid = pid;
                            DirectoryOpinion directoryOpinion = new DirectoryOpinion();
                            directoryOpinion.setProjectid(projectId);
                            directoryOpinion.setDirectoryid(pid);
                            directoryOpinion.setOpinionType(DirectoryOpinionType.DFAFT.getCode());
                            directoryOpinion = directoryOpinionMapper.getDirectoryOpinion(directoryOpinion);
                            String opinion1 = "";
                            if(directoryOpinion==null){
                                opinion1 = "不同意";
                            }else{
                                opinion1 = directoryOpinion.getContents();
                            }
                            if(directoryOpinion!=null){
                                DirectoryOpinionExample example = new DirectoryOpinionExample();
                                DirectoryOpinionExample.Criteria criteria = example.createCriteria();
                                criteria.andProjectidEqualTo(projectId);
                                criteria.andDirectoryidEqualTo(pid);
                                criteria.andOpiniontypeEqualTo(DirectoryOpinionType.DFAFT.getCode());
                                directoryOpinionService.deleteByExample(example);
                            }
                            directoryOpinionService.saveOpinion(opinion1, projectId, pid, userName, userId, model.getVersionhash(), DirectoryOpinionType.SUBMIT.getCode());
                        }
					}
				}else{	//如果和上一个循环中是同一个父节点，则不需再查

				}
				//变更当前目录节点
                if("dir".equals(type)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("projectid", projectId);
                    map.put("projectStage", projectStage);
                    map.put("processnode", targetProcessNodeInfo.getProcessnode());
                    List<String> currentDirectoryList = new ArrayList<>();
                    currentDirectoryList.add(id);
                    map.put("list", currentDirectoryList);
                    int success1 = projectDirectoryMapper.batchUpdateByPrimaryKey(map);
                    if (success1 <= 0) {
                        logger.error("变更当前目录节点实体错误{}");
                        throw new BaseException("变更当前目录节点实体错误");
                    }
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("projectid", projectId);
                    map1.put("projectStage", projectStage);
                    map1.put("processnode", targetProcessNodeInfo.getProcessnode());
                    List<String> directoryList = new ArrayList<>();
                    //递归变更所有子目录节点(如果子目录节点大于目标节点)
                    if (list.size() > 0) {
                        for (ProjectDirectoryTree temp1 : list) {
                            //延超更新接口后，此注释放开
                            if ("dir".equals(temp1.getType())) {
                                if (Integer.parseInt(temp1.getProcessnode()) > Integer.parseInt(targetProcessNodeInfo.getProcessnode())) {
                                    directoryList.add(temp1.getId());
                                }
                            }
                        }
                        if (directoryList.size() > 0) {
                            map1.put("list", directoryList);
                            int success2 = projectDirectoryMapper.batchUpdateByPrimaryKey(map1);
                            if (success2 <= 0) {
                                logger.error("变更所有子目录流程节点实体错误{}");
                                throw new BaseException("变更所有子目录流程节点实体错误");
                            }
                        }
                    }
                }
			}
		}
		return "";
	}

	/**
	 * 更新阶段
	 * @param projectId
	 * @param projectStage
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void updateStage(String projectId, String projectStage) throws BaseException {
		//根据项目id变更到下一项目阶段
		//具体逻辑
		//1.根据当前项目阶段，项目类型，查询下一项目阶段
		ProjectInfo projectinfo = projectInfoMapper.selectByPrimaryKey(projectId);
//		ProjectStageInfo projectStageInfo =
		ProjectStageInfoExample example = new ProjectStageInfoExample();
		com.company.projectstageinfo.model.ProjectStageInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(projectinfo.getProjecttype());
		criteria.andProjectstageGreaterThan(projectStage);
		ProjectStageInfo projectStageInfo = projectStageInfoMapper.getNextStageinfoByExample(example);
		logger.info(projectStageInfo.getProjectstage());
		//2.将流程重置为项目组录入11 ，这步应该不用，目录已经在后面节点的，那就不动了
		//3.变更项目信息表的项目阶段
		projectinfo.setStage(projectStageInfo.getProjectstage());
		projectInfoMapper.updateByPrimaryKeySelective(projectinfo);


	}

	/**
	 * 添加用户角色数据权限
	 * @param projectId
	 * @param userId
	 * @param roleId
	 * @throws BaseException
	 */
	public void saveDataItem(String projectId, String userId, String roleId) throws BaseException {
		try {
			ProjectInfo info = new ProjectInfo();
			info.setId(projectId);
			info.setUserId(userId);
			info.setRoleList(roleId);
			projectInfoService.saveDataRole(info);
		} catch (Exception e) {
			logger.error("添加用户角色数据权限错误信息：", e);
			throw new BaseException("添加用户角色数据权限错误信息");
		}
	}

	public static void main(String[] args) {
		//入参需要有项目类型
		File file = new File("D:/mulu.txt");
		StringBuilder result = new StringBuilder();
		String level1name = "";
		String level1id = "";
		String level2name = "";
		String level2id = "";
		String level3name = "";
		String level3id = "";
		String level4name = "";
		String level4id = "";
		String parentid = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
				/*
					首先需要
				 */
//				result.append(System.lineSeparator() + s);
				if(s.contains("第") && s.contains("部分")){
					String ss[] = s.split("　");
					System.out.println(ss[0]+ "====" +ss[1]);
					level1name = s;
					level1id = UUID.randomUUID().toString().replace("-","");
			}
				if(s.contains("第") && s.contains("章")){
					String ss[] = s.split("　");
					System.out.println(ss[0]+ "----" +ss[1]);
				}
				if(s.contains("-")){
					String ss[] = s.split("-");
					System.out.println(ss.length);
					for(String sss:ss){
						System.out.println(sss);
					}
				}
			}
			br.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}