package com.epc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class EpcMobileGatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EpcMobileGatewayApplication.class).web(true).run(args);
	}

}
