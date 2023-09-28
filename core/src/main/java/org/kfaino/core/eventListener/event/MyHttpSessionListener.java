package org.kfaino.core.eventListener.event;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.stereotype.Component;

@Component
public class MyHttpSessionListener implements HttpSessionListener {
    public static Integer count = 0; //记录在线的用户数量

    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("新用户上线了");
        count++;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("用户下线了");
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }
}
