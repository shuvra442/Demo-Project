package com.example.FINALMODELMAPPER.dto;

import com.example.FINALMODELMAPPER.model.Address;
import com.example.FINALMODELMAPPER.model.Department;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

public class EmployeeDto {
    private int id;
    private String Ename;
    private String Edob;
    private String Edoj;

    private Address address;

    private int department_id;

    private List<TestDto>project_list;



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

//    public Address getAddress_id() {
//        return address_id;
//    }
//
//    public void setAddress_id(Address address_id) {
//        this.address_id = address_id;
//    }

        public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public List<TestDto> getProject_list() {
        return project_list;
    }

    public void setProject_list(List<TestDto> project_list) {
        this.project_list = project_list;
    }
}
