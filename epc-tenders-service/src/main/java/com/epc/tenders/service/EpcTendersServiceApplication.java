package com.epc.tenders.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EpcTendersServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcTendersServiceApplication.class).web(true).run(args);
	}

}
