package com.vignesh.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Ups implements ICourier {
    private String name;

    @PostConstruct
    public void init() {
        name = "UPS";
    }

    @Override
    public String info() {
        return name;
    }

    @PreDestroy
    public void destroy() {
        name = null;
    }
}
