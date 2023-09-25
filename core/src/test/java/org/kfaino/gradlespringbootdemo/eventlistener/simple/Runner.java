package org.kfaino.gradlespringbootdemo.eventlistener.simple;

public class Runner {
    public static void main(String[] args) {
        // 创建UserRegisterService实例
        UserRegisterService userRegisterService = new UserRegisterService();

        // 向UserRegisterService中添加监听器
        userRegisterService.addListener(new WelcomeEmailListener());
        userRegisterService.addListener(new UserRegisterLogListener());

        // 模拟用户注册
        userRegisterService.registerUser("kfaino", "kfaino@example.com");
    }
}