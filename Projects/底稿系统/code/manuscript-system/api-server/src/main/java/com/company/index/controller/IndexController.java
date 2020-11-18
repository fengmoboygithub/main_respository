package com.company.index.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.constant.BaseConstant;
import com.company.userinfo.model.UserTab;
import com.company.userinfo.model.UserTabExample;
import com.company.userinfo.model.UserTabExample.Criteria;
import com.company.userinfo.service.UserTabService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 	仪表盘
 * Controller类
 *
 */
@Api(value="仪表盘数据维护",tags={"仪表盘数据操作接口"})
@RestController("IndexController")
@RequestMapping("/api/Index")
public class IndexController {

    public static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserTabService<UserTab, UserTabExample> service;
	
	/**
	 * 	仪表盘--用户信息分页查询
	 */
	@ApiOperation("仪表盘--用户信息分页查询")
    @PostMapping(value = "/getUserTabListByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<UserTab> getUserTabListByPage(
    		@RequestParam(required = false) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage, 
    		@RequestParam(required = false) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
    		@RequestParam(required = false) @ApiParam(name="id",value="主键",required=true) Long id
    	)  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},id:{}", currentPage, itemsPerPage, id);
        ResponseDataPageListForBootModel<UserTab> responseModel = new ResponseDataPageListForBootModel<UserTab>();
        
		try {
            UserTabExample example = new UserTabExample();
            //按主键倒序 查询
            example.setOrderByClause("id desc");
            Criteria criteria = example.createCriteria();
            criteria.andIsDeleteEqualTo(BaseConstant.DEL_FLAG_NO);
            
            //若主键不为空
            if (!StringUtils.isEmpty(id)) {
            	criteria.andIdEqualTo(id);
            }
        	PageInfo<UserTab> page = service.getListByPage(currentPage, itemsPerPage, example);
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

}