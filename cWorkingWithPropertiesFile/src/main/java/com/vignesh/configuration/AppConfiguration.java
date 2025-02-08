package com.vignesh.configuration;

import com.vignesh.util.FedEx;
import com.vignesh.util.Ups;
import com.vignesh.util.ICourier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.vignesh")
public class AppConfiguration {

    @Bean("ups")
    public ICourier createUps() {
        return new Ups();
    }

    @Bean("fedex")
    public ICourier createFedEx() {
        return new FedEx();
    }
}
