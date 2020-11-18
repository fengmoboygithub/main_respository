package com.company.projectdirectory.controller;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataListModel;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.directoryversion.service.DirectoryVersionService;
import com.company.processnodeinfo.model.ProcessNodeInfo;
import com.company.processnodeinfo.model.ProcessNodeInfoExample;
import com.company.processnodeinfo.service.ProcessNodeInfoService;
import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.model.ProjectDirectoryExample;
import com.company.projectdirectory.model.ProjectDirectoryExample.Criteria;
import com.company.projectdirectory.model.ProjectDirectoryKey;
import com.company.projectdirectory.service.ProjectDirectoryService;
import com.company.projectdirectory.view.ProjectDirectoryTree;
import com.company.projectinfo.model.ProjectInfo;
import com.company.projectinfo.model.ProjectInfoExample;
import com.company.projectinfo.service.ProjectInfoService;
import com.company.utils.FileUtils;
import com.company.utils.ListUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	项目目录信息
 * Controller类
 *
 */
@Api(value="项目目录信息数据维护",tags={"项目目录信息数据操作接口"})
@RestController("ProjectDirectoryController")
@RequestMapping("/api/ProjectDirectory")
public class ProjectDirectoryController {

    public static Logger logger = LoggerFactory.getLogger(ProjectDirectoryController.class);

    /**
     * 上传资源目录
     */
    @Value("${web.upload-file-path}")
    private String fileUploadPath;

    /**
     * 导出文件目录
     */
    @Value("${web.download-file-path}")
    private String fileDownloadPath;

    @Autowired
    private ProjectDirectoryService<ProjectDirectory, ProjectDirectoryExample> service;

    @Autowired
    private DirectoryVersionService directoryVersionService;

    @Autowired
    private ProjectInfoService<ProjectInfo, ProjectInfoExample> projectInfoService;

    @Autowired
    private ProcessNodeInfoService<ProcessNodeInfo, ProcessNodeInfoExample> processNodeInfoService;


    /**
     * 	项目目录树用于导出某时间节点的数据展示接口
     */
    @ApiOperation("项目目录树用于导出某时间节点的数据展示接口")
    @PostMapping(value = "/viewTreeForExport", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ProjectDirectoryTree> viewTreeForExport(
            @RequestParam(required = true) @ApiParam(name="projectid",value="项目id",required=true) String projectid,
            @RequestParam(required = false) @ApiParam(name="reptDate",value="报送日期时间",required=true) String reptDate
    ) {
        ResponseDataListModel<ProjectDirectoryTree> responseModel = new ResponseDataListModel<>();
        try {
            //项目目录树查询
            List<ProjectDirectoryTree> list = service.viewTreeForExport(projectid, reptDate);
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
        responseModel.setMessage("项目目录树查询成功");
        return responseModel;
    }


    /**
     * 	项目目录树含底稿文件(全部)查询
     */
    @ApiOperation("项目目录树含底稿文件(全部)查询")
    @PostMapping(value = "/viewTreeForMe", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ProjectDirectoryTree> viewTreeForMe(
            @RequestParam(required = true) @ApiParam(name="projectid",value="项目id",required=true) String projectid,
            @RequestParam(required = true) @ApiParam(name="projectStage",value="项目阶段",required=true) String projectStage
    ) {
        ResponseDataListModel<ProjectDirectoryTree> responseModel = new ResponseDataListModel<>();
        try {
            //项目目录树查询
            List<ProjectDirectoryTree> list = service.viewTreeForMe(projectid, projectStage);

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
        responseModel.setMessage("项目目录树查询成功");
        return responseModel;
    }

    /**
	 * 	项目目录树含底稿文件(适用)查询
	 */
	@ApiOperation("项目目录树含底稿文件(适用)查询")
    @PostMapping(value = "/viewTree", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ProjectDirectoryTree> viewTree(
    	@RequestParam(required = true) @ApiParam(name="projectid",value="项目id",required=true) String projectid,
        @RequestParam(required = true) @ApiParam(name="projectStage",value="项目阶段",required=true) String projectStage,
    	@RequestParam(required = false) @ApiParam(name="directoryid",value="目录id",required=false) String directoryid,
        @RequestParam(required = false) @ApiParam(name="nocheck",value="是否不显示复选框",required=false) Boolean nocheck,
        HttpServletRequest request
    	) {
		ResponseDataListModel<ProjectDirectoryTree> responseModel = new ResponseDataListModel<>();
        try {
            String userId1 = request.getHeader("userId");
            if(nocheck == null){
                nocheck = false;
            }
            String[] userId = new String[]{userId1, nocheck.toString()};
        	//项目目录树查询
            List<ProjectDirectoryTree> list = service.viewTree(projectid, projectStage, directoryid, userId);

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
        responseModel.setMessage("项目目录树查询成功");
        return responseModel;
    }

    /**
     * 	导出报送文件--项目目录信息数据
     */
    @ApiOperation("导出报送文件--项目目录信息数据")
    @GetMapping(value = "/export", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void export(
            @RequestParam(required = true) @ApiParam(name="projectid",value="项目id",required=true) String projectid,
            @RequestParam(required = true) @ApiParam(name="projectStage",value="项目阶段",required=true) String projectStage,
            @RequestParam(required = true) @ApiParam(name="directoryid",value="目录id",required=true) String directoryid,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws UnsupportedEncodingException{
        String filename = service.writeTextFile(projectid, projectStage, directoryid);
        String filepath = fileDownloadPath + filename;
        FileUtils.writeTxtFileForWeb(filepath, filename, request, response);
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }

    /**
     * 	项目目录名称或简称查询唯一性
     */
    @ApiOperation("项目目录名称或简称查询唯一性")
    @PostMapping(value = "/getNameOrSnameForOnly", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<Boolean> getNameOrSnameForOnly(
            @RequestParam(required = true) @ApiParam(name="projectid",value="项目id",required=true) String projectid,
            @RequestParam(required = false) @ApiParam(name="parentid",value="父目录Id",required=false) String parentid,
            @RequestParam(required = false) @ApiParam(name="id",value="项目目录Id",required=false) String id,
            @RequestParam(required = false) @ApiParam(name="sname",value="目录简称",required=false) String sname,
            @RequestParam(required = false) @ApiParam(name="fullname",value="目录全称",required=false) String fullname
    ) {
        ResponseDataModel<Boolean> responseModel = new ResponseDataModel<Boolean>();
        try {
            Boolean entity = false;
            ProjectDirectoryExample example = new ProjectDirectoryExample();
            Criteria criteria = example.createCriteria();
            criteria.andProjectidEqualTo(projectid);
            if(!StringUtils.isEmpty(parentid)){
                criteria.andParentidEqualTo(parentid);
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
                criteria.andDirectoryidNotEqualTo(id);
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
	 * 	项目目录信息查询详情
	 */
	@ApiOperation("项目目录信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectDirectory> get(
    	@RequestParam(required = true) @ApiParam(name="projectid",value="主键",required=true) String projectid,
        @RequestParam(required = true) @ApiParam(name="directoryid",value="目录id",required=true) String directoryid
    	) {
        ResponseDataModel<ProjectDirectory> responseModel = new ResponseDataModel<>();
        try {
            ProjectDirectoryKey key = new ProjectDirectoryKey();
            key.setProjectid(projectid);
            key.setDirectoryid(directoryid);
            ProjectDirectory entity = service.get(key);
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
	 * 	项目目录信息分页查询
	 */
	@ApiOperation("分页查询项目目录信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ProjectDirectory> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="projectid",value="主键",required=true) String projectid
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},projectid:{}", currentPage, itemsPerPage, projectid);
        ResponseDataPageListForBootModel<ProjectDirectory> responseModel = new ResponseDataPageListForBootModel<ProjectDirectory>();
        
		try {
            ProjectDirectoryExample example = new ProjectDirectoryExample();
            //按主键倒序 查询
            example.setOrderByClause("projectid desc");
            Criteria criteria = example.createCriteria();
            
            //若主键不为空
            if (!StringUtils.isEmpty(projectid)) {
            	criteria.andProjectidEqualTo(projectid);
            }
        	PageInfo<ProjectDirectory> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	项目目录信息添加数据
	 */
	@ApiOperation("添加项目目录信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectDirectory> add(@RequestBody @ApiParam(name="项目目录信息对象",value="传入json格式",required=true) ProjectDirectory model,HttpServletRequest request) {
        ResponseDataModel<ProjectDirectory> responseModel = new ResponseDataModel<ProjectDirectory>();
//        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ProjectDirectory record = new ProjectDirectory();
            BeanUtils.copyProperties(model, record);
            String parentid = record.getParentid();
            if (StringUtils.isEmpty(parentid)) {
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
	 * 	项目目录信息修改数据
	 */
	@ApiOperation("修改项目目录信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ProjectDirectory> update(@RequestBody @ApiParam(name="项目目录信息对象",value="传入json格式",required=true) ProjectDirectory model,HttpServletRequest request) {
        ResponseDataModel<ProjectDirectory> responseModel = new ResponseDataModel<ProjectDirectory>();
//        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        String userId = request.getHeader("userId");
        try {
            ProjectDirectory record = new ProjectDirectory();
            BeanUtils.copyProperties(model, record);
            String parentid = record.getParentid();
            if (StringUtils.isEmpty(parentid)) {
                record.setParentid(null);
            }
            service.updateProjectDirectory(record, userId);
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
	 * 	项目目录信息删除数据
	 */
	@ApiOperation("删除项目目录信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="projectid",value="主键",required=true) String projectid,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
//        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	ProjectDirectory record = new ProjectDirectory();
            record.setProjectid(projectid);
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
     * 	项目目录信息删除数据
     */
    @ApiOperation("删除项目目录信息数据通过ID")
    @DeleteMapping(value = "/delDirctoryById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel delDirctoryById(
            @RequestParam(required=true) @ApiParam(name="id",value="主键",required=true) String id,
            HttpServletRequest request
    ) {
        ResponseModel responseModel = new ResponseModel();
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
    
    /**
	 * 	项目目录信息批量删除数据
	 */
	@ApiOperation("批量删除项目目录信息数据")
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
     * 	 适用性修改(目录和底稿文件)
     */
    @ApiOperation("适用性修改(目录和底稿文件)")
    @PutMapping(value = "/updateIsapp", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel updateIsapp(
            @RequestParam(required = true) @ApiParam(name="projectId",value="项目id",required=true) String projectId,
            @RequestParam(required = true) @ApiParam(name="projectStage",value="项目阶段",required=true) String projectStage,
            @RequestParam(required = true) @ApiParam(name="treedag",value="目录树DAG",required=true) String treeDag,
            HttpServletRequest request
    ) {
        ResponseDataModel<ProjectDirectory> responseModel = new ResponseDataModel<ProjectDirectory>();
//        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        String userId = request.getHeader("userId");
        try {
//            ProjectDirectory record = new ProjectDirectory();
//            BeanUtils.copyProperties(model, record);
            service.updateIsapp(projectId, projectStage, treeDag, userId);
//            responseModel.setEntity(record);
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
     * 	项目目录树含底稿文件(适用)查询(全部层级)
     */
    @ApiOperation("项目目录树含底稿文件(适用)查询(全部层级)测试")
    @PostMapping(value = "/viewTreeAllTest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ProjectDirectoryTree> viewTreeAllTest(
            @RequestParam(required = false) @ApiParam(name="projectId",value="项目id",required=false) String projectId,
            @RequestParam(required = false) @ApiParam(name="directoryid",value="目录id",required=false) String directoryid,
//            @RequestBody @ApiParam(name="项目目录信息对象",value="传入json格式",required=true) ProjectDirectory model,
            HttpServletRequest request
    ) {
        ResponseDataListModel<ProjectDirectoryTree> responseModel = new ResponseDataListModel<>();
        try {
            String userId = request.getHeader("userId");
            //项目目录树查询
            Map hashnameMap = new HashMap();
            Map versioncompositionMap = new HashMap();
            List<ProjectDirectoryTree> list = service.viewAllDirectoryTree(projectId);
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
        responseModel.setMessage("项目目录树查询成功");
        return responseModel;
    }


    /**
     * 	上传文件测试
     */
    @ApiOperation("上传文件测试")
    @PostMapping(value = "/uploadfiletest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ProjectDirectory> uploadfiletest(
            @RequestParam(required = false) @ApiParam(name="projectId",value="项目id",required=false) String projectId,
//            @RequestParam(required = false) @ApiParam(name="directoryid",value="目录id",required=false) String directoryid,
//            @RequestBody @ApiParam(name="项目目录信息对象",value="传入json格式",required=true) ProjectDirectory model,
            HttpServletRequest request
    ) {
        ResponseDataListModel<ProjectDirectory> responseModel = new ResponseDataListModel<>();
        try {
            String userId = request.getHeader("userId");
            service.uploadfiletest(projectId,"93970");
            responseModel.setSuccess(true);
//            responseModel.setList(list);
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
        responseModel.setMessage("项目目录树查询成功");
        return responseModel;
    }


}