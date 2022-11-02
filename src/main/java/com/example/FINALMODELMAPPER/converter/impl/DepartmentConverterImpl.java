package com.example.FINALMODELMAPPER.converter.impl;

import com.example.FINALMODELMAPPER.converter.DepartmentConverter;
import com.example.FINALMODELMAPPER.dto.DepartmentDto;
import com.example.FINALMODELMAPPER.dto.DepartmentResponceDto;
import com.example.FINALMODELMAPPER.model.Department;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverterImpl implements DepartmentConverter {
    public final ModelMapper modelMapper;

    public DepartmentConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Department departmentDtoTodepartment(DepartmentDto departmentDto)
    {
        return modelMapper.map(departmentDto, Department.class);
    }

    @Override
    public DepartmentResponceDto departmentTodepartmentResponceDto(Department department) {
        return modelMapper.map(department, DepartmentResponceDto.class);
    }
}
