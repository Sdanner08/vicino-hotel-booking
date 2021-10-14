package com.revature.location.find;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FindApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindApplication.class, args);
	}

}
