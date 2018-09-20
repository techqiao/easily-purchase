package com.epc.web.client.controller.common.config;

import com.epc.web.client.controller.common.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description : 配置文件
 * <p>Date : 2018-09-14 09:40
 * <p>@Author : wjq
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 注入一个过滤器到mvc容器
     * @return
     */
    @Bean
    public FilterRegistrationBean characterEncodingFilterRegister(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF8");
        filter.setForceEncoding(true);
        registrationBean.setFilter(filter);
        List<String> list = new ArrayList<>();
        list.add("/*");
        registrationBean.setUrlPatterns(list);
        return  registrationBean;
    }

    @Autowired
    private AuthorityInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将拦截器添加到mvc容器
        registry.addInterceptor(timeInterceptor).excludePathPatterns("/roleLogin");
    }
}
