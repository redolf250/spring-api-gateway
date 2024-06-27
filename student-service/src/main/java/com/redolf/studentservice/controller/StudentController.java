package com.redolf.studentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.redolf.studentservice.utils.StudentUtils.getStudentList;

@RestController
//@RequestMapping("/api/v1/student-service")
public class StudentController {
    @GetMapping("/students")
    private ResponseEntity<?> getStudent(){
        return new ResponseEntity<>(getStudentList(), HttpStatus.OK);
    }
}
