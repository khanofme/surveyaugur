package com.stackroute.alerting_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AlertingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertingServiceApplication.class, args);
	}

}
