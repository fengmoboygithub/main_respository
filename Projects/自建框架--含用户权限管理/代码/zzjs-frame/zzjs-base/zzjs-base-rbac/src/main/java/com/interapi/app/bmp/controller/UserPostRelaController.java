package com.interapi.app.bmp.controller;

import com.interapi.app.annotation.ResourceMapping;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.bean.ResponseDataListModel;
import com.interapi.app.bean.ResponseDataModel;
import com.interapi.app.bmp.model.UserPostRela;
import com.interapi.app.bmp.model.UserPostRelaExample;
import com.interapi.app.bmp.service.UserPostRelaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("UserPostRelaController")
@RequestMapping("/api/UserPostRela")
@ResourceMapping(code = "UserPostRela", name = "用户岗位_模块", tableName = "user_post_rela", menuName = "关系信息管理",
roleName = "用户岗位_页面", roleFlag = "ROLE_UserPostRela_PAGE", homePage = "/pages/UserPostRela",
pageSort = "2", menuSort = "4")
public class UserPostRelaController {

    public static Logger logger = LoggerFactory.getLogger(UserPostRelaController.class);

    @Autowired
    private UserPostRelaService<UserPostRela, UserPostRelaExample> service;


    @Secured("ROLE_UserPostRela_QUERY_LIST_BY_USERID")
//    @Cacheable(value = "UserPostRela")
    @PostMapping(value = "/getListByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/UserPostRela/getListByUserId", roleName = "用户岗位_查询_列表_根据用户ID",
            roleFlag = "ROLE_UserPostRela_QUERY_LIST_BY_USERID")
    public ResponseDataListModel<UserPostRela> getList(Long userId)  throws BaseException{
        ResponseDataListModel<UserPostRela> responseModel = new ResponseDataListModel<UserPostRela>();
        List<UserPostRela> list = new ArrayList<>();
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


    @Secured("ROLE_UserPostRela_EDIT")
//	@CacheEvict(value = "UserTab", allEntries=true)
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/UserPostRela/update", roleName = "用户岗位_编辑",
            roleFlag = "ROLE_UserPostRela_EDIT")
    public ResponseDataModel<UserPostRela> update(Long userId, @RequestParam(required = false) String postList) {
        ResponseDataModel<UserPostRela> responseModel = new ResponseDataModel<UserPostRela>();
        try {
            service.updateUserPostRela(userId,postList);
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
	
//	@Secured("ROLE_UserPostRela_QUERY_DETAIL")
//	@Cacheable(value = "UserPostRela")
//    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/UserPostRela/get", roleName = "用户岗位_查询_详情",
//					roleFlag = "ROLE_UserPostRela_QUERY_DETAIL")
//    public ResponseDataModel<UserPostRela> get(Long id) {
//        ResponseDataModel<UserPostRela> responseModel = new ResponseDataModel<>();
//        try {
//            UserPostRela entity=service.get(id);
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

//	@Secured("ROLE_UserPostRela_QUERY_PAGE")
//	@Cacheable(value = "UserPostRela")
//    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    @SuppressWarnings("unchecked")
//    @ResourceMapping(code = "/api/UserPostRela/getListByPage", roleName = "用户岗位_查询_分页",
//					roleFlag = "ROLE_UserPostRela_QUERY_PAGE")
//    public ResponseDataPageListForBootModel<UserPostRela> getListByPage(
//    		@RequestParam(required = false) int currentPage,
//    		@RequestParam(required = false) int itemsPerPage,
//    		@RequestParam(required = false) int draw,
//    		@RequestParam(required = false) String param
//    	)  throws BaseException{
//        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
//        ResponseDataPageListForBootModel<UserPostRela> responseModel = new ResponseDataPageListForBootModel<UserPostRela>();
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
//        UserPostRelaExample example = new UserPostRelaExample();
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
//        			} else {
//        				code = "4";
//        			}
//        			Method method = null;
//        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
//        			if(typeVal != null){
//        				method = criteria.getClass().getMethod(keyStr, typeVal);
//        			} else {
//        				method = criteria.getClass().getMethod(keyStr);
//        			}
//        			String vals = (String)entry.getValue();
//        			if(flag) {
//        				vals = "%"+vals+"%";
//        			}
//        			method.invoke(criteria, vals);
//        		}
//        	}
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//        PageInfo<UserPostRela> page = service.getListByPage(currentPage, itemsPerPage, example);
//        responseModel.setSuccess(true);
//        responseModel.setPageIndex(currentPage);
//        responseModel.setPageSize(itemsPerPage);
//        responseModel.setDraw(draw);
//        responseModel.setRecordsTotal(page.getTotal());
//        responseModel.setData(page.getList());
//        responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
//        responseModel.setMessage("分页查询成功");
//        return responseModel;
//    }

//    @Secured("ROLE_UserPostRela_QUERY_LIST")
//    @Cacheable(value = "UserPostRela")
//    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    @SuppressWarnings("unchecked")
//    @ResourceMapping(code = "/api/UserPostRela/getList", roleName = "用户岗位_查询_列表",
//					roleFlag = "ROLE_UserPostRela_QUERY_LIST")
//    public ResponseDataListModel<UserPostRela> getList(@RequestParam(required = false) String param)  throws BaseException{
//        logger.info("param:{}", param);
//        ResponseDataListModel<UserPostRela> responseModel = new ResponseDataListModel<UserPostRela>();
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
//        UserPostRelaExample example = new UserPostRelaExample();
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
//        			} else {
//        				code = "4";
//        			}
//        			Method method = null;
//        			Class<?> typeVal = ExampleTypeEnum.getEnumsByCode(code).getValue();
//        			if(typeVal != null){
//        				method = criteria.getClass().getMethod(keyStr, typeVal);
//        			} else {
//        				method = criteria.getClass().getMethod(keyStr);
//        			}
//        			String vals = (String)entry.getValue();
//        			if(flag) {
//        				vals = "%"+vals+"%";
//        			}
//        			method.invoke(criteria, vals);
//        		}
//        	}
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//        List<UserPostRela> list = service.getList(example);
//        responseModel.setSuccess(true);
//        responseModel.setList(list);
//        responseModel.setMessage("列表查询成功");
//        return responseModel;
//    }

//	@Secured("ROLE_UserPostRela_ADD")
//	@CachePut(value = "UserPostRela", key = "#root.caches[0].name + ':' + #model.id")
//    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/UserPostRela/add", roleName = "用户岗位_添加",
//				roleFlag = "ROLE_UserPostRela_ADD")
//    public ResponseModel add(@RequestBody UserPostRela model) {
//        ResponseModel responseModel = new ResponseModel();
//        try {
//            UserPostRela record = new UserPostRela();
//            BeanUtils.copyProperties(model, record);
//            service.save(record);
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

//	@Secured("ROLE_UserPostRela_DELETE")
//	@CacheEvict(value = "UserPostRela")
//    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/UserPostRela/del", roleName = "用户岗位_删除",
//				roleFlag = "ROLE_UserPostRela_DELETE")
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