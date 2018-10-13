package com.epc.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author SongXing
 * @Description: 支付服务
 * @date 2018-10-12 14:38:22
 */

@EnableDiscoveryClient
@SpringBootApplication
public class EpcPaymentServiceApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcPaymentServiceApplication.class).web(true).run(args);
	}
}
