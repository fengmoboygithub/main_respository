package com.company.processConfig.serviceImpl;

import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.processConfig.dao.StageInfoMapper;
import com.company.processConfig.model.StageInfo;
import com.company.processConfig.model.StageInfoExample;
import com.company.processConfig.service.StageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StageInfoServiceImpl extends BaseServiceImpl<StageInfo, StageInfoExample> implements StageInfoService<StageInfo, StageInfoExample>{

    @Autowired
    private StageInfoMapper mapper;
	
	public IBaseDao<StageInfo, StageInfoExample> getMapper(){
		return mapper;
	}

	/**
	 * 	根据projecttype查询相关的流程信息
	 */
	public List<StageInfo> getListByType(StageInfoExample example) throws BaseException {

		List<StageInfo> list = null;
		try {
			list = getMapper().selectByExample(example);
		} catch (Exception e) {
			logger.error("查询失败!原因是:",e);
			throw new BaseException("查询失败");
		}
		return list;

	}
}