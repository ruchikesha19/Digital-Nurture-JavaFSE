package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.library.service.BookService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("[AOP-LOG] Starting execution of method: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("[AOP-LOG] Finished execution of method: " + joinPoint.getSignature().getName() + " | Time elapsed: " + (endTime - startTime) + "ms");
        return result;
    }
}
