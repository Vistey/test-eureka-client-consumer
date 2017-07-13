package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * http://blog.didispace.com/spring-cloud-starter-dalston-2-1/
 * 消费之前注册的erureka client
 * 需要利用之前的test-eureka-server test-erreka-client
 * eureka 客户端 @EnableEurekaClient 开启注册
 * spring.application.name=test-eureka-client  注册进eureka的名字
 * eureka.client.service-url.defaultZone=http://localhost:1001/eureka/ eureka服务端的地址
 */

@EnableEurekaClient
@SpringBootApplication
public class TestEurekaClientConsumerApplication {

	/**
	 * 用于发起rest请求 用于消费别的url
	 * @return 创建bean
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(TestEurekaClientConsumerApplication.class, args);
	}
}
