package com.example.FINALMODELMAPPER.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Dname;
    private String Dlocation;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Project>projects;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee>employees;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDlocation() {
        return Dlocation;
    }

    public void setDlocation(String dlocation) {
        Dlocation = dlocation;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
