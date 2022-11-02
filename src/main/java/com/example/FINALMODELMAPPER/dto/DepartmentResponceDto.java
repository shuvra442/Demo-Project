package com.example.FINALMODELMAPPER.dto;

public class DepartmentResponceDto {
    private int id;
    private String Dname;
    private String Dlocation;


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
}
