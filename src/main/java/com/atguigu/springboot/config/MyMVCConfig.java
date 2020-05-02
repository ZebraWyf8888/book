package com.atguigu.springboot.config;


import com.atguigu.springboot.component.LoginHandleInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/atguigu", "success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/bookuser").setViewName("userlogin");

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/index","/","/user/login","/bookuser","/img","/userlogin",
                        "/webjars/**","/asserts/**","**/favicon.ico");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
//    @Bean
//    public WebMvcConfigurationSupport webMvcConfigurerSupport() {
//        WebMvcConfigurationSupport a = new WebMvcConfigurationSupport() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//
//
//            }
//
//            @Override
//            protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/**")
//                        .addResourceLocations("classpath:/static/");
//            }
//        };
//
//        return a;
//    }

    ;


}
