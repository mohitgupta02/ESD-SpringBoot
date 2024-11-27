package com.mohitgupta.esdproject.repository;

import com.mohitgupta.esdproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
