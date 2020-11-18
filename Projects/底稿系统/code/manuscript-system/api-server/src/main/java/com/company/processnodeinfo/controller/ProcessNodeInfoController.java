package com.company.processnodeinfo.controller;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.constant.BaseConstant;
import com.company.directoryopinion.service.DirectoryOpinionService;
import com.company.enums.DirectoryOpinionType;
import com.company.processnodeinfo.model.ProcessModel;
import com.company.processnodeinfo.model.ProcessNodeInfo;
import com.company.processnodeinfo.model.ProcessNodeInfoExample;
import com.company.processnodeinfo.model.ProcessNodeInfoExample.Criteria;
import com.company.processnodeinfo.service.ProcessNodeInfoService;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.service.ProjectInfoService;
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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 	流程节点信息
 * Controller类
 *
 */
@Api(value="流程节点信息数据维护",tags={"流程节点信息数据操作接口"})
@RestController("ProcessNodeInfoController")
@RequestMapping("/api/ProcessNodeInfo")
public class ProcessNodeInfoController {

    public static Logger logger = LoggerFactory.getLogger(ProcessNodeInfoController.class);

    @Autowired
    private ProcessNodeInfoService<ProcessNodeInfo, ProcessNodeInfoExample> service;

    @Autowired
    private DirectoryOpinionService directoryOpinionService;

    @Autowired
    private ProjectInfoService projectInfoService;
	
	/**
	 * 	流程节点信息查询详情
	 */
	@ApiOperation("流程节点信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProcessNodeInfo> get(
    	@RequestParam(required = true) @ApiParam(name="processnode",value="主键",required=true) String processnode
    	) {
        ResponseDataModel<ProcessNodeInfo> responseModel = new ResponseDataModel<>();
        try {
            ProcessNodeInfo entity = service.get(processnode);
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
	 * 	流程节点信息分页查询
	 */
	@ApiOperation("分页查询流程节点信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ProcessNodeInfo> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="processnode",value="主键",required=true) String processnode
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},processnode:{}", currentPage, itemsPerPage, processnode);
        ResponseDataPageListForBootModel<ProcessNodeInfo> responseModel = new ResponseDataPageListForBootModel<ProcessNodeInfo>();
        
		try {
            ProcessNodeInfoExample example = new ProcessNodeInfoExample();
            //按主键倒序 查询
            example.setOrderByClause("processnode desc");
            Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            
            //若主键不为空
            if (!StringUtils.isEmpty(processnode)) {
            	criteria.andProcessnodeEqualTo(processnode);
            }
        	PageInfo<ProcessNodeInfo> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	流程节点信息添加数据
	 */
	@ApiOperation("添加流程节点信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProcessNodeInfo> add(@RequestBody @ApiParam(name="流程节点信息对象",value="传入json格式",required=true) ProcessNodeInfo model,HttpServletRequest request) {
        ResponseDataModel<ProcessNodeInfo> responseModel = new ResponseDataModel<ProcessNodeInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProcessNodeInfo record = new ProcessNodeInfo();
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
	 * 	流程节点信息修改数据
	 */
	@ApiOperation("修改流程节点信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProcessNodeInfo> update(@RequestBody @ApiParam(name="流程节点信息对象",value="传入json格式",required=true) ProcessNodeInfo model,HttpServletRequest request) {
        ResponseDataModel<ProcessNodeInfo> responseModel = new ResponseDataModel<ProcessNodeInfo>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProcessNodeInfo record = new ProcessNodeInfo();
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
	 * 	流程节点信息删除数据
	 */
	@ApiOperation("删除流程节点信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="processnode",value="主键",required=true) String processnode,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	ProcessNodeInfo record = new ProcessNodeInfo();
            record.setProcessnode(processnode);
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
	 * 	流程节点信息批量删除数据
	 */
	@ApiOperation("批量删除流程节点信息数据")
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


    /**
     * 	流程处理
     */
    @ApiOperation("流程处理")
    @PostMapping(value = "/updateProcess", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProcessNodeInfo> updateProcess(
            @RequestBody @ApiParam(name="流程处理对象信息",value="传入json格式",required=true) ProcessModel model,
//            @RequestParam @ApiParam(name="projectid",value="项目id",required=true) String projectid,
//            @RequestParam @ApiParam(name="projectStage",value="项目阶段",required=true) String projectStage,
//            @RequestParam(required = false) @ApiParam(name="processnode",value="流程节点",required=false) String processnode,
//            @RequestParam @ApiParam(name="operId",value="操作ID",required=true) String operId,
//            @RequestBody(required = false) @ApiParam(name="treedag",value="目录树DAG",required=false) String treedag,
//            @RequestParam(required = false) @ApiParam(name="countersignUserIds",value="会签人员id",required=false) String countersignUserIds,
            HttpServletRequest request
    ) {
        ResponseDataModel<ProcessNodeInfo> responseModel = new ResponseDataModel<>();
        String userId = request.getHeader("userId");
        String userName = request.getHeader("userName");
        try {
            userName = URLDecoder.decode(userName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String projectid = model.getProjectid();
        String projectStage = model.getProjectStage();
        String processnode = model.getProcessnode();
        String operId = model.getOperId();
        String treedag = model.getTreedag();
        String countersignUserIds = model.getCountersignUserIds();

        //重新判断项目阶段是否发生了变化
        try {
            ProjectInfo entity = (ProjectInfo) projectInfoService.get(projectid);
            if(!projectStage.equals(entity.getStage())){
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


        //用户权限判断
        //目录树条件判断
        //保存操作返回当前节点
        if("3".equals(operId)){ //保存意见
            try {
                //保存意见信息
                 directoryOpinionService.saveAllOpinion(projectid, processnode, operId, userName, userId, treedag, DirectoryOpinionType.DFAFT.getCode());
                //返回当前节点
//                ProcessNodeInfo entity = service.get(processnode);
                responseModel.setSuccess(true);
//                responseModel.setEntity(entity);
            } catch (Exception e) {
                responseModel.setSuccess(false);
                responseModel.setMessage(e.getMessage());
                responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                logger.error("Fail:", e);
                return responseModel;
            }
            responseModel.setSuccess(true);
            responseModel.setMessage("保存成功");
            return responseModel;
        }else if("4".equals(operId)){   //变更阶段
            //根据项目id变更到下一项目阶段
            //具体逻辑
            //1.根据当前项目阶段，项目类型，查询下一项目阶段
            //2.将流程重置为项目组录入11
            //3.变更项目信息表的项目阶段
            //还需要修改查询下一流程节点的sql，改为通过项目类型，当前项目阶段，当前流程节点和操作id，来获取下一流程节点。
            //需要重新配置的数据库表有：流程节点信息processnodeinfo，流程信息processinfo，流程与项目阶段关系processstage
            //考虑是否在流程处理需要修改，主要是因为流程最后结束后，在没有流程了，怎么处理
            /**
             * SELECT
             * 	ENDPROCESSNODE
             * FROM
             * 	PROCESSINFO t
             * WHERE
             * 	t.STARTPROCESSNODE = '11'
             * AND t.OPERID = '1'
             * AND t.PROCESSID IN (
             * 	SELECT
             * 		PROCESSID
             * 	FROM
             * 		PROCESSSTAGE t
             * 	WHERE
             * 		t.PROJECTSTAGE = '100'
             * 	AND t.PROJECTTYPE = '3ef549bdfb8d4170bcc8cb1b5e041b62'
             * )
             */
            try {
                //更新阶段
                ProjectInfo projectInfo = new ProjectInfo();
                projectInfo.setId(projectid);
                projectInfo.setStage(projectStage);
                String message = projectInfoService.advance(projectInfo);
                responseModel.setSuccess(true);
                responseModel.setMessage(message);
            } catch (Exception e) {
                responseModel.setSuccess(false);
                responseModel.setMessage(e.getMessage());
                responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                logger.error("Fail:", e);
                return responseModel;
            }
            responseModel.setSuccess(true);
            responseModel.setMessage("流程处理成功");
        }else{  //其他操作去数据库查询下一节点
            //根据当前节点和操作ID去返回目标流程节点
            //select * from PROCESSNODEINFO where PROCESSNODE = (select ENDPROCESSNODE from PROCESSINFO where STARTPROCESSNODE=xx and OPERID=xx)
            try {
                //流程处理
                String message = service.updateProcess(projectid, projectStage, processnode, operId, userName, userId, treedag, countersignUserIds);
                responseModel.setSuccess(true);
                responseModel.setMessage(message);
            } catch (Exception e) {
                responseModel.setSuccess(false);
                responseModel.setMessage(e.getMessage());
                responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                logger.error("Fail:", e);
                return responseModel;
            }
            responseModel.setSuccess(true);
            responseModel.setMessage("流程处理成功");
        }
        return responseModel;
    }

    public static void main(String[] args) {
        int i = 0;
        while(i < 20){
            String a = UUID.randomUUID().toString();
//            System.out.println(a);
//            System.out.println(a.length());
            //public String replaceAll(String regex, String replacement)
            //replaceAll() 方法使用给定的参数 replacement 替换字符串所有匹配给定的正则表达式的子字符串
            String b = a.replaceAll("-", "");
            System.out.println(b);
//            System.out.println(b.length());
//            System.out.println("*******************************");
            i++;
        }
    }
}