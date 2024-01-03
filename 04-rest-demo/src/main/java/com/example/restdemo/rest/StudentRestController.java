package com.example.restdemo.rest;

import com.example.restdemo.entity.Student;
import com.example.restdemo.entity.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    public List<Student> students;
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Abhishek","Chadha"));
        students.add(new Student("Aarav","Chadha"));
    }

    //get all students
    @GetMapping("/student")
    public List<Student> getStudents(){
        return students;
    }

    // get indv. student on basis of id
    @GetMapping("/student/{studentId}")
    public Student getIndvStudent(@PathVariable int studentId){

        // if student not found throw an exception of StudentNotFoundException class, whatever message is passed from here will get stored through constructor
        if(studentId>=students.size()||studentId<0){
            throw new StudentNotFoundException("ID not found - "+studentId);
        }

        return students.get(studentId);
    }

}
