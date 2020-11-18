package com.company.Aspect;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.base.exception.BaseException;
import com.company.loginfo.model.LogInfo;
import com.company.loginfo.service.LogInfoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    private LogInfoService logInfoService;

    /** 以 controller 包下定义的所有请求为切入点 */
    @Pointcut("execution(public * com.company..*.*Controller.*(..))")
    public void webLog() {}
    /**
     * 判断字符串是否可以转化为json对象
     * @param content
     * @return
     */
    public static boolean isJsonObject(Object[] content) {
        // 此处应该注意，不要使用StringUtils.isEmpty(),因为当content为"  "空格字符串时，JSONObject.parseObject可以解析成功，
        // 实际上，这是没有什么意义的。所以content应该是非空白字符串且不为空，判断是否是JSON数组也是相同的情况。
        if(StringUtils.isEmpty(content))
            return false;
        try {
            Object jsonStr = JSONObject.toJSON(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args   : {}", joinPoint.getArgs());
        if(WebLogAspect.isJsonObject(joinPoint.getArgs())){
            logger.info("Request Args   : {}", JSONObject.toJSON(joinPoint.getArgs()));
            LogInfo logInfo = new LogInfo();
            logInfo.setId(UUID.randomUUID().toString().replace("-",""));
            logInfo.setRequesttype(request.getMethod());
            logInfo.setRequesturl(request.getRequestURL().toString());
            logInfo.setRequestcontrollerpath(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
            logInfo.setRequestparams(JSONObject.toJSON(joinPoint.getArgs()).toString());
            logInfo.setCreateTime(new Date());
            try {
                logInfoService.save(logInfo);
            } catch (BaseException e) {
                e.printStackTrace();
            }
        } else {
            logger.info("Request Args   : {}", joinPoint.getArgs());
            LogInfo logInfo = new LogInfo();
            logInfo.setId(UUID.randomUUID().toString().replace("-",""));
            logInfo.setRequesttype(request.getMethod());
            logInfo.setRequesturl(request.getRequestURL().toString());
            logInfo.setRequestcontrollerpath(joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
            logInfo.setRequestparams(joinPoint.getArgs().toString());
            logInfo.setCreateTime(new Date());
            try {
                logInfoService.save(logInfo);
            } catch (BaseException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
        logger.info("=========================================== End ===========================================");
        // 每个请求之间空一行
        logger.info("");
    }

    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.debug(throwable.getMessage());
        }
        // 打印出参
        logger.info("Response Args  : {}", JSON.toJSONString(result));
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }
}
