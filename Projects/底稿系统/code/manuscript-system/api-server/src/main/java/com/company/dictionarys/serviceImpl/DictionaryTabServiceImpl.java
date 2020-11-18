package com.company.dictionarys.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.base.dao.IBaseDao;
import com.company.base.exception.BaseException;
import com.company.base.service.BaseServiceImpl;
import com.company.constant.BaseConstant;
import com.company.dictionarys.dao.DictionaryTabMapper;
import com.company.dictionarys.model.DictionaryTab;
import com.company.dictionarys.model.DictionaryTabExample;
import com.company.dictionarys.model.DictionaryTabExample.Criteria;
import com.company.dictionarys.service.DictionaryTabService;

@Service
public class DictionaryTabServiceImpl extends BaseServiceImpl<DictionaryTab, DictionaryTabExample> implements DictionaryTabService<DictionaryTab, DictionaryTabExample>{

    @Autowired
    private DictionaryTabMapper mapper;
	
	public IBaseDao<DictionaryTab, DictionaryTabExample> getMapper(){
		return mapper;
	}
	
	@Override
	public void deleteByPrimaryKey(Long id) throws BaseException {
		int success = mapper.deleteByPrimaryKey(id);
        if (success <= 0) {
            logger.error("根据主键删除实体错误{}", id);
            throw new RuntimeException("删除实体错误");
        } else {
        	//删除下级字典信息
        	DictionaryTabExample example = new DictionaryTabExample();
            Criteria criteria = example.createCriteria();
            criteria.andDicGroupIdEqualTo(id);
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            long count = mapper.countByExample(example);
            if(count > 0) {
	            int subSuccess = mapper.deleteByExample(example);
	            if (subSuccess <= 0) {
	                logger.error("根据主键删除下级实体错误{}", id);
	                throw new RuntimeException("删除下级实体错误");
	            } 
            }
        }
        return;
	}
	
	@Override
	public void batchDeleteByPrimaryKey(List<Map<String, Object>> keyList) throws BaseException {
		int success = mapper.batchDeleteByPrimaryKey(keyList);
        if (success <= 0) {
            logger.error("批量删除实体错误{}", keyList);
            throw new RuntimeException("批量删除实体错误");
        } else {
        	for(Map<String, Object> map : keyList) {
        		Long id = (Long)map.get("id");
        		//删除下级字典信息
            	DictionaryTabExample example = new DictionaryTabExample();
                Criteria criteria = example.createCriteria();
                criteria.andDicGroupIdEqualTo(id);
                criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
                long count = mapper.countByExample(example);
                if(count > 0) {
                	int subSuccess = mapper.deleteByExample(example);
                    if (subSuccess <= 0) {
                        logger.error("根据主键删除下级实体错误{}", id);
                        throw new RuntimeException("删除下级实体错误");
                    } 
                }
        	}
        }
        return;
	}

	@Override
	public List<DictionaryTab> getDictionarysByKey(String dicKey) throws BaseException{
		DictionaryTabExample example = new DictionaryTabExample();
        Criteria criteria = example.createCriteria();
        criteria.andDicKeyEqualTo(dicKey);
        criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
        List<DictionaryTab> queryList = mapper.selectByExample(example);
        if(queryList == null || queryList.size() == 0) {
        	logger.error("Fail:根据dicKey查询的数据为空。");
        	throw new BaseException("Fail:根据dicKey查询的数据为空。");
        }
        Long id = queryList.get(0).getId();
        DictionaryTabExample example1 = new DictionaryTabExample();
        Criteria criteria1 = example1.createCriteria();
        criteria1.andDicGroupIdEqualTo(id.longValue());
        criteria1.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
        return mapper.selectByExample(example1);
	}

	@Override
	public String getDictionaryByKey(String dicKey) throws BaseException {
		DictionaryTabExample example = new DictionaryTabExample();
        Criteria criteria = example.createCriteria();
        criteria.andDicKeyEqualTo(dicKey);
        criteria.andDicGroupIdEqualTo(-1L);
        criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
        List<DictionaryTab> queryList = mapper.selectByExample(example);
        if(queryList == null || queryList.size() == 0) {
        	logger.error("Fail:根据dicKey查询的数据为空。");
        	throw new BaseException("Fail:根据dicKey查询的数据为空。");
        }
        return queryList.get(0).getDicValue();
	}
}