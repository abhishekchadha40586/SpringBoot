package com.example.springcore.config;

import com.example.springcore.Coach;
import com.example.springcore.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//use @Bean inside @Configuration to create a customised bean
@Configuration
public class SportConfig {
//    give custome bean id as @Bean("idname") and use it in qualifier
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
