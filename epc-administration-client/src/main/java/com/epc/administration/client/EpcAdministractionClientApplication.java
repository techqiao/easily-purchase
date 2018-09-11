package com.epc.administration.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EpcAdministractionClientApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcAdministractionClientApplication.class).web(true).run(args);
	}

}
