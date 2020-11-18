package com.company.manuscriptinfo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.company.projectdirectory.model.ProjectDirectory;
import com.company.projectdirectory.model.ProjectDirectoryExample;
import com.company.projectdirectory.model.ProjectDirectoryKey;
import com.company.projectdirectory.service.ProjectDirectoryService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.enums.ManuscriptInfoStatus;
import com.company.enums.ManuscriptInfoApply;
import com.company.manuscriptinfo.model.ManuscriptInfo;
import com.company.manuscriptinfo.model.ManuscriptInfoExample;
import com.company.manuscriptinfo.model.ManuscriptInfoExample.Criteria;
import com.company.manuscriptinfo.service.ManuscriptInfoService;
import com.company.utils.ListUtil;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 	底稿信息
 * Controller类
 *
 */
@Api(value="底稿信息数据维护",tags={"底稿信息数据操作接口"})
@RestController("ManuscriptInfoController")
@RequestMapping("/api/ManuscriptInfo")
public class ManuscriptInfoController {
	
    /**
     * 上传资源目录
     */
    @Value("${web.upload-file-path}")
    private String fileUploadPath;
    
    /**
     * 上传资源临时目录
     */
    @Value("${web.upload-temp-path}")
    private String fileUploadTempPath;

    public static Logger logger = LoggerFactory.getLogger(ManuscriptInfoController.class);

    @Autowired
    private ManuscriptInfoService<ManuscriptInfo, ManuscriptInfoExample> service;

    @Autowired
    private ProjectDirectoryService<ProjectDirectory, ProjectDirectoryExample> projectDirectoryService;
	
	/**
	 * 	底稿信息查询详情
	 */
	@ApiOperation("底稿信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptInfo> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id,
        HttpServletRequest request
    	) {
        ResponseDataModel<ManuscriptInfo> responseModel = new ResponseDataModel<>();
        try {
            String userId = request.getHeader("userId");
            ManuscriptInfo entity = service.getByMe(id, userId);
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
	 * 	底稿信息分页查询
	 */
	@ApiOperation("分页查询底稿信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ManuscriptInfo> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="id",value="主键",required=true) String id
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},id:{}", currentPage, itemsPerPage, id);
        ResponseDataPageListForBootModel<ManuscriptInfo> responseModel = new ResponseDataPageListForBootModel<ManuscriptInfo>();
        
		try {
            ManuscriptInfoExample example = new ManuscriptInfoExample();
            //按主键倒序 查询
            example.setOrderByClause("id desc");
            Criteria criteria = example.createCriteria();
            
            //若主键不为空
            if (!StringUtils.isEmpty(id)) {
            	criteria.andIdEqualTo(id);
            }
        	PageInfo<ManuscriptInfo> page = service.getListByPage(currentPage, itemsPerPage, example);
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
     * 	获取该项目目录下该用户上传的底稿信息查询
     */
    @ApiOperation("获取该项目目录下该用户上传的底稿信息查询")
    @PostMapping(value = "/viewManuscriptListByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ManuscriptInfo> viewManuscriptListByUserId(
            @RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage,
            @RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
            @RequestParam(required = true) @ApiParam(name="projectid",value="项目id",required=true) String projectid,
            @RequestParam(required = true) @ApiParam(name="directoryid",value="目录id",required=true) String directoryid,
            HttpServletRequest request
    )  throws BaseException{
        String userId = request.getHeader("userId");
        logger.info("currentPage:{},itemsPerPage:{},projectid:{},directoryid:{},userId: {}", currentPage, itemsPerPage, projectid, directoryid, userId);
        ResponseDataPageListForBootModel<ManuscriptInfo> responseModel = new ResponseDataPageListForBootModel<ManuscriptInfo>();

        try {
            ManuscriptInfoExample example = new ManuscriptInfoExample();
            example.setOrderByClause(" orderno asc");
            ManuscriptInfoExample.Criteria criteria = example.createCriteria();
            criteria.andProjectidEqualTo(projectid);
            criteria.andDirectoryidEqualTo(directoryid);
            criteria.andUseridEqualTo(userId);
            criteria.andRemarksIsNotNull();
            criteria.andIsappEqualTo(ManuscriptInfoApply.YES.getCode());
            PageInfo<ManuscriptInfo> page = service.getListByPage(currentPage, itemsPerPage, example);
            responseModel.setSuccess(true);
            responseModel.setPageIndex(currentPage);
            responseModel.setPageSize(itemsPerPage);
            responseModel.setRecordsTotal(page.getTotal());
            responseModel.setData(page.getList());
            responseModel.setRecordsFiltered(page.getList()==null?0:page.getList().size());
            responseModel.setMessage("分页获取该项目目录下该用户上传的底稿信息查询成功");
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
	 * 	底稿信息添加数据
	 */
	@ApiOperation("添加底稿信息数据")
    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataModel<ManuscriptInfo> add(
    		@RequestParam(name="file",required=true) @ApiParam(name="file",value="上传文件",required=true) MultipartFile file,
    		@RequestParam(required = true) @ApiParam(name="projectid",value="项目id",required=true) String projectid,
    		@RequestParam(required = true) @ApiParam(name="directoryid",value="所属目录id",required=true) String directoryid,
            @RequestParam(required = true) @ApiParam(name="fileType",value="文件类型",required=true) String fileType,
    		HttpServletRequest request) {
		ResponseDataModel<ManuscriptInfo> responseModel = new ResponseDataModel<ManuscriptInfo>();
        logger.info("add--projectId:{},directoryId:{}", projectid, directoryid);
        logger.info("上传文件==="+"\n");
		logger.info("上传文件操作开始===");
        //判断文件是否为空
        if (file.isEmpty()) {
        	responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + "上传文件不可为空");
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:"+"上传文件不可为空");
            return responseModel;
        }
        //判断项目目录是否小于20才能上传
        boolean falg = true;
        try {
            //获取项目目录信息
            ProjectDirectoryKey key = new ProjectDirectoryKey();
            key.setProjectid(projectid);
            key.setDirectoryid(directoryid);
            ProjectDirectory entity = projectDirectoryService.get(key);
            String str = entity.getProcessnode();
            if(str != null && str.length() > 0){
               int stas = Integer.parseInt(str);
               if(stas < 20){
                   falg = false;
               }
            }
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        if(falg){
            //判断项目目录是否小于20才能上传
            //否则提示信息
            responseModel.setSuccess(false);
            responseModel.setMessage("项目目录状态为项目成员录入时才能上传文件。");
            return responseModel;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名===fileName:{}", fileName);
        String tempFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //加个时间戳，尽量避免文件名称重复
        String path = fileUploadTempPath + tempFileName;
        //文件绝对路径
        logger.info("临时文件保存路径===path:{}", path);
        //创建文件路径
        File dest = new File(path);
        
        try {
        	//上传文件到临时目录
        	file.transferTo(dest);
        	String hax = com.company.utils.FileUtils.getFileHashForSha256(dest);
        	String haxPath = fileUploadPath + hax;
        	logger.info("保存的文件名(文件哈希计算值)绝对路径===haxPath:{}", haxPath);
        	File destHax = new File(haxPath);
            ManuscriptInfo record = new ManuscriptInfo();
            record.setProjectid(projectid);
            record.setDirectoryid(directoryid);
            record.setDocname(fileName);
            record.setHashname(hax);
            record.setStatus(ManuscriptInfoStatus.NOTREAD.getCode());
            record.setIsapp(ManuscriptInfoApply.YES.getCode());
            record.setUploaddate(new Date());
            record.setFiletype(fileType);
            String userId = request.getHeader("userId");
            record.setUserid(userId);
            //判断文件是否已经存在  存在即秒传
            if(!destHax.exists()) {
//            	FileUtils.copyFile(dest, destHax);
            	FileUtils.moveFile(dest, destHax);
            } else {
            	FileUtils.deleteQuietly(dest);
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
	 * 	底稿信息修改数据
	 */
	@ApiOperation("修改底稿信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptInfo> update(@RequestBody @ApiParam(name="底稿信息对象",value="传入json格式",required=true) ManuscriptInfo model,HttpServletRequest request) {
        ResponseDataModel<ManuscriptInfo> responseModel = new ResponseDataModel<ManuscriptInfo>();
//        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ManuscriptInfo record = new ManuscriptInfo();
            BeanUtils.copyProperties(model, record);
            String userId = request.getHeader("userId");
            record.setUserid(userId);
            service.updateByMe(record);
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
	 * 	底稿信息删除数据
	 */
	@ApiOperation("删除底稿信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        try {
            service.delForMe(id);
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
	 * 	底稿信息批量删除数据
	 */
	@ApiOperation("批量删除底稿信息数据")
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