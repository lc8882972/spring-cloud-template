package com.yan.sa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebSecurity
@EnableResourceServer
@EnableJpaRepositories(basePackages = "com.yan.sa.repositories")
@EntityScan(basePackages = "com.yan.sa.entities")
public class SaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaApplication.class, args);
	}

}
