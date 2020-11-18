package com.company.dictionarys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataListModel;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.constant.BaseConstant;
import com.company.dictionarys.model.DictionaryTab;
import com.company.dictionarys.model.DictionaryTabExample;
import com.company.dictionarys.model.DictionaryTabExample.Criteria;
import com.company.dictionarys.service.DictionaryTabService;
import com.company.utils.ListUtil;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 	字典
 * Controller类
 *
 */
@Api(value="字典数据维护",tags={"字典数据操作接口"})
@RestController("DictionaryTabController")
@RequestMapping("/api/DictionaryTab")
public class DictionaryTabController {

    public static Logger logger = LoggerFactory.getLogger(DictionaryTabController.class);

    @Autowired
    private DictionaryTabService<DictionaryTab, DictionaryTabExample> service;
    
    /**
	 * 	根据字典key查询字典值
	 */
	@ApiOperation("根据字典key查询字典值")
    @PostMapping(value = "/getDictionaryByKey", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<String> getDictionaryByKey(
    	@RequestParam(required = true) @ApiParam(name="dicKey",value="字典key",required=true) String dicKey
    	) {
		ResponseDataModel<String> responseModel = new ResponseDataModel<>();
        try {
        	String entity = service.getDictionaryByKey(dicKey);
            responseModel.setSuccess(true);
            responseModel.setEntity(entity);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("详情查询成功");
        return responseModel;
    }
    
    /**
	 * 	根据字典key查询下面字典列表
	 */
	@ApiOperation("根据字典key查询下面字典列表")
    @PostMapping(value = "/getDictionarysByKey", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<DictionaryTab> getDictionarysByKey(
    	@RequestParam(required = true) @ApiParam(name="dicKey",value="字典key",required=true) String dicKey
    	) {
		ResponseDataListModel<DictionaryTab> responseModel = new ResponseDataListModel<>();
        try {
            List<DictionaryTab> list = service.getDictionarysByKey(dicKey);
            responseModel.setSuccess(true);
            responseModel.setList(list);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("详情查询成功");
        return responseModel;
    }
    
    /**
	 * 	字典查询详情
	 */
	@ApiOperation("字典信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DictionaryTab> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) Long id
    	) {
        ResponseDataModel<DictionaryTab> responseModel = new ResponseDataModel<>();
        try {
        	DictionaryTab entity = service.get(id);
            responseModel.setSuccess(true);
            responseModel.setEntity(entity);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("详情查询成功");
        return responseModel;
    }
    
	/**
	 * 	字典分页查询
	 */
	@ApiOperation("分页查询字典数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<DictionaryTab> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="dicKey",value="类型",required=false) String dicKey, 
    		@RequestParam(required = false) @ApiParam(name="dicValue",value="名称",required=false) String dicValue
    	)  throws BaseException{
		logger.info("currentPage:{},itemsPerPage:{},dicKey:{},dicValue:{}",
        		currentPage, itemsPerPage, dicKey, dicValue);
        ResponseDataPageListForBootModel<DictionaryTab> responseModel = new ResponseDataPageListForBootModel<DictionaryTab>();
        try {
        	HashMap<String, Object> paramMap = new HashMap<>();
            //按排序字段 查询
            paramMap.put("orderby", "dic_sort");
            DictionaryTabExample example = new DictionaryTabExample();
            example.setOrderByClause((String)paramMap.get("orderby"));
            Criteria criteria = example.createCriteria();
            //状态为正常
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            //组ID为-1
            criteria.andDicGroupIdEqualTo(-1L);
            //若类型不为空
            if (!StringUtils.isEmpty(dicKey)) {
            	criteria.andDicKeyLike(dicKey+"%");
            }
            //若名称不为空
            if (!StringUtils.isEmpty(dicValue)) {
            	criteria.andDicValueLike(dicValue+"%");
            }
        	PageInfo<DictionaryTab> page = service.getListByPage(currentPage, itemsPerPage, example);
        	if(page != null && page.getList() != null && page.getList().size() > 0) {
        		for(DictionaryTab model : page.getList()) {
        			Long id = model.getId();
        			DictionaryTabExample example1 = new DictionaryTabExample();
        			Criteria criteria1 = example1.createCriteria();
        			criteria1.andDicGroupIdEqualTo(id);
        			criteria1.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
        			List<DictionaryTab> subList = service.getList(example1);
        			model.setSubList(subList);
        		}
        	}
        	responseModel.setSuccess(true);
        	responseModel.setPageIndex(currentPage);
        	responseModel.setPageSize(itemsPerPage);
        	responseModel.setRecordsTotal(page.getTotal());
        	responseModel.setData(page.getList());
        	responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
        	responseModel.setMessage("分页查询成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			responseModel.setSuccess(false);
            responseModel.setMessage("失败:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
		}
        return responseModel;
    }
    
	/**
	 * 	字典添加数据
	 */
	@ApiOperation("添加字典数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DictionaryTab> add(@RequestBody @ApiParam(name="字典对象",value="传入json格式",required=true) DictionaryTab model,HttpServletRequest request) {
        ResponseDataModel<DictionaryTab> responseModel = new ResponseDataModel<DictionaryTab>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	DictionaryTab record = new DictionaryTab();
            BeanUtils.copyProperties(model, record);
            //分组id
            if(record != null && record.getDicGroupId() == null) {
            	record.setDicGroupId(-1L);
            }
            //状态为正常
            record.setIsDelete(BaseConstant.DEL_FLAG_NO);
            //查看该分组下的条数
            DictionaryTabExample example = new DictionaryTabExample();
            Criteria criteria = example.createCriteria();
            criteria.andDicGroupIdEqualTo(record.getDicGroupId());
            Long count = service.countByExample(example);
            //设置排序字段
            record.setDicSort(count.intValue()+1);
            record.setCreateTime(new Date());
            record.setCreateUser(currUserId);
            service.save(record);
            responseModel.setEntity(record);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("添加成功");
        return responseModel;
    }
    
	/**
	 * 	字典修改数据
	 */
	@ApiOperation("修改字典数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DictionaryTab> update(@RequestBody @ApiParam(name="字典对象",value="传入json格式",required=true) DictionaryTab model,HttpServletRequest request) {
        ResponseDataModel<DictionaryTab> responseModel = new ResponseDataModel<DictionaryTab>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	DictionaryTab record = new DictionaryTab();
            BeanUtils.copyProperties(model, record);
            record.setUpdateTime(new Date());
            record.setUpdateUser(currUserId);
            service.update(record);
            responseModel.setEntity(record);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("编辑成功");
        return responseModel;
    }
	
	/**
	 *	 字典删除数据
	 */
	@ApiOperation("删除字典数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) Long id
    	) {
        ResponseModel responseModel = new ResponseModel();
        try {
            service.deleteByPrimaryKey(id);
        } catch (Exception e) {
        	responseModel.setSuccess(false);
        	responseModel.setMessage("Fail:" + e.getMessage());
        	responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("删除成功");
        return responseModel;
    }
    
    /**
	 * 	字典批量删除数据
	 */
	@ApiOperation("批量删除字典数据")
    @PostMapping(value = "/batchDel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel batchDel(
    		@ApiParam(name="主键列表",value="传入json格式",required=false)String param
    	) {
        ResponseModel responseModel = new ResponseModel();
        try {
        	List<Map<String, Object>> list = ListUtil.toListMap(param);
        	if(list == null || list.size() == 0) {
        		throw new BaseException("传入参数list为空");
        	}
            service.batchDeleteByPrimaryKey(list);
            
        } catch (Exception e) {
        	responseModel.setSuccess(false);
        	responseModel.setMessage("Fail:" + e.getMessage());
        	responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("删除成功");
        return responseModel;
    }

}