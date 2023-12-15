package com.example.firstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restcontroller {
    @GetMapping("/")
    public String Hello(){
        return "Hello World";
    }
}
