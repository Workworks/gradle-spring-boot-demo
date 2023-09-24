package org.kfaino.gradlespringbootdemo.eventListener.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // TODO 在这里可以执行一些初始化操作，比如查询数据库，缓存数据，加载配置等
//        System.out.println("Spring容器加载完成触发");
    }
}
