package com.example.springcore;

import org.springframework.stereotype.Component;

//missing @Component, because we are manually creating it as a bean in /config/SportConfig
//Useful when req to take third party classes and expose them as a bean
public class SwimCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Swim";
    }
}
