package com.epc.operator.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EpcOperatorServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcOperatorServiceApplication.class).web(true).run(args);
	}

}
