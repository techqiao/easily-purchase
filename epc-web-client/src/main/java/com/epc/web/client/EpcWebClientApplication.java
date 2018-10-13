package com.epc.web.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EpcWebClientApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcWebClientApplication.class).web(true).run(args);
	}
}
