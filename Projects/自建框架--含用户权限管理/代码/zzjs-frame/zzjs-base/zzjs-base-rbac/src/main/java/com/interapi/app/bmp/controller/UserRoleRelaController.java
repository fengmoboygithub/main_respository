package com.interapi.app.bmp.controller;

import com.interapi.app.annotation.ResourceMapping;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.bean.ResponseDataListModel;
import com.interapi.app.bean.ResponseDataModel;
import com.interapi.app.bmp.model.UserRoleRela;
import com.interapi.app.bmp.model.UserRoleRelaExample;
import com.interapi.app.bmp.service.UserRoleRelaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("UserRoleRelaController")
@RequestMapping("/api/UserRoleRela")
@ResourceMapping(code = "UserRoleRela", name = "用户角色_模块", tableName = "user_role_rela", menuName = "关系信息管理",
roleName = "用户角色_页面", roleFlag = "ROLE_UserRoleRela_PAGE", homePage = "/pages/UserRoleRela",
pageSort = "1", menuSort = "4")
public class UserRoleRelaController {

    public static Logger logger = LoggerFactory.getLogger(UserRoleRelaController.class);

    @Autowired
    private UserRoleRelaService<UserRoleRela, UserRoleRelaExample> service;
	
//	@Secured("ROLE_UserRoleRela_QUERY_DETAIL")
////	@Cacheable(value = "UserRoleRela")
//    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/UserRoleRela/get", roleName = "用户角色_查询_详情",
//					roleFlag = "ROLE_UserRoleRela_QUERY_DETAIL")
//    public ResponseDataModel<UserRoleRela> get(Long id) {
//        ResponseDataModel<UserRoleRela> responseModel = new ResponseDataModel<>();
//        try {
//            UserRoleRela entity=service.get(id);
//            responseModel.setSuccess(true);
//            responseModel.setEntity(entity);
//        } catch (Exception e) {
//            responseModel.setSuccess(false);
//            responseModel.setMessage("Fail:" + e.getMessage());
//            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            logger.error("Fail:", e);
//            return responseModel;
//        }
//        responseModel.setSuccess(true);
//        responseModel.setMessage("详情查询成功");
//        return responseModel;
//    }
	
//	@Secured("ROLE_UserRoleRela_QUERY_PAGE")
//	//@Cacheable(value = "UserRoleRela")
//    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    @SuppressWarnings("unchecked")
//    @ResourceMapping(code = "/api/UserRoleRela/getListByPage", roleName = "用户角色_查询_分页",
//					roleFlag = "ROLE_UserRoleRela_QUERY_PAGE")
//    public ResponseDataPageListForBootModel<UserRoleRela> getListByPage(
//    		@RequestParam(required = false) int currentPage,
//    		@RequestParam(required = false) int itemsPerPage,
//    		@RequestParam(required = false) String param
//    	)  throws BaseException{
//        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
//        ResponseDataPageListForBootModel<UserRoleRela> responseModel = new ResponseDataPageListForBootModel<UserRoleRela>();
//        HashMap<String, Object> paramMap = new HashMap<>();
//        if (!StringUtils.isEmpty(param)) {
//            try {
//                paramMap = new ObjectMapper().readValue(param, HashMap.class);
//            } catch (IOException e) {
//                logger.error(e.getMessage(), e);
//            }
//            if(StringUtils.isEmpty((String)paramMap.get("orderby"))){
//            	paramMap.put("orderby","id desc");
//            }
//        }else{
//            paramMap.put("orderby","id desc");
//        }
//        UserRoleRelaExample example = new UserRoleRelaExample();
//        example.setOrderByClause((String)paramMap.get("orderby"));
//        Criteria criteria = example.createCriteria();
//        try {
//        	for(Entry<String, Object> entry : paramMap.entrySet()){
//        		if(!entry.getKey().equals("orderby")){
//        			String keyStr = entry.getKey();
//					//and属性名（首字母大写）IsNull
//					//and属性名（首字母大写）IsNotNull
//					//and属性名（首字母大写）EqualTo
//					//and属性名（首字母大写）NotEqualTo
//					//and属性名（首字母大写）GreaterThan
//					//and属性名（首字母大写）GreaterThanOrEqualTo
//					//and属性名（首字母大写）LessThan
//					//and属性名（首字母大写）LessThanOrEqualTo
//					//and属性名（首字母大写）Like
//					//and属性名（首字母大写）NotLike
//        			boolean flag = false;
//        			if(keyStr.endsWith("Like")){
//        				flag = true;
//        			}
//        			String code = "";
//        			if(keyStr.indexOf("_") > 0){
//        				code = keyStr.split("_")[1];
//        				keyStr = keyStr.split("_")[0];
//        			} else {
//        				code = "4";
//        			}
//        			Method method = null;
//        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
//        			if(typeVal != null){
//        				method = criteria.getClass().getMethod(keyStr, typeVal);
//        				if("1".equals(code)){
//        					Integer vals = Integer.parseInt((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				} else if("2".equals(code)){
//        					Long vals = Long.parseLong((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				} else if("3".equals(code)){
//        					SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        					Date vals = sdf.parse((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				} else if("4".equals(code)){
//        					String vals = (String)entry.getValue();
//        					if(flag) {
//        						vals = "%"+vals+"%";
//                			}
//        					method.invoke(criteria, vals);
//        				} else if("5".equals(code)){
//        					BigDecimal vals = new BigDecimal((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				}
//        			} else {
//        				method = criteria.getClass().getMethod(keyStr);
//        				method.invoke(criteria);
//        			}
//        		}
//        	}
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//        PageInfo<UserRoleRela> page = service.getListByPage(currentPage, itemsPerPage, example);
//        responseModel.setSuccess(true);
//        responseModel.setPageIndex(currentPage);
//        responseModel.setPageSize(itemsPerPage);
//        responseModel.setRecordsTotal(page.getTotal());
//        responseModel.setData(page.getList());
//        responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
//        responseModel.setMessage("分页查询成功");
//        return responseModel;
//    }
    
//    @Secured("ROLE_UserRoleRela_QUERY_LIST")
//    //@Cacheable(value = "UserRoleRela")
//    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    @SuppressWarnings("unchecked")
//    @ResourceMapping(code = "/api/UserRoleRela/getList", roleName = "用户角色_查询_列表",
//					roleFlag = "ROLE_UserRoleRela_QUERY_LIST")
//    public ResponseDataListModel<UserRoleRela> getList(@RequestParam(required = false) String param)  throws BaseException{
//        logger.info("param:{}", param);
//        ResponseDataListModel<UserRoleRela> responseModel = new ResponseDataListModel<UserRoleRela>();
//        HashMap<String, Object> paramMap = new HashMap<>();
//        if (!StringUtils.isEmpty(param)) {
//            try {
//                paramMap = new ObjectMapper().readValue(param, HashMap.class);
//            } catch (IOException e) {
//                logger.error(e.getMessage(), e);
//            }
//        	if(StringUtils.isEmpty((String)paramMap.get("orderby"))){
//            	paramMap.put("orderby","id desc");
//            }
//        }else{
//            paramMap.put("orderby","id desc");
//        }
//        UserRoleRelaExample example = new UserRoleRelaExample();
//        example.setOrderByClause((String)paramMap.get("orderby"));
//        Criteria criteria = example.createCriteria();
//        try {
//        	for(Entry<String, Object> entry : paramMap.entrySet()){
//        		if(!entry.getKey().equals("orderby")){
//        			String keyStr = entry.getKey();
//					//and属性名（首字母大写）IsNull
//					//and属性名（首字母大写）IsNotNull
//					//and属性名（首字母大写）EqualTo
//					//and属性名（首字母大写）NotEqualTo
//					//and属性名（首字母大写）GreaterThan
//					//and属性名（首字母大写）GreaterThanOrEqualTo
//					//and属性名（首字母大写）LessThan
//					//and属性名（首字母大写）LessThanOrEqualTo
//					//and属性名（首字母大写）Like
//					//and属性名（首字母大写）NotLike
//        			boolean flag = false;
//        			if(keyStr.endsWith("Like")){
//        				flag = true;
//        			}
//        			String code = "";
//        			if(keyStr.indexOf("_") > 0){
//        				code = keyStr.split("_")[1];
//        				keyStr = keyStr.split("_")[0];
//        			} else {
//        				code = "4";
//        			}
//        			Method method = null;
//        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
//        			if(typeVal != null){
//        				method = criteria.getClass().getMethod(keyStr, typeVal);
//        				if("1".equals(code)){
//        					Integer vals = Integer.parseInt((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				} else if("2".equals(code)){
//        					Long vals = Long.parseLong((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				} else if("3".equals(code)){
//        					SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        					Date vals = sdf.parse((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				} else if("4".equals(code)){
//        					String vals = (String)entry.getValue();
//        					if(flag) {
//        						vals = "%"+vals+"%";
//                			}
//        					method.invoke(criteria, vals);
//        				} else if("5".equals(code)){
//        					BigDecimal vals = new BigDecimal((String)entry.getValue());
//        					method.invoke(criteria, vals);
//        				}
//        			} else {
//        				method = criteria.getClass().getMethod(keyStr);
//        				method.invoke(criteria);
//        			}
//        		}
//        	}
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//        List<UserRoleRela> list = service.getList(example);
//        responseModel.setSuccess(true);
//        responseModel.setList(list);
//        responseModel.setMessage("列表查询成功");
//        return responseModel;
//    }


    @Secured("ROLE_UserRoleRela_QUERY_LIST_BY_USERID")
    //@Cacheable(value = "UserRoleRela")
    @PostMapping(value = "/getListByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/UserRoleRela/getListByUserId", roleName = "用户角色_查询_列表_根据用户ID",
            roleFlag = "ROLE_UserRoleRela_QUERY_LIST_BY_USERID")
    public ResponseDataListModel<UserRoleRela> getList(Long userId)  throws BaseException {
        ResponseDataListModel<UserRoleRela> responseModel = new ResponseDataListModel<UserRoleRela>();
        List<UserRoleRela> list = new ArrayList<>();
        try{
            list = service.getListByUserId(userId);
        }catch (Exception e){
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setList(list);
        responseModel.setMessage("列表查询成功");
        return responseModel;
    }
	
//	@Secured("ROLE_UserRoleRela_ADD")
////	@CachePut(value = "UserRoleRela", key = "#root.caches[0].name + ':' + #model.id")
//    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/UserRoleRela/add", roleName = "用户角色_添加",
//				roleFlag = "ROLE_UserRoleRela_ADD")
//    public ResponseDataModel<UserRoleRela> add(@RequestBody UserRoleRela model) {
//        ResponseDataModel<UserRoleRela> responseModel = new ResponseDataModel<UserRoleRela>();
//        try {
//            UserRoleRela record = new UserRoleRela();
//            BeanUtils.copyProperties(model, record);
//            service.save(record);
//            responseModel.setEntity(record);
//        } catch (Exception e) {
//            responseModel.setSuccess(false);
//            responseModel.setMessage("Fail:" + e.getMessage());
//            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            logger.error("Fail:", e);
//            return responseModel;
//        }
//        responseModel.setSuccess(true);
//        responseModel.setMessage("添加成功");
//        return responseModel;
//    }
	
	@Secured("ROLE_UserRoleRela_EDIT")
//	@CachePut(value = "UserRoleRela", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/UserRoleRela/update", roleName = "用户角色_编辑", 
			roleFlag = "ROLE_UserRoleRela_EDIT")
    public ResponseDataModel<UserRoleRela> update(Long userId, @RequestParam(required = false) String roleList) {
        ResponseDataModel<UserRoleRela> responseModel = new ResponseDataModel<UserRoleRela>();
        try {
//            UserRoleRela record = new UserRoleRela();
//            BeanUtils.copyProperties(model, record);
//            service.update(record);
//            responseModel.setEntity(record);
            service.updateUserRoleRela(userId,roleList);
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

//	@Secured("ROLE_UserRoleRela_DELETE")
////	@CacheEvict(value = "UserRoleRela")
//    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/UserRoleRela/del", roleName = "用户角色_删除",
//				roleFlag = "ROLE_UserRoleRela_DELETE")
//    public ResponseModel del(Long id) {
//        ResponseModel responseModel = new ResponseModel();
//        try {
//            service.deleteByPrimaryKey(id);
//        } catch (Exception e) {
//        	responseModel.setSuccess(false);
//        	responseModel.setMessage("Fail:" + e.getMessage());
//        	responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            logger.error("Fail:", e);
//            return responseModel;
//        }
//        responseModel.setSuccess(true);
//        responseModel.setMessage("删除成功");
//        return responseModel;
//    }

}