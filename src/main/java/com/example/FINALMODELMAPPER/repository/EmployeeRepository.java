package com.example.FINALMODELMAPPER.repository;

import com.example.FINALMODELMAPPER.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
