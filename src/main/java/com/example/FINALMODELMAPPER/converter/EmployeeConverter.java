package com.example.FINALMODELMAPPER.converter;

import com.example.FINALMODELMAPPER.dto.EmployeeDto;
import com.example.FINALMODELMAPPER.dto.EmployeeResponceDto;
import com.example.FINALMODELMAPPER.model.Employee;

public interface EmployeeConverter {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    EmployeeResponceDto employeeToEmployeeResponceDto (Employee employee);
}
