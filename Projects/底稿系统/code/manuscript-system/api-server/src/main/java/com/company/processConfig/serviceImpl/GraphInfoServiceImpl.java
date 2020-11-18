package com.company.processConfig.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.base.exception.BaseException;
import com.company.enums.ProcessNodeOpt;
import com.company.enums.ProcessNodeStatus;
import com.company.enums.ProcessNodeType;
import com.company.processConfig.dao.ProcessInfoMapper;
import com.company.processConfig.dao.ProcessStageInfoMapper;
import com.company.processConfig.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.processConfig.service.GraphInfoService;
import com.company.processConfig.dao.GraphInfoMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GraphInfoServiceImpl extends BaseServiceImpl<GraphInfo, GraphInfoExample> implements GraphInfoService<GraphInfo, GraphInfoExample>{

    @Autowired
    private GraphInfoMapper mapper;

	@Autowired
	private ProcessInfoMapper processInfoMapper;

	@Autowired
	private ProcessStageInfoMapper processStageInfoMapper;
	
	public IBaseDao<GraphInfo, GraphInfoExample> getMapper(){
		return mapper;
	}
	/**
	 * 保存流程与阶段信息
	 * @param processInfo        流程信息
	 * @param processStageInfo   流程阶段信息
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveProcessInfo(ProcessInfo processInfo , ProcessStageInfo processStageInfo) throws BaseException {
		int success = processInfoMapper.insertSelective(processInfo);
		if (success <= 0) {
			logger.error("新增流程信息错误{}",  processInfo.toString());
			throw new BaseException("新增流程信息错误");
		}
		processStageInfo.setProcessid(processInfo.getProcessid());
		int success1 = processStageInfoMapper.insertSelective(processStageInfo);
		if (success1 <= 0) {
			logger.error("新增流程阶段信息错误{}",  processInfo.toString());
			throw new BaseException("新增流程阶段信息错误");
		}
		return;
	}

	/**
	 * 删除流程与阶段信息
	 * @param processStageInfo   流程阶段信息
	 * @throws BaseException
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void delProcessInfo(ProcessStageInfo processStageInfo) throws BaseException {
		ProcessStageInfoExample example = new ProcessStageInfoExample();
		ProcessStageInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(processStageInfo.getProjecttype());
		criteria.andProjectstageEqualTo(processStageInfo.getProjectstage());
		List<ProcessStageInfo> list = processStageInfoMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			//删除流程阶段信息
			int success = processStageInfoMapper.deleteByExample(example);
			if (success <= 0) {
				logger.error("删除流程阶段信息错误{}",  processStageInfo.toString());
				throw new BaseException("删除流程阶段信息错误");
			}
			ProcessInfoExample piExample = new ProcessInfoExample();
			ProcessInfoExample.Criteria piCriteria = piExample.createCriteria();
			List<String> idsList = new ArrayList<String>();
			for(ProcessStageInfo psi : list){
				idsList.add(psi.getProcessid());
			}
			piCriteria.andProcessidIn(idsList);
			//删除流程信息
			int success1 = processInfoMapper.deleteByExample(piExample);
			if (success1 <= 0) {
				logger.error("删除流程信息错误{}{}",  idsList.toString(), list.toString());
				throw new BaseException("删除流程信息错误");
			}
		}
		return;
	}

	/**
	 * 保存图像信息
	 * @throws BaseException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=BaseException.class)
	public void saveGraphInfo(GraphInfo record) throws BaseException {
		//图像信息ID
		String graphId = null;
		//项目类型ID
		String projecttype = record.getProjecttype();
		//项目阶段值
		String projectstage = record.getProjectstage();
		//图像JSON数据
		String graphdata = record.getGraphdata();
		if(graphdata == null || graphdata.length() == 0){
			throw new BaseException("图像JSON数据(graphdata)为空。");
		}
		//解析图像JSON数据(graphdata)为对象
		JSONObject graphdJsonData = null;
		try{
			graphdJsonData = JSONObject.parseObject(graphdata);
		} catch (Exception e){
			throw new BaseException("图像JSON数据解析失败。");
		}
		//节点集合(nodes)
		JSONArray nodes = null;
		try{
			nodes = graphdJsonData.getJSONArray("nodes");
		} catch (Exception e){
			throw new BaseException("图像JSON数据获取节点集合(nodes)失败。");
		}
		if(nodes.size() == 0){
			throw new BaseException("节点集合(nodes)为空。");
		}
		//线集合(edges)
		JSONArray edges = null;
		try{
			edges = graphdJsonData.getJSONArray("edges");
		} catch (Exception e){
			throw new BaseException("图像JSON数据获取线集合(edges)失败。");
		}
		if(edges.size() == 0){
			throw new BaseException("线集合(edges)为空。");
		}

		GraphInfoExample example = new GraphInfoExample();
		GraphInfoExample.Criteria criteria = example.createCriteria();
		criteria.andProjecttypeEqualTo(projecttype);
		criteria.andProjectstageEqualTo(projectstage);
		List<GraphInfo> graphInfoList = getMapper().selectByExample(example);
		GraphInfo graphInfo = new GraphInfo();
		if(graphInfoList != null && graphInfoList.size() > 0){
			graphInfo = graphInfoList.get(0);
			record.setId(graphInfo.getId());
			//根据项目类型ID和项目阶段更新图像信息
			int success = getMapper().updateByPrimaryKeySelective(record);
			if (success <= 0) {
				logger.error("更新图像信息错误{}",  record.toString());
				throw new BaseException("更新图像信息错误");
			}
		} else {
			//没有数据 则新增数据
			graphInfo.setProjecttype(projecttype);
			graphInfo.setProjectstage(projectstage);
			graphInfo.setGraphdata(graphdata);
			//新增图像信息
			int success = getMapper().insert(graphInfo);
			if (success <= 0) {
				logger.error("新增图像信息错误{}",  graphInfo.toString());
				throw new BaseException("新增图像信息错误");
			}
		}
		graphId = graphInfo.getId();
		//流程阶段信息
		ProcessStageInfo processStageInfo = new ProcessStageInfo();
		processStageInfo.setProjecttype(projecttype);
		processStageInfo.setProjectstage(projectstage);
		processStageInfo.setGraphid(graphId);
		//删除流程与阶段信息
		try{
			this.delProcessInfo(processStageInfo);
		} catch (BaseException e){
			logger.error("删除流程与阶段信息错误{}",  processStageInfo.toString());
			throw new BaseException("删除流程与阶段信息错误");
		}


		/**
		 * 1、遍历节点集合(nodes)找出结束节点 该节点的状态码为9 开始、普通节点的默认状态码为1
		 *     得出节点对应各个状态码的集合(nodeStateMapping)Map<String, List<String>> ==>> {"1":["11"],"2":["21"],"3":["31"],"4":["41"]}
		 */
		//节点对应各个状态码集合
		Map<String, List<String>> nodeStateMapping = new HashMap<String, List<String>>();
		for( int i = 0 ; i < nodes.size() ; i++ ) {
			JSONObject node = nodes.getJSONObject(i);
			String nodeId = node.getString("id");
			String nodeVal = nodeId.substring(4);
			//节点类型
			String changeNodeType = node.getString("changeNodeType");
			List<String> valList = new ArrayList<String>();
			if(ProcessNodeType.END.getCode().equals(changeNodeType)){
				//结束节点
				String startprocessnode = nodeVal+ProcessNodeStatus.DEFAULT.getCode();
				String endprocessnode = nodeVal+ProcessNodeStatus.END.getCode();
				valList.add(startprocessnode);
//				valList.add(endprocessnode);
				ProcessInfo processInfo = new ProcessInfo();
				processInfo.setStartprocessnode(startprocessnode);
				processInfo.setEndprocessnode(endprocessnode);
				processInfo.setOperid(ProcessNodeOpt.OBVERSE.getCode());
				//保存流程与阶段信息
				try{
					this.saveProcessInfo(processInfo, processStageInfo);
				} catch (BaseException e){
					logger.error("保存流程与阶段信息错误{}{}",  processInfo.toString(), processStageInfo.toString());
					throw new BaseException("保存流程与阶段信息错误");
				}
				//变更节点
				String startprocessnode1 = endprocessnode;
				String endprocessnode1 = "31";
				ProcessInfo processInfo1 = new ProcessInfo();
				processInfo1.setStartprocessnode(startprocessnode1);
				processInfo1.setEndprocessnode(endprocessnode1);
				processInfo1.setOperid(ProcessNodeOpt.CHANGE.getCode());
				//保存流程与阶段信息
				try{
					this.saveProcessInfo(processInfo1, processStageInfo);
				} catch (BaseException e){
					logger.error("保存流程与阶段信息错误{}{}",  processInfo.toString(), processStageInfo.toString());
					throw new BaseException("保存流程与阶段信息错误");
				}
			} else {
				//其他节点
				valList.add(nodeVal+ProcessNodeStatus.DEFAULT.getCode());
			}
			nodeStateMapping.put(nodeVal, valList);
		}

		/**
		 * 2、遍历线集合(edges)找出逆流向(inverseEdges)List<Map<String, String>>==>>[{"3":"2"},{"2":"1"},{"3":"1"}]与正流向线(obverseEdges)List<Map<String, String>>==>>[{"1":"2"},{"2":"3"},{"3":"4"}]集合 确定所有节点上的所有状态码
		 *     状态码原则：一、默认为1；二、结束节点为1和9；三、大值节点位(2)逆流向到小值节点位(1)那么小值节点就会新增状态码(12=默认码11+(大值节点位(2)-小值节点位(1)))
		 *     得出节点对应各个状态码的集合(nodeStateMapping)Map<String, List<String>> ==>> {"1":["11","12","13"],"2":["21","22"],"3":["31"],"4":["49"]}
		 */
		//正流向线集合
		List<Map<String, String>> obverseEdges = new ArrayList<Map<String, String>>();
		//逆流向线集合
		List<Map<String, String>> inverseEdges = new ArrayList<Map<String, String>>();
		for( int i = 0 ; i < edges.size() ; i++ ) {
			JSONObject edge = edges.getJSONObject(i);
			String sourceId = edge.getString("sourceId");
			String targetId = edge.getString("targetId");
			String sourceIdVal = sourceId.substring(4);
			String targetIdVal = targetId.substring(4);
			Integer sourceIdIntVal = Integer.parseInt(sourceIdVal);
			Integer targetIdIntVal = Integer.parseInt(targetIdVal);
			Map<String, String> map = new HashMap<String, String>();
			map.put(sourceIdVal, targetIdVal);
			if(sourceIdIntVal < targetIdIntVal){
				//正流向
				obverseEdges.add(map);
			} else {
				//逆流向
				List<String> valList = nodeStateMapping.get(targetIdVal);
				valList.add(targetIdVal+(1+(sourceIdIntVal-targetIdIntVal)));
				inverseEdges.add(map);
			}
		}

		/**
		 * 3、遍历正流向线(obverseEdges)集合 key值通过nodeMappingStateList获取状态码值与value值取默认值对应关系 保存流程与阶段信息
		 */
		//遍历正流向线(obverseEdges)集合
		for(Map<String, String> obverseEdge : obverseEdges){
			for(Map.Entry<String, String> obverseEdgeEntry : obverseEdge.entrySet()){
				String sourceIdVal = obverseEdgeEntry.getKey();
				List<String> startValList = nodeStateMapping.get(sourceIdVal);
				String targetIdVal = obverseEdgeEntry.getValue();
				List<String> endValList = nodeStateMapping.get(targetIdVal);
				//终点流程节点
				String endprocessnode = endValList.get(0);
				for(String startprocessnode : startValList){
					ProcessInfo processInfo = new ProcessInfo();
					processInfo.setStartprocessnode(startprocessnode);
					processInfo.setEndprocessnode(endprocessnode);
					processInfo.setOperid(ProcessNodeOpt.OBVERSE.getCode());
					//保存流程与阶段信息
					try{
						this.saveProcessInfo(processInfo, processStageInfo);
					} catch (BaseException e){
						logger.error("保存流程与阶段信息错误{}{}",  processInfo.toString(), processStageInfo.toString());
						throw new BaseException("保存流程与阶段信息错误");
					}
				}
			}
		}
		/**
		 * 4、遍历逆流向线(inverseEdges)集合 key值通过nodeMappingStateList获取状态码值与value值根据状态码原则第三条获取值对应关系 保存流程与阶段信息
		 */
		//遍历逆流向线(inverseEdges)集合
		for(Map<String, String> inverseEdge : inverseEdges){
			for(Map.Entry<String, String> inverseEdgeEntry : inverseEdge.entrySet()){
				String sourceIdVal = inverseEdgeEntry.getKey();
				List<String> startValList = nodeStateMapping.get(sourceIdVal);
				String targetIdVal = inverseEdgeEntry.getValue();
				Integer sourceIdIntVal = Integer.parseInt(sourceIdVal);
				Integer targetIdIntVal = Integer.parseInt(targetIdVal);
				for(String startprocessnode : startValList){
					ProcessInfo processInfo = new ProcessInfo();
					processInfo.setStartprocessnode(startprocessnode);
					processInfo.setEndprocessnode(targetIdVal+(1+(sourceIdIntVal-targetIdIntVal)));
					processInfo.setOperid(ProcessNodeOpt.INVERSE.getCode());
					//保存流程与阶段信息
					try{
						this.saveProcessInfo(processInfo, processStageInfo);
					} catch (BaseException e){
						logger.error("保存流程与阶段信息错误{}{}",  processInfo.toString(), processStageInfo.toString());
						throw new BaseException("保存流程与阶段信息错误");
					}
				}
			}
		}
		return;
	}
}