package com.epc.web.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // AccessKeyInterceptor（跨域拦截器）
        // 对来自/**这个链接的请求进行拦截
        registry.addInterceptor(new AccessKeyInterceptor()).addPathPatterns("/**");

    }
}
