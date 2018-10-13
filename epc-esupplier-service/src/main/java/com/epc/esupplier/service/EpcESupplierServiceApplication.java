package com.epc.esupplier.service;

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
public class EpcESupplierServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcESupplierServiceApplication.class).web(true).run(args);
	}

}
