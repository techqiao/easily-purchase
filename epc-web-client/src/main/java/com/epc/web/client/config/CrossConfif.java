package com.epc.web.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CrossConfif {
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
//                        .allowCredentials(true)
//                        .allowedOrigins("http://192.168.10.115:8010")
//                        .allowedHeaders()
//                        .
//                        .maxAge(3600);
//            }
//
//        };
//    }
}