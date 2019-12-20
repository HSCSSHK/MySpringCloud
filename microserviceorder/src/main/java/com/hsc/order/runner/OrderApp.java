package com.hsc.order.runner;

/**
 * @author hsc
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication//申明这是一个Spring Boot项目
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients(basePackages ="com.hsc.order.feign")
@ComponentScan(basePackages = {"com.hsc.order.controller", "com.hsc.order.service", "com.hsc.order.properties", "com.hsc.order.fallback"})//手动指定bean扫描范围
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

    /**
     * 向Spring容器中定义RestTemplate对象
     * @return
     */
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
