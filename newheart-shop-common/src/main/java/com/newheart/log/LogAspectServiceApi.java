package com.newheart.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @author hanjie
 * @date 2019/9/29 9:12
 */

@Aspect
@Component
@Slf4j
public class LogAspectServiceApi {

    /** 申明一个切点 指定切入点表达式*/
    @Pointcut(value = "execution( * com.newheart.service.*.*(..))")
    private void controllerAspect(){
    }

    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("===============请求内容===============");
//      打印日志相关信息
        try {
            log.info("请求地址：" + request.getRequestURL());
            log.info("请求方法：" + request.getMethod());
            log.info("请求类方法：" + joinPoint.getSignature());
            log.info("请求类方法参数" + Arrays.toString(joinPoint.getArgs()));
        }catch (Exception e){
            log.error("methodBefore_Error: ",e);
        }
    }
    @AfterReturning(pointcut = "controllerAspect()",returning = "o")
    public void methodAfterReturing(Object o){
        log.info("------------返回内容------------");
        try {
            log.info("Response内容：" + JSON.toJSONString(o));
        }catch (Exception e){
            log.error("methodAfterReturing_error",e);
        }
        log.info("-----------返回内容-------------");
    }
}
