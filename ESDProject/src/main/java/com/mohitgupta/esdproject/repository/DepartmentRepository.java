package com.mohitgupta.academiaesd.repository;

import com.mohitgupta.academiaesd.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
