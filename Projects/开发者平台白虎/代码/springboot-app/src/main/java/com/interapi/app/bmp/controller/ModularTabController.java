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
import com.interapi.app.bmp.model.ModularTab;
import com.interapi.app.bmp.model.ModularTabExample;
import com.interapi.app.bmp.service.ModularTabService;
import com.interapi.app.bmp.bean.ResponseDataModel;
import com.interapi.app.bmp.bean.ResponseModel;
import com.interapi.app.bmp.bean.ResponseDataListModel;
import com.interapi.app.bmp.bean.ResponseDataPageListModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController("ModularTabController")
@RequestMapping("/api/ModularTab")
public class ModularTabController {

    public static Logger logger = LoggerFactory.getLogger(ModularTabController.class);

    @Autowired
    private ModularTabService service;
	
	@Cacheable(value = "ModularTab")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ModularTab> get(Long id) {
        ResponseDataModel<ModularTab> responseModel = new ResponseDataModel<>();
        try {
            ModularTab entity=service.getModularTab(id);
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
	
	@Cacheable(value = "ModularTab")
    @GetMapping(value = "getListByPage/{currentPage}/{itemsPerPage}")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataPageListModel<ModularTab> getListByPage(@PathVariable int currentPage, @PathVariable int itemsPerPage, @RequestParam(required = false) String param) {
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListModel<ModularTab> responseModel = new ResponseDataPageListModel<ModularTab>();
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
        ModularTabExample example = new ModularTabExample();
        
        PageInfo<ModularTab> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setMatchedTotal(page.getTotal());
        responseModel.setResultSet(page.getList());
        return responseModel;
    }
    
    @Cacheable(value = "ModularTab")
    @GetMapping(value = "getList")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataListModel<ModularTab> getList(@RequestParam(required = false) String param) {
        logger.info("param:{}", param);
        ResponseDataListModel<ModularTab> responseModel = new ResponseDataListModel<ModularTab>();
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
        ModularTabExample example = new ModularTabExample();
        
        List<ModularTab> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        return responseModel;
    }
	
	@CachePut(value = "ModularTab", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel add(@RequestBody ModularTab model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            ModularTab record = new ModularTab();
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
	
	@CachePut(value = "ModularTab", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel update(@RequestBody ModularTab model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            ModularTab record = new ModularTab();
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

	@CacheEvict(value = "ModularTab")
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