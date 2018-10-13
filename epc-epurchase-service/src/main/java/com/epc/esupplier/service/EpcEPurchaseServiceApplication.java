package com.epc.esupplier.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>Description : 招标服务入口类
 * <p>Date : 2018-10-13 17:20:07
 * <p>@Author : luozhixin
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.epc.")
@MapperScan("com.epc.tendering.service.mapper.*")
public class EpcEPurchaseServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcEPurchaseServiceApplication.class).web(true).run(args);
	}

}
