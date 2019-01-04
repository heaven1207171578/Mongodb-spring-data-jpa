package com.bucom.boot;

import com.bucom.boot.utils.IdWorker;
import com.bucom.boot.utils.JWTUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
@EnableEurekaClient
@SpringBootApplication
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
		
	}

	@Bean
	public IdWorker idWorker(){
		return new IdWorker();
	}
	@Bean
	public JWTUtils jwtUtil(){

		return  new JWTUtils();
	}
}

