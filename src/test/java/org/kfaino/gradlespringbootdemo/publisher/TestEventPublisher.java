package org.kfaino.gradlespringbootdemo.publisher;

import org.kfaino.gradlespringbootdemo.event.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TestEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        // 使用publishEvent方法发布事件
        applicationEventPublisher.publishEvent(new TestEvent(this, message));
    }
}
