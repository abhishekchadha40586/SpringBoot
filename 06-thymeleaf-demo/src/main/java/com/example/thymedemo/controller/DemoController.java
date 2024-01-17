package com.example.thymedemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        //These are passed as variables to be used in helloworld.html
        theModel.addAttribute("theDate",new java.util.Date());
//        This is going to look for /src/main/resources/templates/helloworld.html due to Thymeleaf
        return "helloworld";
    }

    // create mapping to model from form data and display it on page
    @GetMapping("/upper")
    public String toUpper(HttpServletRequest httpServlet, Model theModel){
        String name=httpServlet.getParameter("studentName");
        name=name.toUpperCase();
        name="Yo "+name;
        theModel.addAttribute("message",name);
        return "/upper";
    }

    //similar to the one above where param is bound to model
//    However in here RequestParam is used to bind in controller params
    @GetMapping("/upperv2")
    public String toUpperv2(@RequestParam("studentName") String name, Model theModel){
        name=name.toUpperCase();
        name="Yoooo "+name;
        theModel.addAttribute("message",name);
        return "/upper";
    }
}
