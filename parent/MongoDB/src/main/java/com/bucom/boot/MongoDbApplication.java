package com.bucom.boot;

import com.bucom.boot.utils.IdWorker;
import com.bucom.boot.utils.JWTUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableEurekaClient
@SpringBootApplication
public class MongoDbApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);

    }


    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

    @Bean
    public JWTUtils jwtUtil() {

        return new JWTUtils();
    }
}

