package com.redolf.gateway.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping("/students")
    private ResponseEntity<?> getStudents(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping()
    private ResponseEntity<?> getPayments(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
