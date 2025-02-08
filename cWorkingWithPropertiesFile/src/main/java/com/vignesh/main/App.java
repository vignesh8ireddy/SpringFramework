package com.vignesh.main;

import com.vignesh.configuration.AppConfiguration;
import com.vignesh.environment.EnvironmentDetails;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.vignesh.springbean.Package;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Package packageBean = applicationContext.getBean(Package.class);
        System.out.println(packageBean.getPackageDetails());
        EnvironmentDetails envBean = applicationContext.getBean(EnvironmentDetails.class);
        System.out.println("========================================Environment Info\n");
        System.out.println(envBean.getEnvironmentDetails());
    }
}
