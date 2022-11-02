package com.example.FINALMODELMAPPER.controller;

import com.example.FINALMODELMAPPER.dto.DepartmentDto;
import com.example.FINALMODELMAPPER.dto.DepartmentResponceDto;
import com.example.FINALMODELMAPPER.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<DepartmentResponceDto> getAllDepartments(){
        return departmentService.getAllDepartment();
    }

    @PostMapping("/departments")
    public void addDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.addDepartment(departmentDto);
    }

    @PutMapping("/departments/{id}")
    public void updateDepartment(@RequestBody DepartmentDto department, @PathVariable int id) {
        departmentService.updateDept(department, id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDept(@PathVariable int id) {
        departmentService.deleteDept(id);
    }
}
