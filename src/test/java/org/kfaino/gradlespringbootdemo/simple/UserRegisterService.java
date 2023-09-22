package org.kfaino.gradlespringbootdemo.simple;

import java.util.ArrayList;
import java.util.List;

public class UserRegisterService {
    private final List<Object> listeners = new ArrayList<>();

    public void registerUser(String username, String email) {
        // 用户注册逻辑（略）
        System.out.println("User registered: " + username);
        
        // 发布事件
        UserRegisterEvent event = new UserRegisterEvent(username, email);
        for (Object listener : listeners) {
            if (listener instanceof WelcomeEmailListener) {
                ((WelcomeEmailListener) listener).sendWelcomeEmail(event);
            } else if (listener instanceof UserRegisterLogListener) {
                ((UserRegisterLogListener) listener).logUserRegister(event);
            }
        }
    }

    public void addListener(Object listener) {
        listeners.add(listener);
    }
}