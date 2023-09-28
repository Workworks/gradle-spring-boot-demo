package org.kfaino.datasource.aspect;

import org.springframework.stereotype.Component;

@Component
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源
    public static void setDataSource(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    // 获取数据源
    public static String getDataSource() {
        return contextHolder.get();
    }

    // 清除数据源
    public static void clearDataSource() {
        contextHolder.remove();
    }
}
