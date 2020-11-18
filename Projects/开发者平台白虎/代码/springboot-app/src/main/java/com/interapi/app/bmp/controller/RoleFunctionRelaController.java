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
import com.interapi.app.bmp.model.RoleFunctionRela;
import com.interapi.app.bmp.model.RoleFunctionRelaExample;
import com.interapi.app.bmp.service.RoleFunctionRelaService;
import com.interapi.app.bmp.bean.ResponseDataModel;
import com.interapi.app.bmp.bean.ResponseModel;
import com.interapi.app.bmp.bean.ResponseDataListModel;
import com.interapi.app.bmp.bean.ResponseDataPageListModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController("RoleFunctionRelaController")
@RequestMapping("/api/RoleFunctionRela")
public class RoleFunctionRelaController {

    public static Logger logger = LoggerFactory.getLogger(RoleFunctionRelaController.class);

    @Autowired
    private RoleFunctionRelaService service;
	
	@Cacheable(value = "RoleFunctionRela")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<RoleFunctionRela> get(Long id) {
        ResponseDataModel<RoleFunctionRela> responseModel = new ResponseDataModel<>();
        try {
            RoleFunctionRela entity=service.getRoleFunctionRela(id);
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
	
	@Cacheable(value = "RoleFunctionRela")
    @GetMapping(value = "getListByPage/{currentPage}/{itemsPerPage}")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataPageListModel<RoleFunctionRela> getListByPage(@PathVariable int currentPage, @PathVariable int itemsPerPage, @RequestParam(required = false) String param) {
        logger.info("currentPage:{},itemsPerPage:{},param:{}", currentPage, itemsPerPage, param);
        ResponseDataPageListModel<RoleFunctionRela> responseModel = new ResponseDataPageListModel<RoleFunctionRela>();
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
        RoleFunctionRelaExample example = new RoleFunctionRelaExample();
        
        PageInfo<RoleFunctionRela> page = service.getListByPage(currentPage, itemsPerPage, example);
        responseModel.setSuccess(true);
        responseModel.setPageIndex(currentPage);
        responseModel.setPageSize(itemsPerPage);
        responseModel.setMatchedTotal(page.getTotal());
        responseModel.setResultSet(page.getList());
        return responseModel;
    }
    
    @Cacheable(value = "RoleFunctionRela")
    @GetMapping(value = "getList")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseDataListModel<RoleFunctionRela> getList(@RequestParam(required = false) String param) {
        logger.info("param:{}", param);
        ResponseDataListModel<RoleFunctionRela> responseModel = new ResponseDataListModel<RoleFunctionRela>();
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
        RoleFunctionRelaExample example = new RoleFunctionRelaExample();
        
        List<RoleFunctionRela> list = service.getList(example);
        responseModel.setSuccess(true);
        responseModel.setList(list);
        return responseModel;
    }
	
	@CachePut(value = "RoleFunctionRela", key = "#root.caches[0].name + ':' + #model.id")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel add(@RequestBody RoleFunctionRela model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            RoleFunctionRela record = new RoleFunctionRela();
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
	
	@CachePut(value = "RoleFunctionRela", key = "#root.caches[0].name + ':' + #model.id")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel update(@RequestBody RoleFunctionRela model) {
        ResponseModel responseModel = new ResponseModel();
        try {
            RoleFunctionRela record = new RoleFunctionRela();
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

	@CacheEvict(value = "RoleFunctionRela")
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