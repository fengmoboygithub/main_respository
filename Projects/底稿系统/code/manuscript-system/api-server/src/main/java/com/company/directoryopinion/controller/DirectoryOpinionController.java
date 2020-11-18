package com.company.directoryopinion.controller;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.constant.BaseConstant;
import com.company.directoryopinion.model.DirectoryOpinion;
import com.company.directoryopinion.model.DirectoryOpinionExample;
import com.company.directoryopinion.model.DirectoryOpinionExample.Criteria;
import com.company.directoryopinion.service.DirectoryOpinionService;
import com.company.enums.DirectoryOpinionType;
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
 * 	目录意见信息
 * Controller类
 *
 */
@Api(value="目录意见信息数据维护",tags={"目录意见信息数据操作接口"})
@RestController("DirectoryOpinionController")
@RequestMapping("/api/DirectoryOpinion")
public class DirectoryOpinionController {

    public static Logger logger = LoggerFactory.getLogger(DirectoryOpinionController.class);

    @Autowired
    private DirectoryOpinionService<DirectoryOpinion, DirectoryOpinionExample> service;
	
	/**
	 * 	目录意见信息查询详情
	 */
	@ApiOperation("目录意见信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DirectoryOpinion> get(
            @RequestParam(required = false) @ApiParam(name="projectId",value="项目id",required=true) String projectId,
            @RequestParam(required = false) @ApiParam(name="directoryId",value="目录id",required=true) String directoryId,
            @RequestParam(required = false) @ApiParam(name="opinionType",value="意见类型",required=true) String opinionType
    	) {
        ResponseDataModel<DirectoryOpinion> responseModel = new ResponseDataModel<>();
        try {
            DirectoryOpinion directoryOpinion = new DirectoryOpinion();
            directoryOpinion.setProjectid(projectId);
            directoryOpinion.setDirectoryid(directoryId);
            directoryOpinion.setOpinionType(opinionType);
            DirectoryOpinion entity = service.getDirectoryOpinion(directoryOpinion);
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
	 * 	目录意见信息分页查询
	 */
	@ApiOperation("分页查询目录意见信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<DirectoryOpinion> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="projectId",value="项目id",required=true) String projectId,
            @RequestParam(required = false) @ApiParam(name="directoryId",value="目录id",required=true) String directoryId
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},projectId:{},directoryId:{}", currentPage, itemsPerPage, projectId, directoryId);
        ResponseDataPageListForBootModel<DirectoryOpinion> responseModel = new ResponseDataPageListForBootModel<DirectoryOpinion>();
		try {
            DirectoryOpinionExample example = new DirectoryOpinionExample();
            //按主键倒序 查询
            example.setOrderByClause("UPDATE_TIME DESC");
            Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            
            if (!StringUtils.isEmpty(projectId)) {
            	criteria.andProjectidEqualTo(projectId);
            }
            if (!StringUtils.isEmpty(directoryId)) {
                criteria.andDirectoryidEqualTo(directoryId);
            }
            criteria.andOpiniontypeEqualTo(DirectoryOpinionType.SUBMIT.getCode());
        	PageInfo<DirectoryOpinion> page = service.getListByPageWithBlobs(currentPage, itemsPerPage, example);
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
	 * 	目录意见信息添加数据
	 */
	@ApiOperation("添加目录意见信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DirectoryOpinion> add(@RequestBody @ApiParam(name="目录意见信息对象",value="传入json格式",required=true) DirectoryOpinion model,HttpServletRequest request) {
        ResponseDataModel<DirectoryOpinion> responseModel = new ResponseDataModel<DirectoryOpinion>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            DirectoryOpinion record = new DirectoryOpinion();
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
	 * 	目录意见信息修改数据
	 */
	@ApiOperation("修改目录意见信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<DirectoryOpinion> update(@RequestBody @ApiParam(name="目录意见信息对象",value="传入json格式",required=true) DirectoryOpinion model,HttpServletRequest request) {
        ResponseDataModel<DirectoryOpinion> responseModel = new ResponseDataModel<DirectoryOpinion>();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
            DirectoryOpinion record = new DirectoryOpinion();
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
	 * 	目录意见信息删除数据
	 */
	@ApiOperation("删除目录意见信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        Long currUserId = (Long)request.getSession().getAttribute(BaseConstant.LOGIN_KEY);
        try {
        	DirectoryOpinion record = new DirectoryOpinion();
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
	 * 	目录意见信息批量删除数据
	 */
	@ApiOperation("批量删除目录意见信息数据")
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