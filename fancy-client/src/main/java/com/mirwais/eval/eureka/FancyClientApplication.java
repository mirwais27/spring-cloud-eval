package com.mirwais.eval.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
public class FancyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FancyClientApplication.class, args);
    }
}
