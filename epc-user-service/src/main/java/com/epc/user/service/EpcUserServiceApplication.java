package com.epc.user.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EpcUserServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcUserServiceApplication.class).web(true).run(args);
	}

}
