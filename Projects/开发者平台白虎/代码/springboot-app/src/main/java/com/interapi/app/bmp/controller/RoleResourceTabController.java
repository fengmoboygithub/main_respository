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
import com.interapi.app.bmp.model.RoleResourceTab;
import com.interapi.app.bmp.model.RoleResourceTabExample;
import com.interapi.app.bmp.service.RoleResourceTabService;
import com.interapi.app.bmp.bean.ResponseDataModel;
import com.interapi.app.bmp.bean.ResponseModel;
import com.interapi.app.bmp.bean.ResponseDataListModel;
import com.interapi.app.bmp.bean.ResponseDataPageListModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController("RoleResourceTabController")
@RequestMapping("/api/RoleResourceTab")
public class RoleResourceTabController {

    public static Logger logger = LoggerFactory.getLogger(RoleResourceTabController.class);

    @Autowired
    private RoleResourceTabService service;
	
	@Cacheable(value = "RoleResourceTab")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<RoleResourceTab> get(Long id) {
        ResponseDataModel<RoleResourceTab> responseModel = new ResponseDataModel<>();
        try {
            RoleResourceTab entity=service.getRoleResourceTab(id);
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
	
	@Cacheable(value = "RoleResourceTab")
    @GetMapping(value = "getListByPage/{currentPage}/{itemsPerPage}")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataPageListModel<RoleResourceTab> getListByPage(@PathVariable int currentPage, @PathVariable int itemsPerPage, @RequestParam(required = false) String param) {
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListModel<RoleResourceTab> responseModel = new ResponseDataPageListModel<RoleResourceTab>();
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
        RoleResourceTabExample example = new RoleResourceTabExample();
        
        PageInfo<RoleResourceTab> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setMatchedTotal(page.getTotal());
        responseModel.setResultSet(page.getList());
        return responseModel;
    }
    
    @Cacheable(value = "RoleResourceTab")
    @GetMapping(value = "getList")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataListModel<RoleResourceTab> getList(@RequestParam(required = false) String param) {
        logger.info("param:{}", param);
        ResponseDataListModel<RoleResourceTab> responseModel = new ResponseDataListModel<RoleResourceTab>();
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
        RoleResourceTabExample example = new RoleResourceTabExample();
        
        List<RoleResourceTab> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        return responseModel;
    }
	
	@CachePut(value = "RoleResourceTab", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel add(@RequestBody RoleResourceTab model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            RoleResourceTab record = new RoleResourceTab();
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
	
	@CachePut(value = "RoleResourceTab", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel update(@RequestBody RoleResourceTab model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            RoleResourceTab record = new RoleResourceTab();
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

	@CacheEvict(value = "RoleResourceTab")
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