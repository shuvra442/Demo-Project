package com.example.FINALMODELMAPPER.dto;

import com.example.FINALMODELMAPPER.model.Department;

public class ProjectResponceDto {
    private int id;
    private String pname;
    private String ptype;

   private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
