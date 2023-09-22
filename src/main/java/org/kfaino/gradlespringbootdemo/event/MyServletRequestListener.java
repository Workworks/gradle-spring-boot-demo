package org.kfaino.gradlespringbootdemo.event;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("session id为：" + request.getRequestedSessionId());
        System.out.println("request url为：" + request.getRequestURL());
        request.setAttribute("name", "斌哥");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request end");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("request域中保存的name值为：" + request.getAttribute("name"));
    }
}
