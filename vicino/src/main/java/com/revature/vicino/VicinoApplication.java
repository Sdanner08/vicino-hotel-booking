package com.revature.vicino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VicinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VicinoApplication.class, args);
	}


	//https://github.com/eugenp/tutorials/tree/master/spring-kafka
	//https://www.baeldung.com/spring-kafka
}
