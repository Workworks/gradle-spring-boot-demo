package org.kfaino.gradlespringbootdemo.listener;

import org.kfaino.gradlespringbootdemo.event.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        // 在这里可以执行监听到事件后的逻辑
        System.out.println("监听到TestEvent：" + testEvent.getMessage());
    }
}