package com.example.inputdatabinding.controller;

import com.example.inputdatabinding.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RestController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${ops}")
    private List<String> os;

    @GetMapping("/showform")
    public String showForm(Model theModel){
        //create student obj and add it as a model attibute
        Student theStudent=new Student("AA","CC");
        theModel.addAttribute("student",theStudent);
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages",languages);
        theModel.addAttribute("os",os);
        return "/showform";
    }

//    Form returns an object of type Student
//    So ModelAttribute binds the student in form to theStudent in controller
    @PostMapping("/processform")
    public String resultForm(@ModelAttribute("student") Student theStudent){
        return "/confirmation";
    }
}
