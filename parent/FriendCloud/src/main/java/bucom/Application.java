package bucom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import utils.JWTUtils;


@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient //开启发现服务
@EnableFeignClients //使用fegin来发现服务 还有rabbion等等
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public JWTUtils jwtUtil(){

		return  new JWTUtils();
	}
}
