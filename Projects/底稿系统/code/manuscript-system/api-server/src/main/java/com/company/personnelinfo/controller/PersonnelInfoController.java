package com.company.personnelinfo.controller;

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
import com.company.personnelinfo.model.PersonnelInfo;
import com.company.personnelinfo.model.PersonnelInfoExample;
import com.company.personnelinfo.model.PersonnelInfoExample.Criteria;
import com.company.base.exception.BaseException;
import com.company.personnelinfo.service.PersonnelInfoService;
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
 * 	项目人员信息
 * Controller类
 *
 */
@Api(value="项目人员信息数据维护",tags={"项目人员信息数据操作接口"})
@RestController("PersonnelInfoController")
@RequestMapping("/api/PersonnelInfo")
public class PersonnelInfoController {

    public static Logger logger = LoggerFactory.getLogger(PersonnelInfoController.class);

    @Autowired
    private PersonnelInfoService<PersonnelInfo, PersonnelInfoExample> service;
	
	/**
	 * 	项目人员信息查询详情
	 */
	@ApiOperation("项目人员信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<PersonnelInfo> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<PersonnelInfo> responseModel = new ResponseDataModel<>();
        try {
            PersonnelInfo entity = service.get(id);
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
     * 	项目人员信息分页查询(从统一用户系统获取)
     */
    @ApiOperation("分页查询项目人员信息数据(从统一用户系统获取)")
    @PostMapping(value = "/getListByPageForUserSys", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<PersonnelInfo> getListByPageForUserSys(
            @RequestParam(required = true) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage,
            @RequestParam(required = true) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
            @RequestParam(required = false) @ApiParam(name="name",value="登录名称",required=false) String loginName
    )  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},roletype:{}name:{}", currentPage, itemsPerPage, loginName);
        ResponseDataPageListForBootModel<PersonnelInfo> responseModel = new ResponseDataPageListForBootModel<PersonnelInfo>();

        try {
            PageInfo<PersonnelInfo> page = service.getListByPageForUserSys(currentPage, itemsPerPage);
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
	 * 	项目人员信息分页查询
	 */
	@ApiOperation("分页查询项目人员信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<PersonnelInfo> getListByPage(
    		@RequestParam(required = true) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage,
    		@RequestParam(required = true) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
            @RequestParam(required = true) @ApiParam(name="roletype",value="角色类型",required=true) int roletype,
            @RequestParam(required = false) @ApiParam(name="name",value="名称",required=false) String name
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},roletype:{}name:{}", currentPage, itemsPerPage, roletype, name);
        ResponseDataPageListForBootModel<PersonnelInfo> responseModel = new ResponseDataPageListForBootModel<PersonnelInfo>();
        
		try {
            PersonnelInfoExample example = new PersonnelInfoExample();
            //按主键倒序 查询
            example.setOrderByClause("sortno asc");
            Criteria criteria = example.createCriteria();

            criteria.andRoletypeEqualTo(roletype);

            
            //若名称不为空
            if (!StringUtils.isEmpty(name)) {
            	criteria.andNameLike(name + "%");
            }
        	PageInfo<PersonnelInfo> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	项目人员信息添加数据
	 */
	@ApiOperation("添加项目人员信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<PersonnelInfo> add(@RequestBody @ApiParam(name="项目人员信息对象",value="传入json格式",required=true) PersonnelInfo model,HttpServletRequest request) {
        ResponseDataModel<PersonnelInfo> responseModel = new ResponseDataModel<PersonnelInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            PersonnelInfo record = new PersonnelInfo();
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
	 * 	项目人员信息修改数据
	 */
	@ApiOperation("修改项目人员信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<PersonnelInfo> update(@RequestBody @ApiParam(name="项目人员信息对象",value="传入json格式",required=true) PersonnelInfo model,HttpServletRequest request) {
        ResponseDataModel<PersonnelInfo> responseModel = new ResponseDataModel<PersonnelInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            PersonnelInfo record = new PersonnelInfo();
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
	 * 	项目人员信息删除数据
	 */
	@ApiOperation("删除项目人员信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	PersonnelInfo record = new PersonnelInfo();
            record.setId(id);
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

}