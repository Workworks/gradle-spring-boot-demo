package org.kfaino.gradlespringbootdemo.eventlistenerdemo.simple;

public class UserRegisterLogListener {
    public void logUserRegister(UserRegisterEvent event) {
        System.out.println("Logging user register: " + event.getUsername());
    }
}