package com.vignesh.springbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("wmg")
public class WishMessageGenerator {

    @Autowired
    private LocalDateTime localDateTime;
    //int hour = localDateTime.getHour(); //this raises NullPointerException because localDateTime is not wired yet!

    //Spring first instantiates WishMessageGenerator
    //Initialises all the fields
    //And then, injects the dependencies
    private int hour;

    public String generateWishMessage() {
        hour = localDateTime.getHour();

        if(hour < 12) {
            return "Good Morning!";
        }
        else if (hour < 16) {
            return "Good Afternoon!";
        }
        else if (hour < 18) {
            return "Good Evening!";
        }
        else {
            return "Good Night!";
        }
    }
}
