package com.epc.administration.client;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@MapperScan(value = "com.epc.administration.client")
public class EpcAdministractionClientApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcAdministractionClientApplication.class).web(true).run(args);
	}

}
