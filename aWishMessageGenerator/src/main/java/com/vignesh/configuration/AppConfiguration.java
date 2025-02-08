package com.vignesh.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages = "com.vignesh.springbean")
public class AppConfiguration {

    @Bean(name = "ldt")
    public LocalDateTime createDateTime() {
        return LocalDateTime.now();
    }
}
