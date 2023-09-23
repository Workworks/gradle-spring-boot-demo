package org.kfaino.gradlespringbootdemo.eventlistenerdemo.publisher;

import org.kfaino.gradlespringbootdemo.eventlistenerdemo.event.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TestEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        // [2]使用publishEvent方法发布事件，事件源为TestEvent
        applicationEventPublisher.publishEvent(new TestEvent(this, message));
    }
}
