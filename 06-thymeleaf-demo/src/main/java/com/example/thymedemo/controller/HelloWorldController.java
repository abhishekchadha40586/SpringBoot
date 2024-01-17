package com.example.thymedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    // show intiial form
    @GetMapping("/showform")
    public String showForm(){
        return "/showform";
    }
    // process form
    @GetMapping("/resultform")
    public String resultForm(){
        return "/resultform";
    }
}
