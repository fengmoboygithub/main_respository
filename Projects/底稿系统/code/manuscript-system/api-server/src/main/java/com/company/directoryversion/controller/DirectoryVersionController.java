package com.company.directoryversion.controller;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.constant.BaseConstant;
import com.company.directoryversion.model.DirectoryVersion;
import com.company.directoryversion.model.DirectoryVersionExample;
import com.company.directoryversion.model.DirectoryVersionExample.Criteria;
import com.company.directoryversion.service.DirectoryVersionService;
import com.company.utils.ListUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 	目录版本信息
 * Controller类
 *
 */
@Api(value="目录版本信息数据维护",tags={"目录版本信息数据操作接口"})
@RestController("DirectoryVersionController")
@RequestMapping("/api/DirectoryVersion")
public class DirectoryVersionController {

    public static Logger logger = LoggerFactory.getLogger(DirectoryVersionController.class);

    @Autowired
    private DirectoryVersionService<DirectoryVersion, DirectoryVersionExample> service;
	
	/**
	 * 	目录版本信息查询详情
	 */
	@ApiOperation("目录版本信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DirectoryVersion> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<DirectoryVersion> responseModel = new ResponseDataModel<>();
        try {
            DirectoryVersion entity = service.get(id);
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
	
	/**
	 * 	目录版本信息分页查询
	 */
	@ApiOperation("分页查询目录版本信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<DirectoryVersion> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="id",value="主键",required=true) String id
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},id:{}", currentPage, itemsPerPage, id);
        ResponseDataPageListForBootModel<DirectoryVersion> responseModel = new ResponseDataPageListForBootModel<DirectoryVersion>();
        
		try {
            DirectoryVersionExample example = new DirectoryVersionExample();
            //按主键倒序 查询
            example.setOrderByClause("id desc");
            Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            
            //若主键不为空
            if (!StringUtils.isEmpty(id)) {
            	criteria.andIdEqualTo(id);
            }
        	PageInfo<DirectoryVersion> page = service.getListByPage(currentPage, itemsPerPage, example);
        	responseModel.setSuccess(true);
        	responseModel.setPageIndex(currentPage);
        	responseModel.setPageSize(itemsPerPage);
        	responseModel.setRecordsTotal(page.getTotal());
        	responseModel.setData(page.getList());
        	responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
        	responseModel.setMessage("分页查询成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			responseModel.setSuccess(false);
            responseModel.setMessage("失败:" + e.getMessage());
            logger.error("Fail:", e);
            return responseModel;
		}
        return responseModel;
    }
    
	/**
	 * 	目录版本信息添加数据
	 */
	@ApiOperation("添加目录版本信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DirectoryVersion> add(@RequestBody @ApiParam(name="目录版本信息对象",value="传入json格式",required=true) DirectoryVersion model,HttpServletRequest request) {
        ResponseDataModel<DirectoryVersion> responseModel = new ResponseDataModel<DirectoryVersion>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            DirectoryVersion record = new DirectoryVersion();
            BeanUtils.copyProperties(model, record);
			record.setCreateTime(new Date());
//			record.setCreateUser(currUserId);
            record.setIsDelete(BaseConstant.DEL_FLAG_NO);
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
    
	/**
	 * 	目录版本信息修改数据
	 */
	@ApiOperation("修改目录版本信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DirectoryVersion> update(@RequestBody @ApiParam(name="目录版本信息对象",value="传入json格式",required=true) DirectoryVersion model,HttpServletRequest request) {
        ResponseDataModel<DirectoryVersion> responseModel = new ResponseDataModel<DirectoryVersion>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            DirectoryVersion record = new DirectoryVersion();
            BeanUtils.copyProperties(model, record);
			record.setUpdateTime(new Date());
//            record.setUpdateUser(currUserId);
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
	
	/**
	 * 	目录版本信息删除数据
	 */
	@ApiOperation("删除目录版本信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	DirectoryVersion record = new DirectoryVersion();
            record.setId(id);
            record.setIsDelete(BaseConstant.DEL_FLAG_YES);
            record.setUpdateTime(new Date());
//            record.setUpdateUser(currUserId);
            service.update(record);
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
    
    /**
	 * 	目录版本信息批量删除数据
	 */
	@ApiOperation("批量删除目录版本信息数据")
    @PostMapping(value = "/batchDel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel batchDel(@ApiParam(name="主键列表",value="传入json格式",required=false)String param) {
        ResponseModel responseModel = new ResponseModel();
        try {
            List<Map<String, Object>> list = ListUtil.toListMap(param);
        	if(list == null || list.size() == 0) {
        		throw new BaseException("传入参数list为空");
        	}
            service.batchDeleteByPrimaryKey(list);
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