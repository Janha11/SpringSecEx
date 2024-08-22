package com.example.SpringSecEx.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.SpringSecEx.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController

public class StudentController {

    private final List<Student> students;

    public StudentController() {
       students = new ArrayList<>(Arrays.asList(
            new Student(1, "Navin", 80),
            new Student(2, "Janha", 90)
        ));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }
    
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        
        return (CsrfToken) request.getAttribute("_csrf");
    }
    
    @PostMapping("/students")
    public Student addStudents(
    		@RequestBody Student student) {
         students.add(student);
         return student;
    }
    
}
