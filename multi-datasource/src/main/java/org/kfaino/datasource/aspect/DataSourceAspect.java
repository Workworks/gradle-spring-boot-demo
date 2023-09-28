package org.kfaino.datasource.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kfaino.datasource.annotation.DataSource;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    @Around("@annotation(dataSource)")
    public Object around(ProceedingJoinPoint pjp, DataSource dataSource) throws Throwable {
        try {
            // 设置数据源
            DataSourceContextHolder.setDataSource(dataSource.value());
            return pjp.proceed();
        } finally {
            // 清除数据源
            DataSourceContextHolder.clearDataSource();
        }
    }
}
