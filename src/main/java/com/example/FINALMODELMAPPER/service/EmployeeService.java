package com.example.FINALMODELMAPPER.service;

import com.example.FINALMODELMAPPER.converter.EmployeeConverter;
import com.example.FINALMODELMAPPER.dto.EmployeeDto;
import com.example.FINALMODELMAPPER.dto.EmployeeResponceDto;
import com.example.FINALMODELMAPPER.dto.TestDto;
import com.example.FINALMODELMAPPER.model.Address;
import com.example.FINALMODELMAPPER.model.Department;
import com.example.FINALMODELMAPPER.model.Employee;
import com.example.FINALMODELMAPPER.model.Project;
import com.example.FINALMODELMAPPER.repository.AddressRepository;
import com.example.FINALMODELMAPPER.repository.DepartmentRepository;
import com.example.FINALMODELMAPPER.repository.EmployeeRepository;
import com.example.FINALMODELMAPPER.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;
    private EmployeeConverter employeeConverter;

    private AddressRepository addressRepository;

    public EmployeeService(DepartmentRepository departmentRepository,
                           EmployeeRepository employeeRepository,
                           ProjectRepository projectRepository,
                           EmployeeConverter employeeConverter,
                           AddressRepository addressRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.employeeConverter = employeeConverter;
        this.addressRepository=addressRepository;
    }

    public List<EmployeeResponceDto> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employeeConverter :: employeeToEmployeeResponceDto)
                .collect(Collectors.toList());
    }

    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeConverter.employeeDtoToEmployee(employeeDto);

        Optional<Department> dept = departmentRepository.findById(employeeDto.getDepartment_id());
        if(dept.isEmpty())
            System.out.println("No department joined!!!");
        employee.setDepartment(dept.get());

//        Optional<Address>add=addressRepository.findById(employeeDto.getAddress_id());
//        if(add.isEmpty())
//            System.out.println("No department joined!!!");
//        employee.setAddress(add.get());


        List<TestDto> projectList = employeeDto.getProject_list();
        for(TestDto project : projectList){
            Optional<Project> optionalProject = projectRepository.findById(project.getProject_id());
            employee.getProjects().add(optionalProject.get());
        }
        employeeRepository.save(employee);
    }


    public void updateEmp(EmployeeDto employee, int id){
        Optional<Employee> This=employeeRepository.findById(id);
        if(This.isEmpty())
            System.out.println("Element not  found");

        Employee data=This.get();
//        data.setE_name(employee.getE_name());
//        data.seteDob(employee.getE_dob());
//        data.setE_doj(employee.getE_doj());
         data.setEname(employee.getEname());
         data.setEdob(employee.getEdob());
         data.setEdoj(employee.getEdoj());
         data.setAddress(employee.getAddress());


        data.setDepartment(departmentRepository.findById(employee.getDepartment_id()).get());

        List<Project> emptyList = new ArrayList<>();
        data.setProjects(emptyList);
        List<TestDto> getProjects = employee.getProject_list();
        for (TestDto project : getProjects){
            Optional<Project> optionalProject = projectRepository.findById(project.getProject_id());
            data.getProjects().add(optionalProject.get());
        }

        employeeRepository.save(data);
    }

    public void deleteEmp(int id){
        employeeRepository.deleteById(id);
    }
}
