package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 用于消费test-eureka-client 提供的接口
 */
@RestController
public class DcController {

  private LoadBalancerClient loadBalancerClient;
  private final RestTemplate restTemplate;

  @GetMapping("/consumer")
  public String dc(){
    ServiceInstance serviceInstance = loadBalancerClient.choose("test-eureka-client");
    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
    System.out.println(url);
    return restTemplate.getForObject(url,String.class);
  }

  @Autowired
  public DcController(LoadBalancerClient loadBalancerClient, RestTemplate restTemplate) {
    this.loadBalancerClient = loadBalancerClient;
    this.restTemplate = restTemplate;
  }
}
