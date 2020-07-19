package com.mycls.demo.confirgure;

import com.mycls.demo.component.MyLocaleResolver;
import com.mycls.demo.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class Config implements WebMvcConfigurer {
    //国际化请求
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
    //跳转
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/register.html").setViewName("register");
            }

            //配置拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).
//                        addPathPatterns("/main.html").excludePathPatterns("/index.html", "/",
//                        "/login", "/login.html",
//                        "/static/asserts/**", "/static/", "/webjars/**");
//            }
        };
        return configurer;
    }
}