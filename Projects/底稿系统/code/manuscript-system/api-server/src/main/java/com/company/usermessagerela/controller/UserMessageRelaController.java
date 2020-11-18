package com.company.usermessagerela.controller;

import com.company.bean.ResponseDataListModel;
import com.company.enums.UserMessageRelaState;
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
import com.company.usermessagerela.model.UserMessageRela;
import com.company.usermessagerela.model.UserMessageRelaExample;
import com.company.usermessagerela.model.UserMessageRelaExample.Criteria;
import com.company.base.exception.BaseException;
import com.company.usermessagerela.service.UserMessageRelaService;
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
 * 	用户与消息关系信息
 * Controller类
 *
 */
@Api(value="用户与消息关系信息数据维护",tags={"用户与消息关系信息数据操作接口"})
@RestController("UserMessageRelaController")
@RequestMapping("/api/UserMessageRela")
public class UserMessageRelaController {

    public static Logger logger = LoggerFactory.getLogger(UserMessageRelaController.class);

    @Autowired
    private UserMessageRelaService<UserMessageRela, UserMessageRelaExample> service;


    /**
     * 	根据消息ID查询用户列表
     */
    @ApiOperation("根据消息ID查询用户列表")
    @PostMapping(value = "/getUserListByMgId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<UserMessageRela> getUserListByMgId(
            @RequestParam(required = true) @ApiParam(name="mgId",value="消息ID",required=true) String mgId
    ) {
        ResponseDataListModel<UserMessageRela> responseModel = new ResponseDataListModel<>();
        try {
            UserMessageRelaExample example = new UserMessageRelaExample();
            Criteria criteria = example.createCriteria();
            criteria.andMgidEqualTo(mgId);
            List<UserMessageRela> list = service.select(null, example);
            responseModel.setSuccess(true);
            responseModel.setList(list);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("根据消息ID查询用户列表成功");
        return responseModel;
    }
	
	/**
	 * 	用户与消息关系信息查询详情
	 */
	@ApiOperation("用户与消息关系信息信息详情")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<UserMessageRela> get(
    	@RequestParam(required = true) @ApiParam(name="id",value="主键",required=true) String id
    	) {
        ResponseDataModel<UserMessageRela> responseModel = new ResponseDataModel<>();
        try {
            UserMessageRela entity = service.get(id);
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
	 * 	各个用户消息中心信息分页查询
	 */
	@ApiOperation("分页查询消息中心信息数据")
    @PostMapping(value = "/getListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<UserMessageRela> getListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="usermgstate",value="用户对消息操作状态",required=true) String usermgstate,
            HttpServletRequest request
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},usermgstate:{}", currentPage, itemsPerPage, usermgstate);
        ResponseDataPageListForBootModel<UserMessageRela> responseModel = new ResponseDataPageListForBootModel<UserMessageRela>();
        String userId = request.getHeader("userId");
		try {
            UserMessageRelaExample example = new UserMessageRelaExample();
            //按主键倒序 查询
            example.setOrderByClause("CREATE_TIME desc");
            Criteria criteria = example.createCriteria();
            //用户对消息操作状态
            criteria.andUsermgstateEqualTo(usermgstate);
            //用户ID
            criteria.andUseridEqualTo(userId);
        	PageInfo<UserMessageRela> page = service.getListByPage(currentPage, itemsPerPage, example);
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
	 * 	发布消息
	 */
	@ApiOperation("发布消息数据")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<UserMessageRela> add(@RequestBody @ApiParam(name="用户与消息关系信息对象",value="传入json格式",required=true) UserMessageRela model,HttpServletRequest request) {
        ResponseDataModel<UserMessageRela> responseModel = new ResponseDataModel<UserMessageRela>();
        String userId = request.getHeader("userId");
        try {
            UserMessageRela record = new UserMessageRela();
            BeanUtils.copyProperties(model, record);
			record.setCreateUser(userId);
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
	 * 	全部撤回消息
	 */
	@ApiOperation("全部撤回消息")
    @PostMapping(value = "/reCallForAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel reCallForAll(
            @RequestBody @ApiParam(name="用户与消息关系信息对象",value="传入json格式",required=true) UserMessageRela model
    	) {
        ResponseModel responseModel = new ResponseModel();
        try {
            UserMessageRela record = new UserMessageRela();
            BeanUtils.copyProperties(model, record);
            service.delForAll(record);
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
     * 	部分撤回消息
     */
    @ApiOperation("部分撤回消息")
    @PostMapping(value = "/reCallForPart", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel reCallForPart(
            @RequestBody @ApiParam(name="用户与消息关系信息对象",value="传入json格式",required=true) UserMessageRela model
    ) {
        ResponseModel responseModel = new ResponseModel();
        try {
            UserMessageRela record = new UserMessageRela();
            BeanUtils.copyProperties(model, record);
            service.delForPart(record);
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
     * 	更新关系信息状态
     */
    @ApiOperation("更新关系信息状态")
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<UserMessageRela> update(@RequestBody @ApiParam(name="用户与消息关系信息对象",value="传入json格式",required=true) UserMessageRela model,HttpServletRequest request) {
        ResponseDataModel<UserMessageRela> responseModel = new ResponseDataModel<UserMessageRela>();
        String userId = request.getHeader("userId");
        try {
            UserMessageRela record = new UserMessageRela();
            BeanUtils.copyProperties(model, record);
            UserMessageRelaExample example = new UserMessageRelaExample();
            Criteria criteria = example.createCriteria();
            criteria.andUsermgstateEqualTo(record.getUsermgstatebefore());
            service.updateByExampleSelective(record, example);
            responseModel.setEntity(record);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("更新关系信息状态成功");
        return responseModel;
    }

    /**
     * 	更新整体状态
     */
    @ApiOperation("更新整体状态")
    @PostMapping(value = "/allChangeState", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataModel<UserMessageRela> allChangeState(
            @RequestParam(required = true) @ApiParam(name="usermgstate",value="用户对消息操作状态",required=true) String usermgstate,
            HttpServletRequest request) {
        ResponseDataModel<UserMessageRela> responseModel = new ResponseDataModel<UserMessageRela>();
        String userId = request.getHeader("userId");
        try {
            UserMessageRela record = new UserMessageRela();
            UserMessageRelaExample example = new UserMessageRelaExample();
            Criteria criteria = example.createCriteria();
            criteria.andUseridEqualTo(userId);
            if(usermgstate.equals(UserMessageRelaState.READ.getCode()) || usermgstate.equals(UserMessageRelaState.RESTORED.getCode())){
                //若是已读或是回收站则更新所有状态
                record.setUsermgstate(usermgstate);
                service.updateByExampleSelective(record, example);
            } else {
                //反之删除
                service.deleteByExample(example);
            }

            responseModel.setEntity(record);
        } catch (Exception e) {
            responseModel.setSuccess(false);
            responseModel.setMessage("Fail:" + e.getMessage());
            responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            logger.error("Fail:", e);
            return responseModel;
        }
        responseModel.setSuccess(true);
        responseModel.setMessage("更新关系信息状态成功");
        return responseModel;
    }
}