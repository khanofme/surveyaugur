package com.stackroute.user_microservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableEurekaClient
@EnableOAuth2Client
@SpringBootApplication

public class UserMicroserviceApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UserMicroserviceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}


}
