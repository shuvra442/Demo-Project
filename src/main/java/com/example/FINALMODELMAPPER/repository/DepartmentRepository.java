package com.example.FINALMODELMAPPER.repository;

import com.example.FINALMODELMAPPER.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
