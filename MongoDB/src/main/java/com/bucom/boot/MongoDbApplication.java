package com.bucom.boot;

import com.bucom.boot.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
		
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker();
	}
}
