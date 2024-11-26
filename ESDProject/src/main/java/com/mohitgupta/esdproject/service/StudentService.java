package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.entity.Student;
import com.mohitgupta.esdproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudentsWithDetails() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }
}
