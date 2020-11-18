package com.interapi.app.bmp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interapi.app.annotation.ResourceMapping;
import com.interapi.app.bean.ResponseDataListModel;
import com.interapi.app.bean.ResponseDataModel;
import com.interapi.app.bmp.dao.UserTabMapper;
import com.interapi.app.bmp.model.AuthorityTab;
import com.interapi.app.bmp.model.ModularTab;
import com.interapi.app.bmp.model.PageTab;
import com.interapi.app.bmp.model.ResourceTab;
import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.UserTab;
import com.interapi.app.bmp.model.UserTabExample;
import com.interapi.app.bmp.service.AuthorityTabService;
import com.interapi.app.bmp.service.ModularTabService;
import com.interapi.app.bmp.service.PageTabService;
import com.interapi.app.bmp.service.ResourceTabService;
import com.interapi.app.bmp.service.RoleTabService;
import com.interapi.app.bmp.service.UserTabService;
import com.interapi.app.utils.JwtTokenUtil;

@RestController("IndexController")
@RequestMapping("/api/Index")
@ResourceMapping(code = "Index", name = "仪表盘_模块", tableName = "index", menuName = "仪表盘",
roleName = "仪表盘_页面", roleFlag = "ROLE_Index_PAGE", homePage = "/index.html",
pageSort = "1", menuSort = "1")
public class IndexController {

    public static Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
    private UserTabService userTabService;
    
    @Autowired
    private UserTabMapper userTabMapper;
    
    @Autowired
    private RoleTabService roleTabService;
    
    @Autowired
    private AuthorityTabService authorityTabService;
    
    @Autowired
    private ResourceTabService resourceTabService;
    
    @Autowired
    private PageTabService pageTabService;
    
    @Autowired
    private ModularTabService modularTabService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
	
    
    @Cacheable(value = "IndexUserInfo")
    @PostMapping(value = "/getUserInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/getUserInfo", roleName = "仪表盘_查询_用户信息", 
					roleFlag = "ROLE_Index_QUERY_USERINFO")
    public ResponseDataModel<UserTab> getUserInfo(String token) {
    	ResponseDataModel<UserTab> responseModel = new ResponseDataModel<>();
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
    		UserTabExample example = new UserTabExample();
    		example.createCriteria().andAccountEqualTo(username);
    		List<UserTab> list = userTabMapper.selectByExample(example);
    		if(list != null && list.size() > 0){
    			UserTab userTab = new UserTab();
    			userTab = list.get(0);
    			responseModel.setEntity(userTab);
    		}
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("用户信息查询成功");
        return responseModel;
    }
    
    @CachePut(value = "IndexUserInfo", key = "#root.caches[0].name + ':' + #token")
    @PutMapping(value = "/perfectInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/perfectInfo", roleName = "仪表盘_编辑_用户信息", 
			roleFlag = "ROLE_Index_EDIT_USERINFO")
    public ResponseDataModel<UserTab> perfectInfo(String token, UserTab model) {
    	ResponseDataModel<UserTab> responseModel = new ResponseDataModel<UserTab>();
        try {
            UserTab record = new UserTab();
            BeanUtils.copyProperties(model, record);
            userTabService.update(record);
            responseModel.setEntity(record);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("用户信息保存成功");
        return responseModel;
    }
    
    @Cacheable(value = "IndexMenuInfo")
    @PostMapping(value = "/getMenuListByToken", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/getMenuListByToken", roleName = "仪表盘_查询_菜单信息", 
					roleFlag = "ROLE_Index_QUERY_MENUINFO")
    public ResponseDataListModel<PageTab> getMenuListByToken(String token) {
    	ResponseDataListModel<PageTab> responseModel = new ResponseDataListModel<>();
        try {
        	List<PageTab> resultList = pageTabService.getPageTabListByUserId(token);
            responseModel.setSuccess(true);
            responseModel.setList(resultList);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("菜单信息查询成功");
        return responseModel;
    }
    
    @Cacheable(value = "IndexRoleList")
    @PostMapping(value = "/getRoleList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/getRoleList", roleName = "仪表盘_查询_角色列表", 
					roleFlag = "ROLE_Index_QUERY_ROLELIST")
    public ResponseDataListModel<RoleTab> getRoleList(String token) {
		ResponseDataListModel<RoleTab> responseModel = new ResponseDataListModel<>();
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
    		UserTabExample example = new UserTabExample();
    		example.createCriteria().andAccountEqualTo(username);
    		List<UserTab> list = userTabMapper.selectByExample(example);
    		List<RoleTab> roleList = new ArrayList<RoleTab>();
    		if(list != null && list.size() > 0){
    			UserTab userTab = new UserTab();
    			userTab = list.get(0);
    			Long id = userTab.getId();
    			roleList = roleTabService.getRoleTabListByUserId(id);
    		}
            responseModel.setSuccess(true);
            responseModel.setList(roleList);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("角色列表查询成功");
        return responseModel;
    }
    
	@Cacheable(value = "IndexAuthorityList")
    @PostMapping(value = "/getAuthorityList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/getAuthorityList", roleName = "仪表盘_查询_权限列表", 
					roleFlag = "ROLE_Index_QUERY_AUTHORITYLIST")
    public ResponseDataListModel<AuthorityTab> getAuthorityList(String token) {
		ResponseDataListModel<AuthorityTab> responseModel = new ResponseDataListModel<>();
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
    		UserTabExample example = new UserTabExample();
    		example.createCriteria().andAccountEqualTo(username);
    		List<UserTab> list = userTabMapper.selectByExample(example);
    		List<AuthorityTab> authorityList = new ArrayList<AuthorityTab>();
    		if(list != null && list.size() > 0){
    			UserTab userTab = new UserTab();
    			userTab = list.get(0);
    			Long id = userTab.getId();
    			authorityList = authorityTabService.getAuthorityTabListByUserId(id);
    		}
            responseModel.setSuccess(true);
            responseModel.setList(authorityList);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("权限列表查询成功");
        return responseModel;
    }
	
	@Cacheable(value = "IndexResourceList")
    @PostMapping(value = "/getResourceList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/getResourceList", roleName = "仪表盘_查询_接口资源列表", 
					roleFlag = "ROLE_Index_QUERY_RESOURCELIST")
    public ResponseDataListModel<ResourceTab> getResourceList(String token) {
		ResponseDataListModel<ResourceTab> responseModel = new ResponseDataListModel<>();
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
    		UserTabExample example = new UserTabExample();
    		example.createCriteria().andAccountEqualTo(username);
    		List<UserTab> list = userTabMapper.selectByExample(example);
    		List<ResourceTab> resourceList = new ArrayList<ResourceTab>();
    		if(list != null && list.size() > 0){
    			UserTab userTab = new UserTab();
    			userTab = list.get(0);
    			Long id = userTab.getId();
    			resourceList = resourceTabService.getResourceTabListByUserId(id);
    		}
            responseModel.setSuccess(true);
            responseModel.setList(resourceList);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("接口资源列表查询成功");
        return responseModel;
    }
	
	@Cacheable(value = "IndexPageList")
    @PostMapping(value = "/getPageList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/getPageList", roleName = "仪表盘_查询_菜单页面列表", 
					roleFlag = "ROLE_Index_QUERY_PAGELIST")
    public ResponseDataListModel<PageTab> getPageList(String token) {
		ResponseDataListModel<PageTab> responseModel = new ResponseDataListModel<>();
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
    		UserTabExample example = new UserTabExample();
    		example.createCriteria().andAccountEqualTo(username);
    		List<UserTab> list = userTabMapper.selectByExample(example);
    		List<PageTab> pageList = new ArrayList<PageTab>();
    		if(list != null && list.size() > 0){
    			UserTab userTab = new UserTab();
    			userTab = list.get(0);
    			Long id = userTab.getId();
    			pageList = pageTabService.getPageTabListByUserId(id);
    		}
            responseModel.setSuccess(true);
            responseModel.setList(pageList);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("菜单页面列表查询成功");
        return responseModel;
    }
	
	@Cacheable(value = "IndexModularList")
    @PostMapping(value = "/getModularList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResourceMapping(code = "/api/Index/getModularList", roleName = "仪表盘_查询_模块列表", 
					roleFlag = "ROLE_Index_QUERY_MODULARLIST")
    public ResponseDataListModel<ModularTab> getModularList(String token) {
		ResponseDataListModel<ModularTab> responseModel = new ResponseDataListModel<>();
        try {
            String username = jwtTokenUtil.getUsernameFromToken(token);
    		UserTabExample example = new UserTabExample();
    		example.createCriteria().andAccountEqualTo(username);
    		List<UserTab> list = userTabMapper.selectByExample(example);
    		List<ModularTab> modularList = new ArrayList<ModularTab>();
    		if(list != null && list.size() > 0){
    			UserTab userTab = new UserTab();
    			userTab = list.get(0);
    			Long id = userTab.getId();
    			modularList = modularTabService.getModularTabListByUserId(id);
    		}
            responseModel.setSuccess(true);
            responseModel.setList(modularList);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("模块列表查询成功");
        return responseModel;
    }

}