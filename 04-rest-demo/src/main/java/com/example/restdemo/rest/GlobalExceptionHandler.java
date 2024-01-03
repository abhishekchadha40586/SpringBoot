package com.example.restdemo.rest;

import com.example.restdemo.entity.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// This is reusable across controllers and acts as a layer on top of all controller
// All req and response pass through it so, req filtering and reusable error handling can be placed here
// logic for handlers remain exactly as for indv
@ControllerAdvice
public class GlobalExceptionHandler {

    //    parameter tells which type of exception this handler handles
//    ResponseEntity determines what type of response to send back
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // error is the body of the ResponseEntity while HttpStatus.NOT_FOUND is status
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // handle all generic exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // error is the body of the ResponseEntity while HttpStatus.NOT_FOUND is status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
