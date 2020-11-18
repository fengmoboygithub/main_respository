package com.company.base.controller;

import com.company.bean.ResponseDataPageListForBootModel;
import com.company.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

public class BaseController {

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private RedisUtil redisUtil;
    /**
     * 根据userId获取redis缓存中的数据权限
     * @param userId
     * @return
     */
    public Object getDataPermission(String userId, ResponseDataPageListForBootModel responseModel, HttpServletResponse response){
        String dataPermission = "";
        //通过usdid获取数据权限
        if(!StringUtils.isEmpty(userId)){
            if(redisUtil.hasKey(userId)){
                dataPermission = redisUtil.get(userId);
                logger.info(userId + "的数据权限为:"+dataPermission);
            }else{
                responseModel.setSuccess(false);
                responseModel.setMessage("Fail:" + "无法获取数据权限信息");
                responseModel.setCode(HttpStatus.UNAUTHORIZED.value());
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                logger.error("Fail:无法获取数据权限信息");
                return responseModel;
            }
        }
        return dataPermission;
    }
}
