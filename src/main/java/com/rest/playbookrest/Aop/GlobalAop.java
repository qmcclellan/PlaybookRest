package com.rest.playbookrest.Aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GlobalAop {

    Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("within(@org.springframework.stereotype.Repository *)"
            + " || within(@org.springframework.stereotype.Service *)"
            + " || within(@org.springframework.stereotype.Controller *)")
    public void springBeanPointcut() {
        throw new UnsupportedOperationException();


    }

    @Pointcut("within(com.rest.playbookrest.Dao.*.*)"
            + " || within(com.rest.playbookrest.Service.*.*)"
            + " || within(com.rest.playbookrest.Controller.*.*)"
            + " || within(com.rest.playbookrest.Dto.*.*)")
    public void applicationPackagePointcut() {
        throw new UnsupportedOperationException();
    }

    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getMessage() : "NULL");
    }

    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        final String joinPoints = Arrays.toString(joinPoint.getArgs());
        if (joinPoints != null) {
            logger.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), joinPoints);
        }
        final Object result = joinPoint.proceed();
        logger.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);
        return result;
    }
}
