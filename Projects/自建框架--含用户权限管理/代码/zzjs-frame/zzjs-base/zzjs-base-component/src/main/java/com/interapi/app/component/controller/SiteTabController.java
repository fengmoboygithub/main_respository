package com.interapi.app.component.controller;

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
import com.interapi.app.component.model.SiteTab;
import com.interapi.app.component.model.SiteTabExample;
import com.interapi.app.component.model.SiteTabExample.Criteria;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.component.service.SiteTabService;
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

@RestController("SiteTabController")
@RequestMapping("/api/SiteTab")
@ResourceMapping(code = "SiteTab", name = "站点_模块", tableName = "site_tab", menuName = "站点管理",
roleName = "站点_页面", roleFlag = "ROLE_SiteTab_PAGE", homePage = "/pages/SiteTab",
pageSort = "1", menuSort = "1")
public class SiteTabController {

    public static Logger logger = LoggerFactory.getLogger(SiteTabController.class);

    @Autowired
    private SiteTabService<SiteTab, SiteTabExample> service;
	
	@Secured("ROLE_SiteTab_QUERY_DETAIL")
	@Cacheable(value = "SiteTab")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/SiteTab/get", roleName = "站点_查询_详情", 
					roleFlag = "ROLE_SiteTab_QUERY_DETAIL")
    public ResponseDataModel<SiteTab> get(Long id) {
        ResponseDataModel<SiteTab> responseModel = new ResponseDataModel<>();
        try {
            SiteTab entity=service.get(id);
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
	
	@Secured("ROLE_SiteTab_QUERY_PAGE")
	//@Cacheable(value = "SiteTab")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/SiteTab/getListByPage", roleName = "站点_查询_分页", 
					roleFlag = "ROLE_SiteTab_QUERY_PAGE")
    public ResponseDataPageListForBootModel<SiteTab> getListByPage(
    		@RequestParam(required = false) int currentPage, 
    		@RequestParam(required = false) int itemsPerPage,
    		@RequestParam(required = false) String param
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListForBootModel<SiteTab> responseModel = new ResponseDataPageListForBootModel<SiteTab>();
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
        SiteTabExample example = new SiteTabExample();
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
        PageInfo<SiteTab> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setRecordsTotal(page.getTotal());
        responseModel.setData(page.getList());
        responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
        responseModel.setMessage("分页查询成功");
        return responseModel;
    }
    
    @Secured("ROLE_SiteTab_QUERY_LIST")
    //@Cacheable(value = "SiteTab")
    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/SiteTab/getList", roleName = "站点_查询_列表", 
					roleFlag = "ROLE_SiteTab_QUERY_LIST")
    public ResponseDataListModel<SiteTab> getList(@RequestParam(required = false) String param)  throws BaseException{
        logger.info("param:{}", param);
        ResponseDataListModel<SiteTab> responseModel = new ResponseDataListModel<SiteTab>();
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
        SiteTabExample example = new SiteTabExample();
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
        List<SiteTab> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        responseModel.setMessage("列表查询成功");
        return responseModel;
    }
	
	@Secured("ROLE_SiteTab_ADD")
	@CachePut(value = "SiteTab", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/SiteTab/add", roleName = "站点_添加", 
				roleFlag = "ROLE_SiteTab_ADD")
    public ResponseDataModel<SiteTab> add(@RequestBody SiteTab model) {
        ResponseDataModel<SiteTab> responseModel = new ResponseDataModel<SiteTab>();
        try {
            SiteTab record = new SiteTab();
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
	
	@Secured("ROLE_SiteTab_EDIT")
	@CachePut(value = "SiteTab", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/SiteTab/update", roleName = "站点_编辑", 
			roleFlag = "ROLE_SiteTab_EDIT")
    public ResponseDataModel<SiteTab> update(@RequestBody SiteTab model) {
        ResponseDataModel<SiteTab> responseModel = new ResponseDataModel<SiteTab>();
        try {
            SiteTab record = new SiteTab();
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

	@Secured("ROLE_SiteTab_DELETE")
	@CacheEvict(value = "SiteTab")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/SiteTab/del", roleName = "站点_删除", 
				roleFlag = "ROLE_SiteTab_DELETE")
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