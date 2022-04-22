package com.tsbx.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/4/19 10:05
 */
@Aspect      
@Component
@Slf4j
public class LogAspect {
    @Pointcut("@annotation(com.tsbx.common.annotation.Log)")
    public void pointcut() { }

    @Before("pointcut()")
    public void before(){
        log.info("方法执行前");   
    }
    
    @Around("pointcut()")
    public void around(ProceedingJoinPoint point){
        log.info("环绕通知");
        long beginTime = System.currentTimeMillis();
        Object result = null;
       try {
        // 执行方法
        result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        log.info("耗时："+time);

    }
    
    
    
    @AfterReturning("pointcut()")
    public void AfterReturning(){
        log.info("方法执行后返回");
    }
    
    

}
