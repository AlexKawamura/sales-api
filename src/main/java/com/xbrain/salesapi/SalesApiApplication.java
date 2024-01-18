package com.xbrain.salesapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SalesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesApiApplication.class, args);
    }

}
