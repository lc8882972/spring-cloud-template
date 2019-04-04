package com.yan.sa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    /**
     * 定义拦截规则：拦截annotation。
     */
    @Pointcut("@annotation(com.yan.sa.annotation.LogEnable)")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.info("doBefore()");
    }

    @AfterReturning("log()")
    public  void  doAfterReturning()throws  Throwable{
        logger.info("doAfterReturning()");
    }

    @AfterThrowing("log()")
    public  void  doAfterThrowing()throws  Throwable{
        logger.info("doAfterThrowing()");
    }

    @After("log()")
    public  void  doAfter() throws  Throwable{
        logger.info("doAfter()");
    }

    @Around("log()")
    public  Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        logger.info("doAround()");
        return proceedingJoinPoint.proceed();
    }
}
