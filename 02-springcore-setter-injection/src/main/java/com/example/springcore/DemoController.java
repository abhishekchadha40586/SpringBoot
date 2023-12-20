package com.example.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //private field for dependency
    private Coach myCoach;

    //setter for injection, due to autowired automatically picks up cricket coach
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach=theCoach;
    }
    @GetMapping("/workout")
    public String getWorkout(){
        return myCoach.getDailyWorkout();
    }
}
