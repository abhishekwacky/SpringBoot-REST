package com.telusko.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, fully-qualified-class-name.method-name, args

    @Before("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp) {
        System.out.println("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExe(JoinPoint jp) {
        System.out.println("Method executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        System.out.println("Method has some issue " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        System.out.println("Method executed Successfully " + jp.getSignature().getName());
    }
}
