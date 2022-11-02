package com.example.FINALMODELMAPPER.service;

import com.example.FINALMODELMAPPER.converter.DepartmentConverter;
import com.example.FINALMODELMAPPER.dto.DepartmentDto;
import com.example.FINALMODELMAPPER.dto.DepartmentResponceDto;
import com.example.FINALMODELMAPPER.model.Department;
import com.example.FINALMODELMAPPER.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentConverter departmentConverter;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    public List<DepartmentResponceDto> getAllDepartment(){
        List<Department>departmentList = departmentRepository.findAll();
        return departmentList.stream().map(departmentConverter :: departmentTodepartmentResponceDto).collect(Collectors.toList());
    }

    public void addDepartment(DepartmentDto departmentDto){
        Department department= departmentConverter.departmentDtoTodepartment(departmentDto);
        departmentRepository.save(department);
    }

    public void updateDept(DepartmentDto department, int id){

        Department data = departmentRepository.findById(id).orElse(null);
        assert data != null;
        data.setDname(department.getDname());
        data.setDlocation(department.getDlocation());

        departmentRepository.save(data);
    }

    public  void deleteDept(int id){
        departmentRepository.deleteById(id);
    }


}
