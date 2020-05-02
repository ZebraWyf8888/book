package com.atguigu.springboot.config;

//import com.atguigu.springboot.filter.MyFilter;
//import com.atguigu.springboot.listener.MyListener;
//import com.atguigu.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import javax.servlet.ServletRegistration;
import java.util.Arrays;

@Configuration
public class MyServerConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryWebServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8093);
            }
        };
    }

//    @Bean
//    public ServletRegistrationBean myServlet(){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
//        return registrationBean;
//    }
//    @Bean
//    public FilterRegistrationBean myFilter(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new MyFilter());
//        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
//        return registrationBean;
//    }
//    @Bean
//    public ServletListenerRegistrationBean myListener(){
//        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
//        return registrationBean;
//    }

}
