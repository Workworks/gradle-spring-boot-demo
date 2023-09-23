package org.kfaino.gradlespringbootdemo.eventlistenerdemo.simple;

public class WelcomeEmailListener {
    public void sendWelcomeEmail(UserRegisterEvent event) {
        System.out.println("Sending welcome email to " + event.getEmail());
    }
}