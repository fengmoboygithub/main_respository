package com.company.messagecenter.controller;

import com.company.bean.ResponseDataListModel;
import com.company.enums.MessageCenterState;
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
import com.company.messagecenter.model.MessageCenter;
import com.company.messagecenter.model.MessageCenterExample;
import com.company.messagecenter.model.MessageCenterExample.Criteria;
import com.company.base.exception.BaseException;
import com.company.messagecenter.service.MessageCenterService;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.utils.ListUtil;
import com.company.constant.BaseConstant;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 	消息中心信息
 * Controller类
 *
 */
@Api(value="消息中心信息数据维护",tags={"消息中心信息数据操作接口"})
@RestController("MessageCenterController")
@RequestMapping("/api/MessageCenter")
public class MessageCenterController {

    public static Logger logger = LoggerFactory.getLogger(MessageCenterController.class);

    @Autowired
    private MessageCenterService<MessageCenter, MessageCenterExample> service;
	
	/**
	 * 	消息中心信息查询详情
	 */
	@ApiOperation("消息中心信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<MessageCenter> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<MessageCenter> responseModel = new ResponseDataModel<>();
        try {
            MessageCenter entity = service.get(id);
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
     * 	消息中心信息查询
     */
    @ApiOperation("查询消息中心信息数据")
    @PostMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataListModel<MessageCenter> getList(
            @RequestParam(required = false) @ApiParam(name="mgtype",value="消息类型",required=false) String mgtype,
            @RequestParam(required = false) @ApiParam(name="mgstate",value="消息状态",required=false) String mgstate,
            @RequestParam(required = false) @ApiParam(name="mgcontent",value="消息内容",required=false) String mgcontent
    )  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},id:{}", mgtype, mgstate, mgcontent);
        ResponseDataListModel<MessageCenter> responseModel = new ResponseDataListModel<MessageCenter>();

        try {
            MessageCenterExample example = new MessageCenterExample();
            //按主键倒序 查询
            example.setOrderByClause("CREATE_TIME desc");
            Criteria criteria = example.createCriteria();

            //若消息类型不为空
            if (!StringUtils.isEmpty(mgtype)) {
                criteria.andMgtypeEqualTo(mgtype);
            }
            //若消息状态不为空
            if (!StringUtils.isEmpty(mgstate)) {
                criteria.andMgstateEqualTo(mgstate);
            }
            //若消息内容不为空
            if (!StringUtils.isEmpty(mgcontent)) {
                criteria.andMgcontentLike("%" + mgcontent + "%");
            }
            List<MessageCenter> list = service.select(null, example);
            responseModel.setSuccess(true);
            responseModel.setList(list);
            responseModel.setMessage("查询成功");
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
	 * 	消息中心信息分页查询
	 */
	@ApiOperation("分页查询消息中心信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<MessageCenter> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="mgtype",value="消息类型",required=false) String mgtype,
            @RequestParam(required = false) @ApiParam(name="mgstate",value="消息状态",required=false) String mgstate,
            @RequestParam(required = false) @ApiParam(name="mgcontent",value="消息内容",required=false) String mgcontent
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},id:{}", currentPage, itemsPerPage, mgtype, mgstate, mgcontent);
        ResponseDataPageListForBootModel<MessageCenter> responseModel = new ResponseDataPageListForBootModel<MessageCenter>();
        
		try {
            MessageCenterExample example = new MessageCenterExample();
            //按主键倒序 查询
            example.setOrderByClause("CREATE_TIME desc");
            Criteria criteria = example.createCriteria();
            
            //若消息类型不为空
            if (!StringUtils.isEmpty(mgtype)) {
            	criteria.andMgtypeEqualTo(mgtype);
            }
            //若消息状态不为空
            if (!StringUtils.isEmpty(mgstate)) {
                criteria.andMgstateEqualTo(mgstate);
            }
            //若消息内容不为空
            if (!StringUtils.isEmpty(mgcontent)) {
                criteria.andMgcontentLike("%" + mgcontent + "%");
            }
        	PageInfo<MessageCenter> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	消息中心信息添加数据
	 */
	@ApiOperation("添加消息中心信息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<MessageCenter> add(@RequestBody @ApiParam(name="消息中心信息对象",value="传入json格式",required=true) MessageCenter model,HttpServletRequest request) {
        ResponseDataModel<MessageCenter> responseModel = new ResponseDataModel<MessageCenter>();
        String userId = request.getHeader("userId");
        try {
            MessageCenter record = new MessageCenter();
            BeanUtils.copyProperties(model, record);
            record.setMgstate(MessageCenterState.DRAFT.getCode());
			record.setCreateTime(new Date());
			record.setCreateUser(userId);
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
	 * 	消息中心信息修改数据
	 */
	@ApiOperation("修改消息中心信息数据")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<MessageCenter> update(@RequestBody @ApiParam(name="消息中心信息对象",value="传入json格式",required=true) MessageCenter model,HttpServletRequest request) {
        ResponseDataModel<MessageCenter> responseModel = new ResponseDataModel<MessageCenter>();
        String userId = request.getHeader("userId");
        try {
            MessageCenter record = new MessageCenter();
            BeanUtils.copyProperties(model, record);
			record.setUpdateTime(new Date());
            record.setUpdateUser(userId);
            service.updateForMe(record);
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
	 * 	消息中心信息删除数据
	 */
	@ApiOperation("删除消息中心信息数据")
    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel del(
    	@ApiParam(name="id",value="主键",required=true) String id,HttpServletRequest request
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
}