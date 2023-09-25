package org.kfaino.gradlespringbootdemo.eventlistener.listener;

import org.kfaino.gradlespringbootdemo.eventlistener.event.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        // [3]在这里可以执行监听到事件后的逻辑, 监听到事件源，触发动作！
        System.out.println("监听到TestEvent：" + testEvent.getMessage());
    }
}