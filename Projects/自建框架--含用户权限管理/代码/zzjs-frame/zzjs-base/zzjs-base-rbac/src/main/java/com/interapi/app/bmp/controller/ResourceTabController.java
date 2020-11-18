package com.interapi.app.bmp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.ResourceTabExample;
import com.interapi.app.bmp.model.ResourceTabExample.Criteria;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.bmp.service.ResourceTabService;
import com.interapi.app.annotation.ResourceMapping;
import com.interapi.app.bean.ResponseDataModel;
import com.interapi.app.bean.ResponseModel;
import com.interapi.app.bean.ResponseDataListModel;
import com.interapi.app.bean.ResponseDataPageListForBootModel;
import com.interapi.app.enums.ExampleTypeEnum;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

@RestController("ResourceTabController")
@RequestMapping("/api/ResourceTab")
@ResourceMapping(code = "ResourceTab", name = "接口资源_模块", tableName = "resource_tab", menuName = "基础信息管理",
roleName = "接口资源_页面", roleFlag = "ROLE_ResourceTab_PAGE", homePage = "/pages/ResourceTab",
pageSort = "5", menuSort = "2")
public class ResourceTabController {

    public static Logger logger = LoggerFactory.getLogger(ResourceTabController.class);

    @Autowired
    private ResourceTabService<ResourceTab, ResourceTabExample> service;
	
	@Secured("ROLE_ResourceTab_QUERY_DETAIL")
	@Cacheable(value = "ResourceTab")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ResourceTab/get", roleName = "接口资源_查询_详情", 
					roleFlag = "ROLE_ResourceTab_QUERY_DETAIL")
    public ResponseDataModel<ResourceTab> get(Long id) {
        ResponseDataModel<ResourceTab> responseModel = new ResponseDataModel<>();
        try {
            ResourceTab entity=service.get(id);
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
	
	@Secured("ROLE_ResourceTab_QUERY_PAGE")
	//@Cacheable(value = "ResourceTab")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/ResourceTab/getListByPage", roleName = "接口资源_查询_分页", 
					roleFlag = "ROLE_ResourceTab_QUERY_PAGE")
    public ResponseDataPageListForBootModel<ResourceTab> getListByPage(
    		@RequestParam(required = false) int currentPage, 
    		@RequestParam(required = false) int itemsPerPage,
    		@RequestParam(required = false) String param
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListForBootModel<ResourceTab> responseModel = new ResponseDataPageListForBootModel<ResourceTab>();
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
        ResourceTabExample example = new ResourceTabExample();
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
        PageInfo<ResourceTab> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setRecordsTotal(page.getTotal());
        responseModel.setData(page.getList());
        responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
        responseModel.setMessage("分页查询成功");
        return responseModel;
    }
    
    @Secured("ROLE_ResourceTab_QUERY_LIST")
    //@Cacheable(value = "ResourceTab")
    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/ResourceTab/getList", roleName = "接口资源_查询_列表", 
					roleFlag = "ROLE_ResourceTab_QUERY_LIST")
    public ResponseDataListModel<ResourceTab> getList(@RequestParam(required = false) String param)  throws BaseException{
        logger.info("param:{}", param);
        ResponseDataListModel<ResourceTab> responseModel = new ResponseDataListModel<ResourceTab>();
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
        ResourceTabExample example = new ResourceTabExample();
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
        List<ResourceTab> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        responseModel.setMessage("列表查询成功");
        return responseModel;
    }
	
	@Secured("ROLE_ResourceTab_ADD")
	@CachePut(value = "ResourceTab", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ResourceTab/add", roleName = "接口资源_添加", 
				roleFlag = "ROLE_ResourceTab_ADD")
    public ResponseDataModel<ResourceTab> add(@RequestBody ResourceTab model) {
        ResponseDataModel<ResourceTab> responseModel = new ResponseDataModel<ResourceTab>();
        try {
            ResourceTab record = new ResourceTab();
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
	
	@Secured("ROLE_ResourceTab_EDIT")
	@CachePut(value = "ResourceTab", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ResourceTab/update", roleName = "接口资源_编辑", 
			roleFlag = "ROLE_ResourceTab_EDIT")
    public ResponseDataModel<ResourceTab> update(@RequestBody ResourceTab model) {
        ResponseDataModel<ResourceTab> responseModel = new ResponseDataModel<ResourceTab>();
        try {
            ResourceTab record = new ResourceTab();
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

	@Secured("ROLE_ResourceTab_DELETE")
	@CacheEvict(value = "ResourceTab")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/ResourceTab/del", roleName = "接口资源_删除", 
				roleFlag = "ROLE_ResourceTab_DELETE")
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

}