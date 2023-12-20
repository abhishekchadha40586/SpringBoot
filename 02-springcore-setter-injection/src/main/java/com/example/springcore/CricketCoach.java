package com.example.springcore;

import org.springframework.stereotype.Component;

// creates cricketcoach as a bean
@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins!!!";
    }
}
