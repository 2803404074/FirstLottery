package com.spring.interceptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Test implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("启动..........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁 ..........");
    }
}
