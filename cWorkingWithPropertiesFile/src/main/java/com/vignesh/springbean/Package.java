package com.vignesh.springbean;

import com.vignesh.util.ICourier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="app.properties")//searches in src/main/resources/app.properties
public class Package {

    @Autowired
    @Qualifier("fedex")
    private ICourier courier;

    @Value("${person.name}")
    private String receiverName;
    @Value("${person.age}")
    private Integer receiverAge;
    @Value("${person.address}")
    private String receiverAddress;
    @Value("${person.phone}")
    private Long receiverPhone;

    public String getPackageDetails() {
        return "Package is sent through "+courier.info()+
                ".\n Receiver Name: "+receiverName+
                ".\n Receiver Age: "+receiverAge+
                ".\n Receiver Address: "+receiverAddress+
                ".\n receiver Phone: "+receiverPhone;
    }
}
