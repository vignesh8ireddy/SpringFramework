package com.vignesh.main;

import com.vignesh.configuration.AppConfiguration;
import com.vignesh.springbean.WishMessageGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        WishMessageGenerator wishMessageBean = applicationContext.getBean("wmg", WishMessageGenerator.class);
        System.out.println(wishMessageBean.generateWishMessage());
    }
}
