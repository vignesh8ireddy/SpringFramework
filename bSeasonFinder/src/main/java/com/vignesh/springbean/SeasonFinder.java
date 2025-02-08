package com.vignesh.springbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("seasonfinder")
@Scope("prototype")
public class SeasonFinder {


/* Field Injection
    @Autowired
    private LocalDateTime localDateTime;
*/
    private LocalDateTime localDateTime;
    private int month;

/* Constructor Injection
    @Autowired
    public SeasonFinder(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
*/

/* Setter Injection
    @Autowired
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
*/

    //Arbitrary method injection
    @Autowired
    public void localDateTimeInjection(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getSeason() {
        month = localDateTime.getMonthValue();
        if(month >= 3 && month <= 5) {
            return "Spring: Warmer, flowers bloom!";
        }
        else if(month >=6 && month <=8) {
            return "Summer: Hot, longest Days, outdoor fun!";
        }
        else if(month >=9 && month <=11 ) {
            return "Fall: Cooler, leaves change, harvest time!";
        }
        else {
            return "Winter: Cold, snow in some places, shortest days!";
        }
    }
}
