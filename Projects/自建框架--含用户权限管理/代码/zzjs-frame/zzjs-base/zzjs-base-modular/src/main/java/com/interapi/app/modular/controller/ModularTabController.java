package com.interapi.app.modular.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.interapi.app.annotation.ResourceMapping;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.base.model.BaseOption;
import com.interapi.app.bean.ResponseDataListModel;
import com.interapi.app.bean.ResponseDataModel;
import com.interapi.app.bean.ResponseDataPageListForBootModel;
import com.interapi.app.bean.ResponseModel;
import com.interapi.app.enums.ExampleTypeEnum;
import com.interapi.app.modular.model.ModularTab;
import com.interapi.app.modular.model.ModularTabExample;
import com.interapi.app.modular.model.ModularTabExample.Criteria;
import com.interapi.app.modular.service.ModularTabService;

@RestController("ModularTabController")
@RequestMapping("/api/ModularTab")
@ResourceMapping(code = "ModularTab", name = "模块_模块", tableName = "modular_tab", menuName = "模块管理",
roleName = "模块_页面", roleFlag = "ROLE_ModularTab_PAGE", homePage = "/pages/ModularTab",
pageSort = "1", menuSort = "1")
public class ModularTabController {

    public static Logger logger = LoggerFactory.getLogger(ModularTabController.class);

    @Autowired
    private ModularTabService<ModularTab, ModularTabExample> service;
	
	@Secured("ROLE_ModularTab_QUERY_DETAIL")
	@Cacheable(value = "ModularTab")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/get", roleName = "模块_查询_详情", 
					roleFlag = "ROLE_ModularTab_QUERY_DETAIL")
    public ResponseDataModel<ModularTab> get(Long id) {
        ResponseDataModel<ModularTab> responseModel = new ResponseDataModel<>();
        try {
            ModularTab entity=service.get(id);
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
	
	@Secured("ROLE_ModularTab_QUERY_PAGE")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/ModularTab/getListByPage", roleName = "模块_查询_分页", 
					roleFlag = "ROLE_ModularTab_QUERY_PAGE")
    public ResponseDataPageListForBootModel<ModularTab> getListByPage(
    		@RequestParam(required = false) int currentPage, 
    		@RequestParam(required = false) int itemsPerPage,
    		@RequestParam(required = false) String param
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListForBootModel<ModularTab> responseModel = new ResponseDataPageListForBootModel<ModularTab>();
        HashMap<String, Object> paramMap = new HashMap<>();
        if (!StringUtils.isEmpty(param)) {
            try {
                paramMap = new ObjectMapper().readValue(param, HashMap.class);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
            if(StringUtils.isEmpty((String)paramMap.get("orderby"))){
            	paramMap.put("orderby","id desc");
            }
        }else{
            paramMap.put("orderby","id desc");
        }
        ModularTabExample example = new ModularTabExample();
        example.setOrderByClause((String)paramMap.get("orderby"));
        Criteria criteria = example.createCriteria();
        try {
        	for(Entry<String, Object> entry : paramMap.entrySet()){
        		if(!entry.getKey().equals("orderby")){
        			String keyStr = entry.getKey();
					//and属性名（首字母大写）IsNull
					//and属性名（首字母大写）IsNotNull
					//and属性名（首字母大写）EqualTo
					//and属性名（首字母大写）NotEqualTo
					//and属性名（首字母大写）GreaterThan
					//and属性名（首字母大写）GreaterThanOrEqualTo
					//and属性名（首字母大写）LessThan
					//and属性名（首字母大写）LessThanOrEqualTo
					//and属性名（首字母大写）Like
					//and属性名（首字母大写）NotLike
        			boolean flag = false;
        			if(keyStr.endsWith("Like")){
        				flag = true;
        			}
        			String code = "";
        			if(keyStr.indexOf("_") > 0){
        				code = keyStr.split("_")[1];
        				keyStr = keyStr.split("_")[0];
        			} else {
        				code = "4";
        			}
        			Method method = null;
        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
        			if(typeVal != null){
        				method = criteria.getClass().getMethod(keyStr, typeVal);
        				if("1".equals(code)){
        					Integer vals = Integer.parseInt((String)entry.getValue());
        					method.invoke(criteria, vals);
        				} else if("2".equals(code)){
        					Long vals = Long.parseLong((String)entry.getValue());
        					method.invoke(criteria, vals);
        				} else if("3".equals(code)){
        					SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        					Date vals = sdf.parse((String)entry.getValue());
        					method.invoke(criteria, vals);
        				} else if("4".equals(code)){
        					String vals = (String)entry.getValue();
        					if(flag) {
        						vals = "%"+vals+"%";
                			}
        					method.invoke(criteria, vals);
        				} else if("5".equals(code)){
        					BigDecimal vals = new BigDecimal((String)entry.getValue());
        					method.invoke(criteria, vals);
        				}
        			} else {
        				method = criteria.getClass().getMethod(keyStr);
        				method.invoke(criteria);
        			}
        		}
        	}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        PageInfo<ModularTab> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setRecordsTotal(page.getTotal());
        responseModel.setData(page.getList());
        responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
        responseModel.setMessage("分页查询成功");
        return responseModel;
    }
    
    @Secured("ROLE_ModularTab_QUERY_LIST")
    //@Cacheable(value = "ModularTab")
    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/ModularTab/getList", roleName = "模块_查询_列表", 
					roleFlag = "ROLE_ModularTab_QUERY_LIST")
    public ResponseDataListModel<ModularTab> getList(@RequestParam(required = false) String param)  throws BaseException{
        logger.info("param:{}", param);
        ResponseDataListModel<ModularTab> responseModel = new ResponseDataListModel<ModularTab>();
        HashMap<String, Object> paramMap = new HashMap<>();
        if (!StringUtils.isEmpty(param)) {
            try {
                paramMap = new ObjectMapper().readValue(param, HashMap.class);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        	if(StringUtils.isEmpty((String)paramMap.get("orderby"))){
            	paramMap.put("orderby","id desc");
            }
        }else{
            paramMap.put("orderby","id desc");
        }
        ModularTabExample example = new ModularTabExample();
        example.setOrderByClause((String)paramMap.get("orderby"));
        Criteria criteria = example.createCriteria();
        try {
        	for(Entry<String, Object> entry : paramMap.entrySet()){
        		if(!entry.getKey().equals("orderby")){
        			String keyStr = entry.getKey();
					//and属性名（首字母大写）IsNull
					//and属性名（首字母大写）IsNotNull
					//and属性名（首字母大写）EqualTo
					//and属性名（首字母大写）NotEqualTo
					//and属性名（首字母大写）GreaterThan
					//and属性名（首字母大写）GreaterThanOrEqualTo
					//and属性名（首字母大写）LessThan
					//and属性名（首字母大写）LessThanOrEqualTo
					//and属性名（首字母大写）Like
					//and属性名（首字母大写）NotLike
        			boolean flag = false;
        			if(keyStr.endsWith("Like")){
        				flag = true;
        			}
        			String code = "";
        			if(keyStr.indexOf("_") > 0){
        				code = keyStr.split("_")[1];
        				keyStr = keyStr.split("_")[0];
        			} else {
        				code = "4";
        			}
        			Method method = null;
        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
        			if(typeVal != null){
        				method = criteria.getClass().getMethod(keyStr, typeVal);
        				if("1".equals(code)){
        					Integer vals = Integer.parseInt((String)entry.getValue());
        					method.invoke(criteria, vals);
        				} else if("2".equals(code)){
        					Long vals = Long.parseLong((String)entry.getValue());
        					method.invoke(criteria, vals);
        				} else if("3".equals(code)){
        					SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        					Date vals = sdf.parse((String)entry.getValue());
        					method.invoke(criteria, vals);
        				} else if("4".equals(code)){
        					String vals = (String)entry.getValue();
        					if(flag) {
        						vals = "%"+vals+"%";
                			}
        					method.invoke(criteria, vals);
        				} else if("5".equals(code)){
        					BigDecimal vals = new BigDecimal((String)entry.getValue());
        					method.invoke(criteria, vals);
        				}
        			} else {
        				method = criteria.getClass().getMethod(keyStr);
        				method.invoke(criteria);
        			}
        		}
        	}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        List<ModularTab> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        responseModel.setMessage("列表查询成功");
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_ADD")
	@CachePut(value = "ModularTab", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/add", roleName = "模块_添加", 
				roleFlag = "ROLE_ModularTab_ADD")
    public ResponseDataModel<ModularTab> add(@RequestBody ModularTab model) {
        ResponseDataModel<ModularTab> responseModel = new ResponseDataModel<ModularTab>();
        try {
            ModularTab record = new ModularTab();
            BeanUtils.copyProperties(model, record);
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
	
	@Secured("ROLE_ModularTab_EDIT")
	@CachePut(value = "ModularTab", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/update", roleName = "模块_编辑", 
			roleFlag = "ROLE_ModularTab_EDIT")
    public ResponseDataModel<ModularTab> update(@RequestBody ModularTab model) {
        ResponseDataModel<ModularTab> responseModel = new ResponseDataModel<ModularTab>();
        try {
            ModularTab record = new ModularTab();
            BeanUtils.copyProperties(model, record);
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

	@Secured("ROLE_ModularTab_DELETE")
	@CacheEvict(value = "ModularTab")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/del", roleName = "模块_删除", 
				roleFlag = "ROLE_ModularTab_DELETE")
    public ResponseModel del(Long id) {
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
	
	@Secured("ROLE_ModularTab_QUERY_FieldInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/getFieldsById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/getFieldsById", roleName = "模块_查询_模块字段信息", 
					roleFlag = "ROLE_ModularTab_QUERY_FieldInfo")
    public ResponseDataModel<Map<String,List>> getFieldsById(Long id) {
        ResponseDataModel<Map<String,List>> responseModel = new ResponseDataModel<>();
        try {
        	Map<String,List> entity = service.getFieldsById(id);
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
        responseModel.setMessage("信息查询成功");
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_SAVE_FieldInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/saveFieldInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/saveFieldInfo", roleName = "模块_保存_模块字段信息", 
					roleFlag = "ROLE_ModularTab_SAVE_FieldInfo")
    public ResponseModel saveFieldInfo(@RequestBody Map<String,Object> map) {
		ResponseModel responseModel = new ResponseModel();
        try {
        	Long id = Long.parseLong(map.get("id")==null?"":(map.get("id")+""));
        	List<Map<String,Object>> listMap = (List<Map<String,Object>>)map.get("list");
        	List<BaseOption> list = new ArrayList<>();
        	for(Map<String,Object> itemMap:listMap){
        		BaseOption baseOption = new BaseOption();
        		baseOption.setKey(itemMap.get("key")==null?"":(itemMap.get("key")+""));
        		baseOption.setLabel(itemMap.get("label")==null?"":(itemMap.get("label")+""));
        		list.add(baseOption);
        	}
        	service.saveFieldInfo(id, list);
        	responseModel.setSuccess(true);
            responseModel.setMessage("保存成功");
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_QUERY_QueryCriteriaInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/getQueryCriteriasById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/getQueryCriteriasById", roleName = "模块_查询_查询条件信息", 
					roleFlag = "ROLE_ModularTab_QUERY_QueryCriteriaInfo")
    public ResponseDataModel<Map<String,List>> getQueryCriteriasById(Long id) {
        ResponseDataModel<Map<String,List>> responseModel = new ResponseDataModel<>();
        try {
        	Map<String,List> entity = service.getQueryCriteriasById(id);
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
        responseModel.setMessage("信息查询成功");
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_SAVE_QueryCriteriaInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/saveQueryCriteriaInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/saveQueryCriteriaInfo", roleName = "模块_保存_查询条件信息", 
					roleFlag = "ROLE_ModularTab_SAVE_QueryCriteriaInfo")
    public ResponseModel saveQueryCriteriaInfo(@RequestBody Map<String,Object> map) {
		ResponseModel responseModel = new ResponseModel();
        try {
        	Long id = Long.parseLong(map.get("id")==null?"":(map.get("id")+""));
        	List<Map<String,Object>> listMap = (List<Map<String,Object>>)map.get("list");
        	List<BaseOption> list = new ArrayList<>();
        	for(Map<String,Object> itemMap:listMap){
        		BaseOption baseOption = new BaseOption();
        		baseOption.setKey(itemMap.get("key")==null?"":(itemMap.get("key")+""));
        		baseOption.setLabel(itemMap.get("label")==null?"":(itemMap.get("label")+""));
        		list.add(baseOption);
        	}
        	service.saveQueryCriteriaInfo(id, list);
        	responseModel.setSuccess(true);
            responseModel.setMessage("保存成功");
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_QUERY_TableItemInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/getTableItemsById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/getTableItemsById", roleName = "模块_查询_表格项信息", 
					roleFlag = "ROLE_ModularTab_QUERY_TableItemInfo")
    public ResponseDataModel<Map<String,List>> getTableItemsById(Long id) {
        ResponseDataModel<Map<String,List>> responseModel = new ResponseDataModel<>();
        try {
        	Map<String,List> entity = service.getTableItemsById(id);
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
        responseModel.setMessage("信息查询成功");
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_SAVE_TableItemInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/saveTableItemInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/saveTableItemInfo", roleName = "模块_保存_表格项信息", 
					roleFlag = "ROLE_ModularTab_SAVE_TableItemInfo")
    public ResponseModel saveTableItemInfo(@RequestBody Map<String,Object> map) {
		ResponseModel responseModel = new ResponseModel();
        try {
        	Long id = Long.parseLong(map.get("id")==null?"":(map.get("id")+""));
        	List<Map<String,Object>> listMap = (List<Map<String,Object>>)map.get("list");
        	List<BaseOption> list = new ArrayList<>();
        	for(Map<String,Object> itemMap:listMap){
        		BaseOption baseOption = new BaseOption();
        		baseOption.setKey(itemMap.get("key")==null?"":(itemMap.get("key")+""));
        		baseOption.setLabel(itemMap.get("label")==null?"":(itemMap.get("label")+""));
        		list.add(baseOption);
        	}
        	service.saveTableItemInfo(id, list);
        	responseModel.setSuccess(true);
            responseModel.setMessage("保存成功");
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_QUERY_FormItemInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/getFormItemsById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/getFormItemsById", roleName = "模块_查询_表单项信息", 
					roleFlag = "ROLE_ModularTab_QUERY_FormItemInfo")
    public ResponseDataModel<Map<String,List>> getFormItemsById(Long id) {
        ResponseDataModel<Map<String,List>> responseModel = new ResponseDataModel<>();
        try {
        	Map<String,List> entity = service.getFormItemsById(id);
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
        responseModel.setMessage("信息查询成功");
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_SAVE_FormItemInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/saveFormItemInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/saveFormItemInfo", roleName = "模块_保存_表单项信息", 
					roleFlag = "ROLE_ModularTab_SAVE_FormItemInfo")
    public ResponseModel saveFormItemInfo(@RequestBody Map<String,Object> map) {
		ResponseModel responseModel = new ResponseModel();
        try {
        	Long id = Long.parseLong(map.get("id")==null?"":(map.get("id")+""));
        	List<Map<String,Object>> listMap = (List<Map<String,Object>>)map.get("list");
        	List<BaseOption> list = new ArrayList<>();
        	for(Map<String,Object> itemMap:listMap){
        		BaseOption baseOption = new BaseOption();
        		baseOption.setKey(itemMap.get("key")==null?"":(itemMap.get("key")+""));
        		baseOption.setLabel(itemMap.get("label")==null?"":(itemMap.get("label")+""));
        		list.add(baseOption);
        	}
        	service.saveFormItemInfo(id, list);
        	responseModel.setSuccess(true);
            responseModel.setMessage("保存成功");
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        return responseModel;
    }
	
	@Secured("ROLE_ModularTab_QUERY_ModularTabInfo")
	//@Cacheable(value = "ModularTab")
    @PostMapping(value = "/getModularInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ModularTab/getModularInfo", roleName = "模块_查询_模块信息", 
					roleFlag = "ROLE_ModularTab_QUERY_ModularTabInfo")
    public ResponseDataModel<String> getModularInfo(String modularName) {
        ResponseDataModel<String> responseModel = new ResponseDataModel<>();
        try {
        	String entity = service.getModularInfo(modularName);
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
        responseModel.setMessage("信息查询成功");
        return responseModel;
    }
}