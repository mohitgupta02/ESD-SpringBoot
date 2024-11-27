package com.mohitgupta.esdproject.repository;

import com.mohitgupta.esdproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee findByEmail(String email);

    Optional<Employee> findByEmailAndPassword(String email,String password);
}
