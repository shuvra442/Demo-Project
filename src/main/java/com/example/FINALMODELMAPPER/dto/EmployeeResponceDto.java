package com.example.FINALMODELMAPPER.dto;

import com.example.FINALMODELMAPPER.model.Address;
import com.example.FINALMODELMAPPER.model.Department;
import com.example.FINALMODELMAPPER.model.Project;

import java.util.List;

public class EmployeeResponceDto {
    private int id;
    private String Ename;
    private String Edob;
    private String Edoj;

    private Address address;
    private Department department;

    private List<Project>projects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEdob() {
        return Edob;
    }

    public void setEdob(String edob) {
        Edob = edob;
    }

    public String getEdoj() {
        return Edoj;
    }

    public void setEdoj(String edoj) {
        Edoj = edoj;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
