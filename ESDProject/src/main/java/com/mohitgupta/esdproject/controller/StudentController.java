package com.mohitgupta.esdproject.controller;

import com.mohitgupta.esdproject.entity.Student;
import com.mohitgupta.esdproject.repository.StudentRepository;
import com.mohitgupta.esdproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    Student newStudent(@RequestBody Student newStudent){
        return studentRepository.save(newStudent);
    }

    @GetMapping("/students")
    public List<Student> getAllStudentsWithDetails() {
        return studentService.getAllStudentsWithDetails();
    }
}
