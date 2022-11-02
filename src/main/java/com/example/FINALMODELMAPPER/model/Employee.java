package com.example.FINALMODELMAPPER.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private int id;
      private String Ename;
      private String Edob;
      private String Edoj;

      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name="address_id")
      private Address address;

      @ManyToOne
      @JoinColumn(name = "department_id")
      private Department department;

      @ManyToMany()
      @JoinTable(name = "EmployeeProject", joinColumns={@JoinColumn(name = "Employee_id",referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "Project_id")})
      private List<Project> projects=new ArrayList<>();

      @JsonIgnore
      @OneToOne(mappedBy = "employee")
      private Image image;


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

      public Image getImage() {
            return image;
      }
      public void setImage(Image image) {
            this.image = image;
      }
}
