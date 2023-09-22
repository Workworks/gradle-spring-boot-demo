package org.kfaino.gradlespringbootdemo;

import org.junit.jupiter.api.Test;
import org.kfaino.gradlespringbootdemo.publisher.TestEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GradleSpringBootDemoApplicationTests {


	@Autowired
	private TestEventPublisher testEventPublisher;

	@Test
	void contextLoads() {
		testEventPublisher.publish("Hello, Spring!");
	}
}