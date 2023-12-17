package com.example.firstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontroller {
    @Value("${coach.name}")
    private String coachname;
    @GetMapping("/")
    public String Hello(){
        return "Hello 23 "+coachname;
    }

    @GetMapping("/workout")
    public String dailyWorkout(){
        return "Burn";
    }
}
