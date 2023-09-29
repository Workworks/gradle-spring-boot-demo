package org.kfaino.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EntityScan(basePackages = "org.kfaino.core.transaction.entity")
// 声明式事务需要开启该注解，等同于Spring中如下XML配置：
//	<tx:advice id="txAdvice" transaction-manager="transactionManager">
//	<tx:attributes>
//	<tx:method name="*" propagation="REQUIRED"/>
//	</tx:attributes>
//	</tx:advice>
// 2023-09-24 看起来这个注解也可以不需要，除非在一些定制化细节上使用
//@EnableTransactionManagement
/**
 * order : 事务本身也是切面实现的，如果你想要日志切面先于事务，可以调整：order=500; 数字越大优先级越低(实操之后发现，日志切面依然先于Transactional代理的方法)
 * mode :  有两种值，顾名思义JDK代理或者Aspect代理
 * 				- AdviceMode.PROXY
 * 			 	- AdviceMode.ASPECTJ
 */
@EnableTransactionManagement(order = 1, mode = AdviceMode.ASPECTJ)
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}


	// 定义多个事务管理器
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManagerOne(DataSource dataSourceOne) {
		return new DataSourceTransactionManager(dataSourceOne);
	}

//	@Bean(name = "transactionManagerTwo")
//	public PlatformTransactionManager transactionManagerTwo(DataSource dataSourceTwo) {
//		return new DataSourceTransactionManager(dataSourceTwo);
//	}


}
