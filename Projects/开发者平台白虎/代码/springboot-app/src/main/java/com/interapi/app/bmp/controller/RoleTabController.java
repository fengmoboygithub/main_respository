package com.interapi.app.bmp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.interapi.app.bmp.model.RoleTab;
import com.interapi.app.bmp.model.RoleTabExample;
import com.interapi.app.bmp.service.RoleTabService;
import com.interapi.app.bmp.bean.ResponseDataModel;
import com.interapi.app.bmp.bean.ResponseModel;
import com.interapi.app.bmp.bean.ResponseDataListModel;
import com.interapi.app.bmp.bean.ResponseDataPageListModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController("RoleTabController")
@RequestMapping("/api/RoleTab")
public class RoleTabController {

    public static Logger logger = LoggerFactory.getLogger(RoleTabController.class);

    @Autowired
    private RoleTabService service;
	
	@Cacheable(value = "RoleTab")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<RoleTab> get(Long id) {
        ResponseDataModel<RoleTab> responseModel = new ResponseDataModel<>();
        try {
            RoleTab entity=service.getRoleTab(id);
            responseModel.setSuccess(true);
            responseModel.setEntity(entity);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("SUCCESS");
        return responseModel;
    }
	
	@Cacheable(value = "RoleTab")
    @GetMapping(value = "getListByPage/{currentPage}/{itemsPerPage}")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataPageListModel<RoleTab> getListByPage(@PathVariable int currentPage, @PathVariable int itemsPerPage, @RequestParam(required = false) String param) {
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListModel<RoleTab> responseModel = new ResponseDataPageListModel<RoleTab>();
        HashMap<String, Object> paramMap = new HashMap<>();
        if (!StringUtils.isEmpty(param)) {
            try {
                paramMap = new ObjectMapper().readValue(param, HashMap.class);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }else{
            paramMap.put("orderby","id desc");
        }
        RoleTabExample example = new RoleTabExample();
        
        PageInfo<RoleTab> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setMatchedTotal(page.getTotal());
        responseModel.setResultSet(page.getList());
        return responseModel;
    }
    
    @Cacheable(value = "RoleTab")
    @GetMapping(value = "getList")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataListModel<RoleTab> getList(@RequestParam(required = false) String param) {
        logger.info("param:{}", param);
        ResponseDataListModel<RoleTab> responseModel = new ResponseDataListModel<RoleTab>();
        HashMap<String, Object> paramMap = new HashMap<>();
        if (!StringUtils.isEmpty(param)) {
            try {
                paramMap = new ObjectMapper().readValue(param, HashMap.class);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }else{
            paramMap.put("orderby","id desc");
        }
        RoleTabExample example = new RoleTabExample();
        
        List<RoleTab> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        return responseModel;
    }
	
	@CachePut(value = "RoleTab", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel add(@RequestBody RoleTab model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            RoleTab record = new RoleTab();
            BeanUtils.copyProperties(model, record);
            service.save(record);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("SUCCESS");
        return responseModel;
    }
	
	@CachePut(value = "RoleTab", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel update(@RequestBody RoleTab model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            RoleTab record = new RoleTab();
            BeanUtils.copyProperties(model, record);
            service.update(record);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("SUCCESS");
        return responseModel;
    }

	@CacheEvict(value = "RoleTab")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(Long id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            service.deleteByPrimaryKey(id);
        } catch (Exception e) {
        responseModel.setSuccess(false);
        responseModel.setMessage("Fail:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("SUCCESS");
        return responseModel;
    }

}