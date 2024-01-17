package com.example.validation.controller;

import com.example.validation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestController {

//    InitBinder is a preprocessor that runs before the requests reach the controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        // a method that trims white spaces
        StringTrimmerEditor trimmer=new StringTrimmerEditor(true);
        // register the trimmer to the dataBinder preprocess every String form data
        dataBinder.registerCustomEditor(String.class,trimmer);
    }
    @GetMapping("/form")
    public String showForm(Model theModel){
        Customer customer=new Customer();
        theModel.addAttribute("customer", customer);
        return "/form";
    }

//    Valid annotation performs validation on basis of rules defines in Customer object and applies them on the customer model recieved from the view
//    BindingResult contains result of the validation
    @PostMapping("/processform")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
        if(theBindingResult.hasErrors())
            return "/form";
        else
            return "/result";
    }
}
