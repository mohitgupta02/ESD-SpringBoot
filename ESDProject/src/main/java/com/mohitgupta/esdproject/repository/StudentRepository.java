package com.mohitgupta.esdproject.repository;

import com.mohitgupta.esdproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s JOIN FETCH s.specialisation JOIN FETCH s.domain")
    List<Student> findAllWithDetails();
}
