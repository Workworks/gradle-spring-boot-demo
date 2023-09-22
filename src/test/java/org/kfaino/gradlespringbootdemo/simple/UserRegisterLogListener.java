package org.kfaino.gradlespringbootdemo.simple;

public class UserRegisterLogListener {
    public void logUserRegister(UserRegisterEvent event) {
        System.out.println("Logging user register: " + event.getUsername());
    }
}