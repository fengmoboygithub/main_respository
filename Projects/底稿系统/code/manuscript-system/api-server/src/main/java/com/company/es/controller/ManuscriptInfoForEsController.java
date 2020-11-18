package com.company.es.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.base.exception.BaseException;
import com.company.bean.ResponseDataListModel;
import com.company.bean.ResponseDataModel;
import com.company.bean.ResponseDataPageListForBootModel;
import com.company.bean.ResponseModel;
import com.company.enums.DataPermission;
import com.company.es.model.ManuscriptInfoForEs;
import com.company.es.repository.ManuscriptInfoForEsRepository;
import com.company.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * 	底稿索引信息--用于底稿信息搜索
 * Controller类
 *
 */
@Api(value="底稿索引信息",tags={"底稿索引信息操作接口"})
@RestController("ManuscriptInfoForEsController")
@RequestMapping("/api/es")
public class ManuscriptInfoForEsController {

    public static Logger logger = LoggerFactory.getLogger(ManuscriptInfoForEsController.class);

    /**
	 * 存储在es里的持久化操作类
	 */
	@Autowired
    private ManuscriptInfoForEsRepository manuscriptInfoForEsRepository;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 	查看底稿服务接口
     */
    @ApiOperation("查看底稿服务接口")
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptInfoForEs> get(
            @RequestParam(required = true) @ApiParam(name="id",value="主键id",required=true) String id
    ) {
        ResponseDataModel<ManuscriptInfoForEs> responseModel = new ResponseDataModel<>();
        try {
            Optional<ManuscriptInfoForEs> entity = manuscriptInfoForEsRepository.findById(id);
            responseModel.setSuccess(true);
            responseModel.setEntity(entity.get());
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
	 * 	关键字搜索底稿服务接口
	 */
	@ApiOperation("关键字搜索底稿服务接口")
    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataListModel<ManuscriptInfoForEs> search(
    	@RequestParam(required = true) @ApiParam(name="keyword",value="关键字",required=true) String keyword,
    	@RequestParam(required = true) @ApiParam(name="historyFlag",value="是否显示历史版本",required=true) String historyFlag
    	) {
		ResponseDataListModel<ManuscriptInfoForEs> responseModel = new ResponseDataListModel<>();
        try {
        	List<ManuscriptInfoForEs> list = manuscriptInfoForEsRepository.findByDocnameAndNewversionflag(keyword, historyFlag);
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
        responseModel.setMessage("详情查询成功");
        return responseModel;
    }

	/**
	 * 	关键字搜索底稿服务接口--分页
	 */
	@ApiOperation("关键字搜索底稿服务接口--分页")
    @PostMapping(value = "/searchByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDataPageListForBootModel<ManuscriptInfoForEs> searchByPage(
    		@RequestParam(required = true) @ApiParam(name="currentPage",value="当前页数",required=true) int currentPage,
    		@RequestParam(required = true) @ApiParam(name="itemsPerPage",value="每页最多显示条数",required=true) int itemsPerPage,
        	@RequestParam(required = true) @ApiParam(name="historyFlag",value="是否显示历史版本",required=true) String historyFlag,
    		@RequestParam(required = false) @ApiParam(name="keyword",value="全文检索",required=false) String keyword,
            @RequestParam(required = false) @ApiParam(name="docname",value="文件名称",required=false) String docname,
            @RequestParam(required = false) @ApiParam(name="projectname",value="项目名称",required=false) String projectname,
            HttpServletRequest request,
            HttpServletResponse response
            )  throws BaseException{
        logger.info("currentPage:{},itemsPerPage:{},keyword:{},historyFlag:{}", currentPage, itemsPerPage, keyword, historyFlag);
        ResponseDataPageListForBootModel<ManuscriptInfoForEs> responseModel = new ResponseDataPageListForBootModel<ManuscriptInfoForEs>();

		try {
			if(currentPage <= 0){
				currentPage = 0;
	    	} else {
	    		currentPage = currentPage - 1;
	    	}

            String userId = request.getHeader("userId");
            logger.info("userId："+userId);
            String dataPermission = "";
            //通过usdid获取数据权限
            if(!StringUtils.isEmpty(userId)){
                if(redisUtil.hasKey(String.valueOf(userId))){
                    dataPermission = redisUtil.get(String.valueOf(userId));
                    logger.info(String.valueOf(userId) + "的数据权限为:"+dataPermission);
                    if (!StringUtils.isEmpty(dataPermission)) {
                        //数据权限条件
                        JSONArray jsonArray = JSONArray.parseArray(dataPermission);
                        if(jsonArray != null){
                            for(int i=0;i<jsonArray.size();i++){
                                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                                String name = jsonObject.get("name").toString();
                                String [] value = jsonObject.get("value").toString().split(",");
                                //根据name去拼写sql条件
                                if(value.length>0){
                                    if(DataPermission.PROJECT.getCode().equals(name)){
                                        //项目id集合
                                        Set set = new HashSet<String>();
                                        for(String str: value) {
                                            set.add(str);
                                        }
                                        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
                                        queryBuilder.must(QueryBuilders.termQuery("newversionflag.keyword",historyFlag))
                                                .must(QueryBuilders.termsQuery("projectid", set));
                                        if (!StringUtils.isEmpty(keyword)) {
                                            queryBuilder.must(QueryBuilders.matchQuery("keyword",keyword));
                                        }
                                        if (!StringUtils.isEmpty(docname)) {
                                            queryBuilder.must(QueryBuilders.matchPhrasePrefixQuery("docname", docname));
                                        }
                                        if (!StringUtils.isEmpty(projectname)) {
                                            queryBuilder.must(QueryBuilders.matchPhrasePrefixQuery("projectname", projectname));
                                        }

                                        Sort sort = new Sort(Sort.Direction.DESC, "uploadtime");
                                        PageRequest pageRequest = PageRequest.of(currentPage, itemsPerPage, sort);
                                        Page<ManuscriptInfoForEs> page = manuscriptInfoForEsRepository.search(queryBuilder, pageRequest);
                                        responseModel.setSuccess(true);
                                        responseModel.setPageIndex(currentPage);
                                        responseModel.setPageSize(itemsPerPage);
                                        responseModel.setRecordsTotal(page.getTotalElements());
                                        responseModel.setData(page.getContent());
                                        responseModel.setRecordsFiltered(page.getContent()==null?0:page.getContent().size());
                                        responseModel.setMessage("分页查询成功");
                                    }
                                }else{
                                    responseModel.setSuccess(true);
                                    responseModel.setPageIndex(currentPage);
                                    responseModel.setPageSize(itemsPerPage);
                                    responseModel.setRecordsTotal(0);
                                    responseModel.setData(null);
                                    responseModel.setRecordsFiltered(0);
                                    responseModel.setMessage("分页查询成功");
                                    return responseModel;
                                }
                            }
                        }else{
                            responseModel.setSuccess(true);
                            responseModel.setPageIndex(currentPage);
                            responseModel.setPageSize(itemsPerPage);
                            responseModel.setRecordsTotal(0);
                            responseModel.setData(null);
                            responseModel.setRecordsFiltered(0);
                            responseModel.setMessage("分页查询成功");
                            return responseModel;
                        }
                    }
                }else{
                    responseModel.setSuccess(false);
                    responseModel.setMessage("Fail:" + "无法获取数据权限信息");
                    responseModel.setCode(HttpStatus.UNAUTHORIZED.value());
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    logger.error("Fail:无法获取数据权限信息");
                    return responseModel;
                }
            } else{
                responseModel.setSuccess(false);
                responseModel.setMessage("Fail:" + "无法获取用户信息");
                responseModel.setCode(HttpStatus.UNAUTHORIZED.value());
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                logger.error("Fail:无法获取用户信息");
                return responseModel;
            }
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
	 * 	建立底稿索引服务接口
	 */
	@ApiOperation("建立底稿索引服务接口")
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptInfoForEs> add(@RequestBody @ApiParam(name="底稿索引信息对象",value="传入json格式",required=true) ManuscriptInfoForEs model,HttpServletRequest request) {
        ResponseDataModel<ManuscriptInfoForEs> responseModel = new ResponseDataModel<ManuscriptInfoForEs>();
        try {
        	ManuscriptInfoForEs record = new ManuscriptInfoForEs();
            BeanUtils.copyProperties(model, record);
            manuscriptInfoForEsRepository.save(record);
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
	 * 	编辑底稿索引服务接口
	 */
	@ApiOperation("编辑底稿索引服务接口")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseDataModel<ManuscriptInfoForEs> update(@RequestBody @ApiParam(name="底稿索引信息对象",value="传入json格式",required=true) ManuscriptInfoForEs model,HttpServletRequest request) {
        ResponseDataModel<ManuscriptInfoForEs> responseModel = new ResponseDataModel<ManuscriptInfoForEs>();
        try {
        	ManuscriptInfoForEs record = new ManuscriptInfoForEs();
            BeanUtils.copyProperties(model, record);
            manuscriptInfoForEsRepository.save(record);
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
	 * 	删除底稿索引服务接口
	 */
	@ApiOperation("删除底稿索引服务接口")
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel delete(
    	@ApiParam(name="id",value="底稿ID",required=true) String id,HttpServletRequest request
    	) {
        ResponseModel responseModel = new ResponseModel();
        try {
            manuscriptInfoForEsRepository.deleteById(id);
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