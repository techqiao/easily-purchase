package com.epc.ossutil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
public class EpcOssUtilServiceApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcOssUtilServiceApplication.class).web(true).run(args);
	}
}
