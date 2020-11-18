package com.interapi.app.bmp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.UserRoleRela;
import com.interapi.app.bmp.model.UserRoleRelaExample;
import com.interapi.app.bmp.model.UserRoleRelaExample.Criteria;
import com.interapi.app.bmp.service.UserRoleRelaService;
import com.interapi.app.annotation.ResourceMapping;
import com.interapi.app.bean.ResponseDataModel;
import com.interapi.app.bean.ResponseModel;
import com.interapi.app.bean.ResponseDataListModel;
import com.interapi.app.bean.ResponseDataPageListForBootModel;
import com.interapi.app.enums.ExampleTypeEnum;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

@RestController("UserRoleRelaController")
@RequestMapping("/api/UserRoleRela")
@ResourceMapping(code = "UserRoleRela", name = "用户角色_模块", tableName = "user_role_rela", menuName = "关系信息管理",
roleName = "用户角色_页面", roleFlag = "ROLE_UserRoleRela_PAGE", homePage = "/pages/UserRoleRela/list.html",
pageSort = "1", menuSort = "4")
public class UserRoleRelaController {

    public static Logger logger = LoggerFactory.getLogger(UserRoleRelaController.class);

    @Autowired
    private UserRoleRelaService service;
	
	@Cacheable(value = "UserRoleRela")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/UserRoleRela/get", roleName = "用户角色_查询_详情", 
					roleFlag = "ROLE_UserRoleRela_QUERY_DETAIL")
    public ResponseDataModel<UserRoleRela> get(Long id) {
        ResponseDataModel<UserRoleRela> responseModel = new ResponseDataModel<>();
        try {
            UserRoleRela entity=service.getUserRoleRela(id);
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
	
	@Cacheable(value = "UserRoleRela")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/UserRoleRela/getListByPage", roleName = "用户角色_查询_分页", 
					roleFlag = "ROLE_UserRoleRela_QUERY_PAGE")
    public ResponseDataPageListForBootModel<UserRoleRela> getListByPage(
    		@RequestParam(required = false) int currentPage, 
    		@RequestParam(required = false) int itemsPerPage,
    		@RequestParam(required = false) int draw,
    		@RequestParam(required = false) String param
    	) {
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListForBootModel<UserRoleRela> responseModel = new ResponseDataPageListForBootModel<UserRoleRela>();
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
        UserRoleRelaExample example = new UserRoleRelaExample();
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
        			} else {
        				code = "4";
        			}
        			Method method = null;
        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
        			if(typeVal != null){
        				method = criteria.getClass().getMethod(keyStr, typeVal);
        			} else {
        				method = criteria.getClass().getMethod(keyStr);
        			}
        			String vals = (String)entry.getValue();
        			if(flag) {
        				vals = "%"+vals+"%";
        			}
        			method.invoke(criteria, vals);
        		}
        	}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        PageInfo<UserRoleRela> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setDraw(draw);
        responseModel.setRecordsTotal(page.getTotal());
        responseModel.setData(page.getList());
        responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
        responseModel.setMessage("分页查询成功");
        return responseModel;
    }
    
    @Cacheable(value = "UserRoleRela")
    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/UserRoleRela/getList", roleName = "用户角色_查询_列表", 
					roleFlag = "ROLE_UserRoleRela_QUERY_LIST")
    public ResponseDataListModel<UserRoleRela> getList(@RequestParam(required = false) String param) {
        logger.info("param:{}", param);
        ResponseDataListModel<UserRoleRela> responseModel = new ResponseDataListModel<UserRoleRela>();
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
        UserRoleRelaExample example = new UserRoleRelaExample();
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
        			} else {
        				code = "4";
        			}
        			Method method = null;
        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
        			if(typeVal != null){
        				method = criteria.getClass().getMethod(keyStr, typeVal);
        			} else {
        				method = criteria.getClass().getMethod(keyStr);
        			}
        			String vals = (String)entry.getValue();
        			if(flag) {
        				vals = "%"+vals+"%";
        			}
        			method.invoke(criteria, vals);
        		}
        	}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
        List<UserRoleRela> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        responseModel.setMessage("列表查询成功");
        return responseModel;
    }
	
	@CachePut(value = "UserRoleRela", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/UserRoleRela/add", roleName = "用户角色_添加", 
				roleFlag = "ROLE_UserRoleRela_ADD")
    public ResponseModel add(@RequestBody UserRoleRela model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            UserRoleRela record = new UserRoleRela();
            BeanUtils.copyProperties(model, record);
            service.save(record);
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
	
	@CachePut(value = "UserRoleRela", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/UserRoleRela/update", roleName = "用户角色_编辑", 
			roleFlag = "ROLE_UserRoleRela_EDIT")
    public ResponseModel update(@RequestBody UserRoleRela model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            UserRoleRela record = new UserRoleRela();
            BeanUtils.copyProperties(model, record);
            service.update(record);
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

	@CacheEvict(value = "UserRoleRela")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/UserRoleRela/del", roleName = "用户角色_删除", 
				roleFlag = "ROLE_UserRoleRela_DELETE")
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