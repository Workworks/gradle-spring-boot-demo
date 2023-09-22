package org.kfaino.gradlespringbootdemo.simple;


public class UserRegisterEvent {
    private final String username;
    private final String email;

    public UserRegisterEvent(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}