package com.atguigu.springboot.listener;


        import javax.servlet.ServletContextEvent;
        import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitializdf is run");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextInitializdf is destory");
    }
}
