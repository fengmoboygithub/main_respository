package com.interapi.app.bmp.controller;

import com.interapi.app.annotation.ResourceMapping;
import com.interapi.app.base.exception.BaseException;
import com.interapi.app.bean.ResponseDataListModel;
import com.interapi.app.bean.ResponseDataModel;
import com.interapi.app.bmp.model.AuthorityPageRela;
import com.interapi.app.bmp.model.AuthorityPageRelaExample;
import com.interapi.app.bmp.service.AuthorityPageRelaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("AuthorityPageRelaController")
@RequestMapping("/api/AuthorityPageRela")
@ResourceMapping(code = "AuthorityPageRela", name = "权限页面_模块", tableName = "authority_page_rela", menuName = "关系信息管理",
roleName = "权限页面_页面", roleFlag = "ROLE_AuthorityPageRela_PAGE", homePage = "/pages/AuthorityPageRela",
pageSort = "5", menuSort = "4")
public class AuthorityPageRelaController {

    public static Logger logger = LoggerFactory.getLogger(AuthorityPageRelaController.class);

    @Autowired
    private AuthorityPageRelaService<AuthorityPageRela, AuthorityPageRelaExample> service;

    @Secured("ROLE_AuthorityPageRela_QUERY_LIST_BY_AUTHORITYID")
//    @Cacheable(value = "UserPostRela")
    @PostMapping(value = "/getListByAuthorityId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @SuppressWarnings("unchecked")
    @ResourceMapping(code = "/api/AuthorityPageRela/getListByAuthorityId", roleName = "权限菜单_查询_列表_根据权限ID",
            roleFlag = "ROLE_AuthorityPageRela_QUERY_LIST_BY_AUTHORITYID")
    public ResponseDataListModel<AuthorityPageRela> getList(Long authorityId)  throws BaseException {
        ResponseDataListModel<AuthorityPageRela> responseModel = new ResponseDataListModel<AuthorityPageRela>();
        List<AuthorityPageRela> list = new ArrayList<>();
        try{
            list = service.getListByAuthorityId(authorityId);
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

    @Secured("ROLE_AuthorityPageRela_EDIT")
//    @CachePut(value = "RoleAuthorityRela", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/AuthorityPageRela/update", roleName = "权限菜单_编辑",
            roleFlag = "ROLE_AuthorityPageRela_EDIT")
    public ResponseDataModel<AuthorityPageRela> update(Long authorityId, @RequestParam(required = false) String pageList) {
        ResponseDataModel<AuthorityPageRela> responseModel = new ResponseDataModel<AuthorityPageRela>();
        try {
            service.updateAuthorityPageRela(authorityId,pageList);
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
	
//	@Secured("ROLE_AuthorityPageRela_QUERY_DETAIL")
//	@Cacheable(value = "AuthorityPageRela")
//    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/AuthorityPageRela/get", roleName = "权限页面_查询_详情",
//					roleFlag = "ROLE_AuthorityPageRela_QUERY_DETAIL")
//    public ResponseDataModel<AuthorityPageRela> get(Long id) {
//        ResponseDataModel<AuthorityPageRela> responseModel = new ResponseDataModel<>();
//        try {
//            AuthorityPageRela entity=service.get(id);
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
	
//	@Secured("ROLE_AuthorityPageRela_QUERY_PAGE")
//	//@Cacheable(value = "AuthorityPageRela")
//    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    @SuppressWarnings("unchecked")
//    @ResourceMapping(code = "/api/AuthorityPageRela/getListByPage", roleName = "权限页面_查询_分页",
//					roleFlag = "ROLE_AuthorityPageRela_QUERY_PAGE")
//    public ResponseDataPageListForBootModel<AuthorityPageRela> getListByPage(
//    		@RequestParam(required = false) int currentPage,
//    		@RequestParam(required = false) int itemsPerPage,
//    		@RequestParam(required = false) String param
//    	)  throws BaseException{
//        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
//        ResponseDataPageListForBootModel<AuthorityPageRela> responseModel = new ResponseDataPageListForBootModel<AuthorityPageRela>();
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
//        AuthorityPageRelaExample example = new AuthorityPageRelaExample();
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
//        PageInfo<AuthorityPageRela> page = service.getListByPage(currentPage, itemsPerPage, example);
//        responseModel.setSuccess(true);
//        responseModel.setPageIndex(currentPage);
//        responseModel.setPageSize(itemsPerPage);
//        responseModel.setRecordsTotal(page.getTotal());
//        responseModel.setData(page.getList());
//        responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
//        responseModel.setMessage("分页查询成功");
//        return responseModel;
//    }
    
//    @Secured("ROLE_AuthorityPageRela_QUERY_LIST")
//    //@Cacheable(value = "AuthorityPageRela")
//    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    @SuppressWarnings("unchecked")
//    @ResourceMapping(code = "/api/AuthorityPageRela/getList", roleName = "权限页面_查询_列表",
//					roleFlag = "ROLE_AuthorityPageRela_QUERY_LIST")
//    public ResponseDataListModel<AuthorityPageRela> getList(@RequestParam(required = false) String param)  throws BaseException{
//        logger.info("param:{}", param);
//        ResponseDataListModel<AuthorityPageRela> responseModel = new ResponseDataListModel<AuthorityPageRela>();
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
//        AuthorityPageRelaExample example = new AuthorityPageRelaExample();
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
//        List<AuthorityPageRela> list = service.getList(example);
//        responseModel.setSuccess(true);
//        responseModel.setList(list);
//        responseModel.setMessage("列表查询成功");
//        return responseModel;
//    }
	
//	@Secured("ROLE_AuthorityPageRela_ADD")
//	@CachePut(value = "AuthorityPageRela", key = "#root.caches[0].name + ':' + #model.id")
//    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/AuthorityPageRela/add", roleName = "权限页面_添加",
//				roleFlag = "ROLE_AuthorityPageRela_ADD")
//    public ResponseDataModel<AuthorityPageRela> add(@RequestBody AuthorityPageRela model) {
//        ResponseDataModel<AuthorityPageRela> responseModel = new ResponseDataModel<AuthorityPageRela>();
//        try {
//            AuthorityPageRela record = new AuthorityPageRela();
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
	
//	@Secured("ROLE_AuthorityPageRela_EDIT")
//	@CachePut(value = "AuthorityPageRela", key = "#root.caches[0].name + ':' + #model.id")
//    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/AuthorityPageRela/update", roleName = "权限页面_编辑",
//			roleFlag = "ROLE_AuthorityPageRela_EDIT")
//    public ResponseDataModel<AuthorityPageRela> update(@RequestBody AuthorityPageRela model) {
//        ResponseDataModel<AuthorityPageRela> responseModel = new ResponseDataModel<AuthorityPageRela>();
//        try {
//            AuthorityPageRela record = new AuthorityPageRela();
//            BeanUtils.copyProperties(model, record);
//            service.update(record);
//            responseModel.setEntity(record);
//        } catch (Exception e) {
//            responseModel.setSuccess(false);
//            responseModel.setMessage("Fail:" + e.getMessage());
//            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            logger.error("Fail:", e);
//            return responseModel;
//        }
//        responseModel.setSuccess(true);
//        responseModel.setMessage("编辑成功");
//        return responseModel;
//    }

//	@Secured("ROLE_AuthorityPageRela_DELETE")
//	@CacheEvict(value = "AuthorityPageRela")
//    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResourceMapping(code = "/api/AuthorityPageRela/del", roleName = "权限页面_删除",
//				roleFlag = "ROLE_AuthorityPageRela_DELETE")
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