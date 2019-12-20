package com.hsc.item.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.hsc.item.controller","com.hsc.item.service","com.hsc.item.config"})
public class ItemApp {
    public static void main(String[] args) {
        SpringApplication.run(ItemApp.class, args);
    }
}
