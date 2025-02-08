package com.vignesh.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentDetails {

    @Autowired
    private Environment environment;

    public String getEnvironmentDetails() {
        return "Configured Properties file details: "+
                "\nPerson Name: "+environment.getProperty("person.name")+
                "\nPerson Age: "+environment.getProperty("person.age")+
                "\nPerson Address: "+environment.getProperty("person.address")+
                "\nPerson Phone: "+environment.getProperty("person.phone")+
                "\n Operating System details: "+
                "\n OS Name: "+environment.getProperty("os.name")+
                "\n OS version: "+environment.getProperty("os.version")+
                "\n Path details: "+environment.getProperty("Path");
    }

}
