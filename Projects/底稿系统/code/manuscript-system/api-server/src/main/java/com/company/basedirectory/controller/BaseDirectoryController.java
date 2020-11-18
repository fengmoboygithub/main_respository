package com.company.basedirectory.controller;

import com.company.base.exception.BaseException;
import com.company.basedirectory.model.BaseDirectory;
import com.company.basedirectory.model.BaseDirectoryExample;
import com.company.basedirectory.model.BaseDirectoryExample.Criteria;
import com.company.basedirectory.service.BaseDirectoryService;
import com.company.bean.ResponseDataListModel;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.constant.BaseConstant;
import com.company.enums.ProjectDirectoryType;
import com.company.projectdirectory.view.ProjectDirectoryTree;
import com.company.utils.FileUtils;
import com.company.utils.RedisUtil;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 	基础目录信息
 * Controller类
 *
 */
@Api(value="基础目录信息数据维护",tags={"基础目录信息数据操作接口"})
@RestController("BaseDirectoryController")
@RequestMapping("/api/BaseDirectory")
public class BaseDirectoryController {

    public static Logger logger = LoggerFactory.getLogger(BaseDirectoryController.class);

    @Autowired
    private BaseDirectoryService<BaseDirectory, BaseDirectoryExample> service;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 	基础目录名称或简称查询唯一性
     */
    @ApiOperation("基础目录名称或简称查询唯一性")
    @PostMapping(value = "/getNameOrSnameForOnly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<Boolean> getNameOrSnameForOnly(
            @RequestParam(required = false) @ApiParam(name="projecttype",value="项目类型",required=false) String projecttype,
            @RequestParam(required = false) @ApiParam(name="parentid",value="父目录Id",required=false) String parentid,
            @RequestParam(required = false) @ApiParam(name="id",value="基础目录Id",required=false) String id,
            @RequestParam(required = false) @ApiParam(name="sname",value="目录简称",required=false) String sname,
            @RequestParam(required = false) @ApiParam(name="fullname",value="目录全称",required=false) String fullname
    ) {
        ResponseDataModel<Boolean> responseModel = new ResponseDataModel<Boolean>();
        try {
            Boolean entity = false;
            BaseDirectoryExample example = new BaseDirectoryExample();
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(projecttype)){
                criteria.andProjecttypeEqualTo(projecttype);
            }
            if(!StringUtils.isEmpty(parentid)){
                if("-1".equals(parentid)){
                    criteria.andParentidIsNull();
                } else {
                    criteria.andParentidEqualTo(parentid);
                }
            } else {
                criteria.andParentidIsNull();
            }
            if(!StringUtils.isEmpty(sname)){
                criteria.andSnameEqualTo(sname);
            }
            if(!StringUtils.isEmpty(fullname)){
                criteria.andFullnameEqualTo(fullname);
            }
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
	 * 	基础目录信息查询详情
	 */
	@ApiOperation("基础目录信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<BaseDirectory> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<BaseDirectory> responseModel = new ResponseDataModel<>();
        try {
            BaseDirectory entity = service.get(id);
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
     * 	基础目录树含底稿文件(全部)查询
     */
    @ApiOperation("基础目录树含底稿文件(全部)查询")
    @PostMapping(value = "/viewTreeForMe", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ProjectDirectoryTree> viewTree(
            @RequestParam(required = true) @ApiParam(name="projecttype",value="项目类型id",required=true) String projecttype,
            @RequestParam(required = true) @ApiParam(name="projectStage",value="项目阶段",required=true) String projectStage
    ) {
//        redisUtil.set("yang","[{\"name\":\"projectid\",\"value\":\"1,2,3,4,5,6\"},{\"name\":\"directory\",\"value\":\"1,2,3,4,5,6\"}]");
//        System.out.println(redisUtil.get("yang"));
        ResponseDataListModel<ProjectDirectoryTree> responseModel = new ResponseDataListModel<>();
        try {
            //基础目录树含底稿文件(全部)查询
            List<ProjectDirectoryTree> list = service.viewTreeForMe(projecttype, projectStage);

            responseModel.setSuccess(true);
            responseModel.setList(list);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            HashMap<String, String> errors = new HashMap<>();
            errors.put("Fail:", e.getLocalizedMessage());
            responseModel.setErrors(errors);
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("基础目录树查询成功");
        return responseModel;
    }
	
	/**
	 * 	基础目录信息分页查询
	 */
	@ApiOperation("分页查询基础目录信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<BaseDirectory> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="id",value="主键",required=true) String id
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},id:{}", currentPage, itemsPerPage, id);
        ResponseDataPageListForBootModel<BaseDirectory> responseModel = new ResponseDataPageListForBootModel<BaseDirectory>();
        
		try {
            BaseDirectoryExample example = new BaseDirectoryExample();
            //按主键倒序 查询
            example.setOrderByClause("id desc");
            Criteria criteria = example.createCriteria();
            
            //若主键不为空
            if (!StringUtils.isEmpty(id)) {
            	criteria.andIdEqualTo(id);
            }
        	PageInfo<BaseDirectory> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	基础目录信息添加数据
	 */
	@ApiOperation("添加基础目录信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<BaseDirectory> add(@RequestBody @ApiParam(name="基础目录信息对象",value="传入json格式",required=true) BaseDirectory model,HttpServletRequest request) {
        ResponseDataModel<BaseDirectory> responseModel = new ResponseDataModel<BaseDirectory>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            BaseDirectory record = new BaseDirectory();
            BeanUtils.copyProperties(model, record);
            String parentid = record.getParentid();
            if (StringUtils.isEmpty(parentid) || "-1".equals(parentid)) {
                record.setParentid(null);
            }
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
	 * 	基础目录信息修改数据
	 */
	@ApiOperation("修改基础目录信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<BaseDirectory> update(@RequestBody @ApiParam(name="基础目录信息对象",value="传入json格式",required=true) BaseDirectory model,HttpServletRequest request) {
        ResponseDataModel<BaseDirectory> responseModel = new ResponseDataModel<BaseDirectory>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            BaseDirectory record = new BaseDirectory();
            BeanUtils.copyProperties(model, record);
            String parentid = record.getParentid();
            String projectstage = record.getProjectstage();
            if (StringUtils.isEmpty(parentid) || "-1".equals(parentid)) {
                record.setParentid(null);
            }
            if (StringUtils.isEmpty(projectstage)) {
                record.setProjectstage(null);
            }
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
	 * 	基础目录信息删除数据
	 */
	@ApiOperation("删除基础目录信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            service.deleteForDeep(id);
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
     * 	导入基础目录信息数据
     */
    @ApiOperation("导入基础目录信息数据")
    @PostMapping(value = "/export", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<BaseDirectory> export(
//            @RequestParam(required = false) @ApiParam(name="projectId",value="项目id",required=true) String projectId,
            @RequestParam(required = false) @ApiParam(name="projectType",value="项目类型",required=true) String projectType,
            @RequestParam(name="file",required=true) @ApiParam(name="file",value="上传文件",required=true) MultipartFile file,
            HttpServletRequest request) {
        ResponseDataModel<BaseDirectory> responseModel = new ResponseDataModel<BaseDirectory>();
        try {
            service.export(FileUtils.multipartFileToFile(file),projectType);
//            responseModel.setEntity(record);
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
}