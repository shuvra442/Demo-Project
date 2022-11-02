package com.example.FINALMODELMAPPER.controller;

import com.example.FINALMODELMAPPER.dto.EmployeeDto;
import com.example.FINALMODELMAPPER.dto.EmployeeResponceDto;
import com.example.FINALMODELMAPPER.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeResponceDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.addEmployee(employeeDto);
    }

    @PutMapping("/employees/{id}")
    public void updateEmp(@RequestBody EmployeeDto employee, @PathVariable int id) {
        employeeService.updateEmp(employee, id);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmp(@PathVariable int id) {
        employeeService.deleteEmp(id);
    }
}
