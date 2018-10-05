package com.epc.bidding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.epc.bidding")
@MapperScan(value = "com.epc.bidding.mapper")
public class EpcBidServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcBidServiceApplication.class).web(true).run(args);
	}

}
