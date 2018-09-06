package com.epc.mobile.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EpcMobileServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcMobileServiceApplication.class).web(true).run(args);
	}

}
