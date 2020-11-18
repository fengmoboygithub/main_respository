package com.company.projectstageinfo.controller;

import com.company.bean.ResponseDataListModel;
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
import com.company.projectstageinfo.model.ProjectStageInfo;
import com.company.projectstageinfo.model.ProjectStageInfoExample;
import com.company.projectstageinfo.model.ProjectStageInfoExample.Criteria;
import com.company.base.exception.BaseException;
import com.company.projectstageinfo.service.ProjectStageInfoService;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.constant.BaseConstant;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 	项目阶段信息
 * Controller类
 *
 */
@Api(value="项目阶段信息数据维护",tags={"项目阶段信息数据操作接口"})
@RestController("ProjectStageInfoController")
@RequestMapping("/api/ProjectStageInfo")
public class ProjectStageInfoController {

    public static Logger logger = LoggerFactory.getLogger(ProjectStageInfoController.class);

    @Autowired
    private ProjectStageInfoService<ProjectStageInfo, ProjectStageInfoExample> service;

    /**
     * 	同一项目类型下项目阶段ID查询唯一性
     */
    @ApiOperation("同一项目类型下项目阶段ID查询唯一性")
    @PostMapping(value = "/getStageNameForOnly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<Boolean> getStageNameForOnly(
            @RequestParam(required = true) @ApiParam(name="stagename",value="项目阶段名称",required=true) String stagename,
            @RequestParam(required = true) @ApiParam(name="projecttype",value="项目类型",required=true) String projecttype,
            @RequestParam(required = false) @ApiParam(name="idCurr",value="项目阶段主键ID",required=false) String idCurr
    ) {
        ResponseDataModel<Boolean> responseModel = new ResponseDataModel<Boolean>();
        try {
            Boolean entity = false;
            ProjectStageInfoExample example = new ProjectStageInfoExample();
            Criteria criteria = example.createCriteria();
            criteria.andStagenameEqualTo(stagename);
            criteria.andProjecttypeEqualTo(projecttype);
            if(!StringUtils.isEmpty(idCurr)){
                criteria.andIdNotEqualTo(idCurr);
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
     * 	同一项目类型下项目阶段ID查询唯一性
     */
    @ApiOperation("同一项目类型下项目阶段ID查询唯一性")
    @PostMapping(value = "/getStageIdForOnly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<Boolean> getStageIdForOnly(
            @RequestParam(required = true) @ApiParam(name="projectstage",value="项目阶段值",required=true) String projectstage,
            @RequestParam(required = true) @ApiParam(name="projecttype",value="项目类型",required=true) String projecttype,
            @RequestParam(required = false) @ApiParam(name="idCurr",value="项目阶段主键ID",required=false) String idCurr
    ) {
        ResponseDataModel<Boolean> responseModel = new ResponseDataModel<Boolean>();
        try {
            Boolean entity = false;
            ProjectStageInfoExample example = new ProjectStageInfoExample();
            Criteria criteria = example.createCriteria();
            criteria.andProjectstageEqualTo(projectstage);
            criteria.andProjecttypeEqualTo(projecttype);
            if(!StringUtils.isEmpty(idCurr)){
                criteria.andIdNotEqualTo(idCurr);
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
	 * 	项目阶段信息查询详情
	 */
	@ApiOperation("项目阶段信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectStageInfo> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="项目阶段ID",required=true) String id
    	) {
        ResponseDataModel<ProjectStageInfo> responseModel = new ResponseDataModel<>();
        try {
            ProjectStageInfo entity = service.get(id);
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
     * 	根据项目类型查询最小项目阶段信息
     */
    @ApiOperation("根据项目类型查询最小项目阶段信息")
    @PostMapping(value = "/getListByMin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataListModel<ProjectStageInfo> getListByMin(
            @RequestParam(required = true) @ApiParam(name="projecttype",value="项目类型",required=true) String projecttype
    )  throws BaseException{
        logger.info("projecttype:{}", projecttype);
        ResponseDataListModel<ProjectStageInfo> responseModel = new ResponseDataListModel<ProjectStageInfo>();
        try {
            ProjectStageInfoExample example = new ProjectStageInfoExample();
            //按主键倒序 查询
            example.setOrderByClause("projectstage asc");
            Criteria criteria = example.createCriteria();
            criteria.andProjecttypeEqualTo(projecttype);
            List<ProjectStageInfo> list1 = service.select(null, example);
            List<ProjectStageInfo> list = new ArrayList<ProjectStageInfo>();
            int count = 0;
            for(ProjectStageInfo pi : list1){
                if(count == 0){
                    list.add(pi);
                    break;
                }
            }
            responseModel.setSuccess(true);
            responseModel.setList(list);
            responseModel.setMessage("查询成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            responseModel.setSuccess(false);
            responseModel.setMessage("失败:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        return responseModel;
    }
	
	/**
	 * 	项目阶段信息分页查询
	 */
	@ApiOperation("分页查询项目阶段信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ProjectStageInfo> getListByPage(
    		@RequestParam(required = true) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage,
    		@RequestParam(required = true) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="projecttype",value="项目类型",required=false) String projecttype
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},projecttype:{}", currentPage, itemsPerPage, projecttype);
        ResponseDataPageListForBootModel<ProjectStageInfo> responseModel = new ResponseDataPageListForBootModel<ProjectStageInfo>();
        
		try {
            ProjectStageInfoExample example = new ProjectStageInfoExample();
            //按主键倒序 查询
            example.setOrderByClause("projectstage asc");
            Criteria criteria = example.createCriteria();
            
            //若主键不为空
            if (!StringUtils.isEmpty(projecttype)) {
            	criteria.andProjecttypeEqualTo(projecttype);
            }
        	PageInfo<ProjectStageInfo> page = service.getListByPage(currentPage, itemsPerPage, example);
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
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
		}
        return responseModel;
    }
    
	/**
	 * 	项目阶段信息添加数据
	 */
	@ApiOperation("添加项目阶段信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectStageInfo> add(@RequestBody @ApiParam(name="项目阶段信息对象",value="传入json格式",required=true) ProjectStageInfo model,HttpServletRequest request) {
        ResponseDataModel<ProjectStageInfo> responseModel = new ResponseDataModel<ProjectStageInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProjectStageInfo record = new ProjectStageInfo();
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
	 * 	项目阶段信息修改数据
	 */
	@ApiOperation("修改项目阶段信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectStageInfo> update(@RequestBody @ApiParam(name="项目阶段信息对象",value="传入json格式",required=true) ProjectStageInfo model,HttpServletRequest request) {
        ResponseDataModel<ProjectStageInfo> responseModel = new ResponseDataModel<ProjectStageInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProjectStageInfo record = new ProjectStageInfo();
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
     * 	项目阶段信息删除数据
     */
    @ApiOperation("删除项目阶段信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
            @RequestParam(required = true) @ApiParam(name="id",value="项目阶段ID",required=true) String id
    ) {
        ResponseModel responseModel = new ResponseModel();
        try {
            service.deleteForMe(id);
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