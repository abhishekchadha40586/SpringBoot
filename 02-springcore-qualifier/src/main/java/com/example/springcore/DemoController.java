package com.example.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //private field for dependency
    private Coach myCoach;
    private Coach secondCoach;
    // setter has precedence if both are used on the same object
    @Autowired
    public void setCoach(@Qualifier("swimCoach")Coach theCoach, @Qualifier("footballCoach")Coach heCoach){
        myCoach=theCoach;
        secondCoach=heCoach;
    }
//    @Autowired
//    public DemoController(@Qualifier("cricketCoach")Coach theCoach){
//        secondCoach=theCoach;
//    }
    @GetMapping("/workout")
    public String getWorkout(){
        return myCoach.getDailyWorkout()+" "+secondCoach.getDailyWorkout();
    }
}
