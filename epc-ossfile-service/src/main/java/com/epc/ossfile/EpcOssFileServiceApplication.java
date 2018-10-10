package com.epc.ossfile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.epc.ossfile")
@MapperScan(value = "com.epc.ossfile.mapper")
public class EpcOssFileServiceApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcOssFileServiceApplication.class).web(true).run(args);
	}
}
