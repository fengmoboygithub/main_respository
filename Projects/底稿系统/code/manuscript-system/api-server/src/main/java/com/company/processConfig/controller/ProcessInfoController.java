package com.company.processConfig.controller;

import com.company.bean.ResponseDataListModel;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.processConfig.model.*;
import com.company.processConfig.service.GraphInfoService;
import com.company.processConfig.service.StageInfoService;
import com.company.processnodeinfo.model.ProcessNodeInfo;
import com.company.processnodeinfo.model.ProcessNodeInfoExample;
import com.company.processnodeinfo.service.ProcessNodeInfoService;
import com.company.query.model.SmartQueryModel;
import com.company.query.model.SmartQueryModelExample;
import com.company.query.service.SmartQueryService;
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
import java.util.List;

/**
 * 	流程信息
 * Controller类
 * @author 杨延超
 */
@Api(value="流程信息数据配置",tags={"流程信息数据配置"})
@RestController("ProcessInfoController")
@RequestMapping("/api/ProcessInfo")
public class ProcessInfoController {

    public static Logger logger = LoggerFactory.getLogger(ProcessInfoController.class);

    @Autowired
    private ProcessNodeInfoService<ProcessNodeInfo, ProcessNodeInfoExample> processNodeInfoService;

    @Autowired
    private StageInfoService<StageInfo, StageInfoExample> stageInfoService;

    @Autowired
    private GraphInfoService<GraphInfo, GraphInfoExample> graphInfoService;

    @Autowired
    private SmartQueryService smartQueryService;

    /**
     * 	流程信息查询详情
     */
    @ApiOperation("根据项目ID查询阶段信息")
    @PostMapping(value = "/getStageByType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataPageListForBootModel<StageInfo> getStageByType(
            @RequestParam(required = true) @ApiParam(name="id",value="项目类型",required=true) String id
    ) {
        ResponseDataPageListForBootModel<StageInfo> responseModel = new ResponseDataPageListForBootModel<StageInfo>();

        try {
            StageInfoExample example = new StageInfoExample();
            //按项目阶段升序
            example.setOrderByClause("PROJECTSTAGE asc");
            StageInfoExample.Criteria criteria = example.createCriteria();

            //若id不为空
            if (!StringUtils.isEmpty(id)) {
                criteria.andProjecttypeEqualTo(id);
            }
            List<StageInfo> list = stageInfoService.getListByType(example);
            responseModel.setData(list);
            responseModel.setMessage("查询成功");
            responseModel.setSuccess(true);
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
     * 	流程节点列表信息查询
     */
    @ApiOperation("流程节点列表信息查询")
    @PostMapping(value = "/getProcessNodeList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ProcessNodeInfo> getProcessNodeList() {
        ResponseDataListModel<ProcessNodeInfo> responseModel = new ResponseDataListModel<ProcessNodeInfo>();

        try {
            ProcessNodeInfoExample example = new ProcessNodeInfoExample();
            //按流程节点升序
            example.setOrderByClause("PROCESSNODE asc");
            List<ProcessNodeInfo> list = processNodeInfoService.getList(example);
            responseModel.setList(list);
            responseModel.setMessage("查询成功");
            responseModel.setSuccess(true);
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
     * 	根据项目类型id和项目阶段查询流程列表信息
     */
    @ApiOperation("根据项目类型id和项目阶段查询流程列表信息")
    @PostMapping(value = "/getProcessList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataPageListForBootModel<SmartQueryModel> getNodeList(
            @RequestParam(required = true) @ApiParam(name="projecttype",value="项目类型",required=true) String projecttype,
            @RequestParam(required = true) @ApiParam(name="projectstage",value="项目阶段",required=true) String projectstage
    ) {
        ResponseDataPageListForBootModel<SmartQueryModel> responseModel = new ResponseDataPageListForBootModel<SmartQueryModel>();
        String SQL=" SELECT * FROM ( " + 
        		"		SELECT " + 
        		"			a.PROCESSID AS property1, " + 
        		"			a.PROJECTTYPE AS property2, " + 
        		"			a.PROJECTSTAGE AS property3, " + 
        		"			b.STARTPROCESSNODE AS property4, " + 
        		"			b.ENDPROCESSNODE AS property5, " + 
        		"			b.OPERID AS property6 " + 
        		"		FROM " + 
        		"			processstage a, " + 
        		"			processinfo b " + 
        		"		WHERE " + 
        		"			a.PROCESSID = b.PROCESSID ) t";
        try {
            SmartQueryModelExample example = new SmartQueryModelExample();
            //按项目阶段升序
            example.setOrderByClause("t.property4 asc");
            SmartQueryModelExample.Criteria criteria = example.createCriteria();

            //若id不为空
            if (!StringUtils.isEmpty(projecttype) && !StringUtils.isEmpty(projectstage)) {
                criteria.andProperty2EqualTo(projecttype);
                criteria.andProperty3EqualTo(projectstage);
            }
            List<SmartQueryModel> list = smartQueryService.findList(SQL, example);
            responseModel.setData(list);
            responseModel.setMessage("查询成功");
            responseModel.setSuccess(true);
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
     * 	根据项目类型id和项目阶段查询流程图像数据
     */
    @ApiOperation("根据项目类型id和项目阶段查询流程图像数据")
    @PostMapping(value = "/getGraphInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<GraphInfo> getGraphInfo(
            @RequestParam(required = true) @ApiParam(name="projecttype",value="项目类型",required=true) String projecttype,
            @RequestParam(required = true) @ApiParam(name="projectstage",value="项目阶段",required=true) String projectstage
    ) {
        ResponseDataModel<GraphInfo> responseModel = new ResponseDataModel<GraphInfo>();
        try {
            GraphInfoExample example = new GraphInfoExample();
            GraphInfoExample.Criteria criteria = example.createCriteria();
            criteria.andProjecttypeEqualTo(projecttype);
            criteria.andProjectstageEqualTo(projectstage);
            List<GraphInfo> list = graphInfoService.getList(example);
            responseModel.setEntity((list == null || list.size() == 0) ? null : list.get(0) );
            responseModel.setMessage("查询流程图像数据成功");
            responseModel.setSuccess(true);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("查询流程图像数据成功");
        return responseModel;
    }

    /**
     * 	保存流程图像数据
     */
    @ApiOperation("保存流程图像数据")
    @PostMapping(value = "/saveGraphInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<GraphInfo> saveGraphInfo(@RequestBody @ApiParam(name="流程图像信息对象",value="传入json格式",required=true) GraphInfo model, HttpServletRequest request) {

        ResponseDataModel<GraphInfo> responseModel = new ResponseDataModel<GraphInfo>();
        try {
            GraphInfo record = new GraphInfo();
            BeanUtils.copyProperties(model, record);
            graphInfoService.saveGraphInfo(record);
            responseModel.setSuccess(true);
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