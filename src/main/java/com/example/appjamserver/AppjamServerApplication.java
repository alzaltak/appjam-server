package com.example.appjamserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AppjamServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppjamServerApplication.class, args);
    }

}
