package com.example.FINALMODELMAPPER.converter.impl;

import com.example.FINALMODELMAPPER.converter.EmployeeConverter;
import com.example.FINALMODELMAPPER.dto.EmployeeDto;
import com.example.FINALMODELMAPPER.dto.EmployeeResponceDto;
import com.example.FINALMODELMAPPER.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverterImpl implements EmployeeConverter {
    public final ModelMapper modelMapper;

    public EmployeeConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto)
    {
        return modelMapper.map(employeeDto, Employee.class);
    }
    @Override
    public EmployeeResponceDto employeeToEmployeeResponceDto(Employee employee){
        return modelMapper.map(employee, EmployeeResponceDto.class);
    }
}
