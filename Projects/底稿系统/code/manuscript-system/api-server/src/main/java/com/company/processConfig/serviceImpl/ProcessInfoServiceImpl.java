package com.company.processConfig.serviceImpl;

import com.company.base.dao.IBaseDao;
import com.company.base.service.BaseServiceImpl;
import com.company.processConfig.dao.ProcessInfoMapper;
import com.company.processConfig.dao.ProcessStageInfoMapper;
import com.company.processConfig.model.*;
import com.company.processConfig.model.ProcessInfoExample.Criteria;
import com.company.processConfig.service.ProcessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProcessInfoServiceImpl extends BaseServiceImpl<ProcessInfo, ProcessInfoExample> implements ProcessInfoService<ProcessInfo, ProcessInfoExample>{

    @Autowired
    private ProcessInfoMapper processInfoMapper;
    
    @Autowired
    private ProcessStageInfoMapper processStageInfoMapper;

	public IBaseDao<ProcessInfo, ProcessInfoExample> getMapper(){
		return processInfoMapper;
	}
	@Override
	public void saveProcessList(List<Map<String, String>> list,List<Map<String, String>> dellist) {
		if (!StringUtils.isEmpty(dellist) && dellist.size() >0) {
			for (Map<String, String> delmap : dellist) {
				// 如果没有id的，那说明是新增了又删除的无用数据，无须处理
				if (!StringUtils.isEmpty(delmap.get("property1"))) {
					ProcessStageInfoExample delStage1 = new ProcessStageInfoExample();
					com.company.processConfig.model.ProcessStageInfoExample.Criteria delCri1 = delStage1.createCriteria();
					delCri1.andProcessidEqualTo(delmap.get("property1"));
					delCri1.andProjecttypeEqualTo(delmap.get("property2"));
					delCri1.andProjectstageEqualTo(delmap.get("property3"));
					processStageInfoMapper.deleteByExample(delStage1);
				}
			}
		}
		
		
		
		if (!StringUtils.isEmpty(list) && list.size()>0) {
			for (Map<String, String> map : list) {
				/**
				 * 对于保存操作的逻辑：
				 * 		无论过来的数据property1（id）是否为空
				 * 		以下操作都要先去查询processinfo是否存在在流程
				 * 		存在 => 新增关联关系。
				 * 		不存在=> processstage新增流程，并且新增关联关系
				 *
				 * 但是有种特殊情况
				 * 		有id的数据变了，隐藏着删除原数据的操作，所以对此进行一下特殊处理：在关联表中取消关联此id
				 * 		这样，执行上述操作只需要考虑新增关联关系即可。
				 * 
				 * 考虑到整体操作，为了能在同一事务下工作，删除的操作也在此进行
				 */
				// id不为空，先取消关联关系
				if (!StringUtils.isEmpty(map.get("property1"))) {
					ProcessStageInfoExample delStage = new ProcessStageInfoExample();
					com.company.processConfig.model.ProcessStageInfoExample.Criteria delCri = delStage.createCriteria();
					delCri.andProcessidEqualTo(map.get("property1"));
					delCri.andProjecttypeEqualTo(map.get("property2"));
					delCri.andProjectstageEqualTo(map.get("property3"));
					processStageInfoMapper.deleteByExample(delStage);
				}
				ProcessStageInfo processStageInfo = new ProcessStageInfo();
				// 先检查新增的关系是否存在于库中，存在修改关联关系，不存在则新增
				ProcessInfoExample processInfoExample = new ProcessInfoExample();
				Criteria cri = processInfoExample.createCriteria();
				cri.andStartprocessnodeEqualTo(map.get("property4"));
				cri.andEndprocessnodeEqualTo(map.get("property5"));
				cri.andOperidEqualTo(map.get("property6"));
				List<ProcessInfo> processinfoResult = processInfoMapper.selectByExample(processInfoExample);
				// 存在则将这一条数据做关联，而且必然只有一条
				if (processinfoResult.size() > 0) {
					// 修改关联关系表
					ProcessInfo proinfo = processinfoResult.get(0);
					// 新增关联关系，且只能为新增
					processStageInfo.setProjecttype(map.get("property2"));
					processStageInfo.setProjectstage(map.get("property3"));
					processStageInfo.setProcessid(proinfo.getProcessid());
					processStageInfoMapper.insert(processStageInfo);
				}else {
					String uuid = UUID.randomUUID().toString().replace("-","");
					// 否则新增两张表
					ProcessInfo processInfo = new ProcessInfo();
					processInfo.setProcessid(uuid);
					processInfo.setStartprocessnode(map.get("property4"));
					processInfo.setEndprocessnode(map.get("property5"));
					processInfo.setOperid(map.get("property6"));
					processInfoMapper.insert(processInfo);
					
					
					processStageInfo.setProjecttype(map.get("property2"));
					processStageInfo.setProjectstage(map.get("property3"));
					processStageInfo.setProcessid(uuid);
					processStageInfoMapper.insert(processStageInfo);
				}
			
			}
		}
	}
	
	

}