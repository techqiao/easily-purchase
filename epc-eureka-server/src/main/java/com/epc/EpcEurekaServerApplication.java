package com.epc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EpcEurekaServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcEurekaServerApplication.class).web(true).run(args);
	}

}
