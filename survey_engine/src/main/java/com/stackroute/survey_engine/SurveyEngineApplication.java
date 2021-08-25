package com.stackroute.survey_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class SurveyEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyEngineApplication.class, args);
	}

}
