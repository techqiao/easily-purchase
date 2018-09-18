package com.epc.web.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(value = "com.epc.web.service.mapper")
public class EpcUserServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcUserServiceApplication.class).web(true).run(args);
	}

}
