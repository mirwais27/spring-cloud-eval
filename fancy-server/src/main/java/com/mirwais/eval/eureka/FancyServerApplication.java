package com.mirwais.eval.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
@EnableEurekaClient
@SpringBootApplication
public class FancyServerApplication {

    @RequestMapping("/")
    public String home() {
        System.out.println("This method was called now!");
        return "Hello World Mirwais!";
    }

    public static void main(String[] args) {
        SpringApplication.run(FancyServerApplication.class, args);
    }
}
