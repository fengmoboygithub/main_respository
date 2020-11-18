package com.company.internalauditreviewresult.controller;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.constant.BaseConstant;
import com.company.internalauditreviewresult.model.InternalAuditReviewResult;
import com.company.internalauditreviewresult.model.InternalAuditReviewResultExample;
import com.company.internalauditreviewresult.model.InternalAuditReviewResultExample.Criteria;
import com.company.internalauditreviewresult.service.InternalAuditReviewResultService;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.service.ProjectInfoService;
import com.company.utils.ListUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 	内核审议结果信息
 * Controller类
 *
 */
@Api(value="内核审议结果信息数据维护",tags={"内核审议结果信息数据操作接口"})
@RestController("InternalAuditReviewResultController")
@RequestMapping("/api/InternalAuditReviewResult")
public class InternalAuditReviewResultController {

    public static Logger logger = LoggerFactory.getLogger(InternalAuditReviewResultController.class);

    @Autowired
    private InternalAuditReviewResultService<InternalAuditReviewResult, InternalAuditReviewResultExample> service;

    @Autowired
    private ProjectInfoService projectInfoService;

    @Autowired
    private TaskService taskService;
	
	/**
	 * 	内核审议结果信息查询详情
	 */
	@ApiOperation("内核审议结果信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<InternalAuditReviewResult> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<InternalAuditReviewResult> responseModel = new ResponseDataModel<>();
        try {
            InternalAuditReviewResult entity = service.get(id);
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
	 * 	内核审议结果信息分页查询
	 */
	@ApiOperation("分页查询内核审议结果信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<InternalAuditReviewResult> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="projectId",value="项目id",required=true) String projectId
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},projectId:{}", currentPage, itemsPerPage, projectId);
        ResponseDataPageListForBootModel<InternalAuditReviewResult> responseModel = new ResponseDataPageListForBootModel<InternalAuditReviewResult>();
        
		try {
            InternalAuditReviewResultExample example = new InternalAuditReviewResultExample();
            //按主键倒序 查询
            example.setOrderByClause("create_Time desc");
            Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            
            //若主键不为空
            if (!StringUtils.isEmpty(projectId)) {
            	criteria.andProjectidEqualTo(projectId);
            }
        	PageInfo<InternalAuditReviewResult> page = service.getListByPageWithBlobs(currentPage, itemsPerPage, example);
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
	 * 	内核审议结果信息添加数据
	 */
	@ApiOperation("添加内核审议结果信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<InternalAuditReviewResult> add(
            @RequestParam @ApiParam(name="isagree",value="是否同意",required=true) String isagree,
            @RequestParam @ApiParam(name="contents",value="意见内容",required=true) String contents,
            @RequestParam @ApiParam(name="projectId",value="项目id",required=true) String projectId,
            @RequestParam @ApiParam(name="projectstage",value="当前阶段",required=true) String projectstage,
//            @RequestParam @ApiParam(name="taskId",value="任务id",required=true) String taskId,
            HttpServletRequest request) {
        ResponseDataModel<InternalAuditReviewResult> responseModel = new ResponseDataModel<InternalAuditReviewResult>();
        String userId = request.getHeader("userId");
        String userName = request.getHeader("userName");
        try {
            userName = URLDecoder.decode(userName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ProjectInfo entity = new ProjectInfo();
        try {
            entity = (ProjectInfo) projectInfoService.get(projectId);
            if(!projectstage.equals(entity.getStage())){
                responseModel.setSuccess(true);
                responseModel.setMessage("项目阶段已发生改变！");
                return responseModel;
            }
        } catch (BaseException e) {
            responseModel.setSuccess(false);
            responseModel.setMessage(e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }

        //需要验证当前用户是否还有任务
        List<Task> list = taskService// 与正在执行的任务管理相关的Service
                .createTaskQuery()// 创建任务查询对象
                /** 查询条件（where部分） */
                .taskAssignee(userId)// 指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
//						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
                .processInstanceId(entity.getProcessInstanceId())//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
                /** 排序 */
                .orderByTaskCreateTime().asc()// 使用创建时间的升序排列
                /** 返回结果集 */
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
                .list();// 返回列表

        if(list.size()==0){
            responseModel.setSuccess(true);
            responseModel.setMessage("内核意见已提交！");
            return responseModel;
        }
        try {
            InternalAuditReviewResult record = new InternalAuditReviewResult();
            record.setIsagree(isagree);
            record.setContents(contents);
            record.setProjectid(projectId);
            record.setProjectstage(projectstage);
			record.setCreateTime(new Date());
			record.setCreateUser(userName);
            record.setIsDelete(BaseConstant.DEL_FLAG_NO);
            //默认一个用户在一个流程实例里只有一个待办任务
            service.saveInternalAuditReviewResult(record,list.get(0).getId());
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
	 * 	内核审议结果信息修改数据
	 */
	@ApiOperation("修改内核审议结果信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<InternalAuditReviewResult> update(@RequestBody @ApiParam(name="内核审议结果信息对象",value="传入json格式",required=true) InternalAuditReviewResult model,HttpServletRequest request) {
        ResponseDataModel<InternalAuditReviewResult> responseModel = new ResponseDataModel<InternalAuditReviewResult>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            InternalAuditReviewResult record = new InternalAuditReviewResult();
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
	 * 	内核审议结果信息删除数据
	 */
	@ApiOperation("删除内核审议结果信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	InternalAuditReviewResult record = new InternalAuditReviewResult();
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
	 * 	内核审议结果信息批量删除数据
	 */
	@ApiOperation("批量删除内核审议结果信息数据")
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