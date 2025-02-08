package com.vignesh.main;

import com.vignesh.configuration.AppConfiguration;
import com.vignesh.springbean.SeasonFinder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        SeasonFinder seasonFinderBean =  applicationContext.getBean("seasonfinder", SeasonFinder.class);
        System.out.println(seasonFinderBean.getSeason());
    }
}
