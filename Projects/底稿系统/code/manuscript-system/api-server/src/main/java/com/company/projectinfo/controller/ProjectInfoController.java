package com.company.projectinfo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.constant.BaseConstant;
import com.company.enums.DataPermission;
import com.company.enums.ProjectInfoStatus;
import com.company.processnodeinfo.service.ProcessNodeInfoService;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.model.ProjectInfoExample;
import com.company.projectinfo.model.ProjectInfoExample.Criteria;
import com.company.projectinfo.service.ProjectInfoService;
import com.company.projectinfo.view.DealtInfo;
import com.company.projectstageinfo.model.ProjectStageInfoExample;
import com.company.utils.DateUtils;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;

/**
 * 	项目信息
 * Controller类
 *
 */
@Api(value="项目信息数据维护",tags={"项目信息数据操作接口"})
@RestController("ProjectInfoController")
@RequestMapping("/api/ProjectInfo")
public class ProjectInfoController{

    public static Logger logger = LoggerFactory.getLogger(ProjectInfoController.class);

    @Autowired
    private ProjectInfoService<ProjectInfo, ProjectInfoExample> service;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ProcessNodeInfoService processNodeInfoService;


    /**
     * 	待办信息分页查询
     */
    @ApiOperation("分页查询待办信息数据")
    @PostMapping(value = "/getListByPageForDealt", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<DealtInfo> getListByPageForDealt(
            @RequestParam(required = true) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage,
            @RequestParam(required = true) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
            HttpServletRequest request,
            HttpServletResponse response
    )  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{}", currentPage, itemsPerPage);
        ResponseDataPageListForBootModel<DealtInfo> responseModel = new ResponseDataPageListForBootModel<DealtInfo>();
        String userId = request.getHeader("userId");
        logger.info("userId："+userId);
        String dataPermission = "";
        try {
            //通过usdid获取数据权限
            if(!StringUtils.isEmpty(userId)){
                if(redisUtil.hasKey(String.valueOf(userId))){
                    dataPermission = redisUtil.get(String.valueOf(userId));
                    logger.info(String.valueOf(userId) + "的数据权限为:"+dataPermission);
                }else{
                    responseModel.setSuccess(false);
                    responseModel.setMessage("Fail:" + "无法获取数据权限信息");
                    responseModel.setCode(HttpStatus.UNAUTHORIZED.value());
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    logger.error("Fail:无法获取数据权限信息");
                    return responseModel;
                }
            }
            ProjectInfoExample example = new ProjectInfoExample();
            //按创建时间倒序 查询
            example.setOrderByClause("CREATE_TIME desc");
            Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(dataPermission)) {
                //数据权限条件
                JSONArray jsonArray = JSONArray.parseArray(dataPermission);
                if(jsonArray != null){
                    for(int i=0;i<jsonArray.size();i++){
                        JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                        String name = jsonObject.get("name").toString();
                        String [] value = jsonObject.get("value").toString().split(",");
                        //根据name去拼写sql条件
                        if(value.length>0){
                            if(DataPermission.PROJECT.getCode().equals(name)){
                                criteria.andIdIn(Arrays.asList(value));
                            }
                        }else{
                            responseModel.setSuccess(true);
                            responseModel.setPageIndex(currentPage);
                            responseModel.setPageSize(itemsPerPage);
                            responseModel.setRecordsTotal(0);
                            responseModel.setData(null);
                            responseModel.setRecordsFiltered(0);
                            responseModel.setMessage("分页查询成功");
                            return responseModel;
                        }
                    }
                }else{
                    responseModel.setSuccess(true);
                    responseModel.setPageIndex(currentPage);
                    responseModel.setPageSize(itemsPerPage);
                    responseModel.setRecordsTotal(0);
                    responseModel.setData(null);
                    responseModel.setRecordsFiltered(0);
                    responseModel.setMessage("分页查询成功");
                    return responseModel;
                }
            }
            criteria.andStatusEqualTo(ProjectInfoStatus.NORMAL.getCode());
            PageInfo<DealtInfo> page = service.getListByPageForDealt(currentPage, itemsPerPage, example);
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
	 * 	项目信息查询详情
	 */
	@ApiOperation("项目信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectInfo> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<ProjectInfo> responseModel = new ResponseDataModel<>();
        try {
            ProjectInfo entity = service.get(id);
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
	 * 	项目信息分页查询
	 */
	@ApiOperation("分页查询项目信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ProjectInfo> getListByPage(
    		@RequestParam(required = true) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage,
    		@RequestParam(required = true) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
            @RequestParam(required = true) @ApiParam(name="status",value="项目状态",required=true) String status,
    		@RequestParam(required = false) @ApiParam(name="projectName",value="项目名称",required=false) String projectName,
            @RequestParam(required = false) @ApiParam(name="projectType",value="项目类型",required=false) String projectType,
            @RequestParam(required = false) @ApiParam(name="projectStage",value="项目阶段",required=false) String projectStage,
            @RequestParam(required = false) @ApiParam(name="beginDate",value="开始时间",required=false) String beginDate,
            @RequestParam(required = false) @ApiParam(name="endDate",value="结束时间",required=false) String endDate,
//            @RequestParam(required = false) @ApiParam(name="userId",value="用户id",required=false) String userId,
            HttpServletRequest request,
            HttpServletResponse response
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},projectName:{},projectType:{},projectStage:{},beginDate:{},endDate:{},userId:{}", currentPage, itemsPerPage, projectName, projectType, projectStage, beginDate, endDate);
        ResponseDataPageListForBootModel<ProjectInfo> responseModel = new ResponseDataPageListForBootModel<ProjectInfo>();
//        Map<String, Object> headerMap = new HashMap<String, Object>();
//        Enumeration<?> er = request.getHeaderNames();//获取请求头的所有name值
//        String headerName;
//        while(er.hasMoreElements()){
//            headerName = er.nextElement().toString();
//            headerMap.put(headerName, request.getHeader(headerName));
//            logger.info(request.getHeader(headerName));
//        }
        String userId = request.getHeader("userId");
        logger.info("userId："+userId);
        String dataPermission = "";
		try {
		    //通过usdid获取数据权限
            if(!StringUtils.isEmpty(userId)){
                if(redisUtil.hasKey(String.valueOf(userId))){
                    dataPermission = redisUtil.get(String.valueOf(userId));
                    logger.info(String.valueOf(userId) + "的数据权限为:"+dataPermission);
                }else{
                    responseModel.setSuccess(false);
                    responseModel.setMessage("Fail:" + "无法获取数据权限信息");
                    responseModel.setCode(HttpStatus.UNAUTHORIZED.value());
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    logger.error("Fail:无法获取数据权限信息");
                    return responseModel;
                }
            }
//            Object object = getDataPermission(userId,responseModel,response);
////            if(object instanceof String){
////                dataPermission = (String)object;
////            }else if (object instanceof ResponseDataPageListForBootModel){
////                return (ResponseDataPageListForBootModel)object;
////            }
            ProjectInfoExample example = new ProjectInfoExample();
            //按主键倒序 查询
            example.setOrderByClause("CREATE_TIME desc");
            Criteria criteria = example.createCriteria();

            if (!StringUtils.isEmpty(dataPermission)) {
                //数据权限条件
                JSONArray jsonArray = JSONArray.parseArray(dataPermission);
                if(jsonArray != null){
                    for(int i=0;i<jsonArray.size();i++){
                        JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                        String name = jsonObject.get("name").toString();
                        String [] value = jsonObject.get("value").toString().split(",");
                        //根据name去拼写sql条件
                        if(value.length>0){
                            if(DataPermission.PROJECT.getCode().equals(name)){
                                criteria.andIdIn(Arrays.asList(value));
                            }
                        }else{
                            responseModel.setSuccess(true);
                            responseModel.setPageIndex(currentPage);
                            responseModel.setPageSize(itemsPerPage);
                            responseModel.setRecordsTotal(0);
                            responseModel.setData(null);
                            responseModel.setRecordsFiltered(0);
                            responseModel.setMessage("分页查询成功");
                            return responseModel;
                        }
                    }
                }else{
                    responseModel.setSuccess(true);
                    responseModel.setPageIndex(currentPage);
                    responseModel.setPageSize(itemsPerPage);
                    responseModel.setRecordsTotal(0);
                    responseModel.setData(null);
                    responseModel.setRecordsFiltered(0);
                    responseModel.setMessage("分页查询成功");
                    return responseModel;
                }
            }
            //项目状态
            criteria.andStatusEqualTo(status);
            //若项目名称不为空
            if (!StringUtils.isEmpty(projectName)) {
            	criteria.andProjectnameLike("%"+projectName+"%");
            }
            //若项目类型不为空
            if (!StringUtils.isEmpty(projectType)) {
                criteria.andProjecttypeEqualTo(projectType);
            }
            //若项目阶段不为空
            if (!StringUtils.isEmpty(projectStage)) {
                criteria.andStageEqualTo(projectStage);
            }
            //若开始时间不为空
            logger.info("beginDate:{}", beginDate);
            if (!StringUtils.isEmpty(beginDate)) {
                criteria.andBegindateLessThanOrEqualTo(DateUtils.stringToDate(beginDate));
            }
            //若结束时间不为空
            logger.info("endDate:{}", endDate);
            if (!StringUtils.isEmpty(endDate)) {
                criteria.andEnddateGreaterThanOrEqualTo(DateUtils.stringToDate(endDate));
            }
        	PageInfo<ProjectInfo> page = service.getListByPage(currentPage, itemsPerPage, example);
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
     * 	同一项目下项目名称或编号查询唯一性
     */
    @ApiOperation("同一项目下项目名称或编号查询唯一性")
    @PostMapping(value = "/getProjectForOnly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<Boolean> getProjectForOnly(
            @RequestParam(required = false) @ApiParam(name="projectname",value="项目名称",required=false) String projectname,
            @RequestParam(required = false) @ApiParam(name="projectno",value="项目编号",required=false) String projectno,
            @RequestParam(required = false) @ApiParam(name="idCurr",value="项目主键ID",required=false) String idCurr
    ) {
        ResponseDataModel<Boolean> responseModel = new ResponseDataModel<Boolean>();
        try {
            Boolean entity = false;
            ProjectInfoExample example = new ProjectInfoExample();
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(projectname)){
                criteria.andProjectnameEqualTo(projectname);
            }
            if(!StringUtils.isEmpty(projectno)){
                criteria.andProjectnoEqualTo(projectno);
            }
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
	 * 	项目信息添加数据
	 */
	@ApiOperation("添加项目信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectInfo> add(@RequestBody @ApiParam(name="项目信息对象",value="传入json格式",required=true) ProjectInfo model,HttpServletRequest request) {
        ResponseDataModel<ProjectInfo> responseModel = new ResponseDataModel<ProjectInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProjectInfo record = new ProjectInfo();
            BeanUtils.copyProperties(model, record);
            record.setStatus(ProjectInfoStatus.NORMAL.getCode());
            record.setCreateTime(new Date());
            String userId = request.getHeader("userId");
            String rolelist = request.getHeader("rolelist");
            if (!StringUtils.isEmpty(userId)) {
                record.setUserId(userId);
            }
            if (!StringUtils.isEmpty(rolelist)) {
                record.setRoleList(rolelist);
            }
            service.saveForMe(record);
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
	 * 	项目信息修改数据
	 */
	@ApiOperation("修改项目信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectInfo> update(@RequestBody @ApiParam(name="项目信息对象",value="传入json格式",required=true) ProjectInfo model,HttpServletRequest request) {
        ResponseDataModel<ProjectInfo> responseModel = new ResponseDataModel<ProjectInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProjectInfo record = new ProjectInfo();
            BeanUtils.copyProperties(model, record);
            service.editForMe(record);
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

//    @ApiOperation("测试redis设置值")
//    @PutMapping(value = "/testRedis", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseDataModel<ProjectInfo> testRedis(HttpServletRequest request) {
//        ResponseDataModel<ProjectInfo> responseModel = new ResponseDataModel<ProjectInfo>();
//        try {
////            String userId = UUID.randomUUID().toString().replace("-","");
////            String userId = "93928";
////            logger.info("userId："+ userId);
////            JSONArray jsonArray = new JSONArray();
////            JSONObject jsonObject = new JSONObject();
////            jsonObject.put("name","project");
////            jsonObject.put("value","c9c70c4d82964f049339a7458670e760,e55f6c38213040c0a858e29a34c0df25");
////            jsonArray.add(jsonObject);
////            redisUtil.set(userId, jsonArray.toString());
////            ProcessNodeInfo processNodeInfo = processNodeInfoService.getNextProcessNode("","");
//            logger.info("1111");
//        } catch (Exception e) {
//            responseModel.setSuccess(false);
//            responseModel.setMessage("Fail:" + e.getMessage());
//            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            logger.error("Fail:", e);
//            return responseModel;
//        }
//        responseModel.setSuccess(true);
//        responseModel.setMessage("编辑成功");
//        return responseModel;
//    }
}