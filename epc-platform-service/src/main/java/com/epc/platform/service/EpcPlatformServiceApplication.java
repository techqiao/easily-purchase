package com.epc.platform.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 01
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.epc.platform.service.mapper")
public class EpcPlatformServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcPlatformServiceApplication.class).web(true).run(args);
	}

}
