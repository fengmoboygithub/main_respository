package com.company.projecttypeinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import javax.servlet.http.HttpServletRequest;
import com.company.projecttypeinfo.model.ProjectTypeInfo;
import com.company.projecttypeinfo.model.ProjectTypeInfoExample;
import com.company.projecttypeinfo.model.ProjectTypeInfoExample.Criteria;
import com.company.base.exception.BaseException;
import com.company.projecttypeinfo.service.ProjectTypeInfoService;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.utils.ListUtil;
import com.company.constant.BaseConstant;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 	项目类型信息
 * Controller类
 *
 */
@Api(value="项目类型信息数据维护",tags={"项目类型信息数据操作接口"})
@RestController("ProjectTypeInfoController")
@RequestMapping("/api/ProjectTypeInfo")
public class ProjectTypeInfoController {

    public static Logger logger = LoggerFactory.getLogger(ProjectTypeInfoController.class);

    @Autowired
    private ProjectTypeInfoService<ProjectTypeInfo, ProjectTypeInfoExample> service;

    /**
     * 	项目类型名称查询唯一性
     */
    @ApiOperation("项目类型名称查询唯一性")
    @PostMapping(value = "/getTypeNameForOnly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<Boolean> getTypeNameForOnly(
            @RequestParam(required = true) @ApiParam(name="typename",value="项目类型名称",required=true) String typename,
            @RequestParam(required = false) @ApiParam(name="id",value="项目类型Id",required=false) String id
    ) {
        ResponseDataModel<Boolean> responseModel = new ResponseDataModel<Boolean>();
        try {
            Boolean entity = false;
            ProjectTypeInfoExample example = new ProjectTypeInfoExample();
            Criteria criteria = example.createCriteria();
            criteria.andTypenameEqualTo(typename);
            if(!StringUtils.isEmpty(id)){
                criteria.andIdNotEqualTo(id);
            }
            long count = service.countByExample(example);
            responseModel.setSuccess(true);
            if(count > 0){
                entity = true;
            }
            responseModel.setEntity(entity);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("查询成功");
        return responseModel;
    }
	
	/**
	 * 	项目类型信息查询详情
	 */
	@ApiOperation("项目类型信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectTypeInfo> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<ProjectTypeInfo> responseModel = new ResponseDataModel<>();
        try {
            ProjectTypeInfo entity = service.get(id);
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
	 * 	项目类型信息分页查询
	 */
	@ApiOperation("分页查询项目类型信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ProjectTypeInfo> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="typename",value="项目类型名称",required=false) String typename
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},typename:{}", currentPage, itemsPerPage, typename);
        ResponseDataPageListForBootModel<ProjectTypeInfo> responseModel = new ResponseDataPageListForBootModel<ProjectTypeInfo>();
        
		try {
            ProjectTypeInfoExample example = new ProjectTypeInfoExample();
            //按主键倒序 查询
            example.setOrderByClause("id desc");
            Criteria criteria = example.createCriteria();
            
            //若主键不为空
            if (!StringUtils.isEmpty(typename)) {
            	criteria.andTypenameLike("%"+typename+"%");
            }
        	PageInfo<ProjectTypeInfo> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	项目类型信息添加数据
	 */
	@ApiOperation("添加项目类型信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectTypeInfo> add(@RequestBody @ApiParam(name="项目类型信息对象",value="传入json格式",required=true) ProjectTypeInfo model,HttpServletRequest request) {
        ResponseDataModel<ProjectTypeInfo> responseModel = new ResponseDataModel<ProjectTypeInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProjectTypeInfo record = new ProjectTypeInfo();
            BeanUtils.copyProperties(model, record);
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
	 * 	项目类型信息修改数据
	 */
	@ApiOperation("修改项目类型信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectTypeInfo> update(@RequestBody @ApiParam(name="项目类型信息对象",value="传入json格式",required=true) ProjectTypeInfo model,HttpServletRequest request) {
        ResponseDataModel<ProjectTypeInfo> responseModel = new ResponseDataModel<ProjectTypeInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProjectTypeInfo record = new ProjectTypeInfo();
            BeanUtils.copyProperties(model, record);
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
     * 	项目类型信息删除数据
     */
    @ApiOperation("删除项目类型信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
            @ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    ) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
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