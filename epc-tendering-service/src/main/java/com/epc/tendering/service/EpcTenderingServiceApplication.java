package com.epc.tendering.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Description : 招标服务入口类
 * <p>Date : 2018-09-13 19:27
 * <p>@Author : wjq
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.epc.tendering.service.mapper")
public class EpcTenderingServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcTenderingServiceApplication.class).web(true).run(args);
	}

}
