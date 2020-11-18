package com.company.manuscriptversion.controller;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.constant.BaseConstant;
import com.company.manuscriptversion.model.ManuscriptVersion;
import com.company.manuscriptversion.model.ManuscriptVersionExample;
import com.company.manuscriptversion.model.ManuscriptVersionExample.Criteria;
import com.company.manuscriptversion.service.ManuscriptVersionService;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 	底稿版本信息
 * Controller类
 *
 */
@Api(value="底稿版本信息数据维护",tags={"底稿版本信息数据操作接口"})
@RestController("ManuscriptVersionController")
@RequestMapping("/api/ManuscriptVersion")
public class ManuscriptVersionController {

    public static Logger logger = LoggerFactory.getLogger(ManuscriptVersionController.class);

    @Autowired
    private ManuscriptVersionService<ManuscriptVersion, ManuscriptVersionExample> service;
	
	/**
	 * 	底稿版本信息查询详情
	 */
	@ApiOperation("底稿版本信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptVersion> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<ManuscriptVersion> responseModel = new ResponseDataModel<>();
        try {
            ManuscriptVersion entity = service.get(id);
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
	 * 	底稿版本信息分页查询
	 */
	@ApiOperation("分页查询底稿版本信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ManuscriptVersion> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="projectId",value="项目id",required=true) String projectId,
            @RequestParam(required = false) @ApiParam(name="docId",value="底稿id",required=true) String docId
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},projectId:{},docId:{}", currentPage, itemsPerPage, projectId, docId);
        ResponseDataPageListForBootModel<ManuscriptVersion> responseModel = new ResponseDataPageListForBootModel<ManuscriptVersion>();
        
		try {
            ManuscriptVersionExample example = new ManuscriptVersionExample();
            //按主键倒序 查询
            example.setOrderByClause("VERSION desc");
            Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            
            //若不为空
            if (!StringUtils.isEmpty(projectId)) {
            	criteria.andProjectidEqualTo(projectId);
            }
            if (!StringUtils.isEmpty(docId)) {
                criteria.andDocidEqualTo(docId);
            }
        	PageInfo<ManuscriptVersion> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	底稿版本信息添加数据
	 */
	@ApiOperation("添加底稿版本信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptVersion> add(@RequestBody @ApiParam(name="底稿版本信息对象",value="传入json格式",required=true) ManuscriptVersion model,HttpServletRequest request) {
        ResponseDataModel<ManuscriptVersion> responseModel = new ResponseDataModel<ManuscriptVersion>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ManuscriptVersion record = new ManuscriptVersion();
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
	 * 	底稿版本信息修改数据
	 */
	@ApiOperation("修改底稿版本信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptVersion> update(@RequestBody @ApiParam(name="底稿版本信息对象",value="传入json格式",required=true) ManuscriptVersion model,HttpServletRequest request) {
        ResponseDataModel<ManuscriptVersion> responseModel = new ResponseDataModel<ManuscriptVersion>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            ManuscriptVersion record = new ManuscriptVersion();
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
	 * 	底稿版本信息删除数据
	 */
	@ApiOperation("删除底稿版本信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	ManuscriptVersion record = new ManuscriptVersion();
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
	 * 	底稿版本信息批量删除数据
	 */
	@ApiOperation("批量删除底稿版本信息数据")
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