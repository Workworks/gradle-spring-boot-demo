package org.kfaino.core.other;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(50) // order值小，优先级高
public class LoggingAspect {
    
    @Before("execution(* org.kfaino.gradlespringbootdemo.transaction.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // ...日志处理逻辑...
        System.out.println("Logging Before Method Execution: " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* org.kfaino.gradlespringbootdemo.transaction.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        // ...日志处理逻辑...
        System.out.println("Logging After Method Execution: " + joinPoint.getSignature().getName());
    }
}
