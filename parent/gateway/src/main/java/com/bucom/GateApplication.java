package com.bucom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import utils.JWTUtils;

/**
 * @author HeavenY
 * @date 2019/1/19 14:30
 */
@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
public class GateApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateApplication.class, args);

    }

    @Bean
    public JWTUtils jwtUtil() {

        return new JWTUtils();
    }
}
