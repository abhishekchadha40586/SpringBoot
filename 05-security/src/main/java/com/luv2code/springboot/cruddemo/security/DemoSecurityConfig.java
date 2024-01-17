package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// for bcrypt, Spring security automatically converts the user password to bcrypt and compare it with the DB bcrypt password
// no addn. coding req
// bcrypt is 1 way algo only encrypts, does not decrypt
// store with {bcrypt} prefix in db
@Configuration
public class DemoSecurityConfig {
    // store in-memory username password and roles
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john= User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
//        UserDetails mary= User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
//        UserDetails susan= User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();
//        return new InMemoryUserDetailsManager(john,mary,susan);
//    }

    // This will automatically link the users(username, password and enabled) and authorities(username and authority) tables in DB with the userdetailsmanager

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    // use custom configuration tables - members and roles
    // need to let spring config know to use these tables to get data
    // query to retrieve a user by username
    // query to retrieve authority/role by username
    // ? is passed from the login form
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        configure the paths for diff roles
         http.authorizeHttpRequests(configurer->
                 configurer
                            .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
         );
        // enable basic auth
         http.httpBasic(Customizer.withDefaults());
        // diable csrf
         http.csrf(csrf->csrf.disable());
         return http.build();
    }
}
