package com.yan.gateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;

@SpringBootApplication
@EnableDiscoveryClient
public class Gateway2Application {

//	@Autowired
//	TokenRelayGatewayFilterFactory factory;

	public static void main(String[] args) {
		SpringApplication.run(Gateway2Application.class, args);
	}
}
