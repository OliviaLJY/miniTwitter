package com.example.mytwitter.config;


import com.example.mytwitter.interceptor.LogInInterceptor;
import com.example.mytwitter.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LogInInterceptor logInInterceptor;

    @Resource
    LogInterceptor logInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(logInInterceptor)
                .addPathPatterns("/tweets/*")
                .excludePathPatterns("/user/login", "/user/createUser");


        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
    }
}
