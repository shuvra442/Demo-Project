package com.example.FINALMODELMAPPER.converter;

import com.example.FINALMODELMAPPER.dto.DepartmentDto;
import com.example.FINALMODELMAPPER.dto.DepartmentResponceDto;
import com.example.FINALMODELMAPPER.model.Department;

public interface DepartmentConverter {

     Department departmentDtoTodepartment(DepartmentDto departmentDto);

     DepartmentResponceDto departmentTodepartmentResponceDto(Department department);
}
