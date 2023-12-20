package com.example.springcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// creates cricketcoach as a bean use @Primary to make this the default one,
// @Lazy for lazy initialization
// @Scope to define whether only singleton object to be created or new one for each initialization
@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins!!!";
    }

    //Bean lifecycle methods to determine any extra functionality to run after a bean is created and before it is destroyed
    @PostConstruct
    public void start(){
        System.out.println("Startup");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Stop");
    }
}
