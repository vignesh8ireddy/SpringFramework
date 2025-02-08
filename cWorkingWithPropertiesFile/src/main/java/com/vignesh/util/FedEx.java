package com.vignesh.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class FedEx implements ICourier {
    private String name;

    @PostConstruct
    public void init() {
        name = "FedEx";
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
